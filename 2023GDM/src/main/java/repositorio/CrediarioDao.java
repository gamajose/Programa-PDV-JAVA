/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Interfaces.CrediarioInterface;
import Utilitarios.HibernateUtil;
import javax.persistence.TypedQuery;
import model.Conta;
import model.Crediario;
import org.hibernate.Session;

/**
 *
 * @author deibi
 */
public class CrediarioDao implements CrediarioInterface {

    @Override
    public void saveCrediario(Crediario c) {
        if (c != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.saveOrUpdate(c);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public Crediario getCrediarioByConta(Conta c) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<Crediario> query = session.createQuery("SELECT c from Crediario c WHERE c.conta.id = :id")
                    .setParameter("id", c.getId());
            Crediario crediario = query.getSingleResult();
            session.getTransaction().commit();
            return crediario;
        }
    }

    @Override
    public void delete(long id) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Crediario c = session.find(Crediario.class, id);
            session.remove(c);
            session.getTransaction().commit();
        }

    }

    @Override
    public void deleteCrediarioByContaId(long id) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Crediario crediario = (Crediario) session.createQuery("SELECT c FROM Crediario c WHERE c.conta.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            crediario.getPagamentos().clear();
            session.remove(crediario);

            session.getTransaction().commit();
        }
    }

    @Override
    public Crediario getCrediarioById(long id) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<Crediario> query = session.createQuery("SELECT c from Crediario c JOIN FETCH c.cliente WHERE c.id = :id").setParameter("id", id);
            Crediario crediario = query.getSingleResult();
            session.getTransaction().commit();
            return crediario;
        }
    }

}
