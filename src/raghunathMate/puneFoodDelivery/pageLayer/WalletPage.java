package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import puneFoodDelivery.testBase.BrowserAction;

import java.time.Duration;

public class WalletPage extends BrowserAction {

    SoftAssert softassert = new SoftAssert();

    public void checkWalletBalance() {
        driver.findElement(By.xpath("//a[contains(text(),'Wallet')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addCredit_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id ='wallet-add']")));
        String bal = driver.findElement(By.xpath("//span[@data-testid='wallet-balance']")).getText();
        bal = bal.replace(",","");
        double B_before = Double.parseDouble(bal);
        System.out.println(B_before);
    }

}
