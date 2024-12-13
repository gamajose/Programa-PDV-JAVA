
package telas;

import Utilitarios.DataHora;
import repositorio.CaixaDao;
import repositorio.LancamentoDao;
import repositorio.PedidoDao;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ItemPedido;
import model.Lancamento;
import model.Pedido;
import relatorio.GeraRelatorioUtil;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaPedidosEfetuados extends javax.swing.JDialog {

    private static final long serialVersionUID = -3932014900812090865L;
    private static List<Pedido> listaPedidos = new ArrayList<>();
    private static PedidoDao pDao;

    /**
     * Creates new form TelaPedidosEfetuados
     */
    public TelaPedidosEfetuados() {
        initComponents();
        pDao = new PedidoDao();

        mostrarPedidos();
    }

    public static void mostrarPedidos() {
        listaPedidos = pDao.listaPedidos();
        DefaultTableModel modelo = (DefaultTableModel) tabelaPedidos.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        NumberFormat format = NumberFormat.getCurrencyInstance();
        Object[] dados = new Object[11];
        for (Pedido p : listaPedidos) {

            dados[0] = String.valueOf(p.getId());
            dados[1] = p.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dados[2] = p.getTipoPedido().toUpperCase();
            dados[3] = p.getCliente().getId();
            dados[4] = p.getVendedor().getId();
            dados[5] = format.format(p.getTotal());
            dados[6] = p.getFormaPagto();
            dados[7] = p.getItemPedido().stream().mapToInt(v -> v.getQtde()).sum();
            dados[9] = p.getObs();
            dados[8] = format.format(p.getDesconto());
            dados[10] = p.getStatus();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            dados[0] = "0";
            dados[1] = "Nenhum Pedido.";

            modelo.addRow(dados);

        }
    }

    public static void mostrarPedidosPorData(LocalDate data) {
        listaPedidos = pDao.listaPedidosPorData(data);
        DefaultTableModel modelo = (DefaultTableModel) tabelaPedidos.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        NumberFormat format = NumberFormat.getCurrencyInstance();
        Object[] dados = new Object[11];
        for (Pedido p : listaPedidos) {

            dados[0] = String.valueOf(p.getId());
            dados[1] = p.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dados[2] = p.getTipoPedido().toUpperCase();
            dados[3] = p.getCliente().getId();
            dados[4] = p.getVendedor().getId();
            dados[5] = format.format(p.getTotal());
            dados[6] = p.getFormaPagto();
            dados[7] = p.getItemPedido().stream().mapToInt(v -> v.getQtde()).sum();
            dados[9] = p.getObs();
            dados[8] = format.format(p.getDesconto());
            dados[10] = p.getStatus();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            dados[0] = "0";
            dados[1] = "Nenhum Pedido.";

            modelo.addRow(dados);

        }
    }

    public static void mostrarItensPedidoSelecionado(long codigoPedido) {
        PedidoDao pD = new PedidoDao();
        List<ItemPedido> listaItensPedidos = pD.pedidoPorCodigo(codigoPedido).getItemPedido();

        DefaultTableModel modelo = (DefaultTableModel) tabeladetail.getModel();
        modelo.setNumRows(0);
        int Counter = 0;

        PedidoDao pDao = new PedidoDao();
        NumberFormat format = NumberFormat.getCurrencyInstance();
        for (ItemPedido pi : listaItensPedidos) {

            Object[] dados = new Object[5];

            dados[0] = String.valueOf(pi.getId());
            dados[1] = pi.getProduto().getDescricao().toUpperCase();
            dados[2] = pi.getProduto().getMarca().toUpperCase();
            dados[3] = pi.getQtde();
            dados[4] = format.format(pi.getPrecoUnitario());

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhum item.";

            modelo.addRow(dados);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busca = new javax.swing.JTextField();
        txtCalendario = new comp.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabeladetail = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnEmitir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedidos realizados");
        setAlwaysOnTop(true);
        setType(java.awt.Window.Type.POPUP);

        busca.setBackground(new java.awt.Color(204, 255, 204));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jLabel1.setText("Por Data:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabeladetail.setAutoCreateRowSorter(true);
        tabeladetail.setFont(new java.awt.Font("Noto Mono", 0, 11)); // NOI18N
        tabeladetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Item", "Marca", "Qtde", "Preço"
            }
        ));
        tabeladetail.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabeladetail.setGridColor(new java.awt.Color(236, 232, 232));
        jScrollPane2.setViewportView(tabeladetail);
        if (tabeladetail.getColumnModel().getColumnCount() > 0) {
            tabeladetail.getColumnModel().getColumn(0).setMaxWidth(120);
            tabeladetail.getColumnModel().getColumn(1).setMinWidth(300);
            tabeladetail.getColumnModel().getColumn(2).setMinWidth(180);
            tabeladetail.getColumnModel().getColumn(4).setMinWidth(150);
        }

        jLabel3.setText("Pesquise:");

        tabelaPedidos.setFont(new java.awt.Font("Noto Mono", 0, 11)); // NOI18N
        tabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Data", "Tipo", "Codigo Cliente", "Vendedor", "Total", "Forma Pagto", "N° Itens", "Desconto", "Obs", "Status"
            }
        ));
        tabelaPedidos.setGridColor(new java.awt.Color(237, 236, 225));
        tabelaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPedidos);
        if (tabelaPedidos.getColumnModel().getColumnCount() > 0) {
            tabelaPedidos.getColumnModel().getColumn(0).setMaxWidth(110);
            tabelaPedidos.getColumnModel().getColumn(5).setMinWidth(120);
            tabelaPedidos.getColumnModel().getColumn(9).setMinWidth(200);
            tabelaPedidos.getColumnModel().getColumn(10).setMinWidth(100);
        }

        jLabel4.setText("Pedidos Efetuados");

        jLabel5.setText("Itens do Pedido Selecionado:");

        jButton2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 0));
        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "EMITIDO", "CANCELADO", "SALVO", " ", " " }));

        jLabel6.setText("Filtro:");

        btnEmitir.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnEmitir.setText("Emitir");
        btnEmitir.setEnabled(false);
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(txtCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane2))
                        .addGap(5, 5, 5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(txtCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnEmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPedidosMouseClicked
        int linha = tabelaPedidos.getSelectedRow();
        long idpedido = Long.parseLong(tabelaPedidos.getValueAt(linha, 0).toString());
        String status = tabelaPedidos.getValueAt(linha, 10).toString();
        mostrarItensPedidoSelecionado(idpedido);

        if (status.equals("SALVO")) {
            btnEmitir.setEnabled(true);
        } else {
            btnEmitir.setEnabled(false);
        }
    }//GEN-LAST:event_tabelaPedidosMouseClicked

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelaPedidos.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelaPedidos.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        mostrarPedidosPorData(LocalDate.parse(txtCalendario.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PedidoDao pd = new PedidoDao();
        int linha = tabelaPedidos.getSelectedRow();
        long idpedido = Long.parseLong(tabelaPedidos.getValueAt(linha, 0).toString());

        Pedido p = pd.pedidoPorCodigo(idpedido);
        pd.deletePedido(p);

        mostrarPedidos();
        DefaultTableModel modelo = (DefaultTableModel) tabeladetail.getModel();
        modelo.setNumRows(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linha = tabelaPedidos.getSelectedRow();
        long idpedido = Long.parseLong(tabelaPedidos.getValueAt(linha, 0).toString());
        GeraRelatorioUtil gera = new GeraRelatorioUtil();
        gera.geraReletorioPedidoEfetuado(idpedido);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
        if (tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 0) != null) {
            int linha = tabelaPedidos.getSelectedRow();
            long idpedido = Long.parseLong(tabelaPedidos.getValueAt(linha, 0).toString());
            Pedido p = new PedidoDao().pedidoPorCodigo(idpedido);
            p.setStatus("EMITIDO");
            new PedidoDao().atualizaPedido(p);

            int opc = JOptionPane.showConfirmDialog(rootPane, "Pedido com status alterado para EMITIDO com sucesso.\n\nDeseja lançar no Caixa o valor total do pedido?", "Emitido", JOptionPane.YES_NO_OPTION);

            if (opc == 0) {

                CaixaDao caixaDao = new CaixaDao();

                Lancamento l = new Lancamento();
                l.setCaixa(caixaDao.getCaixaByNome("MASTER-CX"));
                l.setDescr("Pedido n° " + idpedido);
                l.setValor(p.getTotal());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                l.setData(LocalDate.parse(new DataHora().ler_Data().trim(), formatter));
                l.setHora(LocalDateTime.now());
                l.setTipo("ENTRADA");
                l.setResponsavel(TelaMasterApp.txtinfoUser.getText());

                LancamentoDao ldao = new LancamentoDao();
                l.setSaldoParcial(ldao.total().add(p.getTotal()));//obs
                ldao.salva(l);

            }

            mostrarPedidos();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o pedido na tabela", "Atenção", 0);
        }
    }//GEN-LAST:event_btnEmitirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmitir;
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable tabelaPedidos;
    private static javax.swing.JTable tabeladetail;
    private comp.JCalendar txtCalendario;
    // End of variables declaration//GEN-END:variables
}
