package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.UtilTest;
import com.crm.qa.util.WebEventListener;

public class BaseTest
{
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	
	
	public BaseTest()
	{
		prop = new Properties();
		
		try
		{
			FileInputStream fis = new FileInputStream("E:\\New Java_Workspace\\FreeCRMAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void initialization()
	{
		if(prop.getProperty("browser").contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SeleniumJavaSql_Files\\Selenium_Naveen\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		eventDriver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver = eventDriver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(UtilTest.Implicite_Time_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(UtilTest.Page_Load_TimeOut, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
