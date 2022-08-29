package com.sat.StepDefinitions;

import java.util.List;
import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SingleItemToOtherStoreStepDefs {

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@And("enter  {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and save it")
	public void enter_and_save_it(String brand, String gender, String category, String size, String condition,
			String material, String price, String store, String year, String month, String date, String unsoldItem)
			throws InterruptedException {
		resalelogin.brandSelection(brand);
		resalelogin.genderSelection(gender);
		resalelogin.categorySelection(category);
		resalelogin.sizeSelection(size);
		resalelogin.conditionSelection(condition);
		resalelogin.materialSelection(material);
		resalelogin.priceSelection(price);
		resalelogin.storeSelection(store);
		resalelogin.calendarSelection(year, month, date);
		resalelogin.unsoldItemSelection(unsoldItem);
		resalelogin.pendingSave();
	}
	
	@And("open the {string} item and sign the agreeemnt")
	public void open_the_item_and_sign_the_agreeemnt(String status) throws InterruptedException {
		//resalelogin.openItem(status);
		resalelogin.signForPreregItem();
	}

	@And("click on cancel button and ok")
	public void click_on_cancel_button_and_ok() {
		resalelogin.clickOnCancel();
		resalelogin.okBtn();
	}
	@And("click on Done button")
	public void click_on_Done_button() {
		resalelogin.clickOnDone();
	}

	@And("click on refresh button on right side of screen")
	public void click_on_refresh_button_on_right_side_of_screen() {
		resalelogin.refreshRightSideScreen();
	}

	@And("collect the Items id for items for {string}")
	public void collect_the_Items_id_for_items_for(String store,DataTable testdata) throws InterruptedException {
		resalelogin.singleStatusSelection(store,testdata);
	}
	@And("collect the Items id for items")
	public void collect_the_Items_id_for_items(DataTable testdata) throws InterruptedException {
		resalelogin.multiStatusSelection(testdata);
	}

	@And("{string} for the selected items")
	public void for_the_selected_items(String store) {
		resalelogin.changeStore(store);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("validate that item got changed to new store {string},{string},{string}")
	public void validate_that_item_got_changed_to_new_store(String brand, String country, String store) throws InterruptedException {
		resalelogin.validationOfStores(brand, country, store);

	}
}