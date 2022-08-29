package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateAllInfoStoreusrStepDefs {

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	@Given("User is login to Resale app with admin credentials")
	public void user_is_login_to_Resale_app_with_admin_credentials() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}

	@And("search with existing seller {string},{string}")
	public void search_with_existing_seller(String existingUser, String tabSelection) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser, tabSelection);
	}

	@And("click on AddItem button and enter {string}, select {string} and click Next button and enter sign save it")
	public void click_on_AddItem_button_and_enter_select_and_click_Next_button_and_enter_sign_save_it(String noOfItems, String unsoldItem) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.addPendingItem(noOfItems, unsoldItem);
	}
	
	@And("naviagte to manager users section and search with {string} and select {string} and save it")
	public void naviagte_to_manager_users_section_and_search_with_and_select_and_save_it(String searchtext, String role) throws InterruptedException {
		manageuser.goToManageusers();
		manageuser.userSelection(searchtext, role);
		manageuser.save();
		manageuser.validateMsg();
		manageuser.signOut();
	}
	
	@And("user launch ResaleApp with valid credentials and signin and selecting {string},{string},{string}")
	public void user_launch_ResaleApp_with_valid_credentials_and_signin_and_selecting(String brand, String country, String store) throws InterruptedException {
		TestBase.getDriver().manage().deleteAllCookies();
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
		manageuser.selectedStore(brand, country, store);
	}

	@Then("click on {string} and check {string} field is disable")
	public void click_on_and_check_field_is_disable(String status,String price) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.priceSelection(price);
	}
}
