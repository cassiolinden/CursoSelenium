import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSincronismo {
	private WebDriver driver;
	private DSL dsl;
		
		@Before
		public void inicializa() {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\cassio\\Documents\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			dsl = new DSL(driver);
		}
		
		@After
		public void finaliza() {
//			driver.quit();
		}
		
		@Test
		public void deveUtilizarEsperaFixa() throws InterruptedException {
			dsl.clicarBotao("buttonDelay");
			Thread.sleep(5000);
			dsl.escrever("novoCampo", "Deu certo?");
		}
		@Test
		public void deveUtilizarEsperaImplicita() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			dsl.clicarBotao("buttonDelay");
			dsl.escrever("novoCampo", "Deu certo?");
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
}
