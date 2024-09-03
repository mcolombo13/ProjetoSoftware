package br.unasp.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/teste")
public class Principal {

	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
	}

	@GetMapping()
	public String getGreeting(){
		return "\n\nOi...\n\n";
	}
}
