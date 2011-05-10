package no.rih.rest.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Workout implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Workout() {
		
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
