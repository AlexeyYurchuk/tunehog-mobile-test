package helpers.com.randrmusic.ios.astro.choose.page;

import framework.Loggable;
import helpers.BasePage;
import helpers.com.randrmusic.ios.astro.choose.data.ChooseSignPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.WaitUtils;

/**¡
 * Created by admin on 21.05.14.
 */
public class ChooseSignPage extends BasePage implements ChooseSignPageDataProviders, Loggable {

    @FindBy(how = How.NAME, using = ChooseSignPageDataProviders.zodiakPicker)
    private WebElement zodiakPicker;

    public void checkLoggedInUser() {
        WaitUtils.waitForResult(3);
        LOG_STEP.info("System verifies if user is logged in");
        Assert.assertTrue(zodiakPicker.isEnabled(), "Zodiak picker was not displayed"); //TODO: should be change to real action

    }

    public void clickLogout() {
        LOG_STEP.info("User clicks on logout button");
        // TODO: should be changed to real action
    }
}
