/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import repositorio.CrediarioDao;
import repositorio.PagamentosDao;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Crediario;
import model.Pagamento;

/**
 *
 * @author deibi
 */
public class TelaReceberValorCrediario extends javax.swing.JDialog {

    private static final long serialVersionUID = 1430605039024988250L;
    private String crediarioID;

    /**
     * Creates new form TelaReceberValorCrediario
     *
     * @param parent
     * @param modal
     */
    public TelaReceberValorCrediario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public String getCrediarioID() {
        return crediarioID;
    }

    public void setCrediarioID(String crediarioID) {
        this.crediarioID = crediarioID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtvalor = new Utilitarios.JNumberFormatField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receber");

        txtvalor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel1.setText("Informe o VALOR:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton1.setText("Receber");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtvalor.getValue().compareTo(BigDecimal.ZERO) != 0) {
            // Crediario crediario = new CrediarioDao().getCrediarioById(Long.parseLong(getCrediarioID()));
            Crediario crediario = new CrediarioDao().getCrediarioById(Long.parseLong(getCrediarioID()));
            new PagamentosDao().savePgto(new Pagamento(txtvalor.getValue(), LocalDate.now(), crediario.getCliente()));
            // new CrediarioDao().saveCrediario(crediario);

            TelaDetalheCrediario.mostraPagamento(crediario.getCliente().getCpf());
            this.setVisible(false);
            JOptionPane.showMessageDialog(rootPane, "Pagamento recebido", "Tudo Ok", 1);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe um valor maior que ZERO", "Erro: R$ 0", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private Utilitarios.JNumberFormatField txtvalor;
    // End of variables declaration//GEN-END:variables
}
