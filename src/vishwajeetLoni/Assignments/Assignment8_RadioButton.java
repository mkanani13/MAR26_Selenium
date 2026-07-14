package vishwajeetLoni.Assignments;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Scroll down the page and in the "Checkbox and radios" section perform the following activities:-
//
//Select the radiobutton
//Option two can be something else and selecting it will deselect option one
//
//Use the isSelected() method to confirm whether the intended radiobutton is currently selected or not.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.time.Duration;

public class Assignment8_RadioButton {

    @Test
    public void radioButton(){

        WebDriver driver;
        driver = ActionOnBrowser.start();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Step 1 - Launch browser");
        driver.findElement(By.id("basicelements")).click(); // click on Basic elements tab

        System.out.println("Step 2 - Scroll till the Radiobtns");

        WebElement radiobtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='optionsRadios2']")));
//        WebElement radiobtn = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radiobtn);

        System.out.println("Step 3 - Click the radiobtn");
        radiobtn.click();
        System.out.println("Radiobtn clicked");

        System.out.println("Step 4 - Verify if radiobtn is selected or not");
        Assert.assertTrue(radiobtn.isSelected());

    }

//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Step 1 - Launch browser");
//        WebDriver driver = new ChromeDriver();  // open browser
//        driver.manage().window().maximize();
//        driver.get("http://automationbykrishna.com/"); // open website
//        driver.findElement(By.id("basicelements")).click(); // click on Basic elements tab
//
//        Thread.sleep(1000);
//
//        System.out.println("Step 2 - Scroll till the Radiobtns");
//        WebElement radiobtn = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", radiobtn);
//
//        System.out.println("Step 3 - Click the radiobtn");
//        radiobtn.click();
//        System.out.println("Radiobtn clicked");
//
//        System.out.println("Step 4 - Verify if radiobtn is selected or not");
//        if (radiobtn.isSelected()){
//            System.out.println("Radiobtn is selected");
//        }else {
//            System.out.println("Radiobtn is not selected");
//        }
//
//    }
}
