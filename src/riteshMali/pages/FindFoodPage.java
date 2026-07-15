package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import riteshMali.base.BrowserActions;

import java.util.ArrayList;
import java.util.List;

public class FindFoodPage extends BrowserActions {

    public String getFirstRestaurantHavingDishes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View & order'][1] | //div[@data-testid='restaurants-empty']")));
        String restaurantName = null;
        try {
            restaurantName = driver.findElement(By.xpath("//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))]/preceding-sibling::h3")).getText();
        } catch (NoSuchElementException ne) {
            System.out.println("No Restaurant Having Dishes");
        }

        String[] arr = restaurantName.split(" ");
        restaurantName = "";
        for (int i = 0; i < arr.length - 1; i++) {
            restaurantName = restaurantName + arr[i] + " ";
        }
        return restaurantName.trim();
    }

    public List<String> getLocationFromLocationDropdown(){
      WebElement locationDD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='locality-filter']")));
        Select locationSelect = new Select(locationDD);
        List<String> listOptionsText = new ArrayList<>();
        List<WebElement> listOfOptions = locationSelect.getOptions();
        for( WebElement e : listOfOptions){
            listOptionsText.add(e.getText());
        }
        listOptionsText.remove("All localities");
        System.out.println("Total location from dropdown " + listOptionsText.size());
        System.out.println(listOptionsText);
        return listOptionsText;
    }

    public void setLocationInDropdown(String locationText){
        WebElement locationDD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='locality-filter']")));
        locationDD.click();
        Select locationSelect = new Select(locationDD);
        locationSelect.selectByVisibleText(locationText);
    }

    public void clickOnViewOrder(String restaurantName){
        WebElement viewOrderBtn =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'"+restaurantName+"')]//following::a[1]")));
        viewOrderBtn.click();
    }


}
