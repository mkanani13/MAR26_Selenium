package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            String locationText = e.getText().split(" · ")[0];
            setOfLoation.add(locationText);
        }
        System.out.println(setOfLoation);
        return setOfLoation;
    }

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
            System.out.println("Either no restaurants or all the restaurants having 0 dishes");
        }
        String[] arr = restaurantName.split(" ");
        //String[] tempArr = Arrays.copyOf(arr,arr.length-1);
        //restaurantName = String.join(" ",tempArr);
        restaurantName = "";
        for(int index = 0; index<arr.length-1;index++){
           restaurantName += arr[index] + " ";
        }
        return restaurantName.trim();
    }

    public void clickOnViewOrder(String restaurantName){
        WebElement viewOrderLink = driver.findElement(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/following::a[1]"));
        viewOrderLink.click();
    }
}
