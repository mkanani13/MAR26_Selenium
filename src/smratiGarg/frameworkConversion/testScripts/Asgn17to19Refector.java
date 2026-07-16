package smratiGarg.frameworkConversion.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import smratiGarg.frameworkConversion.base.BrowserActions;
import smratiGarg.frameworkConversion.pages.*;

import java.time.Duration;


public class Asgn17to19Refector {

    //(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]
    // WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setup(){

        BrowserActions.start("http://34.66.197.232/#/access");

    }

   // @AfterMethod
  //  public void tearDown(){
        //driver.quit();
      //  BrowserActions.quit();
  //  }


    @Test
    public void restaurant() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();

        // -------> FindFoodPage

        FindFoodPage findFoodPage = new FindFoodPage();

        System.out.println("to check customer name is present on top ");
        String expectedNameValue = "smrati garg";

        String actualText = findFoodPage.getLoginName();

        boolean userNameVerification = actualText.toUpperCase().contains(expectedNameValue.toUpperCase());

        softAssert.assertTrue(userNameVerification, "User name expected is: " + expectedNameValue + " which is not found in header: " + actualText);
        softAssert.assertAll();

        System.out.println("select location kothrud");
        findFoodPage.setLocation("Kothrud");


        System.out.println("click view and order button for 'Abhishek Pure Veg' restaurant ");

        findFoodPage.clickRestaurantViewAndOrder("Abhishek Pure Veg");

        //------------- RestaurantMenuPage

        System.out.println("from the restraurent menu locate first food item whose stock value is greater than 0 and increase it to 1");

        RestaurantFoodMenuPage restaurantFoodMenuPage = new RestaurantFoodMenuPage();

        String firstAvailableDish = restaurantFoodMenuPage.getFirstAvailableDish();
        restaurantFoodMenuPage.increaseQuantity(firstAvailableDish, 1);

        System.out.println("VERIFY card total is greter than 0 ");

        double subTotalPrice = restaurantFoodMenuPage.getSubTotal();
        Assert.assertTrue(subTotalPrice > 0);


        System.out.println("step click proceed checkout button");

        restaurantFoodMenuPage.clickProceedtoCheckOut();

        //-----------------order summery page
        System.out.println("step -In the delivery details section,enter address and phone number");

        OrderSummeryPage orderSummeryPage = new OrderSummeryPage();
        orderSummeryPage.waitForPage();
        orderSummeryPage.enterAddressAndMobile("Wagholi", "9343767284");

        System.out.println("capture total payable amount in checkout order summery");

        String orderSummeryTotalPayableAmount = orderSummeryPage.getTotalPayable();

        System.out.println("step click the continue to payment button");
        orderSummeryPage.clickContinue();

        //------------------FoodPaymentPage

        System.out.println("capture total payable amount in payment summery");

        FoodPayment foodPayment = new FoodPayment();
        String paymentSummeryTotalPayableAmount = foodPayment.getTotalPayable();

        System.out.println("verify order summery payment amount is equal tp total payment amount");
        Assert.assertEquals(paymentSummeryTotalPayableAmount, orderSummeryTotalPayableAmount);

        System.out.println("step ente r valid UPI");

        foodPayment.enterUPI("smratigarg@hdfcbank");
        System.out.println("step to click checkbox");

        foodPayment.clickConfirmButton();

        System.out.println("click on pay and place order");
        foodPayment.clickOnPayPkaceOrderBtn();

        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();

        System.out.println("Step Click on view my orders");
        orderSuccessPage.clickOnViewMyOrder();




        //-----------------------------

//        SoftAssert softAssert1 = new SoftAssert();
//        System.out.println("verify that order placed screen is displayed and contains the following details under the track order section");
//        boolean orderFlag=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='order placed!']"))).isDisplayed();

//        System.out.println("verify order placed text is displayed");
//        softAssert.assertTrue(orderFlag);
//        System.out.println("verify restaurant details");

        //Thread.sleep(2000);


    }

    }