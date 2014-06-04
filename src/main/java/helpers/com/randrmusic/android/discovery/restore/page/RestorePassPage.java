package helpers.com.randrmusic.android.discovery.restore.page;

import com.sun.mail.handlers.message_rfc822;
import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.android.discovery.restore.data.RestorePassPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.EmailUtils;
import utils.WaitUtils;

import java.util.Date;

public class RestorePassPage extends BasePage implements Loggable, RestorePassPageDataProviders {

    @FindBy(how = How.ID, using = RestorePassPageDataProviders.emailField)
    private WebElement emailField;
    @FindBy(how = How.ID, using = RestorePassPageDataProviders.restoreButton)
    private WebElement restoreButton;

    public void clickRestore(UserObject user) {
        LOG_STEP.info("User fill 'Email' field with his existing email");
        emailField.sendKeys(user.getEmail());
        WaitUtils.sleep(2);
        LOG_STEP.info("User clicks 'Restore Password' button");
        restoreButton.click();
        WaitUtils.waitForResult(13);
        double timeDiff =  EmailUtils.getTimeDiff(EmailUtils.getRestorePasswordEmailDate(user), new Date());
        Assert.assertEquals(timeDiff, 0.0, 20);
        WaitUtils.waitForResult(5);
    }
}
