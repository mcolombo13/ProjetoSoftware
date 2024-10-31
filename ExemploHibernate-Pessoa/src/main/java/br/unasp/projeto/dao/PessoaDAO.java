package br.unasp.projeto.dao;

import br.unasp.projeto.vo.Pessoa;
import java.util.List;

public interface PessoaDAO {
    Pessoa salvar(Pessoa pessoa);
    Pessoa buscarPorId(Long id);
    List<Pessoa> listarTodos();
    void excluir(Long id);
}
