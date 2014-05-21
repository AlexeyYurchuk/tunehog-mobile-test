package helpers;

import framework.Loggable;
import framework.THMobileDriver;
import framework.dataobjects.UserObject;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WaitUtils;

public class BaseTest implements Loggable {

    private AppiumDriver driver;
    protected UserObject defaultUser;

    @BeforeClass
    public void genericSetUp() {
        driver = THMobileDriver.getInstance().getDriver();
        defaultUser = new UserObject();
        defaultUser.setFromProperties();
    }

    @AfterClass
    public void genericTearDown() throws InterruptedException {
        WaitUtils.waitForResult(3);
        THMobileDriver.getInstance().terminate();
    }
}