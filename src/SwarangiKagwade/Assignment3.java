package SwarangiKagwade;
/*Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Enter values in:
FirstName field
LastName field
CompanyName field

Click on the Submit button.
Alert message should pop-up "FirstName and LastName and CompanyName"
*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        String name="Swarangi" , password="Swarangi@1110" , cmpName="Infosys";
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cmpName);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        Alert alert=driver.switchTo().alert();
        String alertMessage=alert.getText();
        Thread.sleep(1000);
        System.out.println("alertMessage"+alertMessage);
        System.out.println("Accepting alert");
        System.out.println("Alert accepted");
        alert.accept();
        Thread.sleep(1000);
        driver.quit();
    }
}
