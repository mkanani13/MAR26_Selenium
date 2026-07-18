package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccessPage extends BrowserActions {

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='access-submit-btn']")));
    }

    public String continueToLogin(String studentId, String accessCode){
        System.out.println("STEP - Enter Student ID");
        WebElement elStduentID = driver.findElement(By.id("access-student-id"));
        elStduentID.sendKeys(studentId);

        System.out.println("STEP - Enter Access Code");
        WebElement elAccessCode = driver.findElement(By.xpath("//input[@id='access-code']"));
        // WebElement elAccessCode = driver.findElement(By.id("//input[@id='access-code']"));
        elAccessCode.sendKeys(accessCode);

        System.out.println("STEP - Click on Continue Button");
        WebElement elContinueButton = driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']"));
        elContinueButton.click();

        return "";
    }
}
