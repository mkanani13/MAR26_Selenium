package smratiGarg.refactorRestaurentApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import smratiGarg.refactorRestaurentApp.base.BrowserActions;

public class MyOrderPage extends BrowserActions {


    WebElement searchElement;

    public void waitForPage(){
        searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='filter-search']")
        ));
    }

    public void searchOrderWithExactID(String orderID){
        searchElement.sendKeys(orderID);
    }





}
