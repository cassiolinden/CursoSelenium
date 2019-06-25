package br.rs.cassiolinden.test;
import org.junit.Assert;
import org.junit.Test;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		/* Firefox */
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\cassio\\Documents\\webdrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		/* Chrome 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\cassio\\Documents\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		*/
		
//		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		driver.get("http://google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
