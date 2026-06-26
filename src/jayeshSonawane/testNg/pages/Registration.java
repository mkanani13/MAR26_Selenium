package jayeshSonawane.testNg.pages;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Registration extends BrowserActions {

    protected final General general = new General();

    public void login(String username, String password){
        general.verifyTitle();
        general.verifyRedirection();

        System.out.println("STEP - Click on the Registration tab/button.");
        WebElement registrationButton = driver.findElement(By.id("registration2"));
        registrationButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait to confirm page is loaded or not using one of the elements which guarantees that if he is loaded  then page is loaded.
        String h1Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Login']"))).getText();
        Assert.assertTrue(h1Text.toUpperCase().equals("LOGIN"));

        System.out.println("STEP - Enter User Name");
        WebElement elUsername = driver.findElement(By.id("unameSignin"));
        elUsername.sendKeys(username);

        System.out.println("STEP - Enter Password");
        WebElement elPassword = driver.findElement(By.id("pwdSignin"));
        elPassword.sendKeys(password);

        System.out.println("STEP - Click on Submit button");
        WebElement submitButton = driver.findElement(By.id("btnsubmitdetails"));
        submitButton.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText,"Success!", "Alert after submit button");
    }
}
