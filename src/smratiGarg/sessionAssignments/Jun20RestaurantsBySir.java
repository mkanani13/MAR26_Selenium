package smratiGarg.sessionAssignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import smratiGarg.base.BrowserActions;
import smratiGarg.refactorRestaurentApp.pages.LoginPage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jun20RestaurantsBySir {
    WebDriver driver = null;

    @BeforeClass
    public void setup(){
        driver = BrowserActions.start("http://34.173.201.53/access#/access");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }



    @Test
    public void userNameTest(){

        SoftAssert softAssert = new SoftAssert();


        int totalRestaurant = driver.findElements(By.xpath("//div[@id='restaurants-grid']/div")).size();

        Set<String> restoLocation = new HashSet<>();
        for (int i = 1;i<=totalRestaurant ; i++ ) {

            String restoLocInfo = driver.findElement(By
                    .xpath("//div[@id='restaurants-grid']/div [" + i +"]//p")).getText();
            String [] arrayRestoLocInfo = restoLocInfo.split(" ");
            System.out.println("Restaurant location "+ arrayRestoLocInfo[0]);
            restoLocation.add(arrayRestoLocInfo[0]);
        }

        System.out.println("total unique restaurant is - "+restoLocation.size());

        Select selectLocationDropDown = new Select(driver.findElement(By
                .xpath("//select[@id='locality-dropdown']")));

        List<WebElement>  listSelectLocationDropDown = selectLocationDropDown.getOptions();
        Set<String> restoNotFound = new HashSet<>();

        for (WebElement we : listSelectLocationDropDown ) {

            if (! restoLocation.contains(we.getText())){
                System.out.println("Restaurant not found "+ we.getText());
                restoNotFound.add(we.getText());
            }
        }
        System.out.println("total not found restro : " +restoNotFound.size());





    }



}
