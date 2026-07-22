package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessPage extends BrowserActions {

    private final String ACCESS_BUTTON_XPATH = "//button[@data-testid='access-submit-btn']";

    @FindBy(xpath=ACCESS_BUTTON_XPATH)
    WebElement elContinueButton;

    @FindBy(id = "access-student-id")
    WebElement elStudentId;

    @FindBy(xpath = "//input[@id='access-code']")
    WebElement elAccessCode;

    public AccessPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(){
        visibilityOfElementLocated(By.xpath(ACCESS_BUTTON_XPATH));
    }

    public void continueToLogin(String studentId, String accessCode){
        System.out.println("STEP - Enter Student ID");
//        WebElement elStduentID = driver.findElement(By.id("access-student-id"));
//        elStduentID.sendKeys(studentId);
        sendKeysToElement(elStudentId, studentId, false);

        System.out.println("STEP - Enter Access Code");
//        WebElement elAccessCode = driver.findElement(By.xpath("//input[@id='access-code']"));
        sendKeysToElement(elAccessCode, accessCode, false);

        System.out.println("STEP - Click on Continue Button");
//        WebElement elContinueButton = driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']"));
//        elContinueButton.click();
        clickOnElement(elContinueButton, false);
    }
}
