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

Scroll down the page and in the "Checkbox and radios" section perform the following activities:-

Select the radiobutton
Option two can be something else and selecting it will deselect option one

Use the isSelected() method to confirm whether the intended radiobutton is currently selected or not.

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable elemment is currently selected else not selected.

 */
public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(2000);
        WebElement radioButton1=driver.findElement(By.xpath("//input[@id='optionsRadios1']"));
        WebElement radioButton2=driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radioButton1);
        Thread.sleep(2000);
        radioButton1.click();

        if(radioButton1.isSelected()) {
            System.out.println(" RadioButton1 clicked");
            if (!radioButton2.isSelected()) {
                System.out.println(" Test Case -Passed RadioButton1 clicked - RadioButton2 Unclicked");
            } else {
                System.out.println(" Test Case -Failed  ");
            }
        }
        else{
            if(radioButton2.isSelected()){
                System.out.println(" Test Case -Passed  RadioButton2 clicked - radioButton1 unclicked");
            }
        }
        driver.quit();
        }

    }

