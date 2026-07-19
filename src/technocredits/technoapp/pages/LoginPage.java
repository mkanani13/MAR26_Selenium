package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;
<<<<<<< HEAD

public class LoginPage extends BrowserActions {

    public void doLogin(){
        System.out.println("STEP - Enter Student id");
        driver.findElement(By.xpath("//input[@data-testid='access-student-id']")).sendKeys("35EGM7D45W");

        System.out.println("STEP - Enter Access code");
        driver.findElement(By.xpath("//input[@data-testid='access-code']")).sendKeys("7MNT2R2F");

        System.out.println("STEP - Click on continue button");
        driver.findElement(By.xpath("//button[text()= 'Continue']")).click();

        System.out.println("STEP - Click on Sign In Food link");
        WebElement signInFoodElement  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='choose-food']")));
        signInFoodElement.click();

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        driver.findElement(By.xpath("//button[@data-email='user@technocredits.com']")).click();
=======
import technocredits.technoapp.constant.FilePaths;
import technocredits.technoapp.utility.PropertyOperations;

/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class LoginPage extends CommonPage {

    PropertyOperations configProperty = new PropertyOperations(FilePaths.CONFIG_FILE_PATH);

    private final String STUDENT_ID_INPUT = "//input[@data-testid='access-student-id']";
    private final String ACCESS_CODE_INPUT = "//input[@data-testid='access-code']";
    private final String CONTINUE_BUTTON = "//button[text()= 'Continue']";
    private final String CHOOSE_FOOD_APP = "//button[@data-testid='choose-food']";
    private final String USER_AUTO_FILL_BUTTON = "//button[@data-email='user@technocredits.com']";
    private final String LOGIN_BUTTON = "//button[@data-testid='login-submit-btn']";

    public void doLogin() {
        System.out.println("STEP - Enter Student id");
        setTextOnElement(By.xpath(STUDENT_ID_INPUT), configProperty.getValue("STUDENTID"));

        System.out.println("STEP - Enter Access code");
        setTextOnElement(By.xpath(ACCESS_CODE_INPUT), configProperty.getValue("ACCESSCODE"));

        System.out.println("STEP - Click on continue button");
        clickOnElement(By.xpath(CONTINUE_BUTTON));

        System.out.println("STEP - Click on Sign In Food link");
        clickOnElement(By.xpath(CHOOSE_FOOD_APP));

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        clickOnElement(By.xpath(USER_AUTO_FILL_BUTTON));
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

        //System.out.println("STEP - Enter email");
        //driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("raghu.customer@technocredits.com");

<<<<<<< HEAD
       // System.out.println("STEP - Enter password");
       // driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("raghuCust@12345");

        System.out.println("STEP - click on login button");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();
    }
=======
        // System.out.println("STEP - Enter password");
        // driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("raghuCust@12345");

        System.out.println("STEP - click on login button");
        clickOnElement(By.xpath(LOGIN_BUTTON));
    }

    public void doLogin(String accessCode, String studentId) {
        System.out.println("STEP - Enter Student id");
        setTextOnElement(By.xpath(STUDENT_ID_INPUT), studentId);

        System.out.println("STEP - Enter Access code");
        setTextOnElement(By.xpath(ACCESS_CODE_INPUT), accessCode);

        System.out.println("STEP - Click on continue button");
        clickOnElement(By.xpath(CONTINUE_BUTTON));

        System.out.println("STEP - Click on Sign In Food link");
        clickOnElement(By.xpath(CHOOSE_FOOD_APP));

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        clickOnElement(By.xpath(USER_AUTO_FILL_BUTTON));

        //System.out.println("STEP - Enter email");
        //driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("raghu.customer@technocredits.com");

        // System.out.println("STEP - Enter password");
        // driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("raghuCust@12345");

        System.out.println("STEP - click on login button");
        clickOnElement(By.xpath(LOGIN_BUTTON));
    }


>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
}
