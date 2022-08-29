package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BrandSettingsPage;
import com.sat.Pages.CountrySettingsPage;
import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyUserIsSAbleToAddANewServiceAndViewServiceToStoreForSelectedBrandAndCountryInAdminCanvasApp {
public WebDriver driver;
	

private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	private GmailLoginPage  Gmail= new GmailLoginPage(TestBase.getDriver());
	private GmailLoginPage gmailLoginPage = new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	private PowerAppsAutomateFlowPage power = new PowerAppsAutomateFlowPage(TestBase.getDriver());

	@Then("Navigate to store settings")
	public void navigate_to_store_settings() {
		storestng.clickOnSettings();
		storestng.clickOnStoreSettings();
	}
	@Then("select the Store {string}")
	public void select_the_store(String storeName) {
		storestng.selectStoreCheckBox(storeName);
	}
	@Then("click on Add button and Ok button")
	public void click_on_Add_button_and_Ok_button() {
		CountrySetting.clickAdd();
		CountrySetting.clickOk();
	}
	@And("Validate success message")
	public void validate_success_message() {
		storestng.validateServiceAddedMsgInStoreLevel();
	}
	
}
