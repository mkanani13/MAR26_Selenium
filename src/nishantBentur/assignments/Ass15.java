package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ass15 {
    WebDriver driver;

    void setUp(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Demo Tables tab");
        driver.findElement(By.linkText("Demo Tables")).click();
    }

    String getUserName(String firstName){
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){
            String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
            if(fName.equals(firstName))
                return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
        }
        return null;
    }

    @Test
    public void getEmployeeUserName(){
        String firstName = "Priya";
        Ass15 obj = new Ass15();
        obj.setUp();
        System.out.println("STEP-Get the user name for the firstName provided");
        String uName = obj.getUserName(firstName);
        System.out.println("Output:: " + firstName + " has Username : " + uName);
    }
}
