/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Interfaces.ContaInt;
import Utilitarios.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import model.Conta;
import org.hibernate.Session;
import telas.LancamentoContas;

/**
 *
 * @author deibi
 */
public class ContaDao implements ContaInt {

    @Override
    public void salva(Conta c) {
        if (c != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.saveOrUpdate(c);
                session.getTransaction().commit();
            } catch (PersistenceException e) {
                LancamentoContas.txtmsn.setText("Atenção - o Numero de documento ja esta cadastrado");
            }
        }
    }

    @Override
    public List<Conta> listaReceber() {
        List<Conta> contasAReceber = null;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<Conta> query = session.createQuery("From Conta c WHERE c.tipo = :tipo").setParameter("tipo", "RECEBER");
            contasAReceber = query.getResultList();
            session.getTransaction().commit();
        }
        return contasAReceber;
    }

    @Override
    public List<Conta> listaRPagar() {

        List<Conta> contasAPAGAR = null;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<Conta> query = session.createQuery("From Conta c WHERE c.tipo = :tipo").setParameter("tipo", "PAGAR");
            contasAPAGAR = query.getResultList();
            session.getTransaction().commit();
        }
        return contasAPAGAR;
    }

    @Override
    public void quitaConta(Conta c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletaConta(Long id) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Conta c = session.find(Conta.class, id);
            session.remove(c);
            session.getTransaction().commit();
        }

    }

    @Override
    public Conta getContaById(long id) {
        Conta c;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            c = session.find(Conta.class, id);
            session.getTransaction().commit();
        }
        return c;
    }

    @Override
    public BigDecimal getTotalReceber() {
        BigDecimal total = BigDecimal.ZERO;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<BigDecimal> query = session.createQuery("SELECT sum(valor) as total FROM Conta c WHERE c.status = :tipo")
                    .setParameter("tipo", " A RECEBER ");

            if (query.getSingleResult() != null) {
                total = query.getSingleResult();
            }

            session.getTransaction().commit();
        }
        return total;
    }

    @Override
    public BigDecimal getTotalPagar() {
        BigDecimal total = BigDecimal.ZERO;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<BigDecimal> query = session.createQuery("SELECT sum(valor) as total FROM Conta c WHERE c.status = :tipo")
                    .setParameter("tipo", " A PAGAR ");

            if (query.getSingleResult() != null) {
                total = query.getSingleResult();
            }

            session.getTransaction().commit();
        }
        return total;
    }

}
