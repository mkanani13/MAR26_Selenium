package smratiGarg.sessionAssignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class Jun20OrderFlowTest {
    WebDriver driver = null;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("http://34.173.201.53/access#/access");

    }
    @AfterClass
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
      //  driver.quit();
    }
    public void login(){
        System.out.println("STEP initial password");
        //System.out.println("STEP username to enter into site ");
        driver.findElement(By.xpath("//input[@id='access-student-id']"))
                .sendKeys("39WJAEGT2P");
        driver.findElement(By.xpath("//input[@id='access-code']"))
                .sendKeys("ZJ9KCRZQ");


//        System.out.println("STEP - Clicked submit button");
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
    }

    String getDispayedUserName() {
        try {
            Thread.sleep(2000);
        } catch ( InterruptedException ie) {
            System.out.println("Failed in thread sleep!!");
        }

        String displayedUserName = driver.findElement(By
                .xpath("//span[@id='user-chip-name']")).getAttribute("textContent") ;
        return displayedUserName;

    }

    boolean selectLocationFromDownDown(String location){
        try {
            driver.findElement(By.xpath("//select[@id='locality-dropdown']/option[text()='" + location + "']")).click();
            return true;
        } catch (NoSuchElementException ne){
            System.out.println("No such location found ");
            return false;
        }
    }

    boolean viewOrderRestaurantFromGrid(String restaurant){
        //first to find if this restaurant is present or not and in the same loop we can click on view and order botton "it is <a> tag"
        boolean isRestroPresent = false;
        List<WebElement> listOfRestroFromGrid = driver.findElements(By.xpath("//div[@id='restaurants-grid']/div"));

        if (listOfRestroFromGrid.isEmpty()) {
            return false;
        }

        for (int index = 1; index <= listOfRestroFromGrid.size(); index++){
            String restroDisplayName = driver.findElement(By.xpath(
                    "//div[@id='restaurants-grid']/div["+index+"]/div/div/div/h3")).getText();
//            System.out.println("Restro display name "+ restroDisplayName);
            if (restroDisplayName.equals(restaurant)){
                System.out.println("Found restaurant : "+restaurant+" at index "+index);
                isRestroPresent = true;
                driver.findElement(By.xpath("//div[@id='restaurants-grid']/div["+index+"]/div/div/a[text()='View & order']")).click();
                // to find first restaurant - (//a[contains(@data-testid,'view-restaurant-res')])[1]
            }

            //alternate     //div[@id='restaurants-grid']/div[1]/div/div/a[text()='View & order']
                            //div[@id='restaurants-grid']//h3[text()='Durga']following::div[1]/a
                            //div[@id='restaurants-grid']//h3[text()='Durga']following::a[1]
            //              (//div[@id='resaurants-grid']//ul/li)[1]/proceding::a[text()='View & order'][1]
            //              (//div[@data-testid='restaurants-grid']//p[not(contains(text(),' 0 dishes'))])[1]/following::a[1]
        }
        return isRestroPresent;
    }

    double getSubTotalAmount() {
        double totalAmount = Double.parseDouble(driver
                .findElement(By.id("ot-subtotal")).getText()
                .replaceAll("[^0-9.]","") //alternative is to use replace "₹"
        );
//        System.out.println(totalAmount);
        return totalAmount;

    }

    double getPayableAmount() {
        double payableAmount = Double.parseDouble(driver
                .findElement(By.id("ot-total")).getText()
                .replaceAll("[^0-9.]","") //alternative is to use replace "₹"
        );
//        System.out.println(payableAmount);
        return payableAmount;
    }

    int getCountOfDishesDisplay(){
        return driver.findElements(By.xpath("//*[@data-testid='menu-table']/tbody/tr")).size();
    }

    double addFirstInStockDish(){
        double amountToBeIncrease = 0.0;

        int totalNumberOfDishes = getCountOfDishesDisplay();

        for (int index = 1 ; index <=totalNumberOfDishes ; index++){
            String dishInStockString = driver.findElement(By
                    .xpath("//*[@data-testid='menu-table']/tbody/tr["+index+"]/td[4]"))
                    .getText();
            int dishInStock = Integer.parseInt(dishInStockString);
            if (dishInStock > 0 ) {
                String dishPriceString = driver.findElement(By
                                .xpath("//*[@data-testid='menu-table']/tbody/tr[" + index + "]/td[3]"))
                        .getText().replaceAll("[^0-9.]", "");
                double dishPrice = Double.parseDouble(dishPriceString);
                String dishName =  driver.findElement(By
                                .xpath("//*[@data-testid='menu-table']/tbody/tr[" + index + "]/td[1]/div/div/div"))
                        .getText();
                System.out.println("Dish: "+dishName +" is in stock. Available quantity: " + dishInStock + " and Price: " + dishPriceString);

                // could get quantity value and then increase with one
                // int quantity = Integer.parseInt(driver.findElement(By.xpath("//*[@data-testid='menu-table']/tbody/tr[" + index + "]/td[5]/input")).getText());

                /*option one

                WebElement quantityInput = driver.findElement(By.xpath("//table[@data-testid='menu-table']/tbody/tr[" + index + "]/td[5]/input"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", quantityInput);
                quantityInput.clear();
                quantityInput.sendKeys("1");
                 */

                //Option two Drag dish to cart area
                // // alternate version -> to print dish name itself (//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]


                WebElement dishItem = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]"));
                WebElement dropAreaElement = driver.findElement(By.xpath("//div[@id='cart-dropzone']"));
                Actions actions = new Actions(driver);
                actions.dragAndDrop(dishItem,dropAreaElement).perform();
                // it should drag dish to drop area

                WebElement quantityInput = driver.findElement(By
                        .xpath("//table[@data-testid='menu-table']/tbody/tr[" + index + "]/td[5]/input"));
                String quantityInputValue = quantityInput.getAttribute("value");
                // it should be 1 now after dragging dish

                // to click input button one up
                quantityInput.click();
                actions.sendKeys(Keys.ARROW_UP).perform();

                amountToBeIncrease =dishPrice*2;
                break;
            }
        }
        return amountToBeIncrease;
    }


    boolean enterContactDetails (String address, String mobile){
        WebElement addressWE = driver.findElement(By.id("addr-pick-input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addressWE);
        addressWE.sendKeys(address);
        driver.findElement(By.id("contact-mobile")).sendKeys(mobile);
        return true;

    }

    String placeOrder(){
        WebElement captchaCheckBox = driver
                .findElement(By.xpath("//input[@id='captcha-checkbox']"));
        if (! captchaCheckBox.isSelected()){
            captchaCheckBox.click();
        }
        driver.findElement(By.xpath("//button[@data-testid='place-order-btn']")).click();
        return getOrderNumber();

    }

    String getOrderNumber(){
//        String orderNumber = driver.findElement(By.xpath("//span[@data-testid='order-progress-label']")).getText();
//        if (orderNumber.equals("Placing…")){
//            System.out.println("Retry count : ");
//            return getOrderNumber();
//        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 4. Create a pointer (locator) to find the text span
        By orderSpan = By.xpath("//span[@data-testid='order-progress-label']");

        // 5. SMART WAIT: Wait until the text inside the span starts with "ORDER"
        // This completely skips the temporary "placing..." message automatically!
        wait.until(ExpectedConditions.textToBePresentInElementLocated(orderSpan, "Order "));

        // 6. Grab the text immediately before the page changes
        String orderNumber = driver.findElement(orderSpan).getText();

        // Print the final result to your console
        System.out.println("Your Order Number is: " + orderNumber);

        String[] orderNumberWords = orderNumber.split(" ");
        if(orderNumberWords.length >1){
            return orderNumberWords[1];
        }

        return orderNumber;
    }

    String pageURLEndsWith(String endWithKey, int toWaitingFor){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(toWaitingFor));
        wait.until(ExpectedConditions.urlMatches (".*"+endWithKey+"$"));
        return driver.getCurrentUrl();
    }

    boolean isOrderDisplay (String orderNumber){
        return !driver.findElements(
                By.xpath("//table[@data-testid='orders-table']/tbody/tr/td[1][text()='" + orderNumber + "']"))
                .isEmpty();
    }


    @Test
    public void orderFlowTesting(){
        System.out.println("STEP - login");
        login();
        SoftAssert softAssert = new SoftAssert();
        String  displayedUserName = getDispayedUserName ();
        String expectedDisplayName = "smrati.customer";
        System.out.println("Displayed name "+displayedUserName );

        softAssert.assertEquals(displayedUserName,expectedDisplayName
                ,"Displayed User Name check - Expected:"+expectedDisplayName+ " Actual:"+displayedUserName);

        String locationToSelect = "Kothrud";
        System.out.println("STEP - Selecting location as '"+locationToSelect+"' from dropDown");

        boolean locationSelected = selectLocationFromDownDown (locationToSelect);
        softAssert.assertTrue(locationSelected,"Selecting Kothrud location");

        String restaurantToOrderFrom = "Abhishek Pure Veg";
        System.out.println("STEP - Selecting '"+restaurantToOrderFrom+"' view&Order option");

        boolean clickOrderRestro = viewOrderRestaurantFromGrid(restaurantToOrderFrom);
        softAssert.assertTrue(clickOrderRestro,"While ordering from "+ restaurantToOrderFrom);

        double subTotalAmount = getSubTotalAmount();
//        System.out.println("Initially sub total amount is "+subTotalAmount);

        softAssert.assertEquals(subTotalAmount,0.0,"Sub Amount initially expected to be Zero");

        double payableAmount = getPayableAmount();
//        System.out.println("Initial payable amount is : "+ payableAmount);
        System.out.println("VERIFY - Initial payable amount should be Zero");
        softAssert.assertEquals(payableAmount,0.0,"Payable Amount initially expected to be Zero");

        int totalNumberOfDishes = getCountOfDishesDisplay();

        softAssert.assertNotEquals(totalNumberOfDishes,0,"At least one Dish is expected to be listed");

        double amountToBeIncrease = addFirstInStockDish();

        softAssert.assertNotEquals(amountToBeIncrease,0.0,"No dish found in stock");

        double expectedPayableAmount =  Double.sum(payableAmount,amountToBeIncrease);
        System.out.println("After selection new payable amount is expected to be : "+ expectedPayableAmount);

        payableAmount = getPayableAmount();
        System.out.println("VERIFY - expected payable amount: "+ expectedPayableAmount +" with displayed payable amount : "+payableAmount );
        softAssert.assertEquals(payableAmount,expectedPayableAmount,"Payable amount should add-up after dish quantity selected");




        String addressToEnter = "Rohan Abhilasha, Wagholi";
        String contactMobileNumber = "9343767284"; // Only digits are allowed

        boolean enterContactDet = enterContactDetails (addressToEnter, contactMobileNumber);
        softAssert.assertTrue(enterContactDet,"Entering contact details - Address:"+addressToEnter+" mobile:"+contactMobileNumber);


        String orderNumber = placeOrder();
        System.out.println("VERIFY - Order Number : "+orderNumber);
        softAssert.assertTrue(orderNumber.startsWith("ORDER"),"fetched order number is to start with Order");


        //validate url is changed to http://34.173.201.53/access#/orders

        System.out.println("VERIFY - Url to be ending with orders" );

        String pageURL = pageURLEndsWith("orders",15);

        softAssert.assertTrue(pageURL.endsWith("orders"),"new page URL '"+pageURL+"' is expected to be ending with orders");

        System.out.println("VERIFY - new order is visible in order page");

        boolean orderIsDisplayed = isOrderDisplay(orderNumber);
        softAssert.assertTrue(orderIsDisplayed,"Order : "+ orderNumber+" should have been displayed in my order page");


        softAssert.assertAll();
    }

}
