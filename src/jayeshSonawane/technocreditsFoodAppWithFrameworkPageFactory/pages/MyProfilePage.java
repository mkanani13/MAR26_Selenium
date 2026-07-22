package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BrowserActions {

    private final String SUBMIT_BUTTON_XPATH = "//button[@type='submit']";

    @FindBy(xpath = "//a[@data-nav='profile']")
    WebElement elementProfilePage;

    @FindBy(xpath = "//dd[@data-testid='profile-username']")
    WebElement elementProfileUserName;

    public MyProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(){
        visibilityOfElementLocated(By.xpath(SUBMIT_BUTTON_XPATH));
    }

    public void clickOnMyProfilePage(){
//        driver.findElement(By.xpath("//a[@data-nav='profile']")).click();
        clickOnElement(elementProfilePage, false);
    }

    public String getUserName(){
//        return driver.findElement(By.xpath("//dd[@data-testid='profile-username']")).getText();
        return getElementText(elementProfileUserName, false);
    }
}
