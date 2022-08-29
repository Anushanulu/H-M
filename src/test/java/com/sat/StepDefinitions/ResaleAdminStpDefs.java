package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.ResaleAdminPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResaleAdminStpDefs {
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("User login to Resale portal admin credentials")
	public void User_login_to_Resale_portal_with_admin_credentials() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}

	@When("go to manager users section")
	public void go_to_manager_users_section() {
		manageuser.goToManageusers();
	}

	/*@When("search with {string} and select the {string} and save it")
	public void search_with_and_select_the_and_save_it(String searchtext, String role) throws InterruptedException  {
		manageruser.user_Selection(searchtext, role);
	    
	}*/
	@When("search with {string} and select the {string},{string},{string},{string} and save it")
	public void search_with_and_select_the_and_save_it(String searchtext, String role, String brand, String country, String store) throws InterruptedException {
		manageuser.userSelection(searchtext, role);
		manageuser.selectBrand(brand);
		manageuser.selectCountry(country);
		manageuser.selectStore(store);
	}
	
	@Then("check user able to see success message")
	public void check_user_able_to_see_success_message() {
		manageuser.validateMsg();
	}

}
