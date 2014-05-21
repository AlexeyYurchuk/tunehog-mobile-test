package framework.dataobjects;

import framework.DataStore;

import java.util.Properties;

/**
 * Created by admin on 20.05.14.
 */
public class UserObject {

    private Properties properties;

    private String email;
    private String username;
    private String password;


    public void setFromProperties() {
        properties = DataStore.getInstance().getProperties();
        setEmail(properties.getProperty("email"));
        setPassword(properties.getProperty("password"));
        setUsername(properties.getProperty("username"));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
