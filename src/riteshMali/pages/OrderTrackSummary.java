package riteshMali.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderTrackSummary extends BrowserActions {

    private WebElement backToMyOrderBtn;


    public void waitForPageLoad() {
        backToMyOrderBtn = waitForElementVisibility(By.xpath("//a[@data-testid='track-done-back']"));
    }

    public List<String> getOrderDetails() {
        List<String> orderDetailList = new ArrayList<String>();
        orderDetailList.add(driver.findElement(By.xpath("//div[@data-testid='track-order-number']")).getText());
        String restaurantName = String.valueOf(orderDetailList.add(driver.findElement(By.xpath("//div[@class='text-sm text-slate-600']/div[1]")).getText()));
        restaurantName.replace("Restaurant:", "").trim();
        orderDetailList.add(restaurantName);
        orderDetailList.add(driver.findElement(By.xpath("//div[@data-testid='track-order-total']")).getText());

        return orderDetailList;

    }

    public void switchToTrackOrderDetails() {
        //String mainWindowHandleId = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowHandleId = driver.getWindowHandles();
        for (String id : allWindowHandleId) {
            driver.switchTo().window(id);
            String currentTitle = driver.getTitle();
            if (currentTitle.equals("Track Order · Technocredits")) {
                break;
            }

        }

    }
}
