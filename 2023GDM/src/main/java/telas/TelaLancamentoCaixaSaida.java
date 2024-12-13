/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Utilitarios.DataHora;
import repositorio.CaixaDao;
import repositorio.LancamentoDao;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Caixa;
import model.Lancamento;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaLancamentoCaixaSaida extends javax.swing.JDialog {

    private static final long serialVersionUID = -5753520675135514101L;
    private List<Caixa> listaCaixa = new ArrayList<>();
    private CaixaDao cd;

    /**
     * Creates new form TelaLancamentoCaixaSaida
     */
    public TelaLancamentoCaixaSaida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cd = new CaixaDao();
        listaCaixa = cd.listaCaixa();

        setModelCaixas();
        txtdata.setModel(new DefaultComboBoxModel<>(new String[]{new DataHora().ler_Data()}));

    }

    public final void setModelCaixas() {

        if (listaCaixa.size() > 0) {
            String[] model = new String[listaCaixa.size()];
            for (int i = 0; i < listaCaixa.size(); i++) {
                model[i] = listaCaixa.get(i).getDescr();
            }
            txtcaixa.setModel(new DefaultComboBoxModel<>(model));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        txtvalor = new Utilitarios.JNumberFormatField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdesc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtcaixa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtdata = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saida");

        jLayeredPane1.setBackground(new java.awt.Color(255, 204, 204));
        jLayeredPane1.setOpaque(true);

        jLabel2.setText("Valor:");

        txtvalor.setBackground(new java.awt.Color(255, 255, 204));
        txtvalor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtvalor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel1.setText("Descrição:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton1.setText("Confirmar Lançamento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtdesc.setBackground(new java.awt.Color(255, 255, 204));
        txtdesc.setColumns(20);
        txtdesc.setRows(5);
        jScrollPane1.setViewportView(txtdesc);

        jLabel3.setText("Data:");

        jLabel4.setText("CAIXA:");

        txtdata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtvalor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtcaixa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtdata, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtcaixa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtdata, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 98, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(103, 103, 103))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(txtcaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtvalor.getValue() != BigDecimal.ZERO) {
            CaixaDao caixaDao = new CaixaDao();

            if (caixaDao.listaCaixa().size() > 0) {

                Caixa caixa = caixaDao.getCaixaByNome(txtcaixa.getSelectedItem().toString());

                Lancamento lancamento = new Lancamento();
                lancamento.setValor(txtvalor.getValue());
                lancamento.setTipo("SAIDA");
                lancamento.setCaixa(caixa);
                if (txtdesc.getText().equals("")) {
                    lancamento.setDescr("Saida: Descrição não informada");
                } else {
                    lancamento.setDescr(txtdesc.getText());
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                lancamento.setData(LocalDate.parse(txtdata.getSelectedItem().toString().trim(), formatter));
                lancamento.setHora(LocalDateTime.now());
                lancamento.setResponsavel(TelaMasterApp.txtinfoUser.getText());

                LancamentoDao ld = new LancamentoDao();
                lancamento.setSaldoParcial(ld.total().subtract(txtvalor.getValue()));

                caixa.getLancamentos().add(lancamento);
                caixa.setValorFecamento(caixa.getValorFecamento().subtract(lancamento.getValor()));
                caixa.setDtabertura(LocalDate.parse(txtdata.getSelectedItem().toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                caixa.setDtabertura(LocalDate.parse(txtdata.getSelectedItem().toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                caixaDao.salvaCaixa(caixa);

                JOptionPane.showMessageDialog(rootPane, "Lançamento adicionado", "Confirmado", 1);
                TelaMasterCaixa.mostrarDadosDoCaixa(LocalDate.parse(TelaMasterCaixa.txtdata.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Nenhum Caixa foi criado.\nAcesse o menu Financeiro->Caixa->Criar Caixa.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum valor Informado.", "Atenção", 0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> txtcaixa;
    public javax.swing.JComboBox<String> txtdata;
    private javax.swing.JTextArea txtdesc;
    private Utilitarios.JNumberFormatField txtvalor;
    // End of variables declaration//GEN-END:variables
}
