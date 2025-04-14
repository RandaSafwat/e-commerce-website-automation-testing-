package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTests extends TestBase {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        loginPage.fillUserName("standard_user");
        loginPage.fillUserPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void testProductNamesVisibility() {
        Assert.assertTrue(productsPage.areProductNamesVisible(), "One or more product names are empty or invisible.");
    }



    @Test
    public void testProductPricesVisibility() {
        Assert.assertTrue(productsPage.areProductPricesVisible(), "One or more product prices are empty or invisible.");
    }

    @Test
    public void testAddToCartButtonExists() {
        Assert.assertTrue(productsPage.areAddToCartButtonsVisibleAndClickable(), "One or more 'Add to Cart' buttons are not visible or clickable.");
    }
    @Test
    public void testNavigateToCartPageAfterAddingProduct() {
        productsPage.clickOnAddToCartButton(0);
        productsPage.goToCartPage();

        Assert.assertTrue(cartPage.areCartItemsVisible(), "No items found in the cart.");
    }
}

