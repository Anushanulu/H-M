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

public class VerifyUserIsAbleToViewAvailableServicesAndBookingsForSelectedBrandAndCountryInAdminCanvasAppStepDef {
public WebDriver driver;
	
private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	private GmailLoginPage  Gmail= new GmailLoginPage(TestBase.getDriver());
	private BookingPortalPage bookingPortal = new BookingPortalPage(TestBase.getDriver());
	private GmailLoginPage gmailLoginPage = new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	private PowerAppsAutomateFlowPage power = new PowerAppsAutomateFlowPage(TestBase.getDriver());

	
	@And("validate services {string} under the available service")
	public void validate_services_under_the_available_service(String serviceName) {
		StoreCalendars.validateListOfServices(serviceName);
	}
	@And("click on Booking tab and veify the booking slots for {string}")
	public void click_on_Booking_tab_and_veify_the_booking_slots_for(String serviceName) {
		StoreCalendars.clickOnBookingTabAndValidateService(serviceName);
	}
	
	
	
}
