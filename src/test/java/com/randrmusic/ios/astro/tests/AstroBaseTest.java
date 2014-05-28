package com.randrmusic.ios.astro.tests;

import framework.Loggable;
import helpers.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WaitUtils;

/**
 * Created by admin on 28.05.14.
 */
public class AstroBaseTest extends BaseTest implements Loggable {

    @BeforeTest
    public void setUpApplication() {
        System.setProperty("test.AppName","Astro.app");
        System.setProperty("test.AppPathName", "/Users/admin/a.tykhonov/wti-astro-ios/Astro/build/Products/Debug-iphonesimulator");
        System.setProperty("test.deviceName", "iPhone Simulator");
    }

    @AfterTest
    public void tearDownApplication() {
        WaitUtils.waitForResult(2);
    }

}
