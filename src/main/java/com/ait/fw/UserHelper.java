package com.ait.fw;

import com.ait.core.BaseHelper;
import com.ait.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void login(User user) {
        click(By.cssSelector("a[href='/login']"));
        pause(2000);
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        click(By.cssSelector("input[value='Log in']"));
        pause(2000);
    }
    public void register(User user) {
        click(By.cssSelector("a[href='/register']"));
        pause(2000);
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());
        click(By.cssSelector("#register-button"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector(".account"));
    }

    public boolean isRegistered() {
        pause(2000);
        return isElementPresent(By.cssSelector(".result"));
    }
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("a[href='/login']"));
    }
}