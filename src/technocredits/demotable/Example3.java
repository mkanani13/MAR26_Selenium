package technocredits.demotable;

import java.util.LinkedHashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import technocredits.technoapp.base.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example3 {
	WebDriver driver;

	void setUp() {
		driver = BrowserActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	Set<Integer> getDuplicateEmpId() {
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Set<Integer> duplicateEmpSet = new LinkedHashSet<>();
		Set<Integer> empSet = new LinkedHashSet<>();

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowIndex + "]/td[2]"))
					.getText();

			int empIdNum = Integer.parseInt(empId);
			if (!empSet.add(empIdNum)) {
				duplicateEmpSet.add(empIdNum);
			}
		}
		return duplicateEmpSet;
	}
	
	@Test
    public void verifyEmployeeDetails() {
		Example3 ex3 = new Example3();
		ex3.setUp();
		Set<Integer> duplicateEmpSet = ex3.getDuplicateEmpId();
		System.out.println(duplicateEmpSet);
        Assert.assertTrue(duplicateEmpSet.size() == 1);
	}
}
