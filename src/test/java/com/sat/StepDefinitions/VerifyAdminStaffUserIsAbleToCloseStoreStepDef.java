package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BrandSettingsPage;
import com.sat.Pages.CountrySettingsPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyAdminStaffUserIsAbleToCloseStoreStepDef {
	public WebDriver driver;
	
	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	@Given ("User Navigate to Booking App")
	public void user_Naviagte_to_Booking_App() throws InterruptedException {
		TestBase.getDriver().get(config.getApplicationUrl());
		BookingAppLogin.EnterUserName(config.AdminUserName());
		BookingAppLogin.EnterPassword(config.AdminUserPassword());
	}
	
	@Then("Enter Booking App url")
	public void enter_booking_app_url() {
		TestBase.getDriver().get(config.getApplicationUrl());
		BookingAppLogin.switchToFrame();
	}
	
	@When("User select {string} and {string}")
	public void user_select_and(String selectCountry, String selectBrand) {
		StoreCalendars.setCountryAndBrand(selectCountry, selectBrand);
	}

	@When ("User Set {string} {string} {string} {string}")
	public void user_Set(String Brand, String Country, String ServiceName, String DefaultAllowedVisitors) throws InterruptedException {
		CountrySetting.navigateToCountrySettings();
		CountrySetting.DefaultVisitorOfCountryAndBrand(Brand, Country, ServiceName, DefaultAllowedVisitors);
	}
	
	
	@Then("User Check {string} for {string}")
	public void user_check_for(String storeState, String nameOfTheStore) {
		StoreCalendars.storeIsOpenOrClose(storeState, nameOfTheStore);
	}
	
	@Given("User clicks on Calendar link")
	public void user_clicks_on_calendar_link() {
		StoreCalendars.clickOnCalendar();
	}
		
	@Then("User selects the store {string} and clicks on Next")
	public void user_selects_the_store_and_click_on_next(String nameOfTheStore) {
		StoreCalendars.selectStoreAndClickNext(nameOfTheStore);
	}
	
	@Then("User click on toggle")
	public void user_click_on_toggle() {
		StoreCalendars.clickOnToggle();
	}
	
	@And("User click on Yes and able to see Successfully store Close Message")
	public void user_click_on_yes_and_see_Successfully_store_Close_Message() {
		StoreCalendars.selectApplyhAndVerifySuccessMsg();
	}
	
}
