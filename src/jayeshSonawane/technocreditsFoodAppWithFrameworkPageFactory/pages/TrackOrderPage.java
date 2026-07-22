package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackOrderPage extends BrowserActions {

    private final String ORDER_NUMBER_XPATH = "//div[starts-with(text(),'ORDER#')]";

    @FindBy(xpath = ORDER_NUMBER_XPATH)
    WebElement elementOrderNumber;

    @FindBy(xpath = "//div[@data-testid='track-order-total']")
    WebElement elementOrderTotal;

    public TrackOrderPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ORDERNUMBERXPATH)));
        visibilityOfElementLocated(By.xpath(ORDER_NUMBER_XPATH));
    }

    public String getOrderNumber() {
//        return driver.findElement(By.xpath(ORDER_NUMBER_XPATH)).getText();
        return getElementText(elementOrderNumber, false);
    }

    public double getTotalPrice(){
//        return Double.parseDouble(driver.findElement(By.xpath("//div[@data-testid='track-order-total']")).getText().substring(1));
        return Double.parseDouble(getElementText(elementOrderTotal, false).substring(1));
    }

    public void switchToMyOrdersOrderPlacedPage() {
//        driver.switchTo().window(MyOrdersOrderPlacedPage.MYORDERSORDERPLACEDPAGEID);

//        for(String id : BrowserActions.getWindowHandles()){
//            driver.switchTo().window(id);
//            String currentTitle = driver.getTitle();
//            if(currentTitle.equals("Order placed · Technocredits"))
//                break;
//        }

        for(String id : getAllPageIds()){
            switchToWindow(id);
            String currentTitle = getPageTitle();
            if(currentTitle.equals("Order placed · Technocredits"))
                break;
        }
    }
}
