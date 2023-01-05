package com.attornatus.cadastropessoa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.cadastropessoa.entities.Pessoa;
import com.attornatus.cadastropessoa.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> listarPessoas(){
		return repository.findAll();
	}
	
	public Pessoa consultarPessoa(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.get();
	}
	
	public Pessoa criarPessoa(Pessoa obj) {
		return repository.save(obj);
	}
	
	public Pessoa editarPessoa(Long id, Pessoa obj) {
		Pessoa entity = repository.getReferenceById(id);
		entity.setNome(obj.getNome());
		entity.setDataNascimento(obj.getDataNascimento());
		return repository.save(entity);
	}
}
