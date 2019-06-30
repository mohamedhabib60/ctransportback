package com.caddan.CTransport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Mois")
public class Mois implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMois;
	
	@Column(name = "nom", length = 30, nullable = false, unique = true)
	private String nom;

	
	//Getters and Setters 
	public long getIdMois() {
		return idMois;
	}

	public void setIdMois(long idMois) {
		this.idMois = idMois;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	

}
