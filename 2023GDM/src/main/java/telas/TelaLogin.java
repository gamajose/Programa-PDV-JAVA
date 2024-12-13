package telas;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import model.Usuario;
import repositorio.UsuarioDao;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaLogin extends javax.swing.JFrame {

    private static final long serialVersionUID = 8728881339819621625L;
    public static boolean logoff = false;

    
    public TelaLogin() {
        initComponents();
        setDefaultLookAndFeelDecorated(true);
        Border line = BorderFactory.createEmptyBorder();
        Border empty = new EmptyBorder(0, 10, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);
        txtlogin.setBorder(border);
        txtpasword.setBorder(border);
    }

    public Image icone() {
        return new ImageIcon(getClass().getResource("/imagens/ico_main.png")).getImage();
    }

    public void login() {
        if (new UsuarioDao().verificaUsuarioEstaBloqueado(txtlogin.getText()) == true) {
            JOptionPane.showMessageDialog(rootPane, "Usuario informado esta BLOQUEADO", "Sem Permissão", 0);
        } else {
            UsuarioDao vd = new UsuarioDao();
            Usuario v = vd.getUsuario(new String(txtpasword.getPassword()), txtlogin.getText().trim());

            if (logoff == false) {
                if (!txtlogin.getText().equals("") && txtpasword.getPassword().length > 0) {

                    jProgressBar1.setIndeterminate(true);

                    if (new String(txtpasword.getPassword()).equals("0001") && txtlogin.getText().trim().equals("admin")) {
                        TelaMasterApp main = new TelaMasterApp();
                        main.setVisible(true);
                        TelaMasterApp.txtinfoUser.setText("o usuario inválido cadastre um funcionário com login e senha");
                        this.setVisible(false);
                       
                        JOptionPane.showMessageDialog(rootPane, "Para o bom funcionamento do sistema cadastre um funcionário com dados de  login e senha");
                        TelaCadastroVendedor tv = new TelaCadastroVendedor();
                       
                        TelaMasterApp.getDisplay().add(tv);
                        tv.setVisible(true);

                    } else {

                        try {

                            if (v.getSenha().equals(new String(txtpasword.getPassword())) && v.getUsuario().equals(txtlogin.getText().trim())) {
                                TelaMasterApp main = new TelaMasterApp();
                                main.setVisible(true);
                                if (v.getFuncionario() != null) {
                                    TelaMasterApp.txtinfoUser.setText(v.getFuncionario().getNome());
                                } else {
                                    TelaMasterApp.txtinfoUser.setText(v.getUsuario());
                                }
                                TelaMasterApp.txtinfoUserId.setText(v.getId().toString());
                                this.setVisible(false);
                                TelaMasterApp.txt_ativacao.setText("Licença " + (365 - verificacaoValidadeDoSistema()) + " dia(s) restante(s)");
                            }

                            jProgressBar1.setIndeterminate(false);
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(rootPane, "Usuário ou senha incorreto", "Login inválido verifique", 0);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Digite seu nome de usuário e senha", "Login inválido", 0);
                }

            } else if (logoff == true) {
                if (!txtlogin.getText().equals("") && txtpasword.getPassword().length > 0) {
                    jProgressBar1.setIndeterminate(true);

                    if (v != null && v.getSenha().equals(new String(txtpasword.getPassword())) && v.getUsuario().equals(txtlogin.getText().trim())) {
                        if (v.getFuncionario() != null) {
                            TelaMasterApp.txtinfoUser.setText(v.getFuncionario().getNome());
                        } else {
                            TelaMasterApp.txtinfoUser.setText(v.getUsuario());
                        }
                        TelaMasterApp.txtinfoUserId.setText(v.getId().toString());

                        setVisible(false);
                        JOptionPane.showMessageDialog(rootPane, "Troca de usuário realizada com sucesso", "Mudança Realizada", 2, new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-administrador-masculino-48.png")));

                        if (TelaMasterApp.getDisplay().getSelectedFrame().getTitle().equals("GDM-PDV")) {
                            TelaMasterVenda.setDadosDoOperador();
                        }

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuário ou senha incorreto", "Login inválido verifique", 0);
                    }
                    jProgressBar1.setIndeterminate(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Digite seu nome de usuário e senha", "Login inválido", 0);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g.create();
                int w = getWidth();
                int h = getHeight();

                GradientPaint gp = new GradientPaint(
                    0, 0, new Color(153, 204, 255),
                    0, h, new Color(51, 153, 255));

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);

                g2d.dispose();
            }
        };
        txtlogin = new javax.swing.JTextField();
        txtpasword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(153, 204, 255));
        setIconImage(icone());
        setMaximumSize(new java.awt.Dimension(350, 335));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        txtlogin.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtlogin.setToolTipText("");
        txtlogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtlogin.setMargin(new java.awt.Insets(6, 6, 6, 6));
        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });

        txtpasword.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtpasword.setToolTipText("");
        txtpasword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtpasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaswordActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 129, 253));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Entrar");
        jButton1.setBorderPainted(false);
        jButton1.setMaximumSize(new java.awt.Dimension(350, 335));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-esqueci-a-senha-96.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setForeground(new java.awt.Color(153, 204, 255));
        jLabel4.setText("GDM SISTEMAS");

        jProgressBar1.setBackground(new java.awt.Color(153, 204, 255));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jProgressBar1.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtlogin)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtpasword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 170, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(txtpasword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed
        login();        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginActionPerformed

    private void txtpaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaswordActionPerformed
        login();        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaswordActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JPasswordField txtpasword;
    // End of variables declaration//GEN-END:variables

    private static long verificacaoValidadeDoSistema() {
        LocalDateTime tempoInicial = LocalDateTime.parse("01/01/2024 07:30", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        long periodo = ChronoUnit.DAYS.between(tempoInicial, LocalDateTime.now());

      //  System.out.println(periodo);

        if (periodo >= 365) {
            JOptionPane.showMessageDialog(null, "Lincença expirada. Renove sua licença.\n\nEntre em contato:\ndeibidson@gmail.com\ndeibidsonmesquita@yahoo.com.br", "Vencido", 0);
            System.exit(0);
        } else if (LocalDateTime.now().isBefore(tempoInicial)) {

            JOptionPane.showMessageDialog(null, "Lincença expirada. A data do computador parece esta incorreta", "Vencido", 0);
            System.exit(0);
        }

        return periodo;
    }
}
