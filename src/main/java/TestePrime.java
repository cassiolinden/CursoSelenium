import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class TestePrime {
	private WebDriver driver;
	private DSL dsl;
		
		@Before
		public void inicializa() {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\cassio\\Documents\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
			dsl = new DSL(driver);
		}
		
		@After
		public void finaliza() {
//			driver.quit();
		}
	
	@Test
	public void deveInteragirComRadioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt701:console:0']/../..//span")); //id dinâmico
		Assert.assertTrue(dsl.isRadioMarcado("j_idt701:console:0"));
		
		dsl.clicarRadio(By.xpath("//label[contains(text(),'PS4')]/..//span")); //pelo label
		Assert.assertTrue(dsl.isRadioMarcado("j_idt701:console:1"));
	}
	
	@Test
	public void deveInteragirComComboPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt701:console", "Xbox One");
//		dsl.clicarBotao(By.xpath("//*[@id='j_idt701:console_2']")); //id do elemento
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt701:console_label"));
		

	}
}
