package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class ResaleLoginPage {

	private WebDriver driver;

	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());

	// Creating account for Reseller user details
	@FindBy(linkText = "Create an account")
	private WebElement createAccount_link;
	@FindBy(xpath = "//*[@id='poregistrationemail']")
	private WebElement email;
	@FindBy(xpath="//*[@id='poregistrationconfirmemail']")
	private WebElement confirmationEmail;
	@FindBy(xpath = "//*[@id='poregisterpassword']")
	private WebElement password;
	@FindBy(xpath = "//*[@id='poregistrationname']")
	private WebElement fname;
	@FindBy(xpath = "//*[@id='poregistrationlastname']")
	private WebElement lname;
	@FindBy(xpath = "//div[@aria-controls='iti-0__country-listbox']") // *[@aria-controls='iti-1__country-listbox']
	private WebElement country_list;
	@FindBy(xpath = "//*[@id='iti-0__item-in']/span") // *[@id='iti-1__item-in']/span
	private WebElement country_selection;
	@FindBy(xpath = "//*[@id='poregistrationmobile']")
	private WebElement phnmbr;
	@FindBy(xpath = "//*[@id='poregistrationaddress']")
	private WebElement address;
	@FindBy(xpath = "//*[@id='poregistrationpostcode']")
	private WebElement postal_code;
	@FindBy(xpath = "//*[@id='poregistrationtown']")
	private WebElement city;
	@FindBy(xpath = "//*[@id='registrationconsent']")
	private WebElement chkbox;
	@FindBy(xpath = "//*[text()='Continue']")
	private WebElement continue_btn;
	@FindBy(xpath = "//*[text()='Registered successfully.']")
	private WebElement Register_success_msg;
	@FindBy(xpath = "//*[text()='Ok']")
	private WebElement ok_btn;

	@FindBy(xpath = "//form[@id='resellregistrationdetails']//div[text()='Email *']")
	private WebElement email_txt;
	@FindBy(xpath = "//form[@id='resellregistrationdetails']//div[text()='Confirm Email *']")
	private WebElement confirmationEmail_txt;
	@FindBy(xpath = "//form[@id='resellregistrationdetails']//div[text()='Password']")
	private WebElement password_txt;
	@FindBy(xpath = "//div[text()='First Name *']")
	private WebElement fname_txt;
	@FindBy(xpath = "//div[text()='Last Name *']")
	private WebElement lname_txt;
	@FindBy(xpath = "//div[text()='Mobile *']")
	private WebElement mobile_txt;
	@FindBy(xpath = "//div[text()='Street address *']")
	private WebElement staddres_txt;
	@FindBy(xpath = "//div[text()='Postal Code *']")
	private WebElement postalcode_txt;
	@FindBy(xpath = "//div[text()='City *']")
	private WebElement city_txt;
	@FindBy(xpath = "//div[text()='Country *']")
	private WebElement country_txt;

	// Deleting a seller
	@FindBy(xpath = "(//div[@class='Accountdet'])[2]")
	private WebElement myaccount_link;
	@FindBy(xpath = "//div[@class='landingitem']/child::div/div[text()='Manage account']")
	private WebElement manageAcc_link;
	@FindBy(xpath = "//div[@class='removeacc']")
	private WebElement deleteAcc;
	@FindBy(xpath = "//button[@id='yesItemBtn']/child::div/child::div[text()='Yes']")
	private WebElement yes_btn;

	// Login to Resale portal
	@FindBy(xpath = "//input[@id='pousername']")
	private WebElement emailID;
	@FindBy(xpath = "//input[@id='popassword']")
	private WebElement loginpassword;
	@FindBy(xpath = "//div[text()='Sign in']")
	private WebElement signin;
	@FindBy(xpath = "//*[@id='landingpageuseremail']")
	private WebElement succLoginmsg;

	// Seller forgot the password
	@FindBy(linkText = "Forgotten your password?")
	private WebElement forgotPwd_link;
	@FindBy(id = "poresetusername")
	private WebElement emailid;
	@FindBy(xpath = "//*[text()='Reset']")
	private WebElement Reset_btn;
	@FindBy(xpath = "//*[text()='Back to login']")
	private WebElement backToLogin_btn;
	@FindBy(xpath = "//div[text()='You should receive a link in a few moments. Please open that link to reset your password.']")
	private WebElement confirmation_msg;

	@FindBy(xpath = "//div[@aria-label='Promotions']")
	private WebElement promotionTab;

	// Seller Reset the password
	/*
	 * @FindBy(xpath = "(//div[@aria-label='Show trimmed content'])[last()]")
	 * private List<WebElement> expanddots;
	 */
	private By expanddots = By.xpath("(//div[@aria-label='Show trimmed content'])[last()]");
	@FindBy(xpath = "//a[text()='Reset Password']")
	private WebElement resetPwdBtn;
	@FindBy(xpath = "//input[@id='ponewpassword']")
	private WebElement newPwd;
	@FindBy(xpath = "//input[@id='poconfirmpassword']")
	private WebElement confirmPwd;
	@FindBy(xpath = "//div[text()='Update password']")
	private WebElement updatePwd;
	@FindBy(xpath = "//div[text()='Ok']")
	private WebElement okBtn;

	// Book a slot
	@FindBy(xpath = "//*[@id='nextBtn2']/div/div[contains(text(),'Book a time')]")
	private WebElement bookAslotBtn;

	Testutil util = new Testutil();

	public ResaleLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createAccount() {
		Actions action = new Actions(driver);
		action.moveToElement(createAccount_link).click().build().perform();
	}

	public void verifyFields() throws InterruptedException {

		List<String> list1 = Arrays.asList("Email *","Confirm Email *", "Password", "First Name *", "Last Name *", "Mobile *",
				"Street address *", "Postal Code *", "City *", "Country *");
		List<String> list2 = Arrays.asList(email_txt.getText(),confirmationEmail_txt.getText(), password_txt.getText(), fname_txt.getText(),
				lname_txt.getText(), mobile_txt.getText(), staddres_txt.getText(), postalcode_txt.getText(),
				city_txt.getText(), country_txt.getText());
		for (int i = 0; i < list1.size(); i++) {
			if ((list1.get(i)).equals(list2.get(i)) == true) {
				System.out.println(" Array List are equal     :" + list1.get(i) + "------->" + list2.get(i));
			} else {
				System.out.println(" Array List are not equal");
			}
		}
	}

	public void fillRegistrationFormDetails(String emailaddress, String firstname, String lastname, String phnbr,
			String Address, String pincode, String cityname) {
		// String pwd=config.getResalePortalpassword(emailaddress);

		email.sendKeys(emailaddress);
		confirmationEmail.sendKeys(emailaddress);
		password.sendKeys(config.getTemporaryPassword());
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		country_list.click();
		country_selection.click();
		phnmbr.sendKeys(phnbr);
		address.sendKeys(Address);
		postal_code.sendKeys(pincode);
		city.sendKeys(cityname);
	}

	public void continuetonextpage() {
		chkbox.click();
		continue_btn.click();

		boolean verifyTitle = Register_success_msg.isDisplayed();
		assertTrue(verifyTitle);
		ok_btn.click();
	}

	public void loginResalePortal(String userid, String pwd) throws InterruptedException {
		emailID.sendKeys(userid);
		loginpassword.sendKeys(pwd);
	}

	public String clickonsignin() {
		signin.click();
		return driver.getTitle();
	}

	public void validateLoginSuccMsg(String expected) {
		String actual = succLoginmsg.getText();
		// String expected = "You should receive a link in a few moments. Please open
		// that link to reset your password.";
		// Assert.assertEquals(actual, expected);
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
		System.out.println("actual : " + actual);
		System.out.println("expected : " + expected);
	}

	public void clickOnforgotPassword() {
		forgotPwd_link.click();
	}

	public void validateResetbtn(String email) {

		emailid.sendKeys(email);
		Reset_btn.click();

	}

	public void validateSuccessMessage() {
		String actual = confirmation_msg.getText();
		String expected = "You should receive a link in a few moments. Please open that link to reset your password.";
		// Assert.assertEquals(actual, expected);
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
	}

	public void promotionTab() {
		promotionTab.click();
	}

	public void deleteSeller() throws InterruptedException {
		util.jsclick(driver, myaccount_link);
		util.jsclick(driver, manageAcc_link);
		util.jsclick(driver, deleteAcc);
		util.jsclick(driver, yes_btn);

		// driver.navigate().refresh();
	}

	public void resetPwd() {
		List<WebElement> expanddots = driver
				.findElements(By.xpath("(//div[@aria-label='Show trimmed content'])[last()]"));
		if (!expanddots.isEmpty()) {
			if (expanddots.get(0).isDisplayed()) {
				expanddots.get(0).click();
			} else {
				System.out.println("element not visible");
			}
		}
		Wait.elementToBeClickable(driver, resetPwdBtn, 5);
		util.jsclick(driver, resetPwdBtn);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));		
		Wait.elementToBeClickable(driver, newPwd, 3);

		newPwd.sendKeys(config.getTemporaryPassword());
		confirmPwd.sendKeys(config.getTemporaryPassword());
		util.jsclick(driver, updatePwd);
		util.jsclick(driver, okBtn);
	}

	public void bookASlot() {
		util.jsclick(driver, bookAslotBtn);
	}

	public void switchTab() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// driver.close();
		// driver.get("http://google.com");
		// System.out.println("in new tab method");

	}

	public void switchToOriginal() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

	}
}
