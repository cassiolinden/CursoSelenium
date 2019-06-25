package br.rs.cassiolinden.test;
import static br.rs.cassiolinden.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.rs.cassiolinden.core.DSL;
import br.rs.cassiolinden.core.DriverFactory;
import br.rs.cassiolinden.page.CampoTreinamentoPage;
 

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}	
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][]{
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"C�ssio", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
			{"C�ssio", "Linden Albert", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
			{"C�ssio", "Linden Albert", "Masculino", Arrays.asList("Carne","Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?"},
			{"C�ssio", "Linden Albert", "Masculino", Arrays.asList("Carne"), new String[] {"Corrida","O que eh esporte?"}, "Voce faz esporte ou nao?"},
		});
	}
	
	@Test
	public void deveValidarRegras() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Masculino")) {
			page.setSexoMasculino();
		}else if(sexo.equals("Feminino")){
			page.setSexoFeminino();
		}
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano(); 
		if(comidas.contains("Pizza")) page.setComidaPizza(); 
		
		page.setEsporte(esportes);
		page.cadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
}