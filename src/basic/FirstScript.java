package basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP - Launch browser and load url");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationbykrishna.com");
		
		System.out.println("STEP - Click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		Thread.sleep(1000);
		
		System.out.println("STEP - Enter username");
		WebElement usernameInputElement = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		usernameInputElement.sendKeys("mkanani");
		
		System.out.println("STEP - Enter password");
		WebElement passwordInputElement = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		passwordInputElement.sendKeys("mkanani@123");
		
		WebElement loginBtnElement = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		loginBtnElement.click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		if(actualAlertText.equals("Success!")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		alert.accept();
		
		System.out.println("STEP - clear password");
		passwordInputElement.clear();
		passwordInputElement.sendKeys("mmk@123");
		loginBtnElement.click();
		
		String text = alert.getText();
		System.out.println("****" + text);
		alert.accept();
		
//		alert = driver.switchTo().alert();
//		if(actualAlertText.contains("Failed")) {
//			System.out.println("Pass");
//		}else {
//			System.out.println("Fail");
//		}
//		alert.accept();
	
		System.out.println("Script end");
	}
}
