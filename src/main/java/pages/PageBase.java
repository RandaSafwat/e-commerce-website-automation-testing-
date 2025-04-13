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
    public void waitForElementToBePresent( By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitForElementToBeClickable( By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible( By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickOnElement(By element){
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        driver.findElement(element).click();
    }

    public void fillElement(By element,String value){
        driver.findElement(element).sendKeys(value);
    }

    public String getElementText(By element){
        waitForElementToBeVisible(element);
       return driver.findElement(element).getText();
    }






}
