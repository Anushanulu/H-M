package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IBANnumValidationStpDefs {
	public WebDriver driver;

	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());

	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();	
	@Given("user go to login page {string} and click on Create an account link")
	public void user_go_to_login_page_and_click_on_Create_an_account_link(String url1) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.createAccount();
	}

	@And("enter the mandatory fileds {string} and  {string} and {string} and {string} and {string} and {string} and {string} in the page")
	public void enter_the_mandatory_fileds_and_and_and_and_and_and_and_in_the_page(String email,
			String fname, String lname, String phonenumber, String address, String postalcode, String city) {
		resalregister.fillRegistrationFormDetails(email, fname, lname, phonenumber, address, postalcode, city);;
	}

	@And("click on Continue button")
	public void click_on_Continue_button() {
		resalregister.continuetonextpage();
	}

	@When("user navigating to ResaleApp with valid credentials and signin")
	public void user_navigating_to_ResaleApp_with_valid_credentials_and_signin() throws InterruptedException {
		/*TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());*/
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}
	
	@When("select {string},{string},{string}")
	public void select(String brand, String country, String store) throws InterruptedException {
	    manageuser.selectedStore(brand,country,store);
	}

	@And("search for existing seller {string},{string}")
	public void serach_for_existing_seller(String existingUser, String tabSelection) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser,tabSelection);
	}
	
	@And("select checkboxes and give {string} and save it")
	public void select_checkboxes_and_give_and_save_it(String iban) throws InterruptedException {
		resalelogin.empAndBankChkbox();
		resalelogin.fillingIBANNumber(config.getIban(iban));
		
	}

	@And("select the both of the checkboxes and enter the {string} and save it")
	public void select_the_both_of_the_checkboxes_and_enter_the_and_save_it(String iban) throws InterruptedException {
		//resalelogin.empAndBankChkbox();
		resalelogin.fillingIBANNumber(config.getIban(iban));
	}
	@And("validate the IBAN number {string}")
	public void validate_the_IBAN_number(String iban) {
		resalelogin.IBANnumValidation(config.getIban(iban));
		resalelogin.signAgreement();
	}

	@Then("Login to Resalepportal {string},{string} and delete the created seller")
	public void login_to_Resalepportal_and_delete_the_created_seller(String url1, String user1) throws InterruptedException {
		config.refresh();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		//String password=config.getResalePortalpassword(user1);
		resalepagelogin.loginResalePortal(user1,config.getTemporaryPassword());
		resalepagelogin.clickonsignin();
		resalepagelogin.deleteSeller();
	}
}
