package repositorio;

import Interfaces.EstoqueInterface;
import Utilitarios.HibernateUtil;
import model.Estoque;
import model.Produto;
import org.hibernate.Session;

/**
 * @author Deibidson Mesquita
 */
public class EstoqueDao implements EstoqueInterface {

    @Override
    public void saveEstoque(Estoque e) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(e);
            session.getTransaction().commit();
        }
    }

    @Override
    public void atualizarEstoque(Estoque p) {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
        }
    }

    @Override
    public Produto estoqueByCodigoProduto(long codigoProduto) {
        Produto estoque;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            estoque = (Produto) session.createQuery("SELECT e FROM Produto e INNER JOIN e.estoque p WHERE e.codigo = :codigo")
                    .setParameter("codigo", codigoProduto).getSingleResult();
            session.getTransaction().commit();
        }
        return estoque;
    }

    @Override
    public Produto estoqueByNomeProduto(String nomeproduto) {
        Produto estoque;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            estoque = (Produto) session.createQuery("SELECT p FROM Produto p JOIN FETCH p.estoque WHERE p.descricao = :desc")
                    .setParameter("desc", nomeproduto).getSingleResult();
            session.getTransaction().commit();
        }
        return estoque;
    }

    @Override
    public void delete(long ide) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Estoque e = session.get(Estoque.class, ide);
            e.getProdutos().remove(0);
            //  session.remove(e);
            session.getTransaction().commit();
        }
    }

}
