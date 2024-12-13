/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Interfaces.DadosDoSistemInterface;
import Utilitarios.HibernateUtil;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import model.Empresa;
import org.hibernate.Session;
import org.hibernate.query.Query;
import telas.TelaDadosGeralSistema;

/**
 *
 * @author Deibidson Mesquita
 */
public class EmpresaDao implements DadosDoSistemInterface {

    public String getCnpjDaEmpresa() {
        String emp = "";
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            emp = (String) session
                    .createQuery("select e.pessoaJuridica.cnpj AS cnpj from  Empresa e  ")
                    .getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "Cadastre informações sobre a empresa e tente novamente", "Uso instavél", 0);
            new TelaDadosGeralSistema(null, true).setVisible(true);

        }
        return emp;
    }

    @Override
    public Empresa dadosDaEmpresa() {
        Empresa emp = null;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            emp = (Empresa) session
                    .createQuery("from Empresa e ")
                    .getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "Cadastre informações sobre a empresa e tente novamente", "Não foi possivel", 0);

        }
        return emp;
    }

    @Override
    public void registrarEmpresa(Empresa e) {
        if (e != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.saveOrUpdate(e);
                session.getTransaction().commit();
            }
        }
    }

    public void deleteEmpresa(Empresa e) {
        if (e != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.remove(e);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public boolean verificaSeExisteCadastroEmpresa() {
        boolean resp = false;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Empresa> query = session.createQuery("from Empresa e");
            if (query.uniqueResult() != null) {
                resp = true;
            }
            session.getTransaction().commit();
        }
        return resp;
    }

}
