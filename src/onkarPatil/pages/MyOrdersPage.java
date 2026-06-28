package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyOrdersPage extends BrowserActions {

    private static String FIRST_ORDER_LOCATOR = "(//td[contains(@data-testid,'order-number')])[1]";
    private static String FIRST_ORDER_AMOUNT_LOCATOR = "//tbody[@data-testid='orders-tbody']/tr[1]/td[5]";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_ORDER_LOCATOR)));
    }

    public String getFirstOrderId(){
        return driver.findElement(By.xpath(FIRST_ORDER_LOCATOR)).getText();
    }

    public double getAmtDisplayedForFirstOrder(){
        String amtForFirstOrder = driver.findElement(By.xpath(FIRST_ORDER_AMOUNT_LOCATOR)).getText().substring(1);
        return Double.parseDouble(amtForFirstOrder);
    }
}
