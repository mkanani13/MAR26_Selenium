package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Ass16 {
    WebDriver driver;

    void setUp(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Demo Tables tab");
        driver.findElement(By.linkText("Demo Tables")).click();
    }

    String getName(String userName){
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){
            String uName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
            if(uName.equals(userName))
                return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
        }
        return null;
    }

    @Test
    public void getEmployeeName(){
        String userName = "asharma";
        Ass16 obj = new Ass16();
        obj.setUp();
        System.out.println("STEP-Get the user name for the firstName provided");
        String fName = obj.getName(userName);
        System.out.println("Output:: " + userName + " has first name : " + fName);

    }
}
