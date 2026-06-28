package jayeshSonawane.technocreditsFoodAppWithFramework.pages;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class FindFoodMenuPage extends BrowserActions {

    public final String PROCEEDTOCHECKOUTBUTTONXPATH = "//button[@id='proceed-checkout-btn']";

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(PROCEEDTOCHECKOUTBUTTONXPATH));
    }

    public String getRestaurantName(){
        return driver.findElement(By.xpath("//h2")).getText();
    }

    public int addInStockItemIntoCart(int quantity){
        driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input")).click();

        int count = 0;
        for (; count<quantity; count++){
            actions.sendKeys(Keys.ARROW_UP).perform();
        }

        return count;
    }

    public double getSubTotal(){
        return Double.parseDouble(driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText().substring(1));
    }

    public void clickOnProceedToCheckoutButton(){
        driver.findElement(By.xpath(PROCEEDTOCHECKOUTBUTTONXPATH)).click();
    }


}
