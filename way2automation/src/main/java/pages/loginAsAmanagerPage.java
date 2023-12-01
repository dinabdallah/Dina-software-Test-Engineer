package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginAsAmanagerPage extends basePage{
    public loginAsAmanagerPage(WebDriver driver) {
        super(driver);
    }
    By bankManagerLoginLink= By.cssSelector("[ng-click=\"manager()\"]");

    public void clickOnBankManagerLogin(){
        clickOn(driver,bankManagerLoginLink);
    }

}
