package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BookingPortalPage;
import com.sat.Pages.BrandSettingsPage;
import com.sat.Pages.CountrySettingsPage;
import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingPortal_2841_3376_StepDefs {
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
	
	@Then("click on Cancle Booking Button and click on Yes verify cancelled msg and {string}")
	public void click_on_Cancle_Booking_Button_and_click_on_Yesverify_cancelled_msg_and(String helpmail) {
		bookingPortal.cancleBooking();
		bookingPortal.clickOnYesbtnAndVerifyMsg(helpmail);
	}
	
}
