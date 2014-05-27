package helpers;

import framework.THMobileDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

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

    public void jsExecute(String input) {
        ((JavascriptExecutor) driver).executeScript(input);
    }

    public void jsExecuteWithOption(String s, HashMap<String, String> swipeObject) {
        WaitUtils.sleep(1);
        ((JavascriptExecutor) driver).executeScript(s, swipeObject);
    }

    public void swipeToLeft() {
        WaitUtils.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.2);
        swipeObject.put("startY", 0.7);
        swipeObject.put("endX", 0.5);
        swipeObject.put("endY", 0.7);
        swipeObject.put("duration", 0.8);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeToRight() {
        WaitUtils.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.5);
        swipeObject.put("startY", 0.7);
        swipeObject.put("endX", 0.2);
        swipeObject.put("endY", 0.7);
        swipeObject.put("duration", 0.8);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void scrollToRight() {
        WaitUtils.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> swipeObject = new HashMap<String, String>();
        swipeObject.put("direction", "right");
        js.executeScript("mobile: scroll", swipeObject);
    }

    public void scrollToLeft() {
        WaitUtils.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> swipeObject = new HashMap<String, String>();
        swipeObject.put("direction", "left");
        js.executeScript("mobile: scroll", swipeObject);
    }

    public void scrollDown() {
        HashMap<String, String> swipeObject = new HashMap<String, String>();
        swipeObject.put("direction", "down");
        jsExecuteWithOption("mobile: scroll", swipeObject);
    }

    public void scrollTo(int pixels) {
        String execute = "";
        if (pixels >= 0) {
            execute = "scroll(0," + pixels + ");";
        } else {
            execute = "scroll(" + pixels + ",0)";
        }
        jsExecute(execute);
        WaitUtils.sleep(1);
    }
}
