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
    private static final String ANDROID = "Android";
    private static final String APPIUM_DEFAULT_URI = "http://127.0.0.1:4723/wd/hub";
    private static final String V7_1 = "7.1";

    private static final String DEFAULT_APP = "Astro.app";
    private static final String DEFAULT_APP_PATH = "/Users/admin/a.tykhonov/wti-astro-ios/Astro/build/Products/Debug-iphonesimulator";
    private static final String DEFAULT_DEVICE = "iPhone Simulator";

    // Platform variables
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String appName;
    private String appPathName;
    private File appDir;
    private File app;
    private String fullAppName;

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

    public void initProperties() {
        if ( System.getProperty("test.platformName") == null || System.getProperty("test.deviceName") == null) {
            System.setProperty("test.platformName", IOS);
            System.setProperty("test.platformVersion", V7_1);
            System.setProperty("test.deviceName", DEFAULT_DEVICE);
        }

        if (System.getProperty("test.AppName") == null || System.getProperty("test.AppPathName") == null ) {
            System.setProperty("test.AppName", DEFAULT_APP);
            System.setProperty("test.AppPathName",DEFAULT_APP_PATH);
        }


        appPathName = System.getProperty("test.AppPathName");
        appName = System.getProperty("test.AppName");
        appDir = new File(appPathName);
        app = new File(appDir, appName);

        if (appPathName.equals("")) {
            fullAppName = appName;
        } else {
            fullAppName = app.getAbsolutePath();
        }

        platformName = System.getProperty("test.platformName");
        platformVersion = System.getProperty("test.platformVersion");
        deviceName = System.getProperty("test.deviceName");
    }

    public AppiumDriver initDriver() {
        String urlString;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        initProperties();

        LOG_ENVIRONMENT.info("Platform Name: " + platformName + ", Platform Version: " + platformVersion + " Full App Name: " + fullAppName
                + " Device name: " + deviceName);

        driver = null;
        urlString = APPIUM_DEFAULT_URI;

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("app", fullAppName);
        if (platformName.equals(ANDROID)) {
            capabilities.setCapability("appPackage", "com.rnrmusic.radio");
            capabilities.setCapability("appActivity", ".activities.WelcomeActivity");
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
