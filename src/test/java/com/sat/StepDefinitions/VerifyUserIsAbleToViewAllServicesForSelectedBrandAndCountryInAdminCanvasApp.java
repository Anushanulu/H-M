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

public class VerifyUserIsAbleToViewAllServicesForSelectedBrandAndCountryInAdminCanvasApp {
	public WebDriver driver;
	
	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	@When("Navigate to Country settings")
	public void navigate_TO_Country_Settings() {
		CountrySetting.navigateToCountrySettings();
	}
	@Then("User select country {string} and brand {string}")
	public void user_select_and(String NameOfTheCountry, String NameOfTheBrand) {
		CountrySetting.SelectBrand(NameOfTheBrand);
		CountrySetting.SelectCountry(NameOfTheCountry);
	}
	@Then("Click on Settings")
	public void click_on_settings() {
		storestng.clickOnSettings();
	}
	
	@Then("click on Add service")
	public void click_on_Add_service() {
		brandstng.clickOnAddService();
		
	}
    @Then("check status {string}")
    public void check_status(String togglebtnStatus) {
    	brandstng.selectToggleButton(togglebtnStatus);
    }
    @Then("select {string} from the dropdown")
    public void select_from_the_dropdown(String serviceName) {
    	CountrySetting.selectServiceFromDropdown(serviceName);
    }
    @Then("Enter default allowed Visitors {string} click on Add button and Ok button")
    public void Enter_default_allowed_Visitors_click_on_Add_button(String noOfdefaultvisitors) {
    	CountrySetting.defaultVisitor(noOfdefaultvisitors);
    	CountrySetting.clickAdd();
    	CountrySetting.clickOk();
    }
    @And("Verify the success message")
    public void Verify_the_success_message() {
    	brandstng.validateserviceaddedsucessfully();    	
    }
}
