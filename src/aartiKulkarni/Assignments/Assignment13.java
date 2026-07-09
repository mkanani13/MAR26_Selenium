package aartiKulkarni.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Basic Elements" tab to navigate to the Basic Elements section.
Scroll down until the Multi-Select dropdown is visible on the page.
Select the options '2' and '5' from the multi-select dropdown.
Retrieve and print all selected options in the Console.
Deselect the option '5' and print the updated selected options in the Console.
Deselect the option '2' and print the updated selected options in the Console again.

 */
public class Assignment13 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement multiselect= driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select=new Select(multiselect);
        if(select.isMultiple()){
            select.selectByVisibleText("1");
            select.selectByVisibleText("2");
            select.selectByVisibleText("5");

            List<WebElement> selectedOptions= select.getAllSelectedOptions();
            for(WebElement selectedOption:selectedOptions){
                System.out.println(selectedOption.getText());
            }
            select.deselectByVisibleText("2");
            select.deselectByVisibleText("5");
            selectedOptions = select.getAllSelectedOptions();
            System.out.println("After deselection ");
            for(WebElement deselectedList:selectedOptions){
                System.out.println(deselectedList.getText());
            }



        }
        driver.quit();

    }
}