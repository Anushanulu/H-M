package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.ResaleAppLoginPage;

import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResaleAppLoginStepDefs {
	public WebDriver driver;

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("navigates to Resalelogin page with valid credentials and signin")
	public void navigates_to_Resalelogin_page_with_valid_credentials_and_signin() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
	}

	@When("select add button and serach for the existing seller {string}, {string}")
	public void select_add_button_and_serach_for_the_existing_seller(String existingUser,  String tabSelection) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser,tabSelection);
	}

	@Then("click on save")
	public void click_on_save() {
		resalelogin.signAgreement();

	}

}