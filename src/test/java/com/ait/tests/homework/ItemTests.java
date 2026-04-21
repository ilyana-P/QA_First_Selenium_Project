package com.ait.tests.homework;

import com.ait.data.UserData;
import com.ait.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void login() {
        if (app.getUser().isLoginLinkPresent()) {
            User user = new User()
                    .setEmail(UserData.EMAIL)
                    .setPassword(UserData.PASSWORD);
            app.getUser().login(user);
        }
    }

    @Test
    public void addItemToCartTest() {
        app.openHomePage();
        app.getUser().pause(3000);
        app.driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(1).click();
        app.getUser().pause(5000);
        app.driver.get("https://demowebshop.tricentis.com/cart");
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".product-name")));
    }
}