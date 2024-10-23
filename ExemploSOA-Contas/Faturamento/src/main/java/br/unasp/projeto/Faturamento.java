package br.unasp.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Faturamento {

	public static void main(String[] args) {
        SpringApplication.run(Faturamento.class, args);
    }

    @GetMapping("/gerarFatura")
    public String gerarFatura(@RequestParam double valor) {
        RestTemplate restTemplate = new RestTemplate();
        String urlServicoImpostos = "http://localhost:8282/calcularImposto?valor=" + valor;
        
        double imposto = restTemplate.getForObject(urlServicoImpostos, Double.class);
        double valorFinal = valor + imposto;
        
        return "Valor Total (com impostos): R$ " + valorFinal;
    }
}
