package com.ait.core;

import com.ait.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class ApplicationManager {

    private final String browser;
    public WebDriver driver;

    private UserHelper user;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void openHomePage() {
        driver.get("https://demowebshop.tricentis.com");
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();

        user = new UserHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}