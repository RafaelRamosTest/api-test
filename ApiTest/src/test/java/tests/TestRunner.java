package tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features"
				 ,glue={"steps"}
				 ,plugin = { "pretty", "html:report/relatorio.html"}
				 ,publish = true
			   //,tags= ("@accounts")
			   //,tags= ("@codes")
			   //,tags= ("@registrarCodeSucesso")
			   ,tags= ("@consultarContaSucesso")
			   //,tags= ("@consultarContaErro")
						 
				)
public class TestRunner {

}
