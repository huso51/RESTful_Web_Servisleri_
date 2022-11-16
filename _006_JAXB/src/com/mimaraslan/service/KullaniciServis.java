package com.mimaraslan.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mimaraslan.model.Kullanici;

// http://localhost:8080/_006_JAXB/kullanici

@Path ("/kullanici")
public class KullaniciServis {

	// http://localhost:8080/_006_JAXB/kullanici/detay/15
	
	@GET
	@Path ("/detay/{id}")
	//@Produces (MediaType.APPLICATION_XML)
	public Response getKullaniciBilgi(@PathParam("id") Integer id) {
		
		Kullanici kullanici = new Kullanici();
		
		kullanici.setKullaniciId(id);
		kullanici.setKullaniciAdi("BURAK");
		kullanici.setKullaniciSoyadi("YILMAZ");
	
		return Response.status(200).entity(kullanici).build();
		
	}
}
