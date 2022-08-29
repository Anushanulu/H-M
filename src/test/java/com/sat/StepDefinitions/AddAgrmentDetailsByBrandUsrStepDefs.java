package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddAgrmentDetailsByBrandUsrStepDefs {

	ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@And("check the brand value is matching with the selected {string}")
	public void check_the_brand_value_is_matching_with_the_selected(String brand) {
		resalelogin.displayBrand(brand);
	}

	@Then("click on add agreeemnt button and check that brand value is displaying")
	public void click_on_add_agreeemnt_button_and_check_that_brand_value_is_displaying() {
		resalelogin.agreement();
	}

}
