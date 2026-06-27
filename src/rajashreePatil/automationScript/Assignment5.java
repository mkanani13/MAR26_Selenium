/*Selenium Assignment - 5: 10th June'2026
Write a Selenium WebDriver automation script in Java to perform the following steps:


        1. Launch the application: http://automationbykrishna.com/
        2. Click on the “Basic Elements” tab.
3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
4. Handle the JavaScript confirmation alert that appears.
5. Read the alert message and accept it by clicking “OK”.
        6. Verify that the confirmation message displayed on the page is:

        "You pressed OK!"*/

package rajashreePatil.automationScript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Assignment5 {
    static void alertOnBasicElementsPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",alertBtn);
        alertBtn.click();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        String actualAlertText = alert.getText();
        Thread.sleep(1000);
        alert.dismiss();
        String expectedTextAfterAlertAction = "You pressed Cancel!";
        Thread.sleep(1000);
        WebElement actualTextAfterAlert = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
        String actualTextAfterAlertAction= actualTextAfterAlert.getText();
        System.out.println("Expected: " +expectedTextAfterAlertAction);
        System.out.println("Actual: " +actualTextAfterAlertAction);

        /*if(expectedTextAfterAlertAction.equals(actualTextAfterAlertAction)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }*/
        Assert.assertEquals(actualTextAfterAlertAction,expectedTextAfterAlertAction);
        driver.quit();

    }
    List <String> getListOfEmp(String dept){
        WebDriver driver = null;
        List<WebElement> listOfEmp = driver.findElements(By.xpath("//td[text()='"+dept+"']/preceding-sibling::td[2]"));

        List<String> empNames = new ArrayList<String>();

        for(WebElement empName : listOfEmp){
            empNames.add(empName.getText());
        }
        return empNames;
    }
    @Test
    public void verifyConfirmationText() throws InterruptedException {
        Assignment5 assignment5 = new Assignment5();
        assignment5.alertOnBasicElementsPage();
    }
}
//write a method to find duplicate entries