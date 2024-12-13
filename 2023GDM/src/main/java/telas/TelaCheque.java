/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Utilitarios.FormaPagamento;
import repositorio.VendaDao;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import model.Venda;

/**
 *
 * @author deibi
 */
public class TelaCheque extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 5353527524482366292L;

    /**
     * Creates new form TelaCheque
     */
    public TelaCheque() {
        initComponents();
        mostraChequesRecebidos();
    }

    private void mostraChequesRecebidos() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        List<Venda> vendas = new VendaDao().listaVendas();
        int sequence = 1;

        NumberFormat format = NumberFormat.getCurrencyInstance();
        Object[] oneRow = new Object[6];

        for (Venda o : vendas.stream()
                .filter(v -> v.getFormaPagamento() == FormaPagamento.CHEQUE)
                .collect(Collectors.toList())) {

            oneRow[0] = sequence;
            oneRow[1] = o.getTotal();
            oneRow[2] = o.getData();
            oneRow[3] = "";
            oneRow[4] = ";";//o.getCliente().getCpf();
            oneRow[5] = o.getId();
            modelo.addRow(oneRow);
            sequence++;

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setClosable(true);
        setResizable(true);
        setTitle("Cheques");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CHEQUE.png"))); // NOI18N

        tabela.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabela.setForeground(new java.awt.Color(102, 102, 102));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Valor", "Data", "Banco", "Cliente", "Venda"
            }
        ));
        tabela.setGridColor(new java.awt.Color(238, 237, 237));
        tabela.setRowHeight(24);
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMaxWidth(100);
            tabela.getColumnModel().getColumn(4).setMinWidth(145);
        }

        jMenu1.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CHEQUE.png"))); // NOI18N
        jMenuItem1.setText("Registrar Cheque");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
