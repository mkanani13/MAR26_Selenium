package aartiKulkarni.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Demo Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read and iterate through all the rows of the table.
Find the row where the "Username" column contains the value "//table[@id='table1']//td[text()='asharma']/preceding-sibling::td[2]".
From the same row, retrieve the corresponding value from the "First Name" column.
Print the extracted First Name value in the Console.

 */
public class Assignment16 {

    @Test
    public void findFirstNameByUserName(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
         String firstName=driver.findElement(By.xpath("//table[@id='table1']//td[text()='asharma']/preceding-sibling::td[2]")).getText();
        System.out.println("FirstName  of asharma is : " + firstName);
    }
}
