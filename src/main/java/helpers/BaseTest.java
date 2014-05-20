package helpers;

import framework.Loggable;
import framework.THMobileDriver;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WaitUtils;

public class BaseTest implements Loggable {

    private AppiumDriver driver;

    @BeforeClass
    public void setUp() {
        driver = THMobileDriver.getInstance().getDriver();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        WaitUtils.waitForResult(3);
        THMobileDriver.getInstance().terminate();
    }
}