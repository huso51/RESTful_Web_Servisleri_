package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//  http://localhost:8080/_001_RESTfulJersey/rest/selam
@Path(value = "/selam")
public class Merkez {
	

	
//  http://localhost:8080/_001_RESTfulJersey/rest/selam
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String metot1() {
		System.out.println("metot1");
		return "Selamlar RESTful";
	}
	
	
	
//  http://localhost:8080/_001_RESTfulJersey/rest/selam
	@GET
	@Produces("text/html")
	public Response metot2() {
		System.out.println("metot2");		
	    String sonuc =	"<font face=verdana size=40>METOT2</font>";
		return Response.status(200).entity(sonuc).build();
	}
		
	
	
//  http://localhost:8080/_001_RESTfulJersey/rest/selam/sorgu3
	@GET 
	@Path("/sorgu3")
	@Produces("text/html")
	public Response metot3() {		
	    String sonuc =	"<font face=verdana size=60>METOT3</font>";
		return Response.status(200).entity(sonuc).build();
	}
			

	
	
//  http://localhost:8080/_001_RESTfulJersey/rest/selam/sorgu4/{benimParametrem}
	@GET 
	@Path("/sorgu4/{benimParametrem}")
	@Produces(MediaType.TEXT_XML)
	public Response metot4(@PathParam("benimParametrem") String benimParametrem) {		
	    String sonuc =	"<?xml version=\"1.0\"?><soyle>"+ benimParametrem +" </soyle>";
		return Response.status(200).entity(sonuc).build();
	}
	
	
	
//  http://localhost:8080/_001_RESTfulJersey/rest/selam/sorgu5/{benimParametrem}
	@GET 
	@Path("/sorgu5")
	@Produces(MediaType.TEXT_HTML)
	public Response metot5(@QueryParam("benimParametrem") String benimParametrem) {		
	    String sonuc =	"SELAM, " + benimParametrem + " :) " ;
		return Response.ok(sonuc, MediaType.TEXT_HTML).build();
	}
		
	

}
