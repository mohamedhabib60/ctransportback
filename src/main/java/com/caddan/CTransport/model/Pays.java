package com.caddan.CTransport.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Pays")
public class Pays implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPays;

	@Basic(optional = false)
	@Column(name = "nom", length = 100, nullable = false, unique = true)
	private String nom;

	@Column(name = "code2", length = 2, nullable = false, unique = true)
	private String code2;

	@Basic(optional = false)
	@Column(name = "code3", length = 3, nullable = false, unique = true)
	private String code3;

	
	// Getters and Setters

	public long getIdPays() {
		return idPays;
	}

	public void setIdPays(long idPays) {
		this.idPays = idPays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

}
