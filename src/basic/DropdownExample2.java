package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample2 {

	WebElement getFirstSelectedOption(Select oselect) {
		List<WebElement> listOfOption = oselect.getOptions();
		for (WebElement option : listOfOption) {
			if (option.isSelected()) {
				return option;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("STEP - Launch browser & hit url");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("STEP - Navigate to Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();

		System.out.println("STEP - print all the options of the first dropdown");
		WebElement numberSelectElement = driver
				.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[2]"));
		Select numberSelect = new Select(numberSelectElement);

		List<WebElement> listOfOptions = numberSelect.getOptions();
		numberSelect.selectByIndex(listOfOptions.size() - 1);
		numberSelect.selectByVisibleText("2");

		WebElement selectedOptionElement = numberSelect.getFirstSelectedOption();
		System.out.println("Selected option is : " + selectedOptionElement.getText());
		System.out.println(numberSelect.isMultiple());

		List<WebElement> listOfAllSelectedOptions = numberSelect.getAllSelectedOptions();
		System.out.println("All selected option size : " + listOfAllSelectedOptions.size());
		for (WebElement e : listOfAllSelectedOptions) {
			System.out.println(e.getText());
		}

		numberSelect.deselectByVisibleText("5");
		
		System.out.println("===============================");
		listOfAllSelectedOptions = numberSelect.getAllSelectedOptions();
		System.out.println("All selected option size : " + listOfAllSelectedOptions.size());
		for (WebElement e : listOfAllSelectedOptions) {
			System.out.println(e.getText());
		}
		
		numberSelect.deselectAll();
		listOfAllSelectedOptions = numberSelect.getAllSelectedOptions();
		System.out.println("All selected option size : " + listOfAllSelectedOptions.size());
		for (WebElement e : listOfAllSelectedOptions) {
			System.out.println(e.getText());
		}
		
		WebElement e1 = numberSelect.getFirstSelectedOption();
		System.out.println(e1.getText());
		System.out.println("End");
		//driver.quit();
	}
}
