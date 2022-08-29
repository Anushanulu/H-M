package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import net.bytebuddy.asm.Advice.This;

public class Hmresaleapppage {
	private WebDriver driver;
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	private By emailID1 = By.name("loginfmt");
	private By Nextbtn = By.xpath("//input[@type='submit']");
	private By password1 = By.name("passwd");
	private By Submit = By.id("idSIButton9");
	private By DontShowcheckbox = By.name("DontShowAgain");
	private By yesbtn = By.xpath("//*[@type='submit']");
	private By addBtn = By.xpath("//*[@data-container-name='contButtonsMIS-container']/div/div/div");
	private By editBtn = By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div"); //("//*[@data-container-name='contStore-container']/div/div[2]/div/div/div/div/div");
	private By brand = By.xpath("//div[@data-control-name='ddBrand']/div/div/div/div/div/div/div[1]");
	private By HandM = By.xpath("//*[@data-shortcut-id='397']");
	private By country = By.xpath("//*[@tabindex='714']"); //("//div[@data-control-name='ddCountry']/div/div/div/div/div/div/div[1]");
	private By Sweden = By.xpath("//*[@data-drop-id='3']/div/div/div[9]");
	private By store = By.xpath("//*[@data-control-name='ddStore']/div/div/div/div/div/div/div[1]");
	private By store_1 = By.xpath("//*[text()='Drottninggatan 56']");
	private By okbtn = By.xpath("//*[@data-control-name='btnOKStores']/div/div/div/div/div");
	private By addbtn = By.xpath("//*[@data-control-name='btnAddItemFromCustomerMIS']/div/div/div/div/div");
	private By existingUser = By.xpath("//*[@appmagic-control='txtSearchSellerMIStextbox']");
	private By selectExistingUser = By.xpath("//*[@data-control-id=\"464\"]");
	private By items = By.xpath("//*[@aria-labelledby='pa-gallery-label-2']");
	private By addItems = By.xpath("//*[@data-pa-item-id='735']");
	private By addItemIdManually = By.xpath("//*[@data-control-id=\"520\"]");
	private By itemNumber = By.xpath("//*[@appmagic-control='txtAddItemIdMIStextbox']");
	private By itemIdOk = By.xpath("//*[@data-control-name=\"btnOkItemIdPopUpMIS\"]");
	
	
	private By brandList = By.xpath("//*[@aria-label='TopBrand']/div[1]");
	private By listOfBrands = By.xpath("//*[@class='appmagic-combobox-itemlist itemsContainer_14xc3ab']//li");
	private By gender = By.xpath("//*[@data-shortcut-id='288']");
	private By women = By.xpath("//*[@aria-label='Gender items']/div[2]");
	private By addPhoto = By.xpath("//*[@aria-label='Add Photo']");
	private By itemcategory = By.xpath("//*[@aria-describedby='react-combobox-view-6-instructions']/div[1]");
	private By listOfCategory = By.xpath("//*[@aria-label='Size items']/li");
	private By condition = By.xpath("//*[@aria-label='Condition. Worn a few times']");
	private By wornfewtimes = By.xpath("//*[@aria-label='Condition items']/div[1]");
	private By size = By.xpath("//*[@id='react-combobox-view-7']/div[1]");
	private By listOfSize = By.xpath("//*[@class='ms-FocusZone css-125 container_19yuamu-o_O-focusZone_1c6hxqo']");
	private By itemprice = By.xpath("//*[@data-control-name='ddAddItemPriceMIS']/div/div/div/div/div/div/div[1]");
	private By rs150 = By.xpath("//div[text()='350']");
	private By pickupRadiobtn = By.xpath("//*[@data-pa-item-id='1537']/div/div/div/div/div[1]");
	private By listOfprices = By.xpath("//*[@aria-label='Price items']/div");
	private By addItemButton = By.xpath("//*[@data-control-name='btnSaveItemDetailsMIS']/div/div/div/div/div");
	private By itemID = By.xpath("//*[@data-control-name='lblItemIdAddedByCustomerMIS_1']");
	
	public Hmresaleapppage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void userid(String userid) {
		driver.findElement(emailID1).sendKeys(userid);
				
	}
	public void nextButton() throws InterruptedException {
		driver.findElement(Nextbtn).click();
		Thread.sleep(5000);
		
	}
	public void passWord(String password) {
		driver.findElement(password1).sendKeys(password);
		
	}
	
