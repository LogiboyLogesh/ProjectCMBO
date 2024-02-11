package com.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.framework.CommonMethodsAbstract;
import com.framework.ConnectDB;
import com.model.BankModel;

public class BankPage extends CommonMethodsAbstract{
	
	public BankPage(WebDriver driver) throws IOException {

		super(driver);
		PageFactory.initElements(driver, this);
	}

	private List<BankModel> scenarioDataList;

	public List<BankModel> getScenarioDataList() {
		return scenarioDataList;
	}

	public void setScenarioDataList(List<BankModel> scenarioDataList) {
		this.scenarioDataList = scenarioDataList;
	}

	// public Map<String, String> instrumentTypeModelTestData;

	// Screen Validation Elements

	@FindAll({ @FindBy(linkText = "Bank") })
	WebElement BANKMENU;
	@FindAll({ @FindBy(xpath = "//span[text()=' Bank ']") })
	WebElement BANKMENUSCREEN;
	@FindAll({ @FindBy(xpath = "//span[contains(text(),' Bank ')]") })
	WebElement BANKMENUTAB;

	// Add New Page Elements

	@FindAll({ @FindBy(id = "bankCodebankCode") })
	WebElement BANKCODE;
	@FindAll({ @FindBy(id = "bankNamebankName") })
	WebElement BANKNAME;
	@FindAll({ @FindBy(id = "bankShortNamebankShortName") })
	WebElement BANKSHORTNAME;
	

	// Advanced Search Elements

	@FindAll({ @FindBy(id = "srchcodesrchcode") })
	WebElement ADVANCEDBANKCODESEARCH;
	@FindAll({ @FindBy(id = "srchnamesrchname") })
	WebElement ADVANCEDBANKNAMESEARCH;
	@FindAll({ @FindBy(id = "srchshrtnamesrchname") })
	WebElement ADVANCEDBANKSHORTNAMESEARCH;
	

	// Common Elements

	@FindAll({ @FindBy(id = "pendingActionsSearchInput") })
	WebElement PENDINGRECORDSEARCHVALUE;
	@FindAll({ @FindBy(xpath = "//scrollable-tabs//section//a//button[2]//svg-icon") })
	WebElement BANKCLOSETAB;
	@FindAll({ @FindBy(id = "cacheReloadBtn") })
	WebElement CACHERELOAD;
	@FindAll({ @FindBy(xpath = "//*[contains(@class,'loader-wrapper')]") })
	WebElement PROGRESSBAR;
	@FindAll({ @FindBy(xpath = "//*[@id='isRejectedList']") })
	WebElement REJECTEDRECORDCHECKBOX;

	// Existing Records Clear

	public void deleteBankMasterRecord(List<BankModel> itm) throws Exception {
		String temp = "";
		for (int i = 0; i < itm.size() - 1; i++) {
			if (!itm.get(i).getScenarioType().equals("ValidSearch")) {
				if (i == itm.size() - 2)
					temp = temp + "'" + itm.get(i).getBankCode() + "'";
				else
					temp = temp + "'" + itm.get(i).getBankCode() + "',";
			}
		}

		ConnectDB cdb = new ConnectDB();
		String sql = "DELETE FROM M_BANK WHERE BANK_CODE IN(" + temp + ");";
		cdb.deleteSql(sql);

	}

	// Maker

	public void openBankMenu() throws InterruptedException {
		clickBackButtonIfEnabled();
		
		if (!isElementPresent(BANKMENUTAB)) {
			Thread.sleep(500);
			scrollToElement(BANKMENU);
			waitForElementToBeClickable(BANKMENU);
			click(BANKMENU);
		}

	}

	public void verifyBankScreenIsOpened() throws Exception {

		waitForVisibility(BANKMENUSCREEN);
		verifyTrue(isElementPresent(BANKMENUSCREEN), "Bank Page is displayed");

	}

	public void enterValuesInBankMasterAddMode(List<BankModel> itm)
			throws Exception {

		String[] tempbankcode = itm.get(0).getBankCode().split(":");
		String[] tempbankname = itm.get(0).getBankName().split(":");
		String[] tempbankshortname = itm.get(0).getBankShortName().split(":");
		

		clickBackTop();
		scrollToTop();

		waitForVisibility(BANKCODE);
		setvalue(BANKCODE, tempbankcode[tempbankcode.length - 1]);
		setvalue(BANKNAME, tempbankname[tempbankname.length - 1]);
		setvalue(BANKSHORTNAME, tempbankshortname[tempbankshortname.length - 1]);

	}

