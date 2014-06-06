package helpers.com.randrmusic.android.discovery.login.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.android.discovery.discovery.page.DiscoveryPage;
import helpers.com.randrmusic.android.discovery.login.data.SignInPageDataProviders;
import helpers.com.randrmusic.android.discovery.menu.page.MenuPage;
import helpers.com.randrmusic.android.discovery.restore.page.RestorePassPage;
import helpers.com.randrmusic.android.discovery.signup.page.SignUpPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.WaitUtils;

import java.util.Random;

public class SignInPage extends BasePage implements Loggable,SignInPageDataProviders {

    private static final int SLEEP_TIME_IN_SECONDS = 3;

    @FindBy(how = How.ID, using = SignInPageDataProviders.emailField)
    private WebElement emailField;
    @FindBy(how = How.ID, using = SignInPageDataProviders.passwordField)
    private WebElement passwordField;
    @FindBy(how = How.ID, using = SignInPageDataProviders.signInButton)
    private WebElement signInButton;
    @FindBy(how = How.ID, using = SignInPageDataProviders.signUpButton)
    private WebElement signUpButton;
    @FindBy(how = How.ID, using = SignInPageDataProviders.restoreButton)
    private WebElement restoreButton;

    public DiscoveryPage signIn(UserObject user) {
        WaitUtils.waitForResult(SLEEP_TIME_IN_SECONDS);
        LOG_STEP.info("User fills email field");
        emailField.sendKeys(user.getEmail());
        LOG_STEP.info("User fills 'Password' field");
        passwordField.sendKeys(user.getPassword());
        LOG_STEP.info("User clicks 'Login' button");
        signInButton.click();
        WaitUtils.waitForResult(7);
        return new DiscoveryPage();
    }

    public void checkUnLoggedUser() {
        WaitUtils.sleep(1);
        LOG_STEP.info("System verifies if user is no logged");
        Assert.assertTrue(emailField.isDisplayed() && passwordField.isDisplayed());
    }

    public void invalidEmailOrPassword(UserObject user) {
        Random random = new Random();
        LOG_STEP.info("User fills 'Email' field with valid value");
        emailField.sendKeys(user.getEmail());
        LOG_STEP.info("User fills 'Password' field with with random password");
        passwordField.sendKeys(user.getPassword().concat(String.valueOf(random.nextInt())));
        LOG_STEP.info("User clicks 'Login' button");
        signInButton.click();
        WaitUtils.waitForResult(3);
    }

    public SignUpPage clickSignUp() {
        LOG_STEP.info("User clicks 'SignUp' button");
        signUpButton.click();
        return new SignUpPage();
    }

    public RestorePassPage clickRestorePass() {
        LOG_STEP.info("User clicks 'Forgot password' button");
        restoreButton.click();
        return new RestorePassPage();
    }
}