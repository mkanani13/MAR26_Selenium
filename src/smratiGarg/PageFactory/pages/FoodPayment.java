package smratiGarg.PageFactory.pages;

import org.openqa.selenium.By;
import smratiGarg.PageFactory.base.BrowserAction;

public class FoodPayment extends BrowserAction {

    public String getTotalPayable(){
        return driver.findElement(By.xpath( " //span[@data-testid='payment-total']"))
                .getText();
    }

    public void enterUPI(String upiID){
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys(upiID);
    }

    public void clickConfirmButton(){
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

    }
    public void clickOnPayPkaceOrderBtn(){
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();
    }

}
