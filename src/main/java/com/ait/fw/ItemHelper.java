package com.ait.fw;

import com.ait.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(1).click();
        pause(3000);
    }

    public void openCart() {
        driver.get("https://demowebshop.tricentis.com/cart");
        pause(2000);
    }

    public boolean isCartNotEmpty() {
        return isElementPresent(By.cssSelector(".product-name"));
    }
}
