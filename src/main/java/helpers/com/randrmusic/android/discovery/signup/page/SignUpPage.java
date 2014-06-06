package helpers.com.randrmusic.android.discovery.signup.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.android.discovery.discovery.page.DiscoveryPage;
import helpers.com.randrmusic.android.discovery.signup.data.SignUpPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.WaitUtils;

public class SignUpPage extends BasePage implements SignUpPageDataProviders, Loggable {

    @FindBy(how = How.ID, using = SignUpPageDataProviders.emailField)
    private WebElement emailField;
    @FindBy(how = How.ID, using = SignUpPageDataProviders.passwordField)
    private WebElement passwordField;
    @FindBy(how = How.ID, using = SignUpPageDataProviders.confirmPassField)
    private WebElement confirmPassField;
    @FindBy(how = How.ID, using = SignUpPageDataProviders.signUpButton)
    private WebElement signUpButton;

    public DiscoveryPage signUp(UserObject user) {
        LOG_STEP.info("User fills 'Email' field");
        emailField.sendKeys(user.getEmail());
        LOG_STEP.info("User fills 'Password' field");
        passwordField.sendKeys(user.getPassword());
        LOG_STEP.info("User confirms his password");
        confirmPassField.sendKeys(user.getPassword());
        LOG_STEP.info("User clicks 'Create Account' button");
        signUpButton.click();
        WaitUtils.waitForResult(7);
        return new DiscoveryPage();
    }
}
