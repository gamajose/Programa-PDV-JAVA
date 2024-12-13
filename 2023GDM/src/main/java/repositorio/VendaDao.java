package repositorio;

import Interfaces.VendaInterface;
import Utilitarios.HibernateUtil;
import java.util.List;
import model.ItemVenda;
import model.Venda;
import org.hibernate.Session;
import org.hibernate.jpa.QueryHints;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class VendaDao implements VendaInterface {

    @Override
    public void salvaVenda(Venda v) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void cancelarVenda(Venda v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteVenda(Venda v) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM ITEMVENDA WHERE VENDA_ID = " + v.getId()).executeUpdate();
            session.remove(v);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Venda> listaVendas() {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT v FROM Venda v LEFT JOIN FETCH v.crediario c ORDER BY v.id DESC ") //DISTINT//JOIN FETCH v.itensVenda
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
        List<Venda> vendas = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return vendas;
    }

    @Override
    public void adicionarItem(ItemVenda item) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(item);
            session.getTransaction().commit();
        }
    }

    public int totalDeItensVendidoPorProduto(long codigoProduto) {
        int totalvendido = 0;

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT SUM(v.qtde) as total FROM ItemVenda v WHERE v.produto.codigo = :codigo");
            query.setParameter("codigo", codigoProduto);

            if (query.uniqueResult() != null) {
                totalvendido = Integer.parseInt(String.valueOf(query.getSingleResult()));
            }

            session.getTransaction().commit();
        }
        return totalvendido;
    }

    @Override
    public List<ItemVenda> listaItens(Venda vd) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT i from ItemVenda i JOIN FETCH i.produto WHERE i.venda.id = :id");
        query.setParameter("id", vd.getId());
        List<ItemVenda> vendas = query.list();
        session.getTransaction().commit();
        session.close();
        return vendas;
    }

    @Override
    public Venda getVendaByID(long id) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        Venda v = session.get(Venda.class, id);
        session.getTransaction().commit();
        session.close();
        return v;
    }

    @Override
    public long getNumeroProximaVendaCupom() {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Long proxId;
            Query query = session.createQuery("SELECT max(p.id) as maximo From Venda p", Long.class);
            if (query.uniqueResult() == null) {
                proxId = 1L;
            } else {
                proxId = (Long) query.uniqueResult() + 1;
            }
            session.getTransaction().commit();
            return proxId;
        }
    }

}
