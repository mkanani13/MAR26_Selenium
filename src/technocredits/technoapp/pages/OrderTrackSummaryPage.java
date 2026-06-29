package technocredits.technoapp.pages;

import org.openqa.selenium.By;
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
            return true;
        }
        return false;
    }

    public boolean isEnjoyYourMeanTextPresent(){
        try{
            return driver.findElement(By.xpath("//span[contains(text(),'Delivered — Enjoy your meal!')]")).isDisplayed();
        }catch(NoSuchElementException ne){
            return false;
        }
    }

    public void waitForOrderToBeDelivered(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@data-testid='track-step-delivered']/div[1]"),"class","border-fd-brand text-fd-brand ring-4 ring-emerald-100"));
        //wait.until(ExpectedConditions.attributeContains(deliverStatusElement,"class","border-fd-brand text-fd-brand ring-4 ring-emerald-100"));
    }
}
