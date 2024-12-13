/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import repositorio.LancamentoCartaoDAO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.CartaoLancamento;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaCartoes extends javax.swing.JFrame {

    private static final long serialVersionUID = -1976707634361160217L;

    /**
     * Creates new form TelaCartoes
     */
    public TelaCartoes() {
        initComponents();
        mostrarCartaoLancamento();
        setaTotaisCartoes();
    }

    public static void setaTotaisCartoes() {
        totaldebito.setText(new LancamentoCartaoDAO()
                .getTotalVendaCartao("DEBITO")
                .toString()
        );

        totalcredito.setText(new LancamentoCartaoDAO()
                .getTotalVendaCartao("CREDITO")
                .toString()
        );
    }

    public static void mostrarCartaoLancamento() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        LancamentoCartaoDAO pDao = new LancamentoCartaoDAO();
        List<CartaoLancamento> lista = pDao.lancamentosCartao();

        for (CartaoLancamento p : lista) {

            Object[] dados = new Object[6];

            dados[0] = String.valueOf(p.getId());
            dados[1] = p.getDate();
            dados[2] = p.getBandeira();
            dados[3] = p.getParcelas();
            dados[4] = p.getTipoOP();
            dados[5] = p.getValor();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhum ";

            modelo.addRow(dados);

        }
    }

    public static void mostrarCartaoCreditoLancamentoDetalhe(long id) {

        LancamentoCartaoDAO pDao = new LancamentoCartaoDAO();
        CartaoLancamento cl = pDao.mostrarCartaoCreditoLancamentoDetalhe(id);

        DefaultTableModel modelo = (DefaultTableModel) tabela2.getModel();
        modelo.setNumRows(0);

        Object[] dados = new Object[4];

        System.out.println(cl.getParcelas());
        int tempo = 30;
        LocalDate dataParcela;

        for (int i = 1; i <= cl.getParcelas(); i++) {

            dados[0] = i + "°";
            dados[1] = cl.getValor().divide(new BigDecimal(cl.getParcelas()), 2, RoundingMode.CEILING);
            if (cl.getParcelas() > 1) {
                dados[2] = cl.getDate().plusDays(tempo);
                dataParcela = cl.getDate().plusDays(tempo);
            } else {
                dados[2] = cl.getDate().plusDays(0);
                dataParcela = cl.getDate().plusDays(0);
            }

            LocalDate dataAtual = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            if (dataParcela.isAfter(dataAtual)) {
                dados[3] = false;
            } else {
                dados[3] = true;
            }
            modelo.addRow(dados);
            tempo += 30;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totaldebito = new javax.swing.JLabel();
        totalcredito = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cartões");
        setAlwaysOnTop(true);
        setResizable(false);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID#", "Data", "Bandeira", "N° parcelas", "Tipo Operação", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMaxWidth(120);
            tabela.getColumnModel().getColumn(5).setMinWidth(120);
            tabela.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        jLabel1.setText("Lançamentos");

        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Parcela", "Valor", "Vencimento", "Liquidado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela2);
        if (tabela2.getColumnModel().getColumnCount() > 0) {
            tabela2.getColumnModel().getColumn(0).setMinWidth(60);
        }

        jLabel2.setText("Detalhes do Crédito");

        jLabel3.setText("TOTAL DÉBITO   R$:");

        jLabel4.setText("TOTAL CRÉDITO R$:");

        totaldebito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totaldebito.setText("0,00");

        totalcredito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalcredito.setText("0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 763, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totalcredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totaldebito, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(totaldebito))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalcredito))
                        .addGap(41, 41, 41))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        int linha = tabela.getSelectedRow();
        long id = Long.parseLong(tabela.getValueAt(linha, 0).toString());
        mostrarCartaoCreditoLancamentoDetalhe(id);
    }//GEN-LAST:event_tabelaMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable tabela;
    private static javax.swing.JTable tabela2;
    private static javax.swing.JLabel totalcredito;
    private static javax.swing.JLabel totaldebito;
    // End of variables declaration//GEN-END:variables
}
