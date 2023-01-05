package com.attornatus.cadastropessoa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.cadastropessoa.entities.Endereco;
import com.attornatus.cadastropessoa.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> listarEnderecos(){
		return repository.findAll();
	}
	
	public Endereco consultarEndereco(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.get();
	}
	

	
}
