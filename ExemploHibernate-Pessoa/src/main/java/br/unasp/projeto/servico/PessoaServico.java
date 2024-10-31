package br.unasp.projeto.servico;

import br.unasp.projeto.dao.PessoaDAO;
import br.unasp.projeto.vo.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServico {

    @Autowired
    private PessoaDAO pessoaDao;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaDao.salvar(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaDao.buscarPorId(id);
    }

    public List<Pessoa> listarTodos() {
        return pessoaDao.listarTodos();
    }

    public void excluir(Long id) {
        pessoaDao.excluir(id);
    }
}
