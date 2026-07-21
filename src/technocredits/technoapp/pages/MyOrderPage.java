package technocredits.technoapp.pages;

import org.openqa.selenium.By;
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

        return mapOfOrderItem;
    }
}
