package asisPal.Assignments_1_16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
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
        driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("sasmita");

        System.out.println("STEP5 - Enter password");
        WebElement pwdInputElement = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
        pwdInputElement.sendKeys("sasmita@12345");

        System.out.println("STEP6 - Click on submit button");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

        System.out.println("STEP6 - Switch to sucess alert message ");
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (alertText.equals("Success!")) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        System.out.println("STEP7- Click on Ok button");
        alert.accept();

        System.out.println("STEP7- Clear password filed");
        pwdInputElement.clear();

        System.out.println("STEP8- Enter lessthan 8character password");
        pwdInputElement.sendKeys("sg234");

        System.out.println("STEP9- Click on submit button with worong password");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

        System.out.println("STEP10 - Switch to failed alert message ");
        Alert alert1 = driver.switchTo().alert();
        String failedalerttext = alert1.getText();
        if (failedalerttext.equals("Failed! please enter strong password")) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        System.out.println("STEP11 - Accept and close the tabs ");
        alert.accept();
        driver.quit();

    }
}
