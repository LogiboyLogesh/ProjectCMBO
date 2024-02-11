package com.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.CommonMethodsAbstract;
import com.framework.ConnectDB;

public class CommonPageService extends CommonMethodsAbstract {

	public CommonPageService(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//	Maker - Add New
	

	@FindAll({ @FindBy(xpath = "//*[@id='advanceSearchCloseIcon']") })
	WebElement ADVANCEDSEARCHCLOSE;

	@FindAll({ @FindBy(xpath = "//*[@id='menuBar']//span[@class='menu-title' and text()='Master']") })
	WebElement MASTER;
	
	@FindAll({ @FindBy(xpath = "//span[text()='CM Master']") })
	WebElement CMMASTER;
	
	@FindAll({ @FindBy(xpath = "//*[@id='menuBar']//span[@class='menu-title' and text()='Equity Process']") })
	WebElement EQUITYPROCESS;
	
	@FindAll({@FindBy(xpath = "//span[@class='menu-title' and text()='Master']/following-sibling::svg-icon[@icon='icon-chevron-left']") })
	WebElement MASTERCOLLAPSE;
	
	@FindAll({ @FindBy(xpath = "//*[@id='menuBar']//span[@class='menu-title' and text()='Accesscontrol']") })
	WebElement ACCESSCONTROL;
	
	@FindAll({@FindBy(xpath = "//span[@class='menu-title' and text()='Access Control']/following-sibling::svg-icon[@icon='icon-chevron-left']") })
	WebElement ACCESSCONTROLCOLLAPSE;
	
	@FindAll({ @FindBy(xpath = "//span[@class='menu-title' and text()='Treasury']") })
	WebElement TREASURY;
	
	@FindAll({@FindBy(xpath = "//span[@class='menu-title' and text()='Treasury']/following-sibling::svg-icon[@icon='icon-chevron-left']") })
	WebElement TREASURYCOLLAPSE;

	@FindAll({ @FindBy(xpath = "//app-messagealert/ngb-alert/p") })
	WebElement MESSAGE;
	
	@FindAll({ @FindBy(id = "cacheReloadBtn") })
	WebElement CACHERELOAD;
	
	@FindAll({ @FindBy(id = "alertClose") })
	WebElement ALERTCLOSE;
	
	@FindAll({ @FindBy(id = "Draft") })
	WebElement SAVEDRAFT;
	
	@FindAll({ @FindBy(id = "Reset") })
	WebElement RESET;

	@FindAll({ @FindBy(id = "logo-section") })
	WebElement LOGO;

	@FindAll({ @FindBy(id = "megaMenuToggle") })
	WebElement MENUBAR;

	@FindAll({ @FindBy(xpath = "//button[@title='Yes']") })
	WebElement RESETYES;
	
	@FindAll({ @FindBy(xpath = "//button[@title='No']") })
	WebElement RESETNO;
	
	@FindAll({ @FindBy(xpath = "//button[@class='close']") })
	WebElement RESETCLOSE;
	
	@FindAll({ @FindBy(id = "favoriteIconBtn") })
	WebElement ADDFAVORITE;
	
	@FindAll({ @FindBy(id = "favoriteIconBtn") })
	WebElement REMOVEFAVORITE;
	
	@FindAll({ @FindBy(id = "favorites") })
	WebElement FAVORITETAB;
	
	@FindAll({ @FindBy(xpath = "//*[text()='×']") })
	WebElement FAVORITETABCLOSE;
	
	@FindAll({ @FindBy(id = "dropdownDownloadButton1") })
	WebElement DOWNLOAD;
							 
	@FindAll({ @FindBy(id = "exportAsExcelButton") })
	WebElement EXPORTTOEXCEL;
							 
	@FindAll({ @FindBy(id = "exportAsCSVButton") })
	WebElement EXPORTTOCSV;
	
	@FindAll({ @FindBy(id = "viewBtn") })
	WebElement VIEWPAGE;
	
	@FindAll({ @FindBy(name = "filterViewSearch") })
	WebElement SEARCHTEXTINVIEWGRID;
	
	private By VIEWGRIDHEADER = By.xpath("//p-table//table/thead/tr/th[@class='ng-star-inserted']");
	private By GLOBALSEARCHHEADER = By.xpath("//*[@id='advSrchPanel']//table/thead/tr/th"); //// p-table//table/thead/tr/th[@class='ng-star-inserted']");		
	private By GRIDVIEWCLOSE = By.id("globalViewCloseButton");
	private By GRIDCURRENCYVIEWCLOSE = By.xpath("(//*[@bi='bi-x-square'])[3]");
	private By GRIDGLOBALCLOSE = By.id("globalSearchCloseButton");
	
	@FindAll({ @FindBy(id = "globalViewCloseButton") })
	WebElement VIEWPAGECLOSE;
	
	@FindAll({ @FindBy(id = "viewResultDownloadButton") })
	WebElement VIEWPAGEDOWNLOAD;
	
	@FindAll({ @FindBy(id = "globelSearchDownloadAsExcel") })
	WebElement VIEWPAGEEXPORTTOEXCEL;
	
	
	
	
	@FindAll({ @FindBy(id = "globelSearchDownloadAsCSV") })
	WebElement VIEWPAGEEXPORTTOCSV;
	
	
	
	
	@FindAll({ @FindBy(xpath = "(//button[@title='Refresh'])[2]") })
	WebElement VIEWPAGEREFRESH;
	
	private By TABLEROWS = By.xpath("//*[contains(@class,'table-wrapper')]/table/tbody/tr");
	
	@FindAll({ @FindBy(id = "editMode") })
	WebElement EDITBUTTON;
	
	@FindAll({ @FindBy(id = "cancelBtn") })
	WebElement CLICKBACKBUTTON;

	@FindAll({ @FindBy(xpath = "//button[@class='close']") })
	WebElement GRIDCLOSE;
	
	@FindAll({@FindBy(id="copyoption")}) 
	WebElement ACCOUNTCOPY;
	
	@FindAll({@FindBy(xpath="//*[@id='copySubAccCode0']//input")}) 
	WebElement ACCOUNTCOPYCODE;
	
	@FindAll({@FindBy(xpath="//*[@class='ng-dropdown-panel-items scroll-host']//following-sibling::div/div")}) 
	WebElement ACCOUNTCOPYCODESELECT;
	
	@FindAll({@FindBy(xpath="//*[@title='Search']")}) 
	WebElement ACCOUNTCOPYSEARCH;
	
	@FindAll({@FindBy(xpath="(//*[@class='p-datatable-wrapper'])[2]//table//tbody/tr")}) 
	WebElement ACCOUNTCOPYCODESELECTION;

//	Maker - Global Search

	@FindAll({ @FindBy(name = "filterSearch") })
	WebElement SEARCHTEXTINGRID;
	
	@FindAll({ @FindBy(id = "globalSearchCloseButton") })
	WebElement SEARCHCLOSE;
	
	@FindAll({ @FindBy(id = "globalSearchDownloadButton") })
	WebElement SEARCHDOWNLOAD;
	
	@FindAll({ @FindBy(xpath = "(//*[@id='exportAsExcelButton'])[2]") })
	WebElement SEARCHEXPORTTOEXCEL;
	
	@FindAll({ @FindBy(xpath = "(//*[@id='exportAsCSVButton'])[2]") })
	WebElement SEARCHEXPORTTOCSV;
	
	@FindAll({ @FindBy(id = "globalSearchRefreshButton") })
	WebElement REFRESH;

	

//	Maker - Advanced Search
	

	@FindAll({ @FindBy(xpath = "//*[@id='advancedSrchBtn']") }) 
	WebElement ADVANCEDSEARCH;
	
	@FindAll({ @FindBy(id = "AdvancedSearchSearchButton") })
	WebElement ADVANCEDPAGESEARCH;
	
	@FindAll({@FindBy(xpath ="(//*[@id='calendarDate0_clear'])[2]")})WebElement 
	ADVANCEDCALENDARDATESEARCHCLEAR;
	
	@FindAll({@FindBy(xpath ="//*[text()='ALL - ALL']//following::span[1]")})WebElement 
	ADVANCEDSETTLEMENTDOMAINCLEAR;
	
	
	
	@FindAll({@FindBy(xpath ="(//*[text()='SD02 - Securities domain'])[2]//following::span[1]")})WebElement 
	ADVANCEDTRADECHANNELSETTLEMENTDOMAINCLEAR;
	
	@FindAll({@FindBy(xpath ="(//*[text()='ALL - ALL'])[2]//following::span[1]")})WebElement 
	ADVANCEDTRADECHANNELMARKETCLEAR;
	
	@FindAll({@FindBy(xpath ="//*[@id='advFilterClientTypeCode0']/div/span[1]")})WebElement 
	ADVANCEDEQUITYCOMMISSIONCLIENTTYPECLEAR;
	
	@FindAll({@FindBy(xpath ="//*[@id='advFilterClientCategoryIntCode0']/div/span[1]")})WebElement 
	ADVANCEDEQUITYCOMMISSIONCLIENTCATEGORYCLEAR;
	
	
	
	
	
	private By ADVSEARCHGRIDHEADER = By.xpath("//masteradvasearch//thead/tr/th");
	
	private By ADVANCEDSEARCHTABLEROWS = By.xpath("//masteradvasearch//tr");
	
	@FindAll({ @FindBy(id = "advanceSearchDownloadButton") })
	WebElement ADVSEARCHDOWNLOAD;
	
	@FindAll({ @FindBy(xpath = "(//*[@id='exportAsExcelButton'])[2]") })
	WebElement ADVSEARCHEXPORTTOEXCEL;
	
	@FindAll({ @FindBy(xpath = "(//*[@id='exportAsCSVButton'])[2]") })
	WebElement ADVSEARCHEXPORTTOCSV;
	
	@FindAll({ @FindBy(id = "advanceSearchRefreshButton") })
	WebElement ADVANCEDSEARCHREFRESH;
	
	@FindAll({ @FindBy(id = "clearAdvanceSearchButton") })
	WebElement ADVANCEDSEARCHCLEAR;

//	Maker - Pending Actions

	@FindAll({ @FindBy(id = "pendingViewer") })
	WebElement PENDINGVIEWER;

	@FindAll({ @FindBy(id = "pendingActionsSearchInput") })
	WebElement PENDINGRECORDSEARCH;

	@FindAll({ @FindBy(xpath = "//*[@id='layout-wrap']/ngb-modal-window/div/div/div[1]/button/span") })
	WebElement PENDINGACTIONXBUTTON;
	
	@FindAll({ @FindBy(id = "pendingCloseIcon") })
	WebElement PENDINGACTIONCLOSEBUTTON;
	
	@FindAll({ @FindBy(xpath = "//*[@title='Mandatory list']") })
	WebElement MANDATORYLIST;
	
	@FindAll({ @FindBy(xpath = "//*[@id='pendingActionsSearchInput']") })
	WebElement SEARCHTEXTINPENDINGACTIONS;
	
	private By PENDINGACTIONSGRIDHEADER = By.xpath("//ngb-modal-window//table/thead/tr/th");
	
	@FindAll({ @FindBy(id = "pendingActionsRefreshButton") })
	WebElement PENDINGACTIONSREFRESH;
	
	@FindAll({ @FindBy(xpath = "//*[text()='Pending Actions']") })
	WebElement PENDINGACTIONSSCREEN;
	
	@FindAll({ @FindBy(id = "selectAllPendingEntries") })
	WebElement SELECTALLRECORDS;
	
	@FindAll({ @FindBy(xpath = "(//*[@title='Diff-View'])[1]") })
	WebElement CLICKDIFFERENTVIEW;
	
	@FindAll({ @FindBy(xpath = "(//*[contains(@id,'diffviewId')])[1]") })
	WebElement CLICKSUBACCOUNTDIFFERENTVIEW;
	
	
	
	@FindAll({ @FindBy(xpath = "//*[@id='layout-wrap']/ngb-modal-window[2]/div/div/div[1]/button/svg-icon") })
	WebElement CLICKDIFFERENTVIEWX;
	
	@FindAll({ @FindBy(xpath = "(//*[@aria-label='Preview'])[1]") })
	WebElement CLICKPREVIEW;

//	Maker - Draft

	@FindAll({ @FindBy(id = "draftsViewer") })
	WebElement DRAFT;
	
	
	
	@FindAll({ @FindBy(xpath = "//*[text()='Drafts']") })
	WebElement DRAFTSCREEN;
	
	@FindAll({ @FindBy(id = "draftCloseIcon") })
	WebElement DRAFTXCLOSE;
	
	@FindAll({ @FindBy(id = "draftCloseButton") })
	WebElement DRAFTCLOSE;
	
	@FindAll({ @FindBy(xpath = "(//*[@ngbtooltip='Refresh'])[2]") })
	WebElement DRAFTREFRESH;
	
	@FindAll({ @FindBy(xpath = "//*[@class='ms-auto d-flex align-items-center me-3']//button[@aria-label='Delete']") })
	WebElement CLICKDRAFTDELETEALL;
	
	private By DRAFTGRIDHEADER = By.xpath("//ngb-modal-window//table/thead/tr/th");
	
	@FindAll({ @FindBy(xpath = "//button[contains(@id,'draftRow_Delete')]") }) // "//*[@ngbtooltip='Delete']") })
	WebElement CLICKINDIVIDUALDELETE;
	
	@FindAll({ @FindBy(xpath = "//button[contains(@id,'draftRow_Edit')]") }) // "//*[@ngbtooltip='Edit']") })
	WebElement CLICKDRAFTEDIT;

//	Checker - Pending Actions

	@FindAll({ @FindBy(xpath = "(//*[starts-with(@id,'rejectId_')])[1]") })
	WebElement INDIVIDUALREJECT;
	
	@FindAll({ @FindBy(id = "rejectReasonId") })
	WebElement INDIVIDUALREJECTREASON;
	
	@FindAll({ @FindBy(id = "rejectSubmitIdButton") })
	WebElement REASONSUBMIT;
	
	@FindAll({ @FindBy(id = "rejectWithoutIdButton") })
	WebElement REJECTWITHOUTREASON;
	
	@FindAll({ @FindBy(xpath = "//*[@id=\"layout-wrap\"]/ngb-modal-window[2]/div/div/div[1]/button") })
	WebElement REJECTREASONBOXCLOSEBUTTON;
	
	@FindAll({ @FindBy(id = "RejectDiffId") })
	WebElement DIFFERENTVIEWREJECT;
	
	@FindAll({ @FindBy(id = "rejectWithoutIdButton") })
	WebElement DIFFVIEWREJECTWITHOUTREASON;
	
	@FindAll({ @FindBy(xpath = "//*[@id=\"layout-wrap\"]/ngb-modal-window[3]/div/div/div[1]/button") })
	WebElement DIFFVIEWREJECTREASONBOXCLOSEBUTTON;
	
	@FindAll({ @FindBy(xpath = "//*[text()='Reject']") })
	WebElement PREVIEWREJECT;
	
	@FindAll({ @FindBy(id = "rejectSubmitId") })
	WebElement PREVIEWREASONSUBMIT;
	
	@FindAll({ @FindBy(id = "rejectWithoutId") })
	WebElement PREVIEWREJECTWITHOUTREASON;
	
	@FindAll({ @FindBy(id = "closeReject") })
	WebElement PREVIEWREJECTREASONBOXCLOSEBUTTON;
	
	@FindAll({ @FindBy(id = "pendingActionsRejectAllButton") })
	WebElement REJECTALL;
	
	@FindAll({ @FindBy(xpath = "(//*[starts-with(@id,'approveId_')])[1]") })
	WebElement INDIVIDUALAPPROVE;
	
	@FindAll({ @FindBy(id = "ApproveDiffId") })
	WebElement DIFFERENTVIEWAPPROVE;
	
	@FindAll({ @FindBy(xpath = "//*[text()='Approve']") })
	WebElement PREVIEWAPPROVE;
	
	@FindAll({ @FindBy(id = "pendingActionsApproveAllButton") })
	WebElement APPROVEALL;
	
	
	
	

// Draft Records Clear In Database

	public void deleteDraftRecords(String menuname) throws Exception {

		ConnectDB cdb = new ConnectDB();
		String sql = "DELETE FROM DRAFTS WHERE FORMID IN (SELECT id FROM SUBMENU WHERE NAME = '" + menuname + "');";
		cdb.deleteSql(sql);
	}

// Pending Actions Records Clear In Database
	
	public void deletePendingRecords(String menuname) throws Exception {
		
		ConnectDB cdb = new ConnectDB();
		String sqlNew = "DELETE FROM BASE4EYEAUDITJSON WHERE RECORDTYPE='New' and FORMID IN (SELECT id FROM SUBMENU WHERE NAME = '"
				+ menuname + "');";
		cdb.deleteSql(sqlNew);
		String sqlEdit = "DELETE FROM BASE4EYEAUDITJSON WHERE RECORDTYPE='Edit' and FORMID IN (SELECT id FROM SUBMENU WHERE NAME = '"
				+ menuname + "');";
		cdb.deleteSql(sqlEdit);
		
		String sqlNo = "DELETE FROM BASE4EYEAUDITJSON WHERE RECORDTYPE='NOCHANGES' and FORMID IN (SELECT id FROM SUBMENU WHERE NAME = '"
				+ menuname + "');";
		cdb.deleteSql(sqlNo);
		
		String sqlclosingofaccounts = "DELETE FROM SL_CLOSING_REOPEN_AUDIT WHERE CHECKER_STATUS='P'";
		
		cdb.deleteSql(sqlclosingofaccounts);
		
	
	}

// Click Master Menu


	public void clickMasterMenu() throws Exception {			

			mouseHoverElement(MENUBAR);
			Thread.sleep(500);
			waitForElementToBeClickable(MASTER);
			clickOnElementUsingJs(MASTER);
			
			
	}
	
	
// Click Save Button
	
	public void clickSave() throws InterruptedException {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", SAVE);
		waitForElementToBeClickable(SAVE);
		Thread.sleep(500);
		clickOnElementUsingJs(SAVE);
		

	}
	
	
public void clickSignout() throws InterruptedException {
		
		

	}
	

// Record Saved For Approval Message
	
	
	public void verifySaveMessage(String msg) {
		String messagetemp = "";
		try {
			waitForVisibility(MESSAGE);
			messagetemp = gettext(MESSAGE);
			ALERTCLOSE.click();
			
		} catch (Exception e) {
			if (isElementPresent(DRAFTXCLOSE))
				click(DRAFTXCLOSE);
		} finally {
			verifyEquals(msg, messagetemp, "Verify Save Message");
			// clickPendingActionCloseButton();
			if (!msg.equals(messagetemp) && isElementPresent(CLICKBACKBUTTON))
				click(CLICKBACKBUTTON);
		}

	}
	
	
// Click Draft Button
	
	
	public void clickSaveDraft() {
		
		waitForElementToBeClickable(SAVEDRAFT);
		clickOnElementUsingJs(SAVEDRAFT);

	
	}
	

// Draft Saved Successfully Message
	
	public void verifyDraftSaveMessage(String msg) {
		try {
			waitForVisibility(MESSAGE);
			String messagetemp = gettext(MESSAGE);
			verifyEquals(msg, messagetemp, "Verify Save Message");
		} catch (Exception e) {
			click(DRAFTCLOSE);
		}
	}
	
	
// Draft Tab Button	
	
	public void clickDraft() {
		waitForElementToBeClickable(DRAFT);
		clickOnElementUsingJs(DRAFT);
	}
	
	
// Click Edit Button In Draft Page	
	
	public void clickDraftEditButton() throws Exception {
		Thread.sleep(500);
		waitForElementToBeClickable(CLICKDRAFTEDIT);
		click(CLICKDRAFTEDIT);
	}
	
	
// Pending Actions Tab Button	
	
	public void clickPendingActions() {
		
		waitForElementToBeClickable(PENDINGVIEWER);
		clickOnElementUsingJs(PENDINGVIEWER);

	}
	

// Click Preview Button In Pending Actions
	
	public void clickPreviewButton() {

		waitForElementToBeClickable(CLICKPREVIEW);
		click(CLICKPREVIEW);
		if (isElementPresent(EDITBUTTON)) {
			verifyTrue(isElementPresent(EDITBUTTON), "Edit Button is displayed");
		}

	}
	

// Click Edit Button In Pending Actions And In Global Search
	
	public void clickEdit() throws InterruptedException {
		try {
			clickBackTop();
			scrollToTop();
			Thread.sleep(1000);
			waitForVisibility(EDITBUTTON);
			waitForElementToBeClickable(EDITBUTTON);
			click(EDITBUTTON);
		} catch (Exception e) {
			clickDraftClose();
		}
	}
	
	
// Click Reject Button In Pending Actions
	
	
	public void clickRejectButton() {

		waitForElementToBeClickable(INDIVIDUALREJECT);
		click(INDIVIDUALREJECT);
	}
	
// Enter Reason
	
	public void enterReasonForReject(String data) {
		waitForElementToBeClickable(INDIVIDUALREJECTREASON);
		click(INDIVIDUALREJECTREASON);
		clearvalue(INDIVIDUALREJECTREASON);
		setvalue(INDIVIDUALREJECTREASON, data);
	}


// Click Submit Button
	
	public void clickSubmitButton() {

		waitForElementToBeClickable(REASONSUBMIT);
		click(REASONSUBMIT);

	}

	
// Record Rejected Successfully Message // Record Approved Successfully Message 
	
	public void verifyContainsMessage(String msg) {
		waitForVisibility(MESSAGE);
		String messagetemp = gettext(MESSAGE);
		try {
			ALERTCLOSE.click();
		} finally {
			verifyContains(messagetemp.toUpperCase(), msg.toUpperCase(), "Verify Existing Message");
		}
	}
	
	
// Click X Button In Pending Actions
	
	public void clickPendingActionCloseButton() {

		if (isElementPresent(PENDINGACTIONCLOSEBUTTON))
		waitForVisibility(PENDINGACTIONCLOSEBUTTON);
		waitForElementToBeClickable(PENDINGACTIONCLOSEBUTTON);
		clickOnElementUsingJs(PENDINGACTIONCLOSEBUTTON);

	}
	

// Click Approve Button In Pending Actions
	
	
	public void clickApproveButton() {

		waitForElementToBeClickable(INDIVIDUALAPPROVE);
		click(INDIVIDUALAPPROVE);
	}
	

// Click Advanced Search Button
	
	public void clickAdvancedSearch() throws InterruptedException {
		
		clickBackTop();
		scrollToTop();
		Thread.sleep(1000);
		waitForElementToBeClickable(ADVANCEDSEARCH);
		clickOnElementUsingJs(ADVANCEDSEARCH);
	}
	
	
// Click Search Button
	
	public void clickAdvancedPageSearch() throws InterruptedException {

		waitForElementToBeClickable(ADVANCEDPAGESEARCH);
		
		if(isElementPresent(ADVANCEDCALENDARDATESEARCHCLEAR))
		clickOnElementUsingJs(ADVANCEDCALENDARDATESEARCHCLEAR);
		if(isElementPresent(ADVANCEDSETTLEMENTDOMAINCLEAR))
		click(ADVANCEDSETTLEMENTDOMAINCLEAR);
		
		if(isElementPresent(ADVANCEDTRADECHANNELSETTLEMENTDOMAINCLEAR))
		click(ADVANCEDTRADECHANNELSETTLEMENTDOMAINCLEAR);
		if(isElementPresent(ADVANCEDTRADECHANNELMARKETCLEAR))
		click(ADVANCEDTRADECHANNELMARKETCLEAR);
		
		if(isElementPresent(ADVANCEDEQUITYCOMMISSIONCLIENTTYPECLEAR))
		click(ADVANCEDEQUITYCOMMISSIONCLIENTTYPECLEAR);
		if(isElementPresent(ADVANCEDEQUITYCOMMISSIONCLIENTCATEGORYCLEAR))
		click(ADVANCEDEQUITYCOMMISSIONCLIENTCATEGORYCLEAR);

		click(ADVANCEDPAGESEARCH);
	}
	
	
// Click X Button In Advanced Search
	
	public void clickAdvanedSearchClose() {

		waitForElementToBeClickable(ADVANCEDSEARCHCLOSE);
		click(ADVANCEDSEARCHCLOSE);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	public void clickEquityProcess() throws Exception {
		clickOnElementUsingJs(MENUBAR);
		Thread.sleep(500);
		waitForVisibility(EQUITYPROCESS);
		clickOnElementUsingJs(EQUITYPROCESS);


	}

	public void clickLogo() {
		click(LOGO);
	}

//  Click Access Control

	public void clickAccessControlMenu() throws Exception {

			clickOnElementUsingJs(MENUBAR);
			Thread.sleep(500);
			waitForElementToBeClickable(ACCESSCONTROL);
			click(ACCESSCONTROL);
		
	}

//  Click Treasury
	
	public void clickTreasuryMenu() throws Exception {

		clickOnElementUsingJs(MENUBAR);
		waitForElementToBeClickable(TREASURY);
		Thread.sleep(1000);
		clickOnElementUsingJs(TREASURY);
	}

	public void clickUnexpectedButtons() {
		try {
			if (isElementPresent(MANDATORYLIST))
			click(MANDATORYLIST);
			if (isElementPresent(PENDINGACTIONCLOSEBUTTON))
				click(PENDINGACTIONCLOSEBUTTON);	
			if (isElementPresent(DRAFTCLOSE))
				click(DRAFTCLOSE);
			if (isElementPresent(VIEWPAGECLOSE))
				click(VIEWPAGECLOSE);
			if (isElementPresent(ADVANCEDSEARCHCLOSE))
				click(ADVANCEDSEARCHCLOSE);
			if (isElementPresent(CLICKBACKBUTTON))
				click(CLICKBACKBUTTON);
			if (isElementPresent(GRIDCLOSE))
				click(GRIDCLOSE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
// Maker - Add New		

	public void clickCacheReload() {

		waitForElementToBeClickable(CACHERELOAD);
		click(CACHERELOAD);

	}

	
	
	public void verifyKillSessionMessage(String msg) {
		waitForVisibility(MESSAGE);
		String messagetemp = gettext(MESSAGE);
		try {	
			ALERTCLOSE.click();
		}
			finally {
		verifyContains(messagetemp.toUpperCase(),msg.toUpperCase(), "Verify Kill Session Message");
			}

	}
	
	public void verifyAccountLockedMessage(String msg) {
		String messagetemp="";		
		
			waitForVisibility(MESSAGE);
			messagetemp = gettext(MESSAGE);
			ALERTCLOSE.click();
			verifyEquals(msg, messagetemp, "Verify Account locked Message");

	}
	
	public void verifyaccountunlocked(String msg) {
		String messagetemp="";		
		
			waitForVisibility(MESSAGE);
			messagetemp = gettext(MESSAGE);
			ALERTCLOSE.click();
			verifyEquals(msg, messagetemp, "Verify Account Unlocked Meassage");

	}

	

	

	public void verifyDraftsMessage(String msg) {

		waitForVisibility(MESSAGE);
		String messagetemp = gettext(MESSAGE);
		try {
			ALERTCLOSE.click();
		} finally {
			verifyContains(msg, messagetemp, "Verify Draft Message");
		}

	}



	public void clickReset() {

		
			waitForVisibility(RESET);
			waitForElementToBeClickable(RESET);
			clickOnElementUsingJs(RESET);
		
		
		
	}
	
	

	public void clickYesInReset() throws Exception {
		try {
			waitForElementToBeClickable(RESETYES);
			if (isElementPresent(RESETYES))
				click(RESETYES);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNoInReset() throws Exception {
		try {
			waitForElementToBeClickable(RESETNO);
			if (isElementPresent(RESETNO))
				click(RESETNO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickCloseInReset() throws Exception {
		try {
			waitForElementToBeClickable(RESETCLOSE);
			if (isElementPresent(RESETCLOSE))
				click(RESETCLOSE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickAddToFavorite() throws InterruptedException {

		clickBackTop();
		scrollToTop();
		waitForVisibility(ADDFAVORITE);
		waitForElementToBeClickable(ADDFAVORITE);
		if (isElementEnabled(ADDFAVORITE))
			click(ADDFAVORITE);
	}

	public void clickRemoveToFavorite() {
		waitForVisibility(REMOVEFAVORITE);
		waitForElementToBeClickable(REMOVEFAVORITE);
		if (isElementEnabled(REMOVEFAVORITE))
			click(REMOVEFAVORITE);
	}

	public void verifyMenuInFavorite(String menu) throws InterruptedException {

		
		clickBackTop();
		scrollToTop();
		waitForElementToBeClickable(FAVORITETABCLOSE);
		click(FAVORITETABCLOSE);
		waitForElementToBeClickable(FAVORITETAB);
		click(FAVORITETAB);
		boolean fvmenu = true;
		List<WebElement> optionsToSelect = driver.findElements(
				By.xpath("//*[@class='dropdown-menu dropdown-menu-right fav-dropdown show']//button/div/p"));
		try {
			for (WebElement option : optionsToSelect) {
				String getValue = option.getText().trim();
				System.out.println(getValue);
				if (getValue.equalsIgnoreCase(menu)) {
					fvmenu = false;
					break;
				}
			}
		} catch (Exception e) {

		}
		verifyTrue(fvmenu, "Menu is added in Favorites");
	}

	public void verifyMenuIsRemovedFromFavorite(String menu) throws InterruptedException {

		clickBackTop();
		scrollToTop();
		waitForElementToBeClickable(FAVORITETABCLOSE);
		click(FAVORITETABCLOSE);

		waitForElementToBeClickable(FAVORITETAB);
		click(FAVORITETAB);
		boolean fvmenu = true;
		List<WebElement> optionsToSelect = driver
				.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-right show']//button/div/p"));
		try {
			for (WebElement option : optionsToSelect) {
				String getValue = option.getText().trim();
				if (getValue.equalsIgnoreCase(menu))
					fvmenu = false;

			}
		} catch (Exception e) {

		}
		verifyTrue(fvmenu, "Menu is removed in Favorites");
	}

	public void clickDownload() throws Exception {
		waitTillProgressBar();
		clickBackTop();
		waitForElementToBeClickable(DOWNLOAD);
		click(DOWNLOAD);
	}

	public void ExportToExcel() {
		waitForElementToBeClickable(EXPORTTOEXCEL);
		click(EXPORTTOEXCEL);
	}

	public void ExportToCSV() throws Exception {
		waitTillProgressBar();
		waitForElementToBeClickable(EXPORTTOCSV);
		click(EXPORTTOCSV);
	}

	public void clickViewPage() {
		
		
			waitForElementToBeClickable(VIEWPAGE);
			clickOnElementUsingJs(VIEWPAGE);

	}
	
public void enterCopyValueInSearch(String searchdata) throws Exception {
		
		waitForElementToBeClickable(ACCOUNTCOPY);
		click(ACCOUNTCOPY);
		
		String temp[]=searchdata.split(":");
		waitForElementToBeClickable(ACCOUNTCOPYCODE);
		click(ACCOUNTCOPYCODE);
		clearvalue(ACCOUNTCOPYCODE);
		setvalue(ACCOUNTCOPYCODE,temp[temp.length-1]);
		doubleclickOnElementUsingActions(ACCOUNTCOPYCODESELECT);
		click(ACCOUNTCOPYSEARCH);
		doubleclickOnElementUsingActions(ACCOUNTCOPYCODESELECTION);
		
	}

	public void enterValueinViewPageSearch(String searchdata) {
		String temp[] = searchdata.split(":");
		waitForElementToBeClickable(SEARCHTEXTINVIEWGRID);
		click(SEARCHTEXTINVIEWGRID);
		clearvalue(SEARCHTEXTINVIEWGRID);
		setvalue(SEARCHTEXTINVIEWGRID, temp[temp.length - 1]);
	}

	public void verifyAndOpenDataInTableViewPage(List testdata) {
		String temp[] = testdata.get(2).toString().split(":");
		String header = temp[0];
		String data = temp[1];
		WebElement GH = driver.findElement(VIEWGRIDHEADER);
		waitForElementToBeClickable(GH);

		try {
			List<WebElement> hdrs = driver.findElements(VIEWGRIDHEADER);
			int hc = driver.findElements(VIEWGRIDHEADER).size();
			for (int i = 0; i < hc; i++) {
				if (hdrs.get(i).getText().equals(header)) {
					int rr = driver.findElements(TABLEROWS).size();
					for (int j = 1; j <= rr; j++) {
						String rwdata = "//*[contains(@class,'d-block infilter')]//table//tbody/tr[1]/td[" + i
								+ "]/span";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						if (gettext(eletemp).equals(data)) {
							doubleclickOnElementUsingActions(eletemp);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickViewPageClose() {
		
		
			waitForElementToBeClickable(VIEWPAGECLOSE);
			clickOnElementUsingJs(VIEWPAGECLOSE);

		
	}

	public void clickViewPageDownload() {
		
		waitForElementToBeClickable(VIEWPAGEDOWNLOAD);
		//click(VIEWPAGEDOWNLOAD);
		clickOnElementUsingJs(VIEWPAGEDOWNLOAD);
		
	}

	public void clickViewPageExportToExcel() {
		
		
			waitForElementToBeClickable(VIEWPAGEEXPORTTOEXCEL);
			click(VIEWPAGEEXPORTTOEXCEL);
		

	}

	public void clickViewPageExportToCSV() {
		
	
			waitForElementToBeClickable(VIEWPAGEEXPORTTOCSV);
			click(VIEWPAGEEXPORTTOCSV);
	
	}

	public void clickViewRefresh() {
		waitForElementToBeClickable(VIEWPAGEREFRESH);
		click(VIEWPAGEREFRESH);
	}

	public void verifyAndOpenDataInTableViewPageSearch(String testdata) throws Exception {
		Thread.sleep(1000);
		String temp[] = testdata.split(":");
		String header = temp[0];
		String data = temp[1];

		WebElement GH = driver.findElement(GRIDVIEWCLOSE);
		waitForElementToBeClickable(GH);
		

		try {
			List<WebElement> hdrs = driver.findElements(VIEWGRIDHEADER);
			int hc = driver.findElements(VIEWGRIDHEADER).size();
			for (int i = 0; i < hc; i++) {
				// System.out.println(hdrs.get(i).getText());
				// if (hdrs.get(i).getText().equals(header)) {
				if (hdrs.get(i).getText().equalsIgnoreCase(header)) {
					int rr = driver.findElements(TABLEROWS).size();
					for (int j = 1; j <= rr; j++) {
						String rwdata = "//ngb-modal-window//p-table//tbody/tr[" + j + "]/td[" + (i + 1) + "]/span";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						waitForElementToBeClickable(eletemp);
						if (gettext(eletemp).equals(data)) {
							doubleclickOnElementUsingActions(eletemp);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void verifyAndOpenDataInTableCurrencyViewPageSearch(String testdata) throws Exception {
		Thread.sleep(1000);
		String temp[] = testdata.split(":");
		String header = temp[0];
		String data = temp[1];

		WebElement GHCURRENCY = driver.findElement(GRIDCURRENCYVIEWCLOSE);
		waitForElementToBeClickable(GHCURRENCY);
		

		try {
			List<WebElement> hdrs = driver.findElements(VIEWGRIDHEADER);
			int hc = driver.findElements(VIEWGRIDHEADER).size();
			for (int i = 0; i < hc; i++) {
				// System.out.println(hdrs.get(i).getText());
				// if (hdrs.get(i).getText().equals(header)) {
				if (hdrs.get(i).getText().equalsIgnoreCase(header)) {
					int rr = driver.findElements(TABLEROWS).size();
					for (int j = 1; j <= rr; j++) {
						String rwdata = "//ngb-modal-window//p-table//tbody/tr[" + j + "]/td[" + (i - 6) + "]/span";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						//waitForElementToBeClickable(eletemp);
						waitForVisibility(eletemp);
						if (gettext(eletemp).equals(data)) {
							doubleclickOnElementUsingActions(eletemp);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyEditPageIsDisplayed() throws Exception {

		if(isElementPresent(EDITBUTTON))
		{
			waitForVisibility(EDITBUTTON);
			verifyTrue(isElementPresent(EDITBUTTON), "Edit Button is displayed");
		}
		
		if(isElementPresent(CLICKBACKBUTTON))
		{
			waitForVisibility(CLICKBACKBUTTON);
			verifyTrue(isElementPresent(CLICKBACKBUTTON), "Back Button is displayed");
		}
		

	}
	

	public void clickBackButton() throws InterruptedException {
		try {
			
			clickBackTop();
			scrollToTop();
			waitForVisibility(CLICKBACKBUTTON);
			waitForElementToBeClickable(CLICKBACKBUTTON);
			if (isElementPresent(CLICKBACKBUTTON))
				;
			click(CLICKBACKBUTTON);
			// clickOnElementUsingJs(CLICKBACKBUTTON);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	Maker - Draft

	

	public void verifyDraftPageView() {

		verifyTrue(isElementPresent(DRAFTSCREEN), "Draft Screen is opened");

	}

	public void clickDraftXButton() {
		
			waitForElementToBeClickable(DRAFTXCLOSE);
			click(DRAFTXCLOSE);
		
	
		
	}

	public void clickDraftClose() {

		isElementPresent(DRAFTCLOSE);
		click(DRAFTCLOSE);
	}

	public void clickDraftRefresh() {

		waitForElementToBeClickable(DRAFTREFRESH);
		click(DRAFTREFRESH);
		verifyDraftPageView();

	}

	public void clickDraftDeleteAll() {
		try {
			waitForElementToBeClickable(CLICKDRAFTDELETEALL);
			clickOnElementUsingJs(CLICKDRAFTDELETEALL);
		} catch (Exception e) {
			clickDraftClose();
		}

	}

	public void verifyNoDraftFoundMessage() {
		try {
			waitUntilElementIsDisplayedOnScreen(DRAFTGRIDHEADER);
			WebElement GH = driver.findElement(DRAFTGRIDHEADER);

			boolean verifydata = false;
			String rwdata = "//*[contains(@class,'table table-bordered')]//tbody/tr[1]/td";
			WebElement eletemp = driver.findElement(By.xpath(rwdata));
			if (gettext(eletemp).equals("No Drafts Found")) {
				verifydata = true;
				verifyTrue(verifydata, " Data is not present in the Draft");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void clickIndividualDelete() {

		waitForElementToBeClickable(CLICKINDIVIDUALDELETE);
		click(CLICKINDIVIDUALDELETE);

	}

	

//	Maker - Advanced Search

	

	
	

	
	public void ShouldNotAllowToApproveOrReject()
	{
		boolean buttonEnabled=false;
		
		if(!INDIVIDUALAPPROVE.isEnabled() && !INDIVIDUALREJECT.isEnabled())
				buttonEnabled=true;
		verifyTrue(buttonEnabled, "Approve and Reject Button are disabled");
	}
	
	public void verifyDataInAdvancedSearch(String testdata) throws InterruptedException {
		Thread.sleep(1000);
		
		waitUntilElementIsDisplayedOnScreen(ADVSEARCHGRIDHEADER);
		WebElement GH = driver.findElement(ADVSEARCHGRIDHEADER);

		boolean verifydata = false;
		try {
			List<WebElement> hdrs = driver.findElements(ADVSEARCHGRIDHEADER);
			int hc = driver.findElements(ADVSEARCHGRIDHEADER).size();
			int rr = driver.findElements(ADVANCEDSEARCHTABLEROWS).size();
			for (int i = 1; i < rr; i++) {			
					
					for (int j = 1; j <= hc; j++) {
						String rwdata = "//masteradvasearch//tbody//tr[" + i + "]/td[" + (j) + "]/span";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						if (gettext(eletemp).equals(testdata)) {
							click(eletemp);
							verifydata = true;
							break;
						}
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			clickOnElementUsingJs(ADVANCEDSEARCHCLOSE);
		} finally {
			verifyTrue(verifydata, "Data is present in the Advanced Search Results");

		}
	}

	public void verifyInvalidDataInViewPageSearch() {
		try {
			waitUntilElementIsDisplayedOnScreen(GRIDVIEWCLOSE);
			boolean verifydata = false;
			String rwdata = "//ngb-modal-window//table//tbody/tr/td/div";
			waitUntilElementIsDisplayedOnScreen(By.xpath(rwdata));
			WebElement eletemp = driver.findElement(By.xpath(rwdata));
			if (gettext(eletemp).equals("No records found")) {
				verifydata = true;
			}
			verifyTrue(verifydata, "Invalid Data is not present in the View Page Search Results");
		} catch (Exception e) {
			clickViewPageClose();
		}

	}

	public void verifyInvaliddatainGlobalSearch() throws InterruptedException {
		String rwdata = "//table/tbody/tr/td";
		waitUntilElementIsDisplayedOnScreen(By.xpath(rwdata));
		boolean verifydata = false;
		WebElement eletemp = driver.findElement(By.xpath(rwdata));
		Thread.sleep(2000);
		if (gettext(eletemp).equals("No records found")) {
			verifydata = true;
		}
		verifyTrue(verifydata, "Invalid Data is not present in the Global Search Results");

	}

	public void verifyInvalidDataInAdvancedSearchTable() {

		waitUntilElementIsDisplayedOnScreen(ADVSEARCHGRIDHEADER);
		WebElement GH = driver.findElement(ADVSEARCHGRIDHEADER);
		boolean verifydata = false;
		String rwdata = "//masteradvasearch//table/tbody/tr/td";
		WebElement eletemp = driver.findElement(By.xpath(rwdata));
		if (gettext(eletemp).equals("No records found")) {
			verifydata = true;
		}
		verifyTrue(verifydata, "Invalid Data is not present in the Advanced Search Results");
	}

	public void clickDownloadInAdvancedSearch() {
		waitForElementToBeClickable(ADVSEARCHDOWNLOAD);
		click(ADVSEARCHDOWNLOAD);
	}

	public void clickExportToExcelInAdvancedSearch() {
		waitForElementToBeClickable(ADVSEARCHEXPORTTOEXCEL);
		click(ADVSEARCHEXPORTTOEXCEL);
	}

	public void clickExportToCSVInAdvancedSearch() {
		waitForElementToBeClickable(ADVSEARCHEXPORTTOCSV);
		click(ADVSEARCHEXPORTTOCSV);
	}

	public void verifyAdvancedSearchRefresh() {
		waitForElementToBeClickable(ADVANCEDSEARCHREFRESH);
		verifyTrue(isElementPresent(ADVANCEDSEARCHREFRESH), "Advanced Search Screen is opened");
		click(ADVANCEDSEARCHREFRESH);
	}

	public void verifyDataInAdvancedSearchPage(String testdata) throws Exception {
		Thread.sleep(2000);
		String temp[] = testdata.split(":");
		String header = temp[0];
		String data = temp[1];
		waitUntilElementIsDisplayedOnScreen(ADVSEARCHGRIDHEADER);
		WebElement GH = driver.findElement(ADVSEARCHGRIDHEADER);
		boolean verifydata = false;
		try {
			List<WebElement> hdrs = driver.findElements(ADVSEARCHGRIDHEADER);
			int hc = driver.findElements(ADVSEARCHGRIDHEADER).size();
			for (int i = 0; i < hc; i++) {
				// if (hdrs.get(i).getText().equals(header)) {
				if (hdrs.get(i).getText().equalsIgnoreCase(header)) {
					int rr = driver.findElements(ADVANCEDSEARCHTABLEROWS).size();
					for (int j = 1; j <= rr; j++) {
						String rwdata = "//masteradvasearch//tr[" + j + "]/td[" + (i + 1) + "]/span";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						if (gettext(eletemp).equals(data)) {
							// waitForElementToBeClickable(eletemp);
							doubleclickOnElementUsingActions(eletemp);
							verifydata = true;
							break;
						}

					}
					if (verifydata == true) {
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			clickBackButton();
		} finally {
			verifyTrue(verifydata, "Data is present in the Advanced Search Results");

		}
	}

	public void clickAdvancedSearchClear() {

		waitForElementToBeClickable(ADVANCEDSEARCHCLEAR);
		// click(ADVANCEDSEARCHCLEAR);
		clickOnElementUsingJs(ADVANCEDSEARCHCLEAR);
	}

//	Maker - Global Search

	public void enterValueinSearch(String data) {
		waitForElementToBeClickable(SEARCHTEXTINGRID);
		setvalue(SEARCHTEXTINGRID, data);
	}

	public void verifyAndOpenDataInGlobalSearch(String testdata) throws Exception {		
		String data = testdata;
		try {
			enterValueinSearch(data);
			Thread.sleep(2000);
			WebElement GH = driver.findElement(GRIDGLOBALCLOSE);
			waitForElementToBeClickable(GH);
			List<WebElement> hdrs = driver.findElements(GLOBALSEARCHHEADER);
			int hc = driver.findElements(GLOBALSEARCHHEADER).size();
			for (int i = 0; i < hc; i++) {
				// System.out.println(hdrs.get(i).getText());
				// if (hdrs.get(i).getText().equals(header)) {
				
					int rr = driver.findElements(TABLEROWS).size();
					for (int j = 1; j <= rr; j++) {
						String rwdata = "//*[@id='advSrchPanel']//table/tbody//tr[" + j + "]/td[" + (i + 1) + "]";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						if (gettext(eletemp).equals(data)) {
							doubleclickOnElementUsingActions(eletemp);
							break;
						}
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyAndOpenDataInGlobalSearch2(String testdata) throws Exception {		
		String data = testdata;
		try {
			enterValueinSearch(data);
			Thread.sleep(2000);
			WebElement GH = driver.findElement(GRIDGLOBALCLOSE);
			waitForElementToBeClickable(GH);
			List<WebElement> hdrs = driver.findElements(GLOBALSEARCHHEADER);
			int hc = driver.findElements(GLOBALSEARCHHEADER).size();
			int rr = driver.findElements(TABLEROWS).size();
			
			for (int i = 1; i <= hc; i++) {
				// System.out.println(hdrs.get(i).getText());
				// if (hdrs.get(i).getText().equals(header)) {
				
					
					for (int j = 1; j <= rr; j++) {
						String rwdata = "//*[@id='advSrchPanel']//table/tbody//tr[" + i + "]/td[" + j + "]";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						if (gettext(eletemp).equals(data)) {
							doubleclickOnElementUsingActions(eletemp);
							break;
						}
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickGlobalSearchClose() {

		waitForElementToBeClickable(SEARCHCLOSE);
		click(SEARCHCLOSE);

	}

	public void clickDownloadinSearch() {
		waitForElementToBeClickable(SEARCHDOWNLOAD);
		click(SEARCHDOWNLOAD);
	}

	public void clickExportToExcelinSearch() {
		waitForElementToBeClickable(SEARCHEXPORTTOEXCEL);
		click(SEARCHEXPORTTOEXCEL);
	}

	public void clickExportToCSVinSearch() {
		waitForElementToBeClickable(SEARCHEXPORTTOCSV);
		click(SEARCHEXPORTTOCSV);
	}

	public void verifySearchRefresh() {
		waitForElementToBeClickable(REFRESH);
		verifyTrue(isElementPresent(REFRESH), "Search Screen is opened");
		click(REFRESH);
	}

	public void verifyAndOpenDataInGlobalSearchPage(String testdata) {
		String temp[] = testdata.split(":");
		String header = temp[0];
		String data = temp[1];
		WebElement GH = driver.findElement(GLOBALSEARCHHEADER);
		waitForElementToBeClickable(GH);
		try {
			List<WebElement> hdrs = driver.findElements(GLOBALSEARCHHEADER);
			int hc = driver.findElements(GLOBALSEARCHHEADER).size();
			for (int i = 0; i < hc; i++) {
				if (hdrs.get(i).getText().equals(header)) {
					int rr = driver.findElements(TABLEROWS).size();
					for (int j = 1; j <= rr; j++) {
						String rwdata = "//*[contains(@class,'golbal-search infilter')]//table//tbody/tr[1]/td[1]/span";
						WebElement eletemp = driver.findElement(By.xpath(rwdata));
						if (gettext(eletemp).equals(data)) {
							waitForElementToBeClickable(eletemp);
							doubleclickOnElementUsingActions(eletemp);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

//	Maker - Pending Actions	

	

	public void filterPendingrecord(String code) throws Exception {
		verifyPendingActionsRefresh();
		setvalue(PENDINGRECORDSEARCH, code);

	}
	
	public void filterPendingrecordForDate(String code) throws Exception {
		verifyPendingActionsRefresh();
		setvalue(PENDINGRECORDSEARCH, changeDateFormat(code));

	}

	public void clickPendingActionXButton() {

		waitForElementToBeClickable(PENDINGACTIONXBUTTON);
		click(PENDINGACTIONXBUTTON);
	}

	

	public void enterValueinPendingActionSearch(String data) {

		waitForElementToBeClickable(SEARCHTEXTINPENDINGACTIONS);
		click(SEARCHTEXTINPENDINGACTIONS);
		clearvalue(SEARCHTEXTINPENDINGACTIONS);
		setvalue(SEARCHTEXTINPENDINGACTIONS, data);
	}

	public void verifyNoPendingRecordsMessage() throws InterruptedException {
		waitUntilElementIsDisplayedOnScreen(PENDINGACTIONSGRIDHEADER);
		WebElement GH = driver.findElement(PENDINGACTIONSGRIDHEADER);
		boolean verifydata = false;
		
		//String rwdatas = "//*[@id='layout-wrap']//table/tr[1]/td/div//span";
		String rwdatas = "//*[@id='layout-wrap']//following::table[2]//tbody//tr[1]//td//div//span";
		
		WebElement eletemps = driver.findElement(By.xpath(rwdatas));
		Thread.sleep(300);
		if (!gettext(eletemps).equals(" No Pending / Quick actions found ")) {
			verifydata = true;

		}

		verifyTrue(verifydata, "Invalid Data is not present in the Pending Actions");
	}

	public void verifyPendingActionsRefresh() {
		waitForElementToBeClickable(PENDINGACTIONSREFRESH);
		click(PENDINGACTIONSREFRESH);
		verifyTrue(isElementPresent(PENDINGACTIONSSCREEN), "Pending Actions Screen is opened");

	}

	public void clickSelectAll() {
		waitForElementToBeClickable(SELECTALLRECORDS);
		click(SELECTALLRECORDS);
	}

	public void clickDiffViewButton() {

		if(isElementPresent(CLICKDIFFERENTVIEW))
		{
		waitForElementToBeClickable(CLICKDIFFERENTVIEW);
		clickOnElementUsingJs(CLICKDIFFERENTVIEW);
		}
		
		if(isElementPresent(CLICKSUBACCOUNTDIFFERENTVIEW))
		{
		waitForElementToBeClickable(CLICKSUBACCOUNTDIFFERENTVIEW);
		clickOnElementUsingJs(CLICKSUBACCOUNTDIFFERENTVIEW);
		}

	}

	public void clickDiffViewXButton() {

		waitForElementToBeClickable(CLICKDIFFERENTVIEWX);
		click(CLICKDIFFERENTVIEWX);

	}

	

//	Checker - Pending Actions

	

	
	public void clickRejectWithoutReason() {

		waitForElementToBeClickable(REJECTWITHOUTREASON);
		click(REJECTWITHOUTREASON);

	}

	public void clickRejectReasonBoxCloseButton() {

		waitForElementToBeClickable(REJECTREASONBOXCLOSEBUTTON);
		isElementPresent(REJECTREASONBOXCLOSEBUTTON);
		click(REJECTREASONBOXCLOSEBUTTON);

	}

	public void clickDiffViewRejectButton() {

		waitForElementToBeClickable(DIFFERENTVIEWREJECT);
		click(DIFFERENTVIEWREJECT);
	}

	public void clickDiffViewRejectWithoutReason() {

		waitForElementToBeClickable(DIFFVIEWREJECTWITHOUTREASON);
		click(DIFFVIEWREJECTWITHOUTREASON);

	}

	public void clickDiffViewRejectReasonBoxCloseButton() {

		waitForElementToBeClickable(DIFFVIEWREJECTREASONBOXCLOSEBUTTON);
		isElementPresent(DIFFVIEWREJECTREASONBOXCLOSEBUTTON);
		click(DIFFVIEWREJECTREASONBOXCLOSEBUTTON);

	}

	public void clickPreviewRejectButton() {

		waitForElementToBeClickable(PREVIEWREJECT);
		clickOnElementUsingJs(PREVIEWREJECT);
	}

	public void clickPreviewSubmitButton() {

		waitForElementToBeClickable(PREVIEWREASONSUBMIT);
		click(PREVIEWREASONSUBMIT);

	}

	public void clickPreviewRejectWithoutReason() {

		waitForElementToBeClickable(PREVIEWREJECTWITHOUTREASON);
		click(PREVIEWREJECTWITHOUTREASON);

	}

	public void clickPreviewRejectReasonBoxCloseButton() {

		waitForElementToBeClickable(PREVIEWREJECTREASONBOXCLOSEBUTTON);
		isElementPresent(PREVIEWREJECTREASONBOXCLOSEBUTTON);
		click(PREVIEWREJECTREASONBOXCLOSEBUTTON);

	}

	public void clickRejectAll() {
		waitForElementToBeClickable(REJECTALL);
		click(REJECTALL);
	}

	

	public void clickDiffViewApproveButton() {

		waitForElementToBeClickable(DIFFERENTVIEWAPPROVE);
		click(DIFFERENTVIEWAPPROVE);
	}

	public void clickPreviewApproveButton() {

		waitForElementToBeClickable(PREVIEWAPPROVE);
		click(PREVIEWAPPROVE);
	}

	public void clickApproveAll() {
		waitForElementToBeClickable(APPROVEALL);
		click(APPROVEALL);
	}

	

}