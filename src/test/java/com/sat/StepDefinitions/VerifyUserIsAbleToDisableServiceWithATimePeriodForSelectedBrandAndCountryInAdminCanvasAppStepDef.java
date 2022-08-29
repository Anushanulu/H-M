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

public class VerifyUserIsAbleToDisableServiceWithATimePeriodForSelectedBrandAndCountryInAdminCanvasAppStepDef {
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
		
		/*@Then("Select Country {string} and Brand {string}")
		public void select_Country_and_Brand(String selectCountry, String selectBrand) {
			StoreCalendars.setCountryAndBrand(selectCountry, selectBrand);
		}*/
		
	    @When("Select brand {string} and {string}")
	    public void select_brand_and(String NameOfTheBrand,String NameOfTheCountry) {
	    	CountrySetting.SelectBrand(NameOfTheBrand);
	    	CountrySetting.SelectCountry(NameOfTheCountry);
	    }
	   /* @And("select enabled2 {string}")
	    public void select_enabled2(String ServiceName) {
	    	brandstng.selectService(ServiceName);
	    }*/
	    @Then("click on Add Time Period2")
	    public void click_on_Add_Time_Period2() {
	    	brandstng.addTimePeriod();
	    }
	    @Then("input1 {string} {string} {string} {string} {string} and {string}")
	    public void input1_and(String fmDate,String fmYear,String fmMonth,String tDate,String tYear,String tMonth) {
	    	brandstng.selectFromDateAndToDate(fmDate,fmYear,fmMonth, tDate,tYear,tMonth);
	    }
	   /* @And("click on apply1 and ok")
	    public void click_on_apply1_and_ok() {
	    	brandstng.clickOnApply();
	    }*/
	    @Then("click on remove and validate time period is removed")
	    public void click_on_remove_and_validate_time_period_is_removed() {
	    	brandstng.clickOnRemove();
	    }

	
}
