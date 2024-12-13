package telas;

import Utilitarios.ColorColumnRenderer;
import repositorio.ContaDao;
import repositorio.CrediarioDao;
import repositorio.LancamentoDao;
import repositorio.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Conta;
import model.Crediario;
import model.Pagamento;

/**
 *
 * @author deibi
 */
public class TelaContas extends javax.swing.JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1654881163775415398L;
    private JMenuItem menuItemStatusPagamento;
    private JMenuItem menuItemStatusRecebimento;

    /**
     * Creates new form TelaContas
     */
    public TelaContas() {
        initComponents();

        splite.setDividerLocation(this.getHeight() / 2 - 20);

        mostrarContasReceber();
        mostrarContasPagar();

        preparaOpenPopupTabela();

        //seta os totais
        NumberFormat format = DecimalFormat.getCurrencyInstance();
        calculaTotais();
        txttotalCaixa.setText(format.format(new LancamentoDao().total()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        long id = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (tabelaPagar.isFocusable()) {
            id = Long.parseLong(tabelaPagar.getValueAt(tabelaPagar.getSelectedRow(), 0)
                    .toString());

        } else if (tabelareceber.isFocusable()) {
            id = Long.parseLong(tabelareceber.getValueAt(tabelareceber.getSelectedRow(), 0)
                    .toString());
        }

        switch (e.getActionCommand()) {
            case "Deletar Conta":
                System.out.println(id);
                if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
                    if (tabelaPagar.isFocusable()) {
                        new ContaDao().deletaConta(id);
                        mostrarContasPagar();
                        mostrarContasReceber();
                        calculaTotais();
                    } else {
                        if (!tabelareceber.getValueAt(tabelareceber.getSelectedRow(), 5).equals("CREDIARIO")) {
                            new ContaDao().deletaConta(id);
                            mostrarContasPagar();
                            mostrarContasReceber();
                            calculaTotais();
                            System.out.println("ENTROU PARA EXCLUIR CONTA NÃO CREDIARIO");
                        } else {

                            new CrediarioDao().deleteCrediarioByContaId(id);
                            mostrarContasPagar();
                            mostrarContasReceber();
                            //new ContaDao().deletaConta(id);

                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
                }
                break;

            case "Informar Recebimento":
                Conta c1 = new ContaDao().getContaById(id);
                c1.setStatus("RECEBIDA");
                c1.setPagamento(LocalDate.parse(LocalDate.now().format(formatter), formatter));

                new ContaDao().salva(c1);

                Crediario crediario = new CrediarioDao().getCrediarioByConta(c1);
                Pagamento pagamento = new Pagamento();
                pagamento.setCrediario(crediario);
                pagamento.setValor(c1.getValor());
                pagamento.setData(LocalDate.now());
                crediario.getPagamentos().add(pagamento);
                new CrediarioDao().saveCrediario(crediario);

                mostrarContasReceber();
                calculaTotais();
                break;
            case "Informar Pagamento":
                Conta c2 = new ContaDao().getContaById(id);
                c2.setStatus("QUITADA");
                c2.setPagamento(LocalDate.parse(LocalDate.now().format(formatter), formatter));
                new ContaDao().salva(c2);
                mostrarContasPagar();
                calculaTotais();
                break;

        }
    }

    public final void preparaOpenPopupTabela() {
        JPopupMenu popupMenu = new JPopupMenu("Operações Disponíveis:");

        JMenu menuItemStatus = new JMenu("Alterar Status da Conta");
        menuItemStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));

        JMenuItem menuItemRemove = new JMenuItem("Deletar Conta", new javax.swing.ImageIcon(getClass().getResource("/imagens/menou.png")));

        menuItemStatusPagamento = new JMenuItem("Informar Pagamento", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));
        menuItemStatusRecebimento = new JMenuItem("Informar Recebimento", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));

        menuItemStatus.add(menuItemStatusRecebimento);
        menuItemStatus.add(menuItemStatusPagamento);

        menuItemRemove.addActionListener(this);
        menuItemStatusRecebimento.addActionListener(this);
        menuItemStatusPagamento.addActionListener(this);

        popupMenu.add(menuItemRemove);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItemStatus);

        tabelaPagar.setComponentPopupMenu(popupMenu);
        tabelareceber.setComponentPopupMenu(popupMenu);
    }

    private void calculaTotais() {
        ContaDao cd = new ContaDao();
        NumberFormat format = DecimalFormat.getCurrencyInstance();
        totalPagar.setText(format.format(cd.getTotalPagar()));
        totalReceber.setText(format.format(cd.getTotalReceber()));
    }

    public static void mostrarContasReceber() {
        DefaultTableModel modelo = (DefaultTableModel) tabelareceber.getModel();
        modelo.setNumRows(0);

        tabelareceber.setDefaultRenderer(Object.class, new ColorColumnRenderer());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        List<Conta> contasReceber = new ContaDao().listaReceber();

        int Counter = 0;
        Object[] dados = new String[10];
        for (Conta c : contasReceber) {

            dados[0] = String.valueOf(c.getId());
            dados[1] = c.getTitulo();
            dados[2] = c.getVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dados[3] = formatter.format(c.getValor());
            dados[4] = c.getDocNumero();
            dados[5] = c.getBanco();

            if (c.getPagamento() != null) {
                dados[8] = c.getPagamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } else {
                dados[8] = "";
            }

            dados[6] = String.valueOf(c.getParcelas()) + "°";
            dados[7] = c.getCendente();
            dados[9] = c.getStatus();

            Counter++;
            modelo.addRow(dados);
        }
        if (Counter == 0) {

            dados[1] = "Nenhuma conta a receber cadastrada. ";
            modelo.addRow(dados);
        }

    }

    public static void mostrarContasPagar() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaPagar.getModel();
        modelo.setNumRows(0);

        tabelaPagar.setDefaultRenderer(Object.class, new ColorColumnRenderer());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        List<Conta> contasReceber = new ContaDao().listaRPagar();

        int Counter = 0;
        Object[] dados = new String[10];
        for (Conta c : contasReceber) {

            dados[0] = String.valueOf(c.getId());
            dados[1] = c.getTitulo();
            dados[2] = c.getVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dados[4] = String.valueOf(c.getParcelas()) + "°";
            dados[3] = formatter.format(c.getValor());
            dados[5] = c.getCendente();
            dados[6] = c.getDocNumero();
            dados[7] = c.getBanco();

            if (c.getPagamento() != null) {
                dados[8] = c.getPagamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } else {
                dados[8] = "";
            }
            dados[9] = c.getStatus();

            Counter++;
            modelo.addRow(dados);
        }
        if (Counter == 0) {

            dados[1] = "Nenhuma conta a pagar cadastrada. ";
            modelo.addRow(dados);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        txttotalCaixa = new javax.swing.JLabel();
        jCalendar1 = new comp.JCalendar();
        jButton3 = new javax.swing.JButton();
        splite = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelareceber = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtbusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalReceber = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txtbusca2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPagar = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        totalPagar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Contas a Pagar e Receber");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-dinheiro-24.png"))); // NOI18N

        jLabel11.setText("CAIXA:");

        txttotalCaixa.setBackground(new java.awt.Color(0, 51, 102));
        txttotalCaixa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txttotalCaixa.setForeground(new java.awt.Color(0, 51, 102));
        txttotalCaixa.setText("0.00");

        jButton3.setText("Ok");

        splite.setDividerLocation(250);
        splite.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        tabelareceber.setAutoCreateRowSorter(true);
        tabelareceber.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabelareceber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIÇÃO", "VENCIMENTO", "VALOR", "DOC N", "EMISSOR", "PARCELA", "DEVEDOR", "DATA RECEB.", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelareceber.setGridColor(new java.awt.Color(204, 204, 204));
        tabelareceber.setRowHeight(20);
        tabelareceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelareceberMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelareceber);
        if (tabelareceber.getColumnModel().getColumnCount() > 0) {
            tabelareceber.getColumnModel().getColumn(0).setMaxWidth(120);
            tabelareceber.getColumnModel().getColumn(1).setMinWidth(220);
            tabelareceber.getColumnModel().getColumn(2).setMinWidth(145);
            tabelareceber.getColumnModel().getColumn(2).setMaxWidth(150);
            tabelareceber.getColumnModel().getColumn(3).setMinWidth(125);
            tabelareceber.getColumnModel().getColumn(3).setMaxWidth(160);
            tabelareceber.getColumnModel().getColumn(6).setMaxWidth(80);
            tabelareceber.getColumnModel().getColumn(8).setResizable(false);
            tabelareceber.getColumnModel().getColumn(9).setMinWidth(120);
            tabelareceber.getColumnModel().getColumn(9).setMaxWidth(125);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscaKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        jLabel3.setText("TOTAL A RECEBER:");

        totalReceber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalReceber.setForeground(new java.awt.Color(0, 51, 102));
        totalReceber.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(205, 205, 205)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalReceber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(totalReceber)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONTAS A RECEBER", jPanel1);

        splite.setBottomComponent(jTabbedPane1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtbusca2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusca2KeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jLabel2.setToolTipText("");

        tabelaPagar.setAutoCreateRowSorter(true);
        tabelaPagar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabelaPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIÇÃO", "VENCIMENTO", "VALOR", "PARCELA", "CEDENTE", "DOC N°", "EMISSOR", "DATA PGTO", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPagar.setGridColor(new java.awt.Color(230, 225, 225));
        tabelaPagar.setRowHeight(20);
        tabelaPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPagarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPagar);
        if (tabelaPagar.getColumnModel().getColumnCount() > 0) {
            tabelaPagar.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelaPagar.getColumnModel().getColumn(1).setMinWidth(220);
            tabelaPagar.getColumnModel().getColumn(4).setMaxWidth(100);
            tabelaPagar.getColumnModel().getColumn(5).setMinWidth(180);
        }

        jLabel7.setText("TOTAL A PAGAR:");

        totalPagar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalPagar.setForeground(new java.awt.Color(0, 51, 153));
        totalPagar.setText("0.00");

        jLabel9.setText("VENCIDAS:");

        jLabel10.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(207, 207, 207)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPagar)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(txtbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(totalPagar)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("CONTAS A PAGAR", jPanel2);

        splite.setLeftComponent(jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotalCaixa)
                .addGap(735, 735, 735))
            .addGroup(layout.createSequentialGroup()
                .addComponent(splite)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(splite)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txttotalCaixa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LancamentoContas lc = new LancamentoContas(null, closable);
        LancamentoContas.tipo.setSelectedIndex(1);
        LancamentoContas.tipo.setEnabled(false);
        lc.setVisible(true);
        calculaTotais();

        mostrarContasPagar();
        mostrarContasReceber();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrarContasPagar();
        mostrarContasReceber();

        LancamentoContas lc = new LancamentoContas(null, closable);
        LancamentoContas.tipo.setSelectedIndex(0);
        LancamentoContas.tipo.setEnabled(false);
        lc.setVisible(true);

        calculaTotais();
        mostrarContasPagar();
        mostrarContasReceber();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtbuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelareceber.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelareceber.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtbusca.getText().toUpperCase()));
    }//GEN-LAST:event_txtbuscaKeyTyped

    private void txtbusca2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusca2KeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelaPagar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelaPagar.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtbusca2.getText().toUpperCase()));
    }//GEN-LAST:event_txtbusca2KeyTyped

    private void tabelaPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPagarMouseClicked
        tabelareceber.setFocusable(false);
        tabelaPagar.setFocusable(true);

        if (tabelaPagar.isFocusable()) {
            menuItemStatusRecebimento.setEnabled(false);
            menuItemStatusPagamento.setEnabled(true);
        } else if (tabelareceber.isFocusable()) {
            menuItemStatusPagamento.setEnabled(false);
            menuItemStatusRecebimento.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaPagarMouseClicked

    private void tabelareceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelareceberMouseClicked
        if (evt.getClickCount() > 1) {
            TelaDetalheCrediario detalheCrediario = new TelaDetalheCrediario(null, closable);
            TelaDetalheCrediario.contaID = (tabelareceber.getValueAt(tabelareceber.getSelectedRow(), 0).toString());
            TelaDetalheCrediario.mostraPagamento(tabelareceber.getValueAt(tabelareceber.getSelectedRow(), 7).toString());
            detalheCrediario.setVisible(true);
        } else {
            tabelaPagar.setFocusable(false);

            tabelareceber.setFocusable(true);

            if (tabelaPagar.isFocusable()) {
                menuItemStatusRecebimento.setEnabled(false);
                menuItemStatusPagamento.setEnabled(true);
            } else if (tabelareceber.isFocusable()) {
                menuItemStatusPagamento.setEnabled(false);
                menuItemStatusRecebimento.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tabelareceberMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private comp.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JSplitPane splite;
    private static javax.swing.JTable tabelaPagar;
    private static javax.swing.JTable tabelareceber;
    private javax.swing.JLabel totalPagar;
    private javax.swing.JLabel totalReceber;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtbusca2;
    private javax.swing.JLabel txttotalCaixa;
    // End of variables declaration//GEN-END:variables

}
