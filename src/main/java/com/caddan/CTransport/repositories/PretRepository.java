package com.caddan.CTransport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caddan.CTransport.model.Pret;

public interface PretRepository extends JpaRepository<Pret, Long> {


	
//  Pour chercher les pret d'un client
  @Query("SELECT p from Pret p WHERE UPPER(p.employee.nomComplet)"
  		+ " LIKE CONCAT('%',UPPER(:term),'%')"
  		+ "or UPPER(p.employee.email) LIKE CONCAT('%',UPPER(:term),'%')")
  public List<Pret> chercher(@Param("term") String term);



}
