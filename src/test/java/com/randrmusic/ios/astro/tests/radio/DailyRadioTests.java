package com.randrmusic.ios.astro.tests.radio;

import com.randrmusic.ios.astro.tests.AstroBaseTest;
import framework.Loggable;
import helpers.com.randrmusic.ios.astro.choose.page.ChooseSignPage;
import helpers.com.randrmusic.ios.astro.login.pages.SignInPage;
import org.testng.annotations.BeforeMethod;

/**
 * Created by admin on 12.06.14.
 */
public class DailyRadioTests extends AstroBaseTest implements Loggable {

    private static final int NUMBER_OF_SKIPS = 6;

    private SignInPage signInPage;
    private ChooseSignPage chooseSignPage;
    // TODO: private ForecastPage forecastPage;
    // TODO: private DailyRadioPage dailyRadioPage;

    @BeforeMethod
    public void setUp() {
        signInPage = new SignInPage();
        chooseSignPage = new ChooseSignPage();

    }

    public void skipMoreThanFiveTimes() {
        LOG_TEST_SUITE.info("Daily Radio Tests");
        LOG_PRECONDITIONS.info("iphone with iOS 7.1");
        LOG_TEST.info("Skip song more than five times test");
        LOG_EXPECTED_RESULT.info("User cannot skip song more than 5 times in an hour");
        signInPage.signIn(defaultUser);
        // TODO: forecastPage = chooseSignPage.chooseRandomSign();
        // TODO: dailyRadioPage = forecastPage.playDailyRadio();
        // TODO: dailyRadioPage.pressSkipButton(NUMBER_OF_SKIPS);
    }
}
