package Amitjoshi.TechnoAppTesting.testcripts;

import Amitjoshi.TechnoAppTesting.base.BrowserActions;
import Amitjoshi.TechnoAppTesting.pages.LoginPage;
import Amitjoshi.TechnoAppTesting.pages.RestaurantsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class tastcase1 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage= new LoginPage();
        loginPage.doLogin();

    }
@Test
    public void locationTest(){
    RestaurantsPage restaurantsPage= new RestaurantsPage();
    System.out.println("Step= get all the location from location dropdown");
    Set<String>avaiableLocationSet = restaurantsPage.getLocationsFromLocationDropdown();

    System.out.println("Step- get number Of listed restaurants");
    int totalRestaurants = restaurantsPage.getCountOfListedRestaurants();
    int dbRestCount=43;
    System.out.println(totalRestaurants);
    System.out.println("Verify - DB restaurants count with actual count on UI");
    Assert.assertEquals(totalRestaurants,dbRestCount);




    }

}
