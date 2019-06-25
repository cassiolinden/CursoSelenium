package br.rs.cassiolinden.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.rs.cassiolinden.core.DSL;
import br.rs.cassiolinden.core.DriverFactory;

import static br.rs.cassiolinden.core.DriverFactory.getDriver;


public class TesteAlert {
	
private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}

	@Test
	public void deveInteragirComAlertSimples() {
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Negado", dsl.alertaObterTextoEAceita());

		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	}
	
}
