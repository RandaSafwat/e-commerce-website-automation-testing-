package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userName = By.xpath("//input[@name=\"user-name\"]");
    By password = By.xpath("//input[@name=\"password\"]");
    By loginButton = By.xpath("//input[@name=\"login-button\"]");
    By requiredErrorMessage = By.xpath("//div[@class=\"error-message-container error\"]"); //both of user & password



    private String userLockedExpectedResult = "Epic sadface: Sorry, this user has been locked out.";
    private String invalidUserAndValidPasswordExpectedResult = "Epic sadface: Username and password do not match any user in this service";
    private String validUserEmptyPasswordExpectedResult = "Epic sadface: Password is required";
    private String emptyUserAndPasswordExpectedResult = "Epic sadface: Username is required";


    // Getters

    public String getUserLockedExpectedResult() {
        return userLockedExpectedResult;
    }
    public String getInvalidUserAndValidPasswordExpectedResult() {
        return invalidUserAndValidPasswordExpectedResult;
    }
    public String getValidUserEmptyPasswordExpectedResult() {
        return validUserEmptyPasswordExpectedResult;
    }
    public String getEmptyUserAndPasswordExpectedResult() {
        return emptyUserAndPasswordExpectedResult;
    }

    // Actions

    public void fillUserName(String username) {
        fillElement(userName, username);
    }

    public void fillUserPassword(String password) {
        fillElement(this.password, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String requiredErrorMessageActualResult() {
        return getElementText(requiredErrorMessage);
    }

}