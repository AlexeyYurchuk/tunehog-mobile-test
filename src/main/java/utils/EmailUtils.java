package utils;

import javax.mail.*;
import framework.Loggable;
import framework.dataobjects.UserObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils implements Loggable {

    private String mailTitle;
    private String urlPattern;
    private String url;
    private UserObject user;
    private boolean textIsHtml;
    private Date receivedDate;

    public EmailUtils(UserObject user, String mailTitle, String urlPattern) {
        this.user = user;
        this.mailTitle = mailTitle;
        this.urlPattern = urlPattern;
        this.textIsHtml = false;
        WaitUtils.waitForResult(2);
        parseLinkFromEmail();
    }

    public static Date getRestorePasswordEmailDate(UserObject user) {
        LOG_STEP.info("System fetches the date of Restore Password letter through the POP3 protocol");
        return  new EmailUtils(user, "Reset password instructions", "a href=\"(https://restapi.+?)\".+").getReceivedDate();
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    private void parseLinkFromEmail() {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props, null);
        Store store = null;
        try {
            store = session.getStore("imaps");
            store.connect("smtp.gmail.com", user.getEmail(), user.getPasswordEmail());
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
            int startMessage = messageCount;
            int endMessage = messageCount;
            if (messageCount < 5) {
                startMessage = 0;
                endMessage = messageCount - 1;
            }
            Message[] messages = inbox.getMessages(startMessage, endMessage);

            parseMessages(messages);
            inbox.close(true);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void parseMessages(Message[] messages) {
        try {
            for (Message message : messages) {
                String body = "";
                if (!message.getSubject().equals(mailTitle)) {
                    continue;
                }
                Object content = message.getContent();
                if (content instanceof Multipart) {
                    Multipart parts = (Multipart) message.getContent();
                    Part part = null;
                    for (int i = 0; i < parts.getCount(); i++) {
                        part = parts.getBodyPart(i);
                        body += getText(part);
                    }
                } else {
                    body = (String) message.getContent();
                }
                //System.out.println(body);
                Pattern myPattern = Pattern.compile(urlPattern);
                Matcher m = myPattern.matcher(body);
                while (m.find()) {
                    url = m.group(1);
                }
                receivedDate = message.getReceivedDate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getText(Part p) throws MessagingException, IOException {
        if (p.isMimeType("text/*")) {
            String s = (String) p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }
        if (p.isMimeType("multipart/alternative")) {
            Multipart mp = (Multipart) p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null) {
                        text = getText(bp);
                    }
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null) {
                        return s;
                    }
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null) {
                    return s;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param dateOne
     * @param dateTwo
     * @return diff between two date in minutes
     */
    public static long getTimeDiff(Date dateOne, Date dateTwo) {
        long diff = 0;
        long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
        diff =  TimeUnit.MILLISECONDS.toHours(timeDiff) * 60 + // diff hours
                TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)); // diff minutes
        return diff;
    }
}
