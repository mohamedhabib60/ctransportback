package com.caddan.CTransport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caddan.CTransport.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee ,Long>{

//  Pour chercher un client
  @Query("SELECT e from Employee e WHERE UPPER(e.nomComplet)"
  		+ " LIKE CONCAT('%',UPPER(:term),'%')"
  		+ "or UPPER(e.email) LIKE CONCAT('%',UPPER(:term),'%')")
  public List<Employee> chercher(@Param("term") String term);


}
