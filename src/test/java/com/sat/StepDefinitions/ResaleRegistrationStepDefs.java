package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ResaleRegistrationStepDefs {

	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("user naviagtes to login page {string} and click on Create an account link")
	public void user_naviagtes_to_login_page_and_click_on_Create_an_account_link(String url1) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.createAccount();
	}

	@And("check create account page should have required fields")
	public void check_create_account_page_should_have_required_fields() throws InterruptedException {
		resalregister.verifyFields();
	}

	@And("enter all the mandatory fileds {string} and  {string} and {string} and {string} and {string} and {string} and {string} in the page")
	public void enter_all_the_mandatory_fileds_and_and_and_and_and_and_in_the_page(String email, String fname,
			String lname, String phonenumber, String address, String postalcode, String city) {
		resalregister.fillRegistrationFormDetails(email, fname, lname, phonenumber, address, postalcode, city);
	}

	@And("click on Continue")
	public void click_on_Continue() {
		resalregister.continuetonextpage();
	}

	@Then("remove created seller {string}")
	public void remove_created_seller(String user1) throws InterruptedException {
		//TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.loginResalePortal(user1, config.getTemporaryPassword());
		resalregister.clickonsignin();
		resalregister.deleteSeller();
	}
}
