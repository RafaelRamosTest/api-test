package service;

import config.Config;
import io.restassured.response.Response;

public class CodesService {
	
	Config config = new Config();
	
	Service send = new Service();
	
	Response response;
	
	public Response postCode(String body) {
		
		String urlCodes = "codes";
		
		response = send.postRequest(config.dominioPix + config.urlPix, urlCodes, body);
		
        return response;
		
	}
	
	public String body(String qrCode) {
		
		String body = "{\r\n"
				+ "   \"encoded_value\":\"" + qrCode + "\"\r\n"
				+ "}";
		
		return body;
		
	}

}

