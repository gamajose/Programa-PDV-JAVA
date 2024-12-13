package telas;

import Utilitarios.HibernateUtil;
import repositorio.DepartamentoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cargo;
import model.Departamento;
import org.hibernate.Session;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaCadastroDepartamentos extends javax.swing.JDialog {

    private static final long serialVersionUID = 8850876691337181139L;

    private DefaultListModel listModel = new DefaultListModel();
    private List<Cargo> cargos = new ArrayList<>();

    /**
     * Creates new form TelaCadastroDepartamentos
     *
     * @param parent
     * @param modal
     */
    public TelaCadastroDepartamentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarDeptdos();
    }

    public final void mostrarDeptdos() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        for (Departamento p : DepartamentoDAO.listaDepartamentos()) {

            Object[] dados = new Object[2];

            dados[0] = String.valueOf(p.getId());
            dados[1] = p.getNome().toUpperCase();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhum Departamento.";

            modelo.addRow(dados);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cargolist = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        txtcargo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtDepartamento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(cargolist);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtcargo.setEditable(true);
        txtcargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Supervisor", "Gerente", "Administrador", "Montador", "Cobrador", "Entregador", "Motorista", "Vigilante", "Atendente", "Tesoureiro", "Segurança", "Estivador", "Analista", "Repositor", "Diarista", "Zelador", "Caixa" }));

        jLabel2.setText("Cargos:");

        jLabel3.setText("Nome do Departamento: ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDepartamento.setEditable(true);
        txtDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendas", "Financeiro", " ", " " }));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel4.setText("Ex.: Analista, Cobrador etc.. ");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel5.setText("Ex:. Vendas, Transportes etc..");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Departamento"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Departamentos Cadastrados", jPanel2);

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.setEnabled(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println(listModel.size());

        if (listModel.size() > 0) {

            Departamento dep = new Departamento();
            dep.setNome(txtDepartamento.getSelectedItem().toString().toUpperCase());

            for (int i = 0; i < listModel.size(); i++) {
                Cargo cargo = new Cargo();
                System.out.println(cargolist.getModel().getElementAt(i));
                cargo.setCargo(cargolist.getModel().getElementAt(i));
                cargo.setDepartamento(dep);
                cargos.add(cargo);

            }

            dep.setCargos(cargos);

            try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
                session.beginTransaction();
                session.persist(dep);
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(rootPane, "Departamento e Cargos Adicionado com sucesso.", "Confirmado", 1);

            } finally {
                TelaCadastroVendedor.setaDepartametos();
                TelaCadastroVendedor.setaCargosDepartametos(txtDepartamento.getSelectedItem().toString().toUpperCase().trim());
                this.setVisible(false);
                mostrarDeptdos();
                TelaCadastroVendedor.txtdepartamento.setSelectedItem(txtDepartamento.getSelectedItem());

            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = 0;

        if (!listModel.contains(txtcargo.getSelectedItem().toString())) {

            listModel.add(index++, txtcargo.getSelectedItem().toString().trim());
            cargolist.setModel(listModel);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try {
            int linha = tabela.getSelectedRow();
            long codidoDp = Long.parseLong(tabela.getValueAt(linha, 0).toString());

            DepartamentoDAO dp = new DepartamentoDAO();
            dp.deletedp(codidoDp);

            mostrarDeptdos();
            TelaCadastroVendedor.setaDepartametos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não é possivel excluir Departamento.\n"
                    + "Existe(m) funcionário(s) cadastrados no departamento", "Erro", 0);
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaKeyPressed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        btndelete.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JList<String> cargolist;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox<String> txtDepartamento;
    private javax.swing.JComboBox<String> txtcargo;
    // End of variables declaration//GEN-END:variables
}
