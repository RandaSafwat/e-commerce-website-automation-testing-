package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTests extends TestBase {

    public ProductsTests(WebDriver driver) {

    }
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
}

