package jayeshSonawane.technocreditsFoodAppWithFramework.pages;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersOrderPlacedPage extends BrowserActions {

    private final String ORDERMOREBUTTONXPATH = "//a[text()='Order more']";
    private final String ORDERNUMBERXPATH = "//span[starts-with(text(),'ORDER#')]";
    public static final String MYORDERSORDERPLACEDPAGEID = driver.getWindowHandle();

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(ORDERMOREBUTTONXPATH));
    }

    public boolean isOrderPlaced(){
        try {
            driver.findElement(By.xpath(ORDERNUMBERXPATH));
            return true;
        }catch (NoSuchElementException ne){
            return false;
        }
    }

    public String getRestaurantName(){
        return driver.findElement(By.xpath("//div[@id='success-host']//strong")).getText();
    }

    public boolean isOrderNumberPresent(){
        return driver.findElement(By.xpath("//span[text()='Order number']")).isDisplayed() && driver.findElement(By.xpath(ORDERNUMBERXPATH)).isDisplayed();
    }

    public boolean isAmountPaidPresent(){
        return driver.findElement(By.xpath("//span[text()='Amount paid']")).isDisplayed();
    }

    public boolean isPaidViaPresent(){
        return driver.findElement(By.xpath("//span[text()='Paid via']")).isDisplayed();
    }

    public List<String> getOrderDetails(){
        List<String> orderDetails = new ArrayList<>();

        orderDetails.add(driver.findElement(By.xpath(ORDERNUMBERXPATH)).getText());
        orderDetails.add(driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText());
        orderDetails.add(driver.findElement(By.xpath("//div[@id='success-host']/div/div/div/following-sibling::div[2]/span[2]")).getText());

        return orderDetails;
    }

    public void clickOnTrackOrderButton(){
        driver.findElement(By.xpath("//a[text()='Track order']")).click();
    }

    public void clickOnViewMyOrdersButton(){
        driver.findElement(By.xpath("//a[text()='View my orders']")).click();
    }

    public static String getMyOrdersOrderPlacedPageId(){
        return driver.getWindowHandle();
    }

    public void switchToTrackOrderPageWindow() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

//        for(String id : BrowserActions.getWindowHandles()){
//            driver.switchTo().window(id);
//            if(!id.equals(MYORDERSORDERPLACEDPAGEID)){
//                break;
//            }
//        }

        for (String id : BrowserActions.getWindowHandles()) {
            driver.switchTo().window(id);
            String currentTitle = driver.getTitle();
            if (currentTitle.equals("Track Order · Technocredits")) {
                break;
            }
        }
    }

}
