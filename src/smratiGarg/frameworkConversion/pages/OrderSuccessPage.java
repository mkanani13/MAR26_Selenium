package smratiGarg.frameworkConversion.pages;

import org.openqa.selenium.By;
import smratiGarg.frameworkConversion.base.BrowserActions;

public class OrderSuccessPage extends BrowserActions {

    public void clickOnViewMyOrder(){
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();
    }
}
