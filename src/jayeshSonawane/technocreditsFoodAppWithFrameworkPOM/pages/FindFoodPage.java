package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;

public class FindFoodPage extends BrowserActions {

    public void waitForPageLoad() {
        BrowserActions.visibilityOfElementLocated(By.xpath("//img[@alt='Rolls Mania logo']"));
    }

    public void clickOnFindFoodPage() {
        driver.findElement(By.xpath("//a[@data-nav='find']")).click();
    }

    public String getUserName(){
        return driver.findElement(By.xpath("(//span[@class='text-fd-brand-accent'])[2]/parent::span")).getText().split(" ")[1];
    }

    public boolean verifyLoggedInUser(){
        String actualUserName = getUserName();

        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.clickOnMyProfilePage();
        myProfilePage.waitforPageLoad();
        String expectedUserName = myProfilePage.getUserName();

        return actualUserName.equals(expectedUserName);
    }
}
