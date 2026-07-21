package riteshMali;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment17 {
WebDriver driver = new ChromeDriver();
    @BeforeClass
    void startup() {
        driver.get("http://34.173.201.53/access#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void verifyRestorantSystem(){


    }

}
