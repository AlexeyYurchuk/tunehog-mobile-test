package helpers.start.page;

import framework.Loggable;
import helpers.BasePage;
import helpers.login.pages.SignInPage;
import helpers.start.data.StartPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by admin on 20.05.14.
 */
public class StartPage extends BasePage implements StartPageDataProviders, Loggable{

    @FindBy(how = How.NAME, using = StartPageDataProviders.LoginName)
    private WebElement loginButton;

    @FindBy(how = How.NAME, using = StartPageDataProviders.TryNowName)
    private WebElement tryNowButton;

    public StartPage() {}

    public SignInPage clickLogin() {
        LOG_STEP.info("User choose 'Login' option");
        loginButton.click();
        return new SignInPage();
    }
}
