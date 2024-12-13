package repositorio;

import Interfaces.LancamentoInterface;
import Utilitarios.HibernateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Lancamento;
import org.hibernate.Session;

/**
 *
 * @author Deibidson Mesquita
 */
public class LancamentoDao implements LancamentoInterface {

    @Override
    public List<Lancamento> listaLancamentos() {
        List<Lancamento> lista = new ArrayList<>();
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            lista = session.createQuery("SELECT c FROM Lancamento c JOIN FETCH c.caixa", Lancamento.class).getResultList();
            session.getTransaction().commit();
        }
        return Collections.unmodifiableList(lista);

    }

    @Override
    public BigDecimal totalEntradas() {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<BigDecimal> total = session.createQuery("SELECT SUM(v.valor) as v FROM Lancamento v WHERE v.tipo = 'ENTRADA'");
        BigDecimal v = total.getSingleResult();
        if (v == null) {
            v = new BigDecimal(0);
        }
        session.getTransaction().commit();;
        session.close();
        return v;
    }

    @Override
    public BigDecimal totalSaidas() {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<BigDecimal> total = session.createQuery("SELECT SUM(v.valor) as v FROM Lancamento v WHERE v.tipo = 'SAIDA'");
        BigDecimal v = total.getSingleResult();

        if (v == null) {
            v = new BigDecimal(0);
        }

        session.getTransaction().commit();;
        session.close();
        return v;
    }

    @Override
    public BigDecimal total() {
        return totalEntradas().subtract(totalSaidas());
    }

    @Override
    public BigDecimal saldoAnterior(LocalDate date) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();

        TypedQuery<BigDecimal> totale = session
                .createQuery("SELECT SUM(v.valor) FROM Lancamento v  WHERE v.data < :datae AND v.tipo = 'ENTRADA' ");
        totale.setParameter("datae", date);

        BigDecimal vle = BigDecimal.ZERO;
        if (totale.getSingleResult() != null) {
            vle = totale.getSingleResult();
        }

        TypedQuery<BigDecimal> totals = session
                .createQuery("SELECT SUM(v.valor) FROM Lancamento v  WHERE v.data < :datas AND v.tipo = 'SAIDA'");
        totals.setParameter("datas", date);

        BigDecimal vls = BigDecimal.ZERO;
        if (totals.getSingleResult() != null) {
            vls = totals.getSingleResult();
        }

        session.getTransaction().commit();
        session.close();

        return vle.subtract(vls);

    }

    @Override
    public List<Lancamento> listaLancamentosByDate(LocalDate localDate) {
        List<Lancamento> lista = new ArrayList<>();
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            TypedQuery<Lancamento> typed = session.createQuery("SELECT c FROM Lancamento c JOIN FETCH c.caixa WHERE c.data = :data ORDER BY c.hora ASC", Lancamento.class);
            typed.setParameter("data", localDate);
            lista = typed.getResultList();
            session.getTransaction().commit();
        }

        return Collections.unmodifiableList(lista);

    }

    @Override
    public BigDecimal totalEntradasPorData(LocalDate l) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<BigDecimal> total = session.createQuery("SELECT SUM(v.valor) as v FROM Lancamento v WHERE v.tipo = 'ENTRADA' AND v.data = :data");
        total.setParameter("data", l);
        BigDecimal v = total.getSingleResult();
        if (v == null) {
            v = new BigDecimal(0);
        }
        session.getTransaction().commit();;
        session.close();

        // System.out.println("valor total de entradas para date selecionada " + v);
        return v;
    }

    @Override
    public BigDecimal totalSaidasPorData(LocalDate l) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<BigDecimal> total = session.createQuery("SELECT SUM(v.valor) as v FROM Lancamento v WHERE v.tipo = 'SAIDA' AND v.data = :data");
        total.setParameter("data", l);
        BigDecimal v = total.getSingleResult();
        if (v == null) {
            v = new BigDecimal(0);
        }
        session.getTransaction().commit();;
        session.close();

        //    System.out.println("valor total de saids para date selecionada " + v);
        return v;
    }

    @Override
    public void salva(Lancamento l) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(l);
        session.getTransaction().commit();;
        session.close();
    }

    @Override
    public void deletaLancamentoVendaCancelada(String vendaDesc, BigDecimal valor) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("DELETE FROM lancamento WHERE descr = '" + vendaDesc + "' AND valor = " + valor + "")
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
        //   System.out.println("executou a exclusão do lançamento da venda cancelada.");
    }

    @Override
    public void deletaLancamento(long id) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {

            session.beginTransaction();
            session.createSQLQuery("DELETE FROM lancamento WHERE id = " + id)
                    .executeUpdate();
            session.getTransaction().commit();

        }
    }

    @Override
    public Lancamento getLancamento(long id) {
        Lancamento l;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            l = session.get(Lancamento.class, id);
            session.getTransaction().commit();
        }
        return l;
    }

}
