package com.ait.fw;

import com.ait.core.BaseHelper;
import com.ait.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }


    public void clickOnLoginLink() {
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillEmailPasswordForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input[value='Log in']"));
    }


    public void clickOnRegisterLink() {
        click(By.cssSelector("a[href='/register']"));
    }

    public void fillRegisterForm(User user) {
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegisterButton() {
        click(By.cssSelector("#register-button"));
    }


    public void clickOnSignOutLink() {
        click(By.cssSelector("a[href='/logout']"));
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

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.cssSelector(".message-error"));
    }
}