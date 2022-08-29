package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewItemResaleAppStepDefs {

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("user launching ResaleApp with valid credentials and signin")
	public void user_launching_ResaleApp_with_valid_credentials_and_signin() throws InterruptedException {
		/*TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getEmailUserid());
		gmail.enterPassword(config.getEmailPassword());
		gmail.unReadAllMails();*/
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}

	@When("selecting {string},{string},{string}")
	public void selecting(String brand, String country, String store) throws InterruptedException {
		manageuser.selectedStore(brand, country, store);
	}

	@And("searching for existing seller {string},{string}")
	public void searching_for_existing_seller(String existingUser, String tabSelection) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser, tabSelection);
		
	}

	@And("click on Add Item button and enter {string} and select {string} and click Next button and enter sign save it")
	public void click_on_Add_Item_button_and_enter_and_select_and_click_Next_button_and_enter_sign_save_it(
			String noOfItems, String unsoldItem) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.addPendingItem(noOfItems, unsoldItem);
	}

	@And("click on {string} item and generate id by clicking on edit button and save it")
	public void click_on_item_and_generate_id_by_clicking_on_edit_button_and_save_it(String status)
			throws InterruptedException, AWTException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.idGeneration();
		//resalelogin.removeItems();
		//resalelogin.removeForLoop();
		//resalelogin.countPages();
	}

	@Then("user will receive email as {string}")
	public void user_will_receive_email_as(String subject) {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getEmailUrl());
		//gmail.Validation(subject);
		resalelogin.switchToOriginal();
	}

	@And("click on {string} and enter  {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and save it")
	public void click_on_and_enter_and_save_it(String status, String brand, String gender, String category, String size,
			String condition, String material, String price, String store, String year, String month, String date,
			String unsoldItem) throws InterruptedException {
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
	}

	@And("open the created item {string} and update all details including price {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void open_the_created_item_and_update_all_details_including_price(String status, String brand, String gender,
			String category, String size, String condition, String material, String price, String store, String year,
			String month, String date, String unsoldItem) throws InterruptedException {
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

	@Given("naviagte to manage users section and search with {string} and select role to {string} and save it")
	public void naviagte_to_manage_users_section_and_search_with_and_select_role_to_and_save_it(String searchtext,
			String role) throws InterruptedException {
		manageuser.goToManageusers();
		manageuser.userSelection(searchtext, role);
		manageuser.save();
		manageuser.validateMsg();
		manageuser.signOut();
	}

	@Then("user login to ResaleApp and search for {string},{string} update created item {string} to {string}")
	public void user_login_to_ResaleApp_and_search_for_the_click_on_and_update_created_item_to(String existingSeller,
			String tabSelection, String status, String Updatedstatus) throws InterruptedException {
		TestBase.getDriver().manage().deleteAllCookies();
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
		resalelogin.selectExistingSeller(existingSeller, tabSelection);
		resalelogin.itemsTab();
		resalelogin.updateStatus(status, Updatedstatus);
	}

}
