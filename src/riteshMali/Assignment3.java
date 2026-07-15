package automationScript;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Enter values in:
//FirstName field
//LastName field
//CompanyName field
//
//Click on the Submit button.
//Alert message should pop-up "FirstName and LastName and CompanyName"


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);
        String firstName = "Ritesh";
        String lastName = "Mali";
        String companyName = "hireCorrecto";

        driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Mali");
        driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("hireCorrecto");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(1000);
        String expectedMessage = firstName + " and " + lastName + " and " + companyName;

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();

        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        alert.accept();
        driver.quit();
    }

}
