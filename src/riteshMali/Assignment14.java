package automationScript;
//Using Selenium WebDriver in Java, automate the following scenario:
//
//Open the website http://automationbykrishna.com/.
//Click on the "Demo Tables" tab to navigate to the tables section.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Read all the rows and columns present in the table.
//Print the complete table data in the Console Output.

import net.bytebuddy.asm.MemberSubstitution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment14 {

    WebDriver driver;

    void startup() {
        driver = new ChromeDriver();
        System.out.println("Step - launch browser and hit URL");
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Click on Demo Table");
        driver.findElement(By.linkText("Demo Tables")).click();
    }

    void printEmployeeInfo() {

        for (int rowIndex = 1; rowIndex <= 5; rowIndex++) {
            for (int colIndex = 1; colIndex <= 4; colIndex++) {
                String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]")).getText();
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    void printEmployeeInfo1(){
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
    }

    public static void main(String[] args) {
        Assignment14 assign14 = new Assignment14();
        assign14.startup();
        assign14.printEmployeeInfo();
        assign14.printEmployeeInfo1();
    }
}
