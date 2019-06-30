package com.caddan.CTransport.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Poste")
public class Poste implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPoste;

	@Basic(optional = false)
	@Column(name = "titre", length = 200, nullable = false, unique = true)
	private String titre;


	//Getters and Setters
	public long getIdPoste() {
		return idPoste;
	}

	public void setIdPoste(long idPoste) {
		this.idPoste = idPoste;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	

}
