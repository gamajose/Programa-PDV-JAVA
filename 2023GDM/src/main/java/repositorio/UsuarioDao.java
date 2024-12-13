package repositorio;

import Interfaces.UsuarioInterface;
import Utilitarios.HibernateUtil;
import java.util.List;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class UsuarioDao implements UsuarioInterface {

    @Override
    public void salvaUser(Usuario u) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(u);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Usuario u) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(u);
            session.getTransaction().commit();
        }
    }

    @Override
    public Usuario getUsuario(String senha, String login) {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Usuario> query = session.createQuery("FROM Usuario u WHERE  u.usuario = :login AND u.senha = :senha ");
            query.setParameter("login", login);
            query.setParameter("senha", senha);
            Usuario u = query.uniqueResult();
            session.getTransaction().commit();
            return u;
        }

    }

    @Override
    public List<Usuario> listaUsuarios() {
        List<Usuario> lista;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            lista = session.createQuery("SELECT u FROM Usuario u LEFT JOIN u.funcionario f", Usuario.class).getResultList();
            session.getTransaction().commit();
            return lista;
        }
    }

    @Override
    public Usuario getByCodigo(long id) {
        Usuario u = null;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Usuario> query = session.createQuery("FROM Usuario u WHERE u.id = :id");
            query.setParameter("id", id);

            u = query.uniqueResult();
            session.getTransaction().commit();

        }
        return u;
    }

    @Override
    public void atualiza(Usuario u) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(u);
            session.getTransaction().commit();
        }
    }

    public boolean verificaUsuarioEstaBloqueado(String user) {
        boolean permissao = false;

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Usuario> query = session.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :user");
            query.setParameter("user", user);

            if (query.uniqueResult() != null) {
                if (query.uniqueResult().getNivelAcesso().equals("Bloqueado")) {
                    permissao = true;
                }
            }

            session.getTransaction().commit();
            return permissao;
        }

    }

    @Override
    public boolean verificaPermissao(String user) {
        boolean permissao = false;

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Usuario> query = session.createQuery("SELECT u FROM Usuario u WHERE LOWER(u.usuario) = :user OR UPPER(u.usuario) = :user");
            query.setParameter("user", user);

            if (query.uniqueResult().getNivelAcesso().equals("Administrador")) {
                permissao = true;
            }

            session.getTransaction().commit();
            return permissao;
        }

    }

}
