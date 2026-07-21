package vishwajeetLoni;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage_Assignment5 {
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

        WebElement btn = driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",btn);
        btn.click();
        System.out.println("Btn click");

        Alert alert = driver.switchTo().alert();
        String actualtxt = alert.getText();
        String expectedtxt = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        if (actualtxt.equals(expectedtxt)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        alert.accept();
        System.out.println("Clicked on OK");

       String tocheckfor = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
       if (tocheckfor.equals("You pressed OK!"));
       System.out.println("pass");






    }
}
