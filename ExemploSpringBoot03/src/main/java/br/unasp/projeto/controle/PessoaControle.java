package br.unasp.projeto.controle;

import br.unasp.projeto.vo.Pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class PessoaControle {



	public static void main(String[] args) {
		SpringApplication.run(PessoaControle.class, args);
	}
	
	

    @PutMapping("/pessoa")
    public Pessoa criarPessoa(@RequestParam String nome, @RequestParam int idade) {
		/*
		 *
		 * Verificar possiveis status: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
		 */
		
		if (nome == null || nome.trim().equals("")) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "O nome deve ser preenchido"
            );
        }		
		
		if (idade < 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "A idade deve ser maior que 0"
            );
        }
		
		if (idade > 120) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "A idade deve ser menor que 120"
            );
        }
	
        return new Pessoa(nome, idade);
    }
	
	
}
