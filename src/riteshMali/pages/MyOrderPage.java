package riteshMali.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyOrderPage extends BrowserActions {
    WebElement searchElement;

    public void waitForPageLoad() {
        searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='filter-search']")));
    }

    public void searchOrderWithExactId(String orederId) {
        searchElement.sendKeys(orederId);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[2]"), 1));
    }

    public Map<String, String> getOrderDetails() {
        Map<String, String> mapOfOrderitem = new LinkedHashMap<String, String>();
        String orderId = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[2]")).getText();
        String date = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[3]")).getText();
        String restaurant = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[4]")).getText();
        String total = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[6]")).getText();
        String status = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[7]")).getText();

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
