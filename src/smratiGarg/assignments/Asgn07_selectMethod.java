package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asgn07_selectMethod {
    @Test
    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate to automationbykrishna");
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com");

        System.out.println("STEP click basic elements");
        driver.findElement(By.id("basicelements")).click();

        Thread.sleep(2000);
//        WebElement checkBox1 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input[@type='checkbox'])[6]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("scrollIntoView to show previous element than checkbox to see checkbox properly");
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//p[text()='info@technocredits.com']")));
//        js.executeScript("arguments[0].scrollIntoView(true);",checkBox1);
        Thread.sleep(3000);

        WebElement checkBox2 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input[@type='checkbox'])[7]"));

        System.out.println("Checking if checkbox2 is not selected then executing click function");
        if (!checkBox2.isSelected()) {
            Thread.sleep(2000);
            System.out.println("Selecting check box");
            Assert.assertTrue(checkBox2.isSelected());

        }

        driver.quit();

    }
}
