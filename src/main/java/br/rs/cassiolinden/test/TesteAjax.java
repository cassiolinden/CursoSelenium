package br.rs.cassiolinden.test;
import static br.rs.cassiolinden.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.rs.cassiolinden.core.DSL;
import br.rs.cassiolinden.core.DriverFactory;


public class TesteAjax {
	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
	}
		
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
		
	@Test
	public void testAjax() {
		dsl.escrever("j_idt700:name", "Teste");
		dsl.clicarBotao("j_idt700:j_idt703");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//		wait.until(ExpectedConditions.textToBe(By.id("j_idt700:display"), "Teste"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt715_start")));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt700:display"));
		

	}
}
