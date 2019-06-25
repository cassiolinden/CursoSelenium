import static br.rs.cassiolinden.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.rs.cassiolinden.core.DriverFactory;


public class TestePrime {
	private DSL dsl;
		
		@Before
		public void inicializa() {
			getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
			dsl = new DSL();
		}
		
		@After
		public void finaliza() {
			DriverFactory.killDriver();
		}
	
	@Test
	public void deveInteragirComRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt701:console:0']/../..//span")); //id dinâmico
		Assert.assertTrue(dsl.isRadioMarcado("j_idt701:console:0"));
		
		dsl.clicarRadio(By.xpath("//label[contains(text(),'PS4')]/..//span")); //pelo label
		Assert.assertTrue(dsl.isRadioMarcado("j_idt701:console:1"));
	}
	
	@Test
	public void deveInteragirComComboPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt701:console", "Xbox One");
//		dsl.clicarBotao(By.xpath("//*[@id='j_idt701:console_2']")); //id do elemento
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt701:console_label"));
		

	}
}
