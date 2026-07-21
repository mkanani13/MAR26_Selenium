package vishwajeetLoni.Assignments;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Scroll down the page and in the "Selects" section dropdown perform the following activities:-
//
//Select the option with number '3' from the dropdown
//
//Use the isSelected() method to confirm whether the intended dropdown option is currently selected or not
//
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.util.List;

public class Assignment10_Dropdown {

    @Test
    public void singleSelectDropdown(){
        WebDriver driver;
        driver = ActionOnBrowser.start();

        System.out.println("Step 1 - Launch Browser");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Step - Scroll to dropdown section");
        WebElement dropdown = driver.findElement(By.xpath("//form[@class = 'form-horizontal adminex-form']/div[3]//select[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropdown);

        System.out.println("Step 4 - Select option 3");
        Select selectoption = new Select(dropdown);
        selectoption.selectByVisibleText("3");
        // selectoption.selectByValue(); can be used when value attribute is present
        // selectoption.selectByIndex(2); used for selection by index starting from zero

        System.out.println("Is dropdown multiselect ? " ); // verify type of dropdown
        System.out.println(selectoption.isMultiple());

        int size = selectoption.getOptions().size();
        System.out.println(size + " is the total number of available options");
        System.out.println("Print the available options");
        List<WebElement> ListOfOptions = selectoption.getOptions();
        for (WebElement e : ListOfOptions){
            System.out.println(e.getText());
        }

        System.out.println("Step 5 - Verify if option 3 is selected");
        for (WebElement e : ListOfOptions){
            if (e.isSelected()) {
                System.out.println(e.getText() + "  is selected");
            }
        }

        List<WebElement> SelectedOptions = selectoption.getAllSelectedOptions();
        System.out.println("List of selected " + SelectedOptions.get(0).getText());

    }

//    public static void main(String[] args) {
//        System.out.println("Step 1 - Launch Browser");
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://automationbykrishna.com");
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // waits till the element is found for the given time before throwing exception
//        driver.findElement(By.id("basicelements")).click();
//
//
//        System.out.println("Step - Scroll to dropdown section");
//        WebElement dropdown = driver.findElement(By.xpath("//form[@class = 'form-horizontal adminex-form']/div[3]//select[1]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
//
//
////        System.out.println("Step 3 - Click on Singleselect dropdown");
////        dropdown.click();
////        System.out.println("Dropdown opened");
//
//        System.out.println("Step 4 - Select option 3");
//        Select selectoption = new Select(dropdown);
//        selectoption.selectByVisibleText("3");
//       // selectoption.selectByValue(); can be used when value attribute is present
//       // selectoption.selectByIndex(2); used for selection by index starting from zero
//
//        System.out.println("Is dropdown multiselect ? " ); // verify type of dropdown
//        System.out.println(selectoption.isMultiple());
//
//
//        int size = selectoption.getOptions().size();
//        System.out.println(size + " is the total number of available options");
//        System.out.println("Print the available options");
//        List<WebElement> ListOfOptions = selectoption.getOptions();
//        for (WebElement e : ListOfOptions){
//                System.out.println(e.getText());
//        }
//
//        System.out.println("Step 5 - Verify if option 3 is selected");
//
//        for (WebElement e : ListOfOptions){
//            if (e.isSelected()) {
//                System.out.println(e.getText() + "  is selected");
//            }
//        }
//
//        List<WebElement> SelectedOptions = selectoption.getAllSelectedOptions();
//        System.out.println("List of selected " + SelectedOptions.get(0).getText());
//
//
//    }
}
