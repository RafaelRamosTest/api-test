package service;

import config.Config;
import io.restassured.response.Response;

public class PaymentsService {
	
	Config config = new Config();
	
	Service send = new Service();
	
	Response response;
	
	public Response postPayments(String body) {
		
		String urlPayments = "payments";
		
		response = send.postRequest(config.dominioPix + config.urlPix, urlPayments, body);
		
        return response;
		
	}
	
	public String body(String endToEnd, String conciliationId) {
		
		String body = "{\r\n"
				+ "   \"end_to_end\":\"" + endToEnd + "\",\r\n"
				+ "   \"conciliation_id\":\"" + conciliationId + "\"\r\n"
				+ "}";
		
		return body;
		
	}

}
