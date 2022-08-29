package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BrandusrNotSeenAdminStepDefs {
	
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("user launch ResaleApp with admin credentials and signin and selecting {string},{string},{string}")
	public void user_launch_ResaleApp_with_admin_credentials_and_signin_and_selecting(String brand, String country, String store) throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		manageuser.selectedStore(brand, country, store);
	}

	@And("go to manage users section and search with {string} and select role to {string} and save it")
	public void go_to_manage_users_section_and_search_with_and_select_role_to_and_save_it(String searchtext, String role) throws InterruptedException {
		manageuser.goToManageusers();
		manageuser.userSelection(searchtext, role);
		manageuser.save();
		manageuser.validateMsg();
		manageuser.signOut();
	}

	@And("user login to ResaleApp and selecting {string},{string},{string}")
	public void user_login_to_ResaleApp_and_selecting(String brand, String country, String store) throws InterruptedException {
		TestBase.getDriver().manage().deleteAllCookies();
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
		manageuser.selectedStore(brand, country, store);
	}

	@And("naviagting to manage users section and search with {string}")
	public void naviagting_to_manage_users_section_and_search_with(String user) {
		manageuser.goToManageusers();
		manageuser.roleAccess(user);
	}
}
