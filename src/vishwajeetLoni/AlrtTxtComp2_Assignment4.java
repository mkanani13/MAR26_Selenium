package vishwajeetLoni;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlrtTxtComp2_Assignment4 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.id("javascriptAlert")).click();

        Alert alert = driver.switchTo().alert();
        String actualtxt = alert.getText();
        String exptext = "You must be TechnoCredits student!!";
        if (actualtxt.equals(exptext)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }




    }
}
