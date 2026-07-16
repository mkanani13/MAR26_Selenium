package jayeshSonawane.testNg.testScriptsAssignmentsTestNg;

import jayeshSonawane.base.BrowserActions;
import jayeshSonawane.testNg.pages.BasicElements;
import jayeshSonawane.testNg.pages.Registration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*

convert all selenium assignments with main() to
1. testNg
2. with annotations
3. with proper assertions
4. combine all assignments(1 to 16) into 1
 */
public class AssignmentTestNgTCs {
    Registration registration = new Registration();
    BasicElements basicElements = new BasicElements();

    @BeforeMethod
    void setUp() {
        BrowserActions.start();
    }

    @Test
    void tcAssignment1() {
        registration.login("Jayesh", "Jayesh1234");
    }

    @Test(priority = 1)
    void tcAssignment2(){
        registration.login("Jayesh", "Jayesh1"); // enter password less than 8 characters
    }

    @Test(priority = 2)
    void tcAssignment3(){
        basicElements.alertDemo("Jayesh", "Sonawane", "abcd");
    }

    @Test(priority = 3)
    void tcAssignment4_5(){
        basicElements.alertJavascriptConfirmation();
    }

    @Test(priority = 4)
    void tcAssignment6(){
        basicElements.alertJavascriptPrompt();
    }

    @Test(priority = 5)
    void tcAssignment7(){

    }

    @AfterMethod
    void quitBrowser(){
        BrowserActions.close();
    }
}