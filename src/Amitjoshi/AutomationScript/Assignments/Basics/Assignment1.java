package AutomationScript.Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/#");
        driver.manage().window().maximize();
        System.out.println("step1- window is maximized now clicking on registration ");
       WebElement element= driver.findElement(By.id("registration2"));
        element.click();
        Thread.sleep(2000);
        System.out.println("step2- imputing user and password = maulik, password= kanani@12  ");
        driver.findElement(By.id("unameSignin")).sendKeys("Maulik");
        System.out.println("the user name is done");
        driver.findElement(By.id("pwdSignin")).sendKeys("kanani@12");
        System.out.println("clicking the checkbox for not a robot");
        driver.findElement(By.id("rememberme")).click();
        System.out.println("click on submit button");
        driver.findElement(By.id("btnsubmitdetails")).click();
       element.getText();



        Thread.sleep(8000);
        driver.close();
    }

}
