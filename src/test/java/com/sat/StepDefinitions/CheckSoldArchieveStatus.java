package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckSoldArchieveStatus {
	
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private PowerAppsAutomateFlowPage job = new PowerAppsAutomateFlowPage(TestBase.getDriver());

	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@And("open the created item {string} to {string}")
	public void open_the_created_item_to(String status, String updatedStatus) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.updateStatusFrmDropdown(updatedStatus);
		resalelogin.pendingSave();
		//resalelogin.donePendingItem();
	}

	@And("run the job {string}")
	public void run_the_job(String flowName) {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getPowerAppCloudFlow());
		job.runCloudFlow(flowName);
		resalelogin.switchToOriginal();
	}
	@And("click on refresh button")
	public void click_on_refresh_button() {
		resalelogin.refresh();
		//resalelogin.refreshRightSideScreen();
	}

	@Then("open the created item {string} and check the status")
	public void open_the_created_item_and_check_the(String status) throws InterruptedException {
		//resalelogin.selectExistingSeller(existingSeller, tabSelection);
		resalelogin.itemsTab();
		resalelogin.validateStatusOfItem(status);
		resalelogin.openItem(status);
		resalelogin.displayStatus(status);
		resalelogin.pendingSave();
	}
}
