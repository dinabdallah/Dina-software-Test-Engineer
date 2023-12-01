package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePage {

        protected WebDriver driver;
        public basePage(WebDriver driver){

            this.driver=driver;
        }
        public static void clickOn(WebDriver driver, By locator){
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        }
        public static void setText(WebDriver driver, By locator,String value){
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            driver.findElement(locator).sendKeys(value);
        }
    }
