package com.sat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;

//import junit.framework.Assert;

public class PowerAppsAutomateFlowPage {
	private WebDriver driver;
	Testutil testutil = new Testutil();
	private ConfigFileReader config = new ConfigFileReader();

	@FindBy(xpath = "//*[@name='loginfmt']")
	private WebElement UserName;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement NextButton;

	@FindBy(xpath = "//*[@type='password']")
	private WebElement Password;

	@FindBy(xpath = "//*[@id='idSIButton9']") // *[@type='submit']
	private WebElement Signin;

	@FindBy(xpath = "//*[@name='DontShowAgain']")
	private WebElement DontShowAgain;

	@FindBy(xpath = "//*[@id='idSIButton9']")
	private WebElement Yes;

	@FindBy(xpath = "//*[@aria-label='Search' and contains(@id,'SearchBox')]")
	private WebElement Search;

	@FindBy(xpath = "//a[text()='Create_Seller_ItemsCount']")
	private WebElement CreateSellerItemsCount;

	@FindBy(xpath = "//button[@data-automation-id='flowCommand-run']")
	private WebElement Run;
	// button[@data-automation-id='flowCommand-run']
	// span[text()='Run']/parent::span

	@FindBy(xpath = "//span[text()='Run flow']")
	private WebElement Runflowbutton;

	@FindBy(xpath = "//span[text()='Done']")
	private WebElement Done;

	@FindBy(xpath = "(//div[@role='rowheader']//span//span[@class='fl-StartTime-ago'])[1]")
	private WebElement execTime;

	@FindBy(xpath = "//*[@data-icon-name='Refresh']")
	private WebElement refresh;

	@FindBy(xpath = "(//div[@data-automation-key='status'])[1]")
	private WebElement successmessage;
	// (//*[text()='Succeeded'])[1]

	@FindBy(xpath = "//*[contains(@class,'fl-StatusInCell root')]//*[text()='Running']")
	private WebElement running;

	// *[contains(@class,'fl-StatusInCell root')]//*[text()='Running']

	public PowerAppsAutomateFlowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginPowerApp() {
		// TestBase.getDriver().get(config.getPowerAppCloudFlow());
		UserName.sendKeys(config.AdminUserName());
		NextButton.click();
		Wait.elementToBeClickable(driver, Password, 5);
		Password.sendKeys(config.AdminUserPassword());
		Wait.elementToBeClickable(driver, Signin, 5);
		Wait.untilPageLoadComplete(driver, 5);
		Signin.click();
		// Wait.waitUntilElementVisible(driver, DontShowAgain);
		// DontShowAgain.click();
		// Yes.click();
	}

	public void runCloudFlow(String flowName) {
		/*
		 * UserName.sendKeys(config.resaleAdminAppUserId()); NextButton.click();
		 * Wait.elementToBeClickable(driver, Password, 5);
		 * Password.sendKeys(config.resaleAdminAppPassword());
		 * Wait.elementToBeClickable(driver, Signin, 5);
		 * Wait.untilPageLoadComplete(driver, 5); Signin.click();
		 * Wait.waitUntilElementVisible(driver, DontShowAgain); DontShowAgain.click();
		 * Yes.click();
		 */
		System.out.println("power app logged in");
		Wait.untilPageLoadComplete(driver);
		Wait.elementToBeClickable(driver, Search, 5);
		Wait.elementToBeClickable(driver, Search, 5);
		try {
			Thread.sleep(5000);
			Search.click();
			Search.sendKeys(flowName, Keys.ENTER);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Search.click();
			Search.sendKeys(flowName, Keys.ENTER);
		}
		/*WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(Search)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Search")));*/
		WebElement we = driver.findElement(By.xpath("//*[text()='" + flowName + "']"));
		we.click();
		Wait.untilPageLoadComplete(driver, 10);
		// testutil.actionClassClick(driver, Run);
		driver.switchTo().frame("widgetIFrame");
		Run.click();
		Runflowbutton.click();
		Done.click();
		Wait.untilPageLoadComplete(driver);
		Wait.elementToBeClickable(driver, refresh, 5);
		refresh.click();
		System.out.println("clicked on refresh");
		Wait.elementToBeClickable(driver, execTime, 5);
		String time = execTime.getText();
		System.out.println(time + "hms");
		boolean condition = true;
		while (condition) {
			if (time.contains("sec")) {
				// String runningmsg = running.getText();
				String successmsg = successmessage.getText();
				if (successmsg.equalsIgnoreCase("Succeeded")) {
					System.out.println(successmsg);
					// Assert.assertTrue("flow run got
					// failed",successmsg.equalsIgnoreCase("Succeeded"));
					Assert.assertEquals("Succeeded", successmsg);
					condition = false;
				} else {
					refresh.click();
				}

			} else {
				System.out.println("Flow Execution Failed");
				condition = false;
			}
		}
	}

}