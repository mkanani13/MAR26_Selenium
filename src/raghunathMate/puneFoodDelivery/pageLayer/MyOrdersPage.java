package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import puneFoodDelivery.testBase.BrowserAction;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyOrdersPage extends BrowserAction {
    String orderIdFroMOrderSuccessPage;
    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));
    }

    public boolean getpageTitleFlage(){
        boolean pageTileFlage = driver.findElement(By.xpath("//h1[text()='My Orders']")).isDisplayed();
        return pageTileFlage;
    }

    public boolean checkOrderIdIsPresentOrNotInMyOrderPage(String orderId){
        boolean orderIdPresentFlage = false;
        List<WebElement> listOfOrderIDs = driver.findElements(By.xpath("//tr/td[1]"));
        for(WebElement id : listOfOrderIDs){
            if(orderId.equals(id.getText())){
                orderIdPresentFlage = true;
                break;
            }
        }
        return orderIdPresentFlage;
    }

    public void printOrderDetails(String orderId){

        List<WebElement> orderDetails = driver.findElements(By.xpath("//tr[1]/td"));
        List<String> orderDetailsText = new LinkedList<String>();
        for(int i =1; i<=5;i++) {
            orderDetailsText.add(orderDetails.get(i).getText());
        }
        System.out.println(orderDetailsText);
    }

    public Map<String, String> getOrderDetails(String orderId){
        Map<String, String> orderDetailsMap = new LinkedHashMap<String,String>();
        String order_Id = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[2]")).getText();
        String date = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[3]")).getText();
        String restaurant = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[4]")).getText();
        String total = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[6]")).getText();
        String status = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[7]")).getText();
        orderDetailsMap.put("Order #",order_Id);
        orderDetailsMap.put("Date",date);
        orderDetailsMap.put("Restaurant",restaurant);
        orderDetailsMap.put("Total",total);
        orderDetailsMap.put("Status",status);
        return orderDetailsMap;
    }

    public String getOrderIdFromSearchBar(String orderId){
        driver.findElement(By.xpath("//input[@data-testid='orders-search']")).sendKeys(orderId);
        String OrderIdFromMyOrdersPage = driver.findElement(By.xpath("//td[contains(@data-testid,'order-number-ORDER#')]")).getText();
        return OrderIdFromMyOrdersPage;
    }



}
