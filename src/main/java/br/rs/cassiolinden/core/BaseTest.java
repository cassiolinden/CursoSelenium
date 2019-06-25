package br.rs.cassiolinden.core;
import static br.rs.cassiolinden.core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest {
	
	@After
	public void finaliza() {
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
