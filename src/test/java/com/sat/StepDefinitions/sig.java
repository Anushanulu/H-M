package com.sat.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class sig {

		
		WebDriver driver;
		public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<>();

		@FindBy(xpath="//*[@name='loginfmt']")
		private WebElement UserName;

		@FindBy(xpath="//*[@type='submit']")
		private WebElement NextButton;

		@FindBy(xpath="//*[@type='password']")
		private WebElement Password;

		@FindBy(xpath="//*[@id='idSIButton9']")
		private WebElement Signin;

		@FindBy(xpath="//*[@name='DontShowAgain']")
		private WebElement DontShowAgain;

		@FindBy(xpath="//*[@id='idSIButton9']")
		private WebElement Yes;

		@Test
		public void clickEmail() throws InterruptedException {
		//GmailPageObjects Emaildemo = new GmailPageObjects(TestBase.getDriver());
		//String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hcladmin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.get("https://mail.google.com");
		// GmailPageObjects gp =PageFactory.initElements(driver, GmailPageObjects.class);
		// gp.enterEmail("shwethapinky358@gmail.com");//Replace with your email id
		// gp.enterPassword("$wetha@1494");//Replace with your password
		// gp.clickEmail("Job | Urgent Opening for Data Engineer ( python, SQL & ETL tools mandatory ) Long term contract with Product based organization Location - Bengaluru");//Replace with email subject you want to click
		//

		driver.get("https://www.signwell.com/online-signature/draw/");
		WebElement element = driver.findElement(By.xpath("//canvas[@id='canvas_signature']"));
		
		/*driver.get("https://apps.powerapps.com/play/28f9089b-9235-4ecd-86d7-8b082d98dc8f?tenantId=86c0fbbd-1856-4798-8525-b74a8f55b824");
		Thread.sleep(1000);
		UserName.sendKeys("powerappstest@storelens.com");
		NextButton.click();
		Thread.sleep(1000);
		Password.sendKeys("FibbelKungen2002#");
		Signin.click();
		Thread.sleep(1000);
		DontShowAgain.click();
		Yes.click();
		*/


		Actions builder = new Actions(driver);
		//builder.dragAndDropBy(element, xOffset:135, yOffset:0).build().perform();
		builder.dragAndDropBy(element, 135, 0).build().perform();
		}






		
	}
		
		
		
		
		



