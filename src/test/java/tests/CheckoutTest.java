package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends TestBase{
    CheckoutPage checkout;

    @BeforeMethod
    public void setUpData(){
        checkout =new CheckoutPage(driver);

    }
    @Test
    public void checkoutWithValidFirstNameAndLastNameAndPostalCode() throws InterruptedException{
        checkout.fillFirstName("Randa");
        checkout.fillLastName("Safwat");
        checkout.fillPostalCode("346");
        checkout.clickOnContinueButton();
        Thread.sleep(5000);

    }

}
