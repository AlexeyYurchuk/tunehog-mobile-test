package com.randrmusic.android.discovery.tests;

import framework.DataStore;
import framework.Loggable;
import framework.THMobileDriver;
import helpers.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WaitUtils;

import java.util.Properties;

public class BaseDiscoveryTest extends BaseTest implements Loggable {

    private Properties properties;

    @BeforeTest
    public void setUpApplication() {
        properties = DataStore.getInstance().getProperties();
        System.setProperty("test.AppName", properties.getProperty("android.discovery.appName"));
        System.setProperty("test.AppPathName", properties.getProperty("android.discovery.appPathName"));
        System.setProperty("test.deviceName", properties.getProperty("android.discovery.deviceName"));
        System.setProperty("test.appActivity", properties.getProperty("android.discovery.appActivity"));
        System.setProperty("test.appPackage", properties.getProperty("android.discovery.appPackage"));
    }

    @AfterTest
    public void tearDownApplication() {
        WaitUtils.waitForResult(2);
    }
}
