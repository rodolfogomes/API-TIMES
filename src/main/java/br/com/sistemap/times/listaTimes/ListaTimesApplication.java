package br.com.sistemap.times.listaTimes;

import br.com.sistemap.times.listaTimes.service.XMLService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ListaTimesApplication {

	public static void main(String[] args) {

		SpringApplication.run(ListaTimesApplication.class, args);

        XMLService xmlService = new XMLService();
		try {
			xmlService.printMarketDTOFromApi();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
