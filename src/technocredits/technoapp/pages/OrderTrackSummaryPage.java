package technocredits.technoapp.pages;

import org.openqa.selenium.By;
<<<<<<< HEAD
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderTrackSummaryPage extends BrowserActions {
    private final String ORDERTRACKSUMMARYPAGETITLE = "Track Order · Technocredits";

    public void waitForPageLoad(){
        waitForElementVisibility(By.xpath("//div[starts-with(text(),'ORDER#')]"));
    }

    public List<String> getOrderDetails(){
        List<String> orderDetailList = new ArrayList<>();
        orderDetailList.add(driver.findElement(By.xpath("//div[@data-testid='track-order-number']")).getText());
        String restaurantName = driver.findElement(By.xpath("//div[@class='text-sm text-slate-600']/div[1]")).getText().replace("Restaurant:","").trim();
        orderDetailList.add(restaurantName);
        orderDetailList.add(driver.findElement(By.xpath("//div[@data-testid='track-order-total']")).getText());
        return orderDetailList;
    }

    public void switchToTrackOrderWindow(){
        //String mainWindowHandleId = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowHandleIds = driver.getWindowHandles();

        for(String id : allWindowHandleIds){
            driver.switchTo().window(id);
            String currentTitle = driver.getTitle();
            if(currentTitle.equals(ORDERTRACKSUMMARYPAGETITLE)){
                break;
            }
        }
        System.out.println("----------After Tab Switch, title of the page is : " + driver.getTitle());
//        for(String id : allWindowHandleIds){
//            if(!id.equals(mainWindowHandleId)){
//                driver.switchTo().window(id);
//                break;
//            }
//        }
    }

    public boolean isOrderDelivered(){
        WebElement deliverStatusElement = driver.findElement(By.xpath("//div[@data-testid='track-step-delivered']/div[1]"));
        String className = deliverStatusElement.getAttribute("class");
        if(className.contains("border-slate-300 text-slate-400")){
            return false;
        }else if(className.contains("border-fd-brand text-fd-brand ring-4 ring-emerald-100")){
=======

import java.util.ArrayList;
import java.util.List;


/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class OrderTrackSummaryPage extends CommonPage {

    private final String ORDER_TRACK_SUMMARY_PAGE_TITLE = "Track Order · Technocredits";
    private final String ORDER_NUMBER_HEADER = "//div[starts-with(text(),'ORDER#')]";
    private final String ORDER_NUMBER = "//div[@data-testid='track-order-number']";
    private final String RESTAURANT_NAME = "//div[@class='text-sm text-slate-600']/div[1]";
    private final String ORDER_TOTAL = "//div[@data-testid='track-order-total']";
    private final String DELIVER_STATUS = "//div[@data-testid='track-step-delivered']/div[1]";
    private final String ENJOY_MEAL_TEXT = "//span[contains(text(),'Delivered — Enjoy your meal!')]";

    public void waitForPageLoad() {
        waitForElementVisibility(By.xpath(ORDER_NUMBER_HEADER));
    }

    public List<String> getOrderDetails() {
        List<String> orderDetailList = new ArrayList<>();
        orderDetailList.add(getTextFromElement(By.xpath(ORDER_NUMBER)));
        String restaurantName = getTextFromElement(By.xpath(RESTAURANT_NAME)).replace("Restaurant:", "").trim();
        orderDetailList.add(restaurantName);
        orderDetailList.add(getTextFromElement(By.xpath(ORDER_TOTAL)));
        return orderDetailList;
    }

    public void switchToTrackOrderWindow() {
        waitUntilWindowsCount(2);
        switchToWindowByTitle(ORDER_TRACK_SUMMARY_PAGE_TITLE);
        System.out.println("----------After Tab Switch, title of the page is : " + getPageTitle());
    }

    public boolean isOrderDelivered() {
//        String className = driver.findElement(By.xpath(DELIVER_STATUS)).getAttribute("class");
        String className = getElementAttribute(By.xpath(DELIVER_STATUS), "class");
        if (className.contains("border-slate-300 text-slate-400")) {
            return false;
        } else if (className.contains("border-fd-brand text-fd-brand ring-4 ring-emerald-100")) {
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public boolean isEnjoyYourMeanTextPresent(){
        try{
            return driver.findElement(By.xpath("//span[contains(text(),'Delivered — Enjoy your meal!')]")).isDisplayed();
        }catch(NoSuchElementException ne){
            return false;
        }
    }

    public void waitForOrderToBeDelivered(){
=======
    public boolean isEnjoyYourMeanTextPresent() {
//        try{
//            return driver.findElement(By.xpath(ENJOY_MEAL_TEXT)).isDisplayed();
//        }catch(NoSuchElementException ne){
//            return false;
//        }
        return isElementDisplayed(By.xpath(ENJOY_MEAL_TEXT));
    }

    public void waitForOrderToBeDelivered() {
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
<<<<<<< HEAD
        //wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@data-testid='track-step-delivered']/div[1]"),"class","border-fd-brand text-fd-brand ring-4 ring-emerald-100"));
        //wait.until(ExpectedConditions.attributeContains(deliverStatusElement,"class","border-fd-brand text-fd-brand ring-4 ring-emerald-100"));
=======
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
    }
}
