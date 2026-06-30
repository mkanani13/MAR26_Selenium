package vishwajeetLoni.Assignments;

//Using Selenium WebDriver in Java, automate the following scenario:
//
//        Open the website http://automationbykrishna.com/.
//        Click on the "Demo Tables" tab to navigate to the tables section.
//        Locate the "EMPLOYEE BASIC INFORMATION" table.
//        Read and iterate through all the rows of the table.
//        Find the row where the "Username" column contains the value "asharma".
//        From the same row, retrieve the corresponding value from the "First Name" column.
//        Print the extracted First Name value in the Console.



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.time.Duration;
import java.util.List;

public class Assignment16_TablesFindFirstname {

    @Test
    public void TableFindFirstname() {
        System.out.println("Step - Launch browser and select demotables");
        WebDriver driver;
        driver = ActionOnBrowser.start();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.findElement(By.id("demotable")).click();

        System.out.println("Step 2 - Find Employee Basic Info table and Print the data in it");
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empbasic']")));

        String Tabledata = table.getText();  // print the text in table
        System.out.println(Tabledata);

//        For when we can use for loop based on rows for the table
//        String getUserName(String firstName){
//            int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
//            for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){
//                String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
//                if(fName.equals(firstName))
//                    return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
//            }
//            return null;
//        }

        List<WebElement> empTableUname = driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr/td[4]"));
        for (WebElement uname : empTableUname) {
            if (uname.getText().equals("asharma")) { // had to get text since the loop is of webelements and cannot directly
                System.out.println("Found asharma, now get the firstname:");
                WebElement firstname = uname.findElement(By.xpath("./preceding-sibling::td[2]"));  // ./ means the element that we have the list for ,from there we continue ahead.Here it means td where the username is asharma
                System.out.println("Firstname: " + firstname.getText());
            }
        }
    }
}


//        public static void main(String[] args) {
//        System.out.println("Step 1 - Launch Browser");
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://automationbykrishna.com");
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // waits till the element is found for the given time before throwing exception
//        driver.findElement(By.id("demotable")).click();
//
//        System.out.println("Step 2 - Find Employee Basic Info table and Print the data in it");
//        String Tabletitle = driver.findElement(By.xpath("//div[@id='empbasic']")).getText();  // print the text in table
//        System.out.println(Tabletitle);
//       // Assert.assertEquals(Tabletitle,"Employee Basic Information");
//
//        System.out.println("Step 3 - Find 'asharma' in  username");
//
//        List<WebElement> empTableUname = driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr/td[4]"));
//        for (WebElement uname : empTableUname) {
//            if (uname.getText().equals("asharma")) { // had to get text since the loop is of webelements and cannot directly
//                System.out.println("Found asharma, now get the firstname:");
//                WebElement firstname = uname.findElement(By.xpath("./preceding-sibling::td[2]"));  // ./ means the element that we have the list for ,from there we continue ahead.Here it means td where the username is asharma
//                System.out.println("Firstname: " + firstname.getText());
//            }
//        }
//
//    }
//}
