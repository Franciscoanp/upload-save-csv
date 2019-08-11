package com.example.demo.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/uploadFile")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	@PostMapping
	@ResponseBody
	public ResponseEntity<Pessoa> uploadFileAndSave(@RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {

		service.uploadFile(uploadFile);

		return new ResponseEntity<Pessoa>(HttpStatus.OK);
	}

}
