package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;


//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici

@Path(value="/kullanici")
public class Merkez {

	
//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici
	@GET
	public Response selamVer1() {
		return Response.status(200).entity("selamlar").build();
	}
	

	
//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici/selamla
	@GET
	@Path("/selamla")
	public Response selamVer2() {
		return Response.status(200).entity("SELAMLAMA YAPILIYOR.").build();
		
	}
		

	
//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici/selamla/Murat
	@GET
	@Path("/selamla/{adi}")
	public Response selamVer3(@PathParam("adi") String adi) {
		return Response.status(200).entity("SELAMLAR "+ adi).build();
		
	}
			


	
//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici/01/Adana
	@GET
	@Path("/{plakaNumarasi}/{sehirAdi}")
	@Produces("text/html")
	public Response getSehirBilgisi(
			@PathParam("plakaNumarasi") String plakaNumarasi, 
			@PathParam("sehirAdi") String sehirAdi) {
		
		String sonuc = "DETAYLAR: " + sehirAdi + " - " + plakaNumarasi;
		
		return Response.status(200).entity(sonuc).build();	
	}
	
	
	
//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici/regex/Murat
	@GET
	@Path("/regex/{adi :[a-zA-Z][a-zA-Z_0-9]+ }")
	public Response selamVerRegex(@PathParam("adi") String adi) {
		return Response.status(200).entity("KURALLI SELAMLAR "+ adi).build();
		
	}
			
	
	
//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici/1/Murat
	@GET
	@Path("/1/{adi}")
	public Response selamBilgisiniAl(@PathParam("adi") String adi) {
		return Response.status(200).entity("SELAMLAR "+ adi).build();
		
	}
	
//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici/2/Murat/25
	@GET
	@Path("/2/{adi}/{yasi}")
	public Response selamBilgisiniAl(@PathParam("adi") String adi,   @PathParam("yasi") String yasi  ) {
		return Response.status(200).entity("ADI: "+ adi + " YAS: "+  yasi).build();
		
	}
	

//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici;adi=Nazım;ulke=Türkiye
	@GET
	@Produces("text/html"+";charset=utf-8")
	public Response personelBilgisiniAl(
			@MatrixParam("adi") String adi,   
			@MatrixParam("ulke") String ulke  ) {
		return Response.status(200).entity("ADI: "+ adi + " ÜLKE: "+  ulke).build();
		
	}	
	
	

//  http://localhost:8080/_003_RESTful-Annotations/rest/kullanici/personel/detay;adi=Nazım;meslek=Yazılımcı;tecrube=7
	@GET
	@Path("/personel/{detay}")
	@Produces("text/plain"+";charset=utf-8")
	public Response getPersonelBilgi(@PathParam("detay") PathSegment detay) {
		
		String personel = "Personel : ";
		
		MultivaluedMap<String, String> matrix = detay.getMatrixParameters();
		for (String key : matrix.keySet()) {
			personel +=  key + matrix.get(key) + " "; 
		}
		
		personel += " "; 
		
		return Response.status(200).entity(personel).build();
		
	}	
		
	
}









