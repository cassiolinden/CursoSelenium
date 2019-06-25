import static br.rs.cassiolinden.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.rs.cassiolinden.core.DriverFactory;

public class DesafioRegraNegocio {
	/* Testar:
	 * - Nome
	 * - Sobrenome
	 * - Sexo
	 * - Comida: Carne e Vegetariano
	 * - Esportes: Esporte e "O que eh esporte?"
	 * */
	
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}	
	
	@Test
	public void testarRegraNome() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void testarRegraSobrenome() {
		page.setNome("lalalal");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void testarRegraSexo() {
		page.setNome("lalalal");
		page.setSobrenome("lelelel");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void testarRegraVegetariano1() {
		page.setNome("lalalal");
		page.setSobrenome("lelelel");
		page.setSexoMasculino();
		page.setComidaVegetariano(); //vegetariano 
		page.setComidaCarne(); //carne
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void testarRegraVegetariano2() {
		page.setNome("lalalal");
		page.setSobrenome("lelelel");
		page.setSexoMasculino();
		page.setComidaVegetariano(); //vegetariano 
		page.setComidaFrango(); //frango
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void testarRegraEsporte() {
		page.setNome("lalalal");
		page.setSobrenome("lelelel");
		page.setSexoMasculino();
		page.setComidaVegetariano(); //vegetariano 
		page.setComidaPizza(); //pizza
		page.setEsporte("Karate","O que eh esporte?");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
}
