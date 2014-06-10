package helpers.com.randrmusic.ios.astro.start.page;

import framework.Loggable;
import helpers.BasePage;
import helpers.com.randrmusic.ios.astro.start.data.StartPageDataProviders;
import helpers.com.randrmusic.ios.astro.login.pages.SignInPage;
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

    @FindBy(how = How.NAME, using = StartPageDataProviders.LoginControllerButton)
    private WebElement loginControllerButton;

    public StartPage() {}

    public SignInPage clickLogin() {
        LOG_STEP.info("User choose 'Login' option");
        loginControllerButton.click();
        return new SignInPage();
    }
}
