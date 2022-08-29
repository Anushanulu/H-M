package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.BookingPortalPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BookASlotStepDefs {

	private BookingPortalPage bookingPortal = new BookingPortalPage(TestBase.getDriver());
	private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	
	@And("click on book a slot button")
	public void click_on_book_a_slot_button() {
		resalepagelogin.bookASlot();
	}
	/*@Then("Check and click on the store {string}")
	public void check_and_click_on_the_store(String storeName) {
		bookingPortal.checkStoreAndClickOnIt(storeName);
	}

	@And("validate the date format")
	public void vlaidate_the_date_formate() throws InterruptedException {
		bookingPortal.validateDateFormat();
	}

	@And("selct the time slot which is enable {string}")
	public void select_the_time_slot_which_is_enable(String bookingSlotTime) {
		bookingPortal.checkEnabledSlotAndClickOnIt(bookingSlotTime);
	}

	@Then("enter required contact details {string} {string} {string} {string} {string} {string}")
	public void enter_required_contact_details(String contactName, String contactEmail, String contactMobile,
			String contactAddress, String contactPostcode, String contactCity) {
		bookingPortal.enterContactDetails(contactName, contactEmail, contactMobile, contactAddress, contactPostcode,
				contactCity);
	}

	@Then("validate contact fields {string} {string} {string} {string} {string}")
	public void validate_contact_fields(String Name, String Email, String phoneno, String address, String helpmail)
			throws InterruptedException {
		bookingPortal.validateContactDetails(Name, Email, phoneno, address, helpmail);
	}

	@Then("click on done")
	public void click_on_done() {
		bookingPortal.clickOnDone();
	}*/

}
