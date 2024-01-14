package com.costco.pages;

import com.costco.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {
    private final WebDriver driver;
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private final By cartItemQuantityLocator = By.cssSelector("#items-quantity-title");

    public String getCartItemQuantity() {
        WebElement cartItemQuantity = waitUntilElementIsVisible(cartItemQuantityLocator);
        return cartItemQuantity.getText();
    }

}
