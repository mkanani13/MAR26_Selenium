package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FindFoodPage extends BrowserActions {
    private String localityFilter_xpath = "//select[@data-testid='locality-dropdown']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@id='restaurants-grid']/div"),1));
    }

    public void setLocality(String location){
        WebElement ddLocality = driver.findElement(By.xpath(localityFilter_xpath));
        Select select = new Select(ddLocality);
        select.selectByVisibleText(location);
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

    public void clickOnViewAndOrder(String restaurantName){
        driver.findElement(By.xpath("//h3[text()='"+restaurantName+" ']/following::a[1]")).click();
    }
}
