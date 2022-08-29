package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
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

public class VerifyServiceCalendarsWhenOpeningTheClosedStoreStepDefs {
public WebDriver driver;
	
	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	private GmailLoginPage  Gmail= new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	/*@When ("sets {string} {string} {string} {string}")
	public void set(String Brand, String Country, String ServiceName, String DefaultAllowedVisitors) throws InterruptedException {
		CountrySetting.navigateToCountrySettings();
		CountrySetting.DefaultVisitorOfCountryAndBrand(Brand, Country, ServiceName, DefaultAllowedVisitors);
	}
	
	@When ("user Select {string} services for {string} brand {string} country and {string} Store")
	public void user_Select_services_for_brand_country_and_Store(String serviceStatus, String NameOfTheBrand,String NameOfTheCountry, String ServiceName) throws InterruptedException {
		storestng.storeEnableorDisable(NameOfTheBrand, NameOfTheCountry, serviceStatus, ServiceName);
		
	}

	@Then("checks {string} for {string}")
	public void checks_for(String storeState, String nameOfTheStore) {
		StoreCalendars.storeIsOpenOrClose(storeState, nameOfTheStore);
	}
	
	@Given("User selects {string}")
	public void User_select(String storeStatus) {
		StoreCalendars.clickOnToggle();
	}*/
	
	@When("The user enter default visitors {string}")
	public void the_user_enter_default_visitors(String defaultAlowedVisitor) {
		StoreCalendars.enterDefaultVisitor(defaultAlowedVisitor);
	}
	
    @Then("Select Yess Button to verify success message")
    public void Select_Yess_Button_to_verify_success_message() {
    	StoreCalendars.selectYesAndVerifySuccessOpenMsg();
	}
    @And("Verify service Calendars is {string}")
    public void Verify_service_calendars(String statusOfCalander) {
    	StoreCalendars.verificationOfCalender(statusOfCalander);
    }
}
