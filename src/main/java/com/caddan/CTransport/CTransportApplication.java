package com.caddan.CTransport;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caddan.CTransport.model.AppRole;
import com.caddan.CTransport.model.AppUser;
import com.caddan.CTransport.model.Employee;
import com.caddan.CTransport.model.NiveauEtude;
import com.caddan.CTransport.model.Pays;
import com.caddan.CTransport.model.Poste;
import com.caddan.CTransport.model.Specialite;
import com.caddan.CTransport.model.UserRole;
import com.caddan.CTransport.repositories.AppRoleRepository;
import com.caddan.CTransport.repositories.AppUserRepository;
import com.caddan.CTransport.repositories.EmployeeRepository;
import com.caddan.CTransport.repositories.NiveauEtudeRepository;
import com.caddan.CTransport.repositories.PaysRepository;
import com.caddan.CTransport.repositories.PosteRepository;
import com.caddan.CTransport.repositories.SpecialiteRepository;
import com.caddan.CTransport.repositories.UserRoleRepository;
import com.caddan.CTransport.services.Imp.AppUserServiceImpl;

//Application SB
@SpringBootApplication
public class CTransportApplication implements CommandLineRunner{
	
	@Autowired
    private EmployeeRepository er;
    @Autowired
    private NiveauEtudeRepository nr;
    @Autowired
    private PaysRepository pr;
    @Autowired
    private PosteRepository postr;
    
    
    @Autowired
	private UserRoleRepository rolerepo;
	
    
    @Autowired
    AppUserServiceImpl app;
    
    @Autowired
    AppUserRepository userRep;
    @Autowired
    AppRoleRepository roleRep;

    @Autowired
    private SpecialiteRepository srep;
    
    
	public static void main(String[] args) {
		SpringApplication.run(CTransportApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		
		//Pays
		Pays pays=new Pays();
		pays.setCode2("MR");
		pays.setCode3("MRT");
		pays.setNom("Mauritanie");
		pr.save(pays);
		
	   NiveauEtude nve =new NiveauEtude();
	   nve.setTitre("Bac +12");
	   nr.save(nve);
	   
	   
	   Poste poste =new Poste();
	   poste.setTitre("Poste1");
	   postr.save(poste);
	   
	   Specialite sp=new Specialite();
		sp.setTitre("Ingenieure");
		srep.save(sp);
		
		
		for (int i=0;i<20;i++) {
			Employee p1=new Employee();
			p1.setDateEmbauche(new Date());
			p1.setDateNaissance(new Date());
			p1.setEmail("med@med"+i+"k"+i);
			p1.setNationnalite(pays);
			p1.setNiveauEtude(nve);
			p1.setNni("415475414");
			p1.setNomComplet("emplpyee");
			p1.setPoste(poste);
			p1.setSalaire(400000);
			p1.setSpecialite(sp);
			p1.setTel("4178454");
			
			er.save(p1);
		
			
		}
		List<Employee> list =er.chercher("emplpyee");
		System.out.println(list.size());
		
		for(int i =0 ;i<list.size();i++) {
			
			System.out.println(list.get(i).getEmail());
		}
		
		//For Security 
		
		AppUser u1 =new AppUser();
		AppUser u2 =new AppUser();
		
		u1.setNationnalite(pays);
		u1.setNomComplet("mohamed");
		u1.setUsername("mohamed");
		u1.setPassword("mohamed");
		
		
		
		
		u2.setNationnalite(pays);
		u2.setNomComplet("vall");
		u2.setUsername("vall");
		u2.setPassword("vall");
		
		
		
		
		AppRole r1 =new AppRole();
		AppRole r2 =new AppRole();
		
		r1.setNom("ROLE_USER");
		r1.setDescription("Ordinary user");
		
		r2.setNom("ROLE_ADMIN");
		r2.setDescription("Administrateur");
		
		roleRep.save(r1);
		roleRep.save(r2);
		 
		
		app.save(u1);
		app.save(u2);
		
		UserRole ur1 =new UserRole();
		ur1.setRole(r1);
		ur1.setUser(u1);
		rolerepo.save(ur1);
		
		UserRole ur2 =new UserRole();
		ur2.setRole(r1);
		ur2.setUser(u2);
		rolerepo.save(ur2);
		
		UserRole ur3 =new UserRole();
		ur3.setRole(r2);
		ur3.setUser(u2);
		rolerepo.save(ur3);
		
		
		System.out.println(app.findByUsername("mohamed").getEmail());
		

		
    }

}
