package telas;

import Utilitarios.DataHora;
import repositorio.CaixaDao;
import repositorio.ClienteDao;
import repositorio.LancamentoDao;
import repositorio.PedidoDao;
import repositorio.VendedorDao;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.EnderecoEntrega;
import model.ItemPedido;
import model.Lancamento;
import model.Pedido;
import model.Vendedor;
import relatorio.GeraRelatorioUtil;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaPedidoVenda extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = -6470884820497181828L;
    public static List<ItemPedido> listaProdutosDoPedido = new ArrayList<>();
    private long codigoImpressao;
    private TelaListaProdutos tlp;

    public TelaPedidoVenda() {

        initComponents();
        mostrarProdutosPedidos();
        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);
        txtemissao.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txtcodigoCliente.requestFocus();

        geraNumeroNovoPedido();

    }

    protected final void geraNumeroNovoPedido() {
        txtnumeroPedido.setText(String.valueOf(new PedidoDao().geraNumeroProximoPedido()));
    }
    //captura de eventos do teclado
    //evt.getID() == KeyEvent.KEY_PRESSED && evt.getModifiers() == KeyEvent.CTRL_MASK && evt.getKeyCode() == KeyEvent.VK_F
    final AWTEventListener listener = (AWTEvent event) -> {
        try {
            KeyEvent evt = (KeyEvent) event;

            if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getKeyCode() == KeyEvent.VK_F4) {
                if (tlp == null) {
                    tlp = new TelaListaProdutos(null, true);
                }
                tlp.setVisible(true);
            }
            if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getKeyCode() == KeyEvent.VK_ENTER) {
                System.out.println("ENTER acionado");
            }
            if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getKeyCode() == KeyEvent.VK_F2) {
                TelaListaBuscaClientes tlp = new TelaListaBuscaClientes(null, true);
                tlp.setVisible(true);

            }
        } catch (Exception e) {
        }
    };

    public static void mostrarProdutosPedidos() {

        DefaultTableModel modelo = (DefaultTableModel) tabelapedido.getModel();
        modelo.setNumRows(0);

        List<BigDecimal> valoresTotaisDosItens = new ArrayList<>();

        int Counter = 0;

        if (!listaProdutosDoPedido.isEmpty()) {

            Object[] dados = new Object[7];
            Collections.reverse(valoresTotaisDosItens);

            NumberFormat format = NumberFormat.getCurrencyInstance();

            for (ItemPedido p : listaProdutosDoPedido) {
                dados[0] = String.valueOf(p.getProduto().getCodigo());
                dados[1] = p.getProduto().getDescricao().toUpperCase();
                dados[2] = p.getProduto().getEstoque().getUnidade().toUpperCase();
                dados[3] = p.getQtde();
                dados[4] = p.getPrecoUnitario();
                dados[5] = format.format(p.getPrecoUnitario().multiply(new BigDecimal(p.getQtde())));

                Counter++;
                modelo.addRow(dados);

                valoresTotaisDosItens.add(p.getPrecoUnitario().multiply(new BigDecimal(p.getQtde())));

            }

            BigDecimal subTotalPedido = valoresTotaisDosItens.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            txtsubtotal.setValue(subTotalPedido);
            txtTotal.setValue(subTotalPedido);
            totalItens.setText(String.valueOf(listaProdutosDoPedido.stream().mapToInt(i -> i.getQtde()).sum()));

        } else {

            if (Counter == 0) {
                String[] dados = new String[2];
                dados[0] = "0";
                dados[1] = "Nenhum Produto adicionado.";

                modelo.addRow(dados);

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelapedido = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtformapgto = new javax.swing.JComboBox<>();
        txtsubtotal = new Utilitarios.JNumberFormatField();
        txtfrete = new Utilitarios.JNumberFormatField();
        jPanel1 = new javax.swing.JPanel();
        btnAddproduto = new javax.swing.JButton();
        btnsalva = new javax.swing.JButton();
        btndeletePr = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        BTNfechar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txtdesconto = new Utilitarios.JNumberFormatField();
        txtTotal = new Utilitarios.JNumberFormatField();
        totalItens = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtcodigoCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtemissao = new javax.swing.JTextField();
        txtentrega = new comp.JCalendar();
        jLabel15 = new javax.swing.JLabel();
        txtnumeroPedido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcodigovendedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnomevendedor = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txttipopedido = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedidos e Orçamentos");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        tabelapedido.setFont(new java.awt.Font("Noto Mono", 0, 11)); // NOI18N
        tabelapedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Unidade", "Qtde", "Preço", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelapedido.setGridColor(new java.awt.Color(234, 241, 225));
        tabelapedido.setRowHeight(20);
        jScrollPane1.setViewportView(tabelapedido);
        if (tabelapedido.getColumnModel().getColumnCount() > 0) {
            tabelapedido.getColumnModel().getColumn(0).setMaxWidth(120);
            tabelapedido.getColumnModel().getColumn(1).setMinWidth(250);
            tabelapedido.getColumnModel().getColumn(2).setMaxWidth(100);
            tabelapedido.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Sub-Total:");

        jLabel2.setText("Frete:");

        jLabel3.setText("Desconto:");

        jLabel4.setText("Total:");

        jLabel11.setText("Observações:");

        txtobs.setBackground(new java.awt.Color(255, 255, 204));
        txtobs.setColumns(20);
        txtobs.setRows(5);
        jScrollPane2.setViewportView(txtobs);

        jLabel10.setText("Forma de Pagamento:");

        txtformapgto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A Vista", "A Prazo", "Cheque", "Cartao", "Boleto", "Carnê" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtformapgto, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtformapgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtsubtotal.setForeground(new java.awt.Color(0, 51, 102));
        txtsubtotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtfrete.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtfrete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfreteFocusLost(evt);
            }
        });
        txtfrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfreteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações:"));

        btnAddproduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        btnAddproduto.setText("Incluir Item ( F4 )");
        btnAddproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddprodutoActionPerformed(evt);
            }
        });

        btnsalva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAVE.png"))); // NOI18N
        btnsalva.setText("Salvar Pedido");
        btnsalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvaActionPerformed(evt);
            }
        });

        btndeletePr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menou.png"))); // NOI18N
        btndeletePr.setText("Retirar Produto");
        btndeletePr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletePrActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new.png"))); // NOI18N
        jButton6.setText("Novo Pedido");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-impressão-48.png"))); // NOI18N
        btnimprimir.setText("Imprimir -  CTRL+P");
        btnimprimir.setEnabled(false);
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        jButton8.setText("Sair - CTRL+F4");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-contabilidade-24.png"))); // NOI18N
        jButton1.setText("Pedidos Efetuados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BTNfechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        BTNfechar.setText("Fechar Pedido");
        BTNfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNfecharActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-notícias-48.png"))); // NOI18N
        jButton7.setText("Pedidos Remotos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddproduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btndeletePr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BTNfechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeletePr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNfechar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtdesconto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtdesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescontoActionPerformed(evt);
            }
        });

        txtTotal.setForeground(new java.awt.Color(0, 51, 102));
        txtTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        totalItens.setForeground(new java.awt.Color(0, 102, 153));
        totalItens.setText("0");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Total de Itens:");

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 204));
        jLabel17.setText("F2 - Buscar Cliente");

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 204));
        jLabel18.setText("F3 - Buscar Vendedor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfrete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtfrete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtdesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalItens)
                                    .addComponent(jLabel13)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtcodigoCliente.setBackground(new java.awt.Color(204, 255, 204));
        txtcodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoClienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Codigo do Cliente:");

        jLabel5.setText("Cliente:");

        txtcliente.setBackground(new java.awt.Color(255, 255, 204));
        txtcliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel7.setText("Emissão:");

        txtemissao.setBackground(new java.awt.Color(255, 255, 204));

        jLabel15.setText("Previsão entrega:");

        txtnumeroPedido.setEditable(false);
        txtnumeroPedido.setBackground(new java.awt.Color(204, 255, 204));

        jLabel9.setText("N° Pedido :");

        txtcodigovendedor.setBackground(new java.awt.Color(204, 255, 204));
        txtcodigovendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigovendedorActionPerformed(evt);
            }
        });

        jLabel8.setText("Codigo do  Vendedor:");

        txtnomevendedor.setEditable(false);
        txtnomevendedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel16.setText("Nome do Vendedor:");

        txttipopedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VENDA", "COMPRA", "ORÇAMENTO" }));

        jLabel14.setText("Tipo de Pedido:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emitente", "Destinatário" }));

        jLabel12.setText("Frete por Conta:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcodigovendedor)
                        .addComponent(txtcodigoCliente))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGap(388, 388, 388)
                            .addComponent(jButton10)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton9)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(txttipopedido, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))))
                    .addComponent(jLabel16)
                    .addComponent(jLabel5)
                    .addComponent(txtnomevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtemissao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtentrega, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(txtnumeroPedido))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttipopedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemissao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton9)
                                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel16))))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnomevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton10))
                            .addComponent(txtcodigovendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddprodutoActionPerformed
        if (tlp == null) {
            tlp = new TelaListaProdutos(null, true);
        }
        tlp.setVisible(true);
        BTNfechar.setEnabled(true);
        //impedir da janela se fechar ao clicar 2x acao q acontece no pdv caso valor seja 1
        TelaListaProdutos.origemDaChamada = 2;

    }//GEN-LAST:event_btnAddprodutoActionPerformed

    private void btndeletePrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletePrActionPerformed
        int linhaSelecionada = tabelapedido.getSelectedRow();

        if (linhaSelecionada != -1) {

            long codigoProduto = Long.parseLong(tabelapedido.getValueAt(linhaSelecionada, 0).toString().trim());

            for (Iterator<ItemPedido> iterator = listaProdutosDoPedido.iterator(); iterator.hasNext();) {
                ItemPedido next = iterator.next();
                if (next.getProduto().getCodigo().equals(codigoProduto)) {
                    iterator.remove();
                    break;
                }

            }
            mostrarProdutosPedidos();

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Item na tabela", "Atenção", 0);
        }
    }//GEN-LAST:event_btndeletePrActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.println(evt.getKeyChar());
        System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        TelaListaBuscaClientes lc = new TelaListaBuscaClientes(null, closable);
        TelaListaBuscaClientes.setCodigotela(1);
        lc.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        GeraRelatorioUtil rel = new GeraRelatorioUtil();

        rel.geraReletorioPedidoEfetuado(codigoImpressao);
        btnimprimir.setEnabled(false);

    }//GEN-LAST:event_btnimprimirActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        VendedorDao vd = new VendedorDao();
        if (!txtcodigovendedor.getText().equals("")) {
            Optional<Vendedor> v = vd.vendedorByCodigo(Long.valueOf(txtcodigovendedor.getText().trim()));
            if (v.isPresent()) {
                Vendedor vendedor = v.get();
                txtnomevendedor.setText(vendedor.getNome().toUpperCase());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vendedor não encontrado no Sistema", "Atenção", 0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vendedor não encontrado no Sistema", "Atenção Informe o codigo", 0);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtfreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfreteActionPerformed
        txtTotal.setValue(txtsubtotal.getValue()
                .add(txtfrete.getValue())
                .subtract(txtdesconto.getValue()));
    }//GEN-LAST:event_txtfreteActionPerformed

    private void txtdescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescontoActionPerformed
        txtTotal.setValue(txtsubtotal.getValue()
                .add(txtfrete.getValue())
                .subtract(txtdesconto.getValue()));        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescontoActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        txtTotal.setValue(txtsubtotal.getValue()
                .add(txtfrete.getValue())
                .subtract(txtdesconto.getValue()));        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void BTNfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNfecharActionPerformed
        try {
            txtTotal.setValue(txtsubtotal.getValue()
                    .add(txtfrete.getValue())
                    .subtract(txtdesconto.getValue()));

            PedidoDao pd = new PedidoDao();
            ClienteDao clienteEndereco = new ClienteDao();

            Cliente cliente = clienteEndereco.clientePorCodigo(Long.valueOf(txtcodigoCliente.getText().trim()));

            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setVendedor(new Vendedor(Long.valueOf(txtcodigovendedor.getText().trim())));
            pedido.setItemPedido(listaProdutosDoPedido);

            switch (txttipopedido.getSelectedItem().toString()) {
                case "ORÇAMENTO":
                    pedido.setStatus("EMITIDO");
                    break;
                case "VENDA":
                    pedido.setStatus("EMITIDO");
                    break;
                case "COMPRA":
                    pedido.setStatus("EMITIDO");
                    break;
            }

            pedido.setDataPedido(LocalDate.parse(new DataHora().ler_Data().trim(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            pedido.setDesconto(txtdesconto.getValue());
            pedido.setFrete(txtfrete.getValue());
            pedido.setTotal(txtTotal.getValue());
            pedido.setPrevisaoEntrega(txtentrega.getText());

            pedido.setObs(txtobs.getText());
            pedido.setTipoPedido(txttipopedido.getSelectedItem().toString());
            pedido.setFormaPagto(txtformapgto.getSelectedItem().toString());

            EnderecoEntrega entrega = new EnderecoEntrega();
            if (cliente.getListaEndereco().size() > 2) {
                entrega.setBairro(cliente.getListaEndereco().get(1).getBairro());
                entrega.setCep(cliente.getListaEndereco().get(1).getCep());
                entrega.setCidade(cliente.getListaEndereco().get(1).getCidade());
                entrega.setEnd(cliente.getListaEndereco().get(1).getEndereco());
                entrega.setN(cliente.getListaEndereco().get(1).getNumero());
                entrega.setReferencia(cliente.getListaEndereco().get(1).getReferencia());
                entrega.setUf(cliente.getListaEndereco().get(1).getUf());
                pedido.setEnderecoEntrega(entrega);
            } else {
                entrega.setBairro(cliente.getListaEndereco().get(0).getBairro());
                entrega.setCep(cliente.getListaEndereco().get(0).getCep());
                entrega.setCidade(cliente.getListaEndereco().get(0).getCidade());
                entrega.setEnd(cliente.getListaEndereco().get(0).getEndereco());
                entrega.setN(cliente.getListaEndereco().get(0).getNumero());
                entrega.setReferencia(cliente.getListaEndereco().get(0).getReferencia());
                entrega.setUf(cliente.getListaEndereco().get(0).getUf());
                pedido.setEnderecoEntrega(entrega);
            }

            listaProdutosDoPedido.stream().forEach(i -> i.setPedido(pedido));

            codigoImpressao = pd.salvaPedido(pedido);
            int opc = JOptionPane.showConfirmDialog(rootPane, "Pedido Concluido com sucesso.\n\nDeseja lançar no Caixa o total do pedido?", "Pedido Fechado", JOptionPane.YES_NO_OPTION);

            if (opc == 0) {
                CaixaDao caixaDao = new CaixaDao();

                Lancamento l = new Lancamento();
                l.setCaixa(caixaDao.getCaixaByNome("MASTER-CX"));
                l.setDescr("Pedido n° " + codigoImpressao);
                l.setValor(txtTotal.getValue());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                l.setData(LocalDate.parse(new DataHora().ler_Data().trim(), formatter));
                l.setHora(LocalDateTime.now());
                l.setTipo("ENTRADA");
                l.setResponsavel(TelaMasterApp.txtinfoUser.getText());

                LancamentoDao ldao = new LancamentoDao();
                l.setSaldoParcial(ldao.total().add(txtTotal.getValue()));//obs
                ldao.salva(l);
            }

            btnimprimir.setEnabled(true);
            BTNfechar.setEnabled(false);

            limpaNovoPedido(false);
            cliente = new Cliente();

            btnAddproduto.setEnabled(false);
            btndeletePr.setEnabled(false);
            btnsalva.setEnabled(false);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Informe os Codigos do cliente e do vendedor.", "Atenção erro", 0);
        }

    }//GEN-LAST:event_BTNfecharActionPerformed

    private void limpaNovoPedido(boolean btn) {
        DefaultTableModel modelo = (DefaultTableModel) tabelapedido.getModel();
        modelo.setNumRows(0);

        btnimprimir.setEnabled(true);
        listaProdutosDoPedido.clear();
        txtTotal.setValue(BigDecimal.ZERO);
        txtsubtotal.setValue(BigDecimal.ZERO);
        txtfrete.setValue(BigDecimal.ZERO);
        txtdesconto.setValue(BigDecimal.ZERO);
        txtcliente.setText("");
        txtcodigoCliente.setText("");
        txtobs.setText("");

        if (btn) {
            btnimprimir.setEnabled(false);
        }
    }

    private void txtfreteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfreteFocusLost
        txtTotal.setValue(txtsubtotal.getValue()
                .add(txtfrete.getValue())
                .subtract(txtdesconto.getValue()));        // TODO add your handling code here:
    }//GEN-LAST:event_txtfreteFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaPedidosEfetuados pe = new TelaPedidosEfetuados();
        pe.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcodigovendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigovendedorActionPerformed
        VendedorDao vd = new VendedorDao();
        if (!txtcodigovendedor.getText().equals("")) {
            Optional<Vendedor> v = vd.vendedorByCodigo(Long.valueOf(txtcodigovendedor.getText().trim()));
            if (v.isPresent()) {
                Vendedor vendedor = v.get();
                txtnomevendedor.setText(vendedor.getNome());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vendedor não encontrado no Sistema", "Atenção", 0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vendedor não encontrado no Sistema", "Atenção Informe o codigo", 0);
        }
    }//GEN-LAST:event_txtcodigovendedorActionPerformed

    private void txtcodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoClienteActionPerformed
        ClienteDao vd = new ClienteDao();
        if (!txtcodigoCliente.getText().equals("")) {
            Cliente v = vd.clientePorCodigo(Long.valueOf(txtcodigoCliente.getText().trim()));
            if (v != null) {

                txtcliente.setText(v.getPessoaJuridica().getNomeFantasia());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado no Sistema", "Atenção", 0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado no Sistema", "Atenção Informe o codigo", 0);
        }
    }//GEN-LAST:event_txtcodigoClienteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        limpaNovoPedido(true);
        geraNumeroNovoPedido();
        btnAddproduto.setEnabled(true);
        btndeletePr.setEnabled(true);
        totalItens.setText("0");
        btnsalva.setEnabled(true);
        btnimprimir.setEnabled(false);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setVisible(false);
        limpaNovoPedido(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnsalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvaActionPerformed
        try {
            txtTotal.setValue(txtsubtotal.getValue()
                    .add(txtfrete.getValue())
                    .subtract(txtdesconto.getValue()));

            PedidoDao pd = new PedidoDao();
            ClienteDao clienteEndereco = new ClienteDao();

            Cliente cliente = clienteEndereco.clientePorCodigo(Long.valueOf(txtcodigoCliente.getText().trim()));

            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setVendedor(new Vendedor(Long.valueOf(txtcodigovendedor.getText().trim())));
            pedido.setItemPedido(listaProdutosDoPedido);

            pedido.setStatus("SALVO");

            pedido.setDataPedido(LocalDate.parse(new DataHora().ler_Data().trim(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            pedido.setDesconto(txtdesconto.getValue());
            pedido.setFrete(txtfrete.getValue());
            pedido.setTotal(txtTotal.getValue());

            pedido.setObs(txtobs.getText());
            pedido.setTipoPedido(txttipopedido.getSelectedItem().toString());
            pedido.setFormaPagto(txtformapgto.getSelectedItem().toString());

            EnderecoEntrega entrega = new EnderecoEntrega();
            if (cliente.getListaEndereco().size() > 2) {
                entrega.setBairro(cliente.getListaEndereco().get(1).getBairro());
                entrega.setCep(cliente.getListaEndereco().get(1).getCep());
                entrega.setCidade(cliente.getListaEndereco().get(1).getCidade());
                entrega.setEnd(cliente.getListaEndereco().get(1).getEndereco());
                entrega.setN(cliente.getListaEndereco().get(1).getNumero());
                entrega.setReferencia(cliente.getListaEndereco().get(1).getReferencia());
                entrega.setUf(cliente.getListaEndereco().get(1).getUf());
                pedido.setEnderecoEntrega(entrega);
            } else {
                entrega.setBairro(cliente.getListaEndereco().get(0).getBairro());
                entrega.setCep(cliente.getListaEndereco().get(0).getCep());
                entrega.setCidade(cliente.getListaEndereco().get(0).getCidade());
                entrega.setEnd(cliente.getListaEndereco().get(0).getEndereco());
                entrega.setN(cliente.getListaEndereco().get(0).getNumero());
                entrega.setReferencia(cliente.getListaEndereco().get(0).getReferencia());
                entrega.setUf(cliente.getListaEndereco().get(0).getUf());
                pedido.setEnderecoEntrega(entrega);
            }

            listaProdutosDoPedido.stream().forEach(i -> i.setPedido(pedido));

            codigoImpressao = pd.salvaPedido(pedido);
            JOptionPane.showMessageDialog(rootPane, "Pedido salvo com sucesso.", "Pedido salvo!", 1);
            btnimprimir.setEnabled(true);

            btnAddproduto.setEnabled(false);
            btndeletePr.setEnabled(false);
            btnsalva.setEnabled(false);
            BTNfechar.setEnabled(false);

            limpaNovoPedido(false);
            cliente = new Cliente();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Informe os Codigos do cliente e do vendedor.", "Atenção erro", 0);
        }
    }//GEN-LAST:event_btnsalvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNfechar;
    private javax.swing.JButton btnAddproduto;
    private javax.swing.JButton btndeletePr;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnsalva;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable tabelapedido;
    private static javax.swing.JLabel totalItens;
    private static Utilitarios.JNumberFormatField txtTotal;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcodigoCliente;
    private javax.swing.JTextField txtcodigovendedor;
    private Utilitarios.JNumberFormatField txtdesconto;
    private javax.swing.JTextField txtemissao;
    private comp.JCalendar txtentrega;
    private javax.swing.JComboBox<String> txtformapgto;
    private Utilitarios.JNumberFormatField txtfrete;
    private javax.swing.JTextField txtnomevendedor;
    private javax.swing.JTextField txtnumeroPedido;
    private javax.swing.JTextArea txtobs;
    private static Utilitarios.JNumberFormatField txtsubtotal;
    private javax.swing.JComboBox<String> txttipopedido;
    // End of variables declaration//GEN-END:variables

}
