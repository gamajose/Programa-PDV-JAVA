package Utilitarios;

import java.util.logging.Level;
import model.Caixa;
import model.CaixaDiario;
import model.Cargo;
import model.CartaoLancamento;
import model.Categoria;
import model.Cheque;
import model.Cliente;
import model.Conta;
import model.Contato;
import model.Crediario;
import model.Departamento;
import model.Empresa;
import model.Endereco;
import model.Estoque;
import model.Fornecedor;
import model.ItemPedido;
import model.ItemVenda;
import model.Lancamento;
import model.Pagamento;
import model.Pedido;
import model.Produto;
import model.Usuario;
import model.Venda;
import model.Vendedor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    //hsqldb
    final static String path = System.getProperty("user.dir") + "\\GDM\\HSQLDB\\gdmData";

    static {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Configuration configuration = new Configuration();

        //HSQLDB
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:" + path + "");
        configuration.setProperty("hibernate.connection.username", "gdm");
        configuration.setProperty("hibernate.connection.password", "gdm");
        configuration.setProperty("hibernate.connection.pool_size", "10");
        configuration.setProperty("hibernate.generate_statistics", "false");

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().applySettings(configuration.getProperties())
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .addPackage("model")
                    .addAnnotatedClass(Estoque.class)
                    .addAnnotatedClass(Pedido.class)
                    .addAnnotatedClass(Produto.class)
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(Vendedor.class)
                    .addAnnotatedClass(Fornecedor.class)
                    .addAnnotatedClass(Endereco.class)
                    .addAnnotatedClass(Empresa.class)
                    .addAnnotatedClass(Departamento.class)
                    .addAnnotatedClass(ItemPedido.class)
                    .addAnnotatedClass(Cargo.class)
                    .addAnnotatedClass(ItemVenda.class)
                    .addAnnotatedClass(Venda.class)
                    .addAnnotatedClass(Contato.class)
                    .addAnnotatedClass(Caixa.class)
                    .addAnnotatedClass(Lancamento.class)
                    .addAnnotatedClass(Usuario.class)
                    .addAnnotatedClass(CartaoLancamento.class)
                    .addAnnotatedClass(CaixaDiario.class)
                    .addAnnotatedClass(Conta.class)
                    .addAnnotatedClass(Crediario.class)
                    .addAnnotatedClass(Pagamento.class)
                    .addAnnotatedClass(Cheque.class)
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getHibernateSessionFactory() {
        return sessionFactory;
    }
}
