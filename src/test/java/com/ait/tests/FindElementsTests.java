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

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let car work"));
        System.out.println(linkText.getText());

        // WebElement linkText2 = driver.findElement(By.linkText("Los Angeles"));
        //System.out.println(linkText2.getText());

    }

    @Test
    public void findElementByPartialLink() {
        WebElement work = driver.findElement(By.partialLinkText("work"));
        System.out.println(work.getText());

    }

    @Test
    public void findElementByCssSelector() {
        //driver.findElement(By.tagName("h1"));
        //tagName h1-> css "h1"
        driver.findElement(By.cssSelector("h1"));

        //driver.findElement(By.id("city"));
        //id-> css #city
        driver.findElement(By.cssSelector("#city"));

        //driver.findElement(By.className("telephone"));
        //class-> css .telephone


        driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.cssSelector(".navigation-link"));

        //contains ->*
        driver.findElement(By.cssSelector("[class*='container']"));
        //start-> ^
        driver.findElement(By.cssSelector("[class^='input']"));
        //end to -> $
        driver.findElement(By.cssSelector("[class$='icon']"));

        //[key='value']
        driver.findElement(By.cssSelector("[placeholder='City']"));

        //tag + class + class
        driver.findElement(By.cssSelector("a.navigation-link.active"));

        //one step above(один шаг вниз)
        driver.findElement(By.cssSelector(".logo>img"));
        //.feedback-card:nth-child(3)

        //.feedback-card:nth-child(6) .feedback-text

        //<tag> or <class> or <id>:nth-child(n)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback-card:nth-child(1)"));
        System.out.println(feedback.getText());
        WebElement search = driver.findElement(By.cssSelector(".navigation-link:nth-child(2)"));
        System.out.println(search.getText());


    }

    @Test
    public void findElementByxPath() {
        // // tag[@atribute=‘value‘]
        // //tag[1]
        // //tag[text()'losa angeles']
        driver.findElement(By.xpath("//h1"));

        driver.findElement(By.xpath("//*[@id='city']"));

        driver.findElement(By.xpath("//*[@class='telephone']"));

        //driver.findElement(By.cssSelector("[class*='container']"));
        driver.findElement(By.xpath("//*[contains(@class,'container')]"));
        // driver.findElement(By.xpath("//p[contains(text(),'best services')]"));
        driver.findElement(By.xpath("//p[contains(.,'best services')]"));
        // driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        driver.findElement(By.xpath("//*[.='Find your car now!']"));

        //driver.findElement(By.cssSelector(".logo>img"));
        driver.findElement(By.xpath("//*[@class='logo']/img"));

        //cssSelector - >   div>a         //cssSelector - >
        //cssSelector - > div a           //cssSelector - >  //div//a


    }
}