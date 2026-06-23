
package Amitjoshi.AutomationScript.Pro;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

/**
 * End-to-End Food Ordering Automation — TestNG version
 * App under test : http://34.173.201.53/#/access  (Technocredits food delivery testbed)
 *
 * Framework: Selenium WebDriver 4 + TestNG (single file, no Page Object classes)
 *
 * Test methods are chained with dependsOnMethods so they execute in the exact
 * business-flow order (access gate -> login -> locality -> restaurant -> cart ->
 * checkout -> orders). If a step fails, TestNG automatically SKIPS (not fails) all
 * downstream dependent steps, which is the correct behavior for a sequential E2E flow.
 *
 * Dependencies to add to your build:
 *   - org.seleniumhq.selenium:selenium-java:4.21.0
 *   - org.testng:testng:7.10.2
 *   - io.github.bonigarcia:webdrivermanager:5.8.0   (optional, auto-manages chromedriver)
 *
 * Run via: testng.xml, your IDE's TestNG runner, or `gradle test` with useTestNG() configured.
 *
 * NOTE ON LOCATORS:
 * This app is a JS-rendered SPA, so its real element IDs/classes/text can only be
 * confirmed by inspecting the live DOM in the browser (right-click -> Inspect).
 * Locators marked "// TODO verify" are best-effort guesses based on common patterns
 * (visible button text, placeholder text, class-name fragments) — confirm/replace
 * them against the live app for a stable suite.
 */
public class FoodOrderingE2ETest {

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
        wait.until(ExpectedConditions.or(ExpectedConditions.not(ExpectedConditions.urlContains("/access")),ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email' or @name='email' or @placeholder='Email']"))
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
    public void testAddDishToCart() {
        // TODO verify: dish list item locator and "out of stock" indicator class/text
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'dish') or contains(@class,'menu-item')]")));

        List<WebElement> dishes = driver.findElements(
                By.xpath("//*[contains(@class,'dish') or contains(@class,'menu-item')]"));

        boolean dishAdded = false;
        for (WebElement dish : dishes) {
            boolean outOfStock = !dish.findElements(
                    By.xpath(".//*[contains(text(),'Out of Stock') or contains(text(),'Sold Out') or contains(@class,'unavailable')]")).isEmpty();

            if (outOfStock) {
                continue; // skip unavailable dish, move to next
            }

            List<WebElement> addButtons = dish.findElements(
                    By.xpath(".//button[contains(normalize-space(),'Add')]"));

            if (!addButtons.isEmpty()) {
                addButtons.get(0).click();
                dishAdded = true;
                log("Added in-stock dish to cart: " + dish.getText().split("\n")[0]);
                break;
            }
        }

        Assert.assertTrue(dishAdded, "No in-stock dish could be found/added to the cart.");
    }

    // ---------------- Step 10: Verify cart subtotal > 0 ----------------

    @Test(priority = 7, dependsOnMethods = "testAddDishToCart",
            description = "Verify the cart displays a subtotal greater than zero")
    public void testVerifyCartSubtotal() {
        // TODO verify: cart/subtotal locator — opening the cart panel may be needed first
        // e.g. driver.findElement(By.xpath("//*[contains(@class,'cart-icon')]")).click();

        WebElement subtotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class,'subtotal') or contains(text(),'Subtotal')]/following::*[contains(text(),'₹') or contains(text(),'Rs')][1] | //*[contains(@class,'subtotal')]")));

        String subtotalText = subtotalElement.getText().replaceAll("[^0-9.]", "");
        double subtotal = subtotalText.isEmpty() ? 0 : Double.parseDouble(subtotalText);

        Assert.assertTrue(subtotal > 0, "Expected cart subtotal > 0, but found: " + subtotal);
        log("Verified cart subtotal is greater than zero: " + subtotal);
    }

    // ---------------- Step 11: Delivery address + mobile number ----------------

    @Test(priority = 8, dependsOnMethods = "testVerifyCartSubtotal",
            description = "Enter a valid delivery address and mobile number")
    public void testEnterDeliveryDetails() {
        // TODO verify: delivery address & mobile number field locators on checkout page
        WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//textarea[contains(@placeholder,'Address') or contains(@name,'address')] | //input[contains(@placeholder,'Address') or contains(@name,'address')]")));
        addressField.clear();
        addressField.sendKeys(DELIVERY_ADDRESS);

        WebElement mobileField = driver.findElement(
                By.xpath("//input[contains(@placeholder,'Mobile') or contains(@name,'mobile') or contains(@type,'tel')]"));
        mobileField.clear();
        mobileField.sendKeys(MOBILE_NUMBER);

        Assert.assertEquals(addressField.getAttribute("value"), DELIVERY_ADDRESS,
                "Delivery address field did not retain the entered value.");
        Assert.assertEquals(mobileField.getAttribute("value"), MOBILE_NUMBER,
                "Mobile number field did not retain the entered value.");

        log("Entered delivery address and mobile number.");
    }

    // ---------------- Step 12: "I am not a robot" checkbox ----------------

    @Test(priority = 9, dependsOnMethods = "testEnterDeliveryDetails",
            description = "Select the 'I am not a robot' confirmation checkbox")
    public void testConfirmNotARobot() {
        // TODO verify: checkbox locator for "I am not a robot — confirm before placing order"
        WebElement robotCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type='checkbox'][following-sibling::*[contains(text(),'not a robot')] or preceding-sibling::*[contains(text(),'not a robot')]] | //*[contains(text(),'not a robot')]/preceding::input[@type='checkbox'][1]")));

        if (!robotCheckbox.isSelected()) {
            robotCheckbox.click();
        }

        Assert.assertTrue(robotCheckbox.isSelected(), "'I am not a robot' checkbox was not selected.");
        log("Checked 'I am not a robot' confirmation checkbox.");
    }

    // ---------------- Step 13: Place order ----------------

    @Test(priority = 10, dependsOnMethods = "testConfirmNotARobot",
            description = "Click the 'Place Order' button")
    public void testPlaceOrder() {
        // TODO verify: "Place Order" button locator
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(normalize-space(),'Place Order')]")));

        Assert.assertTrue(placeOrderBtn.isEnabled(), "'Place Order' button is not enabled.");
        placeOrderBtn.click();
        log("Clicked 'Place Order'.");
    }

    // ---------------- Step 14-15: Verify My Orders page + new order ----------------

    @Test(priority = 11, dependsOnMethods = "testPlaceOrder",
            description = "Verify 'My Orders' page is displayed and the new order is visible")
    public void testVerifyOrderPlaced() {
        // TODO verify: "My Orders" page heading/URL and order list item locator
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("orders"),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'My Orders')]"))
        ));

        boolean onMyOrdersPage = driver.getCurrentUrl().toLowerCase().contains("order")
                || !driver.findElements(By.xpath("//*[contains(text(),'My Orders')]")).isEmpty();

        Assert.assertTrue(onMyOrdersPage, "'My Orders' page was not displayed after placing the order.");

        // The most recent order is typically the first item in the orders list
        WebElement latestOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//*[contains(@class,'order-item') or contains(@class,'order-card')])[1]")));

        Assert.assertFalse(latestOrder.getText().trim().isEmpty(),
                "Newly placed order details were not visible on the 'My Orders' page.");
        log("Verified 'My Orders' page shows the new order: " + latestOrder.getText().split("\n")[0]);
    }

    // ---------------- Utility ----------------

    private void log(String message) {
        System.out.println("[E2E] " + message);
    }
}
