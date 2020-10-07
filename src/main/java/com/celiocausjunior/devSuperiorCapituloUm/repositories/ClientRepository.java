package com.celiocausjunior.devSuperiorCapituloUm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celiocausjunior.devSuperiorCapituloUm.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}