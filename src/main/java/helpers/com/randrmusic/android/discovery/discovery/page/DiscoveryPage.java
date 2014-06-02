package helpers.com.randrmusic.android.discovery.discovery.page;

import framework.Loggable;
import helpers.BasePage;
import helpers.com.randrmusic.android.discovery.discovery.data.DiscoveryPageDataProviders;
import helpers.com.randrmusic.android.discovery.menu.page.MenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.WaitUtils;

public class DiscoveryPage extends BasePage implements DiscoveryPageDataProviders, Loggable {

    @FindBy(how = How.ID, using = DiscoveryPageDataProviders.homeButton)
    private WebElement homeButton;

    public MenuPage clickHome() {
        WaitUtils.sleep(1);
        LOG_STEP.info("User clicks on Home icon to open menu activity");
        homeButton.click();
        return new MenuPage();
    }
}
