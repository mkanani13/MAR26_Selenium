package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class FoodOrderPage extends BrowserAction {

    private final String  locationDropDown_xpath = "//select[@data-testid='locality-dropdown']";

    public void waitPageLoad(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[text()='View & order']"),1));
    }

    public void totalRestaurant(){
        System.out.println("Find and printing total count of restaurant");
        int countOfRestro = driver.findElements(By.xpath("//div[(contains(@data-testid,'restaurant-card-res'))]")).size();
        System.out.println(countOfRestro);
    }

    public Set<String> findUniqueLocationsAvailableOnApplication() {
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        List<WebElement> listOfLocations = locationDropDownSelector.getOptions();
        Set<String> setOfLocation = new LinkedHashSet<String>();
        String allLocation = "All localities";
        for(WebElement e: listOfLocations) {
            String location  = e.getText();
            if(!(allLocation.equalsIgnoreCase(location))) {
                setOfLocation.add(location);
            }
        }
        return setOfLocation;
    }

    public void getCountAndListOfRestaurantAtPlace(String place) {
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        locationDropDownSelector.selectByVisibleText(place);
        List<WebElement> RestoListAtPlace = driver.findElements(By.xpath("//div/h3"));
        System.out.println("Total Count at "+place+" is :- "+RestoListAtPlace.size());
        for(WebElement e : RestoListAtPlace){
            System.out.println(e.getText());
        }

    }

    public void getLocationWhereNoRestaurantListedYet(){
        FoodOrderPage foodorder = new FoodOrderPage();
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        Set<String> locationSet = foodorder.findUniqueLocationsAvailableOnApplication();
        Set<String> noRestoLocation = new LinkedHashSet<String>();
        for(String l:locationSet) {
            locationDropDownSelector.selectByVisibleText(l);
            int countOfRestro = driver.findElements(By.xpath("//div[(contains(@data-testid,'restaurant-card-res'))]")).size();
            if (!(countOfRestro>0)){
                noRestoLocation.add(l);
            }
        }
        System.out.println("Location :- "+noRestoLocation);
    }

    public void getLocationWhereRestaurantListed(){
        FoodOrderPage foodorder = new FoodOrderPage();
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        Set<String> locationSet = foodorder.findUniqueLocationsAvailableOnApplication();
        Set<String> RestoLocation = new LinkedHashSet<String>();
        for(String l:locationSet) {
            locationDropDownSelector.selectByVisibleText(l);
            int countOfRestro = driver.findElements(By.xpath("//div[(contains(@data-testid,'restaurant-card-res'))]")).size();
            if (!(countOfRestro>=1)){
                RestoLocation.add(l);
            }
        }
        System.out.println("Location :- "+RestoLocation);
    }

    public boolean userNameVisibilityCheck() {
        WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'raghuCust')]"));
        return userName.isDisplayed();
    }

    public void selectLocationFromDropDown(String location) {
        WebElement locationDropDown = driver.findElement(By.xpath(locationDropDown_xpath));
        Select locationDropDownSelector = new Select(locationDropDown);
        locationDropDownSelector.selectByVisibleText(location);
    }
    public void selectRestraurant(String name){
        driver.findElement(By.xpath("//h3[contains(text(),'"+name+"')]/following::a[1]")).click();
    }

    public String  getFirstRestraurantwhichHasNonZeroDish(){
        String restoName =null;
        try {
             restoName =  driver.findElement(By.xpath("//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/preceding-sibling::h3")).getText();

        }catch(NoSuchElementException ne){
            System.out.println("Either no restaurants or all the restaurants having 0 dishes");
        }
        String[] arrayWord =  restoName.split(" ");
        String[] newWordArray = Arrays.copyOf(arrayWord,(arrayWord.length)-1);
        String restoName1= String.join(" ",newWordArray).trim();
        System.out.println(restoName1);
        return restoName1;
    }

    public void navigateToMyOrderPage(){
        driver.findElement(By.xpath("//a[text()='\uD83D\uDCE6 My Orders']")).click();
    }


    public void appliedDiscountCoupon(String coupon) {
        WebElement couponDropDown = driver.findElement(By.xpath("//select[@id='coupon-code']"));
        Select discountCouponSelection = new Select(couponDropDown);
        discountCouponSelection.selectByVisibleText(coupon);
        //discountCouponSelection.selectByValue(coupon);
    }

    public void subTotalAndPayableVerification(){
        String subtotal = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        subtotal = subtotal.substring(1);
        double subTotal = Double.parseDouble(subtotal);
        String payable = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        payable = payable.substring(1);
        double payableAmt = Double.parseDouble(payable);
        double actualPayableAmt;
        String discount = driver.findElement(By.xpath("//strong[@id='ot-discount']")).getText();
        discount = discount.substring(1);
        double discountAmt = Double.parseDouble(discount);
        double calculatedDiscountAmt;
        //softassert.assertTrue(subTotal>0, "Sub total is zero");
        WebElement couponDropDown = driver.findElement(By.xpath("//select[@id='coupon-code']"));
        Select discountCouponSelection = new Select(couponDropDown);
        List<WebElement> discountCoupons = discountCouponSelection.getOptions();
        String couponText ="";
        for(WebElement coupon : discountCoupons){
            if(coupon.isSelected()){
                couponText = coupon.getText();
                break;
            }
        }
        if(couponText.contains("10%")){
            calculatedDiscountAmt = subTotal*0.1;
        } else if(couponText.contains("20%")) {
            calculatedDiscountAmt = subTotal*0.2;
        } else {
            calculatedDiscountAmt = 0.00;
        }
        actualPayableAmt = subTotal - calculatedDiscountAmt;

        //softassert.assertTrue(payableAmt==actualPayableAmt,"Payable amount is not matching");
        System.out.println("Sub Total: "+ subTotal);
        System.out.println("Calculated Payable Amt: "+ actualPayableAmt);
        System.out.println("Calculated Discount Amt: "+ calculatedDiscountAmt);
    }




    public void puttingOrder() {
        SoftAssert softassert = new SoftAssert();
        System.out.println("Starting putting order");
        System.out.println("Verifying customer user name");
        String actualUserName = driver.findElement(By.xpath("//span[@id='user-chip-name']")).getText();
        System.out.println("Printing actual user name:- " + actualUserName);
        String expectedUserName = "raghuCust12345";
        softassert.assertEquals(expectedUserName, actualUserName, "User name miss matched");
        System.out.println("Selecting location for order");
        WebElement locationSelectionDropDown = driver.findElement(By.xpath("//select[@data-testid='locality-dropdown']"));
        Select locSelection = new Select(locationSelectionDropDown);
        locSelection.selectByVisibleText("Kothrud");
        System.out.println("Selecting restaurant for order");
        driver.findElement(By.xpath("//a[@href='#/restaurants/res_pune_555076']")).click();
        System.out.println("Adding element in order");
//        driver.findElement(By.xpath("//input[@data-item='dish_23be15']")).clear();
//        driver.findElement(By.xpath("//input[@data-item='dish_23be15']")).sendKeys("1");
//        driver.findElement(By.xpath("//button[@data-name='Veg Kolhapuri']")).click();
        driver.findElement(By.xpath("//input[@data-item='dish_028480']")).clear();
        driver.findElement(By.xpath("//input[@data-item='dish_028480']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@data-name='Butter Roti']")).click();
        String totalItemSelectedExp = "1 item(s) selected";
        String totalItemUnitExp = "1 unit(s)";
        String order = driver.findElement(By.xpath("//span[@id='cart-summary']")).getText();
        String[] strArray = order.split(" . ");
        String totalItemSelectedAct = strArray[0];
        String totalItemUnitAct = strArray[1];
        System.out.println("Verifying order items");
        softassert.assertEquals(totalItemSelectedExp, totalItemSelectedAct);
        softassert.assertEquals(totalItemUnitExp, totalItemUnitAct);
        System.out.println("Entering address for delivery and mobile no");
        driver.findElement(By.xpath("//input[@id='addr-pick-input']")).sendKeys("Vadgaon Budruk");
        driver.findElement(By.xpath("//input[@id='contact-mobile']")).sendKeys("9730857334");
        System.out.println("Verifying prize");
        String subTotalAct = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        String subTotalExp = "₹40.00";
        softassert.assertEquals(subTotalAct, subTotalExp);
        System.out.println("clicking check box of i am not robot");
        driver.findElement(By.xpath("//input[@id='captcha-checkbox']")).click();
        System.out.println("clicking on place order button");
        driver.findElement(By.xpath("//button[@data-testid='place-order-btn']")).click();
        System.out.println("getting and printing order id");
        String orderId = driver.findElement(By.xpath("//button[@data-testid='place-order-btn']")).getText();
        System.out.println("Order id:-" + orderId);
        System.out.println("Verifying order id in the order table");
        List<WebElement> ordersId = driver.findElements(By.xpath("//table[@class='min-w-full text-sm']/tbody/tr/td[1]"));
        for (WebElement e : ordersId) {
            System.out.println("Order id from order table:-" + e.getText());
            if (orderId.equals(e.getText())) {
                System.out.println("Order Id is present in order table");
            }
        }
        softassert.assertAll();
        System.out.println("TC-2 end");
    }
}
