package com.mimaraslan.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mimaraslan.model.Kullanici;

// http://localhost:8080/_008_RESTeasyJacksonJSON/kullanici

@Path ("/kullanici")
public class KullaniciServis {

	// http://localhost:8080/_008_RESTeasyJacksonJSON/kullanici/detay/15
	
	@GET
	@Path ("/detay/{id}")
	//@Produces (MediaType.APPLICATION_JSON + ";charset=utf-8")
      @Produces ("application/json"+";charset=utf-8")
	public Response getKullaniciBilgi(@PathParam("id") Integer id) {
		
		Kullanici kullanici = new Kullanici();
		
		kullanici.setKullaniciId(id);
		kullanici.setKullaniciAdi("Mustafa");
		kullanici.setKullaniciSoyadi("Şen");
	
		return Response.status(200).entity(kullanici).build();
		
	}
}
