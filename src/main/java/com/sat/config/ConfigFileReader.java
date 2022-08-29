package com.sat.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.sat.testbase.TestBase;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir")
			+ "/src/main/java/com/sat/config/config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public void refresh() {
		TestBase.getDriver().navigate().refresh();
	}

	public String fileUpload(String fileName) {
		String file_Name = properties.getProperty(fileName);
		if (file_Name != null)
			return file_Name;
		else
			throw new RuntimeException("File path not Specified in the configuration path");
	}

	public String getResalePortalUrl1(String url1) {
		String url = properties.getProperty(url1);
		System.out.println(url1);
		System.out.println(url);
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getResalePortaluserId(String user1) {
		String UserID = properties.getProperty(user1);
		System.out.println(user1);
		System.out.println(UserID);
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("UserID not specified in the Configuration.properties file");
	}

	public String getResalePortalpassword(String password) {
		String Password = properties.getProperty(password);
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	public String getResalePortalUrl2() {
		String url = properties.getProperty("resale_portal_url2");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getResalePortaluserId2() {
		String UserID = properties.getProperty("resale_portal_userid2");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("UserID not specified in the Configuration.properties file");
	}

	public String getResalePortalpassword2() {
		String Password = properties.getProperty("resale_portal_password2");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	public String getResaleAppUrl() {
		String url = properties.getProperty("resale_app_url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("resale App url not specified in the Configuration.properties file.");
	}

	public String resaleAppUserId() {
		String UserID = properties.getProperty("resale_app_userid");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("Resale app UserID not specified in the Configuration.properties file");
	}

	public String resaleAppPassword() {
		String Password = properties.getProperty("resale_app_password");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("resale App Password not specified in the Configuration.properties file");
	}

	public String resaleAdminAppUserId() {
		String UserID = properties.getProperty("resale_admin_app_userid");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("Resale app UserID not specified in the Configuration.properties file");
	}

	public String resaleAdminAppPassword() {
		String Password = properties.getProperty("resale_admin_app_password");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("resale App Password not specified in the Configuration.properties file");
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("BookingAppUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Booking App url not specified in the Configuration.properties file.");
	}
	public String getPowerAppAdminCloudFlow() {
		String url = properties.getProperty("PowerAppsCloudFlow_AdminTool");
		if(url != null) return url;
		else throw new RuntimeException("powerApp cloud flow url not specified in the Configuration.properties file.");
	}
	public String AdminUserName(){
		String UserID =properties.getProperty("BookingAppAdminUserName");
		if(UserID!= null) return UserID;
		else throw new RuntimeException("Admin UserID not specified in the Configuration.properties file");
	}
	public String AdminUserPassword(){
		String Password =properties.getProperty("BookingAppAdminPassword");
		if(Password != null) return Password;
		else throw new RuntimeException("Admin Password not specified in the Configuration.properties file");
	}
	public String TestUserName(){
		String UserID =properties.getProperty("BookingAppTestUserName");
		if(UserID!= null) return UserID;
		else throw new RuntimeException("Test UserID not specified in the Configuration.properties file");
	}
	public String TestUserPassword(){
		String Password =properties.getProperty("BookingAppTestPassword");
		if(Password != null) return Password;
		else throw new RuntimeException("Test Password not specified in the Configuration.properties file");
	}
	public String getEmailUrl() {
		String url = properties.getProperty("email_url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getEmailUserid() {
		String UserID = properties.getProperty("email_username");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("UserID not specified in the Configuration.properties file");
	}

	public String getEmailPassword() {
		String Password = properties.getProperty("email_password");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	public String getIban(String iban) {
		String Password = properties.getProperty(iban);
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("IBANnumber not specified in the Configuration.properties file");
	}

	public String getTemporaryPassword() {
		String Password = properties.getProperty("temporaryPassword");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	public String getPowerAppCloudFlow() {
		String url = properties.getProperty("PowerAppsCloudFlow");
		if (url != null)
			return url;
		else
			throw new RuntimeException("powerApp cloud flow url not specified in the Configuration.properties file.");
	}
	public String bookingportalUrlForAutomationServiceTest() {
		String gmailuderPassword =properties.getProperty("BookingPortalUrl_AutomationServiceTest");
		if(gmailuderPassword != null) return gmailuderPassword;
		else throw new RuntimeException("AutomationServiceTest url not specified in the Configuration.properties file");
	}
	public String bookingportalUrlForResell() {
		String gmailuderPassword =properties.getProperty("BookingPortalUrl_Resell");
		if(gmailuderPassword != null) return gmailuderPassword;
		else throw new RuntimeException("Resell service url not specified in the Configuration.properties file");
	}

}
