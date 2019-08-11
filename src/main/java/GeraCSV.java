import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Pessoa;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class GeraCSV {

	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Joao", "15", "ABCD@dicasdejava.com.br"));
		pessoas.add(new Pessoa("Maria", "10", "EEEEE@dicasdeprogramacao.com.br"));
		pessoas.add(new Pessoa("Ana", "05", "AAAAAAA@dicasdejava.com.br"));
		
		Writer writer = Files.newBufferedWriter(Paths.get("C:\\csv\\pessoas.csv"));
		StatefulBeanToCsv<Pessoa> beanToCsv = new StatefulBeanToCsvBuilder<Pessoa>(writer).build();
		
		beanToCsv.write(pessoas);
		System.out.println("Arquivo gerado!");
		
		writer.flush();
		writer.close();
	}
	
}