	public void submitbtn() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(Submit).click();
		
	}
	public void dontShowBtn() {
		driver.findElement(DontShowcheckbox).click();
		
	}
	public void yesBtn(){
		driver.findElement(yesbtn).click();
		Wait.untilPageLoadComplete(driver, 30);
	}
	
	
	public void AddBtn()  {
		driver.findElement(addBtn).click();
		
	}
	public void editBtn()   {
		TargetLocator currentFrame = driver.switchTo();
		currentFrame.frame("fullscreen-app-host");
		driver.findElement(editBtn).click();
	}
	public void brandName(String brandName)   {
		/*Select List_of_brand = new Select (driver.findElement(brand));
		List_of_brand.selectByVisibleText(brandName);*/
		/*List<WebElement> allOptions = driver.findElements(brand);
        System.out.println(allOptions.size());
        for(int i = 0; i<=allOptions.size()-1; i++) {
        	if(allOptions.get(i).getText().contains(brandName)) {
                allOptions.get(i).click();
                Thread.sleep(8000);
                break;
        	}
        }*/
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		driver.findElement(brand).click();
		WebElement categories = driver.findElement(HandM);
		Actions action = new Actions(driver);
		action.moveToElement(categories).click().perform();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
	}
	//*[@data-drop-id='3']//div[text()='Canada']
	public WebElement selectCountry(String countryName)
	{
	return driver.findElement(By.xpath("//*[@data-drop-id='3']//div[text()='"+countryName+"']"));
	}
	public void countryName(String countryName) throws InterruptedException   {
		
		driver.findElement(country).click();
		//WebElement categories = driver.findElement(Sweden);
		//Wait.elementToBeClickable(TestBase.getDriver(), selectCountry(countryName), 20);
		//Wait.waitUntilElementVisible(TestBase.getDriver(), selectCountry(countryName));
		Actions action = new Actions(driver);
		action.moveToElement(selectCountry(countryName)).click().perform();
		Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		//Thread.sleep(3000);
	}
	
	
	public WebElement selectStore(String store) {
		return driver.findElement(By.xpath("//*[text()='"+store+"']"));
	}
	public void storeName(String storeName) throws InterruptedException   {
		//Select List_of_country = new Select(driver.findElement(store));
		//List_of_country.selectByVisibleText(StoreName);
		Thread.sleep(5000);
		driver.findElement(store).click();
		//WebElement categories = driver.findElement(store_1);type name = new type();
		//Wait.untilPageLoadComplete(TestBase.getDriver(), 10);
		Thread.sleep(5000);
		Wait.waitUntilElementVisible(TestBase.getDriver(), selectStore(storeName));
		Actions action = new Actions(driver);
		action.moveToElement(selectStore(storeName)).click().perform();
		
		
	}
	public void okbBtn()   {
		driver.findElement(okbtn).click();
	}
	public void addButton()   {
		driver.findElement(addbtn).click();
	}
	public void enterExistingUser(String existingUserName)   {
		driver.findElement(existingUser).sendKeys(existingUserName);
		driver.findElement(existingUser).sendKeys(Keys.ENTER);
	}
	public void selectExistinguser()   {
		driver.findElement(selectExistingUser).click();
	}
	public void selectItems()   {
		driver.findElement(items).click();
	}
	public void addItems()   {
		driver.findElement(addItems).click();
	}
	public void addItemIdManually()   {
		driver.findElement(addItemIdManually).click();
	}
	public void itemNumber(String itemId)   {
		driver.findElement(itemNumber).clear();
		driver.findElement(itemNumber).sendKeys(itemId);
	}
	public void itemIdOk() throws InterruptedException   {
		driver.findElement(itemIdOk).click();
		WebElement Element = driver.findElement(By.xpath("//*[@data-shortcut-id='271']"));
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,-350)");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		//jse.executeScript("window.scrollTo(0, document.body.scrollHeight");
//		EventFiringWebDriver event = new EventFiringWebDriver(driver);
//		event.executeScript("document.querySelector(), null)
		Thread.sleep(10000);
		System.out.println("scroll is done");
	}
	
	public WebElement selectBrandName(String Brand) {
		return driver.findElement(By.xpath("//*[@aria-label='TopBrand items']//span[text()='"+Brand+"']"));
	}
	public void selectBrand(String topBrand)   {
		System.out.println("need to click brand");
		driver.findElement(brandList).click();
		Wait.waitUntilElementVisible(TestBase.getDriver(), selectBrandName(topBrand));
		Actions action = new Actions(driver);
		action.moveToElement(selectBrandName(topBrand)).click().perform();
		
		
//		driver.findElement(brandList).sendKeys(topBrand);
//		List<WebElement> elements = driver.findElements(listOfBrands);
//		for (WebElement element : elements) {
//            if (element.getText().equalsIgnoreCase(topBrand)) {
//                element.click();
//                break;
//            }
//        }
	}
	public WebElement Gender(String gender) {
		return driver.findElement(By.xpath("//*[@aria-label='Gender items']/div[text()='"+gender+"']"));
	}
	public void selectGender(String Gender)   {
		driver.findElement(gender).click();
		Wait.waitUntilElementVisible(TestBase.getDriver(), Gender(Gender));
		//WebElement gender = driver.findElement(women);
		Actions action = new Actions(driver);
		action.moveToElement(Gender(Gender)).click().perform();	
	}
	
	public WebElement category(String categoryName) {
		return driver.findElement(By.xpath("//*[@aria-label='Category items']//span[text()='"+categoryName+"']"));
	}
	public void selectcategory(String category)   {
		driver.findElement(itemcategory).click();
		Wait.waitUntilElementVisible(TestBase.getDriver(), category(category));
		//WebElement categories = driver.findElement(By.xpath("//*[@aria-label='Category items']/li[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(category(category)).click().perform();
//		List<WebElement> elements = driver.findElements(listOfCategory);
//		for (WebElement element : elements) {
//            if (element.getText().equalsIgnoreCase(category)) {
//                element.click();
//                break;
//            }
//        }
	}
	public WebElement conditionOfItem(String Itemscondition) {
		return driver.findElement(By.xpath("//*[@aria-label='Condition items']/div[text()='"+Itemscondition+"']"));
	}
	public void itemCondition(String itemconditions)   {
		driver.findElement(condition).click();
		//WebElement condition_of_item = driver.findElement(wornfewtimes);
		Wait.waitUntilElementVisible(TestBase.getDriver(), conditionOfItem(itemconditions));
		Actions action = new Actions(driver);
		action.moveToElement(conditionOfItem(itemconditions)).click().perform();
	}
	public WebElement sizeOfItem(String size) {
		return driver.findElement(By.xpath("//*[@aria-label='Size items']//span[text()='"+size+"']"));
	}
	public void itemSize(String itemSize)   {
		driver.findElement(size).click();
		Wait.waitUntilElementVisible(TestBase.getDriver(), sizeOfItem(itemSize));
		//WebElement sizeOfItems = driver.findElement(By.xpath("//*[@aria-label='Size items']/li[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(sizeOfItem(itemSize)).click().perform();
//		List<WebElement> elements = driver.findElements(listOfSize);
//		for (WebElement element : elements) {
//            if (element.getText().equalsIgnoreCase(itemsize)) {
//                element.click();
//                break;
//            }
//        }
	}
	public WebElement priceOfItem(String price) {
		return driver.findElement(By.xpath("//div[text()='"+price+"']"));
	}
	public void itemPrice(String priceOfItems)   {
		driver.findElement(itemprice).click();
		//WebElement rupees = driver.findElement(rs150);
		Wait.waitUntilElementVisible(TestBase.getDriver(), priceOfItem(priceOfItems));
		Actions action = new Actions(driver);
		action.moveToElement(priceOfItem(priceOfItems)).click().perform();
//		List<WebElement> elements = driver.findElements(listOfprices);
//		for (WebElement element : elements) {
//            if (element.getText().equalsIgnoreCase(listofprice)) {
//                element.click();
//                break;
//            }
//        }
	}
	public void pickUpRadioBtn()   {
		driver.findElement(pickupRadiobtn).click();
	}
	public void uploadfile(String NameOfFile) throws InterruptedException   {
		Thread.sleep(1000);
		driver.findElement(addPhoto).sendKeys(config.fileUpload(NameOfFile));
	}
	public void addItemButton() throws InterruptedException   {
		driver.findElement(addItemButton).click();
		boolean verifyTitle = driver.findElement(itemID).isDisplayed();
		assertTrue(verifyTitle);
		Thread.sleep(10000);
		//driver.switchTo().defaultContent();
	}
}
