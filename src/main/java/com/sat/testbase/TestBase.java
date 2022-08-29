package com.sat.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sat.testUtil.Testutil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
		
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<>();
	public static Properties prop;
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/sat/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initialization() {
		String browserName = prop.getProperty("browser");
		
	if(browserName.equals("chrome")){
		
		WebDriverManager.chromedriver().setup();
		tldriver.set(new ChromeDriver());
		
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/com.sat.Drivers/chromedriver.exe");
	}
	
	getDriver().manage().window().maximize();
	getDriver().manage().deleteAllCookies();
	getDriver().manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	getDriver().manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	return getDriver();
}


private void elseif() {
	System.out.println("inside elseif ");		
	}


public static synchronized WebDriver getDriver()
{
	
  return tldriver.get();
}


	

}
