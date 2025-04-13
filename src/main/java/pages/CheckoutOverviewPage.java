package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends PageBase {

    By checkoutOverviewText = By.cssSelector("[data-test='title']");
    By continueButton = By.id("finish");  //

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }


    public String getCheckoutOverviewText() {
        return getElementText(checkoutOverviewText);
    }


    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}
