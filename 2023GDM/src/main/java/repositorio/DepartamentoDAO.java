/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Utilitarios.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.swing.JOptionPane;
import model.Cargo;
import model.Departamento;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class DepartamentoDAO {

    static List<Departamento> departamentos = new ArrayList<>();

    public void deletedp(long id) {
        Departamento dep;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            dep = session.get(Departamento.class, id);
            session.remove(dep);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Não é possivel excluir Departamento.\n"
                    + "Existe(m) funcionário(s) cadastrados no departamento", "Erro", 0);
        }

    }

    public static Departamento departamentoPorNome(String nome) {
        Departamento dep;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Departamento d WHERE d.nome = :nome ", Departamento.class);
            query.setParameter("nome", nome);
            dep = (Departamento) query.getSingleResult();
            session.getTransaction().commit();
        } catch (NoResultException | NonUniqueResultException e) {
            dep = new Departamento(nome, null);
        }
        return dep;
    }

    public static List<Departamento> listaDepartamentos() {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            departamentos = session.createQuery("from Departamento d", Departamento.class).list();
            session.getTransaction().commit();
        }
        return departamentos;
    }

    public static List<Cargo> cargosPordepartamento(String dep) {
        List<Cargo> depcargos;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Cargo c WHERE c.departamento.nome = :id", Cargo.class);
            query.setParameter("id", dep);
            depcargos = (List<Cargo>) query.list();
            session.getTransaction().commit();

            return depcargos;
        }
    }
}
