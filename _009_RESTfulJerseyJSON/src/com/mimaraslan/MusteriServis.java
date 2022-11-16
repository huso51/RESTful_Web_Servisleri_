package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


// http://localhost:8080/_009_RESTfulJerseyJSON/rest/kayit

@Path("/kayit")
public class MusteriServis {
	
	// http://localhost:8080/_009_RESTfulJerseyJSON/rest/kayit/bilgi/1
	
	@GET
	@Path("/bilgi/{id}")
	//@Produces (MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces ("application/json"+";charset=utf-8")
	public Musteri getMusteriBilgi(@PathParam("id") int id) {
		
		Musteri musteri = new Musteri();
		musteri.setMusteritId(id);
		musteri.setMusteriAdi("Mustafa");
		musteri.setMusteriSehir("Şen");
		
		return musteri;
		
	}
	
}
