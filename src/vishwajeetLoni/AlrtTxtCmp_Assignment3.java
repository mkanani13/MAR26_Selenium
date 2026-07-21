package vishwajeetLoni;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlrtTxtCmp_Assignment3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();     // Click on BAsic Elements tab
        Thread.sleep(5000);

        String username = "TestUserName";
        String lastname = "TestLastName";
        String companyname = "TestCompanyName";

        driver.findElement(By.id("UserFirstName")).sendKeys(username);
        driver.findElement(By.id("UserLastName")).sendKeys(lastname);
        driver.findElement(By.id("UserCompanyName")).sendKeys(companyname);
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();

        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        System.out.println(actualAlertText);
        String expectedAlerttext = username + " and " + lastname + " and " + companyname;
        System.out.println(expectedAlerttext);

        if (actualAlertText.equals(expectedAlerttext)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        alert.accept();


    }
}
