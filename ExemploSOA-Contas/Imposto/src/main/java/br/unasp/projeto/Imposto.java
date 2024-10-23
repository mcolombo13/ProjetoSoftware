package br.unasp.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Imposto {
	
	public static void main(String[] args) {
        SpringApplication.run(Imposto.class, args);
    }
	
	

    @GetMapping("/calcularImposto")
    public double calcularImposto(@RequestParam double valor) {
        double taxaImposto = 0.1;
		
        return valor * taxaImposto;
    }
}
