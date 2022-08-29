package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.ResalRegisterItemPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeclineItemStepDefs {
	
	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	private ResalRegisterItemPage registerpage = new ResalRegisterItemPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	private PowerAppsAutomateFlowPage job = new PowerAppsAutomateFlowPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());

	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	@When("User login to ResalePortal {string} with valid {string} and {string}")
	public void user_login_to_ResalePortal_with_valid_and(String url1, String user1, String password) throws InterruptedException {
		/*manageuser.signOut();
		TestBase.getDriver().manage().deleteAllCookies();*/
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getEmailUserid());
		gmail.enterPassword(config.getEmailPassword());
		gmail.unReadAllMails();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.loginResalePortal(config.getResalePortaluserId(user1),config.getResalePortalpassword(password));
		resalregister.clickonsignin();
	}

	@When("register an item with below fields {string},{string},{string},{string},{string},{string} and submit it")
	public void register_an_item_with_below_fields_and_submit_it(String Store_Name, String Brand, String Category, String Condition, String Material, String Unsolditem) throws InterruptedException {
		registerpage.registerItem();
		registerpage.selectValues(Store_Name, Brand, Category, Condition, Material, Unsolditem);
		registerpage.Submit();
	}

	@And("user can login to ResaleApp and search for {string},{string} and open the item {string} decline it")
	public void user_can_login_to_ResaleApp_and_search_for_and_open_the_item_decline_it(String existingUser, String tabSelection, String status) throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		resalelogin.selectExistingSeller(existingUser, tabSelection);	
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.declineAnItem();
	}
	
	@And("run the automatic cloudflow job for declineitem {string}")
	public void run_the_automatic_cloudflow_job_for_declineitem (String flowName) {
		//resalelogin.switchToParent();
		TestBase.getDriver().get(config.getPowerAppCloudFlow());
		job.runCloudFlow(flowName);
		//resalelogin.switchToOriginal();
	}
	@Then("decline email should sent with {string}")
	public void decline_email_should_sent_with(String subject) {
		//resalelogin.switchTab();
		TestBase.getDriver().get(config.getEmailUrl());
		//gmail.enterEmail(config.getEmailUserid());
		//gmail.enterPassword(config.getEmailPassword());
		//gmail.unReadAllMails();
		gmail.Validation(subject);
		//resalelogin.switchToOriginal();
	}

}
