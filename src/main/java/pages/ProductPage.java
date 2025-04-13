package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase {

    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By checkoutButton = By.id("checkout");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        clickOnElement(addToCartButton);
    }

    public void clickCartIcon() {
        clickOnElement(cartIcon);  // هذه الخطوة ستوجهك إلى صفحة السلة
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);  // بعد إضافة العناصر، يمكنك النقر على Checkout هنا
    }
}
