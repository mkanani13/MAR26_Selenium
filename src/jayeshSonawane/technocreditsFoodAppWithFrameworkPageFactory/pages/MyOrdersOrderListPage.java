package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersOrderListPage extends BrowserActions {

    private final String FILTER_SEARCH_ID = "filter-search";
//    private WebElement searchFilter;
    WebElement elementSearchFilter;

    @FindBy(xpath = "//tbody[@id='orders-tbody']/tr/td[2]")
    WebElement elementOrderNumber;

    @FindBy(xpath = "//tbody[@id='orders-tbody']/tr/td[6]")
    WebElement elementOrderTotalPrice;

    public MyOrdersOrderListPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad() {
//        searchFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FILTERSEARCHID)));
        elementSearchFilter = visibilityOfElementLocated(By.id(FILTER_SEARCH_ID));
    }

    public void searchOrder(String orderNumber) {
//        searchFilter.sendKeys(orderNumber);
        sendKeysToElement(elementSearchFilter, orderNumber, false);
    }

    public boolean isOrderNumberPresent(String orderNumber) {
        searchOrder(orderNumber);
//        return driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr/td[2]")).getText().equals(orderNumber);
        return getElementText(elementOrderNumber, false).equals(orderNumber);
    }

    public double getOrderTotalPrice() {
//        return Double.parseDouble(driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr/td[6]")).getText().substring(1));
        return Double.parseDouble(getElementText(elementOrderTotalPrice, false).substring(1));
    }
}
