package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderSellerDetailsStepDefs {
	

	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	
	@Given("user launches ResaleApp with valid credentials and signin")
	public void user_launches_ResaleApp_with_valid_credentials_and_signin() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}

	@When("selects {string},{string},{string} and go to {string}")
	public void selects_Drottninggatan_and_go_to(String brand, String country, String store, String tabSelection) throws InterruptedException {
		manageuser.selectedStore(brand, country, store);
		//resalelogin.selectExistingSeller(existingUser, tabSelection);
		resalelogin.tabSelection(tabSelection);
	}

	@And("Verify SHOW ALL SELLERS link and click on the same and navigate to Seller Name column and check sellers are displaying in alphabetical order")
	public void verify_SHOW_ALL_SELLERS_link_and_click_on_the_same_and_navigate_to_Seller_Name_column_and_check_sellers_are_displaying_in_alphabetical_order() {
		resalelogin.orderSellers();
	}


}
