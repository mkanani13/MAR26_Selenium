package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;

public class MyProfilePage extends BrowserActions {

    public void waitforPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"));
    }

    public void clickOnMyProfilePage(){
        driver.findElement(By.xpath("//a[@data-nav='profile']")).click();
    }

    public String getUserName(){
        return driver.findElement(By.xpath("//dd[@data-testid='profile-username']")).getText();
    }
}
