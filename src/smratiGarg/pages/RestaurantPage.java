package smratiGarg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import smratiGarg.base.BrowserActions;

import java.util.List;

public class RestaurantPage extends BrowserActions {

public List<String> getLocationFromLocationDropDown(){
    return null;
}
 public List<String> getListOfRestaurantName(){
    return null;
 }
public void setLocationInDropDown(String location){

    Select selectLocationDropDown = new Select(driver.findElement(By
            .xpath("//select[@id='locality-dropdown']")));
    selectLocationDropDown.selectByValue(location);
}
}
