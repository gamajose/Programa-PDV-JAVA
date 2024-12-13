package repositorio;

import Interfaces.ProdutoInterface;
import Utilitarios.HibernateUtil;
import java.util.List;
import model.Produto;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class ProdutoDao implements ProdutoInterface {

    @Override
    public List<Produto> listaProdutos() {
        List<Produto> listagemProdutos;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {

            session.beginTransaction();
            listagemProdutos = session.createQuery("SELECT p from Produto p JOIN FETCH p.estoque JOIN FETCH p.fornecedor", Produto.class).getResultList();
            session.getTransaction().commit();
        }

        return listagemProdutos;

    }

    @Override
    public void deleteProduto(long p) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Produto pr = session.find(Produto.class, p);

            session.remove(pr.getEstoque());
            session.getTransaction().commit();
        }
    }

    @Override
    public Produto produtoByCodigo(long codigo) {
        Produto produto;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Produto> query = session.createQuery("SELECT p FROM Produto p JOIN FETCH p.fornecedor JOIN FETCH p.categoria WHERE p.codigo = :code ");
            query.setParameter("code", codigo);
            produto = query.uniqueResult();
            session.getTransaction().commit();
        }

        return produto;
    }

    @Override
    public void atualizarProduto(Produto p) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        Produto pr = (Produto) session.merge(p);
        session.update(pr);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void cadastra(Produto p) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.persist(p);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Produto produtoByCodigoBarras(String codigobar) {
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        Query<Produto> query = session.createQuery("SELECt p FROM Produto p JOIN FETCH p.estoque JOIN FETCH p.categoria WHERE p.codigoBarras = :code OR p.codigo = :code ");
        query.setParameter("code", codigobar);

        Produto p = query.uniqueResult();
        session.getTransaction().commit();
        session.close();

        return p;
    }

    @Override
    public void alteraStatus(long codigo, String status) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Produto p = session.find(Produto.class, codigo);
            p.getEstoque().setStatus(status);
            session.saveOrUpdate(p);
            session.getTransaction().commit();
        }
    }

}
