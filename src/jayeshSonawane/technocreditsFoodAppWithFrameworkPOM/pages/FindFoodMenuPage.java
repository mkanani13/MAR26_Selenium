package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindFoodMenuPage extends BrowserActions {

    private final String PROCEEDTOCHECKOUTBUTTONXPATH = "//button[@id='proceed-checkout-btn']";
    private String coupon;

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(PROCEEDTOCHECKOUTBUTTONXPATH));
    }

    public String getRestaurantName(){
        return driver.findElement(By.xpath("//h2")).getText();
    }

    public int addInStockItemIntoCart(int quantity){
//        driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input")).click();
        WebElement qty = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input"));
        qty.click();

//        int count = 0;
        for (int count = 0; count<quantity; count++){
            actions.sendKeys(Keys.ARROW_UP).perform();
        }

 //       return count;
        return Integer.parseInt(qty.getAttribute("value"));
    }

    public void selectCoupon(String couponCode) {
        coupon = couponCode;
        WebElement couponElement = driver.findElement(By.xpath("//select[@id='coupon-code']"));
        BrowserActions.scrollTo(couponElement);
        Select couponSelect = new Select(couponElement);
        couponSelect.selectByValue(couponCode);
    }

    public double getSubTotal(){
        return Double.parseDouble(driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText().substring(1));
    }

    public double expectedSubTotal(){

        double dishPrice = Double.parseDouble(driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/preceding-sibling::td[1]")).getText().substring(1));

        WebElement qty = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input"));
        int quantity = Integer.parseInt(qty.getAttribute("value"));

        return dishPrice * quantity;
    }

    public double getDiscount(){
        return Double.parseDouble(driver.findElement(By.xpath("//strong[@id='ot-discount']")).getText().substring(1));
    }

    public double getDiscountPercentage(){
        String textPercentage = driver.findElement(By.xpath("//select[@id='coupon-code']/option[contains(text(), '"+coupon+"')]")).getText().split(" — ")[1];
        double discountPercentage = Double.parseDouble(textPercentage.substring(0, textPercentage.indexOf('%')));

        return discountPercentage;
    }

    public double expectedDiscount(){
        double subTotal = expectedSubTotal();
        double discountPercentage = getDiscountPercentage();

        return subTotal * (discountPercentage / 100);
    }

    public double getPayable(){
        return Double.parseDouble(driver.findElement(By.xpath("//strong[@id='ot-total']")).getText().substring(1));
    }

    public double expectedPayable(){
        double subTotal = expectedSubTotal();
        double discount = expectedDiscount();

        return subTotal - discount;
    }

    public void clickOnProceedToCheckoutButton(){
        driver.findElement(By.xpath(PROCEEDTOCHECKOUTBUTTONXPATH)).click();
    }
}
