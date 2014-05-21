package helpers.choose.page;

import helpers.choose.data.ChooseSignPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**¡
 * Created by admin on 21.05.14.
 */
public class ChooseSignPage {

    @FindBy(how = How.NAME, using = ChooseSignPageDataProviders.something)
    private WebElement something;

    public void checkLoggedInUser() {
        Assert.assertTrue(false); //TODO: should be change to real action
    }
}
