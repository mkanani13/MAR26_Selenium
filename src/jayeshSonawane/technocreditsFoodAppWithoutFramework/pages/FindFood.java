package jayeshSonawane.technocreditsFoodAppWithoutFramework.pages;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class FindFood extends BrowserActions {

    public void verifyLoggedInUserName() {
        System.out.println("STEP - Verify Logged In Username");
        String email = "jayesh.customer@technocredits.com";
        String expectedUserName = email.substring(0, email.indexOf('@'));
        String actualUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'jayesh.customer')]"))).getText().split(" ")[1];
        Assert.assertEquals(actualUserName, expectedUserName, "Verify Logged In Username");
    }

    public void findRestaurantByLocality(String locality, String restaurant) {
        System.out.println("STEP - From the locality dropdown, select " + locality);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Balance Brew Cafe logo']")));
//        WebElement elLocalityDD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='locality-filter' and @data-testid='locality-dropdown']")));
        WebElement elLocalityDD = driver.findElement(By.xpath("//select[@id='locality-filter' and @data-testid='locality-dropdown']"));
//        WebElement elLocalityDD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='locality-filter' and @data-testid='locality-dropdown']")));
        Select localityOptions = new Select(elLocalityDD);
        localityOptions.selectByVisibleText(locality);

        System.out.println("STEP - Open the restaurant " + restaurant + " and Click the View & Order button.");
        String actualRestaurantName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'Abhishek Pure Veg')]"))).getText();
        actualRestaurantName = actualRestaurantName.substring(0, actualRestaurantName.indexOf(" Non-Veg"));
        Assert.assertEquals(restaurant, actualRestaurantName, "Open the restaurant " + restaurant + " and Click the View & Order button.");

        WebElement elViewAndOrder_AbhishekPureVeg = driver.findElement(By.xpath("//h3[contains(text(),'Abhishek Pure Veg')]/ancestor::div[contains(@class, 'flex items-start gap')]/following-sibling::a"));
        elViewAndOrder_AbhishekPureVeg.click();

        actualRestaurantName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2"))).getText();
        Assert.assertEquals(restaurant, actualRestaurantName);
    }

    public void addInStockDishToCart() {

        System.out.println("STEP - Add any available (in-stock) dish to the shopping cart.");
        WebElement elItemQuantity = driver.findElement(By.xpath("(//table/tbody/tr/td[4][not(text()='0')]/following-sibling::td)[1]/input"));
        elItemQuantity.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();

        System.out.println("STEP - Verify that the cart displays a subtotal greater than zero.");
        String strSubTotal = driver.findElement(By.xpath("//div[@id='order-totals']/strong[@id='ot-subtotal']")).getText().substring(1);
        double subTotal = Double.parseDouble(strSubTotal);
        Assert.assertTrue(subTotal > 0, "Verify that the cart displays a subtotal greater than zero.");

        System.out.println("Click on Proceed to Checkout");
        WebElement elProceedToCheckoutButton = driver.findElement(By.id("proceed-checkout-btn"));
        elProceedToCheckoutButton.click();
    }

    public void addDeliveryDetails() {

        System.out.println("STEP - Enter Delivery Address");
        WebElement elDeliveryAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("co-address")));
        elDeliveryAddress.sendKeys("Wakad");

        System.out.println("STEP - Enter Contact Mobile");
        WebElement elContactMobile = driver.findElement(By.id("co-mobile"));
        elContactMobile.sendKeys("9730287487");

        System.out.println("STEP - Click on Continue to Payment");
        driver.findElement(By.id("co-continue")).click();
    }

    public void placeOrderUsingUpi() {
        System.out.println("STEP - Enter UPI ID");
        WebElement elUPiId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("f-upi")));
        elUPiId.sendKeys("jayesh@sbi");

        System.out.println("STEP - Click on I'm not a robot - confirm before paying");
        WebElement elIAmNotRobotCheckBox = driver.findElement(By.id("pay-captcha"));
        elIAmNotRobotCheckBox.click();

        System.out.println("Check wallet balance");
        String strTotalPayable = driver.findElement(By.xpath("//span[text()='Total payable']/following-sibling::span")).getText().substring(1);
        Double totalPayable = Double.parseDouble(strTotalPayable);
        String strWalletBalance = driver.findElement(By.xpath("//p[contains(text(), 'Wallet balance')]/strong")).getText();
        Double walletBalance = Double.parseDouble(strWalletBalance);
        Assert.assertTrue(walletBalance > totalPayable, "Check wallet balance");

        System.out.println("STEP - Click on Place Order");
        WebElement elPlaceOrderButton = driver.findElement(By.id("pay-btn"));
        elPlaceOrderButton.click();
    }

}
