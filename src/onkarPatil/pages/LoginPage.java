package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BrowserActions {

    private static String STUDENT_ID_LOCATOR = "access-student-id";
    private static String STUDENT_ACCESS_CODE_LOCATOR = "access-code";
    private static String ACCESS_SUBMIT_BTN_LOCATOR = "//button[@data-testid='access-submit-btn']";

    private static String CHOOSE_FOOD_LOCATOR = "//button[@data-testid='choose-food']";

    private static String EMAIL_INPUT_LOCATOR = "login-email";
    private static String PASSWORD_INPUT_LOCATOR = "login-password";
    private static String LOGIN_SUBMIT_BTN_LOCATOR = "//button[@data-testid='login-submit-btn']";

    private static String STUDENT_ID = "TS5FU2Z2ND";
    private static String ACCESS_CODE = "P4VY95MB";
    private static String EMAIL = "patilonkar18@gmail.com";
    private static String PASSWORD = "Devansh@1";


    public void doLogin(){
        driver.findElement(By.id(STUDENT_ID_LOCATOR)).sendKeys(STUDENT_ID);
        driver.findElement(By.id(STUDENT_ACCESS_CODE_LOCATOR)).sendKeys(ACCESS_CODE);
        driver.findElement(By.xpath(ACCESS_SUBMIT_BTN_LOCATOR)).click();

        WebElement chooseFoodLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHOOSE_FOOD_LOCATOR)));
        chooseFoodLocator.click();

        WebElement emailLocator = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(EMAIL_INPUT_LOCATOR)));
        emailLocator.sendKeys(EMAIL);
        driver.findElement(By.id(PASSWORD_INPUT_LOCATOR)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(LOGIN_SUBMIT_BTN_LOCATOR)).click();
    }
}
