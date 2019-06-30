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

@Entity(name = "Employee")
public class Employee implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmployee;

	@Column(name = "nomComplet", length = 60, nullable = false, unique = false)
	private String nomComplet;
	
	@Column(name = "NNI", length = 60, nullable = false, unique = false)
	private String nni;

	
	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "dateEmbauche", nullable = true)
	private Date dateEmbauche ;

	
	@Column(name = "salaire", nullable = false)
	private float salaire;
	
	
	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "dateNaissance", nullable = true)
	private Date dateNaissance;

	@Column(name = "tel", length = 20, nullable = false)
	private String tel;


	@Column(name = "email", nullable = true, length = 200)
	private String email;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPoste", nullable = true)
	@NotNull(message = "{Poste.requis}")
	private Poste poste;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPays", nullable = true)
	@NotNull(message = "{Pays.requis}")
	private Pays nationnalite;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idNiveauEtude")
	@NotNull(message = "{niveauEtude.requis}")
	private NiveauEtude niveauEtude;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSpecialite")
	@NotNull(message = "{Specialite.requis}")
	private Specialite specialite;

	
	
	
	
	
	//Getters and Setters 
	
	
	public long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getNni() {
		return nni;
	}

	public void setNni(String nni) {
		this.nni = nni;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Pays getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(Pays nationnalite) {
		this.nationnalite = nationnalite;
	}

	public NiveauEtude getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(NiveauEtude niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	

	
}
