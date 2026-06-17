package vishwajeetLoni;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPageJSPrompt_Assignment6 {
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

        WebElement btn = driver.findElement(By.xpath("//button[@id = 'javascriptPromp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",btn);
        btn.click();
        System.out.println("Btn click");

        Alert alert = driver.switchTo().alert();
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String name = sc.nextLine();
//        sc.close();


        String entered = "Vishwajeet";
        alert.sendKeys(entered);
        alert.accept();

        String tocheck = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
        if (tocheck.contains(entered))
            System.out.println("Clicked on Ok");
    }
}
