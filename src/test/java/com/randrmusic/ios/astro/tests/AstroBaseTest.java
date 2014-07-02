package com.randrmusic.ios.astro.tests;

import framework.DataStore;
import framework.Loggable;
import framework.THMobileDriver;
import framework.dataobjects.UserObject;
import helpers.BaseTest;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.WaitUtils;

import java.util.Properties;

/**
 * Created by admin on 28.05.14.
 */
public class AstroBaseTest extends BaseTest implements Loggable {

    private Properties properties;
    protected UserObject astroSubscribedUser;
    protected UserObject astroNoSubscribedUser;

    @BeforeClass
    public void setUpAstro() {
        astroSubscribedUser = new UserObject();
        astroSubscribedUser.setFromPropertiesAstroSubscribed();
        astroNoSubscribedUser = new UserObject();
        astroNoSubscribedUser.setFromPropertiesAstroNoSubscribed();
    }

    @BeforeTest
    public void setUpApplication() {
        properties = DataStore.getInstance().getProperties();
        System.setProperty("test.AppName", properties.getProperty("ios.astro.appName"));
        System.setProperty("test.AppPathName", properties.getProperty("ios.astro.appPathName"));
        System.setProperty("test.deviceName", properties.getProperty("ios.deviceName"));
    }

    @AfterTest
    public void tearDownApplication() {
        WaitUtils.waitForResult(2);
    }

}
