package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFoodMenuPage extends BrowserActions {

    private final String PROCEED_TO_CHECKOUT_BUTTON_XPATH = "//button[@id='proceed-checkout-btn']";
    private final String DISCOUNT_PERCENTAGE_XPATH = "//select[@id='coupon-code']/option[contains(text(), '%s')]";
    private String coupon;

    @FindBy(xpath = PROCEED_TO_CHECKOUT_BUTTON_XPATH)
    WebElement elementProceedToCheckoutButton;

    @FindBy(xpath = "//h2")
    WebElement elementGetRestaurantName;

    @FindBy(xpath = "(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input")
    WebElement addInStockItemIntoCart;

    @FindBy(xpath = "//select[@id='coupon-code']")
    WebElement elementCouponCode;

    @FindBy(xpath = "//strong[@id='ot-subtotal']")
    WebElement elementSubTotal;

    @FindBy(xpath = "(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/preceding-sibling::td[1]")
    WebElement elementDishPrice;

    @FindBy(xpath = "(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input")
    WebElement elementDishQuantity;

    @FindBy(xpath = "//strong[@id='ot-discount']")
    WebElement elementDiscount;

    @FindBy(xpath = "//strong[@id='ot-total']")
    WebElement elementPayable;

    public FindFoodMenuPage(){
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(){
        visibilityOfElementLocated(By.xpath(PROCEED_TO_CHECKOUT_BUTTON_XPATH));
    }

    public String getRestaurantName(){
//        return driver.findElement(By.xpath("//h2")).getText();
        return getElementText(elementGetRestaurantName, false);
    }

    public int addInStockItemIntoCart(int quantity){
//        driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input")).click();
//        WebElement qty = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input"));
//        qty.click();

        clickOnElement(addInStockItemIntoCart, false);

//        for (int count = 0; count<quantity; count++){
//            actions.sendKeys(Keys.ARROW_UP).perform();
//        }

        sendKeysArrowUp(quantity);

//        return Integer.parseInt(qty.getAttribute("value"));
        return getAttributeValue(addInStockItemIntoCart, "value");
    }

    public void selectCoupon(String couponCode) {
        coupon = couponCode;
//        WebElement couponElement = driver.findElement(By.xpath("//select[@id='coupon-code']"));
        BrowserActions.scrollTo(elementCouponCode);
//        Select couponSelect = new Select(elementCouponCode);
//        couponSelect.selectByValue(couponCode);
        selectDropdownElementByValue(elementCouponCode, couponCode);
    }

    public double getSubTotal(){
//        return Double.parseDouble(driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText().substring(1));
        return Double.parseDouble(getElementText(elementSubTotal, false).substring(1));
    }

    public double expectedSubTotal(){

//        double dishPrice = Double.parseDouble(driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/preceding-sibling::td[1]")).getText().substring(1));
        double dishPrice = Double.parseDouble(getElementText(elementDishPrice, false).substring(1));

//        WebElement qty = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input"));
//        int quantity = Integer.parseInt(qty.getAttribute("value"));
        int quantity = getAttributeValue(elementDishQuantity, "value");
        return dishPrice * quantity;
    }

    public double getDiscount(){
//        return Double.parseDouble(driver.findElement(By.xpath("")).getText().substring(1));
        return Double.parseDouble(getElementText(elementDiscount, false).substring(1));
    }

    public double getDiscountPercentage(){
//        String textPercentage = driver.findElement(By.xpath("//select[@id='coupon-code']/option[contains(text(), '"+coupon+"')]")).getText().split(" — ")[1];
        String textPercentage = getElementText(By.xpath(String.format(DISCOUNT_PERCENTAGE_XPATH, coupon)), false).split(" — ")[1];
        return Double.parseDouble(textPercentage.substring(0, textPercentage.indexOf('%')));
    }

    public double expectedDiscount(){
        double subTotal = expectedSubTotal();
        double discountPercentage = getDiscountPercentage();

        return subTotal * (discountPercentage / 100);
    }

    public double getPayable(){
//        return Double.parseDouble(driver.findElement(By.xpath("//strong[@id='ot-total']")).getText().substring(1));
        return Double.parseDouble(getElementText(elementPayable, false).substring(1));
    }

    public double expectedPayable(){
        double subTotal = expectedSubTotal();
        double discount = expectedDiscount();

        return subTotal - discount;
    }

    public void clickOnProceedToCheckoutButton(){
//        driver.findElement(By.xpath(PROCEEDTOCHECKOUTBUTTONXPATH)).click();
        clickOnElement(elementProceedToCheckoutButton, false);
    }
}
