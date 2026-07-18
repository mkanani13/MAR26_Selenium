package onkarPatil.pages;

import com.sun.source.tree.LambdaExpressionTree;
import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.transform.sax.SAXResult;
import java.io.ObjectInputFilter;

public class OrderSuccessPage extends BrowserActions {

    public OrderSuccessPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-testid='success-view-orders']")
    WebElement successViewOrderElement;

    @FindBy(xpath = "//p[@class='text-slate-500']")
    WebElement confirmationMessageElement;

    @FindBy(xpath = "//span[@data-testid='success-order-number']")
    WebElement orderIdElement;

    @FindBy(xpath = "(//span[@class='text-slate-500'])[2]/following-sibling::span")
    WebElement amountPaidElement;

    @FindBy(xpath = "(//span[@class='text-slate-500'])[3]/following-sibling::span")
    WebElement paidViaElement;

    private static String SUCCESS_VIEW_ORDER_LOCATOR = "//a[@data-testid='success-view-orders']";
    private static String CONFIRMATION_MESSAGE_LOCATOR= "//p[@class='text-slate-500']";
    private static String ORDER_ID_LOCATOR = "//span[@data-testid='success-order-number']";
    private static String AMOUNT_PAID_LOCATOR = "(//span[@class='text-slate-500'])[2]/following-sibling::span";
    private static String PAID_VIA_LOCATOR = "(//span[@class='text-slate-500'])[3]/following-sibling::span";

    public void waitForPageLoad(){
        waitUntilElementIsClickable(successViewOrderElement);
    }

    public String getConfirmationMessage(){
        return getTextOfElement(confirmationMessageElement, false);
    }

    public String getOrderId(){
        return getTextOfElement(orderIdElement, false);
    }

    public String getAmountPaid(){
        return getTextOfElement(amountPaidElement, false);
    }

    public String getPaymentMode(){
        return getTextOfElement(paidViaElement, false);
    }

    public void clickOnViewOrders(){
        clickOnElement(successViewOrderElement, false);
    }
}
