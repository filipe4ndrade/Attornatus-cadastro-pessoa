package com.attornatus.cadastropessoa.entities.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.cadastropessoa.entities.Endereco;
import com.attornatus.cadastropessoa.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> listarEnderecos() throws ParseException{
		List<Endereco> list = service.listarEnderecos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> consultarEndereco(@PathVariable Long id){
		Endereco obj = service.consultarEndereco(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
