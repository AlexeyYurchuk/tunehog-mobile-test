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

    @FindBy(how = How.XPATH, using = ChooseSignPageDataProviders.chooseSign)
    private WebElement chooseSign;

    public void checkLoggedInUser() {
        WaitUtils.waitForResult(3);
        LOG_STEP.info("System verifies if user is logged in");
        Assert.assertTrue(chooseSign.isEnabled(), "Zodiak picker was not displayed");

    }

}
