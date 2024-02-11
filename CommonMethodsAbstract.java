package com.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.configurations.GlobaController;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;

import io.cucumber.java.Scenario;

public abstract class CommonMethodsAbstract extends AssertionsAbstract {

	protected static WebDriver driver;

	public final int timeOut = 10;
	Properties configProp = new Properties();
	protected FileInputStream configFis;
	protected File file = new File("");
	protected WebDriverWait wait;
	private static By AUTOLISTSEL = By.xpath(".//div[contains(@class,'ng-dropdown-panel-items')]");
	@FindAll({ @FindBy(id = "Save") })
	protected WebElement SAVE;
	
	@FindAll({@FindBy(xpath="//*[@id='warningsPanel']//h3//div//button//svg-icon")}) WebElement WARNINGPANEL;
	
	@FindAll({@FindBy(xpath="//scrollable-tabs//section//a//button//svg-icon")}) 
	protected WebElement CLOSETAB;
	
	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Save')]") })
	protected WebElement ALTERNATESAVE;
	
	
	@FindAll({ @FindBy(id = "alertClose") })
	WebElement ALERTCLOSE;
	@FindAll({ @FindBy(xpath = "//*[contains(@alt,'loader')]") })
	WebElement PROGRESSBAR;
	@FindAll({ @FindBy(id = "cancelBtn") })
	protected WebElement CLICKBACKBUTTON;
	@FindAll({ @FindBy(id = "pendingCloseButton") })
	WebElement PENDINGACTIONCLOSEBUTTON;
	@FindAll({ @FindBy(id = "pendingCloseIcon") })
	WebElement PENDINGCLOSEICON;
	@FindAll({ @FindBy(id = "advanceSearchCloseIcon") })
	protected WebElement ADVANCEDSEARCHCLOSE;
	
	@FindAll({ @FindBy(id = "backTop") })
	protected WebElement BACKTOP;
	
	@FindAll({ @FindBy(xpath = "//button[@title='Click to edit filters']") })
	protected WebElement CLICKFILTER;

	
	@FindAll({ @FindBy(id = "btnApplyGlobalFilter") })
	protected WebElement APPLYFILTER;
	
	@FindAll({ @FindBy(id = "btnClearGlobalFilter") })
	protected WebElement RESETFILTER;
	
	@FindAll({ @FindBy(xpath = "//button[@id='exportAsTxt']//*[@id='bi']") })
	protected WebElement EXPORTCSV;
	
	protected static String path = "src/test/resources";

	protected static File resourcefile = new File(path);
	protected static String absolutePath = resourcefile.getAbsolutePath();
//	protected String workingDir = System.getProperty("user.dir");
	protected String testfilepath = absolutePath + "/TestFiles/TestData/";
	
	protected String bodfilepath = absolutePath + "/TestFiles/BODFiles/";

	protected String ExpectedDataPath = absolutePath + "/TestFiles/TDAY/ER/";
	static int screenshotcount = 1;

	protected String Actualfilepath = absolutePath + "/TestFiles/TDAY/AR/";
	private final By GRIDHEADER = By.xpath("//*[@id='allocationGrid']//thead//th");
	private final By AMENDGRIDHEADER = By.xpath("//*[@id='amendGrid']//thead//th");
	private final By ORDERWISEGRIDHEADER = By.xpath("(//*[@id='orderWise']//p-table)[2]//thead//th");
	
	
	public CommonMethodsAbstract(WebDriver driver) throws IOException {
		super(driver);
		this.driver = GlobaController.driver;
		wait = new WebDriverWait(driver, timeOut);
	}
	
	
	

	
	// 01 Get Url

	public void get(String url) {

		driver.get(url);

	}

	// 02 Sendkeys Values

	public void setvalue(WebElement element, String value) {
		if(!element.getAttribute("value").equals(""))
		element.clear();
		element.sendKeys(value);
	}
	
	public void setfiles(WebElement element, String value) {
		
		mouseHoverElement(element);
		element.sendKeys(value);
	}
	
	
	public void setvalueinContractGrid(WebElement element, String value) {
		if (!element.getAttribute("value").equals(""))
			element.clear();
			element.sendKeys(value);
			element.sendKeys(Keys.ENTER);
	}
	
