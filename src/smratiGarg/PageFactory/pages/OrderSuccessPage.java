package smratiGarg.PageFactory.pages;

import org.openqa.selenium.By;
import smratiGarg.PageFactory.base.BrowserAction;

public class OrderSuccessPage extends BrowserAction {

    public void clickOnViewMyOrder(){
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();
    }
}
