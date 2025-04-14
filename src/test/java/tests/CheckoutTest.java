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
    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void setUpData() {

       loginHelp = new LoginHelp();
        checkout = new CheckoutPage(driver);
        checkoutOverviewPage= new CheckoutOverviewPage(driver);
        product = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);




    }

    @Test
    public void checkoutWithValidFirstNameAndLastNameAndPostalCode() throws InterruptedException {
        // Step 1: Login
        loginHelp.loginWithValidUserNameAndPassword();
        Thread.sleep(5000);
        // Step 2: Add two products to cart
        product.clickOnAddToCartButton(0); // أول منتج
        Thread.sleep(5000);
        product.clickOnAddToCartButton(1); // ثاني منتج
        Thread.sleep(5000);
        // Step 3: Go to cart
        product.goToCartPage();
        Thread.sleep(5000);
        // Step 4: Remove one product (وليكن الأول)
//        product.clickOnRemoveFromCartButton(0);
//        Thread.sleep(5000);
        // Step 5: Click on checkout
        cartPage.waitForCheckoutButtonToBeVisible();
        cartPage.clickOnCheckoutButton();
        Thread.sleep(5000);
        // Step 6: Fill user data
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("346");
        checkout.clickOnContinueButton();
        Thread.sleep(3000);
        String expectedTitle = "Checkout: Overview";
        String actualTitle = checkout.getCheckoutInformationTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Not on Checkout Overview page");
        checkoutOverviewPage.clickOnFinishButton();
        Thread.sleep(1000);

        // Step 9: Assert you reached Checkout Complete
        String completeText = checkoutCompletePage.getCompleteMessageText();
        Assert.assertEquals(completeText, "Checkout: Complete", "Checkout not completed successfully");
    }


    @Test
    public void verifyErrorMessageWhenFirstNameIsEmpty() throws InterruptedException {
        // Step 1: Login
        loginHelp.loginWithValidUserNameAndPassword();
        Thread.sleep(5000);
        // Step 2: Add two products to cart
        product.clickOnAddToCartButton(0); // أول منتج
        Thread.sleep(5000);
        product.clickOnAddToCartButton(1); // ثاني منتج
        Thread.sleep(5000);
        // Step 3: Go to cart
        product.goToCartPage();
        Thread.sleep(5000);
        // Step 4: Remove one product (وليكن الأول)
//        product.clickOnRemoveFromCartButton(0);
//        Thread.sleep(5000);
        // Step 5: Click on checkout
        cartPage.waitForCheckoutButtonToBeVisible();
        cartPage.clickOnCheckoutButton();
        Thread.sleep(5000);
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("346");
        checkout.clickOnContinueButton();
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
        loginHelp.loginWithValidUserNameAndPassword();
        Thread.sleep(10000);
        product.clickOnAddToCartButton(1);
        Thread.sleep(10000);
        product.goToCartPage();
        Thread.sleep(10000);
        cartPage.clickOnCheckoutButton();
        Thread.sleep(10000);
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("346");
        checkout.clickOnContinueButton();
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("");
        checkout.clickOnContinueButton();

        String expectedText = "Error: Postal Code is required";
        String actualText = checkout.getPostalCodeErrorMessage();
        Assert.assertEquals(actualText, expectedText);
    }


    @Test
    public void verifyFunctionalityOfTheCancelButtonOnTheCheckoutPage() throws InterruptedException {
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
        CartPage cartPage = checkout.goToCartPageFromCheckout();
        String expectedTitle = "Your Cart";
        String actualTitle = cartPage.getCartTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "The title is not as expected!");
    }

}
