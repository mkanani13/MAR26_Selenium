package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyOrdersOrderListPage extends BrowserActions {

    private final String FILTERSEARCHID = "filter-search";
    private WebElement searchFilter;

    public void waitForPageLoad() {
        searchFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FILTERSEARCHID)));
    }

    public void searchOrder(String orderNumber) {
        searchFilter.sendKeys(orderNumber);
    }

    public boolean isOrderNumberPresent(String orderNumber) {
        searchOrder(orderNumber);
        return driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr/td[2]")).getText().equals(orderNumber);
    }

    public double getOrderTotalPrice() {
        return Double.parseDouble(driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr/td[6]")).getText().substring(1));
    }
}
