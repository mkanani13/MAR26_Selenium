package asisPal.Assignments_1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");

        System.out.println("STEP3 - Click on registration tab");
        driver.findElement(By.id("registration2")).click();


        Thread.sleep(1000);

        System.out.println("STEP4 - Enter username");
        driver.findElement(By.id("unameSignin")).sendKeys("sasmita");


        System.out.println("STEP5 - Enter password");
        driver.findElement(By.id("pwdSignin")).sendKeys("sasmita@12345");

        System.out.println("STEP6 - Click on submit button");
        driver.findElement(By.id("btnsubmitdetails")).click();
    }
}
