/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import repositorio.VendedorDao;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Vendedor;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaFuncionariosCadastrados extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 768035637676078448L;

    private TelaCadastroVendedor telaCadastroVendedor;

    public TelaFuncionariosCadastrados() {
        initComponents();
        mostrarVendedores();
    }

    public static void mostrarVendedores() {

        DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionario.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        VendedorDao pDao = new VendedorDao();
        for (Vendedor p : pDao.listaVendedores()) {

            Object[] dados = new Object[8];

            dados[0] = String.valueOf(p.getId());
            dados[1] = p.getNome().toUpperCase();
            dados[2] = p.getCpf().toUpperCase();
            dados[3] = p.getAdmissao();
            dados[4] = p.getCelular().toUpperCase();
            dados[5] = p.getEmail().toUpperCase();
            dados[6] = p.getStatus().toUpperCase();
            dados[7] = p.getSexo().toUpperCase();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhum Vendedor Cadastrado.";

            modelo.addRow(dados);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        busca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("Funcionários");

        tabelaFuncionario.setFont(new java.awt.Font("Noto Mono", 0, 11)); // NOI18N
        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CPF", "Admissão", "Celular", "E-mail", "Status", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionario.setGridColor(new java.awt.Color(243, 255, 255));
        tabelaFuncionario.setRowHeight(20);
        tabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionario);
        if (tabelaFuncionario.getColumnModel().getColumnCount() > 0) {
            tabelaFuncionario.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelaFuncionario.getColumnModel().getColumn(1).setMinWidth(250);
            tabelaFuncionario.getColumnModel().getColumn(5).setMinWidth(200);
            tabelaFuncionario.getColumnModel().getColumn(6).setMaxWidth(100);
            tabelaFuncionario.getColumnModel().getColumn(7).setMinWidth(100);
            tabelaFuncionario.getColumnModel().getColumn(7).setMaxWidth(110);
        }

        busca.setBackground(new java.awt.Color(255, 255, 204));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton1.setText("Novo ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        btndelete.setText("Excluir Cadastro");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1)
                .addGap(3, 3, 3))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                .addComponent(btndelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(btndelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (telaCadastroVendedor == null) {
                telaCadastroVendedor = new TelaCadastroVendedor();
                TelaMasterApp.getDisplay().add(telaCadastroVendedor);
            }
            telaCadastroVendedor.setVisible(true);

            Dimension desktopSize = TelaMasterApp.getDisplay().getSize();
            Dimension screenSize = telaCadastroVendedor.getSize();
            telaCadastroVendedor.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            telaCadastroVendedor.setSelected(true);

        } catch (PropertyVetoException ex) {
        } finally {
            telaCadastroVendedor.limparFormulario();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelaFuncionario.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelaFuncionario.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void tabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionarioMouseClicked
        int linha = tabelaFuncionario.getSelectedRow();
        int id = Integer.parseInt(tabelaFuncionario.getValueAt(linha, 0).toString());
        btndelete.setEnabled(true);

        if (evt.getClickCount() == 2) {
            VendedorDao vd = new VendedorDao();

            try {
                if (telaCadastroVendedor == null) {
                    telaCadastroVendedor = new TelaCadastroVendedor();
                    TelaMasterApp.getDisplay().add(telaCadastroVendedor);
                    telaCadastroVendedor.preparaFormParaEdicao(vd.vendedorByCodigo(id).get());

                }
                telaCadastroVendedor.setVisible(true);

                telaCadastroVendedor.preparaFormParaEdicao(vd.vendedorByCodigo(id).get());

                Dimension desktopSize = TelaMasterApp.getDisplay().getSize();
                Dimension screenSize = telaCadastroVendedor.getSize();
                telaCadastroVendedor.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
                telaCadastroVendedor.setSelected(true);

            } catch (PropertyVetoException ex) {
            } finally {
                TelaCadastroVendedor.btnRefresh.setEnabled(true);
                TelaCadastroVendedor.btnCadastrar.setEnabled(false);
            }

        }

    }//GEN-LAST:event_tabelaFuncionarioMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int linha = tabelaFuncionario.getSelectedRow();
        if (linha != -1) {
            long id = Integer.parseInt(tabelaFuncionario.getValueAt(linha, 0).toString());

            Vendedor v = new Vendedor(id);

            new VendedorDao().deleteVendedor(v);
            mostrarVendedores();
            btndelete.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione algum cadastro na tabela", "Erro de Seleção", 0);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabelaFuncionario;
    // End of variables declaration//GEN-END:variables
}
