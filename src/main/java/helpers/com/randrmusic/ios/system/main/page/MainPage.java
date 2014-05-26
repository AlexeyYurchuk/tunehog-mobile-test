package helpers.com.randrmusic.ios.system.main.page;

import framework.Loggable;
import helpers.BasePage;
import helpers.com.randrmusic.ios.system.main.data.MainPageDataProviders;
import helpers.com.randrmusic.ios.system.settings.page.SettingsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.WaitUtils;

/**
 * Created by admin on 26.05.14.
 * This class represents main iOS activity
 */
public class MainPage extends BasePage implements Loggable, MainPageDataProviders {

    @FindBy(how = How.NAME, using = MainPageDataProviders.SettingsIcon)
    WebElement settingsIcon;

    @FindBy(how = How.NAME, using = MainPageDataProviders.AstroIcon)
    WebElement astroIcon;


    public SettingsPage openSettings() {
        LOG_STEP.info("Open Settings app");
        WaitUtils.sleep(2);
        settingsIcon.click();
        LOG_STEP.info("settings icon was clicked");
        return new SettingsPage();
    }
}
