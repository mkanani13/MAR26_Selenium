//Automate the following scenario using Selenium WebDriver in Java:
//
//        Open the application: http://automationbykrishna.com/
//        Click on the “Basic Elements” tab/button.
//
//        Enter values in:
//        FirstName field
//        LastName field
//        CompanyName field
//
//        Click on the Submit button.
//        Alert message should pop-up "FirstName and LastName and CompanyName"

package rutujaWaje;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment3 {
    @Test
    public void alertmessagepopup() throws InterruptedException {
        System.out.println("Launch Browser");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        System.out.println("Click on Basic Elements");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        System.out.println("Enter FirstName");
        WebElement firstname = driver.findElement(By.xpath("//input[@id=\"UserFirstName\"]"));
        firstname.sendKeys("Rutuja");

        System.out.println("Enter LastName");
        WebElement lastname = driver.findElement(By.xpath("//input[@id=\"UserLastName\"]"));
        lastname.sendKeys("Chaugule");

        System.out.println("Enter Company Name");
        WebElement companyname = driver.findElement(By.xpath("//input[@id=\"UserCompanyName\"]"));
        companyname.sendKeys("TCS");
        System.out.println("click the element");
        WebElement clickelement = driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[1]"));
        clickelement.click();

        System.out.println("Get the alert message");
        Alert alert = driver.switchTo().alert();
        String tab = alert.getText();
        Assert.assertEquals(tab,"Rutuja and Chaugule and TCS");
        alert.accept();
    }
}