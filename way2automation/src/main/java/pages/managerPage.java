package pages;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static java.time.Duration.*;

public class managerPage extends basePage{
    List<WebElement> cellsNumbers;

    public managerPage(WebDriver driver) {
        super(driver);
    }

    /////////web element FOR Add customer form /////////
    By addToCustomerbutton=By.xpath("//button[@ng-class='btnClass1']");
    By firstnameField=By.cssSelector("[ng-model='fName']");
    By lastnameField=By.cssSelector("[ng-model='lName']");
    By postcodeField=By.cssSelector("[ng-model='postCd']");
    By addCustomerButton=By.cssSelector("[type='submit']");

    ////////web element FOR customers form ////////
    By customersButton=By.cssSelector("[ng-click='showCust()']");
    By table=By.xpath(" //table[@class='table table-bordered table-striped']");
    By allrows=By.tagName("tr");
    By columns=By.tagName("td");
    By deleteButton=By.xpath("//button[@ng-click='deleteCust(cust)']");

    /////////web element FOR open account form////////

    By openAccountButton=By.cssSelector("[ng-class='btnClass2']");
    By dropDownLocator=By.id("userSelect");
    By cyrrencyDropDown=By.xpath("//select[@id='currency']");
    By submitButton=By.xpath("//button[@type='submit']");


    //////methods for Add customer form////
    public void goToAddCustomerForm(){
        clickOn(driver,addToCustomerbutton);
    }

    public void sendTxtToFname(){
        setText(driver,firstnameField,"dina");
    }

    public void sendTxtToLname(){
        setText(driver,lastnameField,"Abdallah");
    }

    public void sendTxtToPostCode(){
        setText(driver,postcodeField,"E5645");
    }

    public void addingNewCustomerSuccessfully(){
        clickOn(driver,addCustomerButton);
    }


    /////methods for customers form/////
    public void goToCustomersForm() {

        clickOn(driver, customersButton);
    }
    public int selectRow(){
          List<WebElement>rows= driver.findElements(allrows);
            int myIndex=rows.size()-1;
            return myIndex;
}
    public String getUserContent() {
    List<WebElement>rows= driver.findElements(allrows);
        System.out.println(rows.getLast().getText());
        return rows.getLast().getText();
    }

    public String getAccountNum() {
        List<WebElement>rows= driver.findElements(allrows);
        System.out.println("assertin message: "+rows.getLast().findElements(columns).get(3).getText());
        return rows.getLast().findElements(columns).get(3).getText();
    }

public void deletUser(){
    List<WebElement>delete= driver.findElements(deleteButton);
    delete.getLast().click();
}

    //////methods for open account form/////
    public void goToOpenAccountForm () {

        clickOn(driver, openAccountButton);
    }
    public void selectCustomer () {
        Select selectFromDrobdown = new Select(driver.findElement(dropDownLocator));
        selectFromDrobdown.selectByIndex(selectFromDrobdown.getOptions().size() - 1);
    }

public int generateRandomNum(){
    Random random = new Random();
    int minRange = 0;
    int maxRange = 3;
    int randomNum =random.nextInt(maxRange)+minRange;
            return randomNum;
}
    public void selectCurrency () {
        Select selectrandomcurrenct = new Select(driver.findElement(cyrrencyDropDown));
        selectrandomcurrenct.selectByIndex(generateRandomNum());
       // new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(cyrrencyDropDown));
    }

    public void processNewAccount () {
        clickOn(driver, submitButton);
        new WebDriverWait(driver, ofSeconds(60)).until(ExpectedConditions.alertIsPresent());
    }
}

