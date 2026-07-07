package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.transform.sax.SAXResult;
import java.io.ObjectInputFilter;

public class OrderSuccessPage extends BrowserActions {

    private static String SUCCESS_VIEW_ORDER_LOCATOR = "//a[@data-testid='success-view-orders']";
    private static String CONFIRMATION_MESSAGE_LOCATOR= "//p[@class='text-slate-500']";
    private static String ORDER_ID_LOCATOR = "//span[@data-testid='success-order-number']";
    private static String AMOUNT_PAID_LOCATOR = "(//span[@class='text-slate-500'])[2]/following-sibling::span";
    private static String PAID_VIA_LOCATOR = "(//span[@class='text-slate-500'])[3]/following-sibling::span";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SUCCESS_VIEW_ORDER_LOCATOR)));
    }

    public String getConfirmationMessage(){
        return driver.findElement(By.xpath(CONFIRMATION_MESSAGE_LOCATOR)).getText();
    }

    public String getOrderId(){
        return driver.findElement(By.xpath(ORDER_ID_LOCATOR)).getText();
    }

    public String getAmountPaid(){
        return driver.findElement(By.xpath(AMOUNT_PAID_LOCATOR)).getText();
    }

    public String getPaymentMode(){
        return driver.findElement(By.xpath(PAID_VIA_LOCATOR)).getText();
    }

    public void clickOnViewOrders(){
        driver.findElement(By.xpath(SUCCESS_VIEW_ORDER_LOCATOR)).click();
    }
}
