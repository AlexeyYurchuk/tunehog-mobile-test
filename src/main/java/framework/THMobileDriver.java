package framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 20.05.14.
 */
public class THMobileDriver implements Loggable {

    private AppiumDriver driver;
    private static volatile THMobileDriver instance;

    //constants
    private static final String IOS = "iOS";
    private static final String APPIUM_DEFAULT_URI = "http://127.0.0.1:4723/wd/hub";
    private static final String V7_1 = "7.1";

    // Platform variables
    private String platformName;
    private String platformVersion;


    private THMobileDriver() {
        initProperties();
        driver = initDriver();
     }

    public static THMobileDriver getInstance() {
        Lock lock;
        if (instance == null) {
            lock = new ReentrantLock();
            lock.lock();

            if (instance == null) {
                instance = new THMobileDriver();
            }

            lock.unlock();
        }
        return instance;
    }

    private void initProperties() {
        if ( System.getProperty("test.platformName") == null) {
            System.setProperty("test.platformName", IOS);
            System.setProperty("test.platformVersion", V7_1);
        }

        platformName = System.getProperty("test.platformName");
        platformVersion = System.getProperty("test.platformVersion");
    }

    public AppiumDriver initDriver() {
        String urlString;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        LOG_ENVIRONMENT.info("Platform Name: " + platformName + ", Platform Version: " + platformVersion);

        driver = null;

        urlString = APPIUM_DEFAULT_URI;

        if (platformName.equals(IOS)) {
            File appDir = new File("/Users/admin/a.tykhonov/wti-astro-ios/Astro/build/Products/Debug-iphonesimulator");
            File app = new File(appDir, "Astro.app");
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("deviceName", "iPhone Simulator");
            capabilities.setCapability("app", app.getAbsolutePath());
        }

        try {
            driver = new AppiumDriver(new URL(urlString), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public void terminate() {
        driver.quit();
        driver = null;
    }

    public AppiumDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }
}
