package helpers.com.randrmusic.android.discovery.login.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.android.discovery.login.data.SignInPageDataProviders;
import helpers.com.randrmusic.android.discovery.menu.page.MenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.WaitUtils;

public class SignInPage extends BasePage implements Loggable,SignInPageDataProviders {

    private static final int SLEEP_TIME_IN_SECONDS = 3;

    @FindBy(how = How.ID, using = SignInPageDataProviders.emailField)
    private WebElement emailField;
    @FindBy(how = How.ID, using = SignInPageDataProviders.passwordField)
    private WebElement passwordField;
    @FindBy(how = How.ID, using = SignInPageDataProviders.signInButton)
    private WebElement signInButton;

    public MenuPage signIn(UserObject user) {
        WaitUtils.waitForResult(SLEEP_TIME_IN_SECONDS);
        LOG_STEP.info("User fills email field");
        emailField.sendKeys(user.getEmail());
        LOG_STEP.info("User fills 'Password' field");
        passwordField.sendKeys(user.getPassword());
        LOG_STEP.info("User clicks 'Login' button");
        signInButton.click();
        WaitUtils.sleep(3);
        return new MenuPage();
    }

    public void checkUnLoggedUser() {
        LOG_STEP.info("System verifies if user is no logged");
        Assert.assertTrue(emailField.isDisplayed() && passwordField.isDisplayed());
    }
}
