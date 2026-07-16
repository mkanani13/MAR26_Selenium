package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChooseApplicationPage extends BrowserActions {

    public final String SIGN_INTO_FOOD_APP_XPATH = "//button[@data-testid='choose-food']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGN_INTO_FOOD_APP_XPATH)));
    }

    public void clickOnSignIntoFoodApp(){
        System.out.println("STEP - Click Sign in to Food app");
        driver.findElement(By.xpath(SIGN_INTO_FOOD_APP_XPATH)).click();
    }
}
