/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import repositorio.ClienteDao;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaClientesCadastrados extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 3177035318185377222L;
    private static List<Cliente> lista = new ArrayList<>();
    private long idDelete;

    /**
     * Creates new form TelaClientesCadastrados
     */
    public TelaClientesCadastrados() {
        initComponents();
        mostrarClientes();
    }

    public static void mostrarClientes() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        ClienteDao pDao = new ClienteDao();
        lista = pDao.listaTodosClientes();

        for (Cliente p : lista) {

            Object[] dados = new Object[10];

            dados[0] = String.valueOf(p.getId());
            dados[1] = p.getPessoaJuridica().getNomeFantasia().toUpperCase();
            dados[7] = p.getCpf().toUpperCase();
            dados[8] = p.getRg();
            dados[2] = p.getCelular().toUpperCase();
            dados[3] = p.getEmail();
            dados[5] = p.getLimiteCredito();
            dados[4] = p.getStatus();
            dados[9] = p.getPessoaJuridica().getCnpj();
            dados[6] = p.getTipo();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhum Cliente Cadastrado.";

            modelo.addRow(dados);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        busca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes Cadastrados");

        tabela.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Telefone", "E-mail", "Bloqueado", "Crédito", "Tipo", "CPF", "RG", "CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setGridColor(new java.awt.Color(243, 255, 255));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(120);
            tabela.getColumnModel().getColumn(1).setMinWidth(350);
            tabela.getColumnModel().getColumn(1).setMaxWidth(120);
            tabela.getColumnModel().getColumn(2).setMinWidth(100);
            tabela.getColumnModel().getColumn(2).setMaxWidth(120);
            tabela.getColumnModel().getColumn(3).setMinWidth(250);
            tabela.getColumnModel().getColumn(6).setMinWidth(120);
            tabela.getColumnModel().getColumn(7).setMinWidth(100);
            tabela.getColumnModel().getColumn(8).setMinWidth(100);
            tabela.getColumnModel().getColumn(9).setMinWidth(120);
        }

        busca.setBackground(new java.awt.Color(255, 255, 234));
        busca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        busca.setForeground(new java.awt.Color(153, 153, 153));
        busca.setText("Pesquisar..");
        busca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscaFocusLost(evt);
            }
        });
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete Selecionado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                            .addComponent(busca))
                        .addGap(4, 4, 4))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscaFocusGained
        busca.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_buscaFocusGained

    private void buscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscaFocusLost
        busca.setText("Pesquisar");
    }//GEN-LAST:event_buscaFocusLost

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabela.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        int row = tabela.getSelectedRow();
        idDelete = Long.parseLong(tabela.getValueAt(row, 0).toString().trim());
        if (evt.getClickCount() == 2) {
            try {
                TelaCadastroClientes tc = new TelaCadastroClientes();
                TelaMasterApp.getDisplay().add(tc);
                tc.setVisible(true);

                TelaCadastroClientes.btngrava.setEnabled(false);
                TelaCadastroClientes.btnatualiza.setEnabled(true);
                tc.setaDadosClienteSelecionado(idDelete);

                Dimension desktopSize = TelaMasterApp.getDisplay().getSize();
                Dimension screenSize = tc.getSize();
                tc.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
                tc.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaClientesCadastrados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            TelaCadastroClientes tc = new TelaCadastroClientes();
            TelaMasterApp.getDisplay().add(tc);
            tc.setVisible(true);

            Dimension desktopSize = TelaMasterApp.getDisplay().getSize();
            Dimension screenSize = tc.getSize();
            tc.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            tc.setSelected(true);
        } catch (PropertyVetoException ex) {

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            new ClienteDao().deleteCliente(new ClienteDao().clientePorCodigoParaEdicao(idDelete));
            mostrarClientes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "O cliente não pode ser excluido. Está relacionado com alguma transação no sistema", "Não é possível", 0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
