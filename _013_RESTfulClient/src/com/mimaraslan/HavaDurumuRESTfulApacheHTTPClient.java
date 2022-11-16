package com.mimaraslan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HavaDurumuRESTfulApacheHTTPClient {


	private void getFahrenheitToCelsius(Double fah) {		
		try {			
			/*
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/_012_RESTfulServer/ftocservice/"+fah);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			*/
			
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet httpGetRequest = new HttpGet("http://localhost:8080/_012_RESTfulServer/ftocservice/"+fah);
			        httpGetRequest.addHeader("accept", "application/json");	
			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
			

				if (httpResponse.getStatusLine().getStatusCode() != 200) {  //response.getStatus() != 200
					throw new RuntimeException("HATA MEYDANA GELDİ. GELEN HTTP STATUS CODE : " + httpResponse.getStatusLine().getStatusCode() ); 
																								//response.getStatus()
				}	
			//System.out.println(response.getEntity(String.class));
				
				BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
				String sonuc ;
				
		
			while ((sonuc = br.readLine()) != null ) {
				System.out.println(sonuc);
			}
				
			
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
	HavaDurumuRESTfulApacheHTTPClient nesne = new HavaDurumuRESTfulApacheHTTPClient();
	
	nesne.getFahrenheitToCelsius(98.3);
	
	System.out.println("\n\n---------------------------\n\n");
	
	nesne.getCelsiusToFahrenheit(55.8);
		
		
	}
	
}
