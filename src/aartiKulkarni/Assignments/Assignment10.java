package aartiKulkarni.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Selects" section dropdown perform the following activities:-

Select the option with number '3' from the dropdown

Use the isSelected() method to confirm whether the intended dropdown option is currently selected or not

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable elemment is currently selected else not selected.

 */
public class Assignment10 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("//a[@id='basicelements']")).click();
        Thread.sleep(2000);
        WebElement dropDown1=driver.findElement(By.id(""));
        WebElement dropDown2=driver.findElement(By.id(""));
        WebElement dropDown3=driver.findElement(By.id(""));
        WebElement dropDown4=driver.findElement(By.id(""));
        WebElement dropDown5=driver.findElement(By.id(""));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" , dropDown3);
        dropDown3.click();

        if(dropDown3.isSelected()){
            System.out.println("Test Case Passed - dropDown3 selected" );
        }
        driver.quit();
    }
}
