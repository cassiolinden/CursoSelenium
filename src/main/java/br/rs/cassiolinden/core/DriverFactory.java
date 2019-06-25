package br.rs.cassiolinden.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver==null) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\cassio\\Documents\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver!=null) {
			driver.quit();
			driver = null;
		}
	}
}
