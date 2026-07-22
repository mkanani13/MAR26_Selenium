package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersOrderPlacedPage extends BrowserActions {

    private final String ORDER_MORE_BUTTON_XPATH = "//a[text()='Order more']";
//    private final String ORDERNUMBERXPATH = "//span[starts-with(text(),'ORDER#')]";
    public static final String MY_ORDERS_ORDER_PLACED_PAGE_ID = driver.getWindowHandle();

    @FindBy(xpath = "//span[starts-with(text(),'ORDER#')]")
    WebElement elementOrderNumberStartsWith;

    @FindBy(xpath = "//div[@id='success-host']//strong")
    WebElement elementRestaurantName;

    @FindBy(xpath = "//span[text()='Order number']")
    WebElement elementOrderNumberText;

    @FindBy(xpath = "//span[starts-with(text(),'ORDER#')]")
    WebElement elementOrderNumber;

    @FindBy(xpath = "//a[text()='Track order']")
    WebElement elementTrackOrderText;

    @FindBy(xpath = "//span[text()='Amount paid']")
    WebElement elementAmountPaidText;

    @FindBy(xpath = "//span[text()='Paid via']")
    WebElement elementPaidViaText;

    @FindBy(xpath = "//span[@data-testid='success-amount']")
    WebElement elementSuccessAmount;

    @FindBy(xpath = "//div[@id='success-host']/div/div/div/following-sibling::div[2]/span[2]")
    WebElement elementSuccessHost;

    @FindBy(xpath = "//a[text()='View my orders']")
    WebElement elementViewMyOrdersButton;

    public MyOrdersOrderPlacedPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(){
        visibilityOfElementLocated(By.xpath(ORDER_MORE_BUTTON_XPATH));
    }

//    public boolean isOrderPlaced(){
//        try {
//            driver.findElement(By.xpath(ORDERNUMBERXPATH));
//            return true;
//        }catch (NoSuchElementException ne){
//            return false;
//        }
//    }

//    public boolean isOrderPlaced(){
//            return isElementDisplayed(elementOrderNumber, false);
//    }

    public boolean isOrderPlaced(){
        if(isElementDisplayed(elementOrderNumberStartsWith, false))
            return true;
        else
            return false;
    }

    public String getRestaurantName(){
//        return driver.findElement(By.xpath("//div[@id='success-host']//strong")).getText();
        return getElementText(elementRestaurantName, false);
    }

    public boolean isOrderNumberPresent(){
//        return driver.findElement(By.xpath("//span[text()='Order number']")).isDisplayed() && driver.findElement(By.xpath(ORDERNUMBERXPATH)).isDisplayed();
        return isElementDisplayed(elementOrderNumberText, false) && isElementDisplayed(elementOrderNumber, false);
    }

    public boolean isAmountPaidPresent(){
//        return driver.findElement(By.xpath("//span[text()='Amount paid']")).isDisplayed();
        return isElementDisplayed(elementAmountPaidText, false);
    }

    public boolean isPaidViaPresent(){
//        return driver.findElement(By.xpath("//span[text()='Paid via']")).isDisplayed();
        return isElementDisplayed(elementPaidViaText, false);
    }

    public List<String> getOrderDetails(){
        List<String> orderDetails = new ArrayList<>();

//        orderDetails.add(driver.findElement(By.xpath(ORDERNUMBERXPATH)).getText());
        orderDetails.add(getElementText(elementOrderNumberStartsWith, false));
//        orderDetails.add(driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText());
        orderDetails.add(getElementText(elementSuccessAmount, false));
//        orderDetails.add(driver.findElement(By.xpath("//div[@id='success-host']/div/div/div/following-sibling::div[2]/span[2]")).getText());
        orderDetails.add(getElementText(elementSuccessHost, false));

        return orderDetails;
    }

    public void clickOnTrackOrderButton(){
//        driver.findElement(By.xpath("//a[text()='Track order']")).click();
        clickOnElement(elementTrackOrderText, false);
    }

    public void clickOnViewMyOrdersButton(){
//        driver.findElement(By.xpath("//a[text()='View my orders']")).click();
        clickOnElement(elementViewMyOrdersButton, false);
    }

    public String getMyOrdersOrderPlacedPageId(){
        return getPageId();
    }

    public void switchToTrackOrderPageWindow() {
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        waitForNumberOfWindowsToBe(2);

//        for(String id : BrowserActions.getWindowHandles()){
//            driver.switchTo().window(id);
//            if(!id.equals(MYORDERSORDERPLACEDPAGEID)){
//                break;
//            }
//        }

//        for (String id : BrowserActions.getWindowHandles()) {
//            driver.switchTo().window(id);
//            String currentTitle = driver.getTitle();
//            if (currentTitle.equals("Track Order · Technocredits")) {
//                break;
//            }
//        }
        for (String id : getAllPageIds()) {
            switchToWindow(id);
            String currentTitle = getPageTitle();
            if (currentTitle.equals("Track Order · Technocredits")) {
                break;
            }
        }
    }

}
