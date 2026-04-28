package com.ait.tests.homework;

import com.ait.data.UserData;
import com.ait.details.UserDetails;
import com.ait.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ait.core.ApplicationManager.softAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutLink();
            app.getUser().pause(1000);
        }
    }

    @Test(enabled = false)
    public void createAccountPositiveTest() {
        User user = new User()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("testuser_" + System.currentTimeMillis() + "@test.com")
                .setPassword(UserData.PASSWORD);

        app.getUser().clickOnRegisterLink();
        app.getUser().pause(1000);
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isRegistered());
    }

    @Test
    public void existedUserRegisterNegativeTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().pause(1000);
        app.getUser().fillRegisterForm(new User()
                .setEmail(UserDetails.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegisterButton();
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }
}