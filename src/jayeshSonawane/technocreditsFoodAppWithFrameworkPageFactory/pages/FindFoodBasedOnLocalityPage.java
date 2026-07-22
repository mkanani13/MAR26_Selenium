package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindFoodBasedOnLocalityPage extends BrowserActions {

    private final String SEARCH_STUDENT_ID = "search-filter";
    private final String RESTAURANT_XPATH = "(//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))])[1]/parent::div/h3";
    private final String FIRST_RESTAURANT_WITH_AVAILABILITY_XPATH = "(//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))])[1]/preceding-sibling::h3/span";
    private final String SELECT_RESTAURANT_XPATH = "//h3[contains(text(),'%s')]/parent::div/parent::div/following-sibling::a";
    private final String RESTAURANT_NAME_XPATH = "//h3[contains(text(),'%s')]";
    private final String RESTAURANT_NAME_SPLITBY_XPATH = "//h3[contains(text(),'%s')]/child::span";

    @FindBy(id = SEARCH_STUDENT_ID)
    WebElement elSearchRestaurant;

    @FindBy(id = "locality-filter")
    WebElement elementLocalityDropdown;

    @FindBy(xpath = RESTAURANT_XPATH)
    WebElement elementRestaurant;

    @FindBy(xpath = FIRST_RESTAURANT_WITH_AVAILABILITY_XPATH)
    WebElement elementFirstAvailableRestaurant;

    public FindFoodBasedOnLocalityPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad() {
        visibilityOfElementLocated(By.id(SEARCH_STUDENT_ID));
    }

    public void waitForPageLoad(String restaurantName) {
        visibilityOfElementLocated(By.xpath(String.format(RESTAURANT_NAME_XPATH, restaurantName)+"/child::span"));
    }

    public String selectLocalityFromDropdown(String locality){
//        WebElement dropdown = driver.findElement(By.id("locality-filter"));
//        selectLocality.selectByVisibleText(locality);
//        return selectLocality.getFirstSelectedOption().getText();
        return  selectDropdownElementByVisibleText(elementLocalityDropdown, locality);
    }

    public String getRestaurantName(String restaurantName){
//        String splitBy = driver.findElement(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/child::span")).getText();
        String splitBy = getElementText(By.xpath(String.format(RESTAURANT_NAME_SPLITBY_XPATH, restaurantName)), false);
//        String actualRestaurantName = driver.findElement(By.xpath("//h3[contains(text(),'" + restaurantName + "')]")).getText().split(splitBy)[0].trim();
        String actualRestaurantName = getElementText(By.xpath(String.format(RESTAURANT_NAME_XPATH, restaurantName)), false).split(splitBy)[0].trim();
        return actualRestaurantName;
    }

    public void selectRestaurant(String restaurantName){
//        driver.findElement(By.xpath("//h3[contains(text(),'"+restaurantName+"')]/parent::div/parent::div/following-sibling::a")).click();
        clickOnElement(By.xpath(String.format(SELECT_RESTAURANT_XPATH, restaurantName)),false);
    }

    @FindBy(xpath = "(//div[@id='restaurants-grid']//p[1][not(contains(text(), '0 dishes'))])[1]/parent::div/parent::div/following-sibling::div/a")
    WebElement elementClickOnRestaurant;

    public String selectFirstRestaurantWithAvailability(){
        String splitBy = getElementText(elementFirstAvailableRestaurant, true);
        String restaurantName = getElementText(elementRestaurant, false).split(splitBy)[0].trim();
//        driver.findElement(By.xpath("(//p[1][not(contains(text(), '0 dishes'))]/following::a[1])[1]")).click();
        clickOnElement(elementClickOnRestaurant,false);

        return restaurantName;
    }
}
