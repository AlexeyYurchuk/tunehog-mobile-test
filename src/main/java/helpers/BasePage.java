package helpers;

import framework.THMobileDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 20.05.14.
 */
public class BasePage {

    private AppiumDriver driver;

    public BasePage() {
        driver = THMobileDriver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
