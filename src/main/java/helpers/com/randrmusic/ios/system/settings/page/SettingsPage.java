package helpers.com.randrmusic.ios.system.settings.page;

import framework.Loggable;
import helpers.BasePage;
import helpers.com.randrmusic.ios.system.settings.data.SettingsPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by admin on 26.05.14.
 */
public class SettingsPage extends BasePage implements Loggable, SettingsPageDataProviders{

    @FindBy(how = How.NAME, using = SettingsPageDataProviders.FacebookIcon)
    WebElement facebookIcon;


    public FacebookSettingsPage openFacebookSettings() {
        LOG_STEP.info("Open Facebook settings page.");
        facebookIcon.click();
        return new FacebookSettingsPage();
    }
}
