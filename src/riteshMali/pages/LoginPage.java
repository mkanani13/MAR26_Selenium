package riteshMali.pages;

import org.openqa.selenium.By;
import riteshMali.base.BrowserActions;
import riteshMali.utility.PropertyOperations;

public class LoginPage extends BrowserActions {

    private final String STUDENT_ID_LOGIN = "//input[@id='access-student-id']";
    private final String ACCESS_CODE = "//input[@id='access-code']";
    private final String CONTINUE_BTN = "//button[@data-testid='access-submit-btn']";
    private final String SIGN_IN_FOOD_BTN = "//button[@data-testid='choose-food']";
    private final String AUTOFILL_BTN = "//button[@data-testid='demo-customer']";
    private final String SIGN_IN_TECHNOCREDITFOOD_BTN = "//button[@data-testid='login-submit-btn']";


    public void doLogin() {

        PropertyOperations configProperty = new PropertyOperations("src/riteshMali/config/config.properties");
        BrowserActions.start();
        System.out.println("Step - Enter student ID");
        setTextOnElement(By.xpath(STUDENT_ID_LOGIN), configProperty.getValue("STUDENTID"));

        System.out.println("Step - Enter Access code");
        setTextOnElement(By.xpath(ACCESS_CODE), configProperty.getValue("ACCESSCODE"));

        System.out.println("Step - Click on continue button ");
        clickOnElement(By.xpath(CONTINUE_BTN));


        System.out.println("Step - click on sign in food app");
        clickOnElement(By.xpath(SIGN_IN_FOOD_BTN));

        System.out.println("Step - Enter Email Address and password using autofill");
        clickOnElement(By.xpath(AUTOFILL_BTN));

        System.out.println("Step - Click on Sign in to Technocredits Food button");
        clickOnElement(By.xpath(SIGN_IN_TECHNOCREDITFOOD_BTN));
    }

}
