//Using Selenium WebDriver in Java, automate the following scenario:
//        Open the website http://automationbykrishna.com/.
//        Click on the "Basic Elements" tab to navigate to the corresponding section.
//        Scroll down to the Multi-Select dropdown.
//        Select the options '2' and '5' from the dropdown.
//        Fetch and print all currently selected options in the Console.
//        Deselect the option '5' from the dropdown.
//        Fetch and print the updated list of selected options in the Console after deselection.

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

public class Assignment_12 {
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
        System.out.println("Step_5 - deselecting 5 from DropDown");
        s.deselectByVisibleText("5");
        System.out.println("Step_6 - storing selected option in list");
        List<WebElement> options = s.getOptions();
        List<Integer> listOfSelectedOption = new ArrayList<Integer>();
        for(WebElement e:options) {
            if(e.isSelected()){
                int opt = Integer.parseInt(e.getText());
                listOfSelectedOption.add(opt);
            }
        }
        System.out.println("Step_7 - printing selected option in list");
        System.out.println(listOfSelectedOption);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
