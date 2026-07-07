package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.Arrays;

public class FindFoodPage extends BrowserActions {

    private static String USER_LOCATOR = "//span[contains(text(),'onkarpatil')]";
    private static String FILTER_LOCATOR = "locality-filter";
    private static String FIRST_RESTAURANT_WITH_AVAILABLE_DISHES = "(//p[@class='text-xs text-slate-500'][not(contains(text(),' 0 dishes'))])[1]/following::a[1]";
    private static String FIRST_RESTAURANT_NAME_WITH_AVAILABLE_DISHES = "(//p[@class='text-xs text-slate-500'][not(contains(text(),' 0 dishes'))])[1]/preceding::h3";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_RESTAURANT_NAME_WITH_AVAILABLE_DISHES)));
    }

    public String getCurrentLoggedInUser(){
        return driver.findElement(By.xpath(USER_LOCATOR)).getText();
    }

    public void selectLocationFromDropdown(String location){
        WebElement locatlityFilter = driver.findElement(By.id(FILTER_LOCATOR));
        Select select = new Select(locatlityFilter);
        select.selectByVisibleText(location);
    }

    public String getFirstRestaurantWithAvailbleDishes(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_RESTAURANT_WITH_AVAILABLE_DISHES)));
        String selectedRestaurantRaw = driver.findElement(By.xpath(FIRST_RESTAURANT_NAME_WITH_AVAILABLE_DISHES)).getText();
        String[] arr = selectedRestaurantRaw.split(" ");
        String[] tempArr = Arrays.copyOf(arr, arr.length-1);
        return String.join(" ", tempArr);
    }

    public void selectFirstRestaurantWithAvailbleDishes(){
        WebElement viewAndOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_RESTAURANT_WITH_AVAILABLE_DISHES)));
        viewAndOrder.click();
    }

    public void selectGivenRestaurant(String restaurantName){
        WebElement viewAndOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/following::a[1]")));
        viewAndOrderBtn.click();
    }
}
