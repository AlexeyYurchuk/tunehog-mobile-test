package com.randrmusic.ios.astro.tests.login;

import com.randrmusic.ios.astro.tests.AstroBaseTest;
import framework.Loggable;
import framework.THMobileDriver;
import helpers.com.randrmusic.ios.astro.choose.page.ChooseSignPage;
import helpers.com.randrmusic.ios.astro.login.pages.SignInPage;
import helpers.com.randrmusic.ios.astro.start.page.StartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WaitUtils;

/**
 * Created by admin on 30.05.14.
 */
public class FacebookLoginTests extends AstroBaseTest implements Loggable {

    private StartPage startPage;
    private SignInPage signInPage;
    private ChooseSignPage chooseSignPage;

    @BeforeMethod
    public void setUp() {
        startPage = new StartPage();
        chooseSignPage = new ChooseSignPage();
    }

    @AfterMethod
    public void tearDown() {
        WaitUtils.waitForResult(1);
        THMobileDriver.getInstance().terminate();
    }

    // don't forget to run initFacebookOptions() before
    // TODO: make pure dependency on initFacebookOptions() method
    @Test()
    public void loginThroughFacebook() {
        LOG_TEST_SUITE.info("Facebook Login Tests");
        LOG_TEST.info("Login with Facebook account");
        LOG_EXPECTED_RESULT.info("User is logged into the system with the Facebook account");
        signInPage = startPage.clickLogin();
        signInPage.checkUnLoggedUser();
        signInPage.signInFacebook();
        chooseSignPage.checkLoggedInUser();
        // TODO: chooseSignPage.clickLogout();
    }
}
