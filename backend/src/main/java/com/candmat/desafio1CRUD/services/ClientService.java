package com.candmat.desafio1CRUD.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candmat.desafio1CRUD.dto.ClientDTO;
import com.candmat.desafio1CRUD.entities.Client;
import com.candmat.desafio1CRUD.repositories.ClientRepository;
import com.candmat.desafio1CRUD.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> listClient = repository.findAll(pageRequest);
		return listClient.map(k -> new ClientDTO(k));
}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}



}
