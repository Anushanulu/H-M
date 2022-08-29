package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
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

public class AdminExpToInstore2ndTry {

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private PowerAppsAutomateFlowPage job = new PowerAppsAutomateFlowPage(TestBase.getDriver());
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("user is able to launch ResaleApp with admin credentials and signin and selecting {string},{string},{string}")
	public void user_is_able_to_launch_ResaleApp_with_admin_credentials_and_signin_and_selecting(String brand,
			String country, String store) throws InterruptedException {
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getEmailUserid());
		gmail.enterPassword(config.getEmailPassword());
		gmail.unReadAllMails();
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		// manageuser.selectedStore(brand, country, store);
	}

	@When("searching with the existing seller {string},{string}")
	public void searching_with_the_existing_seller(String existingUser, String tabSelection)
			throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser, tabSelection);
	}

	@And("clickng on Add Item button and enter {string}, select {string} and click Next button and enter sign save it")
	public void clickng_on_Add_Item_button_and_enter_select_and_click_Next_button_and_enter_sign_save_it(
			String noOfItems, String unsoldItem) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.addPendingItem(noOfItems, unsoldItem);
	}

	@And("clickng on {string} item and generate unique id by clicking on edit button and save it")
	public void clickng_on_item_and_generate_unique_id_by_clcking_on_edit_button_and_save_it(String status)
			throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.idGeneration();
	}

	@And("clickng on {string} and fil details {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and save it")
	public void clickng_on_and_fil_details_and_save_it(String status, String brand, String gender, String category,
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

	@And("user is open the created item {string} and update the end of line item date with todays date as {string},{string},{string}")
	public void user_is_open_the_created_item_and_update_the_end_of_line_item_date_with_todays_date_as(String status,
			String year, String month, String date) throws InterruptedException {
		resalelogin.openItem(status);
		resalelogin.calendarSelection(year, month, date);
		resalelogin.pendingSave();
		resalelogin.donePendingItem();
	}

	@And("run the cloudflow job {string}")
	public void run_the_cloudflow_job(String flowName) {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getPowerAppCloudFlow());
		job.runCloudFlow(flowName);
		resalelogin.switchToOriginal();
	}

	@And("navigating to {string},{string} open the {string} item and update the item to {string}")
	public void navigating_to_open_the_item_and_update_the_item_to(String existingSeller, String tabSelection,
			String status, String updatedStatus) throws InterruptedException {
		resalelogin.refresh();
		resalelogin.selectExistingSeller(existingSeller, tabSelection);
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.displayStatus(status);
		resalelogin.updateStatusFrmDropdown(updatedStatus);
		resalelogin.pendingSave();
		resalelogin.donePendingItem();
	}

	@And("run the automatic cloudflow job for instore2ndtry {string}")
	public void run_the_automatic_cloudflow_job_for_instore2ndtry(String flowName) {
		// resalelogin.switchTab();
		resalelogin.switchToChild();
		TestBase.getDriver().get(config.getPowerAppCloudFlow());
		job.runCloudFlow(flowName);
		resalelogin.switchToOriginal();
	}

	@And("navigating to {string} tab and check the item count")
	public void navigating_to_tab_and_check_the_item_count(String tab) throws InterruptedException {
		resalelogin.refresh();
		resalelogin.itemsCount(tab);
	}

	@Then("user will receive extend email as {string}")
	public void user_will_receive_extend_email_as(String subject) throws InterruptedException {
		resalelogin.switchToChild();
		TestBase.getDriver().get(config.getEmailUrl());
		// gmail.enterEmail(config.getEmailUserid());
		// gmail.enterPassword(config.getEmailPassword());
		// gmail.unReadAllMails();
		gmail.Validation(subject);
		// resalelogin.switchToOriginal();
	}
}
