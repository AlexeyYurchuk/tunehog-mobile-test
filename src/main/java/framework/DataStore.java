package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 21.05.14.
 */
public class DataStore {

    private static DataStore instance;
    private Properties properties;

    public DataStore() {
        String propertiesFileName = "project.properties";
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(ClassLoader.getSystemResource(propertiesFileName).toURI())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static DataStore getInstance() {
        Lock lock;
        if (instance == null) {
            lock = new ReentrantLock();
            lock.lock();

            if (instance == null) {
                instance = new DataStore();
            }

            lock.unlock();
        }
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }
}
