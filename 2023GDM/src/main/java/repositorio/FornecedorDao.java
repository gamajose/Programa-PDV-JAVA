/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Interfaces.FornecedoresInterface;
import Utilitarios.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import model.Fornecedor;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class FornecedorDao implements FornecedoresInterface {

    @Override
    public List<Fornecedor> listaFornecedores() {
        List<Fornecedor> listagemFornecedor;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            listagemFornecedor = session.createQuery("from Fornecedor p", Fornecedor.class).getResultList();
            session.getTransaction().commit();
        }

        return listagemFornecedor;
    }

    @Override
    public void deleteFornecedor(long id) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(session.get(Fornecedor.class, id));
            session.getTransaction().commit();
        }

    }

    @Override
    public Fornecedor fornecedorByCodigo(long codigo) {
        Fornecedor f;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            f = session.get(Fornecedor.class, codigo);
            session.getTransaction().commit();
        }

        return f;
    }



    @Override
    public void cadastra(Fornecedor f) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(f);
            session.getTransaction().commit();
        }
    }

    @Override
    public Fornecedor fornecedorByNome(String nome) {
        Fornecedor f;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT f FROM Fornecedor f WHERE f.pessoaJuridica.razaosocial = :pnome");
            query.setParameter("pnome", nome);
            f = (Fornecedor) session.merge(query.getSingleResult());
            session.getTransaction().commit();
        } catch (NoResultException e) {
            return null;
        }

        return f;
    }

    public static boolean verificaSeExistiFornecedorCadastrado() {
        boolean rsp = false;

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);

            query.select(builder.count(query.from(Fornecedor.class)));
            TypedQuery<Long> typedQuery = session.createQuery(query);

            if (typedQuery.getSingleResult() != 0) {
                rsp = true;
            }

            session.getTransaction().commit();
        }

        return rsp;
    }

}
