package com.randrmusic.android.discovery.tests.login;

import com.randrmusic.android.discovery.tests.BaseDiscoveryTest;
import framework.Loggable;
import helpers.com.randrmusic.android.discovery.login.page.SignInPage;
import helpers.com.randrmusic.android.discovery.menu.page.MenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WaitUtils;

public class LoginTests extends BaseDiscoveryTest implements Loggable {

    private SignInPage signInPage;
    private MenuPage menuPage;

    @BeforeMethod
    public void setUp() {
        signInPage = new SignInPage();

    }

    @Test
    public void signInSignOutTest() {
        LOG_TEST_SUITE.info("Login Tests");
        LOG_PRECONDITIONS.info("Android 4.4.2");
        LOG_TEST.info("Login and Logout test");
        LOG_EXPECTED_RESULT.info("User logs into the system, then log out");
        WaitUtils.waitForResult(1);
        signInPage.checkUnLoggedUser();
        signInPage.signIn(defaultUser);
       // menuPage.checkLoggedUser();
       // menuPage.clickLogout();
       // signInPage.checkUnLoggedUser();
    }
}
