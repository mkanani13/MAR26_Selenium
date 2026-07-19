package priyankaGhule.automationScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
    public static void main(String[] args)throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        String firstName= "Radhika";
        String lastName= "singh";
        String userComapanyName="allianz.technology";
        String ExpectedMessage= firstName + " and " + lastName + " and "+ userComapanyName;
        System.out.println(ExpectedMessage);

        driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
        driver.findElement(By.id("UserLastName")).sendKeys(lastName);
        driver.findElement(By.id("UserCompanyName")).sendKeys(userComapanyName);
        driver.findElement(By.xpath("//button[text()='Submit'][1]")).click();
        Alert aleart = driver.switchTo().alert();
        String actualMessage= aleart.getText();

        if(ExpectedMessage.equals(actualMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        aleart.accept();
        driver.quit();



    }
}
