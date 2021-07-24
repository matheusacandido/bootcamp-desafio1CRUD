package com.candmat.desafio1CRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candmat.desafio1CRUD.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
