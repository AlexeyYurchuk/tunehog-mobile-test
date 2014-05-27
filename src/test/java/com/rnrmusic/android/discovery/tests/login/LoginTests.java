package com.rnrmusic.android.discovery.tests.login;

import com.rnrmusic.android.discovery.tests.BaseDiscoveryTest;
import framework.Loggable;
import helpers.com.randrmusic.android.discovery.login.page.SignInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseDiscoveryTest implements Loggable {

    private SignInPage signInPage;

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
        // signInPage.checkUnLoggedUser();
        signInPage.signIn(defaultUser);
        // TODO: implement other steps
    }
}
