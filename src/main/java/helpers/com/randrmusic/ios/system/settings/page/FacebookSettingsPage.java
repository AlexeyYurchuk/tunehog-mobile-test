package helpers.com.randrmusic.ios.system.settings.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.ios.system.settings.data.SettingsPageDataProviders;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.WaitUtils;

/**
 * Created by admin on 26.05.14.
 */
public class FacebookSettingsPage extends BasePage implements Loggable, SettingsPageDataProviders {

    @FindBy(how = How.NAME, using = SettingsPageDataProviders.FacebookUserName)
    WebElement facebookUserName;
    @FindBy(how = How.NAME, using = SettingsPageDataProviders.FacebookPassword)
    WebElement facebookPassword;
    @FindBy(how = How.XPATH, using = SettingsPageDataProviders.FacebookSignIn)
    WebElement facebookSignIn;
    @FindBy(how = How.XPATH, using = SettingsPageDataProviders.FacebookSignInApprove)
    WebElement facebookSignInApprove;
    @FindBy(how =How.NAME, using = SettingsPageDataProviders.FacebooKUserInfo)
    WebElement facebookUserInfo;

    public void signIn(UserObject user) {
        LOG_STEP.info("User fills email field");
        facebookUserName.sendKeys(user.getEmail());
        LOG_STEP.info("User fills password field");
        facebookPassword.sendKeys(user.getPassword());
        LOG_STEP.info("User clicks on Sign In button");
        WaitUtils.waitForResult(17);
        facebookSignIn.click();
        LOG_STEP.info("User approve to sign in");
        facebookSignInApprove.click();
        WaitUtils.waitForResult(5);
    }

    public void checkLoggedInUser() {
        LOG_STEP.info("System checks if user is logged in");
        Assert.assertTrue("User is logged in", facebookUserInfo.isDisplayed());
    }
}
