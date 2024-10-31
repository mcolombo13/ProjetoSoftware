package br.unasp.projeto.controle;

import br.unasp.projeto.vo.Pessoa;
import br.unasp.projeto.servico.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaControle {

    @Autowired
    private PessoaServico pessoaServico;

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaServico.salvar(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscarPessoa(@PathVariable Long id) {
        return pessoaServico.buscarPorId(id);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaServico.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Long id) {
        pessoaServico.excluir(id);
    }
}
