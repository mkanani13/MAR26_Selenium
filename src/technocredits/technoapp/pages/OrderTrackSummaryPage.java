package technocredits.technoapp.pages;

import org.openqa.selenium.By;

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
            return true;
        }
        return false;
    }

    public boolean isEnjoyYourMeanTextPresent() {
//        try{
//            return driver.findElement(By.xpath(ENJOY_MEAL_TEXT)).isDisplayed();
//        }catch(NoSuchElementException ne){
//            return false;
//        }
        return isElementDisplayed(By.xpath(ENJOY_MEAL_TEXT));
    }

    public void waitForOrderToBeDelivered() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
