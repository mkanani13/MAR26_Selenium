package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;

public class RestauarantMenuPage extends BrowserActions {
    private WebElement proceedToCheckoutBtn;

    public void waitForPage(){
        proceedToCheckoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='proceed-checkout-btn']")));
    }

    public void clickOnProceedToCheckout(){
        proceedToCheckoutBtn.click();
    }

    public String getRestaurantName(){
        String restaurantMenu_RestaurantName = driver.findElement(By.xpath("//h2[@data-testid='restaurant-name']")).getText();
        return restaurantMenu_RestaurantName;
    }

    public String getFirstAvailableDish(){
        String dish = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]")).getText();
        return dish;
    }

    public void setQuantityOfGivenDish(String dish, int quantity){
        driver.findElement(By.xpath("//div[text()='"+dish+"']/following::input[@type='number'][1]")).click();
        for(int count=1;count<=quantity;count++){
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

    public String getSubTotal(){
        String subTotalText = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        return subTotalText;
    }
}
