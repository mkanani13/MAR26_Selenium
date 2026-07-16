package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

public class FindFoodPage extends BrowserActions {

    public FindFoodPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[@class='text-xs text-slate-500'][not(contains(text(),' 0 dishes'))])[1]/preceding::h3")
    WebElement firstRestaurantNameWithAvailableDishesElement;

    @FindBy(xpath = "(//p[@class='text-xs text-slate-500'][not(contains(text(),' 0 dishes'))])[1]/following::a[1]")
    WebElement firstRestaurantWithAvailableDishElement;

    @FindBy(id = "locality-filter")
    WebElement localityFilterElement;

    @FindBy(xpath = "//span[contains(text(),'onkarpatil')]")
    WebElement locateUserElement;


    public void waitForPageLoad(){
        waitUntilElementIsVisible(firstRestaurantNameWithAvailableDishesElement);
    }

    public String getCurrentLoggedInUser(){
        return getTextOfElement(locateUserElement, true);
    }

    public void selectLocationFromDropdown(String location){
        selectOptionFromDropdownByVisibleText(localityFilterElement, location);
    }

    public String getFirstRestaurantWithAvailableDishes(){
        String selectedRestaurantRaw = getTextOfElement(firstRestaurantNameWithAvailableDishesElement, true);
        String[] arr = selectedRestaurantRaw.split(" ");
        String[] tempArr = Arrays.copyOf(arr, arr.length-1);
        return String.join(" ", tempArr);
    }

    public void selectFirstRestaurantWithAvailbleDishes(){
        clickOnElement(firstRestaurantWithAvailableDishElement, true);
    }

    public void selectGivenRestaurant(String restaurantName){
        clickOnElement(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/following::a[1]"), true);
    }
}
