package raghunathMate.puneFoodDelivery.testPageLayer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import puneFoodDelivery.pageLayer.FoodOrderPage;
import puneFoodDelivery.pageLayer.LoginPage;
import puneFoodDelivery.testBase.BrowserAction;

import java.util.Set;

public class ClassForRunTC {
    WebDriver driver;


    @BeforeClass()
    public void setUp() {
        System.out.println("Lunching browser and loading url");
        BrowserAction.start();
        LoginPage loginpage = new LoginPage();
        loginpage.loginToApplication();

    }

    @Test
    public void countTheRestaurantListedOnApp_TC_01() {
        FoodOrderPage foodorderpage = new FoodOrderPage();
        foodorderpage.totalRestaurant();
    }

    @Test
    public void getUniqueLocationAvailableOnAppAndItSCount_TC_02() {
        FoodOrderPage foodorderpage = new FoodOrderPage();
        Set<String> uniqueLocations = foodorderpage.findUniqueLocationsAvailableOnApplication();
        System.out.println("Location count is :- " + uniqueLocations.size());
        System.out.println("Location list is :- " + uniqueLocations);
    }

    @Test
    public void getRestaurantCountAndListForPlace_TC_03() {
        FoodOrderPage foodorderpage = new FoodOrderPage();
        foodorderpage.getCountAndListOfRestaurantAtPlace("Baner");
    }

    @Test
    public void findLocationWhereNoRestaurant_TC_04() {
        FoodOrderPage foodorderpage = new FoodOrderPage();
        foodorderpage.getLocationWhereNoRestaurantListedYet();
    }

    @Test
    public void verifyLocationWhereRestaurant_TC_05() {
        FoodOrderPage foodorderpage = new FoodOrderPage();
        foodorderpage.getLocationWhereRestaurantListed();
    }

    @AfterClass
    public void tearDown() {

        BrowserAction.closeBrowser();
    }
}
