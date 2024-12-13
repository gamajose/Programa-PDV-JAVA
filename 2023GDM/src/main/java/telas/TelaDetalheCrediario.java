/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import repositorio.CrediarioDao;
import repositorio.PagamentosDao;
import java.math.BigDecimal;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import model.Crediario;
import model.Pagamento;

/**
 *
 * @author deibi
 */
public class TelaDetalheCrediario extends javax.swing.JDialog {

    private static final long serialVersionUID = 576921682470385415L;
    public static String contaID;

    /**
     * Creates new form TelaDetalheCrediario
     *
     * @param parent
     * @param modal
     */
    public TelaDetalheCrediario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//     mostraPagamento("092.019.291-02");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPagamentos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        saldoDevedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttotalpagago = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtNcredi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhe do Crediário");

        tabelaPagamentos.setAutoCreateRowSorter(true);
        tabelaPagamentos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabelaPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TRANSAÇÃO", "VALOR PAGO", "DATA", "TOTAL COMPRA", "SALDO DEVEDOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPagamentos.setGridColor(new java.awt.Color(238, 234, 234));
        tabelaPagamentos.setRowHeight(22);
        jScrollPane1.setViewportView(tabelaPagamentos);
        if (tabelaPagamentos.getColumnModel().getColumnCount() > 0) {
            tabelaPagamentos.getColumnModel().getColumn(0).setMinWidth(100);
            tabelaPagamentos.getColumnModel().getColumn(0).setMaxWidth(120);
            tabelaPagamentos.getColumnModel().getColumn(2).setMinWidth(110);
            tabelaPagamentos.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton1.setText("Receber Valor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("PAGAMENTOS");

        txtcliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtcliente.setForeground(new java.awt.Color(102, 102, 102));
        txtcliente.setEnabled(false);
        txtcliente.setOpaque(false);

        txtcpf.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtcpf.setEnabled(false);

        jLabel2.setText("Cliente:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Saldo devedor:");

        saldoDevedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        saldoDevedor.setForeground(new java.awt.Color(102, 0, 0));
        saldoDevedor.setText("0.00");

        jLabel6.setText("TOTAL PAGO:");

        txttotalpagago.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txttotalpagago.setForeground(new java.awt.Color(0, 102, 51));
        txttotalpagago.setText("0.00");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton2.setText("Vender");

        txtNcredi.setEditable(false);
        txtNcredi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtNcredi.setOpaque(false);

        jLabel5.setText("N° Crediário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(422, 422, 422)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttotalpagago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jButton2)
                                .addGap(5, 5, 5)
                                .addComponent(jButton1)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoDevedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 31, Short.MAX_VALUE))
                            .addComponent(txtNcredi))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNcredi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txttotalpagago))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4)
                    .addComponent(saldoDevedor)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaReceberValorCrediario tc = new TelaReceberValorCrediario(null, rootPaneCheckingEnabled);
        tc.setCrediarioID(txtNcredi.getText());
        tc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void mostraPagamento(String cpf) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaPagamentos.getModel();
        modelo.setNumRows(0);

        List<Pagamento> pgtos = new PagamentosDao().pagamentos(cpf);

        txtcpf.setText(pgtos.get(0).getCliente().getCpf());
        txtcliente.setText(pgtos.get(0).getCliente().getPessoaJuridica().getNomeFantasia());

        Crediario crediario = new CrediarioDao().getCrediarioByConta(new Conta(Long.parseLong(contaID)));
        txtNcredi.setText(String.valueOf(crediario.getId()));

        NumberFormat format = NumberFormat.getCurrencyInstance();
        Object[] rows = new Object[6];

        List<BigDecimal> totaisEmCompras = new ArrayList<>();
        List<BigDecimal> totaisEmPgtos = new ArrayList<>();

        for (Pagamento object : pgtos) {

            rows[0] = object.getId();
            if (object.getCrediario() != null) {
                rows[1] = "COMPRA";
                rows[4] = format.format(object.getCrediario().getConta().getValor().add(object.getValor()));
                rows[5] = format.format(object.getCrediario().getConta().getValor());
                totaisEmCompras.add(object.getCrediario().getConta().getValor().add(object.getValor()));

            } else {
                rows[1] = "PAGAMENTO";
                rows[4] = "";
                rows[5] = "";
            }
            rows[2] = format.format(object.getValor());
            rows[3] = object.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            modelo.addRow(rows);
            totaisEmPgtos.add(object.getValor());

        }

        txttotalpagago.setText(String.valueOf(format.format(pgtos.stream().map(v -> v.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add))));

        saldoDevedor.setText(String.valueOf(format.format(totaisEmCompras.stream().reduce(BigDecimal.ZERO, BigDecimal::add)
                .subtract(pgtos.stream().map(v -> v.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add)))));

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel saldoDevedor;
    private static javax.swing.JTable tabelaPagamentos;
    public static javax.swing.JTextField txtNcredi;
    private static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcpf;
    public static javax.swing.JLabel txttotalpagago;
    // End of variables declaration//GEN-END:variables
}
