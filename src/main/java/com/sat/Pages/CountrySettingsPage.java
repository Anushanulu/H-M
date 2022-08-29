package com.sat.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class CountrySettingsPage {
	private WebDriver driver;
	Testutil testutil = new Testutil();
	
	
	@FindBy(xpath="//div[text()='Settings']")
	private WebElement Settings;
	//div[@title='Settings']
	
	@FindBy(xpath="//*[@data-control-name='galQueueSystemMenu']/div/div/div/div/div/div/div/div/div[3]/div/div/div[4]/div/div/div/div/div/div/div/div[2]") //div[text()='Country Settings']
	private WebElement CountrySettings;
	//*[contains(text(),'Country Settings')]
	
	@FindBy(xpath="(//*[@class='topTagText_yz2uri-o_O-topTagText_wlyv6o-o_O-topTagTextReadonly_m0te3e'])[1]")
	private WebElement BrandName;
	
	@FindBy(xpath="//button[contains(@class,'buttonReset')]")
	private WebElement Cancleicon;
	
	@FindBy(xpath="//*[@aria-label='Brand']")
	private WebElement BrandEntryBox;
	
	@FindBy(xpath="//*[@data-control-name='cbCountryCSS']//*[@class='selectedItem_7e8qnb']")
	private WebElement CountryName;

	@FindBy(xpath="//div[text()='Holi sale']")
	private WebElement ServiceHolisale;
	
	@FindBy(xpath="//*[@appmagic-control='txtEditDefaultAllowedVisitorsCSStextbox']")
	private WebElement DefaultAllowedVisitors;
	
	@FindBy(xpath="//*[text()='APPLY']")
	private WebElement ApplyButton;
	
	@FindBy(xpath="//*[text()='OK']")
	private WebElement OkButton;
	private By OKbtn1 = By.xpath(("//*[text()='OK']"));
	
	@FindBy(xpath="//*[@data-control-name='icnCancelStatusChangeSVS_4']")
	private WebElement Cancle;
	
	@FindBy(xpath="//*[text()='Select Service *']")
	private WebElement clickOnSelectService;
	
	
	@FindBy(xpath="//*[@aria-label='AddService' and @placeholder='Select Service *']")
	private WebElement serviceInDropDown;
	
	
	@FindBy(xpath="//*[text()='ADD']")
	private WebElement addbtn;
	
	@FindBy(xpath = "//*[@class='pika-select pika-select-year']")
	private WebElement selectFromYear;
	
	@FindBy(xpath = "//*[@class='pika-select pika-select-year']")
	private List<WebElement> selectToYear;

	@FindBy(xpath = "//*[@class='pika-select pika-select-month']")
	private WebElement selectFromMonth;

	@FindBy(xpath = "(//*[@class='pika-select pika-select-month'])")
	private WebElement selectToMonth;
	
	@FindBy(xpath="//*[@appmagic-control='txtAddDefaultAllowedVisitorsCSStextbox']")
	private WebElement defaultVisitor;
	
	@FindBy(xpath="//*[@appmagic-control='txtEnableMultiServiceDefaultVisitorsCSStextbox']")
	private WebElement defaultVisitor1;
	
	@FindBy(xpath = "(//*[@class='appmagic-datepicker-ok-button' and text()='Ok'])")
	private WebElement toDateOk;
	
	@FindBy(xpath = "//div[text()='ADD TIME PERIOD']")
	private WebElement addTimePeriod;

	@FindBy(xpath = "//div[@data-control-name='dpEditFromDateBSS' or @data-control-name='dpFromDateCSS' or @data-control-name='dpExportFromDateSSS']/div/div/div/div/div/div")
	private WebElement fromDate;

	@FindBy(xpath = "//div[@data-control-name='dpEditToDateBSS' or @data-control-name='dpToDateCSS' or @data-control-name='dpExportToDateSSS']/div/div/div/div/div/div")
	private WebElement toDate;

	@FindBy(xpath = "//*[@class='appmagic-datepicker-ok-button' and text()='Ok']")
	private WebElement fromDateOk;
			
	@FindBy(xpath="//*[text()='OK']")
	private WebElement okbtn;

	@FindBy(xpath="//*[contains(@data-control-name,'icnSelectAllOptionsCSS')]")
	private WebElement moreoption;
		
	@FindBy(xpath="//*[contains(text(),'Disable selected')][contains(text(),'services')]")
	private WebElement disablepopupwindow;
	
	@FindBy(xpath="//*[contains(text(),'Enable selected')][contains(text(),'services')]")
	private WebElement enablepopupwindow;
	
	@FindBy(xpath="//*[text()='Selected services updated successfully']")
	private List<WebElement> ServiceupdatedSuccessfully;
	//Selected services updated successfully
	
	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;
			
	public CountrySettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isClickable(WebElement ele) {
		boolean flag = true;
				try {
				       new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ele));
				       System.out.println("Element is clickable");
				     }
				catch(Exception e) {
				       System.out.println("Element isn't clickable");
				       flag=false;
				}
			return flag;
		}
	public void navigateToCountrySettings() {
		System.out.println("navigating to country settings");
		Wait.elementToBeClickable(driver, Settings, 10);
		//Wait.waitUntilElementVisible(driver, Settings);
		//Settings.click();
		//testutil.actionClassClick(driver, Settings);
		//testutil.jsclick(driver, Settings);
		//List<WebElement> ele = driver.findElements(By.xpath("//div[text()='Settings']"));
		//div[@data-control-name='icnQueueSystemMenu']/following-sibling::div[@data-control-name='lblQueueSystemMenu']//div[text()='Settings']
		//System.out.println("initilized web element");
		Boolean flag = false;
		while(!flag) {
			List<WebElement> ele = driver.findElements(By.xpath("//div[text()='Settings']"));
			System.out.println("eneterd while");
			for(int i=0;i<ele.size();i++){
				System.out.println("eneterd for");
				if(isClickable(ele.get(i))) {
					System.out.println("eneterd if");
					testutil.actionMethodClick(driver, ele.get(i));
					//ele.get(i).click();
					flag = true;
					i = ele.size();
				}
				}

				}
		System.out.println("clicked on settings");
		Wait.elementToBeClickable(driver, CountrySettings, 2);
		CountrySettings.click();
		System.out.println("Navigated Country settings");
	}
	
	public void SelectBrand(String NameOfTheBrand) {
		System.out.println("setting the brand");
		Wait.elementToBeClickable(driver, BrandName, 3);
		testutil.jsclick(driver, BrandName);
		Wait.elementToBeClickable(driver, Cancleicon, 2);
		testutil.jsclick(driver, Cancleicon);
		//Actions action = new Actions(driver);
		//WebElement we = driver.findElement(By.xpath("//*[text()='"+NameOfTheBrand+"']"));
		//Wait.elementToBeClickable(driver, we, 5);
		//action.moveToElement(we).click().perform();
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
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		System.out.println("Selected Brand");
	}
	public void SelectCountry(String NameOfTheCountry) {
		Wait.elementToBeClickable(driver, CountryName, 2);
		CountryName.click();
		Wait.elementToBeClickable(driver, Cancleicon, 5);
		Cancleicon.click();
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@class='itemTemplateLabel_dqr75c' and contains(text(),'"+NameOfTheCountry+"')]"));
		Wait.elementToBeClickable(driver, we, 2);
		Wait.waitUntilElementVisible(driver, we);
		action.moveToElement(we).click().perform();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		System.out.println("Selected Country");
	}
	
	/**
	 * @param NameOfTheBrand
	 * @param NameOfTheCountry
	 * @param ServiceName
	 * @param NumOfDefaultVisitors
	 */
	public void DefaultVisitorOfCountryAndBrand(String NameOfTheBrand, String NameOfTheCountry, String ServiceName, String NumOfDefaultVisitors) {
		SelectBrand(NameOfTheBrand);
		SelectCountry(NameOfTheCountry);
		System.out.println("Need to select service");
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		List<WebElement> serviceName = driver.findElements(By.xpath("//*[text()='"+ServiceName+"']"));
		System.out.println(serviceName);
		//Wait.elementToBeClickable(driver, serviceName, 3);
		//serviceName.click();
		//Wait.waitUntilElementVisible(driver, serviceName);
		//testutil.actionMethodClick(driver, serviceName);
		Boolean flag = false;
		while(!flag) {
			System.out.println(serviceName.size());
			for(int i=0;i<serviceName.size();i++)
				{
				System.out.println(i);
				if(isClickable(serviceName.get(i))) {
					//serviceName.get(i).click();
					testutil.actionMethodClick(driver, serviceName.get(i));
					flag = true;
					i = serviceName.size();
				}

				}

				}
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);		
		System.out.println("Service Name Selected");
