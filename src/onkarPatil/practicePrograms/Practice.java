package onkarPatil.practicePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Practice {

    static WebDriver driver;

    @Test
    public void m1(){
        System.out.println("testNG Testing");
    }


    public static void main(String[] args){
        driver = new ChromeDriver();
        driver.get("http://34.173.201.53/access#/login");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        driver.findElement(By.xpath("//input[@id=\"access-student-id\"]")).sendKeys("TS5FU2Z2ND");
        driver.findElement(By.xpath("//input[@id=\"access-code\"]")).sendKeys("P4VY95MB");
        driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();

        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("patilonkar18@gmail.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Devansh@1");
        driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();

        List<WebElement> al = driver.findElements(By.xpath("//p[@class='text-xs text-slate-500']"));
        Set<String> uniqueLocations = new LinkedHashSet<>();
        for(WebElement e : al){
            String str = e.getText();
            String[] arr = str.split(" . ");
            String location = arr[0];
            uniqueLocations.add(location);
        }
        System.out.println("Unique locations are" + uniqueLocations);

        int size = driver.findElements(By.xpath("//select[@data-testid=\"locality-dropdown\"]/option")).size() - 1;
        Set<String> locationsInDropdown = new HashSet<>();

        for(int i=2; i<=size; i++){
            String locator = "//select[@data-testid=\"locality-dropdown\"]/option["+i+"]";
            String location = driver.findElement(By.xpath(locator)).getText();
            locationsInDropdown.add(location);
        }

        System.out.println("All available locations in dropdown : "+locationsInDropdown);

        Set<String> duplicateCopy = new LinkedHashSet<>(locationsInDropdown);

        duplicateCopy.removeAll(uniqueLocations);

        System.out.println("No restaurants available for these locations : " + duplicateCopy);

        driver.quit();
    }
}
