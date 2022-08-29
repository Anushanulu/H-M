package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewRelevantStoresStepDefs {
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	@Given("User login to Resaleapp with admin credentials")
	public void user_login_to_Resaleapp_with_admin_credentials() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}

	@When("select {string},{string},{string} and can able to see specific store which they selected")
	public void select_and_can_able_to_see_specific_store_which_they_selected(String brand, String country, String store) throws InterruptedException {
		
	    manageuser.selectedStore(brand,country,store);
	}
	
	
	



}
