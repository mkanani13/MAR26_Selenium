package adityaMukhedkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment_1_2 {

    @Test
    public void test() throws InterruptedException{

        WebDriver driver = new ChromeDriver() ;
        String url = "http://automationbykrishna.com/";
        System.out.println("----->To launch url");
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("----->url launched successfully <----------");
        System.out.println("----->To find registration tab by ID method & click on it");
        driver.findElement(By.id ("registration2")).click();
        Thread.sleep(5000);

        driver.findElement(By.id ("unameSignin")).sendKeys("Aditya");

        driver.findElement(By.id ("pwdSignin")).sendKeys("Hirecorrecto@123");

        Thread.sleep(1000);
        driver.findElement(By.id ("btnsubmitdetails")).click();
        System.out.println("----->password section found by ID method & click on it <--------");
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals("Success!")){
            System.out.println("ok.User is created .");
            alert.accept();
        }else
            System.out.println("KO. ");

        System.out.println("----->Negative test case <----------");
        driver.findElement(By.id ("unameSignin")).clear();
        driver.findElement(By.id ("unameSignin")).sendKeys("Aditya");
        driver.findElement(By.id ("pwdSignin")).clear();
        driver.findElement(By.id ("pwdSignin")).sendKeys("Hirec@");
        Thread.sleep(1000);
        driver.findElement(By.id ("btnsubmitdetails")).click();
        if (alert.getText().equals("Failed! please enter strong password")){
            System.out.println("negative testcase is catched . OK.");
            alert.accept();
        }else
            System.out.println("negative testcase is not catched . KO.");

        System.out.println("----------Assignment 2 -----------");
        Thread.sleep(3000);
        driver.findElement(By.id ("basicelements")).click();
        Thread.sleep(3000);
        driver.findElement(By.id ("UserFirstName")).sendKeys("Aditya");
        Thread.sleep(3000);
        driver.findElement(By.id("UserLastName")).sendKeys("M");
        Thread.sleep(3000);
        driver.findElement(By.id("UserCompanyName")).sendKeys("hc");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String str = "Aditya and M and hc";
        if (alert.getText().equals(str)){
            System.out.println("Alert Message is OK .");
            alert.accept();
        }else
            System.out.println("Alert message is KO .");
        System.out.println("-----------Assignment-2 is passed--------");

        driver.quit();

    }
}
