package com.mimaraslan;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HavaDurumuRESTfulJerseyClient {


	private void getFahrenheitToCelsius(Double fah) {		
		try {			
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/_012_RESTfulServer/ftocservice/"+fah);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			
				if (response.getStatus() != 200) {
					throw new RuntimeException("HATA MEYDANA GELDİ. GELEN HTTP STATUS CODE : " + response.getStatus());   
				}	
			System.out.println(response.getEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void getCelsiusToFahrenheit(Double cel) {
		try {			
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/_012_RESTfulServer/ctofservice/"+cel);
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			
				if (response.getStatus() != 200) {
					throw new RuntimeException("HATA MEYDANA GELDİ. GELEN HTTP STATUS CODE : " + response.getStatus());   
				}	
			System.out.println(response.getEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
public static void main(String[] args) {
	HavaDurumuRESTfulJerseyClient nesne = new HavaDurumuRESTfulJerseyClient();
	
	nesne.getFahrenheitToCelsius(98.3);
	
	System.out.println("\n\n---------------------------\n\n");
	
	nesne.getCelsiusToFahrenheit(55.8);
		
		
	}
	
}
