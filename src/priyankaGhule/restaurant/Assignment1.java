package priyankaGhule.restaurant;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment1 {

    public static void main(String[] args)throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://34.173.201.53/access#/acces");
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("7VHY26YN3M");
        driver.findElement(By.xpath("//input[@id='access-code']")).sendKeys("4FVMQ9F8");
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("click on food ordering");
        driver.findElement(By.xpath("//h2[text()='Food Ordering']")).click();

        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("user@technocredits.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("User@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Select any resaturant");
        driver.findElement(By.xpath("//div[@id='restaurants-grid']/div[1]//a")).click();

        System.out.println("select food item");
        WebElement element = driver.findElement(By.xpath("//tr[@data-testid='menu-row-dish_default_balance_brew_cafe_1']/td[5]/input"));
        element.clear();
        element.sendKeys("1");

        System.out.println("Scoll the page");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,500)");

        System.out.println("apply coupon code");
        WebElement couponElement = driver.findElement(By.xpath("//select[@id='coupon-code']"));
        Select couponSelect = new Select(couponElement);
        couponSelect.selectByIndex(1);

        System.out.println("Proceed to checkout");
        driver.findElement(By.xpath("//button[text()='Proceed to Checkout →']")).click();

        System.out.println("Scoll the page");
        JavascriptExecutor jsp = (JavascriptExecutor)driver;
        jsp.executeScript("window.scroll(0,500)");

        System.out.println("add the address");
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("Hadpsar pune-28");

        System.out.println("add phone number");
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys("8806198891");

        System.out.println("Continue the payment");
        driver.findElement(By.xpath("//button[@id='co-continue']")).click();

        System.out.println("Enter UPI Number");
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("1234567890@upi");

        System.out.println("click on checkbox");
        driver.findElement(By.xpath("//span[text()='I’m not a robot — confirm before paying']")).click();

        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();









    }
}

