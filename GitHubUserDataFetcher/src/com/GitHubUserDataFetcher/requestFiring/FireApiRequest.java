package com.GitHubUserDataFetcher.requestFiring;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FireApiRequest {
	
	private HttpClient client;
	private String url = "https://api.github.com/users/";
	
	public FireApiRequest() {
		this.client = HttpClient.newHttpClient();
	}
	
	//login
    public String getEventInfo(String requiredUser){
        System.out.println("===========Initiating Connection============");
        String outputResponse = "";
        String firingUrl = url+requiredUser+"/events";
        try{
           
        	HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(firingUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code : "+response.statusCode());

            outputResponse = response.body() != null ? response.body() : "null";

        }catch (Exception e){
            System.out.println("Error initiating Connection with "+url);
            System.out.println("Error : "+e.getMessage());
        }
        return outputResponse;
    }
    
    //About user
    public String getUserInfo(String username) {
    	String response = "";
    	String uri = url +username;
    	
    	try {
    		HttpRequest request = HttpRequest.newBuilder()
    							 .uri(URI.create(uri))
    							 .GET().build();
    		HttpResponse<String> apiResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
    		
    		System.out.println("Status Code : "+apiResponse.statusCode());
    		
    		response = apiResponse.body() != null ? apiResponse.body() : "null";
    		
    		return response;
    	}catch(Exception e) {
    		System.out.println("Error fetching user details : "+e.getMessage());
    	}
    	
    	return response;
    }
    
    public String getUserRepos(String username) {
    	String response = "";
    	String uri = url+username+"/repos";
    	
    	try {
    		HttpRequest request = HttpRequest.newBuilder()
    							 .uri(URI.create(uri))
    							 .GET().build();
    		HttpResponse<String> apiResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
    		System.out.println("Status code : "+apiResponse.statusCode());
    		
    		response = apiResponse.body() != null ? apiResponse.body() : "null";
    		return response;
    	}catch(Exception e) {
    		System.out.println("Error fetching Repository Details : "+e.getMessage());
    	}
       	return response;
    }

}
