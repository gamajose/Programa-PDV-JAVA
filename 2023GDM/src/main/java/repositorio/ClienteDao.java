/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Interfaces.ClienteInterface;
import Utilitarios.HibernateUtil;
import java.util.List;
import model.Cliente;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class ClienteDao implements ClienteInterface {

    @Override
    public void salvaCliente(Cliente p) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(p);
            session.getTransaction().commit();
        }

    }

    @Override
    public Cliente clientePorCodigo(long codigo) {
        Cliente cliente;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Cliente> query = session.createQuery("SELECT c FROM Cliente c JOIN FETCH c.listaEndereco WHERE c.id = :id", Cliente.class);
            query.setParameter("id", codigo);
            cliente = query.uniqueResult();
            session.getTransaction().commit();
        }
        return cliente;
    }

    @Override
    public Cliente clientePorCpf(String cpf) {
        Cliente cliente;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Cliente> query = session.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class);
            query.setParameter("cpf", cpf);
            cliente = query.uniqueResult();
            session.getTransaction().commit();
        }
        return cliente;
    }

    public Cliente clientePorCodigoParaEdicao(long codigo) {
        Cliente cliente = null;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Cliente> query = session.createQuery("SELECT c FROM Cliente c JOIN FETCH c.listaEndereco WHERE c.id = :id", Cliente.class);
            query.setParameter("id", codigo);
            cliente = query.getSingleResult();
            session.getTransaction().commit();
        }

        return cliente;

    }

    @Override
    public void deleteCliente(Cliente p) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(p);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Cliente> listaTodosClientes() {
        List<Cliente> listagemClientes;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            listagemClientes = session.createQuery("from Cliente p", Cliente.class).getResultList();
            session.getTransaction().commit();
        }
        return listagemClientes;
    }

}
