package com.sat.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Log;

import com.sat.testUtil.Testutil;

import com.sat.testUtil.Wait;

public class GmailLoginPage {

	private WebDriver driver;
	Wait waits = new Wait();

	@FindBy(how = How.XPATH, xpath = "//input[@id='identifierId']")
	WebElement emailField;

	@FindBy(how = How.XPATH, xpath = "//*[@id='password']/div[1]/div/div[1]/input")
	WebElement passwordField;

	@FindBy(how = How.XPATH, xpath = "//*[@class='xY a4W']")
	List<WebElement> emailThreads;

	@FindBy(how = How.XPATH, xpath = "//img[@class='gb_Aa gbii']")
	WebElement profileLogo;

	@FindBy(how = How.XPATH, xpath = "(//*[@aria-label='Not starred'])[last()]/parent::div/span[@title]")
	WebElement recentMailTime;

	@FindBy(how = How.XPATH, xpath = "//*[@role='navigation']/following-sibling::div//div[@aria-label='Back to Inbox']")
	WebElement back;

	@FindBy(how = How.XPATH, xpath = "//*[@role='navigation']//div[@data-tooltip='Inbox']//div[@class='bsU']")
	WebElement noOfMails;

	@FindBy(how = How.XPATH, xpath = "//*[@role='navigation']//div[@data-tooltip='Inbox']")
	WebElement inbox;

	@FindBy(how = How.XPATH, xpath = "//div[@gh='mtb']//div[@aria-label='Select' or @title='Select']//span")
	WebElement selectAllMailCheckBox;

	@FindBy(how = How.XPATH, xpath = "//div[@aria-label='Mark as read' or @title='Mark as read']")
	WebElement markAsRead;

	@FindBy(how = How.XPATH, xpath = "//img[@class='gb_Aa gbii']")
	WebElement ticon;

	@FindBy(how = How.XPATH, xpath = "//div[text()='Sign out']/parent::a")
	WebElement signoutBtn;

	@FindBy(how = How.XPATH, xpath = "//*[@class='aKz' and text()='Primary']")
	WebElement primaryTab;


	Testutil testutil = new Testutil();

	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String emailID) {
		waitForVisible(driver, emailField);
		Actions actions = new Actions(driver);
		actions.moveToElement(emailField);
		actions.click();
		Log.info("entered email Id");
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
		System.out.println("Email entered");
	}

	public void enterPassword(String password) {
		waitForVisible(driver, passwordField);
		Actions actions = new Actions(driver);
		actions.moveToElement(passwordField);
		actions.click();
		Wait.textToBePresent(driver, passwordField, password, 3);
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
		Log.info("entered password");
		System.out.println("Password entered");
	}

