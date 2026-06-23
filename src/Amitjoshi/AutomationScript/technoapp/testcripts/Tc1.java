package Amitjoshi.AutomationScript.technoapp.testcripts;

import Amitjoshi.AutomationScript.technoapp.base.BrowserActions;
import Amitjoshi.AutomationScript.technoapp.pages.LoginPage;
import Amitjoshi.AutomationScript.technoapp.pages.RestaurantsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static Amitjoshi.AutomationScript.Pro.FoodOrderingE2ETest.*;
import static org.testng.Reporter.log;

public class Tc1 {
    // ---- Test data ----
    private static final String BASE_URL = "http://34.173.201.53/#/access";
    private static final String STUDENT_ID = "P6YUZ7U34R";
    private static final String ACCESS_CODE = "V6GBJZ93";
    private static final String VALID_EMAIL = "amit.customer@technocredits.com";
    private static final String VALID_PASSWORD = "Amit@123";
    private static final String LOCALITY = "Kothrud";
    private static final String RESTAURANT_NAME = "Abhishek Pure Veg";
    private static final String DELIVERY_ADDRESS = "123, FC Road, Shivajinagar, Pune, Maharashtra 411005";
    private static final String MOBILE_NUMBER = "9876543210";                     // TODO update with valid format
    private WebDriver driver;
    private WebDriverWait wait;

    // ---------------- Setup / Teardown ----------------

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        // If using WebDriverManager (recommended), uncomment:
        // io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ---------------- Step 1: Access page (Student ID + Access Code gate) ----------------

    @Test(priority = 1, description = "Launch browser, open Access page, enter Student ID & Access Code to unlock the app")
    public void testAccessPage() {
        driver.get(BASE_URL);
        log("Navigated to: " + BASE_URL);

        // Wait for the SPA to finish loading and the access form to render
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[normalize-space()='Student ID']")));

        // Locate each input via its visible label text. The earlier attribute-based
        // locators (placeholder/name/id containing "student"/"access") both matched
        // the SAME element, which caused the Access Code value to overwrite the
        // Student ID field and leave the real Access Code box empty.
        WebElement studentIdField = driver.findElement(
                By.xpath("//input[@id = 'access-student-id']"));
        studentIdField.clear();
        studentIdField.sendKeys(STUDENT_ID);

        WebElement accessCodeField = driver.findElement(
                By.xpath("//input[@id = 'access-code']"));
        accessCodeField.clear();
        accessCodeField.sendKeys(ACCESS_CODE);

        // Sanity-check both fields actually hold the right values before submitting,
        // so a locator collision like before fails fast with a clear message.
        Assert.assertEquals(studentIdField.getAttribute("value"), STUDENT_ID,
                "Student ID field does not contain the expected value before submission.");
        Assert.assertEquals(accessCodeField.getAttribute("value"), ACCESS_CODE,
                "Access Code field does not contain the expected value before submission.");

        // The submit button sits directly below the Access Code field
        WebElement continueBtn = driver.findElement(
                By.xpath("//label[normalize-space()='Access Code']/following::button[1]"));
        continueBtn.click();

        log("Submitted Student ID and Access Code on the access gate.");

        // Confirm we've moved past the access gate (URL changes away from #/access, or login form appears)
        wait.until(ExpectedConditions.or(
                ExpectedConditions.not(ExpectedConditions.urlContains("/access")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email' or @name='email' or @placeholder='Email']"))
        ));

        Assert.assertFalse(driver.getCurrentUrl().toLowerCase().contains("/access"),
                "Still on the Access page after submitting Student ID and Access Code — access may not have been granted.");
        log("Access granted, proceeded past the access gate.");
    }

    // ---------------- Step 2-5: Launch, navigate, login ----------------

    @Test(priority = 2, dependsOnMethods = "testAccessPage",
            description = "Open login page (if not already there) and login with valid credentials")
    public void testLaunchAndLogin() {
        // If the access gate doesn't auto-redirect to the login page, navigate explicitly
        if (!driver.getCurrentUrl().toLowerCase().contains("login")) {
            driver.get("http://34.173.201.53/#/login");
            log("Navigated to login page explicitly.");
        }

        // TODO verify: input field locators for email/password on the login form
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='email' or @name='email' or @placeholder='Email']")));
        emailField.clear();
        emailField.sendKeys(VALID_EMAIL);

        WebElement passwordField = driver.findElement(
                By.xpath("//input[@type='password' or @name='password' or @placeholder='Password']"));
        passwordField.clear();
        passwordField.sendKeys(VALID_PASSWORD);

        WebElement loginBtn = driver.findElement(
                By.xpath("//button[normalize-space()='Login' or normalize-space()='Log In' or normalize-space()='Sign In']"));
        loginBtn.click();

        log("Submitted login form for: " + VALID_EMAIL);
    }

