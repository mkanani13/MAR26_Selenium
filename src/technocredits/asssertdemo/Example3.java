package technocredits.asssertdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import technocredits.technoapp.base.BrowserActions;

public class Example3 {

    @Test
    public void verifyDemoTablePage(){
        System.out.println(System.getProperty("user.dir"));
        SoftAssert softAssert = new SoftAssert();

        System.out.println("STEP - Launch browser & Load URL");
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to DemoTables");
        driver.findElement(By.linkText("Demo Tables")).click();

        System.out.println("VERIFY - number of tables in the page");
        int actualTableCount = driver.findElements(By.xpath("//table")).size();
        softAssert.assertEquals(actualTableCount, 4);

        System.out.println("VERIFY - Header of the first table is as expected");
        String firstTableActualHeaderText = driver.findElement(By.xpath("//div[@id='empbasic']/section/header")).getText();
        softAssert.assertTrue(firstTableActualHeaderText.contains("EMPLOYEE BASIC INFORMATION"), "expected was Employee Basic Information but found " + firstTableActualHeaderText);

        System.out.println("VERIFT - Header of the second table is expected");
        String secondTableActualHeaderText = driver.findElement(By.xpath("//div[@id='empmanager']/section/header")).getText();
        softAssert.assertEquals(secondTableActualHeaderText.trim(),"EMPLOYEE MANAGER");

        softAssert.assertAll();
        System.out.println("end");
    }
}
