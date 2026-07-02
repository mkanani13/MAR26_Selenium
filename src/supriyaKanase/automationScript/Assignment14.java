package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assignment14 {
    @Test
    public  void printAllEmployeeDetails() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("STEP - Click on demo tables tab");
        driver.findElement(By.linkText("Demo Tables")).click();

        System.out.println("Print all employee details");
       for(int rowIndex =1; rowIndex <=5; rowIndex++){
            System.out.println(driver.findElement(By.xpath("//table[@id = 'table1']/tbody/tr["+rowIndex+"]")).getText());
        }
        //System.out.println(driver.findElement(By.xpath("//table[@id = 'table1']/tbody")).getText());

        //System.out.println(driver.findElement(By.xpath("//table[@id = 'table1']")).getText());
    }
}