package framework.dataobjects;

import framework.DataStore;

import java.util.Properties;

/**
 * Created by admin on 20.05.14.
 */
public class UserObject {

    private Properties properties;

    private String email;
    private String username;
    private String password;
    private String passwordEmail;

    public void setFromProperties() {
        properties = DataStore.getInstance().getProperties();
        setEmail(properties.getProperty("emailArtemT"));
        setPassword(properties.getProperty("passwordArtemT"));
        setUsername(properties.getProperty("usernameArtemT"));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordEmail() {
        return passwordEmail;
    }

    public void setPasswordEmail(String passwordEmail) {
        this.passwordEmail = passwordEmail;
    }

    public void setFromPropertiesAccount() {
        properties = DataStore.getInstance().getProperties();
        setEmail(properties.getProperty("user_account"));
        setUsername(properties.getProperty("username_account"));
        setPassword(properties.getProperty("password_account"));
        setPasswordEmail(properties.getProperty("password_email_account"));
    }

    public void setFromPropertiesAstroSubscribed() {
        properties = DataStore.getInstance().getProperties();
        setEmail(properties.getProperty("astro_subscribed_user"));
        setUsername(properties.getProperty("astro_subscribed_username"));
        setPassword(properties.getProperty("astro_subscribed_password"));
     }

    public void setFromPropertiesAstroNoSubscribed() {
        properties = DataStore.getInstance().getProperties();
        setEmail(properties.getProperty("astro_nosubscribed_user"));
        setUsername(properties.getProperty("astro_nosubscribed_username"));
        setPassword(properties.getProperty("astro_nosubscribed_password"));
    }
}
