package com.attornatus.cadastropessoa.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.attornatus.cadastropessoa.entities.Pessoa;
import com.attornatus.cadastropessoa.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "José Filipe",sdf.parse("27/03/2000"));
		Pessoa p2 = new Pessoa(null, "Maria Cecilia",sdf.parse("13/07/2001"));
		
		pessoaRepository.saveAll(Arrays.asList(p1,p2));
		
	}
}
