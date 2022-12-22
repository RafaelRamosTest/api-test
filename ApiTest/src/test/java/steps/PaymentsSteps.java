package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import service.PaymentsService;

public class PaymentsSteps {
	
	PaymentsService payments = new PaymentsService();
	
	Response response;
	
	String endToEnd = "test";
	
	String conciliationId = "456";
	
	String body = "";
	
	@Given("que tenha informado valores validos")
	public void que_tenha_informado_valores_validos() {
	    
		body = payments.body(endToEnd, conciliationId);
		
	}
		
	@Then("deve retornar as informacoes de payments")
	public void deve_retornar_as_informacoes_de_payments() {
	    
		Assert.assertEquals(200, response.statusCode());
		
	}
	
	@Given("que tenha informado end_to_end invalido")
	public void que_tenha_informado_end_to_end_invalido() {
	    
		endToEnd = "nenhum";
		
		body = payments.body(endToEnd, conciliationId);
		
	}
		
	@Then("mensagem de erro end_to_end {string}")
	public void mensagem_de_erro_end_to_end(String mensagemErro) {

		Assert.assertEquals(mensagemErro, response.jsonPath().getString("errors.endToEnd"));
		
	}
	
	@Given("que tenha informado conciliation_id invalido")
	public void que_tenha_informado_conciliation_id_invalido() {

		conciliationId = "";
		
		body = payments.body(endToEnd, conciliationId);
		
	}
	
	@Then("mensagem de erro conciliation_id {string}")
	public void mensagem_de_erro_conciliation_id(String mensagemErro) {
	    
		Assert.assertEquals(mensagemErro, response.jsonPath().getString("errors.conciliationId"));
		
	}
	
	@Then("deve retornar erro {int} para payments")
	public void deve_retornar_erro(int erro) {

		Assert.assertEquals(erro, response.statusCode());
		
	}

	@When("registrar payments")
	public void registrar_payments() {
	    
		response = payments.postPayments(body);
		
	}

}
