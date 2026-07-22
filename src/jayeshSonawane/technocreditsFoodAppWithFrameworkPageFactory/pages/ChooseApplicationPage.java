package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChooseApplicationPage extends BrowserActions {

    private final String SIGN_INTO_FOOD_APP_XPATH = "//button[@data-testid='choose-food']";

    @FindBy(xpath = SIGN_INTO_FOOD_APP_XPATH)
    WebElement elSignIntoFoodAppButton;

    public ChooseApplicationPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(){
        visibilityOfElementLocated(By.xpath(SIGN_INTO_FOOD_APP_XPATH));
    }

    public void clickOnSignIntoFoodApp(){
        System.out.println("STEP - Click Sign in to Food app");
//        driver.findElement(By.xpath(SIGN_INTO_FOOD_APP_XPATH)).click();
        clickOnElement(elSignIntoFoodAppButton, false);
    }
}
