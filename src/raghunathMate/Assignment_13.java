package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import raghunathMate.testBase.BrowserAction;


import java.util.ArrayList;
import java.util.List;

public class Assignment_13 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Step_1 - Launching browser and loading link");
        driver = BrowserAction.start();
    }

    @Test
    public void verifyMultiSelectionDropDown(){
        System.out.println("Step_2 - Navigating to DropDown Box");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        // WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        WebElement dropdown = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[2]"));
        Select s = new Select(dropdown);
        System.out.println("Step_3 - Verifying DropDown Box is multi-selected or not");
        Assert.assertTrue(s.isMultiple(),"DropDown is not multi-selected");
        System.out.println("Step_4 - Clicking on multiple options from DropDown");
        s.selectByIndex(1);
        s.selectByVisibleText("5");
        System.out.println("Step_5 - storing selected option in list");
        List<WebElement> options = s.getOptions();
        List<Integer> listOfSelectedOption = new ArrayList<Integer>();
        System.out.println("Step_6 - printing selected option in list");
        for(WebElement e:options) {
            if(e.isSelected()){
                int opt = Integer.parseInt(e.getText());
                listOfSelectedOption.add(opt);
            }
        }
        System.out.println(listOfSelectedOption);
        System.out.println("Step_7 - deselecting 2 and 5 from DropDown");
        s.deselectByIndex(4);
        s.deselectByVisibleText("2");
        options = s.getOptions();
        listOfSelectedOption = new ArrayList<Integer>();
        System.out.println("Step_8 - printing selected option in list");
        for(WebElement e:options) {
            if(e.isSelected()){
                int opt = Integer.parseInt(e.getText());
                listOfSelectedOption.add(opt);
            }
        }
        System.out.println(listOfSelectedOption);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
