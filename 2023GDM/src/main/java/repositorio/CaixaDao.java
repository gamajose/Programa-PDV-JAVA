/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Interfaces.CaixaInterface;
import Utilitarios.HibernateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Caixa;
import model.CaixaDiario;
import model.Lancamento;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class CaixaDao implements CaixaInterface {

    private List<BigDecimal> lancamentosValores = new ArrayList<>();

    @Override
    public void salvaCaixa(Caixa c) {
        if (c != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.saveOrUpdate(c);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public BigDecimal calcularSaldoDiario() {
        BigDecimal entradasTotais;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            List<Lancamento> all = session.createQuery("SELECT l FROM Lancamento l", Lancamento.class).getResultList();
            all.forEach((object) -> {
                lancamentosValores.add(object.getValor());

            });
            entradasTotais = lancamentosValores.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            session.getTransaction().commit();
        }

        return entradasTotais.subtract(entradasTotais);
    }

    @Override
    public void deleteCaixa(Caixa cx) {
        if (cx != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.remove(cx);
                session.getTransaction().commit();
            }
        }
    }

    public Caixa getCaixaByNome(String nome) {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<Caixa> typedQuery = session.createQuery("SELECT c FROM Caixa c WHERE c.descr = :nome", Caixa.class);
            typedQuery.setParameter("nome", nome);
            Caixa c = typedQuery.getSingleResult();
            session.getTransaction().commit();
            session.close();
            return c;
        }

    }

    public Caixa getCaixaByDataAbertura(LocalDate date) {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            TypedQuery<Caixa> typedQuery = session.createQuery("SELECT c FROM Caixa c WHERE c.dtabertura = :date", Caixa.class);
            typedQuery.setParameter("date", date);

            Caixa c = typedQuery.setMaxResults(1).getSingleResult();

            session.getTransaction().commit();
            session.close();
            return c;
        }

    }

    @Override
    public List<Caixa> listaCaixa() {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<Caixa> typedQuery = session.createQuery("FROM Caixa c  ", Caixa.class);
            List<Caixa> caixas = typedQuery.getResultList();
            session.getTransaction().commit();
            session.close();
            return caixas;
        }

    }

    @Override
    public List<CaixaDiario> listaCaixaDiario() {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<CaixaDiario> typedQuery = session.createQuery("FROM CaixaDiario c  ", CaixaDiario.class);
            List<CaixaDiario> caixas = typedQuery.getResultList();
            session.getTransaction().commit();
            session.close();
            return caixas;
        }

    }

    @Override
    public Caixa getCaixaPoCodigo(Long codigo) {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Caixa cx = session.get(Caixa.class, codigo);
            session.getTransaction().commit();
            session.close();
            return cx;
        }

    }

    @Override
    public String getStatusCaixa(Caixa c) {
        String status = "";
        if (c != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                Caixa cx = session.find(Caixa.class, c);
                status = cx.getStatus();
                session.getTransaction().commit();
            }
        }
        return status;
    }

    @Override
    public Caixa getCaixaPorStatusAberto() {
        Caixa cx = null;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            cx = session.createQuery("SELECT c FROM Caixa c WHERE c.status = 'ABERTO'", Caixa.class)
                    .setMaxResults(1)
                    .uniqueResult();

            session.getTransaction().commit();
        }
        return cx;
    }

    @Override
    public void abrirCaixa(Caixa cx) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(cx);
            session.getTransaction().commit();
        }
    }

    @Override
    public void fecharCaixa(Caixa cx) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Caixa c = session.load(Caixa.class, cx.getId());
            c.setStatus("FECHADO");
            session.update(c);
            session.getTransaction().commit();
        }
    }

    @Override
    public void salvaCaixaDiario(CaixaDiario cxd) {
        if (cxd != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.saveOrUpdate(cxd);
                session.getTransaction().commit();
            }
        }
    }

    public void resetCaixa() {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query typedQuery = session.createQuery("delete FROM Lancamento ");
            typedQuery.executeUpdate();
            session.getTransaction().commit();

        }

    }

}
