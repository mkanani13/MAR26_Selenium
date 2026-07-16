package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrackOrderPage extends BrowserActions {

    private final String ORDERNUMBERXPATH = "//div[starts-with(text(),'ORDER#')]";

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ORDERNUMBERXPATH)));
    }

    public String getOrderNumber() {
        return driver.findElement(By.xpath(ORDERNUMBERXPATH)).getText();
    }

    public double getTotalPrice(){
        return Double.parseDouble(driver.findElement(By.xpath("//div[@data-testid='track-order-total']")).getText().substring(1));
    }

    public void switchToMyOrdersOrderPlacedPage() {
//        driver.switchTo().window(MyOrdersOrderPlacedPage.MYORDERSORDERPLACEDPAGEID);

        for(String id : BrowserActions.getWindowHandles()){
            driver.switchTo().window(id);
            String currentTitle = driver.getTitle();
            if(currentTitle.equals("Order placed · Technocredits"))
                break;
        }
    }
}
