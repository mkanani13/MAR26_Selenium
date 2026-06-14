package demotable;

import base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Example5 {
    WebDriver driver;

    @Test
    private void m1(){
        driver = BrowserActions.start();
        driver.findElement(By.linkText("Demo Tables")).click();
        int size = driver.findElements(By.xpath("//table")).size();
        System.out.println("m1");
        Assert.assertEquals(size, 4);
    }

    @Test
    public void m2(){
        System.out.println("m2");
        System.out.println("STEP - find total number of employees");
        int size = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

        System.out.println("VERIFY - Number of employees");
        Assert.assertEquals(size, 5);
    }

    @Test
    public void m3(){
        System.out.println("m3");
        int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

        System.out.println("VERIFY - Number of employees");
        Assert.assertEquals(size, 9);
    }

    @Test
    public void m4(){
        System.out.println("m4");
        System.out.println("STEP - find unique department set");
        int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        Set<String> deptSet = new HashSet<>();

        for(int index=1;index<=totalRows;index++){
            String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
            deptSet.add(deptName);
        }

        System.out.println("VERIFIY - unique department should be 4");
        Assert.assertEquals(deptSet.size(),4);
    }
}
