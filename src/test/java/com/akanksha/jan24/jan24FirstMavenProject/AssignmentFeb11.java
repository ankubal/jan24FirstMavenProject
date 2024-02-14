package com.akanksha.jan24.jan24FirstMavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AssignmentFeb11 {
	WebDriver driver = null;
	WebDriverWait wait = null;
	Actions actions=null;
	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		WebDriverManager.chromedriver().setup();

		// To launch the browser instancE

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 15);
		
		actions =new Actions(driver);
		
		driver.manage().window().maximize();
	}
	@Test
	public void addToCart() {
		
		WebElement email = driver.findElement(By.xpath("//input[@id ='input-email']"));
		WebElement password = driver.findElement(By.xpath("//input[@id ='input-password']"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		email.sendKeys("akanksha@gmail.com");
		password.sendKeys("akanksha");
		loginBtn.submit();
		
		WebElement desktops =driver.findElement(By.xpath("//a [text()= 'Desktops'][@class='dropdown-toggle']"));
		actions.moveToElement(desktops).perform();
		WebElement alldesktops =driver.findElement(By.xpath("//a [text()= 'Show All Desktops']"));
		alldesktops.click();
//		WebElement addtoCart =driver.findElement(By.cssSelector("div.product-layout:nth-of-type(1)"));
//		addtoCart.click();
		
		//product  add to cart
		List<WebElement> products= driver.findElements(By.cssSelector(".product-thumb"));
		WebElement prod= products.stream().filter(product-> 
		
		product.findElement(By.cssSelector("div.caption>h4>a")).getText().equals("MacBook")).findFirst().orElse(null);
		prod.findElement(By.cssSelector("div.button-group >button:nth-of-type(1)")).click();
		
		
		
		WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-total")));
		cartBtn.click();
//		WebElement viewcartBtn =driver.findElement(By.cssSelector("#cart-total"));
//		viewcartBtn.click();
		WebElement viewcartBtn =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart>ul>li>div>p>a:first-of-type")));
		viewcartBtn.click();
		WebElement checktoutBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Checkout']")));
		checktoutBtn.click();
		
		//billing details
		WebElement newAddressBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='radio'][name='payment_address'][value='new']")));
		newAddressBtn.click();
		WebElement firstname = driver.findElement(By.xpath("//input[@id='input-payment-firstname']"));
		WebElement lastname= driver.findElement(By.xpath("//input[@id='input-payment-lastname']"));
		WebElement company = driver.findElement(By.xpath("//input[@id='input-payment-company']"));
		WebElement address1 = driver.findElement(By.xpath("//input[@id='input-payment-address-1']"));
		WebElement address2= driver.findElement(By.xpath("//input[@id='input-payment-address-2']"));
		WebElement city = driver.findElement(By.xpath("//input[@id='input-payment-city']"));
		
		WebElement postCode = driver.findElement(By.xpath("//input[@id='input-payment-postcode']"));

		firstname.sendKeys("akanksha");
		lastname.sendKeys("bal");
		//company.sendKeys("concrete-buddies");
		address1.sendKeys("33 kirk drive");
		//address2.sendKeys("33 kirk drive");
		city.sendKeys("brampton");
		postCode.sendKeys("L6X4E6");
		WebElement country = driver.findElement(By.id("input-payment-country"));
		Select select = new Select(country);
		select.selectByVisibleText("Canada");
		
		WebElement region = driver.findElement(By.id("input-payment-zone"));
region.click();
		Select Region = new Select(region);
		Region.selectByValue("610");
		WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueBtn.click();
		WebElement addComments = driver.findElement(By.xpath("//textarea[@name='comment']"));
		addComments.sendKeys("abcdefghi");
		WebElement paymentCheckbox = driver.findElement(By.cssSelector(" input[type='checkbox']"));
		
		paymentCheckbox.click();
		WebElement paymentConfirmBtn = driver.findElement(By.id("button-payment-method"));
		paymentConfirmBtn.click();
		
		WebElement headerElement = driver.findElement(By.tagName("h1"));
		String actualHeaderText = headerElement.getText();

		String expectedHeaderText = "Your order has been placed!";

		Assert.assertEquals(actualHeaderText, expectedHeaderText, "Header text doesn't match");

		if (actualHeaderText.equals(expectedHeaderText)) {
			WebElement continueButton = driver.findElement(By.cssSelector(".pull-right a.btn-primary"));
			continueButton.click();
		}

	}
	
	}

