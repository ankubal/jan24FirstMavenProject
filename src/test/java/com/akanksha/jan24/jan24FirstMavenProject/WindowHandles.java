package com.akanksha.jan24.jan24FirstMavenProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandles {

	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver", "C:\\edgewebdriver\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/browser-windows");

		// driver.manage().window().maximize();
	}

	@Test
	public void openNewTab() {
		WebElement tabBtn = driver.findElement(By.id("tabButton"));
		tabBtn.click();
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);

		

		Set<String> Handles = (Set<String>) driver.getWindowHandles();
		
		
		for (String secondhandle : Handles) {
			if(!secondhandle.equals(parentHandle)) {
				driver.switchTo().window(secondhandle);
				break;
			}
		}
	driver.getWindowHandle();
	driver.switchTo().window(parentHandle);
		WebElement windowBtn2 = driver.findElement(By.xpath("//button [text()='New Window']"));
		windowBtn2.click();
		String thirdHandle = driver.getWindowHandle();
		System.out.println(thirdHandle);
		Set<String> allhandles = (Set<String>) driver.getWindowHandles();
		for(String handleAll : Handles) {
			if(!allhandles.equals(Handles)) {
				driver.switchTo().window(thirdHandle);		
				break;
				
			}
		}
		driver.getWindowHandle();
		System.out.println(thirdHandle);
//		WebElement headingtext1 = driver.findElement(By.id("sampleHeading"));
//		System.out.println(headingtext1.getText());
		driver.switchTo().window(parentHandle);
	}

//	@Test
//		public void checkallTab()
//		{
//		driver.findElement(By.xpath("//button [@id='tabButton']")).click();
//		driver.findElement(By.xpath("//button [text()='New Window']")).click();
//		
//		
//		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
//		for (int i = 0; i < windows.size(); i++) {
//			driver.switchTo().window(windows.get(i));
//			System.out.println(driver.getWindowHandle());
//		}
//
//		}

		}
	


