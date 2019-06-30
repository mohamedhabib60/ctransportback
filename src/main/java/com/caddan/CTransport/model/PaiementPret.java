package com.caddan.CTransport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity(name="PaiementPret")
public class PaiementPret implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPaiementPret;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPret", nullable = true)
	@NotNull(message = "{Pret.requis}")
	private Pret pret;
	
	@Column(name = "somme", nullable = false)
	private float somme;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = true)
	@NotNull(message = "{User.requis}")
	private AppUser user;
	
	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "datePaie", nullable = false)
	private Date datePaie ;
	
	//Getters and Setters

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public long getIdPaiementPret() {
		return idPaiementPret;
	}

	public void setIdPaiementPret(long idPaimentPret) {
		this.idPaiementPret = idPaimentPret;
	}

	public Pret getPret() {
		return pret;
	}

	public void setPret(Pret pret) {
		this.pret = pret;
	}

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	public Date getDatePaie() {
		return datePaie;
	}

	public void setDatePaie(Date datePaie) {
		this.datePaie = datePaie;
	}
	
	
	
	

}
