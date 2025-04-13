package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.CheckoutPage;

public class ProductTest extends TestBase {

    ProductPage productPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void addItemToCartAndProceedToCheckout() throws InterruptedException {
        // إضافة المنتج إلى السلة
        productPage.clickAddToCart();

        // الضغط على أيقونة السلة
        productPage.clickCartIcon();

        // التوجه إلى صفحة التشيك أوت
        productPage.clickOnCheckoutButton();

        // التأكد من الانتقال إلى صفحة التشيك أوت
        Thread.sleep(2000); // تأكد من أن الصفحة تم تحميلها
        String actualResult = checkoutPage.getCheckoutActualResult();
        String expectedResult = checkoutPage.getCheckoutExpectedResult();

        Assert.assertEquals(actualResult, expectedResult, "Checkout page is not displayed correctly!");
    }
}

