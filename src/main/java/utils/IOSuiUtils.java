package utils;

import framework.Loggable;
import framework.THMobileDriver;
import helpers.com.randrmusic.ios.system.main.page.MainPage;
import helpers.com.randrmusic.ios.system.settings.page.SettingsPage;
import io.appium.java_client.AppiumDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by admin on 26.05.14.
 */
public class IOSuiUtils implements Loggable{

    private static AppiumDriver driver;
    private static MainPage mainPage;
    private static SettingsPage settingsPage;

   public static MainPage clickHomeButton() {
        try {
            WaitUtils.sleep(1);
            Robot robot = new Robot();

            //Script for setting iPhone Simulator to foreground
            String[] cmd = {"osascript", "-e", "tell application \"iPhone Simulator\" to activate"};
            Process ls = Runtime.getRuntime().exec(cmd);
            ls.waitFor();

            // Run robot comands
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_H);

            robot.keyRelease(KeyEvent.VK_H);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_META);
            WaitUtils.sleep(2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new MainPage();
    }


}
