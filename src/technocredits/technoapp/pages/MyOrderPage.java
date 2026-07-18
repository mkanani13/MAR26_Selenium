package technocredits.technoapp.pages;

import org.openqa.selenium.By;
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

        return mapOfOrderItem;
    }
}
