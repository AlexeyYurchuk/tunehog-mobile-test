package helpers.com.randrmusic.ios.system.settings.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.ios.system.settings.data.SettingsPageDataProviders;
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
    @FindBy(how = How.NAME, using = SettingsPageDataProviders.FacebookSignIn)
    WebElement facebookSignIn;

    public void signIn(UserObject user) {
        LOG_STEP.info("User fills email field");
        facebookUserName.sendKeys(user.getEmail());
        LOG_STEP.info("User fills password field");
        facebookPassword.sendKeys(user.getPassword());
        LOG_STEP.info("User clicks on Sign In button");
        facebookSignIn.click();
        WaitUtils.waitForResult(5);
    }
}
