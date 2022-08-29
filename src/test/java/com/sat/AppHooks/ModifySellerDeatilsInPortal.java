package com.sat.AppHooks;

import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResalRegisterItemPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ModifySellerDeatilsInPortal {

	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	ResalRegisterItemPage registerItem = new ResalRegisterItemPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("user navigating go to login page {string} and click on Create an account link")
	public void user_navigating_go_to_login_page_and_click_on_Create_an_account_link(String url1) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.createAccount();
	}

	@And("enter mentioned fileds {string} and  {string} and {string} and {string} and {string} and {string} and {string} in the page and click on Continue")
	public void enter_mentioned_fileds_and_and_and_and_and_and_in_the_page_and_click_on_Continue(String email,
			String fname, String lname, String phonenumber, String address, String postalcode, String city) {
		resalregister.fillRegistrationFormDetails(email, fname, lname, phonenumber, address, postalcode, city);
		resalregister.continuetonextpage();
	}

	@And("login to Resale portal {string} and enter {string} and password")
	public void login_to_Resale_portal_and_enter_and_password_then_navigate_to_Personal_Detials_tab_and_update_the_details_and_save_it(
			String url1, String user1) throws InterruptedException {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.loginResalePortal(user1, config.getTemporaryPassword());
		resalregister.clickonsignin();
	}

	@Then("navigate to Personal Detials tab and update the details {string},{string},{string},{string},{string},{string} and save it")
	public void navigate_to_Personal_Detials_tab_and_update_the_details_and_save_it(String fname, String lname,
			String mobnumber, String address, String pincode, String city) {
		registerItem.modifyDetilasInPortal(fname, lname, mobnumber, address, pincode, city);
		registerItem.modifiedDetailsPortalValidation(fname, lname, mobnumber, address, pincode, city);
	}

	@And("user launch the ResaleApp with valid credentials and signin and select {string},{string},{string}")
	public void user_launch_the_ResaleApp_with_valid_credentials_and_signin_and_select(String brand, String country,
			String store) throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		manageuser.selectedStore(brand, country, store);
	}

	@And("search for the existing seller {string},{string}")
	public void search_for_the_existing_seller(String existingUser, String tabSelection) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser, tabSelection);
	}
	 @And("valiadte the seller details in app {string},{string},{string},{string},{string},{string}")
	public void valiadte_the_seller_details_in_app(String fname, String lname,
			String mobnumber, String address, String pincode, String city) {
		 registerItem.modifiedDetailsAppValidation(fname, lname, mobnumber, address, pincode, city);
	 }

}
