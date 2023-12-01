package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends basePage{

         //WEB ELEMENTS////
    public homePage(WebDriver driver) {
        super(driver);
    }
   By bankingLink=By.xpath("//img[@alt='banking']");


           //METHODS////
    public loginAsAmanagerPage clickOnBankingLink(){
        clickOn(driver,bankingLink);
        return  new loginAsAmanagerPage(driver);
    }

}
