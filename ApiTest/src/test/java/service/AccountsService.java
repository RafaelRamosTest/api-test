package service;

import config.Config;

import io.restassured.response.Response;

public class AccountsService {
	
	Service send = new Service();
	
	Config config = new Config();
	
	Response response;
	
	public Response getAccount(String accountId) {
		
		String urlAccounts = "accounts/" + accountId;
		
		response = send.getRequest(config.dominioPix, urlAccounts);		
        
        return response;
		
	}

}
