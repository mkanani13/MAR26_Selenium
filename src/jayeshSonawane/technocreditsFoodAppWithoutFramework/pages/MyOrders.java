package jayeshSonawane.technocreditsFoodAppWithoutFramework.pages;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MyOrders extends BrowserActions {

    public void verifyOrderPlaced(){
        System.out.println("STEP - Verify that order placed and 'My Orders' page is displayed.");
        String expectedLinkText = "My Orders";
        String actualLinkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'My Orders')]"))).getText();
        actualLinkText = actualLinkText.substring(actualLinkText.indexOf("My Orders"));
        Assert.assertEquals(actualLinkText, expectedLinkText, "STEP - Verify that order placed and 'My Orders' page is displayed.");
    }

    public void orderDetails(){
        System.out.println("STEP - Confirm that the newly placed order details are visible on the 'My Orders' page.");
        WebElement elOrderNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'ORDER#')]")));
        Assert.assertTrue(elOrderNumber.isDisplayed(), "STEP - Confirm that the newly placed order details are visible on the 'My Orders' page.");
    }
}
