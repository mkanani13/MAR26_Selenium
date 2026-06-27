package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment14 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("demotable")).click();
        Thread.sleep(1000);

        int columnCount = driver.findElements(By.xpath("//table[@id='table1']//tr[1]//th")).size();
        int rowsCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();

        System.out.println("--------Print Headers-----------");
        for(int i=1; i<=columnCount; i++){
            String formedxpath = "//table[@id='table1']//tr[1]//th["+i+"]";
            System.out.print(driver.findElement(By.xpath(formedxpath)).getText()+"  ");
        }
        System.out.println();
        System.out.println("--------Print Rows-----------");
        for(int i=1; i<=rowsCount; i++){
            for(int j=1; j<=columnCount; j++){
                String xpath = "//table[@id='table1']//tbody/tr["+i+"]/td["+j+"]";
                System.out.print(driver.findElement(By.xpath(xpath)).getText()+"  ");
            }
            System.out.println();
        }

        driver.quit();
    }
}
