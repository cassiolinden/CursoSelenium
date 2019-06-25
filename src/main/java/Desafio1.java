import static br.rs.cassiolinden.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.rs.cassiolinden.core.DriverFactory;



public class Desafio1 {

private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void desafioCadastro() {
		page.setNome("Cássio");
		page.setSobrenome("Linden Albert");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaFrango();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.setEsporte("Corrida");
		page.setSugestoes("lalalalalala");
		page.cadastrar();
		
		//verificação dos dados cadastrados
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Cássio", page.obterNomeCadastro());
		Assert.assertEquals("Linden Albert", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Carne Frango Pizza", page.obterComidaCadastro());
		Assert.assertEquals("superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Futebol Corrida", page.obterEsporteCadastro());
		Assert.assertEquals("lalalalalala", page.obterSugestoesCadastro());
	}
}
