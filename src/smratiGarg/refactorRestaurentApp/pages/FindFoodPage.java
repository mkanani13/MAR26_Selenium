package smratiGarg.refactorRestaurentApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import smratiGarg.refactorRestaurentApp.base.BrowserActions;


import java.util.List;

public class FindFoodPage extends BrowserActions {
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@id='restaurants-grid']/div"), 1));

    }

public void setLocationInDropDown(String location){

    Select selectLocationDropDown = new Select(driver.findElement(By
            .xpath("//select[@id='locality-dropdown']")));
    selectLocationDropDown.selectByValue(location);
}

public String getFirstRestaurantNameHavingDishes(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='co-continue']")));
    return null;
}


public void clickOnViewOrder (String restaurantName){
    driver.findElement(By.xpath("//h3[contains(text(),'"+ restaurantName+"')]//following::a[1]")).click();
 }
}
