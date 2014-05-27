package helpers.com.randrmusic.android.discovery.login.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.android.discovery.login.data.SignInPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.WaitUtils;

public class SignInPage extends BasePage implements Loggable,SignInPageDataProviders {

    private static final int SLEEP_TIME_IN_SECONDS = 3;

    @FindBy(how = How.ID, using = SignInPageDataProviders.emailField)
    private WebElement emailField;

    public void signIn(UserObject user) {
        WaitUtils.waitForResult(SLEEP_TIME_IN_SECONDS);
        LOG_STEP.info("User fills email field");
        emailField.sendKeys(user.getEmail());
        LOG_STEP.info("User fills password field");
    }
}
