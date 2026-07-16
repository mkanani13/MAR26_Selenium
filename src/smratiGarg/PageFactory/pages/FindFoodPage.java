package smratiGarg.PageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import smratiGarg.PageFactory.base.BrowserAction;

public class FindFoodPage extends BrowserAction {

    @FindBy(xpath = "//header/div/div/span[2]")
    WebElement headerText;

    @FindBy(xpath = "//select[@id='locality-filter']")
    WebElement dropDownElement;

    public FindFoodPage(){
        PageFactory.initElements(driver,this);
    }

    public String getLoginName(){
        return headerText.getText();
    }

    public void setLocation(String locationToSelect){
        Select location = new Select(dropDownElement);
        location.selectByValue(locationToSelect);
    }

    public void clickRestaurantViewAndOrder(String restaurantName){

        driver.findElement(By.xpath("(//h3[contains(text(),'Abhishek Pure Veg')]/following::a[text()='View & order'])[1]"))
                .click();
    }

}

