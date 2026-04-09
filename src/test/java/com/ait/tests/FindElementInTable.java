package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementInTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tableCssSelector() {
        List<WebElement> tr = driver.findElements(By.cssSelector("tr"));
        System.out.println(tr.size());
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getText());

        }
        for  (WebElement element : tr){
            System.out.println(element.getText());

        }


        // get row оплучить ряд tr:nth-child(4)
        WebElement mexico = driver.findElement(By.cssSelector("#customers tr:nth-child(4)"));
        System.out.println(mexico.getText());

        //get row 4 last element(получить ряд и последний элемент)
// WebElement country = driver.findElement(By.cssSelector("#customers tr:nth-child(4) td:nth-child(3)"));
        WebElement country = driver.findElement(By.cssSelector("#customers tr:nth-child(4) td:last-child"));
        System.out.println(country.getText());




    }
    @Test
    public void tableXPath(){
        List<WebElement> tr = driver.findElements(By.xpath("//tr"));
        System.out.println(tr.size());

        WebElement mexico = driver.findElement(By.xpath("//*[@id='customers']//tr[4]//td[3]"));
        System.out.println(mexico.getText());

        WebElement country = driver.findElement(By.xpath("//*[@id='customers']//tr[4]//td[last()]"));
        //parent
//one step up(один шаг вверх)
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));


        //ancestor all (все)
        driver.findElement(By.xpath("//h1/ancestor::*"));//all
        driver.findElement(By.xpath("//h1/ancestor::div"));//two steps
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));//one step

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
