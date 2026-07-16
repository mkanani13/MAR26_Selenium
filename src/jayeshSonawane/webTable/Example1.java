package jayeshSonawane.webTable;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Demo Tables");
        WebElement elementDemoTables = driver.findElement(By.linkText("Demo Tables"));
        elementDemoTables.click();

        // Find number of Tables
        List<WebElement> elTableCount = driver.findElements(By.xpath("//table"));
        System.out.println("Number of Tables : " + elTableCount.size());

        // Find Number of Columns and Rows in Second Table
        System.out.println("Table Name : " + driver.findElement(By.xpath("//header[contains(text(),'Employee Manager')]")).getText().toUpperCase());
        System.out.print("Number of Rows : ");
        System.out.println(driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size());

        System.out.print("Number of Columns : ");
        System.out.println(driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr")).size());


        for(int i = 1 ; i <= elTableCount.size(); i++ ){
            String tableName = driver.findElement(By.xpath("(//div[@class='wrapper' and @id='indexBody']/div/div/div/section/header)["+i+"]")).getText().toUpperCase();

            System.out.print("Number of Columns in "+ tableName + " are ");
            //xpath = //(//table)[1]/thead/tr/th
            System.out.println(driver.findElements(By.xpath("(//table)["+ i +"]/thead/tr/th")).size());

            //xpath = (//table)[1]/tbody/tr
            System.out.print("Number of Rows in "+ tableName + " are ");
            System.out.println(driver.findElements(By.xpath("(//table)["+ i +"]/tbody/tr")).size());
        }

        BrowserActions.close();

    }
}
