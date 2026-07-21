package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RestaurantMenuPage extends BrowserActions {
    private String proceedToCheckoutBtn_xpath = "//button[@id='proceed-checkout-btn']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(proceedToCheckoutBtn_xpath)));
    }

    public String getRestaurantName(){
        String restaurantMenu_restaurantName = driver.findElement(By.xpath("//h2[@data-testid='restaurant-name']")).getText();
        return restaurantMenu_restaurantName;
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

    public void clickOnProceedToCheckoutBtn(){
        driver.findElement(By.xpath(proceedToCheckoutBtn_xpath)).click();
    }

    public void selectCoupon(String couponName){
        WebElement DDCoupon = driver.findElement(By.xpath("//select[@id='coupon-code']"));
        Select select = new Select(DDCoupon);
        List<WebElement> couponsList = select.getOptions();
        for(WebElement e : couponsList){
            if(e.getText().contains(couponName)) {
                select.selectByVisibleText(e.getText());
                break;
            }
        }
    }

    public String getDiscountAmount(){
        return driver.findElement(By.xpath("//strong[@id='ot-discount']")).getText();
    }

    public String getPayableAmount(){
        return driver.findElement(By.xpath("//strong[@id='ot-total']")).getText();
    }



}
