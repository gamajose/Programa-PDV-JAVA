/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import Utilitarios.HibernateUtil;
import java.util.List;
import model.Pagamento;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author deibi
 */
public class PagamentosDao {

    public List<Pagamento> pagamentos(String cpf) {

        List<Pagamento> pgto;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT p FROM Pagamento p  WHERE p.cliente.cpf = :cpf");//ORDER BY p.dataPgto DESC
            query.setParameter("cpf", cpf);
            pgto = query.getResultList();
            session.getTransaction().commit();
        }
        return pgto;
    }

    public void savePgto(Pagamento c) {
        if (c != null) {
            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.saveOrUpdate(c);
                session.getTransaction().commit();
            }
        }
    }

}
