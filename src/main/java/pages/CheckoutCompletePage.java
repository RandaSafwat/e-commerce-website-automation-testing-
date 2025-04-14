package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends PageBase{


    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    By CheckoutCompleteText =By.cssSelector("[data-test='title']");

    public String getCompleteMessageText() {
        return getElementText(CheckoutCompleteText);
    }

}
