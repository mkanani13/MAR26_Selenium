package raghunathMate.PuneFoodDeliveryApp.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import raghunathMate.PuneFoodDeliveryApp.testBase.BrowserAction;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static raghunathMate.PuneFoodDeliveryApp.testBase.BrowserAction.wait;


public class FoodOrderPage extends BrowserAction {

    private final String locationDropDown_xpath = "//select[@data-testid='locality-dropdown']";

    public void waitPageLoad() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[text()='View & order']"), 1));
    }

    public void totalRestaurant() {
        System.out.println("Find and printing total count of restaurant");
        int countOfRestro = driver.findElements(By.xpath("//div[(contains(@data-testid,'restaurant-card-res'))]")).size();
        System.out.println(countOfRestro);
    }

    public Set<String> findUniqueLocationsAvailableOnApplication() {
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        List<WebElement> listOfLocations = locationDropDownSelector.getOptions();
        Set<String> setOfLocation = new LinkedHashSet<String>();
        String allLocation = "All localities";
        for (WebElement e : listOfLocations) {
            String location = e.getText();
            if (!(allLocation.equalsIgnoreCase(location))) {
                setOfLocation.add(location);
            }
        }
        return setOfLocation;
    }

    public void getCountAndListOfRestaurantAtPlace(String place) {
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        locationDropDownSelector.selectByVisibleText(place);
        List<WebElement> RestoListAtPlace = driver.findElements(By.xpath("//div/h3"));
        System.out.println("Total Count at " + place + " is :- " + RestoListAtPlace.size());
        for (WebElement e : RestoListAtPlace) {
            System.out.println(e.getText());
        }

    }

    public void getLocationWhereNoRestaurantListedYet() {
        FoodOrderPage foodorder = new FoodOrderPage();
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        Set<String> locationSet = foodorder.findUniqueLocationsAvailableOnApplication();
        Set<String> noRestoLocation = new LinkedHashSet<String>();
        for (String l : locationSet) {
            locationDropDownSelector.selectByVisibleText(l);
            int countOfRestro = driver.findElements(By.xpath("//div[(contains(@data-testid,'restaurant-card-res'))]")).size();
            if (!(countOfRestro > 0)) {
                noRestoLocation.add(l);
            }
        }
        System.out.println("Location :- " + noRestoLocation);
    }

    public void getLocationWhereRestaurantListed() {
        FoodOrderPage foodorder = new FoodOrderPage();
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        Set<String> locationSet = foodorder.findUniqueLocationsAvailableOnApplication();
        Set<String> RestoLocation = new LinkedHashSet<String>();
        for (String l : locationSet) {
            locationDropDownSelector.selectByVisibleText(l);
            int countOfRestro = driver.findElements(By.xpath("//div[(contains(@data-testid,'restaurant-card-res'))]")).size();
            if (!(countOfRestro >= 1)) {
                RestoLocation.add(l);
            }
        }
        System.out.println("Location :- " + RestoLocation);
    }

    public boolean userNameVisibilityCheck() {
        WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'raghuCust')]"));
        return userName.isDisplayed();
    }

    public void selectLocationFromDropDown(String location) {
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        locationDropDownSelector.selectByVisibleText(location);
    }

    public void selectRestraurant(String name) {
        driver.findElement(By.xpath("//h3[contains(text(),'" + name + "')]/following::a[1]")).click();
    }

}