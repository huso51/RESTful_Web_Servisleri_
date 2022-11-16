package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


// http://localhost:8080/_005_XmlRootElement/rest/kayit

@Path("/kayit")
public class Merkez {
	
	// http://localhost:8080/_005_XmlRootElement/rest/kayit/bilgi/1
	
	@GET
	@Path("/bilgi/{id}")
	@Produces (MediaType.APPLICATION_XML)
	public Musteri getMusteriBilgi(@PathParam("id") int id) {
		
		Musteri musteri = new Musteri();
		musteri.setMusteritId(id);
		musteri.setMusteriAdi("Burak");
		musteri.setMusteriSehir("Adana");
		
		return musteri;
		
	}
	
}
