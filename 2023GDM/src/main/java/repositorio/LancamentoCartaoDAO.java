package repositorio;

import Interfaces.LancamentoCartaoInter;
import Utilitarios.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import model.CartaoLancamento;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LancamentoCartaoDAO implements LancamentoCartaoInter {

    private final Session SESSION = HibernateUtil
            .getHibernateSessionFactory()
            .openSession();

    @Override
    public void regitrarTrasacaoComCartao(CartaoLancamento cl) {
        SESSION.beginTransaction();
        SESSION.save(cl);
        SESSION.getTransaction().commit();
        SESSION.close();
    }

    @Override
    public List<CartaoLancamento> lancamentosCartao() {
        List<CartaoLancamento> lista;
        SESSION.beginTransaction();
        lista = SESSION.createQuery("FROM CartaoLancamento c", CartaoLancamento.class).getResultList();
        SESSION.getTransaction().commit();
        return lista;
    }

    @Override
    public CartaoLancamento mostrarCartaoCreditoLancamentoDetalhe(long id) {
        SESSION.beginTransaction();
        CartaoLancamento cl = SESSION.get(CartaoLancamento.class, id);
        SESSION.getTransaction().commit();
        SESSION.close();
        return cl;
    }

    public BigDecimal getTotalVendaCartao(String op) {
        BigDecimal total = BigDecimal.ZERO;
        SESSION.beginTransaction();
        Query query = SESSION.createQuery("select sum(cl.valor) as total from CartaoLancamento cl where cl.tipoOP = :op");
        query.setParameter("op", op);
        if (query.uniqueResult() != null) {
            total = new BigDecimal(query.list().get(0).toString());
        }
        SESSION.getTransaction().commit();
        SESSION.close();
        return total;

    }

    @Override
    public void deleteLancamentoCartaoPorVendaID(long cl) {
        SESSION.beginTransaction();
        Query query = SESSION.createQuery("delete from CartaoLancamento cl where cl.venda.id = :id");
        query.setParameter("id", cl).executeUpdate();
        SESSION.getTransaction().commit();
        SESSION.close();
    }
}
