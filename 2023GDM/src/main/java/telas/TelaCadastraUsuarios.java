/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import repositorio.UsuarioDao;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaCadastraUsuarios extends javax.swing.JFrame {

    private static final long serialVersionUID = 475890509151938939L;

    /**
     * Creates new form TelaTrocaUsuarios
     */
    public TelaCadastraUsuarios() {
        initComponents();
        mostarUsuarios();
        btnatualizar.setEnabled(false);

    }

    public Image icone() {
        return new ImageIcon(getClass().getResource("/imagens/icons8-grupos-de-usuários-24.png")).getImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnatualizar = new javax.swing.JButton();
        txtuser = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnivel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Usuários");
        setAlwaysOnTop(true);
        setIconImage(icone());

        btnatualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sincronizar-24.png"))); // NOI18N
        btnatualizar.setText("Atualizar");
        btnatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Senha:");

        jLabel2.setText("Usuário:");

        txtnivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limitado", "Administrador", "Bloqueado" }));

        jLabel4.setText("Nivél de Acesso:");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nivél", "Login", "Senha", "Vendedor"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(1).setMinWidth(100);
            tabela.getColumnModel().getColumn(2).setMinWidth(140);
            tabela.getColumnModel().getColumn(3).setMinWidth(80);
            tabela.getColumnModel().getColumn(4).setMinWidth(100);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Trocar Usuário logado"));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-atualizações-disponíveis-24.png"))); // NOI18N
        jButton2.setText("Logar com outro Usuário");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Novo Funcionário com Usuário");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtid.setEditable(false);

        jLabel3.setText("ID:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lixo-24.png"))); // NOI18N
        jButton3.setText("Excluir Usuário");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton5.setText("Cadastrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtuser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtsenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnatualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnivel, 0, 0, Short.MAX_VALUE)
                            .addComponent(txtid)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtnivel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(8, 8, 8))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizarActionPerformed
        if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
            if (txtsenha.getPassword().length != 0 && !txtuser.getText().isEmpty()) {
                Usuario u = new Usuario();
                u.setId(Long.parseLong(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
                u.setUsuario(txtuser.getText());
                u.setSenha(new String(txtsenha.getPassword()));
                u.setNivelAcesso(txtnivel.getSelectedItem().toString());
                new UsuarioDao().atualiza(u);
                mostarUsuarios();
            } else {
                JOptionPane.showMessageDialog(tabela, "Preencha todos os campos.", "", 0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
        }
    }//GEN-LAST:event_btnatualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaLogin lg = new TelaLogin();
        TelaLogin.logoff = true;
        lg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lg.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaCadastroVendedor tv = new TelaCadastroVendedor();
        TelaMasterApp.getDisplay().add(tv);
        tv.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        txtuser.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtid.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtsenha.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        txtnivel.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        btnatualizar.setEnabled(true);

    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
            long id = Long.parseLong(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            new UsuarioDao().delete(new Usuario(id));
            mostarUsuarios();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Usuario u = new Usuario();
        u.setFuncionario(null);
        u.setUsuario(txtuser.getText());
        u.setSenha(new String(txtsenha.getPassword()));
        u.setNivelAcesso(txtnivel.getSelectedItem().toString());

        new UsuarioDao().salvaUser(u);
        mostarUsuarios();
        btnatualizar.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void mostarUsuarios() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        UsuarioDao u = new UsuarioDao();

        Object[] dados = new Object[5];

        u.listaUsuarios().forEach((p) -> {
            dados[0] = p.getId();
            dados[2] = p.getUsuario();
            dados[3] = p.getSenha();
            dados[1] = p.getNivelAcesso();

            if (p.getFuncionario() != null) {
                dados[4] = p.getFuncionario().getId();
            } else {
                dados[4] = "0";
            }
            modelo.addRow(dados);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatualizar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabela;
    private javax.swing.JTextField txtid;
    private javax.swing.JComboBox<String> txtnivel;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
