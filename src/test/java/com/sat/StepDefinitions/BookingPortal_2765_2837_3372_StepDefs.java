package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BookingPortalPage;
import com.sat.Pages.BrandSettingsPage;
import com.sat.Pages.CountrySettingsPage;
import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingPortal_2765_2837_3372_StepDefs {
	public WebDriver driver;
	

	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private GmailLoginPage  Gmail= new GmailLoginPage(TestBase.getDriver());
	private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
	private BookingPortalPage bookingPortal = new BookingPortalPage(TestBase.getDriver());
	private GmailLoginPage gmailLoginPage = new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	private PowerAppsAutomateFlowPage power = new PowerAppsAutomateFlowPage(TestBase.getDriver());
	
	@Given("Login to Admin tool App")
	public void login_to_Admin_tool_App() {
		TestBase.getDriver().get(config.getApplicationUrl());
		BookingAppLogin.EnterUserName(config.AdminUserName());
		BookingAppLogin.EnterPassword(config.AdminUserPassword());		
	}	
	@When("navigate to store settings")
	public void navigate_to_store_setings() {
		storestng.clickOnSettings();
		storestng.clickOnStoreSettings();
	}
	@When("select brand {string} and country {string}")
	public void select_Brand_And_Country(String Brand, String Country) throws InterruptedException {
		storestng.selectStoreSettingBrand(Brand);
		storestng.selectStoreSettingCountry(Country);
	}
	@Then("Select store {string}")
	public void select_store(String storeName) {
		storestng.clickOnStore(storeName);
	}
	@And("click on {string} Settings")
	public void click_one_settings(String serviceName) {
		storestng.clickOnService(serviceName);
	}
	@Then("check the display in portal view is {string} for the service")
	public void check_the_display_in_portal_view_is_for_the_service(String viewStatus) {
		storestng.displayInPortalView(viewStatus);
	}
	@Then("change the Country {string} and brand {string}")
	public void change_the_country_and_bran(String Country, String Brand) {
		StoreCalendars.setCountryAndBrand(Country,Brand);
	}
	@When("clicked on store Calendar then select store {string} and check the {string}")
	public void clicked_on_store_calendar(String nameOfTheStore, String storeState) {
		StoreCalendars.storeIsOpenOrClose(storeState, nameOfTheStore);
	}
	@Then("check calendar is generated for the {string} if not generate calendar {string} {string} {string} {string} {string} {string}")
	public void check_calendar_is_generated_for_the_if_not_generate_calendar(String serviceName,String fmDate,String fmYear,String fmMonth,String tDate,String tYear,String tMonth) {
		StoreCalendars.checkCalendarForService(serviceName,fmDate,fmYear,fmMonth,tDate,tYear,tMonth);
		StoreCalendars.editSelectedSlot(serviceName);
	}	
	@And("open booking portal url")
	public void open_booking_portal_url() throws InterruptedException {
		TestBase.getDriver().get(config.getEmailUrl());
		gmailLoginPage.enterEmail(config.getEmailUserid());
		gmailLoginPage.enterPassword(config.getEmailPassword());
		gmailLoginPage.unReadAllMails();
		TestBase.getDriver().get(config.bookingportalUrlForResell());
	}
	
	@Then("select Slot Date {string} {string} {string}")
	public void select_slot_date(String setMonth, String setYear, String setDate)	{
		bookingPortal.selectSlotDate(setMonth, setYear, setDate);
	}
	@And("validate the date format")
	public void vlaidate_the_date_formate() throws InterruptedException {
		bookingPortal.validateDateFormat();
	}
	@Then("Check and click on the store {string}")
	public void check_and_click_on_the_store(String storeName) {
		bookingPortal.checkStoreAndClickOnIt(storeName);
	}
	@And("selct the time slot which is enable {string}")
	public void select_the_time_slot_which_is_enable(String bookingSlotTime) {
		bookingPortal.checkEnabledSlotAndClickOnIt(bookingSlotTime);
	}
	@Then("enter required contact details {string} {string} {string} {string} {string} {string}")
	public void enter_required_contact_details(String contactName, String contactEmail, String contactMobile, String contactAddress,String contactPostcode,String contactCity) {
		bookingPortal.enterContactDetails(contactName, contactEmail, contactMobile, contactAddress, contactPostcode, contactCity);
	}
	@Then("validate contact fields {string} {string} {string} {string} {string}")
	public void validate_contact_fields(String Name,String Email,String phoneno,String address,String helpmail) throws InterruptedException {
		bookingPortal.validateContactDetails(Name, Email, phoneno, address, helpmail);
	}
	@Then("click on done")
	public void click_on_done() {
		bookingPortal.clickOnDone();
	}
	@And("Validate confirmation mail with subject {string}")
	public void validate_confirmation_mail(String emailSubject) {
		TestBase.getDriver().get(config.getEmailUrl());
		gmailLoginPage.ValidationWithoutPromotionTab(emailSubject);
	}
	
}
