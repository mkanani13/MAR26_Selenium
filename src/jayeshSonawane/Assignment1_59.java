package seleniumAssignments;

/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Registration” tab/button.
Enter valid values in:-
→ User Name field
→ Password field (must contain at least 8 characters)

Click on the Submit button (Green Tick icon) to complete registration.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_59 {

    public static void main(String[] args) {

        // Open browser
        WebDriver driver = new ChromeDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Load the specified URL
        driver.get("http://automationbykrishna.com/");

        // TC 1 = Verify no re-direction
        System.out.println("Executing TC1");
        String title = driver.getTitle();

        if(title.equals("Login Signup Demo")){
            System.out.println("TC1 Passed");
        }else{
            System.out.println("TC1 Failed");
        }

        // TC 2 = Verify no re-direction
        System.out.println("Executing TC2");
        String currentURL = driver.getCurrentUrl();

        if(currentURL.equals("http://automationbykrishna.com/")){
            System.out.println("TC2 Passed");
        }else{
            System.out.println("TC2 Failed");
        }

        // TC 3 = Click on the “Registration” tab/button.
        // Element 1 = Registration Button
        // Find element uniquely using locators and perform action
        System.out.println("Executing TC3");
        driver.findElement(By.id("registration2")).click();
        System.out.println("TC3 Passed");

        // TC 4 = Enter User Name
        // Element 2 = UserName TextBox
        // Find element uniquely using locators and perform action
        try {
            Thread.sleep(5000); // wait for 5 seconds to load element
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executing TC4");
        System.out.println("STEP - Enter User Name");
        driver.findElement(By.id("unameSignin")).sendKeys("Jayesh");
        System.out.println("TC4 Passed");

        // TC 5 = Enter Password
        // Element 3 = Password TextBox
        // Find element uniquely using locators and perform action
        System.out.println("Executing TC5");
        System.out.println("STEP - Enter Password");
        driver.findElement(By.id("pwdSignin")).sendKeys("jayesh1234");
        System.out.println("TC5 Passed");

        // TC 6 Click on the Submit button (Green Tick icon) to complete registration.
        // Element 4 = Submit button (Green Tick icon)
        // Find element uniquely using locators and perform action
        System.out.println("Executing TC6");
        System.out.println("STEP - Click on Submit button");
        driver.findElement(By.id("btnsubmitdetails")).click();
        System.out.println("TC6 Passed");
    }
}
