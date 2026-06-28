package vishwajeetLoni.Assignments;

//Using Selenium WebDriver in Java, automate the following steps:
//
//Launch the website http://automationbykrishna.com/.
//Navigate to the "Demo Tables" section by clicking on the corresponding tab.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Traverse through the table data and identify the row where the "First Name" column value is "Priya".
//Retrieve the corresponding value from the "Username" column in the same row.
//Print the extracted Username value in the Console.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.util.List;

public class Assignment15_TablesFindUsername {

    @Test
    public void TableFindUsername() {
        System.out.println("Step - Launch browser and select demotables");
        WebDriver driver;
        driver = ActionOnBrowser.start();

        driver.findElement(By.id("demotable")).click();

        System.out.println("Step 2 - Find Employee Basic Info table and Print the data in it");
        String Tabledata = driver.findElement(By.xpath("//div[@id='empbasic']")).getText();  // print the text in table
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


        System.out.println("Step 3 - Find Priya in First name");

        List<WebElement> empTableFirstname = driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr/td[2]"));
        for (WebElement firstname : empTableFirstname) {
            if (firstname.getText().equals("Priya")) { // had to get text since the loop is of webelements and cannot directly
                System.out.println("Found Priya, now get the username:");
                WebElement username = firstname.findElement(By.xpath("./following-sibling::td[2]"));
                System.out.println("Username: " + username.getText());
            }
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
//        System.out.println("Step 2 - Find Employee Basic Info table and Print the data in it");
//        String Tabledata = driver.findElement(By.xpath("//div[@id='empbasic']")).getText();  // print the text in table
//        System.out.println(Tabledata);
//
////      For when we can use for loop based on rows for the table
////        String getUserName(String firstName){
////            int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
////            for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){
////                String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
////                if(fName.equals(firstName))
////                    return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
////            }
////            return null;
////        }
//
//
//        System.out.println("Step 3 - Find Priya in First name");
//
//        List<WebElement> empTableFirstname = driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr/td[2]"));
//        for (WebElement firstname : empTableFirstname) {
//            if (firstname.getText().equals("Priya")) { // had to get text since the loop is of webelements and cannot directly
//                System.out.println("Found Priya, now get the username:");
//                WebElement username = firstname.findElement(By.xpath("./following-sibling::td[2]"));
//                System.out.println("Username: " + username.getText());
//            }
//        }
//
//    }
//}
