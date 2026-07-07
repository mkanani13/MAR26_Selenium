package vishwajeetLoni.Assignments;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Scroll down the page and in the "Checkbox and radios" section perform the following activities:-
//
//Select the checkbox
//"Option one is this and that—be sure to include why it's great option one"
//
//Use the isSelected() method to confirm whether the checkbox is currently selected or not.
//
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

public class Assignment7_CheckBox {

    @Test
    public void checkBox(){

        WebDriver driver;
        driver = ActionOnBrowser.start();

        driver.findElement(By.id("basicelements")).click(); // click on Basic elements tab

        System.out.println("Step 2 - Scroll till the Checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='col-lg-10']/div[@class='checkbox'][2]/label/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

        System.out.println("Step 3 - Tick the checkbox");
        checkbox.click();
        System.out.println("Checkbox click");

        System.out.println("Step 4 - Verify if checkbox is selected or not");
        Assert.assertTrue(checkbox.isSelected());


    }
//    public static void main(String[] args) throws InterruptedException {
//
//        System.out.println("Step 1 - Launch browser");
//        WebDriver driver = new ChromeDriver();  // open browser
//        driver.manage().window().maximize();
//        driver.get("http://automationbykrishna.com/"); // open website
//        driver.findElement(By.id("basicelements")).click(); // click on Basic elements tab
//
//        Thread.sleep(1000);
//
//        System.out.println("Step 2 - Scroll till the Checkboxes");
//        WebElement checkbox = driver.findElement(By.xpath("//div[@class='col-lg-10']/div[@class='checkbox'][2]/label/input"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
//
//        System.out.println("Step 3 - Tick the checkbox");
//        checkbox.click();
//        System.out.println("Checkbox click");
//
//        System.out.println("Step 4 - Verify if checkbox is selected or not");
//        if (checkbox.isSelected()){
//            System.out.println("Check box is selected");
//        }else {
//            System.out.println("Checkbox is not selected");
//        }
//
//    }

}
