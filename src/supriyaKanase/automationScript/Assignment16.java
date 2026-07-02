package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assignment16 {
    WebDriver driver;
    void setUp(){
        System.out.println("STEP - Launch Browser and Hit Url");
        driver = BrowserAction.start("http://automationbykrishna.com/");
    }

    String getFirstName(String userName){
        System.out.println("STEP - Click on demo tables tab");
        driver.findElement(By.id("demotable")).click();

        System.out.println("STEP - Find Total Rows Present In Table");
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

        System.out.println("iterate throgh all username,compare with provided User Name and provide its First Name");
        for(int rowIndex = 1; rowIndex <= totalRows;rowIndex++){
            String uName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
            if(uName.equals(userName)){
                return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
            }
        }
        return null;
    }

    String getLastName(String userName){
        System.out.println("STEP - Click on demo tables tab");
        driver.findElement(By.id("demotable")).click();
        return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[4][text()='"+userName+"']/preceding-sibling::td[1]")).getText();
    }

//    List<String> getEmpNames(String empDept){
//        List<WebElement> empListWebelements= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5][text()='"+empDept+"']/preceding-sibling::td[2]"));
//         List<String> listOfEmployee = new ArrayList<String>();
//         for(WebElement e:empListWebelements){
//             listOfEmployee.add(e.getText());
//         }
//        return listOfEmployee;
//    }

    @Test
    public  void getFirstAndLastName() {
        Assignment16 ass16 = new Assignment16();
         ass16.setUp();
         String fname = ass16.getFirstName("asharma");
         String lname = ass16.getLastName("asharma");

        System.out.println("First Name : "+fname);
        System.out.println("Lirst Name : "+lname);

//        List<String> listOfEmpName = ass16.getEmpNames("7003-HR");
//        System.out.println(listOfEmpName);
    }
}
