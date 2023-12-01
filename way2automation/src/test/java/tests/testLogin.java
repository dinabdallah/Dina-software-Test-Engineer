package tests;
import Utilities.Utilities;
import org.testng.annotations.Test;
import pages.homePage;
import pages.loginAsAmanagerPage;

public class testLogin extends testBase{
//homePage homePageObject;

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
}
