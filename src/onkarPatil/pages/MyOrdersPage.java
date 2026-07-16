package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class MyOrdersPage extends BrowserActions {

    public MyOrdersPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//td[contains(@data-testid,'order-number')])[1]")
    WebElement firstOrderElement;

    @FindBy(xpath = "//tbody[@data-testid='orders-tbody']/tr[1]/td[6]")
    WebElement firstOrderAmtLocator;


    public void waitForPageLoad(){
        waitUntilElementIsClickable(firstOrderElement);
    }

    public String getFirstOrderId(){
        return getTextOfElement(firstOrderElement, false);
    }

    public double getAmtDisplayedForFirstOrder(){
        String amtForFirstOrder = getTextOfElement(firstOrderAmtLocator, false).substring(1);
        return Double.parseDouble(amtForFirstOrder);
    }

    public String getDateForGivenOrder(String orderId){
        return getTextOfElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[1]"), false);
    }

    public String getRestaurantNameForGiverOrder(String orderId){
        String restaurantNameWithLocation = getTextOfElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[2]"), false);
        return restaurantNameWithLocation.split("\n")[0];
    }

    public Double getTotalAmtForGivenOrder(String orderId){
        String amtText = getTextOfElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[4]"), false).substring(1);
        return Double.parseDouble(amtText);
    }

    public String getStatusForGivenOrder(String orderId){
        return getTextOfElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[5]"), false);
    }
}
