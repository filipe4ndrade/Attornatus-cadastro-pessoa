package com.attornatus.cadastropessoa.entities.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.cadastropessoa.entities.Pessoa;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@GetMapping
	public ResponseEntity<Pessoa> findAll() throws ParseException{
		Pessoa p = new Pessoa(1L, "Filipe",sdf.parse("27/03/2000"));
		return ResponseEntity.ok().body(p);
	}
}
