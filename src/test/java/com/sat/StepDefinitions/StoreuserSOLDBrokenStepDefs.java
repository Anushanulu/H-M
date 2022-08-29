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

public class StoreuserSOLDBrokenStepDefs {

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("user login to ResaleApp with admin credentials and signin and selecting {string},{string},{string}")
	public void user_login_to_ResaleApp_with_admin_credentials_and_signin_and_selecting(String brand, String country, String store) throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		manageuser.selectedStore(brand, country, store);
	}

	@When("search with existing seller {string},{string} and click on Add Item button and enter {string}, select {string} and click Next button and enter sign save it")
	public void search_with_existing_seller_and_click_on_Add_Item_button_and_enter_select_and_click_Next_button_and_enter_sign_save_it(String existingUser, String tabSelection, String noOfItems, String unsoldItem) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser, tabSelection);
		resalelogin.itemsTab();
		resalelogin.addPendingItem(noOfItems, unsoldItem);
	}
	

	@Given("click the {string} item and generate unique id by clcking on edit button and save it")
	public void click_the_item_and_generate_unique_id_by_clcking_on_edit_button_and_save_it(String status) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.idGeneration();
	}

	@Given("click the {string} and fil details {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and save it")
	public void click_the_and_fil_details_and_save_it(String status, String brand, String gender, String category, String size, String condition, String material, String price, String store, String year, String month, String date, String unsoldItem) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.brandSelection(brand);
		resalelogin.genderSelection(gender);
		resalelogin.categorySelection(category);
		resalelogin.sizeSelection(size);
		resalelogin.conditionSelection(condition);
		resalelogin.materialSelection(material);
		resalelogin.priceSelection(price);
		resalelogin.storeSelection(store);
		resalelogin.calendarSelection(year, month, date);
		resalelogin.unsoldItemSelection(unsoldItem);
		resalelogin.pendingSave();
		resalelogin.donePendingItem();
	}

	@Given("naviagte to manage users section and search for {string} and select role to {string} and save it")
	public void naviagte_to_manage_users_section_and_search_for_and_select_role_to_and_save_it(String searchtext, String role) throws InterruptedException {
		manageuser.goToManageusers();
		manageuser.userSelection(searchtext, role);
		manageuser.save();
		manageuser.validateMsg();
		manageuser.signOut();
	}

	@Then("user logging into ResaleApp and search for {string},{string} update created item {string} to {string}")
	public void user_logging_into_ResaleApp_and_search_for_update_created_item_to(String existingSeller, String tabSelection, String status, String Updatedstatus) throws InterruptedException {
		TestBase.getDriver().manage().deleteAllCookies();
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
		resalelogin.selectExistingSeller(existingSeller, tabSelection);
		resalelogin.itemsTab();
		resalelogin.updateStatus(status,Updatedstatus);
	}




}
