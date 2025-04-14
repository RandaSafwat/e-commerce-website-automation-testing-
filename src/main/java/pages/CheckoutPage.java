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
    By firstNameErrorMessage = By.xpath("//h3[contains(text(),'First Name is required')]");
    By lastNameErrorMessage = By.xpath("//h3[contains(text(),'Last Name is required')]");
    By postalCodeErrorMessage = By.xpath("//h3[contains(text(),'Postal Code is required')]");
    By cartButton = By.id("shopping_cart_container");
    By checkoutInfoTitle = By.className("title");  // نفس الكلاس اللي بيظهر فيه عنوان الصفحة


    public String getFirstNameErrorMessage() {
        return getElementText(firstNameErrorMessage);
    }

    public String getLastNameErrorMessage() {
        return getElementText(lastNameErrorMessage);
    }

    public String getPostalCodeErrorMessage() {
        return getElementText(postalCodeErrorMessage);
    }



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

    public String getCheckoutInformationTitle() {
        return driver.findElement(checkoutInfoTitle).getText();
    }







}

