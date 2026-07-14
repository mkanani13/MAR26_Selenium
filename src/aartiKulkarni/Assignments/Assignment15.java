package aartiKulkarni.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*
Using Selenium WebDriver in Java, automate the following steps:

Launch the website http://automationbykrishna.com/.
Navigate to the "Demo Tables" section by clicking on the corresponding tab.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Traverse through the table data and identify the row where the "First Name" column value is "Priya".
Retrieve the corresponding value from the "Username" column in the same row.
Print the extracted Username value in the Console.

 */
public class Assignment15 {

    @Test
    public void retriveUserNameFromName(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

       for(WebElement row:rows){
           String firstname=row.findElement(By.xpath("./td[2]")).getText();
       //    if(firstname.equals("Priya")){
               String userName=row.findElement(By.xpath("./td[4]")).getText();
               System.out.println("UserName of "+firstname + " is :" + userName);
       //        break;
           }
       //}

    }
}
