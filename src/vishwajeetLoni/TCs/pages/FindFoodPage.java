package vishwajeetLoni.TCs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import vishwajeetLoni.base.ActionOnBrowser;

import java.util.List;

public class FindFoodPage extends ActionOnBrowser {

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@id='restaurants-grid']/div"),1));
    }

    public String uname(){
        String Actual = driver.findElement(By.xpath("//header[@id='fd-header']/div/div[1]/span[2]")).getText();
        return Actual;
    }

    public String setSingleLocationinDD(String locationTxt){
        WebElement locationDD = driver.findElement(By.xpath("//select[@id='locality-filter']"));
        Select locationSelect = new Select(locationDD);
        locationSelect.selectByVisibleText(locationTxt);


        List<WebElement> OptionList = locationSelect.getOptions();
        for (WebElement e : OptionList){
            if (e.isSelected()) {
              return e.getText();
            }
        }
       return null;
    }

    public String RestaurantHavingDishes (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View & order'])[1] | //div[@data-testid='restaurants-empty']")));
        String restaurantName = null;
        try{
            restaurantName = driver.findElement(By.xpath("//div[@id = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/preceding-sibling::h3")).getText().trim();
        } catch (NoSuchElementException exc) {
            System.out.println("No restaurant present or no restaurant with dishes present");
        }

//        if (restaurantName == null) {
//            return "";
//        }

        String[] arr = restaurantName.split(" ");
        restaurantName ="";
        for (int index=0;index<arr.length-1;index++){
            restaurantName += arr[index] + " ";
        }

        return restaurantName.trim();
    }

    public void clickOnViewandOrder(String restaurantname){
        WebElement viewandorder = driver.findElement(By.xpath("//h3[contains(text(),'"+restaurantname+"')]/following::a[1]"));
        viewandorder.click();
    }




}
