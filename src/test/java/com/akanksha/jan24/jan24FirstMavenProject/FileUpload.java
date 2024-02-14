package com.akanksha.jan24.jan24FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Owner\\Downloads\\edgedriver_win64 (4)\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/upload-download");
	}
	
	
	@Test
	public void sendKeysToInputField() {

		WebElement fileUpload = driver.findElement(By.id("uploadFile"));
	
		fileUpload.sendKeys("C:\\Users\\Owner\\Downloads\\Locators.pptx");
	}

}
