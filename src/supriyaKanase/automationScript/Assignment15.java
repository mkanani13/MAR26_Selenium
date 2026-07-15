package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assignment15 {
     WebDriver driver;
     void setUp() {
         driver = BrowserAction.start("http://automationbykrishna.com/");
     }
//    String getUserName(String firstName){
//        System.out.println("STEP - Click on demo tables tab");
//        driver.findElement(By.id("demotable")).click();
//
//        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
//        for(int rowIndex=1; rowIndex<=totalRows; rowIndex++){
//            String fname = driver.findElement(By.xpath("//table[@id = 'table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
//           if(fname.equals(firstName)){
//              return  driver.findElement(By.xpath("//table[@id = 'table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
//           }
//        }
//         return null;
//    }
    String getUserName(String firstName){
        System.out.println("STEP - Click on demo tables tab");
        driver.findElement(By.id("demotable")).click();
        String uName = driver.findElement(By.xpath("//table[@id = 'table1']/tbody/tr/td[2][text()='"+firstName+"']/following-sibling::td[2]")).getText();
         return uName;
    }

    @Test
    public void getEmpUserName() {
        Assignment15 assignment15 = new Assignment15();
        assignment15.setUp();

        String userName = assignment15.getUserName("Priya");
        System.out.println("UserName: " + userName);
    }
}
