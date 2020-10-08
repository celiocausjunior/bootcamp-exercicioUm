package com.celiocausjunior.devSuperiorCapituloUm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.celiocausjunior.devSuperiorCapituloUm.dtos.ClientDTO;
import com.celiocausjunior.devSuperiorCapituloUm.entities.Client;
import com.celiocausjunior.devSuperiorCapituloUm.repositories.ClientRepository;
import com.celiocausjunior.devSuperiorCapituloUm.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest page) {
		Page<Client> list = clientRepository.findAll(page);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
		return new ClientDTO(entity);
	}
}
