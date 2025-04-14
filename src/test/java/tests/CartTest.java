package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends TestBase {

    LoginPage login;
    ProductsPage products;
    CartPage cart;

    @BeforeMethod
    public void setUp() {
        login = new LoginPage(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
    }

    @Test
    public void testAddProductToCart() {
        login.fillUserName("standard_user");
        login.fillUserPassword("secret_sauce");
        login.clickOnLoginButton();

        products.clickOnAddToCartButton(1); // بيضيف أول منتج

        cart.clickOnCartIcon(); // يروح للعربة

        Assert.assertTrue(cart.areCartItemsVisible(), "Product was not added to cart!");
    }

//    @Test
//    public void testRemoveProductFromCart() {
//        login.fillUserName("standard_user");
//        login.fillUserPassword("secret_sauce");
//        login.clickOnLoginButton();
//
//        products.clickOnAddToCartButton(1); // يضيف أول منتج
//
//        cart.clickOnCartIcon(); // يروح للعربة
//
//        Assert.assertTrue(cart.areCartItemsVisible(), "Product not found in cart before removing!");
//
//        products.clickOnRemoveFromCartButton(1); // يشيل نفس المنتج
//
//        Assert.assertFalse(cart.areCartItemsVisible(), "Product was not removed from cart!");
//    }
}

