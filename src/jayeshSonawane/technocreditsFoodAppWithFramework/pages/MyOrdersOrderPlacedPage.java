package jayeshSonawane.technocreditsFoodAppWithFramework.pages;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersOrderPlacedPage extends BrowserActions {

    public final String ORDERMOREBUTTONXPATH = "//a[text()='Order more']";

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(ORDERMOREBUTTONXPATH));
    }

    public boolean isOrderPlaced(){
        try {
            driver.findElement(By.xpath("//span[starts-with(text(),'ORDER#')]"));
            return true;
        }catch (NoSuchElementException ne){
            return false;
        }
    }

    public List<String> getOrderDetails(){
        List<String> orderDetails = new ArrayList<>();

        orderDetails.add(driver.findElement(By.xpath("//span[starts-with(text(),'ORDER#')]")).getText());
        orderDetails.add(driver.findElement(By.xpath("")).getText());
        orderDetails.add(driver.findElement(By.xpath("")).getText());

        return orderDetails;
    }
}