//		WebElement service = driver.findElement(By.xpath("//*[contains(text(),'"+ServiceName+"')]"));
//		Wait.elementToBeClickable(driver, service, 5);
//		System.out.println("clicking on service");
//		//testutil.jsclick(driver, service);
//		service.click();
//		System.out.println("clicked on service");
		String NumberOfVisitors = DefaultAllowedVisitors.getText();
		System.out.println(NumberOfVisitors);
		if(NumberOfVisitors == null) {
			System.out.println("if block");
			DefaultAllowedVisitors.sendKeys(NumOfDefaultVisitors);
			ApplyButton.click();
			Wait.elementToBeClickable(driver, OkButton, 3);
			OkButton.click();
			Wait.untilPageLoadComplete(driver, 180);
		}
		else {
			System.out.println("else block");
			Cancle.click();
			Wait.elementToBeClickable(driver, OkButton, 2);
			
			Boolean flag1 = false;
			while(!flag1) {
				List<WebElement> ele = driver.findElements(OKbtn1);
				for(int i=0;i<ele.size();i++){
					if(isClickable(ele.get(i))) {
						ele.get(i).click();
						flag1 = true;
						i = ele.size();
					}

					}

					}
		}
	}//*[@class='appmagic-label no-focus-outline middle']//*[text()='Automation Service Test']

	
	public void selectServiceFromDropdown(String serviceName) {
		clickOnSelectService.click();
		serviceInDropDown.sendKeys(serviceName);
		Wait.elementToBeClickable(driver, clickOnSelectService, 10);
		WebElement we = driver.findElement(By.xpath("//*[text()='"+serviceName+"']"));
		Wait.elementToBeClickable(driver, we, 2);
		Wait.waitUntilElementVisible(driver, we);
		we.click();	
	}
	public void defaultVisitor(String noOfdefaultvisitors) {
		defaultVisitor.click();
		defaultVisitor.clear();
		defaultVisitor.sendKeys(noOfdefaultvisitors);
	}
	public void clickAdd() {
		addbtn.click();
	}
	public void clickOk() {
		
		Boolean flag = false;
		while(!flag) {
			List<WebElement> ele = driver.findElements(OKbtn1);
			for(int i=0;i<ele.size();i++)
				{
				if(isClickable(ele.get(i))) {
					ele.get(i).click();
					flag = true;
					i = ele.size();
				}
				}
				}
		//okbtn.click();
	}
	public void validateServiceAddedMsg() {
		testutil.validatesuccessmsg(driver, ServiceupdatedSuccessfully, toasteContainer);
	}
	public void enableOrDisable(String serviceStatus) throws InterruptedException {
		Wait.elementToBeClickable(driver, moreoption, 2);
		moreoption.click();
		Wait.untilPageLoadComplete(this.driver, 10);
		WebElement status= driver.findElement(By.xpath("//*[text()='"+serviceStatus+"']"));
		System.out.println(status);
		Wait.elementToBeClickable(driver, status, 2);
		if (serviceStatus.equalsIgnoreCase("Enable selected")) {
			System.out.println("enable");
			//Enable selected
			status.click();	
			Wait.elementToBeClickable(driver, defaultVisitor1, 2);
			//defaultVisitor.click();
			testutil.actionMethodClick(driver, defaultVisitor1);
			System.out.println("clicked on default visitor");
			defaultVisitor1.sendKeys("1");
			okbtn.click();
			System.out.println("clicked on ok");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.invisibilityOf((WebElement) enablepopupwindow));
			testutil.validatesuccessmsg(driver, ServiceupdatedSuccessfully, toasteContainer);
			System.out.println("enabled");
		}
		else {
			System.out.println("disable");
			//Disable selected
			Wait.untilPageLoadComplete(this.driver, 10);
			status.click();	
			okbtn.click();
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.invisibilityOf((WebElement) disablepopupwindow));
			testutil.validatesuccessmsg(driver, ServiceupdatedSuccessfully, toasteContainer);
