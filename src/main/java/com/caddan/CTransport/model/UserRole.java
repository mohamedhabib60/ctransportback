package com.caddan.CTransport.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "UserRole" , uniqueConstraints= 
							@UniqueConstraint(columnNames={"idAppUser", "idApprole"}))
public class UserRole implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUserRole;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idAppUser")
	@NotNull(message = "{User.requis}")
	private AppUser user;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idApprole")
	@NotNull(message = "{Role.requis}")
	private AppRole role;

	
//Getters and Setters

	public long getIdUserRole() {
		return idUserRole;
	}


	public void setIdUserRole(long idUserRole) {
		this.idUserRole = idUserRole;
	}


	public AppUser getUser() {
		return user;
	}


	public void setUser(AppUser user) {
		this.user = user;
	}


	public AppRole getRole() {
		return role;
	}


	public void setRole(AppRole role) {
		this.role = role;
	}
	
	
	
	
}
