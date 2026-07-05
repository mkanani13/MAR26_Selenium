package jayeshSonawane.StaleElementReferenceException;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start("https://testing.qaautomationlabs.com/");
    }

    @Test
    public void StaleElementReferenceExceptionTC(){
        WebElement iFrame = driver.findElement(By.linkText("iFrame"));
        driver.navigate().refresh();
        iFrame.click();
    }

    @AfterMethod
    public void tearDown() {
//        BrowserActions.close();
    }
}