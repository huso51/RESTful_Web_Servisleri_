package com.mimaraslan;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


//  http:localhost:8080/_015_RESTfulRESTEasy-AJAX/rest/uye
@Path("/uye")
public class UyeServis {

	
//  http:localhost:8080/_015_RESTfulRESTEasy-AJAX/rest/uye/ekle	
	@POST
	@Path("/ekle")
	@Produces ("text/html;charset=utf-8")
	public Response uyeEkle(@FormParam("adi") String adi,  @FormParam("soyadi") String soyadi) {
		String sonuc = "<font face=verdana size=3 color=red> " + adi + " " + soyadi + "</font>" ;
		return Response.status(200).entity("EKLENEN BİLGİ: " + sonuc).build();	
	}
	
//  http:localhost:8080/_015_RESTfulRESTEasy-AJAX/rest/uye/ekle	
	@POST
	@Path("/kontrol")
	public Response uyeKontrol(@QueryParam("adi") String adi,  @QueryParam("soyadi") String soyadi) {
		
		if(adi==null || adi.isEmpty()){
			return Response.ok().entity("adi bos gecilemez!").build();	

		}
		
		if(soyadi==null || soyadi.isEmpty()){
			return Response.ok().entity("soyadi bos gecilemez!").build();	

		}
		
		
		return Response.ok().entity("Sayın "  + adi + " " + soyadi + " RESTful ile AJAX kontrol edildi.").build();	
	}	
	
	
	
}
