package com.costco.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.costco.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void testHomePageLoads() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Welcome to Costco Wholesale");
    }

    @Test
    public void testHomePageHeroAd() {
        WebElement adHero = driver.findElement(By.id("adb-hero-carousel"));
        Assert.assertTrue(adHero.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}












