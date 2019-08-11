package com.example.demo;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@SpringBootApplication
public class SafitApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SafitApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Reader reader = Files.newBufferedReader(Paths.get("C:\\csv\\pessoas.csv"));
		
		CsvToBean<Pessoa> csvToBean = new CsvToBeanBuilder<Pessoa>(reader)
                .withType(Pessoa.class)
                .build();
		
		List<Pessoa> pessoas = csvToBean.parse();
		
//		for (Pessoa pessoa : pessoas) {
//			repository.save(pessoa);
//			System.out.println("salvou no banco!");
//		}
		
	}

}
