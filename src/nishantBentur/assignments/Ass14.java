package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ass14 {
    WebDriver driver;

    @Test
    public void readEmployeeInfoTable(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Demo Tables tab");
        driver.findElement(By.linkText("Demo Tables")).click();

        System.out.println("Locate 'Employee Basic Information' table & print Employee details");
        WebElement employeeInfoTable = driver.findElement(By.xpath("//table[@id='table1']")); //Employee Basic Information table
        System.out.println();
        System.out.println(employeeInfoTable.getText());

        driver.quit();
    }
}
