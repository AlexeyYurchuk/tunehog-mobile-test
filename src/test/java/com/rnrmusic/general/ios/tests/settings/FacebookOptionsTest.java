package com.rnrmusic.general.ios.tests.settings;

import framework.Loggable;
import framework.THMobileDriver;
import helpers.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WaitUtils;

/**
 * Created by admin on 26.05.14.
 */
public class FacebookOptionsTest extends BaseTest implements Loggable {

    @BeforeTest
    public void setUpApplication() {
        System.setProperty("test.AppName","TestApp.app");
        System.setProperty("test.AppPathName", "/Users/admin/a.tykhonov/appium/sample-code/apps/TestApp/build/Release-iphonesimulator");
    }

    @AfterTest
    public void tearDownApplication() {
        WaitUtils.waitForResult(3);
        System.setProperty("test.AppName", null);
        System.setProperty("test.AppPathName", null);
        THMobileDriver.getInstance().terminate();
    }

    @Test()
    public void initFacebookOptions() {
        LOG_TEST.info("Setup valid Facebook account in the Settings");
        LOG_STEP.info("good");
        WaitUtils.sleep(3);
    }

}
