package com.randrmusic.android.discovery.tests;

import framework.Loggable;
import framework.THMobileDriver;
import helpers.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WaitUtils;

public class BaseDiscoveryTest extends BaseTest implements Loggable {

    @BeforeTest
    public void setUpApplication() {
        System.setProperty("test.AppName","com.rnrmusic.radio.apk");
        System.setProperty("test.AppPathName", "D:\\discoveryAndroid");
        System.setProperty("test.deviceName", "192.168.56.101:5555");
    }

    @AfterTest
    public void tearDownApplication() {
        WaitUtils.waitForResult(2);
    }
}
