package smratiGarg.refactorRestaurentApp.testScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smratiGarg.base.BrowserActions;
import smratiGarg.refactorRestaurentApp.pages.LoginPage;
import smratiGarg.refactorRestaurentApp.pages.FindFoodPage;

public class Asgn17_FrameworkTecnoCredRestro {

    @BeforeMethod
    public void setDriver(){
        BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage=new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void restaurant() throws InterruptedException {
        System.out.println();
        System.out.println("select location kothrud");
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();
        findFoodPage.setLocationInDropDown("kothrud");

//        System.out.println("click view and order button");
//        driver.findElement(By.xpath("(//h3[contains(text(),'Abhishek Pure Veg')]/following::a[text()='View & order'])[1]")).click();
//
//        System.out.println("from the restraurent menu locate first food item whose stock value is greater than 0 and increase it to 1");
//        String dish= driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]")).getText();
//        WebElement qtyinputElement= driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/following-sibling::td[1]/input"));
//        qtyinputElement.click();
//        Actions actions=new Actions(driver);
//        actions.sendKeys(Keys.ARROW_UP).perform();
//
//        System.out.println("VERIFY card total is greter than 0 ");
//        String subTotalText = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
//        subTotalText = subTotalText.substring(1);
//        double subTotalPrice = Double.parseDouble(subTotalText);
//        Assert.assertTrue(subTotalPrice>0);
//
//        System.out.println("step click proceed checkout button");
//        driver.findElement(By.xpath("//button[@id='proceed-checkout-btn']")).click();
//
//        System.out.println("step -In the delivery details section,enter address and phone number");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='co-continue']")));
//        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("wagholi");
//        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9343767284");
//
//        System.out.println("capture total payable amount in checkout order summery");
//        String orderSummeryTotalPayableAmount = driver.findElement(By.xpath( "//span[@data-testid='checkout-payable']")).getText();
//
//        System.out.println("step click the continue to payment button");
//        driver.findElement(By.xpath("//button[@id='co-continue']")).click();
//
//        System.out.println("capture total payable amount in payment summery");
//        String paymentSummeryTotalPayableAmount = driver.findElement(By.xpath( " //span[@data-testid='payment-total']")).getText();
//
//        System.out.println("verify order summery payment amount is equal tp total payment amount");
//
//        System.out.println("step enter valid UPI");
//        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("smratigarg@hdfcbank");
//
//        System.out.println("step to click checkbox");
//        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//
//        System.out.println("click on pay and place order");
//        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();
//
//
//
//
//
//
//
//        Thread.sleep(2000);
//        //driver.quit();
//
    }
}