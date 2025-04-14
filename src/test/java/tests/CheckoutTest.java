package tests;

import Helper.LoginHelp;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends TestBase {
    LoginHelp loginHelp ;
    CheckoutPage checkout;
    CheckoutOverviewPage checkoutOverviewPage;
    ProductsPage product;
    CartPage cartPage;

    @BeforeMethod
    public void setUpData() {

       loginHelp = new LoginHelp();
        checkout = new CheckoutPage(driver);
        checkoutOverviewPage= new CheckoutOverviewPage(driver);
        product = new ProductsPage(driver);
        cartPage = new CartPage(driver);




    }

    @Test
    public void checkoutWithValidFirstNameAndLastNameAndPostalCode() throws InterruptedException {
        loginHelp.loginWithValidUserNameAndPassword();
        Thread.sleep(10000);
        product.clickOnAddToCartButton(1);
        Thread.sleep(6000);
        product.goToCartPage();
        Thread.sleep(10000);
        cartPage.clickOnCheckoutButton();
        Thread.sleep(6000);
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("346");
        checkout.clickOnContinueButton();

        String expectedTitle = "Checkout: Your Information";
        String actualTitle = checkout.getCheckoutInformationTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Not on Checkout Information page");


    }


    @Test
    public void verifyErrorMessageWhenFirstNameIsEmpty() throws InterruptedException {
        checkout.fillFirstName("");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("12345");
        checkout.clickOnContinueButton();

        String expectedText = "Error: First Name is required";
        String actualText = checkout.getFirstNameErrorMessage();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyErrorMessageWhenLastNameIsEmpty() throws InterruptedException {
        checkout.fillFirstName("Randa");
        checkout.fillLastName("");
        checkout.fillPostalCode("12345");
        checkout.clickOnContinueButton();

        String expectedText = "Error: Last Name is required";
        String actualText = checkout.getLastNameErrorMessage();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyErrorMessageWhenPostalCodeIsEmpty() throws InterruptedException {
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("");
        checkout.clickOnContinueButton();

        String expectedText = "Error: Postal Code is required";
        String actualText = checkout.getPostalCodeErrorMessage();
        Assert.assertEquals(actualText, expectedText);
    }

//    @Test
//    public void verifyFunctionalityOfTheCancelButtonOnTheCheckoutPage() {
//        CartPage cartPage = checkout.goToCartPageFromCheckout(); //
//
//        String expectedTitle = "Your Cart";
//        String actualTitle = cartPage.getCartTitleText();
//        Assert.assertEquals(actualTitle, expectedTitle);
//    }

}
