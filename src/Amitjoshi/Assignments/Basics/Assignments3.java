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
package Amitjoshi.Assignments.Basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignments3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/index.html ");
        driver.getTitle();
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(2000);

        String FirstName = "Amit";
        String LastName = "Joshi";
        String CompanyName  = "Amoha Recruitment Services ";
        String expectedAlert = FirstName+" and "+LastName +" and "+CompanyName;
        driver.findElement(By.xpath("//*[@id='UserFirstName']")).sendKeys(FirstName);
        driver.findElement(By.xpath("//*[@id='UserLastName']")).sendKeys(LastName);
        driver.findElement(By.xpath("//*[@id='UserCompanyName']")).sendKeys(CompanyName);
        driver.findElement(By.xpath("(//*[@class = 'btn btn-primary'])[1]")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        String actualAlert = alert.getText();
        if (actualAlert.equals(expectedAlert)){
            System.out.println("success");
        }else{
            System.out.println("Failed");
        }
        alert.accept();

        driver.quit();
    }



}
