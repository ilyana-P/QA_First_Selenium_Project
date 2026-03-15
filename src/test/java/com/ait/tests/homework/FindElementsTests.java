package com.ait.tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void  setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void findElementById(){
        WebElement searchField = driver.findElement(By.id("small-searchterms"));
        System.out.println("search field value: " + searchField.getDomAttribute("value"));

        driver.findElement(By.linkText("Register")).click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        System.out.println("First name field id: " + firstName.getDomAttribute("id"));

    }
    @Test
    public void findElementByTagName(){
        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println("header text: " + h2.getText());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("number of links: " + links.size());
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void finElementByClassName(){
        WebElement button = driver.findElement(By.className("button-2"));
        System.out.println("Class button: " + button.getDomAttribute("class"));

        WebElement categories = driver.findElement(By.className("block-category-navigation"));
        System.out.println("Categories list:" + categories.getText());



    }
    @Test
    public void findElementByLinkText(){
        WebElement electronics = driver.findElement(By.linkText("Electronics"));
        System.out.println(electronics.getText());

        WebElement books = driver.findElement(By.linkText("Books"));
        System.out.println(books.getText());
    }

    @Test
    public void findElementByName(){
        driver.findElement(By.linkText("Log in")).click();
        WebElement email = driver.findElement(By.name("Email"));
        System.out.println(email.getDomAttribute("name"));

        WebElement password = driver.findElement(By.name("Password"));
        System.out.println(password.getDomAttribute("name"));

    }
}
