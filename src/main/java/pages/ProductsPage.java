package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class ProductsPage extends PageBase {


    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    // Locators
    By productNames = By.xpath("//div[@class='inventory_item_name']");
    By productPrices = By.xpath("//div[@class='inventory_item_price']");
    By addToCartButtons = By.xpath("//button[contains(text(), 'Add to cart')]");
    By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
    By cartItems = By.xpath("//div[@class='cart_item']");

    // Methods
    public boolean areProductNamesVisible() {
        List<String> names = driver.findElements(productNames).stream().map(WebElement::getText).toList();
        return !names.contains("");
    }


    public boolean areProductPricesVisible() {
        List<String> prices = driver.findElements(productPrices).stream().map(WebElement::getText).toList();
        return !prices.contains("");
    }

    public boolean areAddToCartButtonsVisibleAndClickable() {
        return driver.findElements(addToCartButtons).stream().allMatch(e -> e.isDisplayed() && e.isEnabled());
    }
    public void clickOnAddToCartButton(int index) {
        waitForElementToBeClickable(addToCartButtons);
        driver.findElements(addToCartButtons).get(index).click();
    }

    public void goToCartPage() {
        clickOnElement(cartIcon);
    }
    public boolean areCartItemsVisible() {
        waitForElementVisibility(cartItems); // انتظر حتى تظهر العناصر في العربة
        return driver.findElements(cartItems).size() > 0; // تحقق من وجود عناصر
    }

    By productsText = By.xpath("//span[@class=\"title\"]");
    private String productsExpectedResult= "Products";

    public String getProductsExpectedResult() {
        return productsExpectedResult;
    }
    // Actions
    public String productsTextActualResult(){
        return getElementText(productsText);
    }

//    public void clickOnRemoveFromCartButton(int index) {
//        List<WebElement> removeButtons = driver.findElements(By.xpath("//*[@class='btn btn_secondary btn_small cart_button']"));
//
//        // تحقق إذا كان الـ index ضمن حجم القائمة
//        if (index >= 0 && index < removeButtons.size()) {
//            removeButtons.get(index).click();
//        } else {
//            System.out.println("Index out of bounds: " + index);
//        }
//    }



}

