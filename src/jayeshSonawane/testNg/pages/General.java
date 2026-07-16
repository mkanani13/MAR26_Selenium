package jayeshSonawane.testNg.pages;

import jayeshSonawane.base.BrowserActions;
import org.testng.Assert;

public class General extends BrowserActions {
    public void verifyTitle(){
        System.out.println("STEP - Get Page Title and Verify");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Login Signup Demo", "STEP - Get Page Title and Verify");
    }

    public void verifyRedirection(){
        System.out.println("STEP - Get Current URL to Verify Redirection");
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"http://automationbykrishna.com/", "STEP - Get Current URL to Verify Redirection");
    }
}
