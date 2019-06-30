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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity(name="PaiementSalaire")
public class PaiementSalaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPaiementSalaire;
	
	
	

	@Column(name = "mois", nullable = false)
	@Min(1)
	@Max(12)
	private int mois;
	
	
	
	@Column(name = "annee", nullable = false )
	@Min(2019)
	@Max(9999)
	private int annee;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmployee", nullable = true)
	@NotNull(message = "{Employee.requis}")
	private Employee employee;
	


	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "datePaie", nullable = false)
	private Date datePaie ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = true)
	@NotNull(message = "{User.requis}")
	private AppUser user;

	
	
	
	//Getters and Setters
	
	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public long getIdPaiementSalaire() {
		return idPaiementSalaire;
	}

	public void setIdPaiementSalaire(long idPaiementSalaire) {
		this.idPaiementSalaire = idPaiementSalaire;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDatePaie() {
		return datePaie;
	}

	public void setDatePaie(Date datePaie) {
		this.datePaie = datePaie;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}
	
	
	
	

	
	
}
