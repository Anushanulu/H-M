package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class ResalRegisterItemPage {

	private WebDriver driver;

	Testutil util = new Testutil();
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	// Seller registering an item from Resale portal
	@FindBy(xpath = "//div[contains(text(),'Register items & drop off at store')]")
	private WebElement Registeryouritems;
	// @FindAll ({@FindBy (id="storelist")}) private List<WebElement> storelist;
	@FindBy(id = "storelist")
	private WebElement storelist;
	@FindBy(xpath = "//input[contains(@data-bind,'value: brand, valueUpdate:')]")
	private WebElement brandName;
	// @FindAll ({@FindBy (id="categories")}) private List<WebElement> categorylist;
	@FindBy(id = "categories")
	private WebElement categorylist;
	@FindBy(xpath = "//form[@id='resellitemcontactdetails']/p[3]/select")
	private WebElement conditionlist;
	@FindBy(xpath = "//input[contains(@data-bind,'value: material,')]")
	private WebElement materialType;
	@FindBy(xpath = "//*[@id='resellitemcontactdetails']/p[5]/select")
	private WebElement Unsolditemlist;
	@FindBy(xpath = "//*[text()='Thanks for register your items. A confirmation mail has been sent to ']")
	private WebElement ThankyouMessage;
	/*@FindBy(xpath = "//div[text()='Register your items']")
	private WebElement Registeryouritems_submit;*/
	@FindBy(xpath = "//div[text()='Save & Continue']")
	private WebElement SaveAndContinueBtn;
	@FindBy(xpath = "//button[@aria-label='Done']")
	private WebElement doneBtn;

	// Seller canceling an item from Resale portal
	@FindBy(xpath = "//div[text()=' My Items']")
	private WebElement MyItems_link;
	// span[not(contains(@style,'display: none;')) and @class='itempreregister']
	// (//span[not(contains(@style,'display: none;')) and
	// @class='itempreregister'])[1]
	// div[not(contains(@style,'display: none;')) and @class='itemcancel']
	@FindBy(xpath = "//button[@id='yesItemBtn']/child::div/child::div[text()='Yes']")
	private WebElement yesBtn;
	
	//Cancel not possible
	@FindBy(xpath="//div[@id='errorText']")
	private WebElement cancelNotPossible;
	

	// Personal details tab
	@FindBy(xpath = "(//div[@class='Accountdet'])[2]")
	private WebElement myaccount_link;
	@FindBy(xpath = "(//div[text()='Personal details'])[2]")
	private WebElement personalDetailsTab;
	@FindBy(xpath = "//input[@name='puregistrationname']") // input[@id='puregistrationname']
	private WebElement fname;
	@FindBy(xpath = "//input[@id='puregistrationlastname']")
	private WebElement lname;
	@FindBy(xpath = "//div[@aria-controls='iti-0__country-listbox']")
	private WebElement country_list;
	@FindBy(xpath = "//li[@id='iti-0__item-in']/span")
	private WebElement country_selection;
	@FindBy(xpath = "//input[@id='puregistrationmobile']")
	private WebElement phnmbr;
	@FindBy(xpath = "//input[@id='puregistrationaddress']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='puregistrationpostcode']")
	private WebElement postal_code;
	@FindBy(xpath = "//input[@id='puregistrationtown']")
	private WebElement city;
	@FindBy(xpath = "//button[@id='BtnUpdate']")
	private WebElement updateBtn;
	@FindBy(xpath = "//div[text()='Ok']")
	private WebElement okBtn;

	// Sellers details in App
	@FindBy(xpath = "//input[@appmagic-control='txtFirstNameMIStextbox'] ")
	private WebElement appFname;
	@FindBy(xpath = "//input[@appmagic-control='txtLastNameMIStextbox']")
	private WebElement appLname;
	@FindBy(xpath = "//input[@appmagic-control='txtEmailMIStextbox']")
	private WebElement appEmail;
	@FindBy(xpath = "//input[@data-intl-tel-input-id='0']")
	private WebElement appPhnmbr;
	@FindBy(xpath = "//input[@appmagic-control='txtAddressMIStextbox']")
	private WebElement appAddress;
	@FindBy(xpath = "//input[@appmagic-control='txtPostalCodeMIStextbox']")
	private WebElement appPostalcode;
	@FindBy(xpath = "//input[@appmagic-control='txtTownMIStextbox']")
	private WebElement appCity;
	@FindBy(xpath = "//div[@data-control-name='ddCountryMIS']")
	private WebElement appCountry;

	public ResalRegisterItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void registerItem() {
		Registeryouritems.click();

	}

	public void selectValues(String Store_Name, String Brand_name, String catogeryName, String Listofcondition,
			String material, String unsolditem) throws InterruptedException {
		Select List_of_stores = new Select(storelist);
		List_of_stores.selectByVisibleText(Store_Name);

		Thread.sleep(2000);

		// Wait.elementToBeClickable(driver, brandName, 5);

		brandName.sendKeys(Brand_name);

		Thread.sleep(2000);

		// Wait.elementToBeClickable(driver, categorylist, 5);

		Select catogeryList = new Select(categorylist);
		catogeryList.selectByVisibleText(catogeryName);

		Thread.sleep(2000);
		// Wait.elementToBeClickable(driver, conditionlist, 5);

		Select conditionList = new Select(conditionlist);
		conditionList.selectByVisibleText(Listofcondition);

		Thread.sleep(2000);
		// Wait.elementToBeClickable(driver, materialType, 5);

		materialType.sendKeys(material);

		Thread.sleep(2000);
		// Wait.elementToBeClickable(driver, Unsolditemlist, 5);

		Select condition_list = new Select(Unsolditemlist);
		condition_list.selectByVisibleText(unsolditem);
	}

	public void Submit() {
		//Registeryouritems_submit.click();
		SaveAndContinueBtn.click();
	}

	public void regiseteredMsg() {
		Wait.waitUntilElementVisible(driver, ThankyouMessage);
		/*
		 * boolean verifyTitle = ThankyouMessage.isDisplayed(); assertTrue(verifyTitle);
		 */
		String actual = ThankyouMessage.getText();
		String expected = "Thanks for register your items. A confirmation mail has been sent to";
		// Assert.assertEquals(actual, expected);
		System.out.println(actual);
		System.out.println(expected);
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
	}

	public void done() {
		doneBtn.click();

	}

	public void currentTabValidation(String status) {
		WebElement preregItem = driver.findElement(
				By.xpath("(//span[not(contains(@style,'display: none;'))]//div[text()='"+status+"'])[1]"));
		System.out.println("Currently added item is present in Active tab");
	}

	public void myItemsTab() {
		util.actionMethodClick(driver, MyItems_link);
	}

	public void cancelItems() {
		WebElement cancelBtn = driver
				.findElement(By.xpath("(//div[not(contains(@style,'display: none;')) and @class='itemcancel'])[1]"));
		util.actionMethodClick(driver, cancelBtn);
		util.actionMethodClick(driver, yesBtn);
	}
	public void cancelNotpossibleItems() {
		WebElement cancelBtn = driver
				.findElement(By.xpath("(//div[not(contains(@style,'display: none;')) and @class='itemcancel'])[1]"));
		util.actionMethodClick(driver, cancelBtn);
		System.out.println(cancelNotPossible.getText());
		assertTrue(cancelNotPossible.getAttribute("textContent").contains("Cancel item is not possible."), "Cancel the item is not possible");
		util.actionMethodClick(driver, okBtn);
	}

	public void modifyDetilasInPortal(String firstName, String lastName, String mobNumber, String addressName,
			String pincode, String cityName) {
		util.actionMethodClick(driver, myaccount_link);
		util.actionMethodClick(driver, personalDetailsTab);
		fname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		fname.sendKeys(firstName);
		lname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		lname.sendKeys(lastName);
		phnmbr.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		phnmbr.sendKeys(mobNumber);
		address.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		address.sendKeys(addressName);
		postal_code.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		postal_code.sendKeys(pincode);
		city.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		city.sendKeys(cityName);
		util.actionMethodClick(driver, updateBtn);
		util.actionMethodClick(driver, okBtn);
	}

	public void modifiedDetailsPortalValidation(String firstName, String lastName, String mobNumber, String addressName,
			String pincode, String cityName) {
		Wait.waitUntilElementVisible(driver, fname);
		// System.out.println(fname.getAttribute("value"));
		// System.out.println(firstName);

		assertTrue(fname.getAttribute("value").contains(firstName), "First Name is not same");
		assertTrue(lname.getAttribute("value").contains(lastName), "Last Name is not same");
		assertTrue(phnmbr.getAttribute("value").contains(mobNumber), "Phone number is not same");
		assertTrue(address.getAttribute("value").contains(addressName), "Address is not same");
		assertTrue(postal_code.getAttribute("value").contains(pincode), "Pincode is not same");
		assertTrue(city.getAttribute("value").contains(cityName), "City Name is not same");
	}

	public void modifiedDetailsAppValidation(String firstName, String lastName, String mobNumber, String addressName,
			String pincode, String cityName) {
		assertTrue(appFname.getAttribute("value").contains(firstName), "First Name is not same");
		assertTrue(appLname.getAttribute("value").contains(lastName), "Last Name is not same");
		assertTrue(appPhnmbr.getAttribute("value").contains(mobNumber), "Phone number is not same");
		assertTrue(appAddress.getAttribute("value").contains(addressName), "Address is not same");
		assertTrue(appPostalcode.getAttribute("value").contains(pincode), "Pincode is not same");
		assertTrue(appCity.getAttribute("value").contains(cityName), "City Name is not same");
	}
}
