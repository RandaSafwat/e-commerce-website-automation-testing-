package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();}



}
