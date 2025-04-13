package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    By checkoutText = By.cssSelector("[data-test='title']");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By cancelButton = By.id("cancel");

    public void fillFirstName(String firstName) {
        fillElement(this.firstName, firstName);
    }

    public void fillLastName(String lastName) {
        fillElement(this.lastName, lastName);
    }

    public void fillPostalCode(String postalCode) {
        fillElement(this.postalCode, postalCode);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void clickOnCancelButton() {
        clickOnElement(cancelButton);
    }

    public String checkoutExpectedResult = "Checkout: Your Information";

    public String getCheckoutExpectedResult() {
        return checkoutExpectedResult;
    }

    public String getCheckoutActualResult() {
        return getElementText(checkoutText);
    }
}

