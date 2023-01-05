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

import com.attornatus.cadastropessoa.entities.Pessoa;
import com.attornatus.cadastropessoa.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoas() throws ParseException{
		List<Pessoa> list = service.listarPessoas();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long id){
		Pessoa obj = service.consultarPessoa(id);
		return ResponseEntity.ok().body(obj);
	}
}
