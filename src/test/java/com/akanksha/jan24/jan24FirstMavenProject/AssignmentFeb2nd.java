package com.akanksha.jan24.jan24FirstMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentFeb2nd {
	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver", "C:\\edgewebdriver\\msedgedriver.exe"); 

		// Launch the browser instance
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

	}

	@Test
	public void register() {
		WebElement firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstname.sendKeys("akanksha");

		WebElement lastname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lastname.sendKeys("bal");
		WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
		email.sendKeys("akanksha007@gmail.com");

		WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		telephone.sendKeys("6478892155");
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.sendKeys("akanksha");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		confirmpassword.sendKeys("akanksha");
		WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		checkbox.click();
		WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueBtn.submit();

	}

	@Test
	public void login() {
		// driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement email = driver.findElement(By.xpath("//input[@id ='input-email']"));
		WebElement password = driver.findElement(By.xpath("//input[@id ='input-password']"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		email.sendKeys("akanksha@gmail.com");
		password.sendKeys("akanksha");
		loginBtn.submit();

	}

	@Test
	public void clckContactUS() {
		WebElement clickContact = driver
				.findElement(By.xpath("//a[(text()= 'Contact Us')]"));
		clickContact.click();

//		WebElement clickContact = driver.findElement(By.linkText("Contact Us"));
//		clickContact.click();
		WebElement yourname = driver.findElement(By.xpath("//input[@id='input-name']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
		WebElement enquiry = driver.findElement(By.xpath("//textarea[@id='input-enquiry']"));
		WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		yourname.sendKeys("akanksha");
		email.sendKeys("akanksha@gmail.com");
		enquiry.sendKeys("abc abc abc abc abc abc abc abc abc");
		submitBtn.submit();

	}

	@Test
	public void findgiftCertificate() {

		WebElement findgiftCertificate = driver.findElement(By.linkText("Gift Certificates"));
		
		WebElement recepientname = driver.findElement(By.xpath("//input[@id='input-to-name']"));
		WebElement recepientemail = driver.findElement(By.xpath("//input[@id='input-to-email']"));
		WebElement yourname = driver.findElement(By.xpath("//input[@id='input-from-name']"));
		WebElement youremail = driver.findElement(By.xpath("//input[@id='input-from-email']"));
		WebElement birthday = driver.findElement(By.cssSelector("#content form>div:nth-of-type(5)>div>div:nth-of-type(1)>label>input"));
	    WebElement message = driver.findElement(By.xpath("//textarea[@id='input-message']"));
		WebElement amount = driver.findElement(By.xpath("//input[@id='input-amount']"));
		WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		WebElement continueBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		findgiftCertificate.click();
		recepientname.sendKeys("akanksha");
		recepientemail.sendKeys("akanksha@gmail.com");
		yourname.sendKeys("akanksha");
		youremail.sendKeys("akanksha@gmail.com");
		birthday.click();
		message.sendKeys("abc abc abc abac abx ABACC ABDCVJ");
		amount.sendKeys("1000");
		checkbox.click();
		continueBtn.submit();
	}

	@Test
	public void returnsLink() {

		WebElement returnsLink = driver.findElement(By.linkText("Returns"));
		//returnsLink.click();
		WebElement firstname = driver.findElement(By.linkText("//input[@id='input-firstname']"));
	    WebElement lastname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
		WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		WebElement orderid = driver.findElement(By.xpath("//input[@id='input-order-id']"));
		WebElement date = driver.findElement(By.className("fa fa-calendar"));
		date.click();
		//String monthYearVal = driver.findElement(By.className(null))
		
		WebElement productName = driver.findElement(By.xpath("//input[@id='input-product']"));
		WebElement productCode = driver.findElement(By.xpath("//input[@id='input-model']"));
		WebElement quantity = driver.findElement(By.xpath("//input[@id='input-quantity']"));
		WebElement reasonforreturn = driver.findElement(By.cssSelector("input[value='2']"));
		WebElement productopenrdbtn = driver.findElement(By.cssSelector("input[value='0']"));
		firstname.sendKeys("akanksha");
		lastname.sendKeys("bal");
		email.sendKeys("akanksha@gmail.com");
		telephone.sendKeys("akanksha");
		orderid.sendKeys("akanksha");
		productName.sendKeys("akanksha");
		productCode.sendKeys("a127");
		quantity.sendKeys("10lbs");
		reasonforreturn.click();
		productopenrdbtn.click();
	}

	public void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
