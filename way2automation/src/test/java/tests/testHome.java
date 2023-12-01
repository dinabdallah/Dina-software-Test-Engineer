package tests;

import org.testng.annotations.Test;
import pages.homePage;

public class testHome extends testBase{

    @Test(priority = 1)
    public void gotoBankingSuccessfully(){
        new homePage(driver).clickOnBankingLink();
    }

}