	public void enterBankValueInPendingActionsSearch(List<BankModel> itm)
			throws Exception {

		waitForElementToBeClickable(PENDINGRECORDSEARCHVALUE);
		waitForVisibility(PENDINGRECORDSEARCHVALUE);
		setvalue(PENDINGRECORDSEARCHVALUE, itm.get(0).getBankCode());

	}

	// Both

	public void editBankValuesFromGlobalSearch(List<BankModel> itm)
			throws Exception {

		clickBackTop();
		scrollToTop();

		waitForVisibility(BANKNAME);
		setvalue(BANKNAME, itm.get(0).getBankName());
		setvalue(BANKSHORTNAME, itm.get(0).getBankShortName());
		
	}

	public void clickBankRejectedRecordCheckBox() {

		waitForElementToBeClickable(REJECTEDRECORDCHECKBOX);
		click(REJECTEDRECORDCHECKBOX);

	}

	public void enterBankCodeInAdvancedSearch(List<BankModel> itm) {

		waitForElementToBeClickable(ADVANCEDBANKCODESEARCH);
		String[] temp = itm.get(0).getBankCode().split(":");
		setvalue(ADVANCEDBANKCODESEARCH, temp[temp.length - 1]);

	}

	public void enterBankNameInAdvancedSearch(List<BankModel> itm) {

		waitForElementToBeClickable(ADVANCEDBANKNAMESEARCH);
		String[] temp = itm.get(0).getBankName().split(":");
		setvalue(ADVANCEDBANKNAMESEARCH, temp[temp.length - 1]);

	}
	
	public void enterBankShortNameInAdvancedSearch(List<BankModel> itm) {

		waitForElementToBeClickable(ADVANCEDBANKSHORTNAMESEARCH);
		String[] temp = itm.get(0).getBankShortName().split(":");
		setvalue(ADVANCEDBANKSHORTNAMESEARCH, temp[temp.length - 1]);

	}

	// Screen Close

	public void clickBankCloseTab() {

		waitForElementToBeClickable(BANKCLOSETAB);
		click(BANKCLOSETAB);

	}

	

	// Getting Data From Excel Sheet

	public List<BankModel> getScenarioTestData(String excelfile, String sheetname)
			throws IOException {
		System.out.println("Excel File data read process Initiated");
		String excelpath = testfilepath + excelfile + ".xlsx";
		String resultValue = "[";
		File file = new File(excelpath);
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetname);
			System.out.println("Test Data Sheet Name: " + sh.getSheetName());
			int rownum = 0;
			int rowcount = sh.getLastRowNum();
			int columnheaderscount = sh.getRow(0).getLastCellNum();

			List<String> heading = new ArrayList<String>();
			for (int i = 0; i <= columnheaderscount - 1; i++) {
				String columnheader = sh.getRow(0).getCell(i).toString();
				heading.add(columnheader.trim());
			}

			Map<String, String> totalrowvalue = new HashMap<String, String>();

			for (int k = 1; k <= rowcount; k++) {
				resultValue = resultValue + "{";
				String columnheader = sh.getRow(k).getCell(0).toString();

				int columncount = sh.getRow(k).getLastCellNum();
				for (int j = 0; j < columncount; j++) {

					String Clmvalue;
					try {
						Clmvalue = sh.getRow(k).getCell(j).toString();
					} catch (Exception e) {
						Clmvalue = "";
					}

					String clmHead = heading.get(j);
					if (Clmvalue.contains("[a-zA-Z]") == false) {
						if (Clmvalue.contains(".")) {
							String txt[] = Clmvalue.split("\\.0");
							String val = txt[0];
							Clmvalue = val.trim();
						}
					}
					totalrowvalue.put(clmHead, Clmvalue);
					resultValue = resultValue + "\"" + clmHead + "\":\"" + Clmvalue + "\"";
					if (j < columncount - 1) {
						resultValue = resultValue + ",";
					}

				}
				resultValue = resultValue + "}";
				if (k < rowcount) {
					resultValue = resultValue + ",";
				}
			}
			resultValue = resultValue + "]";
			System.out.println("Excel File data read process Completed");

		}

		List<BankModel> scenarioList = objectMapper().readValue(resultValue,
				new TypeReference<List<BankModel>>() {
				});

		setScenarioDataList(scenarioList);
		return scenarioList;
	}

	public List<BankModel> getSpecificUserAndScenarioTestData(
			List<BankModel> testdata, String userId, String scenarioId) throws IOException {

		if (!scenarioId.equals(""))
			return testdata.stream()
					.filter(f -> f.getUserType().equals(userId) && f.getScenarioType().equals(scenarioId))
					.collect(Collectors.toList());
		else
			return testdata.stream().filter(f -> f.getUserType().equals(userId) && !f.getScenarioType().equals("Draft"))
					.collect(Collectors.toList());

	}


}
