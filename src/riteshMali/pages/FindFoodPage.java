package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import riteshMali.base.BrowserActions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindFoodPage extends BrowserActions {

    private final String LOCALITY_FILTER_XPATH = "//select[@id='locality-filter']";
    private final String FIRST_RESTAURANT_HAVING_DISH = "//a[text()='View & order'][1] | //div[@data-testid='restaurants-empty']";
    private final String RESTAURANT_NAME_HAVING_DISHES = "//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))]/preceding-sibling::h3";
    private final String CLICK_ON_RESTAURANT_WITH_NAME = "//h3[contains(text(),'%s')]//following::a[1]";
    WebElement locationDD = getElement(By.xpath("//select[@id='locality-filter']"));

    ;

    public String getFirstRestaurantHavingDishes() {
        waitForElementVisibility(By.xpath(FIRST_RESTAURANT_HAVING_DISH));
        String restaurantName = null;
        try {
            restaurantName = getTextFromElement(By.xpath(RESTAURANT_NAME_HAVING_DISHES));
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

    public Set<String> getLocationFromLocationDropdown() {
        List<String> filterOptions = getAllTextOption(By.xpath(LOCALITY_FILTER_XPATH));
        filterOptions.remove("All localities");
        System.out.println("Total location from dropdown " + filterOptions.size());
        System.out.println(filterOptions);
        return new HashSet<>(filterOptions);
    }

    public void setLocationInDropdown(String locationText) {
        clickOnElement(locationDD);
        setLocationByVisibleText(By.xpath(LOCALITY_FILTER_XPATH), locationText);
    }

    public void clickOnViewOrder(String restaurantName) {
        WebElement viewOrderBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CLICK_ON_RESTAURANT_WITH_NAME, restaurantName))));
        viewOrderBtn.click();
    }


}
