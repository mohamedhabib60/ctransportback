package com.caddan.CTransport.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Specialite")
public class Specialite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSpecialite;

	@Basic(optional = false)
	@Column(name = "titre", length = 200, nullable = false, unique = true)
	private String titre;

//Getters and Setters 

	public long getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(long idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
