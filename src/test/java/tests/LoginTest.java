package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {

    LoginPage login;

    @BeforeMethod
    public void setUpData(){
        login =new LoginPage(driver);

    }

    @Test
    public void loginWithValidUserNameAndPassword() throws InterruptedException{
        login.fillUserName("standard_user");
        login.fillUserPassword("secret_sauce");
        login.clickOnLoginButton();
        Thread.sleep(5000);


    }
}
