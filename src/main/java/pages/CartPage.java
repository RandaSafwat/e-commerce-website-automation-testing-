package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {

    // Locators
    By cartItems = By.xpath("//div[@class='cart_item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    public boolean areCartItemsVisible() {
        return driver.findElements(cartItems).size() > 0;
    }
    By cartIcon = By.className("shopping_cart_link");
    By checkoutButton = By.id("checkout");

    public void clickOnCartIcon() {
        clickOnElement(cartIcon); // بيستخدم الانتظار الجاهز من PageBase
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);// نفس الكلام
    }

    public void waitForCheckoutButtonToBeVisible() {
        waitForElementToBeVisible(checkoutButton); // دي موجودة في PageBase
    }

    public void goToCheckoutPage() {
        clickOnCartIcon();
        clickOnCheckoutButton();
    }
}
