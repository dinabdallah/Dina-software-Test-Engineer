package tests;
import Utilities.Utilities;
import jdk.jshell.execution.Util;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.managerPage;
import pages.homePage;
import pages.loginAsAmanagerPage;
import static org.testng.Assert.assertNotEquals;

public class testManagerPage extends testBase{
    String beforeDelete;
    @Test(priority = 1)
    public void gotoBankingSuccessfully(){

        new homePage(driver).clickOnBankingLink();
    }

    @Test(priority = 2)
    public void login() {
        String firstHandle = Utilities.getCurrentWindowHandle(driver);
        Utilities.switchWindow(driver,firstHandle);
        new loginAsAmanagerPage(driver).clickOnBankManagerLogin();
    }
    @Test(priority = 3)
        public void goToaddingCustomerPage(){
        new managerPage(driver).goToAddCustomerForm();
    }
    @Test(priority = 4)
    public void addingCustomer() {
        new managerPage(driver).sendTxtToFname();
        new managerPage(driver).sendTxtToLname();
        new managerPage(driver).sendTxtToPostCode();
        new managerPage(driver).addingNewCustomerSuccessfully();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        //System.out.println("alertText is:" + alertText);
        alert.accept();
        new managerPage(driver).goToCustomersForm();
        String actual= String.valueOf(new managerPage(driver).selectRow());
        //System.out.println(actual);
        Assert.assertEquals(true,alertText.contains(actual));
       String beforeDelete= new managerPage(driver).getUserContent();
        }
        @Test(priority = 5)
                public void openningAcoount(){
            new managerPage(driver).goToOpenAccountForm();
            new managerPage(driver).selectCustomer();
            new managerPage(driver).selectCurrency();
            new managerPage(driver).processNewAccount();
           // new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("alert text: "+alertText);
            alert.accept();
            new managerPage(driver).goToCustomersForm();
           String assertionMsg= new managerPage(driver).getAccountNum();
            Assert.assertEquals(true,alertText.contains(assertionMsg));
        }
    @Test(priority = 6)
    public void deletingUser(){
        new managerPage(driver).deletUser();
     //int afterDelete=new managerPage(driver).selectRow();
      String  afterDelete=new managerPage(driver).getUserContent();
        assertNotEquals("Strings are not equal", afterDelete, beforeDelete);
      //Assert.assertNEquals(afterDelete,beforeDelete);
    }
    }


