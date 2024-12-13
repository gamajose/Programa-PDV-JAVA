package com.gdm.main;

import Utilitarios.DataHora;
import com.formdev.flatlaf.FlatDarculaLaf;
import repositorio.CaixaDao;
import repositorio.UsuarioDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.BindException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UnsupportedLookAndFeelException;
import model.Caixa;
import model.Usuario;
import telas.TelaLogin;

public class Splash extends JWindow {

    private static final long serialVersionUID = 1L;

    private final int duration;

    private Splash(int d) {
        duration = d;
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();
        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setBorderPainted(false);

        content.setBackground(Color.white);
        int width = 760;
        int height = 428;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        JLabel label = new JLabel();

        label.setIcon(new ImageIcon(getClass().getResource("/imagens/splash.png")));
        content.add(label, "Center");
        content.add(progress, BorderLayout.SOUTH);

        setVisible(true);
        // --------------------------------------//--------------------------------------

        if (new UsuarioDao().listaUsuarios().isEmpty()) {
            new UsuarioDao().salvaUser(new Usuario("Administrador", "admin", "admin", null));
            //System.out.println("usuario padrao admin criado");
        }

        //CRIAÇÃO E ABERTURA DO CAIXA PADRAO
        CaixaDao cx = new CaixaDao();
        if (cx.listaCaixa().isEmpty()) {
            Caixa c = new Caixa();
            c.setDescr("MASTER-CX");
            c.setStatus("FECHADO");
            c.setValorAbertura(BigDecimal.ZERO);
            c.setValorFecamento(BigDecimal.ZERO);
            c.setDtabertura(LocalDate.parse(new DataHora().ler_Data(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            c.setDtfechamento(LocalDate.parse(new DataHora().ler_Data(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cx.salvaCaixa(c);

        }

        //  -----------------------------//------------------------------------------------
        try {
            Thread.sleep(duration);

        } catch (InterruptedException e) {
        }
        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();

        System.exit(0);
    }

    public static void main(String args[]) throws IOException, SQLException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Splash splash = new Splash(0000);
        splash.showSplash();

        try {
            ////Verifica se o sistema ja esta em execução
            @SuppressWarnings("unused")
            ServerSocket socket = null;
            socket = new ServerSocket(2216);
            
            //MODO ESCURO
            FlatDarculaLaf.setup(new FlatDarculaLaf());

//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                //Windows, Metal, Nimbus
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//
//                    break;
//                }
//            }

            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);

        } catch (BindException e) {
            JOptionPane.showMessageDialog(null, "A aplicação já está em execução!");
            System.exit(0);

        }

        TelaLogin main = new TelaLogin();
        main.setVisible(true);

    }

}
