package raghunathMate.PuneFoodDeliveryApp.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import raghunathMate.PuneFoodDeliveryApp.testBase.BrowserAction;

import java.util.List;

public class MyOrdersPage extends BrowserAction {
    String orderIdFroMOrderSuccessPage;
    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));
    }

    public boolean getpageTitleFlage(){
        boolean pageTileFlage = driver.findElement(By.xpath("//h1[text()='My Orders']")).isDisplayed();
        return pageTileFlage;
    }

    public boolean checkOrderIdIsPresentOrNotInMyOrderPage(){
        orderIdFroMOrderSuccessPage = OrderSuccessPage.orderId;
        boolean orderIdPresentFlage = false;
        List<WebElement> listOfOrderIDs = driver.findElements(By.xpath("//tr/td[1]"));
        for(WebElement id : listOfOrderIDs){
            if(orderIdFroMOrderSuccessPage.equals(id.getText())){
                orderIdPresentFlage = true;
                break;
            }
        }
        return orderIdPresentFlage;
    }

}
