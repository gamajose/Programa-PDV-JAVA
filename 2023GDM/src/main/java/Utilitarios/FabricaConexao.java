package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FabricaConexao {

    private static Connection con;
    private PreparedStatement psl;

    public static Connection getConexao() {

        //HSQLDB
        String path = System.getProperty("user.dir") + "\\GDM\\HSQLDB\\gdmData";
        if (con == null) {
            try {

                //HSQLDB
                Class.forName("org.hsqldb.jdbcDriver");
                con = DriverManager.getConnection("jdbc:hsqldb:file:" + path + "", "gdm", "gdm");
                System.out.println("conexão com banco de dados ok ");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro na conexão com banco de dados: " + ex.getMessage());
            }
        }
        return con;
    }

}
