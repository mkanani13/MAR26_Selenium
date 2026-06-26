package jayeshSonawane.technocreditsFoodAppWithoutFramework.pages;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Login extends BrowserActions {

    public void login(){
        driver = BrowserActions.start("CHROME", "http://34.173.201.53/access#/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='access-submit-btn']")));

        System.out.println("STEP - Enter Student ID");
        WebElement elStduentID = driver.findElement(By.id("access-student-id"));
        elStduentID.sendKeys("F248JK5SK6");

        System.out.println("STEP - Enter Access Code");
        WebElement elAccessCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='access-code']")));
        // WebElement elAccessCode = driver.findElement(By.id("//input[@id='access-code']"));
        elAccessCode.sendKeys("B6FVNRUZ");

        System.out.println("STEP - Click on Continue Button");
        WebElement elContinueButton = driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']"));
        elContinueButton.click();

        String elActualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Choose your application']"))).getText();
        Assert.assertEquals(elActualText, "Choose your application", "Access Granted");

        System.out.println("STEP - Click on Sign in to Food app");
        WebElement elSignInToFoodAppButton = driver.findElement(By.xpath("//span[contains(text(), 'Sign in to Food app')]"));
        elSignInToFoodAppButton.click();
        WebElement elSignInToTechnocreditsFoodButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign in to Technocredits Food']")));
        Assert.assertEquals(elSignInToTechnocreditsFoodButton.getText(), "Sign in to Technocredits Food");

        System.out.println("STEP - Enter Email");
        WebElement elEmail = driver.findElement(By.id("login-email"));
        elEmail.sendKeys("jayesh.customer@technocredits.com");

        System.out.println("STEP - Enter Password");
        WebElement elPassword = driver.findElement(By.id("login-password"));
        elPassword.sendKeys("jayesh123456");
        // Assert.assertTrue(!elPassword.getText().isEmpty(), "Enter Password"); // Dont use -> It fails everytime

        System.out.println("STEP - Click on Sign in to Technocredits Food");
        elSignInToTechnocreditsFoodButton.click();


    }
}
