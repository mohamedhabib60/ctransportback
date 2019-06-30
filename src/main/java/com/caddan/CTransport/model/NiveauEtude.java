package com.caddan.CTransport.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "NiveauEtude")
public class NiveauEtude implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idNiveauEtude;

	@Basic(optional = false)
	@Column(name = "titre", length = 100, nullable = false)
	private String titre;

	
	
	//Getters and Setters 
	
	

	public long getIdNiveauEtude() {
		return idNiveauEtude;
	}

	public void setIdNiveauEtude(long idNiveauEtude) {
		this.idNiveauEtude = idNiveauEtude;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	

}
