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


@Entity
public class Pret implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPret;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmployee", nullable = true)
	@NotNull(message = "{Employee.requis}")
	private Employee employee;
	
	
	
	@Column(name = "somme", nullable = false)
	private float somme=0;
	


	@Column(name = "dernierPaie", nullable = false)
	private float dernierPaie=0;
	
	@Column(name = "payee", nullable = false)
	private float payee=0;
	
	
	
	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "datePret", nullable = false)
	private Date datePret =new Date();
	
	
	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "dateDernierPaie", nullable = false ,
			columnDefinition = "date NOT NULL DEFAULT now()")
	private Date dateDernierPaie = new Date();

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = true)
	@NotNull(message = "{User.requis}")
	private AppUser user;
	
	
	//Getters And Setters

	
	public float getPayee() {
		return payee;
	}


	public void setPayee(float payee) {
		this.payee = payee;
	}
	
	public AppUser getUser() {
		return user;
	}


	public float getDernierPaie() {
		return dernierPaie;
	}

	public void setDernierPaie(float dernierPaie) {
		this.dernierPaie = dernierPaie;
	}

	public Date getDateDernierPaie() {
		return dateDernierPaie;
	}

	public void setDateDernierPaie(Date dateDernierPaie) {
		this.dateDernierPaie = dateDernierPaie;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public long getIdPret() {
		return idPret;
	}

	public void setIdPret(long idPret) {
		this.idPret = idPret;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	public Date getDatePret() {
		return datePret;
	}

	public void setDatePret(Date datePret) {
		this.datePret = datePret;
	}
	
	
	
	
	
	
	
}
