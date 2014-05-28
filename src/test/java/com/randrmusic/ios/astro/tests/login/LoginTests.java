package com.randrmusic.ios.astro.tests.login;

import com.randrmusic.ios.astro.tests.AstroBaseTest;
import helpers.BaseTest;
import helpers.com.randrmusic.ios.astro.choose.page.ChooseSignPage;
import helpers.com.randrmusic.ios.astro.login.pages.SignInPage;
import helpers.com.randrmusic.ios.astro.start.page.StartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.Loggable;

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

    @Test
    public void signInSignOutTest() {
        LOG_TEST_SUITE.info("Login Tests");
        LOG_PRECONDITIONS.info("iphone with iOS 7.1");
        LOG_TEST.info("Login and Logout test");
        LOG_EXPECTED_RESULT.info("User logs into the system, then log out");
        signInPage = startPage.clickLogin();
        signInPage.checkUnLoggedUser();
        signInPage.signIn(defaultUser);
        chooseSignPage.checkLoggedInUser();
        chooseSignPage.clickLogout();
        signInPage.checkUnLoggedUser();
    }

    // don't forget to run initFacebookOptions() before
    // TODO: make pure dependency on initFacebookOptions() method
    @Test()
    public void loginThroughFacebook() {
        LOG_TEST.info("Login with Facebook account");
        LOG_EXPECTED_RESULT.info("User is logged into the system with the Facebook account");
        signInPage = startPage.clickLogin();
        signInPage.checkUnLoggedUser();
        signInPage.signInFacebook();
        chooseSignPage.checkLoggedInUser();
        chooseSignPage.clickLogout();
    }

}