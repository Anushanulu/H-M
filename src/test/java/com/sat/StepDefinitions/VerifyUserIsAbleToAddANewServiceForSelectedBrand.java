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

public class VerifyUserIsAbleToAddANewServiceForSelectedBrand {
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
	
	
	@Then("Navigate to brand settings")
    public void navigate_to_brand_settings() {
		storestng.clickOnSettings();
		brandstng.selectBrandSettings();
    	
    }
    @And("Select brand {string}")
    public void Select_brand(String brandName) {
    	brandstng.selectBrand(brandName);
  	
    }
    @Then("Click on Add service")
    public void click_on_add_service() {
    	brandstng.clickOnAddService();
    	
    }
    @Then("Enable status toggle button should be {string}")
    public void enable_status_toggle_button_should_be_Enabled(String togglebtn) {
    	brandstng.selectToggleButton(togglebtn);	
    }
    
    @And("Specify display name {string} and {string}")
    public void spicify_dispay_name(String dispName, String APIName) {
    	brandstng.enterDisplayAndApiName(dispName, APIName);
    }
    @Then("Click on Add and Ok")
    public void click_on_add_and_ok() {
    	brandstng.clickAddAndOk();
    }
    @And("Verify the service {string} in the list")
    public void verify_the_service_in_the_list(String verifyDispalyName) {
    	brandstng.validateserviceaddedsucessfully();
    	brandstng.clickOnRefresh();
    	brandstng.verifyServiceAdd(verifyDispalyName);
    }
    

}
