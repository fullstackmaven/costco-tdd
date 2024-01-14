package com.costco.smoke_tests;

import com.costco.base.BaseTest;
import com.costco.pages.ProductDetailsPage;
import com.costco.pages.SearchResultsPage;
import com.costco.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTest {


    @Test
    public void testAddToCartFromSearchResultsPage() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String searchQuery = "CatalogSearch?keyword=milk";
        navigateToSpecificPageByUrl(searchQuery);

        searchResultsPage.clickOnProductFromProductList(0);
        searchResultsPage.waitUntilElementIsAddedToCart();

        searchResultsPage.clickOnCartIcon();

        String cartItemQuantityText = shoppingCartPage.getCartItemQuantity();
        Assert.assertTrue(cartItemQuantityText.contains("1"));
    }

    @Test
    public void testAddToCartFromProductDetailsPage() throws InterruptedException {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        String productId = "2c-12-count.product.100456512.html";
        navigateToSpecificPageByUrl(productId);

        productDetailsPage.addItemToCart();
        Thread.sleep(15000);

        String modalTitle = productDetailsPage.getAddedToCartModalTitle();
        Assert.assertEquals(modalTitle, "Added to Cart");
    }

    private void navigateToSpecificPageByUrl(String url) {
        String currentUrl = driver.getCurrentUrl();
        String searchResultPageUrl = currentUrl + url;
        driver.navigate().to(searchResultPageUrl);
    }


}
