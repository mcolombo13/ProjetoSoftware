package br.unasp.projeto.controle;

import br.unasp.projeto.vo.Pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class PessoaControle {



	public static void main(String[] args) {
		SpringApplication.run(PessoaControle.class, args);
	}
	
	

    @PutMapping("/pessoa")
    public Pessoa criarPessoa(@RequestParam String nome, @RequestParam int idade) {
        return new Pessoa(nome, idade);
    }
	
	
}