	public void setvalueinContractGridCalendar(WebElement element, String value) {
		if (!element.getAttribute("value").equals(""))
			element.sendKeys(Keys.CONTROL + "A");
			element.sendKeys(Keys.BACK_SPACE);
			element.sendKeys(value);
			element.sendKeys(Keys.ENTER);
	}

	// 03 Clear Values

	public void clearvalue(WebElement element) {
		element.clear();
	}

	// 04 Get Text

	public String gettext(WebElement element) {
		if(isElementPresent(element))
			return element.getText();
		else
			return "";
	}

	// 05 Get Attribute

	public String getAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	// 06 Navigate - To

	
	public void navigate(String url) {
		driver.navigate().to(url);
	}

	// 07 Actions - Mouse Over Actions - Click

	
	public void clickOnElementUsingActions(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click().perform();
	}

	// 08 Actions - Double Click

	public void doubleclickOnElementUsingActions(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick(element).perform();
	}

	// 09 Actions - Mouse Over Actions

	public void mouseHoverElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	// 10 Scroll To Element

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	

	// 11 Scroll To Top
	
	public static void scrollToTop() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1000)");
		} catch (Exception e) {
			System.out.println("SENTHIL");
		}
	}
	
	// 12 Scroll To Down
	
	public static void scrollToDown() throws InterruptedException {
		Thread.sleep(1000);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}  catch (Exception e) {
			System.out.println("LOGESH");
		}
		
		
		
	}
	
	// 13 Scroll To Element By Pixel
	
	public static void scrollToDownByPixel() throws InterruptedException {
		Thread.sleep(1000);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");
			
		} catch (Exception e) {
			System.out.println("LOGESH");
		}
	}
	
	
	// 14 Click

	public void click(WebElement element) {
		try {			
			driver.switchTo().activeElement();
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickMenu(WebElement element) throws Exception {
		Thread.sleep(500);
		mouseHoverElement(element);
		element.click();
	}

	
	
	// 15 Click A Element By Using Java Script

	
	public void clickOnElementUsingJs(WebElement element) {
		mouseHoverElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
	// 16 Click Auto Selection

	public void clickAutoSelection(WebElement element) {
		try {
			waitForElementToBeClickable(element);
			mouseHoverElement(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String method = "return document.getElementById('" + element.getAttribute("id")
					+ "').getBoundingClientRect();"; // document.getElementById('branchCode0').getBoundingClientRect();"
			// + id + "
			String name = js.executeScript(method).toString();
			Map<String, String> reconstructedUtilMap = Arrays.stream(name.split(",")).map(s -> s.split("="))
					.collect(Collectors.toMap(s -> s[0], s -> s[1]));
			
			method="document.body.scrollTop=" + (Double.parseDouble(reconstructedUtilMap.get(" top"))) + 10;
			js.executeScript(method,element);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 17 Get Integer Value

	
	public int getIntValue(String getInt) {
		Pattern intsOnly = Pattern.compile("\\d+");
		Matcher makeMatch = intsOnly.matcher(getInt);
		makeMatch.find();
		String inputInt = makeMatch.group();
		return Integer.parseInt(inputInt);
	}

	// 18 Get Title

	
	public String getTitle() {
		return driver.getTitle();
	}

	// 19 Wait - Wait For Page To Load

	
	public void waitForPageToLoad() {
		String pageLoadStatus;
		JavascriptExecutor js;

		do {
			js = (JavascriptExecutor) driver;
			pageLoadStatus = (String) js.executeScript("return document.readyState");

		} while (!pageLoadStatus.equals("complete"));

	}

	// 20 Wait - Is Element Present

	public boolean isElementPresent(WebElement targetElement) {
		Boolean isPresent = false;
		try {
			return isPresent = targetElement.isDisplayed();
		} catch (Exception ex) {
			ex.printStackTrace();
			return isPresent;
		}

	}
	
	

	// 21 Is Element Enabled
	
	public boolean isElementEnabled(WebElement targetElement) {
		Boolean isEnabled = false;
		try {
			isEnabled = targetElement.isEnabled();
			return isEnabled;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isEnabled;

	}

	// 22 Wait - Wait For Visibility

	
	public boolean waitForVisibility(WebElement targetElement) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
		//	wait.until(ExpectedConditions.visibilityOf(targetElement));
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is not visible: " + targetElement);
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}
	
	// 23 Click Back Top

	public void clickBackTop() {
		try {
			do {
			if (isElementPresent(BACKTOP))
				click(BACKTOP);
			Thread.sleep(300);
			}while(isElementPresent(BACKTOP));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	// 24 Wait - Wait Until Element Is Displayed On Screen

	public boolean waitUntilElementIsDisplayedOnScreen(By selector) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(selector));
			
			return true;
		} catch (Exception e) {
			// takeScreenshot();

			throw new NoSuchElementException(String.format("The following element was not visible : %s ", selector));

		}

	}

	// 25 Wait - Wait For Element To Be Clickable

	
	public boolean waitForElementToBeClickable(WebElement targetElement) {
		try {
			System.out.println(isElementPresent(targetElement));
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is not clickable: " + targetElement);
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}
	
	public void deleteFilesFromARFolder(File filepath) {
		try {
			 if (filepath.exists()) {
				 filepath.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waittillfiledownloadedAndRename(File filepath,File newfilename) throws Throwable
	{
		 int maxWaitSeconds = 60; // Adjust the maximum waiting time
	        int pollingInterval = 5; // Adjust the interval between checks

	        for (int seconds = 0; seconds < maxWaitSeconds; seconds += pollingInterval) {
	            if (filepath.exists()) {
	                System.out.println("File downloaded successfully!");
	                // Perform further actions on the downloaded file if needed
	                break;
	            }
	            Thread.sleep(pollingInterval * 1000); // Convert to milliseconds
	        }
	        
	        	filepath.renameTo(newfilename);
	        
	}
	
	public void waittillfiledownloaded(File filepath) throws Throwable
	{
		 int maxWaitSeconds = 60; // Adjust the maximum waiting time
	        int pollingInterval = 5; // Adjust the interval between checks

	        for (int seconds = 0; seconds < maxWaitSeconds; seconds += pollingInterval) {
	            if (filepath.exists()) {
	                System.out.println("File downloaded successfully!");
	                // Perform further actions on the downloaded file if needed
	                break;
	            }
	            Thread.sleep(pollingInterval * 1000); // Convert to milliseconds
	        }
	        
	}

	// 26 Wait - Wait For Invisibility

	
	public void waitForInvisibility(WebElement targetElement) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOf(targetElement));
			// wait.until(ExpectedConditions.invisibilityOf(targetElement));

		} catch (TimeoutException e) {
			System.out.println("Element is still visible: " + targetElement);
			System.out.println();
			System.out.println(e.getMessage());
		

		}
		
	}
	
	// 27 Wait - Wait Until File Download
	
	public void waitUntilFileDownload(String filepath)
	{
	
	WebDriverWait wait = new WebDriverWait(driver,60);
    wait.until(filepresent(filepath));
	}

	// 28 Find Element

	
	public WebElement findElement(WebElement targetElement) {
		try {
			WebElement element = targetElement;
			return element;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	// 29 Find Elements

	
	public List<WebElement> findElements(WebElement targetElement) {
		try {
			List<WebElement> element = (List<WebElement>) targetElement;
			return element;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	// 30 Click On Matching Value

	
	public void clickOnMatchingValue(List<WebElement> fetchedListElements, String valueToBeMatched) {

		for (WebElement element : fetchedListElements) {
			if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
				element.click();
				return;
			}
			// System.out.println(element.getText() );
		}
	}

	// 31 Click On Containing Value

	
	public void clickOnContainingValue(List<WebElement> fetchedListElements, String valueToBeContained) {

		for (WebElement element : fetchedListElements) {
			if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
				element.click();
				// System.out.println("Trying to select: "+valueToBeContained );
				return;
			}
			// System.out.println(element.getText() );
		}
	}

	// 32 Running Shell Command

	public static void runningShellCommand(String command) throws IOException, InterruptedException {
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(command);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while ((line = buf.readLine()) != null) {
		}
	}

	// 33 Alert - Accept Alert

	
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	// 34 Alert - Get Alert Text

	
	public String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			return alertText;
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	// 35 Alert - Is Alert Present

	
	public boolean isAlertPresent() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	// 36 Select - Select By Index

	
	public void selectValuefromDropdownUsingIndex(WebElement targetElement, int valueToBeSelectedindex) {
		Select selectFromDropdown = new Select(targetElement);
		selectFromDropdown.selectByIndex(valueToBeSelectedindex);

	}

	// 37 Select - Select By Visible Text

	public void selectValuefromDropdownUsingText(WebElement targetElement, String valueToBeSelected) {
		Select selectFromDropdown = new Select(targetElement);
		selectFromDropdown.selectByVisibleText(valueToBeSelected);

	}

	// 38 Is Selected

	public boolean isCheckboxSelected(WebElement element) {
		return element.isSelected();
	}

	// 39 Select From Auto Complete

	public void selectFromAutocomplete(WebElement element, String value) throws InterruptedException {
		try {
			setvalue(element, value);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		} catch (Exception ex) {

		}
	}

	// 40 Auto Complete List Selection

	public Boolean autoCompleteListSelection(WebElement selector, String val) throws InterruptedException {
		
		click(selector);
		
		Thread.sleep(1000);
		WebElement autoOptions = driver.findElement(AUTOLISTSEL);
		List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {
			for (WebElement option : optionsToSelect) {

				String getValue = option.getText().trim();

				// if (getValue.equalsIgnoreCase(val.trim())) {
				if (getValue.toUpperCase().startsWith(val.trim().toUpperCase())) {
					j.executeScript("arguments[0].click();", option);
					//option.click();
					return true;
				}

			}
		} catch (Exception e) {

		}
		return false;

	}

	// 41 Type And Select From Auto Complete List Selection
	
	public Boolean typeandSelectfromautoCompleteListSelection(WebElement selector, String val)
			throws InterruptedException {
		
		click(selector);
		Thread.sleep(100);
		setvalue(selector,val);
		Thread.sleep(500);
		waitUntilElementIsDisplayedOnScreen(AUTOLISTSEL);
		WebElement autoOptions = driver.findElement(AUTOLISTSEL);
		List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		try {
			for (WebElement option : optionsToSelect) {
				String getValue = option.getText();
				getValue = getValue.trim();
				if (getValue.contains(val)) {
					option.click();
					return true;
				}
			}
		} catch (Exception e) {

		}
		return false;

	}
	
	// 42 Take Screen Shot

	public void takeScreenshot(Scenario scenario) throws Exception {

		try {
			Random randNum = new Random();
			int number = randNum.nextInt(1000);
			// String destinationPath = (System.getProperty("user.dir") +
			// "\\Reports\\test-output\\").replace("\\", "/");

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String className = "embedded" + screenshotcount;
			File directory = new File(destinationPath);
			File[] files = directory.listFiles();
			for (File f : files) {
				if (f.getName().equals(className + ".png")) {
					screenshotcount = screenshotcount + 1;
					className = "embedded" + screenshotcount;
				}
			}
			FileUtils.copyFile(screenshotFile, new File(destinationPath + className + ".png"), true);
			scenario.attach(destinationPath + className + ".png", "image/png", "test");
			

		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
	}
	
	
	// 43 Close Existing Master Tab
	
	
	public void closeExistingMasterTab() throws InterruptedException {
		
		
		if(isElementPresent(CLOSETAB))
			click(CLOSETAB);
	}
	
	// 44 Click Alternate Save
	
	public void clickAlternateSave() throws InterruptedException {
		
		waitForElementToBeClickable(ALTERNATESAVE);
		clickOnElementUsingJs(ALTERNATESAVE);

	}
	
	// 45 Click Alert Close

	public void clickAlertClose() {
		if (isElementPresent(ALERTCLOSE))
			ALERTCLOSE.click();
	}
	
	// 46 Wait Till Progress Bar

	public void waitTillProgressBar() throws Exception {
		try {
			Thread.sleep(500);
			if (isElementPresent(PROGRESSBAR))
				waitForInvisibility(PROGRESSBAR);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void waitTillBODProgressBar(WebElement element) throws Exception {
		do {
			Thread.sleep(500);
		} while (isElementPresent(element));
	}
	
	// 47 Click Back Button If Enabled

	public void clickBackButtonIfEnabled() {
		try {
			if (isElementPresent(CLICKBACKBUTTON))
				CLICKBACKBUTTON.click();
			if (isElementPresent(PENDINGACTIONCLOSEBUTTON))
				PENDINGACTIONCLOSEBUTTON.click();

			if (isElementPresent(PENDINGCLOSEICON))
				PENDINGCLOSEICON.click();

			if (isElementPresent(ADVANCEDSEARCHCLOSE))
				ADVANCEDSEARCHCLOSE.click();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 48 Date Picker New
	
	public void DatePicker_New(WebElement selector, String getDate) {
		try {
			click(selector);
			String[] date1 = Splitdate(getDate);
			String GetYear = date1[2];
			String Getmonth = date1[1];
			String getDated = date1[0];
			selectyear(GetYear, 1);
			selectmonth(Getmonth);
			Thread.sleep(500);
			selectdate(getDated);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 49 Select Year
	
	public void selectyear(String GetYear, int y) throws InterruptedException {
		if (y == 1) {

			driver.findElement(By.xpath("//*[@class='myDpHeaderBtn myDpYearBtn myDpYearLabel']")).click();

			driver.findElement(By.xpath("//*[@class='myDpHeaderBtn myDpYearBtn myDpYearLabel']")).getAttribute(GetYear);

		}
		String ds = driver.findElement(By.xpath("//*[@class='myDpHeaderBtn myDpYearBtn myDpYearLabel']")).getText();
		String temp[] = ds.split(" - ");
		if ((Integer.parseInt(temp[0].toString()) <= Integer.parseInt(GetYear.toString()))
				&& (Integer.parseInt(temp[1].toString()) >= Integer.parseInt(GetYear.toString()))) {
			try {
				driver.findElement(
						By.xpath("*//span[contains(@class,'myDpYearValue') and normalize-space()='" + GetYear + "']"))
						.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		} else if (Integer.parseInt(temp[0].toString()) > Integer.parseInt(GetYear.toString())) {
			driver.findElement(By.xpath("//*[@class='myDpPrevBtn']")).click();
		} else if (Integer.parseInt(temp[0].toString()) < Integer.parseInt(GetYear.toString())) {
			driver.findElement(By.xpath("//*[@class='myDpNextBtn']")).click();
		}

		y = y + 1;
		selectyear(GetYear, y);
	}
	
	// 50 Select Month

	public void selectmonth(String Getmonth) {

		driver.findElement(By.xpath("//*[contains(@class,'myDpMonthBtn')]")).click();
		waitForVisibility(driver.findElement(By.xpath(
				"*//span[contains(@class,'myDpMonthNbr')]//following-sibling::span[text()='" + Getmonth + "']")));

		driver.findElement(By
				.xpath("*//span[contains(@class,'myDpMonthNbr')]//following-sibling::span[text()='" + Getmonth + "']"))
				.click();

	}
	
	// 51 Select Date

	public void selectdate(String getDate) {
		waitForVisibility(driver.findElement(By.xpath(
				"//*[contains(@class,'myDpCurrMonth') and normalize-space()='" + Integer.parseInt(getDate) + "']")));
		driver.findElement(By.xpath(
				"//*[contains(@class,'myDpCurrMonth') and normalize-space()='" + Integer.parseInt(getDate) + "']"))
				.click();
	}

	// 52 Split Date
	
	private static String[] Splitdate(String getdateplit) {
		try {
			return getdateplit.split("-");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// 54 Compare Expected And Actual Excel Values
	
	public boolean compareExpectedandActualExcelvalues(String ExpectedFile, String ActualGrid) throws Exception {
		FilecompareApplication fc=new FilecompareApplication();
		String ActualFile = null;
		int[] columnsToIgnore = {}; 
		// Assigning id for the grid based upon the grid selection
		switch (ActualGrid) {
		case "OrderReconSummary":// Broker Collateral
			ActualFile = Actualfilepath +"Order Recon Report.xlsx";// grdCollateralLimit_Broker
			columnsToIgnore= new int[]{};
			break;
			
		case "Contract":// Broker Collateral
			ActualFile = Actualfilepath +"Contract.xlsx";// grdCollateralLimit_Broker
			columnsToIgnore= new int[]{3,4};
			break;
			
		
		default:
			break;
		}	
		waitUntilFileDownload(ActualFile);
		
		return fc.compareTwoExcelFiles(ExpectedFile,ActualFile,columnsToIgnore);	

	}
	
	public boolean compareresult(String tableid,String Actfilename,String Newfilename,String expectedFile,String comparisonType) throws Throwable
	{
		
		FilecompareApplication fc=new FilecompareApplication();
		By tableLocator =By.id(tableid);// By.id("tableId"); // Adjust the locator according to your table
		mouseHoverElement(driver.findElement(tableLocator));
        WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(tableElement, By.tagName("tr")));
        File file=new File(Actualfilepath + Newfilename);
        File actfile=new File(Actualfilepath + Actfilename);
        File expectedfile=new File(ExpectedDataPath +expectedFile);
        deleteFilesFromARFolder(file);
        try {
        if(isElementPresent(driver.findElement(By.xpath("//*[contains(@class,'p-datatable-header')]"))))
	    mouseHoverElement(driver.findElement(By.xpath("//*[contains(@class,'p-datatable-header')]")));
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
		click(EXPORTCSV);
		waittillfiledownloadedAndRename(actfile,file);
		if(comparisonType.equals("WebTable"))
			return fc.compareWebtableWithCSVFile(expectedfile , "//*[@id='"+tableid+"']//table/tbody/tr");
		else
	
			return fc.CompareFile(expectedfile,file);
		
	}
	
	
	// 55 File Present
	
	public ExpectedCondition<Boolean> filepresent(String filepath) {
	    return new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	            File f = new File(filepath); 
	            return f.exists();
	        }
	        @Override
	        public String toString() {
	          return String.format("file to be present within the time specified");
	        }
	    };
	}
	
	// 56 Fetch Record From File

	@SuppressWarnings("resource")
	public List<String[]> fetchrecordfromfile(String filepath) throws Exception {
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> li = reader.readAll();
		System.out.println(li);
		return li;

	}
	
	// 57 Change Date Format

	public String changeDateFormat(String date) throws Exception {
		SimpleDateFormat dft = new SimpleDateFormat("dd-MMM-yyyy");
		Date dff = dft.parse(date);
		dft = new SimpleDateFormat("dd-MM-yyyy");
		String dt = dft.format(dff);
		return dt;
	}

	// 58 Compare Manual Allocation Data
	
	public boolean compareManualAllocationData(List<String[]> expected, List<String[]> actual, String mismatch) {
		/*
		 * for (int i = 1; i < actual.size(); i++) { String symbol = actual.get(i)[0];
		 * String limit = actual.get(i)[1]; boolean matched = false; for (int j = 0; j <
		 * expected.size(); j++) { if (!symbol.equals(mismatch)) { if
		 * (expected.get(j).get("SYMBOL").equals(symbol) &&
		 * expected.get(j).get("QTY_LIMIT").equals(limit.trim())) { matched = true;
		 * break; } } else { matched = true; break; } } if (!matched) { return false; }
		 * 
		 * }
		 */
		return true;

	}

	// 59 Object Mapper
	
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.setTimeZone(TimeZone.getDefault());
		return mapper;
	}
	
	

	// 61 Find Using Common IO
	
	public static File findUsingCommonsIO(String sdir) {
		File dir = new File(sdir);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			File lastModifiedFolder = Arrays.stream(files).filter(File::isDirectory)
					.max(Comparator.comparing(File::lastModified)).orElse(null);
			if (lastModifiedFolder != null) {
				File latestDir = new File(lastModifiedFolder.getPath() + "//Reports");
				if (latestDir.isDirectory()) {
					File[] dirFiles = latestDir.listFiles((FileFilter) FileFilterUtils.fileFileFilter());
					return dirFiles.length > 0 ? dirFiles[0] : null;
				}
			}
		}

		return null;
	}
	
	
	// 62 Get Header Column No
	
	public int getheadercolumnno(String Header) throws IOException, InterruptedException {
		waitUntilElementIsDisplayedOnScreen(GRIDHEADER);
		List<WebElement> hc = driver.findElements(GRIDHEADER);
		for (int o = 0; o < hc.size(); o++) {
			if (hc.get(o).getAttribute("innerText").trim().toUpperCase().contains(Header.trim().toUpperCase())) {
				return o;
			}
		}
		return 0;
	}
	
	// 63 Get Header Column No In Amend Grid
	
	public int getheadercolumnnoInAmendGrid(String Header) throws IOException, InterruptedException {
		waitUntilElementIsDisplayedOnScreen(AMENDGRIDHEADER);
		List<WebElement> hc = driver.findElements(AMENDGRIDHEADER);
		for (int o = 0; o < hc.size(); o++) {
			if (hc.get(o).getAttribute("innerText").trim().toUpperCase().contains(Header.trim().toUpperCase())) {
				return o;
			}
		}
		return 0;
	}
	
	// 64 Order Wise Gridget Header Column No
	
	public int orderWiseGridgetheadercolumnno(String Header) throws IOException, InterruptedException {
		waitUntilElementIsDisplayedOnScreen(ORDERWISEGRIDHEADER);
		List<WebElement> hc = driver.findElements(ORDERWISEGRIDHEADER);
		for (int o = 0; o < hc.size(); o++) {
			if (hc.get(o).getAttribute("innerText").trim().toUpperCase().contains(Header.trim().toUpperCase())) {
				hc.get(o).click();
				return o;
			}
		}
		return 0;
	}
	
	
	public void filetransfertobodpath(File source, String destinationPath) throws IOException {
		
		copyFileUsingChannel(source, destinationPath);
	}
	
	@SuppressWarnings("resource")
	public void copyFileUsingChannel(File source, String dest) throws IOException {
		FileChannel sourceChannel = null;
		FileChannel destChannel = null;
		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destChannel = new FileOutputStream(dest).getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		} finally {
			sourceChannel.close();
			destChannel.close();
		}
	}
	
	
	
	// 65 Change date Format from dd-MM-yyyy to yyyy-MM-dd

    public String changeDateFormats(String date) throws Exception {
        SimpleDateFormat dft = new SimpleDateFormat("dd-MMM-yyyy");
        Date dff = dft.parse(date);
        dft = new SimpleDateFormat("yyyy-MM-dd");
        String dt = dft.format(dff);
        return dt;
    }
    
    public void AllfilesFromAFolder(String folderPath)
    {
    	
           File folder = new File(folderPath);

           // Check if the specified path is a directory
           if (folder.isDirectory()) {
               File[] files = folder.listFiles();

               if (files != null) {
                   for (File file : files) {
                       if (file.isFile()) {
                           System.out.println("File Name available :" + file.getName());
                       }
                   }
               } else {
                   System.out.println("The folder is empty.");
               }
           } else {
               System.out.println("The specified path is not a directory.");
           }
       }
    
 // Get the list of columns
 	private static List<String> getColumns(String query) {
 		List<String> columns = new ArrayList<>();
 		query = query.substring("select ".length(), query.indexOf("from"));
 		String[] cols = query.split(",");
 		for (String obj : cols) {
 			columns.add(obj.trim());
 		}
 		return columns;
 	}
    
	// Comparing the testdata
	public static boolean compareData(String sqlquery,String expectedResult) {
		ConnectDB cdb=new ConnectDB();
		 List<Map<String, String>> sqloutput = cdb.selectsql(sqlquery);
		// TODO Auto-generated method stub
		String[] arrRows = expectedResult.split("#");
		List<String> expectedRows = new ArrayList<>();
		for (String t : arrRows) {
			// Add each element into the list
			expectedRows.add(t);

		}
		List<String> columns = getColumns(sqlquery);
		List<String> actualRows = new ArrayList<>();
		for (Map<String, String> map : sqloutput) {
			String actual = "";
			for (String entry : columns) {
				actual += StringUtils.isNotBlank(actual) ? ":" + map.get(entry) : map.get(entry);

			}
			actualRows.add(actual);
		}

		List<String> match = new ArrayList<>();
		List<String> mismatch = new ArrayList<>();
		for (String actual : actualRows) {
			if (expectedRows.contains(actual)) {
				match.add(actual);
			} else {
				mismatch.add(actual);
			}
		}

		return mismatch.isEmpty() ? true : false;
	}
    
	
	
	// Scroll Down
	
	

}
