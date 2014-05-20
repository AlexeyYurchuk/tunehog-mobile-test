package utils;

/**
 * Created by admin on 20.05.14.
 */
public class WaitUtils {

    public static void waitForResult(int seconds) {
        sleep(seconds);
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
