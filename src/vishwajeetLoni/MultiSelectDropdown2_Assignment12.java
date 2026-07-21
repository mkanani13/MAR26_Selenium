package vishwajeetLoni;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class MultiSelectDropdown2_Assignment12 {

    public static void main(String[] args) {

        System.out.println("Step 1 - Launch Browser");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // waits till the element is found for the given time before throwing exception
        driver.findElement(By.id("basicelements")).click();



        System.out.println("Step 2 - Scroll to dropdown section");
        System.out.println("");
        WebElement dropdown = driver.findElement(By.xpath("//form[@class = 'form-horizontal adminex-form']/div[3]//select[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropdown);


//        System.out.println("Step 3 - Click on Singleselect dropdown");
//        dropdown.click();
//        System.out.println("Dropdown opened");

        System.out.println("Step 4 - Select option 2 & 5");
        Select selectoption = new Select(dropdown);
        selectoption.selectByVisibleText("2");
        selectoption.selectByVisibleText("5");
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

        System.out.println("Step 5 - Verify if option 2 & 5 are selected");

        for (WebElement e : ListOfOptions){
            if (e.isSelected()) {
                System.out.println(e.getText() + "  is selected");
            }
        }


        System.out.println("Step 6 - Deselect option 5");
        selectoption.deselectByVisibleText("5");

        for (WebElement e : ListOfOptions){
            if (e.isSelected()) {
                System.out.println(e.getText() + "  is updated selection");
            }
        }

    }
}
