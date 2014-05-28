package helpers.com.randrmusic.ios.astro.login.pages;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.ios.astro.choose.page.ChooseSignPage;
import helpers.com.randrmusic.ios.astro.login.data.LoginPagesDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.WaitUtils;

/**
 * Created by admin on 20.05.14.
 */
public class SignInPage extends BasePage implements LoginPagesDataProviders, Loggable {

    private static final int SLEEP_TIME_IN_SECONDS = 3;

    @FindBy(how = How.XPATH, using = LoginPagesDataProviders.EmailSignIn)
    private WebElement email;
    @FindBy(how = How.XPATH, using = LoginPagesDataProviders.PasswordSignIn)
    private WebElement password;
    @FindBy(how = How.NAME, using = LoginPagesDataProviders.SignInButton)
    private WebElement signinButton;

    @FindBy(how = How.NAME, using = LoginPagesDataProviders.SignInFacebook)
    private WebElement signInFacebookButton;
    @FindBy(how = How.XPATH, using = LoginPagesDataProviders.AllowFacebookAccessToProfile)
    private WebElement allowFacebookAccess;

    private void clearFields() {
        email.clear();
        password.clear();
    }

    public ChooseSignPage signIn(UserObject user) {
        WaitUtils.waitForResult(SLEEP_TIME_IN_SECONDS);
        LOG_STEP.info("User fills email field");
        email.sendKeys(user.getEmail());
        LOG_STEP.info("User fills password field");
        password.sendKeys(user.getPassword());
        LOG_STEP.info("User clicks on Login button");
        signinButton.click();
        WaitUtils.waitForResult(5);
        return new ChooseSignPage();
    }

    public void checkUnLoggedUser() {
        LOG_STEP.info("System verifies if user is no logged");
        Assert.assertTrue(email.isDisplayed() && password.isDisplayed());
    }

    public ChooseSignPage signInFacebook() {
        LOG_STEP.info("User click on 'Log with Facebook' button.");
        signInFacebookButton.click();
        allowFacebookAccess.click();
        WaitUtils.waitForResult(2);
        allowFacebookAccess.click();
        WaitUtils.waitForResult(4);
        return new ChooseSignPage();
    }
}
