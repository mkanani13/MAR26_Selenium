package jayeshSonawane.testNg.pages;

import jayeshSonawane.base.BrowserActions;
import jayeshSonawane.base.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BasicElements extends BrowserActions {

    SoftAssert softAssert = new SoftAssert();
    Alert alert;
    private WebDriverWait wait;

    public void clickBasicElements(){
        System.out.println("STEP - Click on the Basic Elements tab/button.");
        WebElement basicElementsButton = driver.findElement(By.linkText("Basic Elements"));
        basicElementsButton.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='FirstName']")));
    }

    public void alertDemo(String firstName, String lastName, String companyName){

        clickBasicElements();

        System.out.println("STEP - Enter First Name");
        WebElement elFirstName = driver.findElement(By.xpath("//input[@id='UserFirstName']"));
        elFirstName.sendKeys(firstName);

        System.out.println("STEP - Enter Last Name");
        WebElement elLastName = driver.findElement(By.xpath("//*[@id='UserLastName']"));
        elLastName.sendKeys(lastName);

        System.out.println("STEP - Enter Company Name");
        WebElement elCompanyName = driver.findElement(By.xpath("//*[@id='UserCompanyName']"));
        elCompanyName.sendKeys(companyName);

        WebElement elSubmitButton = driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]"));
        elSubmitButton.click();

        String expectedAlertText = firstName + " and " + lastName + " and " + companyName;

        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, expectedAlertText);
        alert.accept();
    }

    public void alertJavascriptConfirmation(){

        clickBasicElements();

        System.out.println("STEP - Click on Javascript Confirmation Alert Button");
        WebElement elJavascriptAlertButton = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        elJavascriptAlertButton.click();
        alert = driver.switchTo().alert();
        String expectedAcceptAlertText = "You pressed OK!";
        System.out.println("STEP - Accept alert");
        alert.accept();
        System.out.println("Alert Accepted");
        WebElement elActualAcceptAlertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You pressed OK!']")));
        String actualAcceptAlertText = elActualAcceptAlertText.getText();
        softAssert.assertEquals(actualAcceptAlertText, expectedAcceptAlertText, "At Accept Alert");

        System.out.println("STEP - Click on Javascript Confirmation Alert Button");
        elJavascriptAlertButton.click();
        alert = driver.switchTo().alert();
        String expectedDismissAlertText = "You pressed Cancel!";
        System.out.println("STEP - Dismiss alert");
        alert.dismiss();
        System.out.println("Alert Dismissed");
        WebElement elActualDismissAlertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You pressed Cancel!']")));
        String actualDismissAlertText = elActualDismissAlertText.getText();
        softAssert.assertEquals(actualDismissAlertText, expectedDismissAlertText, "At Dismiss Alert");

        softAssert.assertAll();
    }

    public void alertJavascriptPrompt(){

        clickBasicElements();
        System.out.println("STEP - Click on Javascript Prompt");
        WebElement elJavascriptPromptButton = driver.findElement(By.id("javascriptPromp"));
        elJavascriptPromptButton.click();

        alert = driver.switchTo().alert();
        String enteredPromptText = "Jayesh";
        alert.sendKeys(enteredPromptText);
        alert.accept();

        String expectedAlertMessage = "Hello " + enteredPromptText + "! How are you today?";
        String actualAlertMessage = driver.findElement(By.id("pgraphdemo")).getText();
        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage);

        softAssert.assertAll();
    }

    public void checkBox(){
        clickBasicElements();
        System.out.println("STEP - Scroll till check box element");

        JavascriptExecutor js = ElementActions.scrollTo();


    }
}
