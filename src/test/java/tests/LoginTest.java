package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends TestBase {
    LoginPage login;
    ProductsPage products;

    @BeforeMethod
    public void setUpData() {
        login = new LoginPage(driver);
//        driver.manage().window().maximize();
        products = new ProductsPage(driver);
    }

    @Test
    public void loginWithValidUsernameAndPassword() throws InterruptedException {
        login.fillUserName("standard_user");
        login.fillUserPassword("secret_sauce");
        login.clickOnLoginButton();
        Thread.sleep(5000);
        Assert.assertEquals(products.productsTextActualResult(), products.getProductsExpectedResult());
    }

    @Test
    public void loginWithLockedUser()  {
        login.fillUserName("locked_out_user");
        login.fillUserPassword("secret_sauce");
        login.clickOnLoginButton();
        Assert.assertEquals(login.requiredErrorMessageActualResult(),login.getUserLockedExpectedResult());
    }

    @Test
    public void loginWithInvalidUsernameAndValidPassword() throws InterruptedException {
        login.fillUserName("invalid_user");
        login.fillUserPassword("secret_sauce");
        login.clickOnLoginButton();
        Thread.sleep(5000);
        Assert.assertEquals(login.requiredErrorMessageActualResult(), login.getInvalidUserAndValidPasswordExpectedResult());
    }

    @Test
    public void loginWithValidUsernameAndEmptyPassword() throws InterruptedException {
        login.fillUserName("standard_user");
        login.fillUserPassword("");
        login.clickOnLoginButton();
        Thread.sleep(5000);
        Assert.assertEquals(login.requiredErrorMessageActualResult(), login.getValidUserEmptyPasswordExpectedResult());
    }

    @Test
    public void loginWithEmptyUsernameAndEmptyPassword() throws InterruptedException {
        login.fillUserName("");
        login.fillUserPassword("");
        login.clickOnLoginButton();
        Thread.sleep(5000);
        Assert.assertEquals(login.requiredErrorMessageActualResult(), login.getEmptyUserAndPasswordExpectedResult());
    }

}
