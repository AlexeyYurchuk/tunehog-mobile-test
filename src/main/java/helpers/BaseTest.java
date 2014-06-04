package helpers;

import framework.Loggable;
import framework.THMobileDriver;
import framework.dataobjects.UserObject;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseTest implements Loggable {

    private AppiumDriver driver;
    protected UserObject defaultUser;
    protected UserObject accountUser;

    @BeforeClass
    public void genericSetUp() {
        driver = THMobileDriver.getInstance().getDriver();
        defaultUser = new UserObject();
        defaultUser.setFromProperties();
        accountUser = new UserObject();
        accountUser.setFromPropertiesAccount();
    }

    @AfterClass
    public void genericTearDown() throws InterruptedException {
        WaitUtils.waitForResult(3);
        /**
        if (driver != null) {
            THMobileDriver.getInstance().terminate();
        }**/
    }

    @AfterMethod(alwaysRun = true)
    public void catchException(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd MM yyyy");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH mm");
        String methodName = result.getName();
        Throwable exceptionName = result.getThrowable();
        if (!result.isSuccess()) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "screenshots/" + "Time_" + formatterTime.format(calendar.getTime()) + "__(Date)_" +
                    formatterDate.format(calendar.getTime()) + "__(TestMethod)_" + methodName + "__(TestClass)_" +
                    getClass().getSimpleName() + ".png";
            LOG_ERROR.info("TEST FAILED. PATH TO SCREENSHOT: " + path);
            LOG_ERROR.info("THE EXCEPTION IS: " + exceptionName.toString());
            try {
                FileUtils.copyFile(scrFile, new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
    }
}