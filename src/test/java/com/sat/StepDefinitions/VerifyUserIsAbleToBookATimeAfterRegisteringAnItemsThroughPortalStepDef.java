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

public class VerifyUserIsAbleToBookATimeAfterRegisteringAnItemsThroughPortalStepDef {
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
	
	
	@And("validate Registered Items details {string} {string}")
	public void validate_registered_items_details(String Brand, String CategoryName) {
		bookingPortal.validateRegisteredItems(Brand, CategoryName);
	}
    @And("validate Booking details {string} {string} {string} {string} {string} {string}")
    public void validate_booking_details(String storeName, String date, String month, String year, String Name, String Email) {
    	bookingPortal.validateFromResaleBookingdeails(storeName, date, month, year, Name, Email);
    }


}
