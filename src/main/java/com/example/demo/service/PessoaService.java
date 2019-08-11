package com.example.demo.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
@Transactional
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private Environment env;
	
	public void uploadFile(MultipartFile uploadFile) throws IOException {
		String filename = uploadFile.getOriginalFilename();
		String directory = env.getProperty("netgloo.paths.uploadedFiles");
		String filepath = Paths.get(directory, filename).toString();
		
		Reader reader = Files.newBufferedReader(Paths.get(filepath));
		CsvToBean<Pessoa> csvToBean = new CsvToBeanBuilder<Pessoa>(reader)
		        .withType(Pessoa.class)
		        .build();
		
		List<Pessoa> pessoas = csvToBean.parse();
		
		for (Pessoa pessoa : pessoas) {
			repository.save(pessoa);
			System.out.println("salvou no banco!");
		}
		
	}
	
}
