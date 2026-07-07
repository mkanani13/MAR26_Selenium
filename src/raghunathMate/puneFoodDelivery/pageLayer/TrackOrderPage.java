package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import puneFoodDelivery.testBase.BrowserAction;

import java.util.Set;

public class TrackOrderPage extends BrowserAction {
    private WebElement orderIDFromTrackOrderPage;

    public void waitForWindowLoad(){
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void waitForPageLoad(){
        orderIDFromTrackOrderPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='track-order-number']")));
    }


    public void switchWindow(){
        waitForWindowLoad();
        Set<String> allWindowIds =  driver.getWindowHandles();
        System.out.println("Set of Ids :- "+allWindowIds);
         for(String id : allWindowIds){
             driver.switchTo().window(id);
             if(driver.getTitle().equals("Track Order · Technocredits")){
               break;
             }
         }
    }

    public String getOrderIdFromTrackOrderPAge(){
        return orderIDFromTrackOrderPage.getText();
    }

}
