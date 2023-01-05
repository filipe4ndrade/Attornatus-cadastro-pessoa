package com.attornatus.cadastropessoa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.cadastropessoa.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	
}
