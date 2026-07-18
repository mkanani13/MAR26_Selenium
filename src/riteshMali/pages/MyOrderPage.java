package riteshMali.pages;


import org.openqa.selenium.By;
import riteshMali.base.BrowserActions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyOrderPage extends BrowserActions {
    private final String SEARCH_INPUT = "//input[@id='filter-search']";
    private final String ORDERS_TABLE_BODY = "//tbody[@id='orders-tbody']/tr[1]/td[2]";
    private final String ORDER_TO_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[2]";
    private final String ORDER_DATE_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[3]";
    private final String RESTAURANT_NAME_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[4]";
    private final String ORDER_TOTAL_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[6]";
    private final String ORDER_STATUS_COLUMN = "//tbody[@id='orders-tbody']/tr[1]/td[7]";


    public void waitForPageLoad() {
         waitForElementVisibility(By.xpath(SEARCH_INPUT));
    }

    public void searchOrderWithExactId(String orderId) {
        setTextOnElement(By.xpath(SEARCH_INPUT), orderId);
        waitForElementTOBe(By.xpath(ORDERS_TABLE_BODY),1);
    }

    public Map<String, String> getOrderDetails() {
        Map<String, String> mapOfOrderitem = new LinkedHashMap<String, String>();
        String orderId = getTextFromElement(By.xpath(ORDER_TO_COLUMN));
        String date = getTextFromElement(By.xpath(ORDER_DATE_COLUMN));
        String restaurant = getTextFromElement(By.xpath(RESTAURANT_NAME_COLUMN));
        String total = getTextFromElement(By.xpath(ORDER_TOTAL_COLUMN));
        String status = getTextFromElement(By.xpath(ORDER_STATUS_COLUMN));

        getOrderDetails().put("Order #", orderId);
        getOrderDetails().put("Date", date);
        getOrderDetails().put("Restaurant", restaurant);
        getOrderDetails().put("Total", total);
        getOrderDetails().put("Status", status);
        return mapOfOrderitem;
    }

    public List<String> getOrderStatus() {
        List<String> orderStatusList = new ArrayList<String>();
        orderStatusList.add("pending");
        orderStatusList.add("Accepted");
        orderStatusList.add("Out for delivery");
        orderStatusList.add("Delivered");
        orderStatusList.add("Cancelled");
        return orderStatusList;
    }


}
