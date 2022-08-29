package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminMissingBrokenUnsoldarchieveStepDefs {

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private PowerAppsAutomateFlowPage job = new PowerAppsAutomateFlowPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("user able to launch ResaleApp with admin credentials and signin and selecting {string},{string},{string}")
	public void user_able_to_launch_ResaleApp_with_admin_credentials_and_signin_and_selecting(String brand,
			String country, String store) throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		manageuser.selectedStore(brand, country, store);
	}

	@When("searching for the existing seller {string},{string}")
	public void searching_for_the_existing_seller(String existingUser, String tabSelection)
			throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser, tabSelection);
	}

	@And("click on Add Item button and enter {string}, select {string} and click Next button and enter sign save it")
	public void click_on_Add_Item_button_and_enter_select_and_click_Next_button_and_enter_sign_save_it(String noOfItems,
			String unsoldItem) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.addPendingItem(noOfItems, unsoldItem);
	}

	@And("click on {string} item and generate unique id by clcking on edit button and save it")
	public void click_on_item_and_generate_unique_id_by_clcking_on_edit_button_and_save_it(String status)
			throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.idGeneration();
	}

	@And("click on {string} and fil details {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and save it")
	public void click_on_and_fil_details_and_save_it(String status, String brand, String gender, String category,
			String size, String condition, String material, String price, String store, String year, String month,
			String date, String unsoldItem) throws InterruptedException {
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

	@And("user open the created item {string} and update the end of line item date with todays date as {string},{string},{string}")
	public void user_open_the_created_item_and_update_the_end_of_line_item_date_with_todays_date_as(String status,
			String year, String month, String date) throws InterruptedException {
		resalelogin.openItem(status);
		resalelogin.calendarSelection(year, month, date);
		resalelogin.pendingSave();
	}

	@And("run the cloudflow {string}")
	public void Update_the_and_run_the_cloudflow(String flowName) throws InterruptedException {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getPowerAppCloudFlow());
		job.runCloudFlow(flowName);
		resalelogin.switchToOriginal();
	}
	
	
	@And("open the created item {string} and update the item to {string}")
	public void open_the_created_item_and_update_the_item_to(String status, String updatedStatus) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.displayStatus(status);
		resalelogin.updateStatusFrmDropdown(updatedStatus);
		resalelogin.pendingSave();
	}

	@Then("go to {string},{string} open the {string} item and update the item to {string}")
	public void go_to_open_the_item_and_update_the_item_to(String existingSeller, String tabSelection, String status,
			String updatedStatus)

			throws InterruptedException {
		resalelogin.refresh();
		resalelogin.selectExistingSeller(existingSeller, tabSelection);
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.displayStatus(status);
		resalelogin.updateStatusFrmDropdown(updatedStatus);
		resalelogin.pendingSave();
		// resalelogin.displayStatus();
	}
	
}
