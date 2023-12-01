package Utilities;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;

public class Utilities {
    public static String getCurrentWindowHandle(WebDriver driver)
    {
        return driver.getWindowHandle();
    }
    public static void switchWindow(WebDriver driver,String firstHandle)
    {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles)
        {
            if (!handle.equals(firstHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
