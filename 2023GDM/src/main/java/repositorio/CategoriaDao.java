package repositorio;

import Utilitarios.HibernateUtil;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import model.Categoria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import telas.TelaCategoria;

public class CategoriaDao {

    private static List<Categoria> listaDeCategorias = new ArrayList<>();

    public static boolean verificaSeExistiCategoriaCadastrada() {
        boolean rsp = false;

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);

            query.select(builder.count(query.from(Categoria.class)));
            TypedQuery<Long> typedQuery = session.createQuery(query);

            if (typedQuery.getSingleResult() != 0) {
                rsp = true;
            }

            session.getTransaction().commit();
        }

        return rsp;
    }

    public static List<Categoria> getAllCategorias() {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            listaDeCategorias = session.createQuery("FROM Categoria c", Categoria.class).list();
            session.getTransaction().commit();
        }
        return Collections.unmodifiableList(listaDeCategorias);
    }

    public static void salvaCategoria(Categoria c) {
        try (Session s = HibernateUtil.getHibernateSessionFactory().openSession()) {
            s.beginTransaction();
            s.persist(c);
            s.getTransaction().commit();
            TelaCategoria.txterro.setText("Categoria adicionada");
            TelaCategoria.txterro.setForeground(Color.BLUE);
        } catch (PersistenceException e) {
            TelaCategoria.txterro.setText("Categoria Já Existe.");
        }

    }

    public static Categoria categoriaByNome(String nome) {
        Categoria c;
        try (Session s = HibernateUtil.getHibernateSessionFactory().openSession()) {
            s.beginTransaction();
            Query q = s.createQuery("FROM Categoria c WHERE c.nome = :nome", Categoria.class);
            q.setParameter("nome", nome);
            c = (Categoria) q.getSingleResult();
            s.getTransaction().commit();
        } catch (NoResultException e) {
            return null;
        }
        return c;
    }

    public static void deleteCategoria(Categoria c) {
        try (Session s = HibernateUtil.getHibernateSessionFactory().openSession()) {
            s.beginTransaction();
            s.delete(c);
            s.getTransaction().commit();
        }
    }

}
