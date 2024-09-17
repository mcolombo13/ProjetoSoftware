package br.unasp.projeto.controle;

import br.unasp.projeto.vo.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PessoaControle.class)
public class PessoaControleTest {



    @Autowired
    private MockMvc mockMvc;



	@Test
	public void testCriarPessoaComNomeVazio() throws Exception {
		String nome = "";
		int idade = 25;

		mockMvc.perform(MockMvcRequestBuilders.put("/api/pessoa")
				.param("nome", nome)
				.param("idade", String.valueOf(idade)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}



	@Test
	public void testCriarPessoaComIdadeNegativa() throws Exception {
		String nome = "Maria";
		int idade = -5;

		mockMvc.perform(MockMvcRequestBuilders.put("/api/pessoa")
				.param("nome", nome)
				.param("idade", String.valueOf(idade)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}



	@Test
	public void testCriarPessoaComIdadeZero() throws Exception {
		String nome = "Carlos";
		int idade = 0;

		mockMvc.perform(MockMvcRequestBuilders.put("/api/pessoa")
				.param("nome", nome)
				.param("idade", String.valueOf(idade)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(nome))
				.andExpect(MockMvcResultMatchers.jsonPath("$.idade").value(idade));
	}


	@Test
	public void testCriarPessoaComNomeEIdadeMaxima() throws Exception {
		String nome = "A".repeat(255);
		int idade = Integer.MAX_VALUE;

		mockMvc.perform(MockMvcRequestBuilders.put("/api/pessoa")
				.param("nome", nome)
				.param("idade", String.valueOf(idade)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(nome))
				.andExpect(MockMvcResultMatchers.jsonPath("$.idade").value(idade));
	}



    @Test
    public void testCriarPessoa() throws Exception {
        String nome = "Joao";
        int idade = 30;

        mockMvc.perform(MockMvcRequestBuilders.put("/api/pessoa")
                .param("nome", nome)
                .param("idade", String.valueOf(idade)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(nome))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idade").value(idade));
    }
}
