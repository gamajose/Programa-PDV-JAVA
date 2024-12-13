/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Interfaces.VendedorInterface;
import Utilitarios.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Vendedor;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class VendedorDao implements VendedorInterface {

    @Override
    public void salvaVendedor(Vendedor v) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(v);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteVendedor(Vendedor v) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Vendedor ve = session.get(Vendedor.class, v.getId());

            if (ve != null) {
                session.delete(ve);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Vendedor> listaVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        Session session = HibernateUtil.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        vendedores = session.createQuery("SELECT  v from Vendedor v JOIN FETCH v.usuario u").list();
        session.getTransaction().commit();
        session.close();

        return vendedores;
    }

    public Vendedor getVendedorPorCredeciais(String loginName) {
        Vendedor vendedor = null;
        if (!loginName.equals("")) {
            Session session = HibernateUtil.getHibernateSessionFactory().openSession();
            session.beginTransaction();
            Query<Vendedor> query = session
                    .createQuery("SELECT v from Vendedor v JOIN FETCH v.usuario WHERE v.usuario.usuario = :user");
            query.setParameter("user", loginName);

            vendedor = query.uniqueResult();
            session.getTransaction().commit();
            session.close();
        }
        return vendedor;
    }

    @Override
    public Optional<Vendedor> vendedorByCodigo(long codigo) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Vendedor> query = session
                    .createQuery("SELECT v from Vendedor v JOIN FETCH v.enderecos e JOIN FETCH v.departamento WHERE v.id = :vendor");
            query.setParameter("vendor", codigo);

            Vendedor v = query.uniqueResult();
            session.getTransaction().commit();
            return Optional.ofNullable(v);
        }
    }

}
