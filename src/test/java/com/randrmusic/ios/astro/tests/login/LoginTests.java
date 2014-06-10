package com.randrmusic.ios.astro.tests.login;

import com.randrmusic.ios.astro.tests.AstroBaseTest;
import framework.THMobileDriver;
import helpers.BaseTest;
import helpers.com.randrmusic.ios.astro.choose.page.ChooseSignPage;
import helpers.com.randrmusic.ios.astro.login.pages.SignInPage;
import helpers.com.randrmusic.ios.astro.start.page.StartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.Loggable;
import utils.WaitUtils;

/**
 * Created by admin on 20.05.14.
 */
public class LoginTests extends AstroBaseTest implements Loggable {

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

    @Test(priority = 1)
    public void signInSignOutTest() {
        LOG_TEST_SUITE.info("Login Tests");
        LOG_PRECONDITIONS.info("iphone with iOS 7.1");
        LOG_TEST.info("Login and Logout test");
        LOG_EXPECTED_RESULT.info("User logs into the system, then log out");
        signInPage = startPage.clickLogin();
        signInPage.checkUnLoggedUser();
        signInPage.signIn(defaultUser);
        chooseSignPage.checkLoggedInUser();
        /**
        chooseSignPage.clickLogout();
        signInPage.checkUnLoggedUser();
        **/
    }

    @Test(priority = 2)
    public void negativeTestSignIn() {
        LOG_TEST.info("Login with wrong credentials");
        LOG_EXPECTED_RESULT.info("User failed to log into the system using invalid credentials");
        signInPage = startPage.clickLogin();
        WaitUtils.waitForResult(3);
    }
}