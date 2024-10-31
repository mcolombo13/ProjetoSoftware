package br.unasp.projeto.dao;

import br.unasp.projeto.vo.Pessoa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PessoaDAOImpl implements PessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        entityManager.persist(pessoa);
        return pessoa;
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> listarTodos() {
        return entityManager.createQuery("from Pessoa", Pessoa.class).getResultList();
    }

    @Override
    public void excluir(Long id) {
        Pessoa pessoa = buscarPorId(id);
        if (pessoa != null) {
            entityManager.remove(pessoa);
        }
    }
}
