package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFoodPage extends BrowserActions {

    private final String IMAGE_XPATH = "//img[@alt='Rolls Mania logo']";

    @FindBy(xpath = "//a[@data-nav='find']")
    WebElement elementClickOnFindFood;

    public FindFoodPage(){
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad() {
        visibilityOfElementLocated(By.xpath(IMAGE_XPATH));
    }

    public void clickOnFindFoodPage() {
//        driver.findElement(By.xpath("//a[@data-nav='find']")).click();
        clickOnElement(elementClickOnFindFood, false);
    }

    @FindBy(xpath = "(//span[@class='text-fd-brand-accent'])[2]/parent::span")
    WebElement elementGetUserName;


    public String getUserName(){
//        return driver.findElement(By.xpath("(//span[@class='text-fd-brand-accent'])[2]/parent::span")).getText().split(" ")[1];
        return getElementText(elementGetUserName, false).split(" ")[1];
    }

    public boolean verifyLoggedInUser(){
        String actualUserName = getUserName();

        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.clickOnMyProfilePage();
        myProfilePage.waitForPageLoad();
        String expectedUserName = myProfilePage.getUserName();

        return actualUserName.equals(expectedUserName);
    }
}
