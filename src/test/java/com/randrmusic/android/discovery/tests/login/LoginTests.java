package com.randrmusic.android.discovery.tests.login;

import com.randrmusic.android.discovery.tests.BaseDiscoveryTest;
import framework.Loggable;
import framework.THMobileDriver;
import framework.datagenerators.UserGenerator;
import framework.dataobjects.UserObject;
import helpers.com.randrmusic.android.discovery.discovery.page.DiscoveryPage;
import helpers.com.randrmusic.android.discovery.login.page.SignInPage;
import helpers.com.randrmusic.android.discovery.menu.page.MenuPage;
import helpers.com.randrmusic.android.discovery.signup.page.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WaitUtils;

public class LoginTests extends BaseDiscoveryTest implements Loggable {

    private SignInPage signInPage;
    private MenuPage menuPage;
    private DiscoveryPage discoveryPage;
    private SignUpPage signUpPage;

    @BeforeMethod
    public void setUp() {

        signInPage = new SignInPage();

    }

    @AfterMethod
    public void tearDown() {
        WaitUtils.waitForResult(1);
        THMobileDriver.getInstance().terminate();
    }


    @Test(priority = 1)
    public void signInSignOutTest() {
        LOG_TEST_SUITE.info("Login Tests");
        LOG_PRECONDITIONS.info("Android 4.4.2");
        LOG_TEST.info("Login and Logout test");
        LOG_EXPECTED_RESULT.info("User logs into the system, then log out");
        WaitUtils.waitForResult(3);
        signInPage.checkUnLoggedUser();
        discoveryPage = signInPage.signIn(defaultUser);
        discoveryPage.back();
        menuPage = discoveryPage.clickHome();
        menuPage.checkLoggedUser(defaultUser);
        // TODO: Emulator fails on logout. Investigate why and uncomment the following steps
        /*
        menuPage.scrollDownAndroid();
        menuPage.clickLogout();
        signInPage.checkUnLoggedUser();*/
    }

    @Test(priority = 2)
    public void negativeTestSignIn() {
        LOG_TEST.info("Login with wrong credentials");
        LOG_EXPECTED_RESULT.info("User failed to log into the system using invalid credentials");
        WaitUtils.waitForResult(3);
        signInPage.checkUnLoggedUser();
        signInPage.invalidEmailOrPassword(defaultUser);
        signInPage.checkUnLoggedUser();
    }

    @Test(priority = 3, dataProvider = "randomUser", dataProviderClass = UserGenerator.class)
    public void signUpTest(UserObject user) {
        LOG_TEST.info("Sign up procedure");
        LOG_EXPECTED_RESULT.info("User passed sign up procedure then logs out");
        WaitUtils.waitForResult(3);
        signInPage.checkUnLoggedUser();
        signUpPage = signInPage.clickSignUp();
        discoveryPage = signUpPage.signUp(user);
        discoveryPage.back();
        menuPage = discoveryPage.clickHome();
        menuPage.checkLoggedUser(user);
    }

    @Test(priority = 4, enabled = false)
    public void restorePasswordTest() {

    }
}
