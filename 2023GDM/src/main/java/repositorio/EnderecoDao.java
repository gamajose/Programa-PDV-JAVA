/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Utilitarios.HibernateUtil;
import model.Endereco;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author deibi
 */
public class EnderecoDao {

    public Endereco getEnderecoPorClienteId(long id) {
        Endereco EnderecoCliente;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            EnderecoCliente = session.find(Endereco.class, id);
            session.getTransaction().commit();
        }
        return EnderecoCliente;
    }

    public void salva(Endereco e) {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
        }

    }

    public Endereco getEnderecoEntregaPorClienteId(long id) {
        Endereco EnderecoEntregaCliente;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Endereco> query = session.createQuery("Select e From Endereco e Where e.cliente.id = :id");
            query.setParameter("id", id);
            EnderecoEntregaCliente = query.getSingleResult();
            session.getTransaction().commit();
        }
        return EnderecoEntregaCliente;
    }
}
