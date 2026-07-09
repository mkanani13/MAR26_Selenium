package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import puneFoodDelivery.testBase.BrowserAction;

public class ChooseApplicationPage extends BrowserAction {
    private WebElement chooseAppButton;

    public void waitForPageLoad() {
        chooseAppButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='choose-food']")));
    }

    public void VerifyAccessGrantedOrNot(){
        boolean accessFlag = driver.findElement(By.xpath("//span[contains(text(),'Welcome')]")).isDisplayed();
        Assert.assertTrue(accessFlag,"Access denied. Your Student ID and Access Code combination is not on the approved list. Please contact your instructor");
        System.out.println("Access granted to user");
    }

    public void chooseApplication(){
        chooseAppButton.click();
    }
}
