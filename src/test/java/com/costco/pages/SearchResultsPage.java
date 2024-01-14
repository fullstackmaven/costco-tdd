package com.costco.pages;

import com.costco.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private final WebDriver driver;
    private final By weFoundLocator = By.id("rsltCntMsg");
    private final By productCardsLocator = By.cssSelector(".product-list>div"); // a lot of elements
    private final By shoppingCartIconLocator = By.cssSelector("#cart-d");
    private final By itemInCartMessageLocator = By.cssSelector("[id^='item-in-cart']");


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getWeFoundText() {
        WebElement weFoundElement = waitUntilElementIsVisible(weFoundLocator);
        return weFoundElement.getText();
    }

    public void clickOnProductFromProductList(int index) {
        List<WebElement> productCards = waitUntilAllElementsPresent(productCardsLocator);
        WebElement productCard = productCards.get(index);
        WebElement addToCartButton = productCard.findElement(By.cssSelector("[id^='addButton']"));
        addToCartButton.click();
    }

    public void waitUntilElementIsAddedToCart() {
        waitUntilElementIsVisible(itemInCartMessageLocator);
    }

    public void clickOnCartIcon() {
        WebElement shoppingCart = driver.findElement(shoppingCartIconLocator);
        shoppingCart.click();
    }

}
