package com.sat.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sat.config.ConfigFileReader;

public class ItemsPage {
	private WebDriver driver;
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();

	@FindBy(xpath = "//*[text()='Pre registered']")
	private WebElement status;
	@FindBy(xpath = "//div[@aria-label='Gender. ']]")
	private WebElement genderList;
	@FindBy(xpath = "//span[text()='Select size ']")
	private WebElement sizelist;
	@FindBy(xpath = "//div[@aria-label='Price. ']")
	private WebElement pricelist;
	@FindBy(xpath = "//div[text()='SAVE']")
	private WebElement saveBtn;

	public ItemsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void preregisterToInstore(String gender, String size) {
		status.click();
		genderList.click();
		WebElement genderSelection = driver.findElement(By.xpath("//div[text()='" + gender + "']"));
		genderSelection.click();
		sizelist.click();
		WebElement sizeSelection = driver.findElement(By.xpath("//div[text()='" + size + "']"));
		sizeSelection.click();
		pricelist.click();
		WebElement priceSelection = driver.findElement(By.xpath("//div[text()='" + size + "']"));
		priceSelection.click();
		saveBtn.click();
	}

}
