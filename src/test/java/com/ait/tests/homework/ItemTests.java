package com.ait.tests.homework;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ItemTests extends TestBase {

    @BeforeMethod
    public void login() {
        click(By.cssSelector("a[href='/login']"));
        type(By.cssSelector("#Email"), "il.potnyaeva@gmail.com");
        type(By.cssSelector("#Password"), "$agm@2Q6z99MXs");
        click(By.cssSelector("input[value='Log in']"));
    }

    @Test
    public void addItemToCartTest() {
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(1).click();
        click(By.cssSelector("a[href='/cart']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".product-name")));    }
}