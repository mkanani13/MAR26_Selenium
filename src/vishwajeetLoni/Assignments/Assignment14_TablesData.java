package vishwajeetLoni.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.util.List;

public class Assignment14_TablesData {

    @Test
    public void TableData() {
        System.out.println("Step - Launch browser and select demotables");
        WebDriver driver;
        driver = ActionOnBrowser.start();

        driver.findElement(By.id("demotable")).click();

        System.out.println("Step 2 - Find Employee Basic Info table");
        String Tabletitle = driver.findElement(By.xpath("//div[@id='empbasic']")).getText();  // print the text in table
        System.out.println(Tabletitle);
        // Assert.assertEquals(Tabletitle,"Employee Basic Information");

        System.out.println("Step 3 - Print the data in table");

        List<WebElement> empTable = driver.findElements(By.xpath("//div[@id='empbasic']//tbody"));
        System.out.println("STEP - Employee table data print");
        for (WebElement tabledata : empTable) {
            System.out.println(tabledata.getText());
        }

    }
}


//    public static void main(String[] args) {
//        System.out.println("Step 1 - Launch Browser");
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://automationbykrishna.com");
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // waits till the element is found for the given time before throwing exception
//        driver.findElement(By.id("demotable")).click();
//
//        System.out.println("Step 2 - Find Employee Basic Info table");
//        String Tabletitle = driver.findElement(By.xpath("//div[@id='empbasic']")).getText();  // print the text in table
//        System.out.println(Tabletitle);
//       // Assert.assertEquals(Tabletitle,"Employee Basic Information");
//
//        System.out.println("Step 3 - Print the data in table");
//
//        List<WebElement> empTable = driver.findElements(By.xpath("//div[@id='empbasic']//tbody"));
//        System.out.println("STEP - Employee table data print");
//            for(WebElement tabledata: empTable) {
//                System.out.println(tabledata.getText());
//            }
//
//
//    }
//}
