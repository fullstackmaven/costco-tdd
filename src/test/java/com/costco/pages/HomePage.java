package com.costco.pages;

import com.costco.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final WebDriver driver;
    private final By searchBoxLocator = By.id("search-field");
    private final By autoSuggestionBoxLocator = By.cssSelector(".tt-menu");
    private final By searchIconLocator = By.cssSelector(".btn.search-ico-button");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchForItem(String key) {
        WebElement searchBox = waitUntilElementIsVisible(searchBoxLocator);
        searchBox.sendKeys(key);

        WebElement searchIcon = waitUntilElementIsVisible(searchIconLocator);
        searchIcon.click();
    }

    public void enterSearchKeyIntoSearchBox(String key) {
        WebElement searchBox = waitUntilElementIsVisible(searchBoxLocator);
        searchBox.sendKeys(key);
    }

    public boolean isAutoSuggestionBoxDisplayed() {
        WebElement autoSuggestionBox = waitUntilElementIsVisible(this.autoSuggestionBoxLocator);
        return autoSuggestionBox.isDisplayed();
    }


}
