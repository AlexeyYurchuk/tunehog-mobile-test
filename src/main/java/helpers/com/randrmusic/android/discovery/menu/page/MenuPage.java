package helpers.com.randrmusic.android.discovery.menu.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.android.discovery.menu.data.MenuPageDataProviders;
import helpers.com.randrmusic.ios.system.main.data.MainPageDataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.WaitUtils;

import java.util.List;

public class MenuPage extends BasePage implements MainPageDataProviders, Loggable {

    @FindBy(how = How.ID, using = MenuPageDataProviders.username)
    private WebElement username;
    @FindBy(how = How.CLASS_NAME , using = MenuPageDataProviders.menuButtonsList)
    List<WebElement> menuButtonsList;

    public void checkLoggedUser(UserObject defaultUser) {
        LOG_STEP.info("System checks if user logged in");
        Assert.assertEquals(username.getText(), defaultUser.getUsername(), "User logged in!");
    }

    public void clickLogout() {
        LOG_STEP.info("User clicks on 'LogOut' button");
        LOG_STEP.info("Soze" + menuButtonsList.size());
        WaitUtils.sleep(1);
        menuButtonsList.get(menuButtonsList.size()-1).click();
    }
}
