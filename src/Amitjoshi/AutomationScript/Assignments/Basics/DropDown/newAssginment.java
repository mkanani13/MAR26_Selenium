/*
Using Selenium WebDriver with Java, automate the following scenario:

Launch the website http://automationbykrishna.com/.
Navigate to the "Basic Elements" section by clicking on the corresponding tab.
Scroll down until the "Select" dropdown is visible.
From the select dropdown, choose the options '3' and '2'.
void selectByvalue(string);
void select ByVisibleText(string text)
void selectByindex(int index);
 */

package Amitjoshi.AutomationScript.Assignments.Basics.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class newAssginment {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();

        WebElement ddElement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[1]"));
        Select oselect = new Select(ddElement);
        oselect.selectByIndex(2);

        oselect.selectByVisibleText("2");

        System.out.println(oselect.getOptions().size());


        driver.quit();
    }
}