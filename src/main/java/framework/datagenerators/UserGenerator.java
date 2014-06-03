package framework.datagenerators;

import framework.dataobjects.UserObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class UserGenerator {

    @DataProvider(name = "randomUser")
    public static Iterator<Object[]> generateRandomUsers() {

        List<UserObject> users = new UserGenerator()
                .generateUsersList();
        List<Object[]> list = new ArrayList<Object[]>();
        for (UserObject forCase : users) {
            list.add(new Object[]{forCase});
        }
        return list.iterator();
    }

    private List<UserObject> generateUsersList() {

        List<UserObject> users = new ArrayList<UserObject>();

        UserObject userObject = new UserObject();

        Random randomGenerator = new Random();

        userObject.setEmail("user" + randomGenerator.nextInt() + "@gmail.com");
        userObject.setPassword("password" + randomGenerator.nextInt());
        userObject.setUsername((userObject.getEmail()).split("@")[0]);

        users.add(userObject);

        return users;
    }
}
