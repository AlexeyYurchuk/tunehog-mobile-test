package utils;

import framework.Loggable;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by admin on 26.05.14.
 */
public class IOSuiUtils implements Loggable{

    public static void clickHomeButton() {
        try {
            Thread.sleep(3000);
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
            Thread.sleep(6000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
