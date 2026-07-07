package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;

public class StudentAccessPage extends BrowserAction {
    private WebElement continueButton;
    public void waitForPageLoad() {
        continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[1]")));
    }
    public void getStudentAccess(String stdId, String accessCode ) {
        System.out.println("Entering student id and password and getting access");
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys(stdId);
        driver.findElement(By.xpath("//input[@id='access-code']")).sendKeys(accessCode);
        continueButton.click();
    }
}
