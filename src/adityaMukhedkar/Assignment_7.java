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

package adityaMukhedkar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_7 {

    @Test
    public void checkCheckBox() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        String URL = "http://automationbykrishna.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        System.out.println("--------Ass7 -> click on  basic elements tab----");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//label[@class='col-sm-2 control-label col-lg-2'][1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        String CheckText = element.getText();
        String Expected_Text = "Checkboxes and radios";

        Assert.assertEquals(CheckText, Expected_Text);
        System.out.println("Before click----------->");
        WebElement element1 = driver.findElement(By.xpath("//div[@class='col-lg-10']//div[@class='checkbox'][2]"));
        boolean check = element1.isSelected();
        if (check==true) {
            System.out.println("element is checked");
        }else
            System.out.println("element is not checked");
        System.out.println("After click----------->");
        //element1.click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
        boolean check1 = element1.isSelected();
        if (check1==true) {
            System.out.println("element is checked");
        }else
            System.out.println("element is not checked");


    }
}
