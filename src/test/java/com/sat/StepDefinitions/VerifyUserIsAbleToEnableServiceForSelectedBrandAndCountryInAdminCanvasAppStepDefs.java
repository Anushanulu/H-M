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

public class VerifyUserIsAbleToEnableServiceForSelectedBrandAndCountryInAdminCanvasAppStepDefs {
	public WebDriver driver;
	
	private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	private GmailLoginPage  Gmail= new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	
	@Then("Select2 Country {string} and Brand {string}")
	public void select_Country_and_Brand(String selectCountry, String selectBrand) {
		StoreCalendars.setCountryAndBrand(selectCountry, selectBrand);
	}
	@Then("Navigate to country settings")
    public void navigate_to_brand_settings() {
		CountrySetting.navigateToCountrySettings();
    }
    @And("Select2 brand {string} and {string}")
    public void Select_brand(String NameOfTheBrand,String NameOfTheCountry) {
    	CountrySetting.SelectBrand(NameOfTheBrand);
    	CountrySetting.SelectCountry(NameOfTheCountry);
    }
    @Given("select1 {string} to disable")
    public void select_to_disable1(String ServiceName1) {
    	brandstng.selectServiceCheckBox(ServiceName1);
    }
    @When("Select2 {string} to disable")
    public void select_to_disable2(String ServiceName2) {
    	brandstng.selectServiceCheckBox(ServiceName2);
    }
   /* @And ("{string} services should be available1")
    public void service_should_be_available(String StatusOfService) throws InterruptedException {
    	CountrySetting.enableOrDisable(StatusOfService);
    	
    }*/
    @When ("Select1 disabled service {string}")
    public void select_disabled1_service(String ServiceName1) {
    	brandstng.selectServiceCheckBox(ServiceName1);
    }
    @When("Select2 disabled service {string}")
    public void select_disabled2_service(String ServiceName2) {
    	brandstng.selectServiceCheckBox(ServiceName2);
    }
    @Then("click on2 {string}")
    public void click_on1(String StatusOfService) throws InterruptedException {
    	CountrySetting.enableOrDisable(StatusOfService);
    }
	
    
	
}
