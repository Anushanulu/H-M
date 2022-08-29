package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class ResaleAdminPage {
	private WebDriver driver = TestBase.getDriver();

	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	// Login other account
	@FindBy(xpath = "//div[text()='Use another account']")
	private WebElement useOtherAcc;

	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;
	
	// Login to Resale admin app
	@FindBy(name = "loginfmt")
	private WebElement app_emailID;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Nextbtn;
	@FindBy(name = "passwd") // xpath = "//*[@name='passwd']
	private WebElement app_password;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Signin;
	@FindBy(name = "DontShowAgain")
	private WebElement DontShowcheckbox;
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement yesbtn;
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement close_icon;

	// changing role of a user
	@FindBy(xpath = "//div[text()='Manage users']")
	private WebElement manage_users;
	@FindBy(xpath = "//div[text()='All Items']/parent::div[@class='appmagic-button middle left']")
	private WebElement all_items;
	@FindBy(xpath = "//input[@appmagic-control='txtSearchMUStextbox']")
	private WebElement searchbox;
	@FindBy(xpath = "//div[text()='powerappstest@storelens.com']")
	private WebElement email_id;
	@FindBy(xpath = "//*[contains(@class,'react-combobox-view')]//ancestor::div//div[@data-control-name='cbNewUserRoleMUS']") // (//*[@class='selectedItem_7e8qnb'])[1]
	private WebElement roleList; // //li[@class='selectedItem_7e8qnb']/span
	@FindBy(xpath = "//div[text()='SAVE']/parent::div[@class='appmagic-button middle center']")
	private WebElement save;

	// Selecting Brand, store, country
	/*
	 * @FindBy(xpath = "(//*[@class='selectedItem_7e8qnb'])[2]") private WebElement
	 * brandName;
	 */
	@FindBy(xpath = "//button[contains(@class,'buttonReset')]")
	private WebElement cancelIcon;
	@FindBy(xpath = "//*[@aria-label='Brand']")
	private WebElement brandEntryBox;
	@FindBy(xpath = "(//*[@class='selectedItem_7e8qnb'])[3]")
	private WebElement countryName;
	@FindBy(xpath = "(//*[@class='selectedItem_7e8qnb'])[4]")
	private WebElement storeName;

	@FindBy(xpath = "//div[@id='meInitialsButton']") // *[@class='_2uCPXE6i21lbm_D8HQgftF']
	private WebElement Sicon;
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signoutBtn;

	// Selecting specific store from the list
	@FindBy(xpath = "//div[@data-container-name='contStore-container']//div[@data-control-name='icnEditStoreSelection']//div[@class='powerapps-icon no-focus-outline']")
	private WebElement penIcon;
	@FindBy(xpath = "//div[@data-control-name='ddBrand']")
	private WebElement brandList;
	@FindBy(xpath = "//div[@data-control-name='ddCountry']")
	private WebElement countryList;
	@FindBy(xpath = "//div[@data-control-name='ddStore']")
	private WebElement storeList;
	@FindBy(xpath = "//*[text()='OK']/parent::div")
	private WebElement okBtn;

	@FindBy(xpath = "//*[text()='User saved successfully']")
	private List<WebElement> usersavedmsg;
	@FindBy(xpath = "//button[contains(@aria-label,'Remove')]")
	private WebElement xicon;
	@FindBy(xpath = "//div[@class='toast-message']")
	private List<WebElement> Successmessage;

	// Brand settings
	/*
	 * @FindBy(xpath =
	 * "(//div[text()='Brand settings']/parent::div[@class='appmagic-button middle left'])[2]"
	 * ) private WebElement brandsettingsleftpanel;
	 * 
	 * @FindBy(xpath = "//div[@data-control-name='cbBrandBSS']") private WebElement
	 * brandsettingsdropdown;
	 * 
	 * @FindBy(
	 * xpath="//ul[contains(@class,'appmagic-combobox-itemlist itemsContainer')]//span[text()='other-stories']"
	 * ) private WebElement dropdownVal;
	 * 
	 * @FindBy(xpath = "//div[@class='appmagic-toggleSwitch-off']") private
	 * WebElement toggleBtn;
	 */
	@FindBy(xpath = "//input[@appmagic-control='txtStoreContactEmailBSStextbox']")
	private WebElement storeCntctEmail;
	@FindBy(xpath = "//div[contains(@data-control-name,'btnSave')]//*[text()='SAVE SETTINGS']")
	private WebElement saveSettings;

	@FindBy(xpath = "//*[text()='Edit User']")
	private WebElement editUser;

	Testutil util = new Testutil();

	// User saved successfully
	public ResaleAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void invokeBrowser(WebDriver driver) {
		/*
		 * this.driver = driver; PageFactory.initElements(driver, this);
		 */
		/*
		 * String a = "window.open('about:blank','_blank');";
		 * ((JavascriptExecutor)driver).executeScript(a);
		 */
		// driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL,Keys.SHIFT+"n");
		ChromeOptions o = new ChromeOptions();

		o.addArguments("--incognito");
		// DesiredCapabilities object
		DesiredCapabilities c = DesiredCapabilities.chrome();
		// set capability to browser
		c.setCapability(ChromeOptions.CAPABILITY, o);
		new ChromeDriver(o);
		driver.get("https://www.tutorialspoint.com/index.htm ");

	}

	public void resaleAdminLogin(String userid, String password) throws InterruptedException {
		app_emailID.sendKeys(userid);
		Nextbtn.click();
		Wait.elementToBeClickable(driver, app_password, 2);
		app_password.sendKeys(password);
		Wait.elementToBeClickable(driver, Signin, 2);
		// Signin.click()
		util.actionMethodClick(driver, Signin);
		Wait.untilPageLoadComplete(driver, 10);
		/*
		 * DontShowcheckbox.click(); yesbtn.click();
		 */
		Wait.untilPageLoadComplete(driver, 30);
		close_icon.click();
		TargetLocator currentFrame = driver.switchTo();
		currentFrame.frame("fullscreen-app-host");
	}

	public void goToManageusers() {
		//manage_users.click();
		util.actionMethodClick(driver, manage_users);
	}

	public void userSelection(String searchtext, String role) throws InterruptedException {
		Wait.untilPageLoadComplete(driver, 2);
		util.jsclick(driver, searchbox);
		try {
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		searchbox.sendKeys(searchtext, Keys.ENTER);
		// WebElement we1 =driver.findElement(By.xpath("//div[@class='appmagic-label
		// no-focus-outline middle']//div[text()='"+searchtext+"']"));
		// WebElement
		// we1=driver.findElement(By.xpath("(//div[text()='powerappstest@storelens.com']/ancestor::div[contains(@class,'appmagic-content')]/following-sibling::div//div[contains(@class,'powerapps-icon')])[1]"));
		/*
		 * @@@@This is in dev@@@@@ WebElement we1 =
		 * driver.findElement(By.xpath("(//div[text()='" + searchtext +
		 * "']/ancestor::div[contains(@class,'appmagic-content')]/following-sibling::div//div[contains(@class,'powerapps-icon')])[1]"
		 * ));
		 */
		WebElement we1 = driver.findElement(By.xpath("//div[text()='" + searchtext
				+ "']/ancestor::div[@class='appmagic-content-control-name appmagic-control-view canvasContentDiv _vst_']/preceding-sibling::div//div[@class='powerapps-icon no-focus-outline'] "));
		// @@@@@//div[text()='powerappstest@storelens.com']/ancestor::div[@class='appmagic-content-control-name
		// appmagic-control-view canvasContentDiv
		// _vst_']/preceding-sibling::div//div[@class='powerapps-icon no-focus-outline']
		Wait.elementToBeClickable(driver, we1, 3);
		/*
		 * Actions actions = new Actions(driver); Wait.elementToBeClickable(driver, we1,
		 * 5); actions.moveToElement(we1).click().build().perform();
		 */
		util.jsclick(driver, we1);
		// util.actionMethodClick(driver, we1);
		roleList.click();
		// util.actionMethodClick(driver, roleList);
		WebElement resetBtn = driver.findElement(By.xpath("//*[contains(@class,'buttonReset')]"));
		resetBtn.click();
		WebElement we = driver.findElement(
				By.xpath("//*[text()='" + role + "']/parent::div[contains(@class,'itemTemplateContainer')]"));

		// ul[@aria-label='Role items']//*[text()='" + role + "']
		if (role.equalsIgnoreCase("Store User")) {
			we.click();
		} else if (role.equalsIgnoreCase("Brand User")) {
			we.click();
		} else {
			we.click();
		}
		/*
		 * Wait.elementToBeClickable(driver, save, 2); save.click();
		 */

	}

	public void selectBrand(String NameOfTheBrand) throws InterruptedException {
		// Thread.sleep(3000);
		List<WebElement> brandName = driver.findElements(By.xpath("//div[contains(@aria-label,'Brand. Selected: ')]"));
		Boolean flag = false;
		while (!flag) {
			for (int i = 0; i < brandName.size(); i++) {
				if (isClickable(brandName.get(i))) {
					// ele.get(i).click();
					util.actionMethodClick(driver, brandName.get(i));
					flag = true;
					i = brandName.size();
				}
			}
		}

		/*
		 * Wait.elementToBeClickable(driver, brandName, 3); brandName.click();
		 */
		Wait.elementToBeClickable(driver, cancelIcon, 3);
		util.jsclick(driver, cancelIcon);
		Actions action = new Actions(driver);
		WebElement we = driver
				.findElement(By.xpath("//*[@class='itemTemplateLabel_dqr75c' and text()='" + NameOfTheBrand + "']"));
		Wait.waitUntilElementVisible(driver, we);
		action.moveToElement(we).click().perform();
		Wait.untilPageLoadComplete(driver, 10);
		System.out.println("Selected Brand");
	}

	public void selectCountry(String NameOfTheCountry) {
		Wait.elementToBeClickable(driver, countryName, 2);
		System.out.println("Select country");
		countryName.click();
		System.out.println("Selected country");
		Wait.elementToBeClickable(driver, cancelIcon, 2);
		cancelIcon.click();
		System.out.println("clicked on cancle icon");
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(
				By.xpath("//*[@class='itemTemplateLabel_dqr75c' and contains(text(),'" + NameOfTheCountry + "')]"));
		Wait.elementToBeClickable(driver, we, 2);
		Wait.waitUntilElementVisible(driver, we);
		action.moveToElement(we).click().perform();
		Wait.untilPageLoadComplete(driver, 10);
		System.out.println("Selected Country");
	}

	public void selectStore(String NameOfTheStore) throws InterruptedException {
		Wait.elementToBeClickable(driver, storeName, 2);
		System.out.println("Select store");
		storeName.click();
		System.out.println("Selected store");
		/*
		 * Wait.elementToBeClickable(driver, cancelIcon, 2); cancelIcon.click();
		 */
		System.out.println("clicked on cancle icon");
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(
				By.xpath("//*[@class='itemTemplateLabel_dqr75c' and contains(text(),'" + NameOfTheStore + "')]"));
		Wait.elementToBeClickable(driver, we, 2);
		Wait.waitUntilElementVisible(driver, we);
		Thread.sleep(2000);
		action.moveToElement(we).click().perform();
		Thread.sleep(2000);
		Wait.untilPageLoadComplete(driver, 10);
		System.out.println("Selected store");

		// action.moveToElement(save).click().perform();
	}

	public void save() {
		Wait.elementToBeClickable(driver, save, 2);
		/*
		 * util.actionMethodClick(driver, save); Wait.untilPageLoadComplete(driver);
		 */

		List<WebElement> ele = driver
				.findElements(By.xpath("//div[text()='SAVE']/parent::div[@class='appmagic-button middle center']"));
		Boolean flag = false;
		while (!flag) {
			for (int i = 0; i < ele.size(); i++) {
				if (isClickable(ele.get(i))) {
					// ele.get(i).click();
					util.actionMethodClick(driver, ele.get(i));
					flag = true;
					i = ele.size();
				}
			}
		}

	}

	public void validateMsg() {

		System.out.println("clicked on windows");
		// List<WebElement> ele = driver.findElements(By.xpath("//*[text()='User saved
		// successfully']"));
		util.validatesuccessmsg(driver, usersavedmsg, toasteContainer);

		System.out.println("popup validation");

	}

	public void signOut() {
		// Wait.untilPageLoadComplete(driver, 2);
		// Wait.waitUntilElementVisible(driver, PAicon);
		// Wait.elementToBeClickable(driver, PAicon, 25);
		driver.switchTo().defaultContent();
		// Sicon.click();
		util.jsclick(driver, Sicon);
		// util.actionMethodClick(driver, Sicon);
		util.jsclick(driver, signoutBtn);
		// signoutBtn.click();
		// driver.quit();
	}

	public boolean isClickable(WebElement ele) {
		boolean flag = true;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Element is clickable");
		} catch (Exception e) {
			System.out.println("Element isn't clickable");
			flag = false;
		}
		return flag;
	}

	public void selectedStore(String brand, String country, String store) throws InterruptedException {
		Wait.untilPageLoadComplete(driver, 20);
		List<WebElement> penIcon = driver.findElements(By.xpath(
				"//div[@data-container-name='contStore-container']//div[@data-control-name='icnEditStoreSelection']//div[@class='powerapps-icon no-focus-outline']"));
		Boolean flag1 = false;
		while (!flag1) {
			for (int i = 0; i < penIcon.size(); i++) {
				if (isClickable(penIcon.get(i))) {
					Wait.elementToBeClickable(driver, penIcon.get(i), 10);
					new WebDriverWait(driver, 6).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(penIcon.get(i)));
					//util.actionMethodClick(driver, penIcon.get(i));
					System.out.println("pencil icon is about to click");
					penIcon.get(i).click();
					System.out.println("clicked on pencil icon");
					flag1 = true;
					i = penIcon.size();
				}
			}
		}
		Wait.elementToBeClickable(driver, brandList, 2);
		brandList.click();
		WebElement brandSelection = driver.findElement(By.xpath("//div[contains(@id,'appmagic-dropdownFlyoutdropdown_siena_') and text()='" + brand + "']"));
		brandSelection.click();
		Wait.elementToBeClickable(driver, countryList, 2);
		countryList.click();
		WebElement countrySelection = driver.findElement(By.xpath("//div[contains(@id,'appmagic-dropdownFlyoutdropdown_siena_') and text()='" + country + "']"));
		Wait.waitForPresenceOfElementLocated(driver, countrySelection, 4);
		countrySelection.click();
		Wait.elementToBeClickable(driver, storeList, 5);
		storeList.click();
		WebElement storeSelection = driver.findElement(By.xpath("//div[contains(@id,'appmagic-dropdownFlyoutdropdown_siena_') and contains(text(),'" + store + "')]"));
		String storeSelectionvalue = storeSelection.getText();
		Wait.waitForInvisibilityOfElement(driver, storeSelection, 2);
		Wait.waitForInvisibilityOfElementLocated(driver, storeSelection, 5);
		Wait.elementToBeClickable(driver, storeSelection, 4);
		List<WebElement> ele = driver.findElements(By.xpath("//div[contains(text(),'" + store + "') and contains(@class,'appmagic-dropdownListItem')]"));
		Boolean flag = false;
		while (!flag) {
			for (int i = 0; i < ele.size(); i++) {
				if (isClickable(ele.get(i))) {
					// ele.get(i).click();
					util.actionMethodClick(driver, ele.get(i));
					flag = true;
					i = ele.size();
				}
			}
			Wait.elementToBeClickable(driver, okBtn, 2);
			util.actionMethodClick(driver, okBtn);
			WebElement viewselectedStore = driver
					.findElement(By.xpath("//div[@class='appmagic-label-text' and contains(text(),'" + store + "')]"));
			String viewselectedStoreValue = viewselectedStore.getText();
			if (storeSelectionvalue.equals(viewselectedStoreValue)) {
				System.out.println("Displayed store is matching with the selected store from the dropdown");
			} else {
				System.out.println("Displayed store is not matching with the selected store from the dropdown");
			}

		}
	
	}
	public void updateBrandSettings(String settings) {
		WebElement brandsettingsleftpanel = driver.findElement(By.xpath("//div[text()='" + settings + "']"));
		brandsettingsleftpanel.click();
	}

	public void selectingToggle() {
		List<WebElement> toggleBtn = driver.findElements(By.xpath("//div[@class='appmagic-toggleSwitch-off']"));
		Boolean flag = false;
		while (!flag) {
			for (int i = 0; i < toggleBtn.size(); i++) {
				if (isClickable(toggleBtn.get(i))) {
					util.actionMethodClick(driver, toggleBtn.get(i));
					flag = true;
					i = toggleBtn.size();
				}
			}
		}
	}

	public void updateDetails(String email) {
		storeCntctEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		storeCntctEmail.sendKeys(email);
	}

	public void saveSettings() {

		saveSettings.click();
		okBtn.click();
		util.validatesuccessmsg(driver, Successmessage, toasteContainer);
	}

	public void roleAccess(String userSelection) {
		// *[text()='aida.babaca@storelens.com']/ancestor::div[@data-control-name='lblGalleryUserNameMUS']/following-sibling::div[@data-control-name='icnMoreOptionsMUS']
		WebElement dotsSelection = driver.findElement(By.xpath("//div[text()='" + userSelection
				+ "']/ancestor::div[@data-control-name='lblGalleryUserNameMUS']/following-sibling::div[@data-control-name='icnMoreOptionsMUS']//div[@class='powerapps-icon no-focus-outline']"));
		Wait.elementToBeClickable(driver, dotsSelection, 5);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", dotsSelection);
		// util.actionMethodClick(driver, dotsSelection);
		util.jsclick(driver, dotsSelection);
		// dotsSelection.click();
		util.actionMethodClick(driver, editUser);
		util.actionMethodClick(driver, roleList);
		List<WebElement> listOfRoles = driver.findElements(By.xpath("//div[contains(@class,'itemTemplateContainer')]"));
		Boolean isAdminFound = false;
		while (!isAdminFound) {
			for (int i = 0; i < listOfRoles.size(); i++) {
				if (listOfRoles.get(i).getText().equals("Admin")) {
					System.out.println("entered into loop");
					System.out.println(listOfRoles.get(i).getText());
					isAdminFound = true;
					System.out.println("Admin option is there for:  " + userSelection);
					break;
				}
			}
			isAdminFound = true;
			System.out.println("Admin option is not available for:  " + userSelection);

		}

	}

	public void switchWindow() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		String MainWindow1 = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow1 = i1.next();

			if (!MainWindow1.equalsIgnoreCase(ChildWindow1)) {
				System.out.println("Window handler Id of Parent window= " + MainWindow1);
				System.out.println("Window handler Id of Child window= " + ChildWindow1);

				driver.switchTo().window(ChildWindow1);

			}
		}

	}

	public void switchToOriginalWindow() {
		Set<String> s1 = driver.getWindowHandles();
		driver.switchTo().window(null);

		driver.switchTo().frame("fullscreen-app-host");

	}

	public void newAccount() {
		useOtherAcc.click();
	}

}
