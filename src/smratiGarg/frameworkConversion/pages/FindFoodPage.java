package smratiGarg.frameworkConversion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import smratiGarg.frameworkConversion.base.BrowserActions;

public class FindFoodPage extends BrowserActions {

    public String getLoginName(){

        String actualText = driver.findElement(By.xpath("//header/div/div/span[2]"))
                .getText();
        return actualText;
    }

    public void setLocation(String locationToSelect){

        WebElement dropdownelement = driver
                .findElement(By.xpath("//select[@id='locality-filter']"));
        Select location = new Select(dropdownelement);
        location.selectByValue(locationToSelect);


    }

    public void clickRestaurantViewAndOrder(String restaurantName){

        driver.findElement(By.xpath("(//h3[contains(text(),'Abhishek Pure Veg')]/following::a[text()='View & order'])[1]"))
                .click();
    }

}

