package aartiKulkarni.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Enter values in:
FirstName field
LastName field
CompanyName field

Click on the Submit button.
Alert message should pop-up "FirstName and LastName and CompanyName"

 */
public class SelAssignment3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        String name="Aarti" , password="Aarti@1110" , companyName="Infosys";

        driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyName);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        Alert alert=driver.switchTo().alert();
        String actualMessage=alert.getText();
        alert.sendKeys(name+" and "+ password +" and "+companyName);
        Thread.sleep(2000);
        alert.accept();

    }
}
