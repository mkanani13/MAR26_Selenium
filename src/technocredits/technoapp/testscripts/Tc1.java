package technocredits.technoapp.testscripts;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import technocredits.technoapp.base.BrowserActions;
import technocredits.technoapp.pages.LoginPage;
import technocredits.technoapp.pages.FindFoodPage;

import java.util.*;

public class Tc1 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void locationTest(){
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();
        System.out.println("STEP - get all the location from location dropdown");
        Set<String> availableLocationSet = findFoodPage.getLocationsFromLocationDropdown();

        System.out.println("STEP - get number of listed restaurants");
        int totalRestaurants = findFoodPage.getCountOfListedRestaurants();
        int dbRestCount = 41;
        System.out.println(totalRestaurants);
        System.out.println("VERIFY - DB Restaurants count with actual count on UI");
        Assert.assertEquals(totalRestaurants,dbRestCount);

        System.out.println("SETP - fetch unique locations of the restaurants");
        Set<String> locationSet = findFoodPage.getUniueSetOfRestaurantsLocation();

        System.out.println("STEP - Fetch locations where no restaurants registered");
        availableLocationSet.removeAll(locationSet);
        System.out.println("No restaurants available ::: " + availableLocationSet);

        SoftAssert softAssert = new SoftAssert();
        System.out.println("VERIFY - when no restaurant location selected, it should show No restaurants.");
        for(String location : availableLocationSet){
            findFoodPage.setLocationInDropdown(location);
            boolean flag = findFoodPage.isNoRestaurantsLabelIsDisplayed();
            softAssert.assertTrue(flag, location + ", no restaurant label was not displayed");
        }
        softAssert.assertAll();

        //       System.out.println("STEP - close doc notification");
        //       restaurantsPage.clickOnDismiss();

//        System.out.println("VERIFY - doc notification is not displayed");
//        boolean isNotificationDisplayedFlag = restaurantsPage.isDocNotificationDisplayed();
//        Assert.assertFalse(isNotificationDisplayedFlag);
    }

    @AfterMethod
    public void tearDown(){

        //BrowserActions.quitBrowser();
    }
}