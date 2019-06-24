import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Desafio1 {

private WebDriver driver;
private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\cassio\\Documents\\webdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
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
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Cássio"));
		Assert.assertEquals("Sobrenome: Linden Albert", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Carne Frango Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Futebol Corrida", page.obterEsporteCadastro());
		Assert.assertEquals("Sugestoes: lalalalalala", page.obterSugestoesCadastro());
	}
}
