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

public class FindDemoWebShopElement {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void findElementByCssSelectors() {

        WebElement search = driver.findElement(By.cssSelector("#small-searchterms"));
        System.out.println(search.getDomAttribute("id"));

        driver.findElement(By.cssSelector(".header-logo"));

        WebElement subscribeBtn = driver.findElement(By.cssSelector("#newsletter-subscribe-button"));
        System.out.println(subscribeBtn.getDomAttribute("value"));

        List<WebElement> categoriesList = driver.findElements(By.cssSelector(".listbox ul li"));
        System.out.println(categoriesList.size());

        WebElement gift = driver.findElement(By.cssSelector(".product-title a"));
        System.out.println(gift.getText());

        WebElement wishLink = driver.findElement(By.cssSelector("a[href='/wishlist']"));
        System.out.println(wishLink.getText());

        WebElement good = driver.findElement(By.cssSelector("#pollanswers-2"));
        System.out.println(good.getDomAttribute("value"));

        WebElement cool = driver.findElement(By.cssSelector("a[href='/producttag/3/cool']"));
        System.out.println(cool.getText());

        WebElement block = driver.findElement(By.cssSelector("[class*='block-category']"));
        System.out.println(block.getDomAttribute("class"));

        WebElement logoImg = driver.findElement(By.cssSelector(".header-logo>a>img"));
        System.out.println(logoImg.getDomAttribute("src"));
    }
    @Test
    public void FindElementByXpath(){
        WebElement search = driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        System.out.println(search.getDomAttribute("id"));

        driver.findElement(By.xpath("//div[@class='header-logo']"));

        WebElement subscribeBtn = driver.findElement(By.xpath("//*[@id='newsletter-subscribe-button']"));
        System.out.println(subscribeBtn.getDomAttribute("value"));

        List<WebElement> categoriesList = driver.findElements(By.xpath("//div[@class='listbox']//ul//li"));
        System.out.println(categoriesList.size());

        WebElement gift = driver.findElement(By.xpath("//h2[@class='product-title']/a"));
        System.out.println(gift.getText());
        WebElement wishLink = driver.findElement(By.xpath("//a[@href='/wishlist']"));
        System.out.println(wishLink.getText());

        WebElement good = driver.findElement(By.xpath("//*[@id='pollanswers-2']"));
        System.out.println(good.getDomAttribute("value"));

        WebElement cool = driver.findElement(By.xpath("//a[@href='/producttag/3/cool']"));
        System.out.println(cool.getText());

        WebElement block = driver.findElement(By.xpath("//*[contains(@class,'block-category')]"));
        System.out.println(block.getDomAttribute("class"));

        WebElement logoImg = driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
        System.out.println(logoImg.getDomAttribute("src"));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}