package com.ait.tests.homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {
        String email = "testuser_" + System.currentTimeMillis() + "@test.com";

        click(By.cssSelector("a[href='/register']"));
        type(By.cssSelector("#FirstName"), "John");
        type(By.cssSelector("#LastName"), "Doe");
        type(By.cssSelector("#Email"), email);
        type(By.cssSelector("#Password"), "Test1234!");
        type(By.cssSelector("#ConfirmPassword"), "Test1234!");
        click(By.cssSelector("#register-button"));

        Assert.assertTrue(isElementPresent(By.cssSelector(".result")));
    }
}