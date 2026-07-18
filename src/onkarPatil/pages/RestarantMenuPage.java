package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestarantMenuPage extends BrowserActions {

    public RestarantMenuPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@data-testid='restaurant-name']")
    WebElement restaurantNameElement;

    @FindBy(xpath = "(//tr[contains(@data-testid,'menu-row-dish')]/td[4][text()!='0'])[1]/following-sibling::td/input")
    WebElement inputQuantityForFirstAvailableDishElement;

    @FindBy(id = "coupon-code")
    WebElement coupanCodeElement;

    @FindBy(id = "proceed-checkout-btn")
    WebElement checkoutBtnElement;

    @FindBy(id = "ot-subtotal")
    WebElement subtotalAmtElement;

    @FindBy(id = "ot-discount")
    WebElement discountAmtElement;

    @FindBy(id = "ot-total")
    WebElement totalAmtElement;


    public void waitForPageLoad(){
        waitUntilElementIsVisible(restaurantNameElement);
    }

    public String getRestaurantName(){
        return getTextOfElement(restaurantNameElement, false);
    }

    public void addFirstAvailableDishInCart(int quantity){
        clickOnElement(inputQuantityForFirstAvailableDishElement, false);
        for(int i=1; i<=quantity; i++){
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

    public int getAvailbleQuantity(){
        String value = getAttributeFromElement(inputQuantityForFirstAvailableDishElement, "value", false);
        return Integer.parseInt(value);
    }

    public void selectCoupanFromDropdown(){
        selectOptionFromDropdownByValue(coupanCodeElement, "PUNE50");
    }

    public double getSubTotalAmount(){
        scrollToElement(checkoutBtnElement);
        String subTotalAmtText = getTextOfElement(subtotalAmtElement, false).substring(1);
        return Double.parseDouble(subTotalAmtText);
    }

    public double getDiscountAmt(){
        scrollToElement(checkoutBtnElement);
        String discountAmtText = getTextOfElement(discountAmtElement, false).substring(1);
        return Double.parseDouble(discountAmtText);
    }

    public double getTotalPayableAmt(){
        scrollToElement(checkoutBtnElement);
        String totalAmtText = getTextOfElement(totalAmtElement, false).substring(1);
        return Double.parseDouble(totalAmtText);
    }

    public void clickOnCheckoutBtn(){
        clickOnElement(checkoutBtnElement, false);
    }
}
