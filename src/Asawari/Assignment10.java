package Asawari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment10 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement ddElement = driver.findElement(By.xpath("//form[@class=\"form-horizontal adminex-form\"]/div[3]/div/select[1]"));
        Select oselect = new Select(ddElement);
        oselect.selectByVisibleText("4");

        System.out.println("Total Options are "+ oselect.getOptions().size());

         //Option 1>>
        List<WebElement> listOfOptions = oselect.getOptions();
        for(WebElement e :listOfOptions){
            System.out.println(e.getText());
        }
       //}

        //Option 2>>
        //List<WebElement> listOfOption = oselect.getAllSelectedOptions();
        //System.out.println(listOfOption.get(0).getText());

        //Option 3
        //WebElement selectedOptionElement = oselect.getFirstSelectedOption();
        //System.out.println("Selected Option is " + selectedOptionElement.getText());
    }
}
