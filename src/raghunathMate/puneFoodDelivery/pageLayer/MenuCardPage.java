package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import puneFoodDelivery.testBase.BrowserAction;

public class MenuCardPage extends BrowserAction {
    private WebElement checkoutButton;

    public void waitForPageLoad() {
        checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Proceed to Checkout →']")));
    }

    public void clickOnProceedToCheckOutButton(){
        checkoutButton.click();
    }

    public String getDishNameWhichStockShouldBeNonZero() {
        String dish = driver.findElement(By.xpath("(//table[@data-testid ='menu-table']/tbody/tr/td[4][text()>0])[1]/preceding-sibling::td[3]/div/div/div[1]")).getText();
        System.out.println(dish);
        return dish;
    }

    public void quantityForGivenDish(String dish, int quantity){
        driver.findElement(By.xpath("//div[text()='"+dish+"']/following::input[1]")).click();
        for(int i=1;i<=quantity;i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

    public String getSubTotal() {
        String subtotal = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        return subtotal;
    }

    public String getRestraurantNameFromMenuCard() {
        return driver.findElement(By.xpath("//h2[@data-testid='restaurant-name']")).getText();
    }


}
