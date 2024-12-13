/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Utilitarios.DataHora;
import repositorio.CaixaDao;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Caixa;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaCadastroCaixa extends javax.swing.JDialog {

    private static final long serialVersionUID = 3639653576694577689L;

    /**
     * Creates new form TelaCadastroCaixa
     */
    public TelaCadastroCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarDadosDoCaixa();
    }

    public static void mostrarDadosDoCaixa() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        CaixaDao lDao = new CaixaDao();
        String[] dados = new String[2];

        for (Caixa f : lDao.listaCaixa()) {
            dados[0] = String.valueOf(f.getId());
            dados[1] = f.getDescr();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dads = new String[2];
            dads[0] = "0";
            dads[1] = "Nenhum registrado.";

            modelo.addRow(dados);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Caixa:");

        tabela.setFont(new java.awt.Font("Noto Mono", 0, 11)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nome"
            }
        ));
        tabela.setGridColor(new java.awt.Color(255, 255, 241));
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(110);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtnome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CaixaDao cx = new CaixaDao();

        Caixa c = new Caixa();
        c.setDescr(txtnome.getText());
        c.setStatus("FECHADO");
        c.setValorAbertura(BigDecimal.ZERO);
        c.setValorFecamento(BigDecimal.ZERO);
        c.setDtabertura(LocalDate.parse(new DataHora().ler_Data(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        c.setDtfechamento(LocalDate.parse(new DataHora().ler_Data(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        cx.salvaCaixa(c);
        JOptionPane.showMessageDialog(rootPane, "Caixa cadastrado", "Confirmado", 1);
        mostrarDadosDoCaixa();
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabela;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables
}
