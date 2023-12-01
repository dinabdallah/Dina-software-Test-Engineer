package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class testBase {
    public WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})

    public void setupdriver(@Optional("chrome") String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();}
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();}
        else if(browserName.equalsIgnoreCase("internetExplorer")){
            driver=new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/protractor-angularjs-practice-website.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
   /* @AfterClass
    public void closedriver(){
        driver.quit();
    }*/
}

