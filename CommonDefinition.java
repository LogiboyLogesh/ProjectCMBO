package com.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.configurations.GlobaController;
import com.framework.CreateSessionService;
import com.framework.MessageProperties;
import com.model.GlobalStaticTestDataModel;
import com.pageObjects.CommonPageService;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonDefinition {
	
	CommonPageService cp;
	
	List testdata;
	
	public CommonDefinition() throws Exception
	{
		 cp=new CommonPageService(GlobaController.driver);
		 testdata=	(List) GlobalStaticTestDataModel.commontestdata;
		
	}



//	Draft Records Clear In Database

	@And("^clear the draft records of \"([^\"]*)\" in database$")
	public void clear_the_draft_records_of_something_in_database(String menuname) throws Throwable {

		cp.deleteDraftRecords(menuname);
	}

//	Pending Actions Records Clear In Database
	
	@And("^clear the pending records of \"([^\"]*)\" in database$")
	public void clear_the_pending_records_of_something_in_database(String menuname) throws Throwable {

		cp.deletePendingRecords(menuname);
	}

//	Click Master Menu

	@When("^the user clicks master menu$")
	public void the_user_clicks_master_menu() throws Throwable {

		cp.clickMasterMenu();

	}
	
//	Click Access Control Menu

	@When("^the user clicks accesscontrol menu$")
	public void the_user_clicks_accesscontrol_menu() throws Throwable {

		cp.clickAccessControlMenu();

	}
	
// Click Save Button	
	
	@And("^the user clicks save button$")
	public void the_user_clicks_save_button() throws Throwable {

		cp.clickSave();

	}
	
	@When("^the user clicks signout$")
	public void the_user_clicks_signout() throws Throwable {
		
		
		cp.clickSignout();
	}
	
	
// Record Saved For Approval Message
	
	@Then("the user validate the record saved for approval message")
	public void the_user_validate_the_record_saved_for_approval_message() throws InterruptedException {

		
		cp.verifySaveMessage(MessageProperties.get("MAKERSAVEREQUESTMESSAGE").toString());
	}
	

// Click Draft Button
	
	@And("^the user clicks saveasdraft button$")
	public void the_user_clicks_saveasdraft_button() throws Throwable {

		cp.clickSaveDraft();

	}
	
	
// Draft Saved Successfully Message
	
	
	@Then("the user validate the draft saved successfully message")
	public void the_user_validate_the_draft_saved_successfully_message() {
		
		cp.verifyDraftSaveMessage(MessageProperties.get("MAKERDRAFTREQUESTMESSAGE").toString());
		

	}	
	
// Draft Tab Button	
	
	@When("the user clicks draft button")
	public void the_user_clicks_draft_button() {

		cp.clickDraft();

	}
	
// Click Edit Button In Draft Page
	
	@When("the user clicks edit button in draft page")
	public void the_user_clicks_edit_button_in_draft_page() throws Exception {

		cp.clickDraftEditButton();

	}
	
// Pending Actions Tab Button
	
	@When("the user clicks pending actions")
	public void the_user_clicks_pending_actions() {

		cp.clickPendingActions();
	}
	
	
// Click Preview Button In Pending Actions
	
	@When("the user clicks preview button in pending actions")
	public void the_user_clicks_preview_button_in_pending_actions() {

		cp.clickPreviewButton();

	}
	
// Click Edit Button In Pending Actions And In Global Search
	
	@When("the user clicks edit button")
	public void the_user_clicks_edit_button() throws InterruptedException {

		cp.clickEdit();
	}
	

// Click Reject Button In Pending Actions
	
	@When("the user clicks Reject button")
	public void the_user_clicks_reject_button() {

		cp.clickRejectButton();
	}


// Enter Reason
	
	@When("the user enters reason")
	public void the_user_enters_reason() {

		cp.enterReasonForReject("Test");
	}

// Click Submit Button
	
	@When("the user clicks Submit button")
	public void the_user_clicks_submit_button() {

		cp.clickSubmitButton();
	}

	
// Record Rejected Successfully Message
	
	@Then("the user should validate Record rejected successfully message")
	public void the_user_should_validate_record_rejected_successfully_message() {

		cp.verifySaveMessage(MessageProperties.get("INDIVIDUALREJECTMESSAGE").toString());

	}
	
// Click X Button In Pending Actions
	
	@Then("the user clicks x button in pending actions")
	public void the_user_clicks_x_button_in_pending_actions() {
		
		cp.clickPendingActionCloseButton();
		
	}
	
	
// Click Approve Button In Pending Actions
	
	@When("the user clicks Approve button in checker")
	public void the_user_clicks_approve_button_in_checker() {

		cp.clickApproveButton();
	}
	

// Record Approved Successfully Message 
	
	@Then("the user should validate Record approved successfully message")
	public void the_user_should_validate_record_approved_successfully_message() {

		cp.verifySaveMessage(MessageProperties.get("INDIVIDUALAPPROVEMESSAGE").toString());
	}
	

// Click Advanced Search Button
	
	@When("the user clicks advancedsearch button")
	public void the_user_clicks_advancedsearch_button() throws InterruptedException {

		cp.clickAdvancedSearch();

	}


// Click Search Button
	
	@When("the user clicks search button")
	public void the_user_clicks_search_button() throws InterruptedException {

		cp.clickAdvancedPageSearch();

	}
	
	
// Click X Button In Advanced Search
	
	@Then("the user clicks x button in advanced search page")
	public void the_user_clicks_x_button_in_advanced_search_page() {

		cp.clickAdvanedSearchClose();

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	
	
	
	
	
	  @When("^the user clicks Equity Process$")
	    public void the_user_clicks_equity_process() throws Throwable {
	        cp.clickEquityProcess();
	    }

	 
	
	@Given("^the user clicks menu logo$")
	public void the_user_clicks_menu_logo() throws Throwable {

		cp.clickLogo();

	}
	
//	Click Access Control 

	@When("^the user clicks AccessControl menu$")
	public void the_user_clicks_AccessControl_menu() throws Throwable {

		cp.clickAccessControlMenu();

	}

//	Click Treasury

	@When("the user clicks Treasury menu")
	public void the_user_clicks_treasury_menu() throws Exception {

		cp.clickTreasuryMenu();
	}

//	Maker - Add New

	
	
	@And("^the user close the existing master tab if its already opened$")
	public void the_user_close_the_existing_master_tab_if_its_already_opened() throws Throwable {

		cp.closeExistingMasterTab();

	}
	
	@And("^the user clicks alternate save button$")
	public void the_user_clicks_alternate_save_button() throws Throwable {

		cp.clickAlternateSave();

	}


	@Then("the user validate the maker save request message")
	public void the_user_validate_the_maker_save_request_message() throws InterruptedException {

		
		cp.verifySaveMessage(MessageProperties.get("MAKERSAVEREQUESTMESSAGE").toString());
	}
	
	@When("the user validate risktable save request message")
	public void the_user_validate_risktable_save_request_message() {
	   
		cp.verifySaveMessage(MessageProperties.get("RISKTABLESAVEREQUESTMESSAGE").toString());
	}
	
	@Then("the user validate the session killed message")
	public void the_user_validate_the_session_killed_message() throws InterruptedException {

		
		cp.verifyKillSessionMessage(MessageProperties.get("SESSIONKILLEDMESSAGE").toString());
	}
	

	@When("the user should validate the Requested Account is locked message")
	public void the_user_should_validate_the_requested_account_is_locked_meassage() throws InterruptedException {

		
		cp.verifyAccountLockedMessage(MessageProperties.get("USERLOCKEDMEASSAGE").toString());
	}
	
	@Then("the locked account should be unlocked")
	public void the_locked_account_should_be_unlocked() throws InterruptedException {

		
		cp.verifyaccountunlocked(MessageProperties.get("UNLOCKEDMEASSAGE").toString());
	}
	
	@Then("the user validate the fileupload message")
	public void the_user_validate_the_fileupload_message() throws InterruptedException {

		
		cp.verifySaveMessage(MessageProperties.get("FILEUPLOADMESSAGE").toString());
	}
	

	@Then("^Changes should be updated and saved$")
    public void changes_should_be_updated_and_saved() throws Throwable {
		cp.verifySaveMessage(MessageProperties.get("ALLOCATIONSAVEMESSAGE").toString());
    }

	@Then("^Allocation Interface records should be saved$")
    public void Allocation_Interface_records_should_be_saved() throws Throwable {
		cp.verifySaveMessage(MessageProperties.get("ALLOCATIONINTERFACESAVEMESSAGE").toString());
    }
	
	
	 @Then("^Contracts should be generated$")
	  public void contracts_should_be_generated() throws Throwable {
		 cp.verifySaveMessage(MessageProperties.get("CONTRACTSAVEMESSAGE").toString());  
	   }

	 @Then("^reversal contracts should be saved and moved for approval$")
	    public void reversal_contracts_should_be_saved_and_moved_for_approval() throws Throwable {
		 cp.verifySaveMessage(MessageProperties.get("CONTRACTREVREQMSG").toString());  
	    }
	 
	 
	 @Then("^reversal contracts should be approved$")
	    public void reversal_contracts_should_be_approved() throws Throwable {
		 cp.verifySaveMessage(MessageProperties.get("CONTRACTREVAPPMSG").toString());  
	    }
	 
	 @Then("^Amendment contracts should be saved and moved for approval$")
	    public void amendment_contracts_should_be_saved_and_moved_for_approval() throws Throwable {
		 cp.verifySaveMessage(MessageProperties.get("CONTRACTAMENDREQMSG").toString());
	    }
	 
	 @Then("^Amendment contracts should be approved$")
	    public void amendment_contracts_should_be_approved() throws Throwable {
		 cp.verifySaveMessage(MessageProperties.get("CONTRACTAMENDAPPMSG").toString());
	    }
	 
	 
	@Then("the user validate the maker already exist request message")
	public void the_user_validate_the_maker_already_exist_request_message() {

		cp.verifyContainsMessage(MessageProperties.get("MAKERALREADYEXISTSREQUESTMESSAGE").toString());
	}

	

	

	@And("^the user clicks reset button$")
	public void the_user_clicks_reset_button() throws Throwable {

		cp.clickReset();

	}

	@Then("^the user should get the nothing to save as draft message$")
	public void the_user_should_get_the_nothing_to_save_as_draft_message() throws Throwable {

		cp.verifySaveMessage(MessageProperties.get("NOTHINGTOSAVEASDRAFTMESSAGE").toString());

	}

	@When("the user clicks Yes Reset It option")
	public void the_user_clicks_yes_reset_it_option() throws Exception {

		cp.clickYesInReset();
	}

	@Then("^the user clicks No Cancel It option$")
	public void the_user_clicks_no_cancel_it_option() throws Throwable {

		cp.clickNoInReset();

	}

	@When("the user clicks Close X option")
	public void the_user_clicks_close_x_option() throws Exception {

		cp.clickCloseInReset();

	}

	@When("^the user clicks AddToFavourite icon$")
	public void the_user_clicks_addtofavourite_icon() throws Throwable {

		cp.clickAddToFavorite();

	}

	@Then("^the user should validate the \"([^\"]*)\" is added to the favourites dropdown$")
	public void the_user_should_validate_the_master_is_added_to_the_favourites_dropdown(String menu) throws Throwable {

		cp.verifyMenuInFavorite(menu);

	}

	@When("^the user clicks RemoveFavourite icon$")
	public void the_user_clicks_removefavourite_icon() throws Throwable {

		cp.clickRemoveToFavorite();

	}

	@Then("^the user should validate the \"([^\"]*)\" is removed to the favourites dropdown$")
	public void the_user_should_validate_the_master_is_removed_to_the_favourites_dropdown(String menu)
			throws Throwable {
		cp.verifyMenuIsRemovedFromFavorite(menu);

	}

	@When("^the user clicks download button$")
	public void the_user_clicks_download_button() throws Throwable {
		
		// cp.clickDownload();

	}

	@Then("^the user should click Export as Excel option$")
	public void the_user_should_click_export_as_excel_option() throws Throwable {

		cp.ExportToExcel();

	}

	@Then("^the user should click Export as CSV option$")
	public void the_user_should_click_export_as_csv_option() throws Throwable {
		
		cp.ExportToCSV();
	}

	@When("the user clicks view page")
	public void the_user_clicks_view_page() {
		cp.clickViewPage();
	}



	@Then("the user clicks close button in view page")
	public void the_user_clicks_close_button_in_view_page() {
		cp.clickViewPageClose();
	}


	@Then("the user should see no records message in view page search result")
	public void the_user_should_see_no_records_message_in_view_page_search_result() {

		cp.verifyInvalidDataInViewPageSearch();
	}

	@When("the user clicks download option in view page")
	public void the_user_clicks_download_option_in_view_page() {

		//cp.clickViewPageDownload();

	}

	@Then("the user should click Export as Excel button in view page")
	public void the_user_should_click_export_as_excel_button_in_view_page() {

		cp.clickViewPageExportToExcel();

	}

	@Then("the user should click Export as CSV button in view page")
	public void the_user_should_click_export_as_csv_button_in_view_page() {

		cp.clickViewPageExportToCSV();

	}

	@When("the user clicks refresh button in view page")
	public void the_user_clicks_refresh_button_in_view_page() {

		cp.clickViewRefresh();
	}


	@Then("the user should validate searched record in view page")
	public void the_user_should_validate_searched_record_in_view_page() throws Exception {

		cp.verifyEditPageIsDisplayed();
		
	}

	@Then("the user clicks back button in view page search")
	public void the_user_clicks_back_button_in_view_page_search() throws InterruptedException {

		cp.clickBackButton();

	}

//	Maker - Draft

	

	@Then("^the user should validate draft screen page$")
	public void the_user_should_validate_draft_screen_page() throws Throwable {

		cp.verifyDraftPageView();
	}

	@Then("the user clicks x button in draft")
	public void the_user_clicks_x_button_in_draft() {

		cp.clickDraftXButton();

	}

	@Then("the user clicks close button in draft")
	public void the_user_clicks_close_button_in_draft() throws InterruptedException {
		Thread.sleep(1000);
		cp.clickDraftClose();
	}

	@When("the user clicks refresh button in draft page")
	public void the_user_clicks_refresh_button_in_draft_page() {

		cp.clickDraftRefresh();
	}

	@Then("the user should validate same page in draft page")
	public void the_user_should_validate_same_page_in_draft_page() {

		cp.verifyDraftPageView();
	}

	@Then("the user clicks All Delete button")
	public void the_user_clicks_all_delete_button() {

		cp.clickDraftDeleteAll();
	}

	@Then("the user should validate the no drafts found message")
	public void the_user_should_validate_the_no_drafts_found_message() {

		cp.verifyNoDraftFoundMessage();

	}

	@When("the user clicks Individual Delete button")
	public void the_user_clicks_individual_delete_button() {

		cp.clickIndividualDelete();

	}

	

	@Then("the user clicks back button in draft page")
	public void the_user_clicks_back_button_in_draft_page() throws InterruptedException {

		cp.clickBackButton();

	}

//	Maker - Advanced Search

	

	
	

	@Then("the user should validate Please Fill Any One Field To Search Message")
	public void the_user_should_validate_please_fill_any_one_field_to_search_message() {

		cp.verifySaveMessage(MessageProperties.get("PLEASEFILLSEARCHMESSAGE").toString());

	}

	

	@Then("the user should validate no records found message")
	public void the_user_should_validate_no_records_found_message() {

		cp.verifyInvalidDataInAdvancedSearchTable();

	}

	@When("the user clicks download option in advanced search page")
	public void the_user_clicks_download_option_in_advanced_search_page() {
		//cp.clickDownloadInAdvancedSearch();
	}

	@Then("the user clicks Export as Excel option in advanced search page")
	public void the_user_clicks_export_as_excel_option_in_advanced_search_page() {
		cp.clickExportToExcelInAdvancedSearch();
	}

	@Then("the user clicks Export as CSV option in advanced search page")
	public void the_user_clicks_export_as_csv_option_in_advanced_search_page() {

		cp.clickExportToCSVInAdvancedSearch();

	}

	@Then("the user clicks refresh button in advanced search page")
	public void the_user_clicks_refresh_button_in_advanced_search_page() {

		cp.verifyAdvancedSearchRefresh();

	}

	

	@Then("the user clicks back button in advanced search page")
	public void the_user_clicks_back_button_in_advanced_search_page() throws InterruptedException {

		cp.clickBackButton();
	}

	@Then("the user clicks clear button")
	public void the_user_clicks_clear_button() {

		cp.clickAdvancedSearchClear();

	}

//	Maker - Global Search


	@Then("the user clicks close button in global search")
	public void the_user_clicks_close_button_in_global_search() {

		cp.clickGlobalSearchClose();
	}



	@Then("the user should see no records message in global page search result")
	public void the_user_should_see_no_records_message_in_global_page_search_result() throws InterruptedException {

		cp.verifyInvaliddatainGlobalSearch();
	}

	@When("the user clicks download option in global search")
	public void the_user_clicks_download_option_in_global_search() {

		//cp.clickDownloadinSearch();
	}

	@Then("the user should click Export as Excel button")
	public void the_user_should_click_export_as_excel_button() {

		cp.clickExportToExcelinSearch();

	}

	@Then("the user should click Export as CSV button")
	public void the_user_should_click_export_as_csv_button() {

		cp.clickExportToCSVinSearch();
	}

	@Then("the user clicks Refresh button in global search")
	public void the_user_clicks_refresh_button_in_global_search() {

		cp.verifySearchRefresh();
	}

	

	@Then("the user clicks back button in global page search")
	public void the_user_clicks_back_button_in_global_page_search() throws InterruptedException {

		cp.clickBackButton();

	}

	

	@Then("the user should validate No Changes Detected message")
	public void the_user_should_validate_no_changes_detected_message() {

		cp.verifySaveMessage(MessageProperties.get("NOCHANGESDETECTEDMESSAGE").toString());
	}
	
	@Then("the user should validate unlocked message")
	public void the_user_should_validate_unlocked_message() {

		cp.verifySaveMessage(MessageProperties.get("UNLOCKEDMESSAGE").toString());
	}
	
	@Then("the user should validate Nothing to save as draft  message")
	public void the_user_should_validate_Nothing_to_save_as_draft_message() {
		
		cp.verifySaveMessage(MessageProperties.get("NOTHINGTOSAVEASDRAFTMESSAGE").toString());
	}
	
	
	@Then("the user should validate nothing to save message")
	public void the_user_should_validate_nothing_to_save_message() {
		
		cp.verifySaveMessage(MessageProperties.get("NOTHINGTOSAVEMESSAGE").toString());
	}
	
	@Then("the user should validate selectarecordtoproceed message")
	public void the_user_should_validate_selectarecordtoproceed_message() {
	   
		cp.verifySaveMessage(MessageProperties.get("SELECTARECORDTOPROCEED").toString());
	}
	
	
	

//	Maker - Pending Actions

	

	@Then("the user clicks X button in maker pending actions")
	public void the_user_clicks_x_button_in_maker_pending_actions() {
		
		cp.clickPendingActionCloseButton();
		
	}

	@Then("the user clicks close button in maker pending actions")
	public void the_user_clicks_close_button_in_maker_pending_actions() {

		cp.clickPendingActionCloseButton();

	}

	

	@Then("the user should validate the No pending Quick actions found message")
	public void the_user_should_validate_the_no_pending_quick_actions_found_message() throws InterruptedException {

		cp.verifyNoPendingRecordsMessage();

	}

	@Then("the user should click refresh button in pending actions")
	public void the_user_should_click_refresh_button_in_pending_actions() {

		cp.verifyPendingActionsRefresh();
	}

	@When("the user clicks select all option")
	public void the_user_clicks_select_all_option() {

		cp.verifyPendingActionsRefresh();
		cp.clickSelectAll();
		cp.verifyPendingActionsRefresh();
		cp.clickSelectAll();

	}

	@When("the user clicks difference view page")
	public void the_user_clicks_difference_view_page() {

		cp.clickDiffViewButton();
	}

	@Then("the user clicks x button in difference view page")
	public void the_user_clicks_x_button_in_difference_view_page() {

		cp.clickDiffViewXButton();
	}

	

	@Then("the user clicks back button in pending actions")
	public void the_user_clicks_back_button_in_pending_actions() throws InterruptedException {

		cp.clickBackButton();
	}

//	Checker - Pending Actions


	

	@When("the user clicks RejectWithoutReason button")
	public void the_user_clicks_reject_without_reason_button() {

		cp.clickRejectWithoutReason();
	}

	@Then("the user clicks Reason Box X button")
	public void the_user_clicks_reason_box_x_button() {

		cp.clickRejectReasonBoxCloseButton();
	}

	@When("the user clicks diffview Reject button")
	public void the_user_clicks_diffview_reject_button() {

		cp.clickDiffViewRejectButton();
	}

	@When("the user clicks diffview RejectWithoutReason button")
	public void the_user_clicks_diffview_reject_without_reason_button() {

		cp.clickDiffViewRejectWithoutReason();
	}

	@Then("the user clicks diffview Reason Box X button")
	public void the_user_clicks_diffview_reason_box_x_button() {

		cp.clickDiffViewRejectReasonBoxCloseButton();
	}

	@When("the user clicks preview Reject button")
	public void the_user_clicks_preview_reject_button() {

		cp.clickPreviewRejectButton();
	}

	@When("the user clicks preview Submit button")
	public void the_user_clicks_preview_submit_button() {

		cp.clickPreviewSubmitButton();
	}

	@When("the user clicks preview RejectWithoutReason button")
	public void the_user_clicks_preview_reject_without_reason_button() {

		cp.clickPreviewRejectWithoutReason();
	}

	@Then("the user clicks preview Reason Box X button")
	public void the_user_clicks_preview_diffview_reason_box_x_button() {

		cp.clickPreviewRejectReasonBoxCloseButton();
	}

	@When("the user clicks RejectAll button in checker")
	public void the_user_clicks_reject_all_button_in_checker() {

		cp.clickRejectAll();
	}

	@Then("the user should validate reject all message")
	public void the_user_should_validate_reject_all_message() {

		cp.verifyContainsMessage(MessageProperties.get("REJECTALLMESSAGE").toString());
	}

	

	@When("the user clicks diffview Approve button in checker")
	public void the_user_clicks_diffview_approve_button_in_checker() {

		cp.clickDiffViewApproveButton();
	}

	@When("the user clicks preview Approve button in checker")
	public void the_user_clicks_preview_approve_button_in_checker() {

		cp.clickPreviewApproveButton();
	}

	@When("the user clicks ApproveAll button in checker")
	public void the_user_clicks_approve_all_button_in_checker() {

		cp.clickApproveAll();
	}

	@Then("the user should validate approve all message")
	public void the_user_should_validate_approve_all_message() {

		cp.verifyContainsMessage(MessageProperties.get("APPROVEALLMESSAGE").toString());
	}

//	Both - Pending Actions

	@Then("the user should validate Invalid Request \\(or) you do not have permission message")
	public void the_user_should_validate_invalid_request_or_you_do_not_have_permission_message() {
		cp.ShouldNotAllowToApproveOrReject();
		//cp.verifySaveMessage(MessageProperties.get("BOTHUSEROWNRECORDAPPROVEMESSAGE").toString());

	}

	@When("the user should validate approve all both message")
	public void the_user_should_validate_approve_all_both_message() {

		cp.verifyContainsMessage(MessageProperties.get("BOTHAPPROVEALLMESSAGE").toString());
	}

	@When("the user should validate reject all both message")
	public void the_user_should_validate_reject_all_both_message() {

		cp.verifyContainsMessage(MessageProperties.get("BOTHREJECTALLMESSAGE").toString());
	}

//	Admin - Add New

	@Then("the user validate the Record Saved Successfully message")
	public void the_user_validate_the_record_saved_successfully_message() {

		cp.verifySaveMessage(MessageProperties.get("DIRECTSAVEMESSAGE").toString());
	}



*/
	
	
}
