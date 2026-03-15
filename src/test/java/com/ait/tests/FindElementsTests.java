package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

    //before test
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        // driver.manage().window().setSize(new Dimension(900,400));
        //driver.get("https://www.google.com");
        //driver.navigate().to("https://www.google.com") with history
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
    }

    //test
    @Test
    public void findElementByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("h2"));
        System.out.println(element1.getText());

        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());


        //
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getDomAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getDomAttribute("dates"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement navLink = driver.findElement(By.className("navigation-link"));
        System.out.println(navLink.getDomAttribute("class"));
        System.out.println(navLink.getText());

    }


}
