package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    //before test
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        //driver.get("https://www.google.com");
        //driver.navigate().to("https://www.google.com") with history
    }

    //test
    @Test
    public void openBrowser() {
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        System.out.println(driver.getTitle());

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
        //driver.close

    }
    //after test

}
