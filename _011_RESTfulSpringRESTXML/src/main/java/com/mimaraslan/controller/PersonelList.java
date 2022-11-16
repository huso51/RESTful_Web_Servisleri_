package com.mimaraslan.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.mimaraslan.model.Personel;

@XmlRootElement (name="personeller")
public class PersonelList implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private List<Personel> personeller = new ArrayList<Personel>();

	public List<Personel> getPersoneller() {
		return personeller;
	}

	public void setPersoneller(List<Personel> personeller) {
		this.personeller = personeller;
	}
	
}
