package com.attornatus.cadastropessoa.entities.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.attornatus.cadastropessoa.entities.Endereco;
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
	
	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa obj){
		obj = service.criarPessoa(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa obj){
		obj = service.editarPessoa(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	

	@GetMapping(value = "/{id}/enderecos")
	public ResponseEntity<List<Endereco>> listarEnderecos(@PathVariable Long id){
		Pessoa obj = service.consultarPessoa(id);
		return ResponseEntity.ok().body(obj.getEnderecos());
	}
	

	
}