/*	public void Validation(String emailSubject) {
		System.out.println("varification started");
		long startTime = System.currentTimeMillis();
		boolean checkmail = true;
		while (checkmail && (System.currentTimeMillis() - startTime) < 600000) {
			System.out.println("will execute click email method");
			List<WebElement> unreadmsg1 = driver
					.findElements(By.xpath("(//*[@class='bqe' and contains(text(),'" + emailSubject + "')])[last()]"));
			if (!unreadmsg1.isEmpty()) {
				for (int i = 0; i < unreadmsg1.size(); i++) {
					WebElement ele = unreadmsg1.get(i);
					Wait.elementToBeClickable(driver, ele, 5);
					Wait.waitUntilElementVisible(driver, ele);
					testutil.actionMethodClick(driver, ele);
					unreadmsg1.remove(i);
					System.out.println("executed click email method");
					String gmailTime = recentMailTime.getText();
					System.out.println(gmailTime);
					String min = gmailTime.substring(7, 8);
					String minInWords = gmailTime.substring(9, 15);
					System.out.println(minInWords);
					System.out.println(min);
					if (minInWords.equals("minute")) {
						System.out.println("executing if");
						Integer s2 = Integer.parseInt(min);
						System.out.println(s2);
						Assert.assertTrue(s2 <= 10, "Email is not received within 10min");
						checkmail = false;
					} else {
						System.out.println("clicking on back");
						WebElement ss2 = driver
								.findElement(By.xpath("//div[@aria-label='Back to Inbox' or @title='Back to Inbox']"));
						testutil.actionMethodClick(driver, ss2);
						unreadmsg1.clear();
						System.out.println("clicked on back");
					}
				}
			} else {
				System.out.println("clicking on refresh");

				WebElement ss = driver.findElement(By.xpath("//div[@title='Refresh' or @aria-label='Refresh']"));
				testutil.actionMethodClick(driver, ss);
				unreadmsg1.removeAll(unreadmsg1);
				System.out.println("clicked on refresh");

				//checkInPromotions(emailSubject);

				List<WebElement> newMailInPromotion = driver
						.findElements(By.xpath("//div[contains(text(),'new') and @class='aDG']"));
				if (!newMailInPromotion.isEmpty()) {
					WebElement promotionTab = driver.findElement(By.xpath("//*[text()='Promotions' and @class='aKz']"));
					promotionTab.click();
					WebDriverWait wait = new WebDriverWait(driver, 100);
					wait.until(ExpectedConditions
							.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//span[@class='bqe']")))));
					Wait.elementToBeClickable(driver,driver.findElement(By.xpath("(//*[@class='bqe' and contains(text(),'')])[last()]")) , 4);
					List<WebElement> unreadmsg2 = driver
							.findElements(By.xpath("(//*[@class='bqe' and contains(text(),'" + emailSubject + "')])[last()]"));
					System.out.println(unreadmsg2.size());
					if (!unreadmsg2.isEmpty()) {
						for (int i = 0; i < unreadmsg2.size(); i++) {
							WebElement ele = unreadmsg2.get(i);
							Wait.elementToBeClickable(driver, ele, 5);
							Wait.waitUntilElementVisible(driver, ele);
							System.out.println("mail need to be click");
							testutil.actionMethodClick(driver, ele);
							System.out.println("mail got clicked in Promotions tab");
							unreadmsg2.remove(i);
							System.out.println("executed click email method");
							String gmailTime = recentMailTime.getText();
							System.out.println(gmailTime);
							String min = gmailTime.substring(7, 8);
							String minInWords = gmailTime.substring(9, 15);
							System.out.println(minInWords);
							System.out.println(min);
							if (minInWords.equals("minute")) {
								System.out.println("executing if");
								Integer s2 = Integer.parseInt(min);
								System.out.println(s2);
								Assert.assertTrue(s2 <= 10, "Email is not received within 10min");
								checkmail = false;
							} else {
								System.out.println("clicking on back");
								WebElement ss2 = driver
										.findElement(By.xpath("//div[@aria-label='Back to Inbox' or @title='Back to Inbox']"));
								testutil.actionMethodClick(driver, ss2);
								System.out.println("clicked on back");
							}
						}
						unreadmsg2.clear();
					} else {
						System.out.println("no mails are in promotions so navigate back to inbox ");
						WebElement inboxTab = driver.findElement(By.xpath("//*[text()='Primary' and @class='aKz']"));
						inboxTab.click();
					}
				} else {
					System.out.println("No new tag on promotion Tab");
				}
			}
		}
	}*/
	public void Validation(String emailSubject) {
		System.out.println("New method validation started ");
		long startTime = System.currentTimeMillis();
		boolean checkmail = true;
		while (checkmail && (System.currentTimeMillis() - startTime) < 600000) {
				primaryTab.click();
				System.out.println("clicked on primarytab");
				List<WebElement> unreadmsg1 = driver.findElements(By.xpath("(//*[@class='bqe' and contains(text(),'" + emailSubject + "')])[last()]"));
				System.out.println(unreadmsg1.size());
				if (!unreadmsg1.isEmpty()) {
					System.out.println("executing if");
					for (int i = 0; i < unreadmsg1.size(); i++) {
						WebElement ele = unreadmsg1.get(i);
						Wait.elementToBeClickable(driver, ele, 5);
						Wait.waitUntilElementVisible(driver, ele);
						testutil.actionMethodClick(driver, ele);
						unreadmsg1.remove(i);
						System.out.println("executed click email method");
						String gmailTime = recentMailTime.getText();
						System.out.println(gmailTime);
						String min = gmailTime.substring(7, 8);
						String minInWords = gmailTime.substring(9, 15);
						System.out.println(minInWords);
						System.out.println(min);
						if (minInWords.equals("minute")) {
							System.out.println("executing if");
							Integer s2 = Integer.parseInt(min);
							System.out.println(s2);
							Assert.assertTrue(s2 <= 10, "Email is not received within 10min");
							checkmail = false;
						} else {
							System.out.println("clicking on back");
							WebElement backBtn = driver.findElement(By.xpath("//div[@aria-label='Back to Inbox' or @title='Back to Inbox']"));
							testutil.actionMethodClick(driver, backBtn);
							unreadmsg1.clear();
							System.out.println("clicked on back");
						}
					}
					System.out.println("completed if");

				}
				else {
					System.out.println("executing else block");
					WebElement promotionTab = driver.findElement(By.xpath("//*[text()='Promotions' and @class='aKz']"));
					promotionTab.click();
					System.out.println("clicked on promo tab");
					Wait.elementToBeClickable(driver,driver.findElement(By.xpath("(//*[@class='bqe' and contains(text(),'')])[last()]")) , 4);
					List<WebElement> unreadmsg2 = driver.findElements(By.xpath("(//*[@class='bqe' and contains(text(),'" + emailSubject + "')])[last()]"));
					System.out.println(unreadmsg2.size());
					if (!unreadmsg2.isEmpty()) {
						for (int i = 0; i < unreadmsg2.size(); i++) {
							WebElement ele = unreadmsg2.get(i);
							Wait.elementToBeClickable(driver, ele, 5);
							Wait.waitUntilElementVisible(driver, ele);
							testutil.actionMethodClick(driver, ele);
							unreadmsg2.remove(i);
							System.out.println("executed click email method");
							String gmailTime = recentMailTime.getText();
							System.out.println(gmailTime);
							String min = gmailTime.substring(7, 8);
							String minInWords = gmailTime.substring(9, 15);
							System.out.println(minInWords);
							System.out.println(min);
							if (minInWords.equals("minute")) {
								System.out.println("executing if");
								Integer s2 = Integer.parseInt(min);
								System.out.println(s2);
								Assert.assertTrue(s2 <= 10, "Email is not received within 10min");
								checkmail = false;
							} else {
								System.out.println("clicking on back");
								WebElement backBtn = driver.findElement(By.xpath("//div[@aria-label='Back to Inbox' or @title='Back to Inbox']"));
								testutil.actionMethodClick(driver, backBtn);
								unreadmsg2.clear();
								System.out.println("clicked on back");
							}
						}

					}else {
					System.out.println("clicking on refresh");
					WebElement ss = driver.findElement(By.xpath("//div[@title='Refresh' or @aria-label='Refresh']"));
					testutil.actionMethodClick(driver, ss);
					System.out.println("clicked on refresh");
					System.out.println("completed else");
					}
			} 	
		}
	}




	public void ValidationWithoutPromotionTab(String emailSubject) {
		System.out.println("varification started");
		long startTime = System.currentTimeMillis();
		boolean checkmail = true;
		while (checkmail && (System.currentTimeMillis() - startTime) < 600000) {
			System.out.println("will execute click email method");
			List<WebElement> unreadmsg1 = driver
					.findElements(By.xpath("(//*[@class='bqe' and contains(text(),'" + emailSubject + "')])[last()]"));
			if (!unreadmsg1.isEmpty()) {
				for (int i = 0; i < unreadmsg1.size(); i++) {
					WebElement ele = unreadmsg1.get(i);
					Wait.elementToBeClickable(driver, ele, 5);
					Wait.waitUntilElementVisible(driver, ele);
					testutil.actionMethodClick(driver, ele);
					unreadmsg1.remove(i);
					System.out.println("executed click email method");
					String gmailTime = recentMailTime.getText();
					System.out.println(gmailTime);
					String min = gmailTime.substring(7, 8);
					String minInWords = gmailTime.substring(9, 15);
					System.out.println(minInWords);
					System.out.println(min);
					if (minInWords.equals("minute")) {
						System.out.println("executing if");
						Integer s2 = Integer.parseInt(min);
						System.out.println(s2);
						Assert.assertTrue(s2 <= 10, "Email is not received within 10min");
						checkmail = false;
					} else {
						System.out.println("clicking on back");
						WebElement ss2 = driver
								.findElement(By.xpath("//div[@aria-label='Back to Inbox' or @title='Back to Inbox']"));
						testutil.actionMethodClick(driver, ss2);
						unreadmsg1.clear();
						System.out.println("clicked on back");
					}
				}
			} else {
				System.out.println("clicking on refresh");

				WebElement ss = driver.findElement(By.xpath("//div[@title='Refresh' or @aria-label='Refresh']"));
				testutil.actionMethodClick(driver, ss);
				unreadmsg1.removeAll(unreadmsg1);
				System.out.println("clicked on refresh");
			}
		}
	}

	/*public void unReadAllMails() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, 100);
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(inbox)));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inbox")));
		List<WebElement> nn = driver
				.findElements(By.xpath("//*[@role='navigation']//div[@data-tooltip='Inbox']//div[@class='bsU']"));
		System.out.println(nn);
		if (!nn.isEmpty()) {
			System.out.println(noOfMails.isDisplayed());
			String getNoOfMails = noOfMails.getText();
			System.out.println(getNoOfMails);
			Integer no_inmail = Integer.parseInt(getNoOfMails);
			System.out.println(noOfMails.isDisplayed());
			if (no_inmail != 0) {
				selectAllMailCheckBox.click();
				markAsRead.click();
				Thread.sleep(5000);
			} else {
				System.out.println("All are read mails");
			}
		} else {
			System.out.println("element not found");
		}
	}*/

	public void unReadAllMails() throws InterruptedException {
		selectAllMailCheckBox.click();
		System.out.println("clicked on select all mail");
		try {
			markAsRead.click();
			System.out.println("clicked on mark read");
			Thread.sleep(5000);
		}catch(Exception e ) {
			System.out.println("clicked on select all mail in catch block");
			selectAllMailCheckBox.click();
		}
		WebElement promotionTab = driver.findElement(By.xpath("//*[text()='Promotions' and @class='aKz']"));
		promotionTab.click();
		System.out.println("clicked on promotion");
		Wait.elementToBeClickable(driver, selectAllMailCheckBox, 5);
		selectAllMailCheckBox.click();
		System.out.println("clicked on select all mail in promotion");
		try {
			markAsRead.click();
			System.out.println("clicked on mark read in promotion");
			Thread.sleep(5000);
		}catch(Exception e ) {
			System.out.println("clicked on select all mail in promotion catch");
			selectAllMailCheckBox.click();
		}
		//Thread.sleep(5000);

	}

	public void clickEmail(String emailSubject) {
		waitForVisible(driver, profileLogo);
		for (int i = 0; i < emailThreads.size(); i++) {
			if (emailThreads.get(i).getText().contains(emailSubject)) {
				System.out.println("click on email");
				emailThreads.get(i).click();
				System.out.println("email clicked");
				break;
			}
		}
	}

	public void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			System.out.println("Waiting for element visibility - wait for visible");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String instanttime() {
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String currenttime = sd.format(date);
		System.out.println(currenttime);
		return currenttime;
	}

	public void signout() {
		ticon.click();
		Wait.elementToBeClickable(driver, signoutBtn, 2);
		signoutBtn.click();
	}

	public void backBtn() {
		WebElement back = driver.findElement(By.xpath("//div[@aria-label='Back to Inbox' or @title='Back to Inbox']"));
		back.click();
	}

	public void frames() {
		List<WebElement> ele = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in a page :" + ele.size());
		for (WebElement el : ele) {
			// Returns the Id of a frame. 
			System.out.println("Frame Id :" + el.getAttribute("id"));
			// Returns the Name of a frame. 
			System.out.println("Frame name :" + el.getAttribute("name"));
		}
	}

}