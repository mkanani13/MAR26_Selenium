package asisPal;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technocredits.technoapp.base.BrowserActions;
import org.testng.annotations.Test;
import technocredits.technoapp.base.BrowserActions;

// Selenium ni jar add na karvi padi ? kayu ?
// testng nu kevu
public class Example1 {
    WebDriver driver;


    void setUp() {
        driver = BrowserActions.start();
        driver.findElement(By.linkText("Demo Tables")).click();
    }

    int getNumberOfTotalEmployees() {
        int totalEmployees = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        return totalEmployees;
    }

    void printEmployeeDetail() {
        for(int rowIndex=1;rowIndex<=5;rowIndex++) {
            for(int colIndex=1;colIndex<=4;colIndex++) {
                String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText();
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    void printEmployeeDetail1() {
        for(int rowIndex=1;rowIndex<=5;rowIndex++) {
            System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]")).getText());
        }
    }

    void printEmployeeDetail2() {
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
    }

    void printEmployeeDetail3() {
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']")).getText());
    }

    List<String> getUsername(String firstName) {
        List<String> listOfUsername = new ArrayList<String>();

        int totalRows =driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for(int rowIndex=1;rowIndex<=totalRows;rowIndex++) {
            String fname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
            if(fname.equals(firstName)) {
                listOfUsername.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText());
            }
        }
        return listOfUsername;
    }

    String getUsername1(String firstName) {
        return driver.findElement(By.xpath("//td[text()='"+firstName+"']/following-sibling::td[2]")).getText();
    }

    List<String> getUsername2(String firstName) {
        List<WebElement> listOfUserNameElements = driver.findElements(By.xpath("//td[text()='"+firstName+"']/following-sibling::td[2]"));
        List<String> al = new ArrayList<String>();

        for(WebElement e : listOfUserNameElements) {
            al.add(e.getText());
        }
        return al;
    }

    @Test
    public void verifyTableData() {
        Example1 ex1 = new Example1();
        ex1.setUp();
        List<String> listOfUname = ex1.getUsername("Vipin");
        System.out.println(listOfUname);
    }
}

