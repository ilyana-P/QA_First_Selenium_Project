package com.ait.tests.homework;

import com.ait.data.UserData;
import com.ait.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {
        User user = new User()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("testuser_" + System.currentTimeMillis() + "@test.com")
                .setPassword(UserData.PASSWORD);

        app.getUser().register(user);

        Assert.assertTrue(app.getUser().isRegistered());
    }
}