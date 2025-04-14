package Helper;

import pages.LoginPage;
import tests.TestBase;

public class LoginHelp {
    LoginPage login = new LoginPage(TestBase.driver);
    public void loginWithValidUserNameAndPassword() {
        login.fillUserName("standard_user");
        login.fillUserPassword("secret_sauce");
        login.clickOnLoginButton();



    }
}
