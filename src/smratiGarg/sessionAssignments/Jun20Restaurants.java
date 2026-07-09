package smratiGarg.sessionAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import smratiGarg.base.BrowserActions;
import smratiGarg.pages.RestaurantPage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jun20Restaurants {

    @Test
    public void userNameTest(){

        WebDriver driver = BrowserActions.start("http://34.173.201.53/access#/access");
        SoftAssert softAssert = new SoftAssert();

        RestaurantPage restaurantPage = new RestaurantPage();

        System.out.println("STEP initial password");
        System.out.println("STEP username to enter into site ");
        driver.findElement(By.xpath("//input[@id='access-student-id']"))
                            .sendKeys("39WJAEGT2P");
        driver.findElement(By.xpath("//input[@id='access-code']"))
                            .sendKeys("ZJ9KCRZQ");


        System.out.println("STEP - Clicked submit button");
        driver.findElement(By.xpath("//form[@id='access-form']/button")).click();

        System.out.println("STEP role based login - Customer credential");

        driver.findElement(By
                .xpath("//form[@id='login-form']/input[@type='email']"))
                .sendKeys("smrati.customer@technocredits.com");
        driver.findElement(By
                        .xpath("//form[@id='login-form']/input[@type='password']"))
                .sendKeys("Smrati@123");
        driver.findElement(By
                        .xpath("//form[@id='login-form']/button")).click();



        int totalRestaurant = driver.findElements(By.xpath("//div[@id='restaurants-grid']/div")).size();

        Set<String> restoLocation = new HashSet<>();
        for (int i = 1;i<=totalRestaurant ; i++ ) {

            String restoLocInfo = driver.findElement(By
                    .xpath("//div[@id='restaurants-grid']/div [" + i +"]//p")).getText();
            String [] arrayRestoLocInfo = restoLocInfo.split(" . ");
            System.out.println("Restaurant location "+ arrayRestoLocInfo[0]);
            restoLocation.add(arrayRestoLocInfo[0]);
        }

        System.out.println("total unique restaurant location is - "+restoLocation.size());

        Select selectLocationDropDown = new Select(driver.findElement(By
                .xpath("//select[@id='locality-dropdown']")));

        List<WebElement>  listSelectLocationDropDown = selectLocationDropDown.getOptions();
        Set<String> restoNotFound = new HashSet<>();
        listSelectLocationDropDown.remove(0); //removing first value i.e. "All location"
        for (WebElement we : listSelectLocationDropDown ) {
            if (! restoLocation.contains(we.getText())){
                System.out.println("Restaurant not found "+ we.getText());
                restoNotFound.add(we.getText());
            }
        }
        System.out.println("total not found restro : " +restoNotFound.size());

        System.out.println("VERIFY - when no restaurant location selected, it should show No restaurants.");

        for (String location : restoNotFound){
            System.out.println("STEP - running for location " + location);
             restaurantPage.setLocationInDropDown(location);
             boolean flag = driver.findElement(By.xpath("//div[text()='No restaurants.']")).isDisplayed();
             Assert.assertTrue(flag);
        }
        System.out.println();
        restaurantPage.setLocationInDropDown("Hadapsar");

        boolean flag = driver.findElement(By.xpath("//div[text()='No restaurants.']")).isDisplayed();
        System.out.println(flag);




    }



}
