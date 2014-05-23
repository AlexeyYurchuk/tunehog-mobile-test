package com.rnrmusic.Astro.tests.login;

import framework.dataobjects.UserObject;
import helpers.BaseTest;
import helpers.choose.page.ChooseSignPage;
import helpers.login.pages.SignInPage;
import helpers.start.page.StartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.Loggable;
/**
 * Created by admin on 20.05.14.
 */
public class LoginTests extends BaseTest implements Loggable {

    private StartPage startPage;
    private SignInPage signInPage;
    private ChooseSignPage chooseSignPage;

    @BeforeMethod
    public void setUp() {
        startPage = new StartPage();
        chooseSignPage = new ChooseSignPage();
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
        chooseSignPage.clickLogout();
        signInPage.checkUnLoggedUser();
    }

    @Test(priority = 2)
    public void loginThroughFacebook() {
        LOG_TEST.info("Login with Facebook account");
        // TODO create real test
    }
}