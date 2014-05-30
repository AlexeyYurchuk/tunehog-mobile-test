package com.randrmusic.ios.general.tests.settings;

import framework.Loggable;
import framework.THMobileDriver;
import helpers.BaseTest;
import helpers.com.randrmusic.ios.system.settings.page.FacebookSettingsPage;
import helpers.com.randrmusic.ios.system.settings.page.SettingsPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WaitUtils;

/**
 * Created by admin on 26.05.14.
 */
public class FacebookOptionsTest extends BaseTest implements Loggable {

    private SettingsPage settingsPage;
    private FacebookSettingsPage facebookSettingsPage;

    @BeforeTest
    public void setUpApplication() {
        System.setProperty("test.AppName","settings");
        System.setProperty("test.AppPathName", "");
        settingsPage = new SettingsPage();
    }

    @AfterTest
    public void tearDownApplication() {
        WaitUtils.waitForResult(2);
        System.setProperty("test.AppName", null);
        System.setProperty("test.AppPathName", null);
        THMobileDriver.getInstance().terminate();
    }

    @Test()
    public void initFacebookOptions() {
        LOG_TEST.info("Setup valid Facebook account in the Settings");
        settingsPage.scrollDown();
        facebookSettingsPage = settingsPage.openFacebookSettings();
        facebookSettingsPage.signIn(defaultUser);
        WaitUtils.sleep(10);
        facebookSettingsPage.checkLoggedInUser();
        WaitUtils.sleep(3);
    }

}
