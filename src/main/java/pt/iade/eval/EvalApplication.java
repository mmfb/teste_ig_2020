package pt.iade.eval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.iade.eval.models.repositories.CusteaveisRepository;

@SpringBootApplication
public class EvalApplication {

	public static void main(String[] args) {
		// Call your populates here
		CusteaveisRepository.populate();
		SpringApplication.run(EvalApplication.class, args);
	}
}
