package com.costco.smoke_tests;

import com.costco.base.BaseTest;
import com.costco.pages.HomePage;
import com.costco.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchFeatureTests extends BaseTest {


    @Test
    public void testSearchResultIsReturned() {

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.searchForItem("milk");

        String text = searchResultsPage.getWeFoundText();
        Assert.assertTrue(text.startsWith("We found"));

    }

    @Test
    public void testSearchBarAutoSuggestionIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchKeyIntoSearchBox("candle");

        boolean result = homePage.isAutoSuggestionBoxDisplayed();
        Assert.assertTrue(result);

    }


}