    // ---------------- Step 6: Verify logged-in user in top nav ----------------

    @Test(priority = 3, dependsOnMethods = "testLaunchAndLogin",
            description = "Verify logged-in user's name is displayed in the top navigation bar")
    public void testVerifyUserLoggedIn() {
        // TODO verify: locator for the user's name in the top navigation bar
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@id = 'user-chip-name']")));

        String displayedName = userNameElement.getText().trim();

        Assert.assertFalse(displayedName.isEmpty(),
                "Logged-in user's name was not displayed in the top navigation bar.");
        log("Verified logged-in user displayed in top nav: " + displayedName);
    }

    // ---------------- Step 6: Select locality ----------------

    @Test(priority = 4, dependsOnMethods = "testVerifyUserLoggedIn",
            description = "Select 'Kothrud' from the locality dropdown")
    public void testSelectLocality() {
        // TODO verify: locality dropdown locator — could be a <select> or a custom
        // dropdown (div/ul-li based). Handling both common patterns below.
        WebElement localityDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//select[@id = 'locality-dropdown']")));
        localityDropdown.click();

        WebElement localityOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='" + LOCALITY + "'] | //option[normalize-space()='" + LOCALITY + "'] | //*[normalize-space(text())='" + LOCALITY + "']")));
        localityOption.click();

        log("Selected locality: " + LOCALITY);

        // Soft confirmation that the page reflects the chosen locality, if it's echoed somewhere
        List<WebElement> localityEcho = driver.findElements(
                By.xpath("//*[contains(text(),'" + LOCALITY + "')]"));
        Assert.assertFalse(localityEcho.isEmpty(), "Locality '" + LOCALITY + "' selection was not reflected on the page.");
    }

    // ---------------- Step 7-8: Open restaurant, View & Order ----------------

    @Test(priority = 5, dependsOnMethods = "testSelectLocality",
            description = "Open restaurant 'Abhishek Pure Veg' and click 'View & Order'")
    public void testOpenRestaurantAndViewOrder() {
        // TODO verify: restaurant card locator on the listing page
        WebElement restaurantCard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'" + RESTAURANT_NAME + "')]")));
        restaurantCard.click();
        log("Opened restaurant: " + RESTAURANT_NAME);

        // TODO verify: "View & Order" button locator
        WebElement viewAndOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Abhishek Pure Veg']/following::a[contains(text(), 'View & order')][1]")));
        viewAndOrderBtn.click();
        log("Clicked 'View & Order'.");

        Assert.assertFalse(driver.getCurrentUrl().toLowerCase().contains("menu") || !driver.findElements(By.xpath("//div[@class='bg-white rounded-xl shadow p-6']")).isEmpty(),
                "Restaurant menu page did not load after clicking 'View & Order'.");
    }

    // ---------------- Step 9: Add in-stock dish to cart ----------------

    @Test(priority = 6, dependsOnMethods = "testOpenRestaurantAndViewOrder",
            description = "Add an available (in-stock) dish to the shopping cart")

    public void verifyPlaceOrderFeature() {


        System.out.println("STEP - Click on View & Order of the restaurants having dishes");

        driver.findElement(By.xpath(
                "//div[@data-testid='restaurants-grid']//p[contains(text(), '0 dishes')]"
        )).click();


        System.out.println("STEP - Drag the first item from the menu which is in stock");

        WebElement itemElement = driver.findElement(By.xpath(
                "//table[@data-testid='menu-table']//tbody/tr[1]"
        ));

        WebElement dropAreaElement = driver.findElement(By.xpath(
                "//div[@id='cart-dropzone']"
        ));


        Actions actions = new Actions(driver);

        actions.dragAndDrop(itemElement, dropAreaElement).perform();
    }
}