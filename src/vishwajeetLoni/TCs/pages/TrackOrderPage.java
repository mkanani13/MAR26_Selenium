package vishwajeetLoni.TCs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vishwajeetLoni.base.ActionOnBrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TrackOrderPage extends ActionOnBrowser {

    private final String TrackOrderPageTitle = "Track Order · Technocredits";

    public void waitForPageLoad(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='track-order-total']")));
        waitForElementVisibility((By.xpath("//div[@data-testid='track-order-total']")));
    }

    public String TrackOrderOrderNumber (){
       return driver.findElement(By.xpath("//div[@data-testid='track-order-number']")).getText();
    }

    public String TrackOrderRestaurantName(){
//      return driver.findElement(By.xpath("//div[@data-testid='track-summary']//span[text()='Restaurant:']/following::text()[1]")).getText().trim();
        String restaurantText = driver.findElement(By.xpath("//span[text()='Restaurant:']/parent::div")).getText();   // restaurantText = "Restaurant: Vish Rest"
        String value = restaurantText.replace("Restaurant: ", "");  // value = "Vish Rest"

        return value;
    }

    public String TrackOrderTotalAmt(){
        return driver.findElement(By.xpath("//div[@data-testid='track-order-total']")).getText();
    }

    public String TrackOrderDeliveryAddress(){
        return driver.findElement(By.xpath("//div[@data-testid='track-summary']//span[text()='Deliver to:']/following::text()[1]")).getText();
    }


//    Creating a List for items to be validated - Res name - amt - order id

    public List<String> getOrderDetails(){
        List<String> orderDetailList = new ArrayList<>();
        orderDetailList.add(driver.findElement(By.xpath("//div[@data-testid='track-order-number']")).getText());
        String restaurantName = driver.findElement(By.xpath("//div[@class='text-sm text-slate-600']/div[1]")).getText().replace("Restaurant:","").trim();
        orderDetailList.add(restaurantName);
        orderDetailList.add(driver.findElement(By.xpath("//div[@data-testid='track-order-total']")).getText());
        return orderDetailList;
    }


    public void switchToTrackOrderWindow(){
        //String mainWindowHandleId = driver.getWindowHandle();  //this will always give main window where the test script was launched
         wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandleIdsAll = driver.getWindowHandles();

        for (String id : windowHandleIdsAll){
            driver.switchTo().window(id);
            String currentwindowtitle = driver.getTitle();
            if (currentwindowtitle.equals(TrackOrderPageTitle)){
                break;
            }
        }

        System.out.println("----------After Tab Switch, title of the page is : " + driver.getTitle());
    }


    public boolean isOrderDelivered(){
        WebElement deliveryStatus = driver.findElement(By.xpath("//div[@data-testid='track-step-delivered']/div[1]"));
        String className = deliveryStatus.getAttribute("class");
        if(className.contains("border-slate-300 text-slate-400")){
            return false;
        }else if(className.contains("border-fd-brand text-fd-brand ring-4 ring-emerald-100")){
            return true;
        }
        return false;


    }


    public boolean isEnjoyYourMealTextPresent(){
        try{
            return driver.findElement(By.xpath("//span[contains(text(),'Delivered — Enjoy your meal!')]")).isDisplayed();
        }catch(NoSuchElementException ne){
            return false;
        }
    }


    public void waitForOrderDelivery(){

        WebElement deliveryStatus = driver.findElement(By.xpath("//div[@data-testid='track-step-delivered']/div[1]"));
       // String className = deliveryStatus.getAttribute("class");
        wait.until(ExpectedConditions.attributeContains(deliveryStatus,"class","border-fd-brand text-fd-brand ring-4 ring-emerald-100"));

    }

    public void waitForOrderDelivery1(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
