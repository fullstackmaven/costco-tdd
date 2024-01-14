package com.costco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    private final WebDriver driver;
    private final By addToCartLocator = By.id("add-to-cart-btn");
    private final By modalTitleLocator = By.id("costcoModalTitle");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemToCart() {
        WebElement addToCartButton = driver.findElement(addToCartLocator);
        addToCartButton.click();
    }

    public String getAddedToCartModalTitle() {
        WebElement modalTitleElement = driver.findElement(modalTitleLocator);
        return modalTitleElement.getText();
    }

}
