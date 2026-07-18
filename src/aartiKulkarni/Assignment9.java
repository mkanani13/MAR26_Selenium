package aartiKulkarni;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Inline checkboxes" section perform the following activities:-

Select the checkbox with number '1'

Use the isSelected() method to confirm whether the intended checkbox is currently selected or not.

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable elemment is currently selected else not selected.

 */
public class Assignment9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);
        WebElement checkBox1= driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        WebElement checkBox2= driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        WebElement checkBox3= driver.findElement(By.xpath("//input[@id='inlineCheckbox3']"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",checkBox1);
        Thread.sleep(2000);
        checkBox1.click();

        if(checkBox1.isSelected()){
            System.out.println("Test Case passed - CheckBox 1 selected ");
        }
        else
            System.out.println("Test case - Failed ");
        driver.quit();
    }
}
