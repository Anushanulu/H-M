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

public class VerifyUserIsAbleToEnableMultipleServicesForSelectedBrandinAdminCanvasApp {
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
	
	@Given("Login to Canvas App with Admin credentials1")
	public void login_to_Canvas_App_With_Admin_credentials() {
		TestBase.getDriver().get(config.getApplicationUrl());
		BookingAppLogin.EnterUserName(config.AdminUserName());
		BookingAppLogin.EnterPassword(config.AdminUserPassword());		
	}
	@Then("Select1 Country {string} and Brand {string}")
	public void select_Country_and_Brand(String selectCountry, String selectBrand) {
		StoreCalendars.setCountryAndBrand(selectCountry, selectBrand);
	}
	/*@Then("Navigate1 to brand settings")
    public void navigate_to_brand_settings() {
		storestng.clickOnSettings();
		brandstng.selectBrandSettings();
    	
    }*/
    @And("Select1 brand {string}")
    public void Select_brand(String brandName) {
    	brandstng.selectBrand(brandName);
    }
    @Given("select {string} to disable1")
    public void select_to_disable1(String ServiceName1) {
    	brandstng.selectServiceCheckBox(ServiceName1);
    }
    @When("Select {string} to disable2")
    public void select_to_disable2(String ServiceName2) {
    	brandstng.selectServiceCheckBox(ServiceName2);
    }
    @And ("{string} services should be available")
    public void service_should_be_available(String StatusOfService) throws InterruptedException {
    	brandstng.enableOrDisable(StatusOfService);
    	
    }
    @When ("Select disabled1 service {string}")
    public void select_disabled1_service(String ServiceName1) {
    	brandstng.selectServiceCheckBox(ServiceName1);
    }
    @When("Select disabled2 service {string}")
    public void select_disabled2_service(String ServiceName2) {
    	brandstng.selectServiceCheckBox(ServiceName2);
    }
    @Then("click on1 {string}")
    public void click_on1(String StatusOfService) throws InterruptedException {
    	brandstng.enableOrDisable(StatusOfService);
    }
	
    
}