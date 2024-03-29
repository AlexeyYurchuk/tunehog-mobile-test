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
        signInPage = new SignInPage();
    }

    @AfterMethod
    public void tearDown() {
        WaitUtils.waitForResult(1);
        THMobileDriver.getInstance().terminate();
    }

    @Test(priority = 1)
    public void signInAstroSubscribedUserTest() {
        LOG_TEST_SUITE.info("Login Tests");
        LOG_PRECONDITIONS.info("iphone with iOS 7.1");
        LOG_TEST.info("Login using Astro user with subscription");
        LOG_EXPECTED_RESULT.info("User logs into the app and can use Astro");
        signInPage.checkUnLoggedUser();
        signInPage.signIn(astroSubscribedUser);
        chooseSignPage.checkLoggedInUser();
    }

    @Test(priority = 2)
    public void signInAstroNoSubscribedUserTest() {
        LOG_TEST.info("Login using Astro user without subscription");
        LOG_EXPECTED_RESULT.info("Only subscribed users can use Astro");
        signInPage.checkUnLoggedUser();
        signInPage.signIn(astroNoSubscribedUser);
        chooseSignPage.checkLoggedInUser();
    }

    @Test(priority = 2)
    public void signInTunehogFreeUserTest() {
        LOG_TEST.info("Login using Tunehog user without subscription");
        LOG_EXPECTED_RESULT.info("Only subscribed users can use Astro");
        signInPage.checkUnLoggedUser();
        signInPage.signIn(defaultUser);
        signInPage.checkIncorrectCredentials();
    }

    @Test(priority = 2)
    public void signInTunehogSubscribedUserTest() {
        LOG_TEST.info("Login using Tunehog user with subscription");
        LOG_EXPECTED_RESULT.info("Only subscribed Astro users can use Astro");
        signInPage.checkUnLoggedUser();
        signInPage.signIn(tunehogNoSubscribedUser);
        signInPage.checkIncorrectCredentials();
    }

    @Test(priority = 2, enabled = false)
    public void negativeTestSignIn() {
        LOG_TEST.info("Login with wrong credentials");
        LOG_EXPECTED_RESULT.info("User failed to log into the system using invalid credentials");
        WaitUtils.waitForResult(3);
    }


}