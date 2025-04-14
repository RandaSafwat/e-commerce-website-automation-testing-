package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
     WebDriver driver;

    public static long WAIT = 60;
    public PageBase(WebDriver driver){
        this.driver =driver;
    }
    public void waitForElementToBePresent( By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable( By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeVisible( By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOnElement(By locator){
        waitForElementToBeVisible(locator);
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    public void fillElement(By locator,String value){
        driver.findElement(locator).sendKeys(value);
    }

    public String getElementText(By locator){
        waitForElementToBeVisible(locator);
       return driver.findElement(locator).getText();
    }

    public void waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }






}
