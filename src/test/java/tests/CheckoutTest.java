package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.CheckoutOverviewPage;

public class CheckoutTest extends TestBase {
    CheckoutPage checkout;
    CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod
    public void setUpData() {
        checkout = new CheckoutPage(driver);
    }

    @Test
    public void checkoutWithValidFirstNameAndLastNameAndPostalCode() {
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("346");
        checkout.clickOnContinueButton();

        checkoutOverviewPage = checkout.goToCheckoutOverview();

        String expectedText = "Checkout: Overview";

        String actualText = checkoutOverviewPage.getCheckoutOverviewText();
        Assert.assertEquals(actualText, expectedText);


    }
//    @Test
//    public void verifyThatPostalCodeAcceptsOnlyNumbers(){
//        checkout.fillFirstName("Randa");
//        checkout.fillLastName("Safwat");
//        checkout.fillPostalCode("asdf");
//        checkout.clickOnContinueButton();
//
//        String expectedText = "Please enter numbers only in the postal code field";
//        String actualText = checkoutOverviewPage.getCheckoutOverviewText();
//        Assert.assertEquals(actualText, expectedText);
//
//    }

    @Test
    public void verifyErrorMessageWhenFirstNameIsEmpty() {
        checkout.fillFirstName("");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("12345");
        checkout.clickOnContinueButton();

        String expectedText = "Error: First Name is required";
        String actualText = checkout.getFirstNameErrorMessage();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyErrorMessageWhenLastNameIsEmpty() {
        checkout.fillFirstName("Randa");
        checkout.fillLastName("");
        checkout.fillPostalCode("12345");
        checkout.clickOnContinueButton();

        String expectedText = "Error: Last Name is required";
        String actualText = checkout.getLastNameErrorMessage();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyErrorMessageWhenPostalCodeIsEmpty() {
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
