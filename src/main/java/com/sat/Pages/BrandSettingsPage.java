package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class BrandSettingsPage {
	private WebDriver driver;

	Testutil testutil = new Testutil();
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());

	@FindBy(xpath = "//div[text()='Settings']") // div[text()='Settings']
	private WebElement Settings;

	@FindBy(xpath = "//*[text()='Brand Settings']")
	private WebElement brandSettings;

	@FindBy(xpath = "//*[@class='selectedItem_7e8qnb']")
	private WebElement selectBrand;

	@FindBy(xpath = "//button[contains(@class,'buttonReset')]")
	private WebElement Cancleicon;

	@FindBy(xpath = "//*[text()='ADD SERVICE']")
	private WebElement addService;

	@FindBy(xpath = "//*[@class='appmagic-toggleSwitch-label left']")
	private WebElement EnableorDisable;

	@FindBy(xpath = "//*[@appmagic-control='txtAddServiceDisplayNameBSStextbox']")
	private WebElement displayName;

	@FindBy(xpath = "//*[@class='appmagic-toggleSwitch-off']")
	private WebElement toggleButton;
	
	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;

	@FindBy(xpath = "//*[text()='ADD']")
	private WebElement addbtn;

	@FindBy(xpath = "//*[@appmagic-control='txtAddServiceAPINameBSStextbox']")
	private WebElement apiName;

	@FindBy(xpath = "//*[text()='OK']")
	private WebElement okbtn;

	@FindBy(xpath = "//*[text()='Service added successfully']")
	private List<WebElement> ServicaddeddMSG;
	
	@FindBy(xpath = "//*[text()='Service updated successfully']")
	private List<WebElement> serviceUpdatedsucmsg1;

	@FindBy(xpath = "//*[contains(@data-control-name,'icnSelectAllOptionsCSS')]")
	private WebElement moreoption;

	@FindBy(xpath = "//*[contains(@appmagic-control,'txtEnableMultiServiceDefault')][contains(@appmagic-control,'textbox')]")
	private WebElement defaultVisitor;

	@FindBy(xpath = "//div[text()='ADD TIME PERIOD']")
	private WebElement addTimePeriod;

	@FindBy(xpath = "//div[@data-control-name='dpEditFromDateBSS' or @data-control-name='dpFromDateCSS' or @data-control-name='dpExportFromDateSSS']/div/div/div/div/div/div")
	private WebElement fromDate;

	@FindBy(xpath = "//div[@data-control-name='dpEditToDateBSS' or @data-control-name='dpToDateCSS' or @data-control-name='dpExportToDateSSS']/div/div/div/div/div/div")
	private WebElement toDate;

	@FindBy(xpath = "//*[@class='appmagic-datepicker-ok-button' and text()='Ok']")
	private WebElement fromDateOk;

	@FindBy(xpath = "(//*[@class='appmagic-datepicker-ok-button' and text()='Ok'])[2]")
	private WebElement toDateOk;

	@FindBy(xpath = "//*[text()='APPLY']")
	private WebElement Applybtn;

	@FindBy(xpath = "//*[text()='Are you sure you want to update service?']")
	private List<WebElement> areYouSureYouWantToUpdateService;

	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> successMsgContainer;

	@FindBy(xpath = "//*[@id='toast-container']")
	private WebElement successMsgContainer1;

	@FindBy(xpath = "//*[text()='Services updated successfully']")
	private List<WebElement> serviceUpdatedsucmsg;

	@FindBy(xpath = "//*[contains(text(),'Enable selected')][contains(text(),'services')]")
	private WebElement enablepopupwindow;

	@FindBy(xpath = "//*[contains(text(),'Disable selected')][contains(text(),'services')]")
	private WebElement disablepopupwindow;

	@FindBy(xpath = "//*[@class='pika-select pika-select-year']")
	private WebElement calendarYear;

	

	@FindBy(xpath = "//*[text()='Remove']")
	private WebElement remove;

	@FindBy(xpath = "//*[text()='Time period']")
	private WebElement timePeriod;

	@FindBy(xpath = "//*[@class='pika-select pika-select-year']")
	private WebElement selectFromYear;

	@FindBy(xpath = "(//*[@class='pika-select pika-select-year'])[2]")
	private WebElement selectToYear;

	@FindBy(xpath = "//*[@class='pika-select pika-select-month']")
	private WebElement selectFromMonth;

	@FindBy(xpath = "(//*[@class='pika-select pika-select-month'])[2]")
	private WebElement selectToMonth;


	public BrandSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isClickable(WebElement ele) {
		boolean flag = true;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Element is clickable");
		} catch (Exception e) {
			System.out.println("Element isn't clickable");
			flag = false;
		}
		return flag;
	}

	public void selectBrandSettings() {
		// Wait.elementToBeClickable(driver, Settings, 3);
		// testutil.actionMethodClick(driver, Settings);
		// testutil.jsclick(driver, Settings);
		Wait.elementToBeClickable(driver, brandSettings, 3);
		testutil.actionMethodClick(driver, brandSettings);
	}

	public void selectBrand(String NameOfTheBrand) {
		Wait.elementToBeClickable(driver, selectBrand, 3);
		selectBrand.click();
		Wait.elementToBeClickable(driver, Cancleicon, 2);
		Cancleicon.click();
		//WebElement we = driver.findElement(By.xpath("//*[text()='"+NameOfTheBrand+"']"));
		//System.out.println(we);
		//Wait.waitUntilElementVisible(driver, we);
		//Wait.elementToBeClickable(driver, we, 3);
		//testutil.actionMethodClick(driver, we);
		//List<WebElement> ele = driver.findElements(By.xpath("//*[text()='"+NameOfTheBrand+"']"));
		Boolean flag = false;
		while(!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[text()='"+NameOfTheBrand+"']"));

			for(int i=0;i<ele.size();i++)

			{
				if(isClickable(ele.get(i))) {
					ele.get(i).click();
					flag = true;
					i = ele.size();
				}

			}

		}
		System.out.println("clicked on brand " + NameOfTheBrand);
		// testutil.jsclick(driver, we);
		// we.click();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		System.out.println("Selected Brand");
	}

	public void clickOnAddService() {
		Wait.elementToBeClickable(driver, addService, 2);
		addService.click();
	}

	public void selectToggleButton(String togglebtnStatus) {
		String currentStatus = EnableorDisable.getText();
		System.out.println(currentStatus);
		if (currentStatus.equals(togglebtnStatus)) {
			System.out.println(" current toggle button status is " + currentStatus);
		} else {
			System.out.println("current toggle button status is " + currentStatus);
			toggleButton.click();
			System.out.println("required toggle button status is " + togglebtnStatus);

		}
	}

	public void addService(String status, String dispName, String APIName) {
		Wait.elementToBeClickable(driver, addService, 2);
		// addService.click();
		testutil.jsclick(driver, addService);
		// String currentStatus = EnableorDisable.getText();
		// if(currentStatus != status) {
		// System.out.println(" current toggle button status is " + currentStatus);
		// toggleButton.click();
		// System.out.println("required toggle button status is " + status);
		// }
		// else {
		// System.out.println("toggle button status is " + status);
		// }
		if (EnableorDisable.isEnabled()) {
			System.out.println(EnableorDisable.getText());
			displayName.click();
			displayName.sendKeys(dispName);
			apiName.click();
			apiName.sendKeys(APIName);
			// addbtn.click();
			// okbtn.click();
		} else {
			System.out.println(EnableorDisable.getText());
			toggleButton.click();
			displayName.click();
			displayName.sendKeys(dispName);
			apiName.click();
			apiName.sendKeys(APIName);
			// addbtn.click();
			// okbtn.click();
		}
	}

	public void enterDisplayAndApiName(String dispName, String APIName) {
		displayName.click();
		displayName.sendKeys(dispName);
		apiName.click();
		apiName.sendKeys(APIName);

	}

	public void clickAddAndOk() {
		Wait.elementToBeClickable(driver, addbtn, 2);
		//addbtn.click();
		testutil.actionMethodClick(driver, addbtn);
		Wait.elementToBeClickable(driver, okbtn, 2);
		//okbtn.click();
		StoreCalendars.clickOnOk();
	}

	public void verifyServiceAdd(String verifyDispalyName) {
		// Wait.waitUntilElementVisible(driver, ServicaddeddMSG);
		// Wait.elementToBeClickable(driver, ServicaddeddMSG, 10);
		// boolean verifyTitle = ServicaddeddMSG.isDisplayed();
		// assertTrue(verifyTitle);
		//testutil.validatesuccessmsg(driver, ServicaddeddMSG, toasteContainer);
		WebElement we = driver.findElement(By.xpath(
				"//div[@data-control-name='lblServiceBSS']//child::div[contains(text(),'" + verifyDispalyName + "')]"));
		Wait.elementToBeClickable(driver, we, 10);
		boolean verifyTitle = we.isDisplayed();
		assertTrue(verifyTitle);
		System.out.println(verifyDispalyName + "Validated service successfully");
	}

	public void selectServiceCheckBox(String ServiceName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement storeCheckBox = driver.findElement(By.xpath("//*[contains(text(),'"+ServiceName+"')]/ancestor::div[@class='appmagic-content-control-name appmagic-control-view canvasContentDiv _vst_']/following-sibling::div[5]"));
		// Wait.untilPageLoadComplete(driver, 10);
		Wait.elementToBeClickable(driver, storeCheckBox, 2);
		testutil.actionMethodClick(driver, storeCheckBox);
	}

	public void enableOrDisable(String serviceStatus) throws InterruptedException {
		Wait.elementToBeClickable(driver, moreoption, 2);
		moreoption.click();
		Wait.untilPageLoadComplete(this.driver, 10);
		WebElement status = driver.findElement(By.xpath("//*[text()='" + serviceStatus + "']"));
		System.out.println(status);
		Wait.elementToBeClickable(driver, status, 2);
		if (serviceStatus.equalsIgnoreCase("Enable selected")) {
			System.out.println("enable");
			// Enable selected
			status.click();
			Wait.elementToBeClickable(driver, defaultVisitor, 2);
			// defaultVisitor.click();
			testutil.actionMethodClick(driver, defaultVisitor);
			System.out.println("clicked on default visitor");
			defaultVisitor.sendKeys("15");
			//okbtn.click();
			StoreCalendars.clickOnOk();
			System.out.println("clicked on ok");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.invisibilityOf(enablepopupwindow));
			testutil.validatesuccessmsg(driver, serviceUpdatedsucmsg, toasteContainer);
			System.out.println("enabled");
		} else {
			System.out.println("disable");
			// Disable selected
			Wait.untilPageLoadComplete(this.driver, 10);
			status.click();
			//okbtn.click();
			StoreCalendars.clickOnOk();
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.invisibilityOf((WebElement) disablepopupwindow));
			testutil.validatesuccessmsg(driver, serviceUpdatedsucmsg, toasteContainer);
			// boolean flag= true;
			// while(flag){
			// WebElement statusmsg = driver.findElement(By.xpath("//*[text()='Services
			// updated successfully']"));
			// if(statusmsg.) {
			// WebDriverWait wait = new WebDriverWait();
			// }
			// }
			// Thread.sleep(10000);
			// WebDriverWait wait = new WebDriverWait(driver, 120);
			// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Disable
			// selected')][contains(text(),'services')]"))));
			System.out.println("disabled");
		}

	}

	public void selectService(String ServiceName) {
		Actions action = new Actions(driver);
		WebElement serviceName = driver.findElement(By.xpath("//*[contains(text(),'" + ServiceName + "')]"));
		Wait.elementToBeClickable(driver, serviceName, 2);
		// Wait.waitUntilElementVisible(driver, serviceName);
		action.moveToElement(serviceName).click().perform();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		System.out.println("Service Name Selected");

	}

	public void addTimePeriod() {
		addTimePeriod.click();
	}

	public void selectFromDateAndToDate(String fmDate, String fmYear, String fmMonth, String tDate, String tYear,
			String tMonth) {
		System.out.println("click on from date");
		fromDate.click();
		// Select dropYear = new
		// Select(driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-year']")));
		// dropYear.selectByValue(fmYear);
		testutil.actionMethodClick(driver, selectFromYear);
		selectFromYear.sendKeys(fmYear, Keys.ENTER);

		// WebElement ee = driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-month']"));
		// Select dropMonth = new Select(ee);
		// dropMonth.selectByVisibleText(fmMonth);
		testutil.actionMethodClick(driver, selectFromMonth);
		selectFromMonth.sendKeys(fmMonth, Keys.ENTER);

		WebElement we = driver
				.findElement(By.xpath("//*[@class='pika-single is-bound']//td[@data-day='" + fmDate + "']"));
		we.click();
		fromDateOk.click();
		//StoreCalendars.clickOnOk();
		System.out.println("clicked on from date");

		toDate.click();
		// Select dropYear2 = new
		// Select(driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-year']")));
		// dropYear2.selectByValue(tYear);
		/*Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = selectToYear;
			System.out.println(ele.size());
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					Wait.elementToBeClickable(driver, ele.get(i), 5);
					testutil.actionMethodClick(driver, ele.get(i));
					Wait.waitUntilElementVisible(driver, ele.get(i));
					ele.get(i).sendKeys(tYear, Keys.ENTER);
					// util.jsclick(driver, ele1);
					flag = true;
					i = ele.size();
				}
				else {
					System.out.println("element is not clickable so executing else");
				}

			}

		}*/
		try {
			Wait.elementToBeClickable(driver, selectFromYear, 5);
			testutil.actionMethodClick(driver, selectFromYear);
			selectFromYear.sendKeys(tYear, Keys.ENTER);
		}
		catch(Exception e) {
			Wait.elementToBeClickable(driver, selectToYear, 5);
			testutil.actionMethodClick(driver, selectToYear);
			selectToYear.sendKeys(tYear, Keys.ENTER);
		}
		//testutil.actionMethodClick(driver, selectToYear);
		//selectToYear.sendKeys(tYear, Keys.ENTER);
		/*Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[@class='pika-select pika-select-year']"));
			System.out.println(ele.size());
			for (int i = 0; i < ele.size(); i++) {
				if (isClickable(ele.get(i))) {
					testutil.actionMethodClick(driver, ele.get(i));
					// util.jsclick(driver, ele1);
					ele.get(i).sendKeys(tYear, Keys.ENTER);
					flag = true;
					i = ele.size();
				}
				else {
					System.out.println("element is not clickable so executing else of refresh");
				}

			}

		}*/

		

		// WebElement ee1 = driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-month']"));
		// Wait.elementToBeClickable(driver, ee1, 2);
		// Select dropMonth2 = new Select(ee1);
		// Wait.elementToBeClickable(driver, ee1, 3);
		// dropMonth2.selectByVisibleText(tMonth);
		// dropMonth2.selectByValue(tMonth);
		
		try {
			Wait.elementToBeClickable(driver, selectFromMonth, 5);
			testutil.actionMethodClick(driver, selectFromMonth);
			selectFromMonth.sendKeys(tMonth, Keys.ENTER);

		}
		catch(Exception e) {
			Wait.elementToBeClickable(driver, selectToMonth, 5);
			testutil.actionMethodClick(driver, selectToMonth);
			selectToMonth.sendKeys(tMonth, Keys.ENTER);
		}
		WebElement we1 = driver
				.findElement(By.xpath("//*[@class='pika-single is-bound']//td[@data-day='" + tDate + "']"));
		we1.click();
		Wait.elementToBeClickable(driver, toDateOk, 2);
		try {
			fromDateOk.click();
		}catch(Exception e) {
		toDateOk.click();
		}
		//StoreCalendars.clickOnOk();
	}
	public void validateserviceaddedsucessfully() {
		testutil.validatesuccessmsg(driver, serviceUpdatedsucmsg1, toasteContainer);
	}

	public void clickOnApply() {
		Applybtn.click();
		List<WebElement> string1 = areYouSureYouWantToUpdateService;
		System.out.println(string1);
		Assert.assertTrue(!string1.equals(null), "are You Sure You Want To Update Service message is not displayed");
		System.out.println("are You Sure You Want To Update Service message displayed");
		//okbtn.click();
		StoreCalendars.clickOnOk();
		testutil.validatesuccessmsg(driver, serviceUpdatedsucmsg1, toasteContainer);
	}

	public void clickOnRemove() {
		remove.click();
		List<WebElement> checkingTimePeriod = driver.findElements(By.xpath("//*[text()='Time period']"));
		System.out.println(checkingTimePeriod);
		int listOfElement = checkingTimePeriod.size();
		System.out.println(listOfElement);
		if(!(listOfElement == 0)) {
			for( int i=0; i<listOfElement;i++) {
				remove.click();
			}
		}
		List<WebElement> checkingTimePeriod1 = driver.findElements(By.xpath("//*[text()='Time period']"));
		Assert.assertTrue(checkingTimePeriod1.size() == 0, "time period is not removed");
	}

	public void clickOnRefresh() {
		//WebElement we = driver.findElement(By.xpath("//*[contains(@data-control-name,'icnRefresh')]//following-sibling::div[@class='powerapps-icon no-focus-outline']"));
		//we.click();
		//List<WebElement> ele = driver.findElements(By.xpath("//*[contains(@data-control-name,'icnRefresh')]//following-sibling::div[@class='powerapps-icon no-focus-outline']"));
		//System.out.println(ele.size());
		Boolean flag = false;
		while (!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//*[contains(@data-control-name,'icnRefresh')]//following-sibling::div[@class='powerapps-icon no-focus-outline']"));
			System.out.println(ele.size());
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					testutil.actionMethodClick(driver, ele.get(i));
					// util.jsclick(driver, ele1);
					flag = true;
					i = ele.size();
				}
				else {
					System.out.println("element is not clickable so executing else of refresh");
				}

			}

		}
	}
}
