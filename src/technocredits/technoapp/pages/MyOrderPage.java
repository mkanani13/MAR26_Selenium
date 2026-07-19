package technocredits.technoapp.pages;

import org.openqa.selenium.By;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyOrderPage extends BrowserActions {
    WebElement searchElement;

    public void waitForPageLoad(){
        searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='filter-search']")));
    }

    public void searchOrderWithExactId(String orderId){
        searchElement.sendKeys(orderId);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody[@id='orders-tbody']/tr"),1));
    }

    public Map<String,String> getOrderDetails(){
        Map<String, String> mapOfOrderItem = new LinkedHashMap<String, String>();
        String orderId = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[2]")).getText();
        String date = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[3]")).getText();
        String restaurant = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[4]")).getText();
        String total = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[5]")).getText();
        String status = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[6]")).getText();

        mapOfOrderItem.put("Order #", orderId);
        mapOfOrderItem.put("Date", date);
        mapOfOrderItem.put("Restaurant", restaurant);
        mapOfOrderItem.put("Total", total);
        mapOfOrderItem.put("Status", status);
=======
import technocredits.technoapp.base.BrowserActions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class MyOrderPage extends CommonPage {
    // XPath Constants for locators
    private final String SEARCH_INPUT = "//input[@id='filter-search']";
    private final String ORDERS_TABLE_BODY = "//tbody[@id='orders-tbody']/tr";
    private final String ORDER_ID_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[2]";
    private final String ORDER_DATE_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[3]";
    private final String RESTAURANT_NAME_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[4]";
    private final String ORDER_TOTAL_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[5]";
    private final String ORDER_STATUS_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[6]";

    public void waitForPageLoad() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_INPUT)));
        waitForElementVisibility(By.xpath(SEARCH_INPUT));
    }

    public void searchOrderWithExactId(String orderId) {
//        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(orderId);
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(ORDERS_TABLE_BODY), 1));
        setTextOnElement(By.xpath(SEARCH_INPUT), orderId);
        waitForElementToBe(By.xpath(ORDERS_TABLE_BODY), 1);
    }

    public Map<String, String> getOrderDetails() {
        Map<String, String> mapOfOrderItem = new LinkedHashMap<String, String>();

        mapOfOrderItem.put("Order #", getTextFromElement(By.xpath(ORDER_ID_COLUMN)));
        mapOfOrderItem.put("Date", getTextFromElement(By.xpath(ORDER_DATE_COLUMN)));
        mapOfOrderItem.put("Restaurant", getTextFromElement(By.xpath(RESTAURANT_NAME_COLUMN)));
        mapOfOrderItem.put("Total", getTextFromElement(By.xpath(ORDER_TOTAL_COLUMN)));
        mapOfOrderItem.put("Status", getTextFromElement(By.xpath(ORDER_STATUS_COLUMN)));
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

        return mapOfOrderItem;
    }
}
