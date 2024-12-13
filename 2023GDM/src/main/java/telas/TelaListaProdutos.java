package telas;

import repositorio.CategoriaDao;
import repositorio.ProdutoDao;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ItemPedido;
import model.Produto;

public class TelaListaProdutos extends javax.swing.JDialog {

    private static final long serialVersionUID = 2120629343863185846L;
    private static List<Produto> listaProdutos = null;
    private int linhaSelecionada;
    private TelaCadastroProduto telaprodutos;
    private List<ItemPedido> listItens = new ArrayList<>();
    private ItemPedido item;
    private Produto produto;

    private int novaQtde;
    private int estoque;
    private long codigoProduto;

    //1 = pdv .... 2 = tela pedido
    public static int origemDaChamada = 0;

    public TelaListaProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setDefaultLookAndFeelDecorated(true);

        listItens = TelaPedidoVenda.listaProdutosDoPedido;

        mostrarProdutos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbproduto = new javax.swing.JTable();
        busca = new javax.swing.JTextField();
        qtdeSpiner = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setTitle("Produtos Cadastrados");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);

        tbproduto.setFont(new java.awt.Font("Noto Mono", 0, 11)); // NOI18N
        tbproduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Referencia", "Preço", "Marca", "Categoria", "Validade", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbproduto.setGridColor(new java.awt.Color(243, 255, 228));
        tbproduto.setRowHeight(20);
        tbproduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbprodutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbproduto);
        if (tbproduto.getColumnModel().getColumnCount() > 0) {
            tbproduto.getColumnModel().getColumn(0).setMinWidth(60);
            tbproduto.getColumnModel().getColumn(0).setMaxWidth(120);
            tbproduto.getColumnModel().getColumn(1).setMinWidth(220);
            tbproduto.getColumnModel().getColumn(2).setMinWidth(120);
            tbproduto.getColumnModel().getColumn(2).setMaxWidth(130);
            tbproduto.getColumnModel().getColumn(3).setMinWidth(95);
            tbproduto.getColumnModel().getColumn(3).setMaxWidth(140);
            tbproduto.getColumnModel().getColumn(6).setMinWidth(100);
            tbproduto.getColumnModel().getColumn(6).setMaxWidth(125);
            tbproduto.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        busca.setBackground(new java.awt.Color(255, 255, 204));
        busca.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        busca.setForeground(new java.awt.Color(153, 153, 153));
        busca.setText("Pesquisar...");
        busca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscaFocusGained(evt);
            }
        });
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        qtdeSpiner.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        qtdeSpiner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));
        qtdeSpiner.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton1.setText("Adicionar ao Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Qtde:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sincronizar-24.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton4.setText("Novo Produto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(qtdeSpiner, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(5, 5, 5)
                        .addComponent(jButton3)
                        .addGap(5, 5, 5)
                        .addComponent(jButton2)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qtdeSpiner, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel2)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.setVisible(false);
        mostrarProdutos();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbprodutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprodutoMouseClicked

        if (evt.getClickCount() == 2 && origemDaChamada == 1) {

            int linha = tbproduto.getSelectedRow();
            long codigoProd = Long.parseLong(tbproduto.getValueAt(linha, 0).toString().trim());
            Produto p = new ProdutoDao().produtoByCodigo(codigoProd);

            TelaMasterVenda.txtqtde.setValue(qtdeSpiner.getValue());
            TelaMasterVenda.txtvalorunt.setValue(p.getPreco());
            TelaMasterVenda.txttotalporItens.setValue(p.getPreco().multiply(new BigDecimal((int) qtdeSpiner.getValue())));

            TelaMasterVenda.txtcodigo.setText(String.valueOf(codigoProd));
            TelaMasterVenda.txtcodigo.requestFocus();
            TelaMasterVenda.txtdesc.setText(tbproduto.getValueAt(linhaSelecionada, 1).toString().trim() + " [ENTER]");
            this.setVisible(false);

        }
    }//GEN-LAST:event_tbprodutoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tbproduto.getSelectedRow() != -1) {
            codigoProduto = Long.parseLong(tbproduto.getValueAt(tbproduto.getSelectedRow(), 0).toString().trim());

            if (origemDaChamada == 1) {
                linhaSelecionada = tbproduto.getSelectedRow();

                int qtdeEstoqueProduto = Integer.parseInt(tbproduto.getValueAt(linhaSelecionada, 7).toString().trim());
                int qtdeDesejada = ((Integer) qtdeSpiner.getValue());

                if (qtdeEstoqueProduto < qtdeDesejada) {
                    JOptionPane.showMessageDialog(rootPane, "Produto sem estoque suficiente. Reduza a quantidade informada!", "Não é possível", 0);
                } else {
                    Produto p = new ProdutoDao().produtoByCodigo(codigoProduto);
                    TelaMasterVenda.txtqtde.setValue(qtdeSpiner.getValue());
                    TelaMasterVenda.txtvalorunt.setValue(p.getPreco());
                    TelaMasterVenda.txttotalporItens.setValue(p.getPreco().multiply(new BigDecimal((int) qtdeSpiner.getValue())));

                    TelaMasterVenda.txtcodigo.setText(String.valueOf(codigoProduto));
                    TelaMasterVenda.txtdesc.setText(tbproduto.getValueAt(linhaSelecionada, 1).toString().trim() + " [ENTER]");
                    TelaMasterVenda.txtcodigo.requestFocus();
                    this.setVisible(false);
                }
            } else {
                linhaSelecionada = tbproduto.getSelectedRow();

                produto = listaProdutos
                        .stream()
                        .filter(p -> codigoProduto == p.getCodigo())
                        .findFirst()
                        .orElse(null);

                item = new ItemPedido();
                item.setProduto(produto);
                item.setPrecoUnitario(produto.getPreco());
                item.setQtde((Integer) qtdeSpiner.getValue());

                int qtdeApoio = 0;
                boolean confirmacaoRemocao = false;

                if (listItens.isEmpty()) {
                    if (((Integer) qtdeSpiner.getValue()) <= produto.getEstoque().getQtdeDisponivel()) {
                        listItens.add(item);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Item sem estoque suficiente!", "Não é possível", 0);
                    }

                } else {
                    for (Iterator<ItemPedido> iterator = listItens.iterator(); iterator.hasNext();) {
                        ItemPedido next = iterator.next();

                        if (next.getProduto().getCodigo().equals(item.getProduto().getCodigo())) {
                            qtdeApoio = next.getQtde();

                            iterator.remove();

                            confirmacaoRemocao = true;
                            break;

                        }
                    }

                    estoque = produto.getEstoque().getQtdeDisponivel();
                    novaQtde = (qtdeApoio + (Integer) qtdeSpiner.getValue());

                    if (novaQtde <= estoque && qtdeApoio <= estoque) {

                        if (confirmacaoRemocao) {
                            item.setQtde(novaQtde);
                            listItens.add(item);
                        } else {
                            listItens.add(item);
                        }
                    }

                }

                if (novaQtde <= estoque && qtdeApoio <= estoque) {
                    TelaPedidoVenda.listaProdutosDoPedido = listItens;
                    TelaPedidoVenda.mostrarProdutosPedidos();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Item sem estoque suficiente!", "Não é possível", 0);
                }
                qtdeSpiner.setValue(1);
                item = null;
                produto = null;

                if (novaQtde <= estoque && qtdeApoio <= estoque) {
                    JOptionPane.showMessageDialog(rootPane, "Item Adicionado com sucesso!", "Confirmado", 1);
                }

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum Item selecionado na tabela!", "Selecione", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tbproduto.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tbproduto.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void buscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscaFocusGained
        busca.setText("");
    }//GEN-LAST:event_buscaFocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mostrarProdutos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SwingWorker work = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    if (telaprodutos == null) {
                        telaprodutos = new TelaCadastroProduto();
                        TelaMasterApp.getDisplay().add(telaprodutos);
                    }

                    Dimension desktopSize = TelaMasterApp.getDisplay().getSize();
                    Dimension screenSize = telaprodutos.getSize();
                    telaprodutos.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
                    telaprodutos.setSelected(true);

                    if (CategoriaDao.verificaSeExistiCategoriaCadastrada() == true) {
                        TelaCadastroProduto.setaCategorias();
                    } else {
                        TelaCadastroProduto.categoria.setModel(
                                new DefaultComboBoxModel<>(new String[]{"Categoria não cadastrada"}));;
                    }

                    TelaCadastroProduto.setaFornecedoresBox();

                    telaprodutos.setVisible(true);
                    telaprodutos.requestFocus();

                } catch (PropertyVetoException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro abrir a janela cadastro de produtos", "ops..", 0);
                }
                return null;
            }
        };

        work.execute();
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void mostrarProdutos() {
        DefaultTableModel modelo = (DefaultTableModel) tbproduto.getModel();
        modelo.setNumRows(0);

        ProdutoDao pdao = new ProdutoDao();
        listaProdutos = pdao.listaProdutos();

        int Counter = 0;

        for (Produto p : listaProdutos) {

            Object[] dados = new Object[8];

            dados[0] = String.valueOf(p.getCodigo());
            dados[1] = p.getDescricao().toUpperCase();
            dados[2] = p.getReferencia().toUpperCase();
            dados[3] = String.valueOf(p.getPreco());
            dados[4] = p.getMarca().toUpperCase();
            dados[5] = p.getCategoria().getNome().toUpperCase();
            dados[6] = p.getEstoque().getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dados[7] = p.getEstoque().getQtdeDisponivel();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhum Produto Cadastrado.";

            modelo.addRow(dados);
        }
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner qtdeSpiner;
    public static javax.swing.JTable tbproduto;
    // End of variables declaration//GEN-END:variables
}
