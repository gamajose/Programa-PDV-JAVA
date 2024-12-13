package telas;

import repositorio.EstoqueDao;
import repositorio.ProdutoDao;
import repositorio.UsuarioDao;
import repositorio.VendaDao;
import java.awt.Image;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Produto;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaConsultaEstoque extends javax.swing.JFrame {

    private static final long serialVersionUID = -9165221552918361973L;
    private Produto produto;

    public TelaConsultaEstoque() {
        initComponents();

        mostrarEstoque();

    }

    public Image icone() {
        return new ImageIcon(getClass().getResource("/imagens/ico_main.png")).getImage();
    }

    public void mostrarEstoque() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        ProdutoDao u = new ProdutoDao();

        Object[] dados = new Object[6];
        u.listaProdutos().forEach((p) -> {
            dados[0] = p.getCodigo();
            dados[1] = p.getDescricao().toUpperCase();
            dados[2] = p.getEstoque().getQtdeDisponivel();
            dados[3] = p.getEstoque().getMinimo();
            dados[4] = p.getEstoque().getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dados[5] = p.getEstoque().getUnidade();
            modelo.addRow(dados);
        });
    }

    public int totalVendidoProdutoPorCodigo(long codigo) {
        VendaDao v = new VendaDao();
        return v.totalDeItensVendidoPorProduto(codigo);
    }

    public void getProdutoComEstoque(long id) {
        EstoqueDao e = new EstoqueDao();
        produto = e.estoqueByCodigoProduto(id);
        txtproduto.setText(produto.getDescricao().toUpperCase());
        txtqtdeatual.setText(String.valueOf(produto.getEstoque().getQtdeDisponivel()));
        txtvalidade.setText(produto.getEstoque().getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txtloclizacao.setText(produto.getEstoque().getLocalizaco());
        txtfabricacao.setText(produto.getFabricao());
        txtstatus.setSelectedItem(produto.getEstoque().getStatus());
        txtunidade.setSelectedItem(produto.getEstoque().getUnidade());
        qtdeminima.setText(String.valueOf(produto.getEstoque().getMinimo()));
        txttotalvendido.setText(String.valueOf(totalVendidoProdutoPorCodigo(id)));
        txtcodigo.setText(String.valueOf(produto.getCodigo()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcodigo = new javax.swing.JTextField();
        txtproduto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtloclizacao = new javax.swing.JTextField();
        txtqtdeatual = new javax.swing.JTextField();
        qtdeminima = new javax.swing.JTextField();
        txtstatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtunidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtvalidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtfabricacao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        txtreposicaoqtde = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        txttotalvendido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque");
        setAlwaysOnTop(true);
        setIconImage(icone());

        txtcodigo.setBackground(new java.awt.Color(153, 255, 204));
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        txtproduto.setBackground(new java.awt.Color(255, 255, 204));
        txtproduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprodutoKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sincronizar-24.png"))); // NOI18N
        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtqtdeatual.setBackground(new java.awt.Color(204, 255, 204));
        txtqtdeatual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtqtdeatual.setForeground(new java.awt.Color(0, 102, 255));
        txtqtdeatual.setEnabled(false);

        qtdeminima.setBackground(new java.awt.Color(255, 204, 255));
        qtdeminima.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Zerado", "Disponivel", "Pedido" }));

        jLabel1.setText("Codigo:");

        jLabel2.setText("Pesquisar Produto:");

        jLabel3.setText("Localização:");

        jLabel4.setText("Qtde Atual:");

        jLabel5.setText("Status:");

        jLabel6.setText("Qtde Minima:");

        txtunidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "CX", "UND", "CX25", "CX50", "CX100", "KG", "KIT", "LITRO", "LATA", "ML", "PC", "VIDRO", "TUBO", "SACOS", "PARES" }));

        jLabel7.setText("Unidade:");

        txtvalidade.setBackground(new java.awt.Color(204, 255, 255));
        txtvalidade.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel8.setText("Validade:");

        txtfabricacao.setEditable(false);

        jLabel9.setText("Data Fabricação:");

        jButton4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 153));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mover-por-carrinho-24.png"))); // NOI18N
        jButton4.setText("Produtos com Estoque Zerado / Minimo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tabela.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Produto", "Qtde Atual", "Qtde Minima", "Validade", "Metrica"
            }
        ));
        tabela.setGridColor(new java.awt.Color(247, 247, 241));
        tabela.setRowHeight(21);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMaxWidth(120);
            tabela.getColumnModel().getColumn(2).setMaxWidth(100);
            tabela.getColumnModel().getColumn(3).setMaxWidth(100);
            tabela.getColumnModel().getColumn(4).setMaxWidth(100);
            tabela.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        txtreposicaoqtde.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel10.setText("Reposição: Qtde");

        txttotalvendido.setBackground(new java.awt.Color(204, 253, 241));
        txttotalvendido.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txttotalvendido.setForeground(new java.awt.Color(0, 153, 204));
        txttotalvendido.setEnabled(false);
        txttotalvendido.setOpaque(false);

        jLabel11.setText("Qtde Vendida:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(txtvalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtunidade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtproduto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(txtqtdeatual, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(qtdeminima, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtloclizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtstatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 116, Short.MAX_VALUE)
                                        .addComponent(txtfabricacao, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(txttotalvendido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10)
                                                .addGap(15, 15, 15))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtreposicaoqtde))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtqtdeatual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qtdeminima, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtunidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtreposicaoqtde, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalvendido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtloclizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        getProdutoComEstoque(Long.parseLong(txtcodigo.getText()));
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedColumnCount() > 0) {

            int linha = tabela.getSelectedRow();
            long id = Long.parseLong(tabela.getValueAt(linha, 0).toString().trim());
            getProdutoComEstoque(id);
            txtcodigo.setText(tabela.getValueAt(linha, 0).toString().trim());
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
            int novaQtde = (int) txtreposicaoqtde.getValue();
            if (!txtcodigo.getText().equals("") && novaQtde > 0) {
                EstoqueDao e = new EstoqueDao();
                produto.getEstoque().setQtdeDisponivel(produto.getEstoque().getQtdeDisponivel() + (int) txtreposicaoqtde.getValue());
                e.atualizarEstoque(produto.getEstoque());
                JOptionPane.showMessageDialog(tabela, "Quantidade atualizada com sucesso", "Estoque Atualizado!", 1);
                getProdutoComEstoque(Long.parseLong(txtcodigo.getText()));
                mostrarEstoque();
            } else {
                mostrarEstoque();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        ProdutoDao u = new ProdutoDao();

        Object[] dados = new Object[6];
        u.listaProdutos().forEach((p) -> {

            if (p.getEstoque().getQtdeDisponivel() <= p.getEstoque().getMinimo()) {
                dados[0] = p.getCodigo();
                dados[1] = p.getDescricao().toUpperCase();
                dados[2] = p.getEstoque().getQtdeDisponivel();
                dados[3] = p.getEstoque().getMinimo();
                dados[4] = p.getEstoque().getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                dados[5] = p.getEstoque().getUnidade();
                modelo.addRow(dados);
            }
        });

        if (modelo.getRowCount() == 0) {
            dados[1] = "Nenhum produto com estoque zerado";
            modelo.addRow(dados);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtprodutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodutoKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabela.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtproduto.getText().toUpperCase()));
    }//GEN-LAST:event_txtprodutoKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField qtdeminima;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtfabricacao;
    private javax.swing.JTextField txtloclizacao;
    private javax.swing.JTextField txtproduto;
    private javax.swing.JTextField txtqtdeatual;
    private javax.swing.JSpinner txtreposicaoqtde;
    private javax.swing.JComboBox<String> txtstatus;
    private javax.swing.JTextField txttotalvendido;
    private javax.swing.JComboBox<String> txtunidade;
    private javax.swing.JTextField txtvalidade;
    // End of variables declaration//GEN-END:variables
}
