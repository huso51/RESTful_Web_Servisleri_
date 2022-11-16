package com.mimaraslan.ws.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MusteriRESTfulClient {
	
	
	public static void main(String[] args) {
		
		
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/_017_RESTful-MultipleOutputFormat-JDBC-CRUD/rest/musteri/herkes");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
			if (response.getStatus() == 200) {
				
				System.out.println(response.getEntity(String.class));
		
			}else{
				System.out.println("HATA MEYDANA GELDİ. : HTTP STATUS CODE: " + response.getStatus());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
