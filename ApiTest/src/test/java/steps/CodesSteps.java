package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import service.CodesService;

public class CodesSteps {
	
	CodesService codes = new CodesService();
	
	Response response;
	
	String body = "";

	@Given("que tenha informado qrcode valido {string}")
	public void que_tenha_informado_qrcode_valido(String qrCodes) {	
		
		body = codes.body(qrCodes);
		
	}
	
	@When("registrar code")
	public void registrar_code() {

		response = codes.postCode(body);
		
	}
	
	@Then("deve retornar as informacoes do code")
	public void deve_retornar_as_informacoes_do_code() {

		Assert.assertEquals(200, response.statusCode());
		
	}

}
