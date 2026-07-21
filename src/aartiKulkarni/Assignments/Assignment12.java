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
Click on the "Basic Elements" tab to navigate to the corresponding section.
Scroll down to the Multi-Select dropdown.
Select the options '2' and '5' from the dropdown.
Fetch and print all currently selected options in the Console.
Deselect the option '5' from the dropdown.
Fetch and print the updated list of selected options in the Console after deselection.

 */
public class Assignment12 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        WebElement multiselect= driver.findElement(By.xpath("//select[@class='form-control']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select select=new Select(multiselect);
        List<WebElement> selectedOptions;
        if(select.isMultiple()){
            select.selectByVisibleText("2");
            select.selectByVisibleText("5");
            selectedOptions= select.getAllSelectedOptions();
            for(WebElement selectedOption : selectedOptions){
                System.out.println(selectedOption.getText());
            }

            System.out.println(" values are selected ");
            select.deselectByVisibleText("5");
            for(WebElement selectedOption: selectedOptions){
                System.out.println(selectedOption.getText());
            }
        }else{
            System.out.println("List is not Multiselected ");
        }

        driver.quit();

    }
}