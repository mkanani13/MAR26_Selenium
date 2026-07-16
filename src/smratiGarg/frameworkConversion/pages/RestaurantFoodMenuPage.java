package smratiGarg.frameworkConversion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import smratiGarg.frameworkConversion.base.BrowserActions;

public class RestaurantFoodMenuPage extends BrowserActions {

    public String getFirstAvailableDish() {


        String dish = driver.findElement(
                        By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]"))
                .getText();
        return dish;
    }

    public void increaseQuantity(String dish, int quantity){
        WebElement qtyinputElement= driver.findElement(
                        By.xpath("//div[text()='"+dish+"']/following::input[@type='number'][1]"));
        qtyinputElement.click();
        Actions actions=new Actions(driver);
        for (int i = 1; i <=quantity; i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

    public double getSubTotal(){
        String subTotalText = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        subTotalText = subTotalText.substring(1);
        return Double.parseDouble(subTotalText);
    }

    public void clickProceedtoCheckOut(){
        driver.findElement(By.xpath("//button[@id='proceed-checkout-btn']")).click();
    }

}
