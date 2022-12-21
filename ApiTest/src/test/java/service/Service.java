package service;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Service {
	
	String url;
	
	Response response;	
	
	public Response getRequest(String dominio, String url, String token) {
		
		RestAssured.baseURI = dominio; //"https://jsonplaceholder.typicode.com";
		
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .param("", "")
                .when()
                .get(url) // "/posts"
                .then()
                .extract().response();

        return response;
        
    }
	
	public Response getRequest(String dominio, String url) {
		
		RestAssured.baseURI = dominio; //"https://jsonplaceholder.typicode.com";
		
        Response response = given()
                .contentType(ContentType.JSON)
                .param("", "")
                .when()
                .get(url) // "/posts"
                .then()
                .extract().response();

        return response;
        
    }
	
	public Response getRequestWithQueryParam(String dominio, String url, String id, String token) {
		
		RestAssured.baseURI = dominio;
		
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .param("postId", id)
                .when()
                .get(url) // "/comments"
                .then()
                .extract().response();

        return response;
        
    }
	
	public Response postRequest(String dominio, String url, String body, String token) {
		
		RestAssured.baseURI = dominio;
		
        Response response = given()
        		.header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .and()
                .body(body)
                .when()
                .post(url)
                .then()
                .extract().response();
        
        return response;
        
    }
	
	public Response postRequest(String dominio, String url, String body) {
		
		RestAssured.baseURI = dominio;
		
        Response response = given()
        		.header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(url)
                .then()
                .extract().response();
        
        return response;
        
    }
	
	public Response postRequest(String dominio, String url) {
		
		RestAssured.baseURI = dominio;
		
		try {
			
			this.url = URLDecoder.decode(url, "UTF-8");
			
			response = given()
	        		.when()
	        		.log()
	        		.all()
	                .post(this.url)
	                .then()
	                .extract().response();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			
		}
        
        return response;
        
    }
	
	public Response postRequest2(String dominio, String url) {
		
		RestAssured.baseURI = dominio;
		
		try {
			
			this.url = URLDecoder.decode(url, "UTF-8");
			
			response = given()
	        		.when()
	                .post(this.url)
	                .then()
	                .extract().response();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			
		}
        
        return response;
        
    }
	
	public Response putRequest(String dominio, String url, String body, String token) {
		
		RestAssured.baseURI = dominio;
		
        Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .and()
                .body(body)
                .when()
                .put(url)
                .then()
                .extract().response();

        return response;
        
    }
	
	public Response patchRequest(String dominio, String url, String body, String token) {
        
		RestAssured.baseURI = dominio;
		
		Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .and()
                .body(body)
                .when()
                .patch(url)
                .then()
                .extract().response();

        return response;
        
    }

}
