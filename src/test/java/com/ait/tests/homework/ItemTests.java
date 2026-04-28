package com.ait.tests.homework;

import com.ait.data.UserData;
import com.ait.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutLink();
            app.getUser().pause(1000);
        }
        app.getUser().clickOnLoginLink();
        app.getUser().pause(1000);
        app.getUser().fillEmailPasswordForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getUser().pause(2000);
    }


    @Test
    public void addItemToCartTest() {
        app.openHomePage();
        app.getItem().addProductToCart();
        app.getItem().openCart();
        Assert.assertTrue(app.getItem().isCartNotEmpty());
    }
}