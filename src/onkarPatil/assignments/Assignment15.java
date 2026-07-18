package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment15 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("demotable")).click();
        Thread.sleep(1000);

        int rowsCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
        int targetRow = 0;
        for(int i=1; i<=rowsCount; i++){
            String xpath = "//table[@id='table1']//tbody/tr["+i+"]/td[2]";
            String name = driver.findElement(By.xpath(xpath)).getText();
            if(name.equals("Priya")){
                targetRow = i;
            }
        }
        String targetxpath = "//table[@id='table1']//tbody/tr["+targetRow+"]/td[4]";
        String targetUsername = driver.findElement(By.xpath(targetxpath)).getText();
        System.out.println(targetUsername);

        driver.quit();
    }
}
