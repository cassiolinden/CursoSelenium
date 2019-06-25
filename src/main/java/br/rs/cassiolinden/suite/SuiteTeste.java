package br.rs.cassiolinden.suite;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.rs.cassiolinden.core.DriverFactory;
import br.rs.cassiolinden.test.Desafio1;
import br.rs.cassiolinden.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	Desafio1.class,
	TesteRegrasCadastro.class
})

public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}
