package Amitjoshi.TechnoAppTesting.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import technocredits.technoapp.base.BrowserActions;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RestaurantsPage extends BrowserActions {

    public Set<String> getLocationsFromLocationDropdown(){
        WebElement locationDD = driver.findElement(By.xpath("//select[@id='locality-filter']"));
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
        WebElement locationDD = driver.findElement(By.xpath("//select[@id='locality-filter']"));
        Select locationSelect = new Select(locationDD);
        locationSelect.selectByVisibleText(locationText);
    }

    public boolean isNoRestaurantsLabelIsDisplayed(){
        boolean flag = driver.findElement(By.xpath("//div[text()='No restaurants.']")).isDisplayed();
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
}
