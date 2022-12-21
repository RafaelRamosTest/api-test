package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import service.AccountsService;

public class AccountsSteps {
	
	AccountsService accounts = new AccountsService();
	
	Response response;
	
	String accountId;
	
	@Given("que tenha informado id da conta valido {string}")
	public void que_tenha_informado_id_da_conta_valido(String accountId) {
	    
		this.accountId = accountId;
		
	}
	
	@Then("deve retornar as informacoes da conta")
	public void deve_retornar_as_informacoes_da_conta() {
		
		Assert.assertEquals(200, response.statusCode());
		
		Assert.assertEquals(this.accountId, response.jsonPath().getString("account_id"));
	    
	}

	@Given("que tenha informado id da conta invalido {string}")
	public void que_tenha_informado_id_da_conta_invalido(String accountId) {

		this.accountId = accountId;
		
	}
	@Then("deve retornar retornar erro {int}")
	public void deve_retornar_retornar_erro(Integer int1) {
	     
		Assert.assertEquals(404, response.statusCode());
		
	}

	@When("consultar conta")
	public void consultar_conta() {
		
		response = accounts.getAccount(this.accountId);
	    
	}


}
