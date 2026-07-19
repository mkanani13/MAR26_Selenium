package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.Select;
import technocredits.technoapp.base.BrowserActions;

import java.util.*;

public class FindFoodPage extends BrowserActions {
    private final String LOCALITYFILTER_XPATH = "//select[@data-testid='locality-dropdown']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@id='restaurants-grid']/div"),1));
    }

    public Set<String> getLocationsFromLocationDropdown(){
        WebElement locationDD = driver.findElement(By.xpath(LOCALITYFILTER_XPATH));
        Select locationSelect = new Select(locationDD);
        Set<String> listOptionsText = new LinkedHashSet<>();

        List<WebElement> listOfOptions = locationSelect.getOptions();
        for(WebElement e : listOfOptions){
            listOptionsText.add(e.getText());
        }
        listOptionsText.remove("All localities");
        System.out.println("Total location from dropdown " + listOptionsText.size());
        System.out.println(listOptionsText);
        return listOptionsText;
    }

    public Set<String> getUniueSetOfRestaurantsLocation(){
        List<WebElement> listOfRestLoc = driver.findElements(By.xpath("//div[@id='restaurants-grid']/div//p"));
        Set<String> setOfLoation = new TreeSet<>();
        for(WebElement e : listOfRestLoc){
=======
import technocredits.technoapp.base.BrowserActions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class FindFoodPage extends CommonPage {

    private final String LOCALITY_FILTER_XPATH = "//select[@data-testid='locality-dropdown']";
    private final String RESTAURANT_GRID = "//div[@id='restaurants-grid']/div";
    private final String RESTAURANT_LOCATIONS = "//div[@id='restaurants-grid']/div//p[contains(@class,'text-xs')]";
    private final String NO_RESTAURANT_AVAILABEL_WITH_FILTER = "//div[text()='No restaurants match your filters.']";
    private final String READ_DOCS_NOTIFICATION = "//p[text()='Please read the Docs page first before performing any operations.']";
    private final String FIRST_RESTAURANT_WITH_DISH = "(//a[text()='View & order'])[1] | //div[@data-testid='restaurants-empty']";
    private final String RESTAURANT_NAME_HAVING_DISHES = "//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/preceding-sibling::h3";
    private final String CLICK_ON_RESTAURANT_WITH_NAME = "//h3[contains(text(),'%s')]/following::a[1]";
    private final String DISMISS_NOTIFICATION = "//button[@id='docs-banner-dismiss']";

    public void waitForPageLoad() {
        waitUntilElementMoreThen(By.xpath(RESTAURANT_GRID),1);
    }

    public Set<String> getLocationsFromLocationDropdown() {
        List<String> filterOptions = getAllOptionsFromDropDown(By.xpath(LOCALITY_FILTER_XPATH));
        filterOptions.remove("All localities");
        System.out.println("Total location from dropdown " + filterOptions.size());
        System.out.println(filterOptions);
        return new HashSet<>(filterOptions);
    }

    public Set<String> getUniueSetOfRestaurantsLocation() {
        List<WebElement> listOfRestLoc = getAllElements(By.xpath(RESTAURANT_LOCATIONS));
        Set<String> setOfLoation = new TreeSet<>();
        for (WebElement e : listOfRestLoc) {
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
            String locationText = e.getText().split(" · ")[0];
            setOfLoation.add(locationText);
        }
        System.out.println(setOfLoation);
        return setOfLoation;
    }

<<<<<<< HEAD
    public int getCountOfListedRestaurants(){
        return driver.findElements(By.xpath("//div[@id='restaurants-grid']/div")).size();
    }

    public void setLocationInDropdown(String locationText){
        WebElement locationDD = driver.findElement(By.xpath(LOCALITYFILTER_XPATH));
        Select locationSelect = new Select(locationDD);
        locationSelect.selectByVisibleText(locationText);
    }

    public boolean isNoRestaurantsLabelIsDisplayed(){
        boolean flag = driver.findElement(By.xpath("//div[text()='No restaurants match your filters.']")).isDisplayed();
        return flag;
    }

    public void clickOnDismiss(){
        driver.findElement(By.xpath("//button[@id='docs-banner-dismiss']")).click();
    }

    public boolean isDocNotificationDisplayed(){
        try{
            return driver.findElement(By.xpath("//p[text()='Please read the Docs page first before performing any operations.']")).isDisplayed();
        }catch (NoSuchElementException ne) {
            return false;
        }
    }

    public String getFirstRestaurantNameHavingDishes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View & order'])[1] | //div[@data-testid='restaurants-empty']")));
        String restaurantName = null;
        try{
            restaurantName = driver.findElement(By.xpath("//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/preceding-sibling::h3")).getText().trim();
        }catch(NoSuchElementException ne){
=======
    public int getCountOfListedRestaurants() {
        return getSizeOfElements(By.xpath(RESTAURANT_GRID));
//        return driver.findElements(By.xpath(RESTAURANT_GRID)).size();
    }

    public void setLocationInDropdown(String locationText) {
//        WebElement locationDD = driver.findElement(By.xpath(LOCALITY_FILTER_XPATH));
//        Select locationSelect = new Select(locationDD);
//        locationSelect.selectByVisibleText(locationText);
        selectByVisibleText(By.xpath(LOCALITY_FILTER_XPATH), locationText);
    }

    public boolean isNoRestaurantsLabelIsDisplayed() {
//        boolean flag = driver.findElement(By.xpath(NO_RESTAURANT_AVAILABEL_WITH_FILTER)).isDisplayed();
        return isElementDisplayed(By.xpath(NO_RESTAURANT_AVAILABEL_WITH_FILTER), false);
//        return flag;
    }

    public void clickOnDismiss() {
        clickOnElement(By.xpath(DISMISS_NOTIFICATION));
    }

    public boolean isDocNotificationDisplayed() {
        return isElementDisplayed(By.xpath(READ_DOCS_NOTIFICATION));
    }

    public String getFirstRestaurantNameHavingDishes() {
        waitForElementVisibility(By.xpath(FIRST_RESTAURANT_WITH_DISH));
        String restaurantName = null;
        try {
//            restaurantName = driver.findElement(By.xpath(RESTAURANT_NAME_HAVING_DISHES)).getText().trim();
            restaurantName = getTextFromElement(By.xpath(RESTAURANT_NAME_HAVING_DISHES));
        } catch (NoSuchElementException ne) {
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
            System.out.println("Either no restaurants or all the restaurants having 0 dishes");
        }
        String[] arr = restaurantName.split(" ");
        //String[] tempArr = Arrays.copyOf(arr,arr.length-1);
        //restaurantName = String.join(" ",tempArr);
        restaurantName = "";
<<<<<<< HEAD
        for(int index = 0; index<arr.length-1;index++){
           restaurantName += arr[index] + " ";
=======
        for (int index = 0; index < arr.length - 1; index++) {
            restaurantName += arr[index] + " ";
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
        }
        return restaurantName.trim();
    }

<<<<<<< HEAD
    public void clickOnViewOrder(String restaurantName){
        WebElement viewOrderLink = driver.findElement(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/following::a[1]"));
        viewOrderLink.click();
=======
    public void clickOnViewOrder(String restaurantName) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        WebElement viewOrderLink = driver.findElement(By.xpath(String.format(CLICK_ON_RESTAURANT_WITH_NAME, restaurantName)));
//        viewOrderLink.click();
        clickOnElement(By.xpath(String.format(CLICK_ON_RESTAURANT_WITH_NAME, restaurantName)));
    }

//    public static void main(String[] args) {
//        String restaurantName = "Jyotis kitchen";
//        String s2 = "Harsh";
////        String s = "//h3[contains(text(),'" + restaurantName + "')]/following::a[1]";
//        String s = "//h3[contains(text(),'%s')]/following::a[1]//%s";
//
//        System.out.println(String.format(s, restaurantName, s2));
//    }

    public void searchRestaurant(String restaurantName) {
        setTextOnElement(By.xpath("//input[@placeholder='Search for restaurants']"), restaurantName);
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
    }
}
