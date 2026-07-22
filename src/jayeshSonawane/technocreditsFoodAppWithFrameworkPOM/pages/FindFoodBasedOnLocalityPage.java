package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FindFoodBasedOnLocalityPage extends BrowserActions {


    public void waitForPageLoad() {
        BrowserActions.visibilityOfElementLocated(By.id("search-filter"));
    }

    public void waitForPageLoad(String restaurantName) {
        BrowserActions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/child::span"));
    }

    public String selectLocalityFromDropdown(String locality){
        WebElement dropdown = driver.findElement(By.id("locality-filter"));
        Select selectLocality = new Select(dropdown);
        selectLocality.selectByVisibleText(locality);

        return selectLocality.getFirstSelectedOption().getText();
    }

    public String getRestaurantName(String restaurantName){
        String splitBy = driver.findElement(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/child::span")).getText();
        String actualRestaurantName = driver.findElement(By.xpath("//h3[contains(text(),'" + restaurantName + "')]")).getText().split(splitBy)[0].trim();
        return actualRestaurantName;
    }

    public void selectRestaurant(String restaurantName){
        driver.findElement(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/parent::div/parent::div/following-sibling::a")).click();
    }

//    public String selectFirstRestaurantWithAvailability(){
//        String restaurantXpath = "(//p[1][not(contains(text(), '0 dishes'))]/following::a[1])[1]/preceding-sibling::div//h3";
//        String splitBy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(restaurantXpath + "/span"))).getText();
//        String restaurantName = driver.findElement(By.xpath(restaurantXpath)).getText().split(splitBy)[0].trim();
//        driver.findElement(By.xpath("(//p[1][not(contains(text(), '0 dishes'))]/following::a[1])[1]")).click();
//        return restaurantName;
//    }





    public String selectFirstRestaurantWithAvailability(){
        String restaurantXpath = "(//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))])[1]/parent::div/h3";
        String splitBy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))])[1]/preceding-sibling::h3/span"))).getText();
        String restaurantName = driver.findElement(By.xpath(restaurantXpath)).getText().split(splitBy)[0].trim();
        driver.findElement(By.xpath("(//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))])[1]/parent::div/parent::div/following-sibling::div/a")).click();
        return restaurantName;
    }
}
