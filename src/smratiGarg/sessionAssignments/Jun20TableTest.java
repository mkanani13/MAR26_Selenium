package smratiGarg.sessionAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import smratiGarg.base.BrowserActions;

public class Jun20TableTest {

    @Test
    public void userNameTest(){

        WebDriver driver = BrowserActions.start("http://34.173.201.53/access#/access");
        SoftAssert softAssert = new SoftAssert();


        System.out.println("STEP click demo table");
        driver.findElement(By.linkText("Demo Tables")).click();
//        String userName = "asharma";

            //username - 39WJAEGT2P
            //password - ZJ9KCRZQ






    }



}
