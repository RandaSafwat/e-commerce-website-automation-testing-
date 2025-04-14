package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {

    // Locators

    By cartItems = By.xpath("//div[@class='cart_item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    By YourCart = By.className("title");


    public String getCartTitleText() {
        return getElementText(YourCart);
    }

    // Methods
    public boolean areCartItemsVisible() {
        return driver.findElements(cartItems).size() > 0;
    }
    By cartIcon = By.className("shopping_cart_link");
    By checkoutButton = By.id("checkout");
    By removeButton = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");


    public void clickOnCartIcon() {
        clickOnElement(cartIcon);
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
    }

    public void waitForCheckoutButtonToBeVisible() {
        waitForElementToBeVisible(checkoutButton);
    }


    public void goToCheckoutPage() {
        clickOnCartIcon();
        clickOnCheckoutButton();
    }
    public CartPage goToCartPageFromCheckout() {
        clickOnCartIcon();
        return new CartPage(driver);
    }

}
