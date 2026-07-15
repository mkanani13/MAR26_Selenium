package technocredits.technoapp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import technocredits.technoapp.base.BrowserActions;
import technocredits.technoapp.pages.LoginPage;
import technocredits.technoapp.pages.FindFoodPage;

import java.time.Duration;
import java.util.regex.Pattern;

public class Tc2 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void verifyPlaceOrderFeature(){
        System.out.println("STEP - Select location as Baner");
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.setLocationInDropdown("Baner");

        System.out.println("STEP - Click on View & Order of the restaurants having dishes");
        driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[not(contains(text(),' 0 dishes'))]/following::a[1])[1]")).click();

        System.out.println("STEP - Drag the first item from the menu which is in stock into the drop area");
        WebElement itemElement = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]"));
        WebElement dropAreaElement = driver.findElement(By.xpath("//div[@id='cart-dropzone']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(itemElement,dropAreaElement).perform();

        System.out.println("VERIFY - Item quantity should be 1");
        WebElement qElement  = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/following-sibling::td[1]/input"));
        String quantity = qElement.getAttribute("value");
        Assert.assertEquals(quantity,"1");

        System.out.println("STEP - Increase quantity by 1");
        qElement.click();
        actions.sendKeys(Keys.ARROW_UP).perform();

        System.out.println("VERIFY - Item quantity should be 2");
        quantity = qElement.getAttribute("value");
        Assert.assertEquals(quantity,"2");

        System.out.println("STEP - Enter address");
        driver.findElement(By.xpath("//input[@id='addr-pick-input']")).sendKeys("Wakad");

        System.out.println("STEP - Enter mobile number");
        driver.findElement(By.xpath("//input[@data-testid='contact-mobile']")).sendKeys("9765463742");

        System.out.println("STEP - Click on I am not a robot checkbox");
        driver.findElement(By.xpath("//input[@id='captcha-checkbox']")).click();

        System.out.println("STEP - Apply Coupan");
        WebElement coupanCodeElement = driver.findElement(By.xpath("//select[@id='coupon-code']"));
        Select coupanSelet = new Select(coupanCodeElement);
        coupanSelet.selectByIndex(1);

        System.out.println("STEP - Click on place order button");
        driver.findElement(By.xpath("//button[@data-testid='place-order-btn']")).click();

        System.out.println("STEP - fetch order id from progress bar");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textMatches(By.xpath("//span[@data-testid='order-progress-label']"), Pattern.compile("Order ORDER#")));
        String text = driver.findElement(By.xpath("//span[@data-testid='order-progress-label']")).getText();
        String orderId = text.split(" ")[1];
        System.out.println("ORDER ID IS " + orderId);

        System.out.println("VERIFY - order is present in My order list");
        boolean flag = driver.findElement(By.xpath("//td[1][text()='"+orderId+"']")).isDisplayed();
        Assert.assertTrue(flag, "Order id " + orderId + " was not displayed");

    }
}