//			boolean flag= true;
//			while(flag){
//				WebElement statusmsg = driver.findElement(By.xpath("//*[text()='Services updated successfully']"));
//				if(statusmsg.) {
//					WebDriverWait wait = new WebDriverWait();
//				}
//			}
			//Thread.sleep(10000);
//			WebDriverWait wait = new WebDriverWait(driver, 120);
//			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Disable selected')][contains(text(),'services')]"))));
			System.out.println("disabled");
		}
		
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
		testutil.actionMethodClick(driver, selectFromYear);
		selectFromYear.sendKeys(tYear, Keys.ENTER);

		// WebElement ee1 = driver.findElement(By.xpath("//*[@class='pika-select
		// pika-select-month']"));
		// Wait.elementToBeClickable(driver, ee1, 2);
		// Select dropMonth2 = new Select(ee1);
		// Wait.elementToBeClickable(driver, ee1, 3);
		// dropMonth2.selectByVisibleText(tMonth);
		// dropMonth2.selectByValue(tMonth);
		testutil.actionMethodClick(driver, selectToMonth);
		selectToMonth.sendKeys(tMonth, Keys.ENTER);

		WebElement we1 = driver
				.findElement(By.xpath("//*[@class='pika-single is-bound']//td[@data-day='" + tDate + "']"));
		we1.click();
		Wait.elementToBeClickable(driver, toDateOk, 2);
		toDateOk.click();
		//StoreCalendars.clickOnOk();
	}
}
