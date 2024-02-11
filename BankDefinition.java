package com.stepDefinitions;

import java.util.List;

import com.configurations.GlobaController;
import com.model.BankModel;
import com.pageObjects.BankPage;
import com.pageObjects.BankPage;
import com.pageObjects.CommonPageService;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankDefinition {
	
	BankPage itp;
	List<BankModel> testdata;
	List<BankModel> temptestdata;
	CommonPageService cp;

	@SuppressWarnings({ "null", "unchecked" })
	public BankDefinition() throws Exception {
		System.out.println("Bank Started");
		itp = new BankPage(GlobaController.driver);
		cp = new CommonPageService(GlobaController.driver);
		testdata = itp.getScenarioTestData("Masters", "Bank");
	}

	// Existing Records Clear

	@Given("clear existing records in bank master")
	public void clear_existing_records_in_bank_master() throws Exception {
		
		itp.deleteBankMasterRecord(testdata);

	}

	// Maker

	@When("the user clicks bank master")
	public void the_user_clicks_bank_master() throws InterruptedException {
		
		itp.openBankMenu();
	}

	@Then("the user should see the bank master page")
	public void the_user_should_see_the_bank_master_page() throws Throwable {
		
		itp.verifyBankScreenIsOpened();
	}

	@When("the user enters values in the respective bank fields for pendingactions")
	public void the_user_enters_values_in_the_respective_bank_fields_for_pendingactions()
			throws Throwable {

		itp.enterValuesInBankMasterAddMode(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Approve"));

	}

	@When("the user enters values in the respective bank fields for draft")
	public void the_user_enters_values_in_the_respective_bank_fields_for_draft() throws Throwable {

		itp.enterValuesInBankMasterAddMode(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Reject"));

	}

	@Then("the user enters bank vaild text in search at pending actions")
	public void the_user_enters_bank_vaild_text_in_search_at_pending_actions() throws Exception {

		itp.enterBankValueInPendingActionsSearch(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Reject"));

	}

	@When("the user changes values in the respective bank pending actions fields")
	public void the_user_changes_values_in_the_respective_bank_pending_actions_fields()
			throws Exception {

		itp.enterValuesInBankMasterAddMode(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "UpdatePendingRecord"));

	}

	// Checker

	@And("select others pending record in bank master{string}")
	public void select_others_pending_record_in_bank_Master(String scenario) throws Exception {

		temptestdata = itp.getSpecificUserAndScenarioTestData(testdata, "Maker", scenario);
		cp.filterPendingrecord(temptestdata.get(0).getBankCode());

	}

	// Both

	@When("the user enters valid text in bank global search")
	public void the_user_enters_valid_text_in_bank_global_search() throws Exception {
		
		temptestdata = itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Approve");
		cp.enterValueinSearch(temptestdata.get(0).getBankCode());
	}

	@When("the user double clicks on a record in bank global search")
	public void the_user_double_clicks_on_a_record_in_bank_global_search() throws Exception {
		
		temptestdata = itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Approve");
		cp.verifyAndOpenDataInGlobalSearch(temptestdata.get(0).getBankCode());
	}

	@When("the user changes all values in the respective bank global search fields")
	public void the_user_changes_all_values_in_the_respective_bank_global_search_fields()
			throws Exception {

		itp.editBankValuesFromGlobalSearch(itp.getSpecificUserAndScenarioTestData(testdata, "Global", "UpdateExistingRecord"));

	}

	@When("^the user enters values in the bank fields for both user$")
	public void the_user_enters_values_in_the_bank_fields_for_both_user() throws Throwable {

		itp.enterValuesInBankMasterAddMode(itp.getSpecificUserAndScenarioTestData(testdata, "Both", "Own Request"));

	}

	@When("the user clicks bank rejected records checkbox")
	public void the_user_clicks_bank_rejected_records_checkbox() {
		
		itp.clickBankRejectedRecordCheckBox();
	}

	@Then("the user enters bank rejected record in search at pending actions")
	public void the_user_enters_bank_rejected_record_in_search_at_pending_actions() throws Exception {

		itp.enterBankValueInPendingActionsSearch(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "UpdatePendingRecord"));

	}

	@When("the user changes all values in the respective bank rejected record search fields")
	public void the_user_changes_all_values_in_the_respective_bank_rejected_record_search_fields()
			throws Exception {

		itp.enterValuesInBankMasterAddMode(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Reject"));

	}

	@When("the user enters all vaild details in bank master advanced search page")
	public void the_user_enters_all_vaild_details_in_bank_master_advanced_search_page()
			throws Exception {

		itp.enterBankCodeInAdvancedSearch(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Approve"));
		itp.enterBankNameInAdvancedSearch(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Approve"));
		itp.enterBankShortNameInAdvancedSearch(itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Approve"));
		
	}

	@Then("the user should validate bank advanced search page records")
	public void the_user_should_validate_bank_advanced_search_page_records() throws Exception {
		
		temptestdata = itp.getSpecificUserAndScenarioTestData(testdata, "Maker", "Approve");
		cp.verifyDataInAdvancedSearch(temptestdata.get(0).getBankCode());

	}

	// Screen Close

	@Then("the user close bank master tab")
	public void the_user_close_bank_master_tab() {

		itp.clickBankCloseTab();
	}

}
