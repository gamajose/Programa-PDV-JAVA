package telas;

import Utilitarios.FormaPagamento;
import repositorio.LancamentoCartaoDAO;
import repositorio.LancamentoDao;
import repositorio.UsuarioDao;
import repositorio.VendaDao;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ItemVenda;
import model.Venda;
import relatorio.GeraRelatorioUtil;


public class TelaGerenciarVendas extends javax.swing.JFrame {

    private static final long serialVersionUID = 6743723607637919637L;
    private static List<Venda> listagemVendas = new ArrayList<>();

    public TelaGerenciarVendas() {
        initComponents();
        mostarVendasNaTabela();
        //   busca.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))));
    }

    public static void mostarVendasNaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tablevendas.getModel();
        modelo.setNumRows(0);
        int count = 0;

        VendaDao vd = new VendaDao();
        listagemVendas = vd.listaVendas();

        NumberFormat formate = NumberFormat.getCurrencyInstance();

        Object[] rows = new Object[12];
        for (Venda object : listagemVendas) {
            rows[0] = object.getId();
            rows[1] = object.getData();
            rows[2] = object.getHora();
            rows[3] = formate.format(object.getTotal());

            if (object.getDesconto() != null) {
                rows[4] = formate.format(object.getDesconto());
            } else {
                rows[4] = formate.format(0);
            }

            rows[7] = "UID: " + object.getCodigoResponsavel();//OBS PROBLEMA A SER CORRIGIDO
            rows[8] = object.getReponsavel();

            rows[9] = object.getTotalItens();

            if (object.getCliente() != null) {
                rows[5] = object.getCliente().getId();
                rows[6] = object.getCliente().getCpf();

            } else {
                rows[5] = "0";
                rows[6] = "Não Informado";

            }

            rows[10] = object.getFormaPagamento();

            if (object.getFormaPagamento().equals(FormaPagamento.CREDIARIO)) {
                rows[11] = object.getCrediario().getPagamentos().get(0).getValor();
            } else {
                rows[11] = new BigDecimal(0.0);
            }
            modelo.addRow(rows);
            count++;
        }
        if (count == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhuma venda realizada.";

            modelo.addRow(dados);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        try{
            busca = new javax.swing.JTextField(){

                final BufferedImage image = ImageIO.read(getClass().getResource("/imagens/icons8-pesquisar-24.png"));

                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int centerPoint = (getHeight() - image.getHeight())/2;
                    g.drawImage(image, 6, centerPoint, this);
                }
            };
            jButton2 = new javax.swing.JButton();
            jButton1 = new javax.swing.JButton();
            jSplitPane1 = new javax.swing.JSplitPane();
            jPanel1 = new javax.swing.JPanel();
            jScrollPane2 = new javax.swing.JScrollPane();
            tablevendas = new javax.swing.JTable();
            jPanel2 = new javax.swing.JPanel();
            jScrollPane3 = new javax.swing.JScrollPane();
            tabelaitem = new javax.swing.JTable();

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jScrollPane1.setViewportView(jTable1);

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Vendas");
            setBackground(new java.awt.Color(102, 153, 255));
            setResizable(false);

            jLayeredPane1.setBackground(new java.awt.Color(153, 204, 255));
            jLayeredPane1.setOpaque(true);

        }catch(Exception e){}
        busca.setBackground(new java.awt.Color(204, 255, 204));
        busca.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        busca.setMargin(new java.awt.Insets(0, 20, 0, 0));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-impressão-48.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSplitPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName(""); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        tablevendas.setFont(new java.awt.Font("Noto Mono", 0, 12)); // NOI18N
        tablevendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Data", "Hora", "Total", "Desconto", "Cod. Cliente", "CPF", "Cod. Operador", "Operador", "Total Itens", "Pagamento", "Recebido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablevendas.setGridColor(new java.awt.Color(243, 255, 255));
        tablevendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablevendasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablevendas);
        if (tablevendas.getColumnModel().getColumnCount() > 0) {
            tablevendas.getColumnModel().getColumn(0).setMinWidth(90);
            tablevendas.getColumnModel().getColumn(0).setMaxWidth(100);
            tablevendas.getColumnModel().getColumn(1).setMinWidth(90);
            tablevendas.getColumnModel().getColumn(1).setMaxWidth(130);
            tablevendas.getColumnModel().getColumn(2).setMaxWidth(100);
            tablevendas.getColumnModel().getColumn(3).setMinWidth(90);
            tablevendas.getColumnModel().getColumn(6).setMinWidth(120);
            tablevendas.getColumnModel().getColumn(7).setMinWidth(80);
            tablevendas.getColumnModel().getColumn(8).setMinWidth(180);
            tablevendas.getColumnModel().getColumn(10).setMinWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        tabelaitem.setFont(new java.awt.Font("Noto Mono", 0, 12)); // NOI18N
        tabelaitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Produtos da Venda", "Qtde", "Valor", "Desconto"
            }
        ));
        tabelaitem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaitem.setGridColor(new java.awt.Color(243, 240, 224));
        jScrollPane3.setViewportView(tabelaitem);
        if (tabelaitem.getColumnModel().getColumnCount() > 0) {
            tabelaitem.getColumnModel().getColumn(0).setMaxWidth(120);
            tabelaitem.getColumnModel().getColumn(1).setMinWidth(380);
            tabelaitem.getColumnModel().getColumn(2).setMaxWidth(60);
            tabelaitem.getColumnModel().getColumn(3).setMinWidth(120);
            tabelaitem.getColumnModel().getColumn(4).setMinWidth(120);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        jLayeredPane1.setLayer(busca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jSplitPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(busca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1)))
                .addGap(3, 3, 3))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jSplitPane1)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLayeredPane1)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tablevendas.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tablevendas.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
            try {

                long idvenda = Long.valueOf(tablevendas.getValueAt(tablevendas.getSelectedRow(), 0).toString());
                String vendaDesc = "Venda n° " + tablevendas.getValueAt(tablevendas.getSelectedRow(), 0).toString();

                //obs erro no valor
                NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.getDefault());

                Number number = formato.parse(tablevendas.getValueAt(tablevendas.getSelectedRow(), 3)
                        .toString()
                        .trim());

                BigDecimal valor = new BigDecimal(number.doubleValue());

                new LancamentoCartaoDAO().deleteLancamentoCartaoPorVendaID(new Venda(idvenda).getId());
                new VendaDao().deleteVenda(new Venda(idvenda));
                new LancamentoDao().deletaLancamentoVendaCancelada(vendaDesc, valor.setScale(2, RoundingMode.HALF_UP));

                mostarVendasNaTabela();

                DefaultTableModel table = (DefaultTableModel) tabelaitem.getModel();
                table.setNumRows(0);

            } catch (ParseException ex) {
                Logger.getLogger(TelaGerenciarVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablevendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablevendasMouseClicked
        if (evt.getClickCount() > 1) {
            System.out.println("dois click");
        } else {
            DefaultTableModel modelo = (DefaultTableModel) tabelaitem.getModel();
            modelo.setNumRows(0);

            NumberFormat f = NumberFormat.getCurrencyInstance();

            long vendaId = Long.parseLong(tablevendas.getValueAt(tablevendas.getSelectedRow(), 0).toString().trim());
            Object[] rows = new Object[5];
            
            List<ItemVenda> itens = new VendaDao().listaItens(new Venda(vendaId));
            for (ItemVenda object : itens) {

                rows[0] = object.getId();
                rows[1] = object.getProduto().getDescricao().toUpperCase();
                rows[2] = object.getQtde();
                rows[3] = f.format(object.getValorUNT());
                rows[4] = f.format(object.getValorDesconto());
                modelo.addRow(rows);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablevendasMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(tablevendas.getSelectedRow() != -1){
        int linha = tablevendas.getSelectedRow();
        long idVenda = Long.parseLong(tablevendas.getValueAt(linha, 0).toString());
        long idCliente = Long.parseLong(tablevendas.getValueAt(linha, 5).toString());
        GeraRelatorioUtil gera = new GeraRelatorioUtil();
        gera.geraReletorioVendasEfetuadas(idVenda, idCliente);
       }else{
           JOptionPane.showMessageDialog(tablevendas, "Selecione uma venda na tabela","Atenção",0);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaitem;
    private static javax.swing.JTable tablevendas;
    // End of variables declaration//GEN-END:variables
}
