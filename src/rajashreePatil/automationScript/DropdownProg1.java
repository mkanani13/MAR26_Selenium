package rajashreePatil.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownProg1 {
    public void dropdownUsingSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.linkText("Basic Elements")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Step: Print all options of the first dropdown");

        WebElement ddElement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[1]"));
        Select oselect = new Select(ddElement);
        oselect.selectByIndex(1);

        //System.out.println(oselect.getOptions().size());
        List<WebElement> listOfOptions = oselect.getOptions();
        System.out.println("Total options are: " +listOfOptions.size());
        for(WebElement e : listOfOptions){
            System.out.println(e.getText());
        }

        driver.quit();

    }
    @Test
    public void verify() throws InterruptedException {
        DropdownProg1 dd = new DropdownProg1();
        dd.dropdownUsingSelect();
    }
}
