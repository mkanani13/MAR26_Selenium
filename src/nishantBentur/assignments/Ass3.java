package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass3 {
    WebDriver driver;

    @Test
    public void aa_basicElementsAlert(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        String fName = "Nishant", lName = "Bentur", cName = "Java";

        WebElement firstName = driver.findElement(By.id("UserFirstName"));
        firstName.sendKeys(fName);

        WebElement lastName = driver.findElement(By.id("UserLastName"));
        lastName.sendKeys(lName);

        WebElement companyName = driver.findElement(By.id("UserCompanyName"));
        companyName.sendKeys(cName);

        driver.findElement(By.xpath("//button[@type='submit'][1]")).click(); //Click Submit button

        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        String expectedAlertMessage = fName + " and " + lName + " and " + cName;

        Assert.assertEquals(expectedAlertMessage,actualAlertMessage);
        alert.accept();
        driver.quit();
    }
}
