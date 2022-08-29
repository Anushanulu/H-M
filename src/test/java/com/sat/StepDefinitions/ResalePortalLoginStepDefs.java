package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResalRegisterItemPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;
import org.testng.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ResalePortalLoginStepDefs {

	private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
	private ResalRegisterItemPage registerpage = new ResalRegisterItemPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());

	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@When("User navigates to ResalePortal {string} login page")
	public void user_navigates_to_ResalePortal_login_page(String url1) throws InterruptedException {
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getEmailUserid());
		gmail.enterPassword(config.getEmailPassword());
		gmail.unReadAllMails();
		// gmail.signout();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
	}

	@And("user enters valid ResalePortal {string} and {string}")
	public void user_enters_valid_ResalePortal_and(String user1, String password) throws InterruptedException {
		resalepagelogin.loginResalePortal(config.getResalePortaluserId(user1),
				config.getResalePortalpassword(password));
	}

	@And("click on signin")
	public void clic_on_signin() throws InterruptedException {
		resalepagelogin.clickonsignin();
	}

	@And("veify success msg with username {string}")
	public void veify_success_msg_with_username(String username) {
		resalepagelogin.validateLoginSuccMsg(username);
	}

	@And("click on Registeryouritems")
	public void click_on_registeritems() throws InterruptedException {
		registerpage.registerItem();
	}

	@And("user select or enter below fields {string},{string},{string},{string},{string},{string}")
	public void user_select_or_enter_below_fields(String Store_Name, String Brand, String Category, String Condition,
			String Material, String Unsolditem) throws InterruptedException {
		registerpage.selectValues(Store_Name, Brand, Category, Condition, Material, Unsolditem);
	}

	@And("click on registration Submit")
	public void click_on_registration_submit() {
		registerpage.Submit();
	}

	@And("user can view Thankyou Msg")
	public void user_can_view_Thankyou_msg() throws InterruptedException {
		registerpage.regiseteredMsg();
	}

	@And("click on Done and success msg with username {string}")
	public void click_on_Done_and_success_msg_with_username(String username) {
		registerpage.done();
		resalepagelogin.validateLoginSuccMsg(username);
	}

	@Then("confirmation email should sent with {string}")
	public void confirmation_email_should_sent_with(String subject) {
		resalepagelogin.switchTab();
		TestBase.getDriver().get(config.getEmailUrl());
		// gmail.enterEmail(config.getEmailUserid());
		// gmail.enterPassword(config.getEmailPassword());
		// gmail.unReadAllMails();
		gmail.Validation(subject);
		gmail.backBtn();
		resalepagelogin.switchToOriginal();
	}
	@And("check currently created {string} item is there in MyItems tab")
	public void check_currently_created_item_is_there_in_MyItems_tab(String status) {
		registerpage.myItemsTab();
		registerpage.currentTabValidation(status);
	}

	@And("cancel item which is register and check the cancellation email {string}")
	public void cancel_item_which_is_register_and_check_the_cancellation_email(String subject) {
		/*registerpage.myItemsTab();
		registerpage.currentTabValidation(subject);*/
		registerpage.cancelItems();
		resalepagelogin.switchTab();
		gmail.Validation(subject);
	}

}