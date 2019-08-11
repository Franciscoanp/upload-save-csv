import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.demo.model.Pessoa;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class LeCSV {

	public static void main(String[] args) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get("C:\\csv\\pessoas.csv"));
		
		CsvToBean<Pessoa> csvToBean = new CsvToBeanBuilder<Pessoa>(reader)
                .withType(Pessoa.class)
                .build();
		
		List<Pessoa> pessoas = csvToBean.parse();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getEmail());
		}
		
		System.out.println("Arquivo salvo no banco de dados!");
	
	}
}
