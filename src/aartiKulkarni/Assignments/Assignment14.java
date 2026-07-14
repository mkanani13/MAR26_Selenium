package aartiKulkarni.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Demo Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read all the rows and columns present in the table.
Print the complete table data in the Console Output.

 */
public class Assignment14 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> tableinfo=driver.findElements(By.xpath("//div[@id='empbasic']"));

        //Reads whole table
        for(WebElement tableElement:tableinfo){
            System.out.println(tableElement.getText());
        }

        //Reads table row and columns

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        for(WebElement row : rows) {

            List<WebElement> cols = row.findElements(By.xpath("./th | ./td"));

            for(WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }

            System.out.println();
        }


    }
}