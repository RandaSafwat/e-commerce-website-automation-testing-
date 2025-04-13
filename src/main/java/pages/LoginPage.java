package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{



    By userName =By.id("user-name");
    By password =By.id("password");
    By loginButton =By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String username){
        fillElement(userName,username);
    }
    public void fillUserPassword(String password){
        fillElement(this.password,password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
}
