package onkarPatil.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();

        String firstName = "Onkar";
        String lastName = "Patil";
        String companyName = "Globant";

        Thread.sleep(1000);
        driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
        driver.findElement(By.id("UserLastName")).sendKeys(lastName);
        driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);

        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        System.out.println(actualMessage);

        String expectedMessage = firstName + " and " + lastName + " and " + companyName;
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Pass !!!");
        }else{
            System.out.println("Fail");
        }

        driver.quit();
    }
}
