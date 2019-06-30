package com.caddan.CTransport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AppUser")
public class AppUser implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nomComplet", length = 60, nullable = false, unique = false)
	private String nomComplet;

	
	@Column(name = "username", length = 64, nullable = false , unique=true)
	private String username;
	
	@Column(name = "password", length = 64, nullable = false)
	private String password;
	
	
   @Column(name = "tel", length = 20, nullable = true)
	private String tel;


	@Column(name = "email", nullable = true, length = 200)
	private String email;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPays", nullable = true)
	@NotNull(message = "{Pays.requis}")
	private Pays nationnalite;


	//Getters and Setters



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNomComplet() {
		return nomComplet;
	}


	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Pays getNationnalite() {
		return nationnalite;
	}


	public void setNationnalite(Pays nationnalite) {
		this.nationnalite = nationnalite;
	}
	
	

}
