package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class AddB2BSeller {
	
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@And("go to {string}")
	public void go_to(String tabName) {
		resalelogin.tabSelection(tabName);
	}

	@And("click on Add B2B sller button and enter the {string} and save it")
	public void click_on_Add_B2B_sller_button_and_enter_the_and_save_it(String Name) {
		resalelogin.addB2BSeller(Name);
		//resalelogin.donePendingItem();
	}
}
