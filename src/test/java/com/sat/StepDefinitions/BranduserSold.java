package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResalRegisterItemPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BranduserSold {
	public WebDriver driver;

	private ResaleAdminPage manageruser = new ResaleAdminPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
	private ResalRegisterItemPage registerpage = new ResalRegisterItemPage(TestBase.getDriver());

	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@Given("User login to Resale app with admin credentials")
	public void User_login_to_Resale_app_with_admin_credentials() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageruser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}

	@And("naviagte to manager users section")
	public void navigate_to_manager_users_section() {
		manageruser.goToManageusers();
		// manageruser.signOut();

	}

	@And("search with {string} and select role to {string} and save it")
	public void search_with_and_select_role_to_and_save_it(String searchtext, String role) throws InterruptedException {
		manageruser.userSelection(searchtext, role);
		

	}

	@When("user navigating to Resaleportal app {string} with valid credentials {string},{string} and signin")
	public void user_navigating_to_Resaleportal_app_with_valid_credentials_and_signin(String url1, String user1,
			String pwd) throws InterruptedException {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalepagelogin.loginResalePortal(config.getResalePortaluserId(user1), config.getResalePortalpassword(pwd));
		resalepagelogin.clickonsignin();
	}

	@And("click on Registeryouritems and enter below fields {string},{string},{string},{string},{string},{string} and Submit")
	public void click_on_Registeryouritems_and_enter_below_fields_and_Submit(String Store_Name, String Brand,
			String Category, String Condition, String Material, String Unsolditem) throws InterruptedException {
		registerpage.registerItem();
		registerpage.selectValues(Store_Name, Brand, Category, Condition, Material, Unsolditem);
		registerpage.Submit();
	}

	@And("user navigating to Resaleportal portal with valid credentials and signin")
	public void user_navigating_to_Resaleportal_portal_with_valid_credentials_and_signin() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
	}

	@And("select add button and serach for existing seller {string}")
	public void select_add_button_and_serach_for_existing_seller(String existingUser) throws InterruptedException {
		//resalelogin.selectExistingSeller(existingUser);
	}

	@And("select the both the checkboxes and enter the {string} and save it")
	public void select_the_both_the_checkboxes_and_enter_the_and_save_it(String iban) throws InterruptedException {
		resalelogin.fillingIBANNumber(config.getIban(iban));
	}

	@And("go to Items tab and open the item which we have craeted")
	public void go_to_Items_tab_and_open_the_item_which_we_have_craeted() throws AWTException {
		resalelogin.itemsTab();
	}

	@And("fill the manadatroy fileds {string},{string},{string} and save it")
	public void fill_the_manadatroy_fileds_and_save_it(String gender, String size, String price)
			throws InterruptedException {
		resalelogin.idGeneration();
		resalelogin.preregToInstore(gender, size, price);
	}

	@Then("save item to proceed sign agreement")
	public void save_item_to_proceed_sign_agreement() {
		resalelogin.signAgreement();
	}

}
