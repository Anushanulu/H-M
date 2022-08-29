package com.sat.StepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResalPortalForgotPwdStepDefs {

	private ResaleLoginPage loginpage = new ResaleLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());

	@Given("User navigating to login page {string}")
	public void user_navigating_to_login_page(String url1) throws InterruptedException {
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getEmailUserid());
		gmail.enterPassword(config.getEmailPassword());
		gmail.unReadAllMails();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
	}

	@Then("click on forgot password link")
	public void click_on_forgot_password_link() {
		loginpage.clickOnforgotPassword();
	}

	@When("enter email id {string} and click on Reset button")
	public void enter_email_id_and_click_on_Reset_button(String user1) {
		loginpage.validateResetbtn(config.getResalePortaluserId(user1));
	}

	@Then("success message should dispaly")
	public void success_message_should_dispaly() {
		loginpage.validateSuccessMessage();
	}

	@And("An email sent to register email address with subject as {string}")
	public void an_email_sent_to_register_email_address_with_subject_as(String subject) throws InterruptedException {
		resalelogin.switchToActiveTab();
		TestBase.getDriver().get(config.getEmailUrl());
		//gmail.enterEmail(config.getEmailUserid());
		//gmail.enterPassword(config.getEmailPassword());
		//gmail.unReadAllMails();
		//loginpage.promotionTab();
		gmail.Validation(subject);
		
		//resalelogin.switchToOriginal();
	}
	@And("click on Reset passowrd and update it")
	public void click_on_Reset_passowrd_and_update_it() {
		resalelogin.switchToChild();
		loginpage.resetPwd();
	}
	
	
}
