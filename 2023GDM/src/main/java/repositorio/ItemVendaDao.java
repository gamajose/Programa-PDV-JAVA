
package repositorio;

import Interfaces.ItemVendaInterface;
import Utilitarios.HibernateUtil;
import model.ItemVenda;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Deibidson Mesquita
 */
public class ItemVendaDao implements ItemVendaInterface {

    @Override
    public ItemVenda getItemPorCodigoProduto(long codigo) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<ItemVenda> query = session.createQuery("FROM ItemVenda i WHERE i.produto.codigo = :codigo");
            query.setParameter("codigo", codigo);
            session.getTransaction().commit();
            return null;
        }
    }

    @Override
    public void delete(ItemVenda it) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(it);
            session.getTransaction().commit();
        }
    }

}
