package seleniumAssignments;

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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3_61 {

    public static void main(String[] args) {

        String firstName = "Jayesh";
        String lastName = "Sonawane";
        String companyName = "abc";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        if(driver.getCurrentUrl().equals("http://automationbykrishna.com/")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        WebElement elementBasicElements = driver.findElement(By.xpath("//*[@id='basicelements']"));
        elementBasicElements.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement elementUserFirstName = driver.findElement(By.xpath("//*[@id='UserFirstName']"));
        elementUserFirstName.sendKeys(firstName);

        WebElement elementUserLastName = driver.findElement(By.xpath("//*[@id='UserLastName']"));
        elementUserLastName.sendKeys(lastName);

        WebElement elementUserCompanyName = driver.findElement(By.xpath("//*[@id='UserCompanyName']"));
        elementUserCompanyName.sendKeys(companyName);

        WebElement elementBtn_btn_primary = driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]"));
        elementBtn_btn_primary.click();

        String expectedAlertText = firstName + " and " + lastName + " and " + companyName;

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        if(alertText.equals(expectedAlertText)){
            System.out.println("TC Passed");
        }else{
            System.out.println("TC Failed");
        }

    }
}
