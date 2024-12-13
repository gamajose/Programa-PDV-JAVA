package telas;

import Utilitarios.ColorColumnRendererCaixa;
import Utilitarios.DataHora;
import Utilitarios.TableMouseListener;
import repositorio.CaixaDao;
import repositorio.LancamentoDao;
import repositorio.UsuarioDao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Caixa;
import model.CaixaDiario;
import model.Configuracao;
import model.Lancamento;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaMasterCaixa extends javax.swing.JInternalFrame implements ActionListener {

    private static final long serialVersionUID = -6744824270586544322L;
    private static List<BigDecimal> valoresTotaisEntradas = new ArrayList<>();
    private static List<BigDecimal> valoresTotaisSaidas = new ArrayList<>();
    private static NumberFormat format;
    private final TableMouseListener tableListener;

    public TelaMasterCaixa() {
        initComponents();
        mostrarDadosDoCaixa(LocalDate.parse(txtdata.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        setupCaixa();

        tableListener = new TableMouseListener(tabelaCaixa);
        preparaOpenPopupTabela();
        tabelaCaixa.addMouseListener(tableListener);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Remover Lançamento":
                if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {

                    try {
                        long id = Long.parseLong(tabelaCaixa.getValueAt(TableMouseListener
                                .getLinhaSelecionada(), 0)
                                .toString());

                        new LancamentoDao().deletaLancamento(id);
                        mostrarDadosDoCaixa(LocalDate.parse(txtdata.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        JOptionPane.showMessageDialog(rootPane, "Lançamento apagado com sucesso.");

                    } catch (NullPointerException ex) {
                        JOptionPane.showMessageDialog(tabelaCaixa, "Houve um erro, nenhum lançamento encontrado", "Nenhum Lançamento", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
                }
                break;

            case "Modificar Lançamento":
                if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
                    try {
                        long id = Long.parseLong(tabelaCaixa.getValueAt(TableMouseListener
                                .getLinhaSelecionada(), 0)
                                .toString());

                        Lancamento l = new LancamentoDao().getLancamento(id);

                        TelaEditaLancamento te = new TelaEditaLancamento();
                        TelaEditaLancamento.txtvalor.setValue(l.getValor());
                        TelaEditaLancamento.txtobs.setText(l.getDescr());
                        TelaEditaLancamento.txtid.setText(l.getId().toString());
                        te.setVisible(true);

                    } catch (NullPointerException ex) {
                        JOptionPane.showMessageDialog(tabelaCaixa, "Houve um erro, nenhum lançamento encontrado", "Nenhum Lançamento", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
                }
                break;
        }
    }

    public final void preparaOpenPopupTabela() {
        JPopupMenu popupMenu = new JPopupMenu("Operações Disponíveis:");

        JMenuItem menuItemRemove = new JMenuItem("Remover Lançamento", new javax.swing.ImageIcon(getClass().getResource("/imagens/menou.png")));
        JMenuItem menuItemRemoveAll = new JMenuItem("Modificar Lançamento", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));

        menuItemRemove.addActionListener(this);
        menuItemRemoveAll.addActionListener(this);

        popupMenu.add(menuItemRemove);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItemRemoveAll);

        tabelaCaixa.setComponentPopupMenu(popupMenu);
    }

    private void setupCaixa() {
        //Processo de busca e abertura do caixa
        CaixaDao cx = new CaixaDao();
        Caixa c = cx.getCaixaByNome("MASTER-CX");
        c.setStatus("ABERTO");
        txtcodigoCaixa.setText(c.getId().toString());
        txtstatuscaixa.setText(c.getStatus());
        txtstatuscaixa.setForeground(Color.BLUE);

        cx.abrirCaixa(c);
        descCaixa.setModel(new DefaultComboBoxModel<>(new String[]{c.getDescr()}));
    }

    public static void atualizarTabelasLancamentos() {
        mostrarDadosDoCaixa(LocalDate.parse(txtdata.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    }

    public static void mostrarDadosDoCaixa(LocalDate date) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaCaixa.getModel();
        modelo.setNumRows(0);

        Configuracao cf = new Configuracao();

        tabelaCaixa.setDefaultRenderer(Object.class, new ColorColumnRendererCaixa());
        int Counter = 0;

        LancamentoDao lDao = new LancamentoDao();
        Object[] dados = new Object[8];

        BigDecimal saldoanterior = lDao.saldoAnterior(date);

        format = NumberFormat.getCurrencyInstance();

        for (Lancamento f : lDao.listaLancamentosByDate(date)) {

            try {
                dados[0] = String.valueOf(f.getId());
                dados[1] = f.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                dados[2] = f.getHora().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                if (f.getTipo().equals("ENTRADA")) {
                    dados[3] = format.format(f.getValor());
                    valoresTotaisEntradas.add(f.getValor());
                    saldoanterior.add(f.getValor());
                } else {
                    dados[3] = "0,00";
                }

                if (f.getTipo().equals("SAIDA")) {
                    dados[4] = format.format(f.getValor().negate());
                    valoresTotaisSaidas.add(f.getValor());
                    saldoanterior.subtract(f.getValor().negate());//NEGATIVE
                } else {
                    dados[4] = "0,00";
                }

                BigDecimal apoioEntradas = valoresTotaisEntradas.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
                BigDecimal apoioSaidas = valoresTotaisSaidas.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

                if (cf.loadParams("fluxo_acumulado").equals("yes")) {
                    txtsaldoacumulado.setVisible(true);
                    dados[5] = format.format(saldoanterior.add(apoioEntradas).subtract(apoioSaidas));
                    lbacumulado.setText("Total Acumulado:");
                } else {
                    txtsaldoacumulado.setVisible(false);
                    dados[5] = format.format(0);
                    lbacumulado.setText("-");
                }
                dados[6] = f.getDescr();
                dados[7] = f.getResponsavel();

                Counter++;
                modelo.addRow(dados);
            } catch (IOException ex) {
                Logger.getLogger(TelaMasterCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (Counter == 0) {
            String[] dads = new String[2];
            dads[0] = "0";
            dads[1] = "Nenhuma movimentação registrada.";

            modelo.addRow(dados);

        }

        calcularTotais(LocalDate.parse(LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        valoresTotaisEntradas.clear();
        valoresTotaisSaidas.clear();

    }

    public static void calcularTotais(LocalDate date) {
        try {
            LancamentoDao ldao = new LancamentoDao();

            BigDecimal totale = ldao.totalEntradasPorData(date);
            BigDecimal totals = ldao.totalSaidasPorData(date);
            BigDecimal saldoanterior = ldao.saldoAnterior(date);

            txttotalentradas.setValue(totale);
            txttotalsaida.setValue(totals);

            format = NumberFormat.getCurrencyInstance();
            txtxsaldo.setText(format.format(totale.subtract(totals)));

            txtanterior.setText(format.format(saldoanterior));

            Configuracao cf = new Configuracao();
            if (cf.loadParams("fluxo_acumulado").equals("yes")) {
                txtsaldoacumulado.setText(format.format(totale.subtract(totals).add(saldoanterior)));
                lbacumulado.setText("Total Acumulado:");
                lbacumulado.setVisible(true);
                txtsaldoacumulado.setVisible(true);
            } else {
                txtsaldoacumulado.setVisible(false);
                lbacumulado.setVisible(false);
            }

        } catch (IOException ex) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCaixa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtdata = new comp.JCalendar();
        txttotalentradas = new Utilitarios.JNumberFormatField();
        txttotalsaida = new Utilitarios.JNumberFormatField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtxsaldo = new javax.swing.JTextField();
        txtanterior = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtcodigoCaixa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtstatuscaixa = new javax.swing.JLabel();
        txtsaldoacumulado = new javax.swing.JTextField();
        lbacumulado = new javax.swing.JLabel();
        busca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        descCaixa = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFecharCaixa = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Caixa");

        tabelaCaixa.setAutoCreateRowSorter(true);
        tabelaCaixa.setFont(new java.awt.Font("Noto Mono", 0, 11)); // NOI18N
        tabelaCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Data", "Hora", "Entrada R$", "Saida R$", "Valor Atual", "Descrição", "Responsável"
            }
        ));
        tabelaCaixa.setGridColor(new java.awt.Color(248, 255, 255));
        tabelaCaixa.setRowHeight(17);
        jScrollPane1.setViewportView(tabelaCaixa);
        if (tabelaCaixa.getColumnModel().getColumnCount() > 0) {
            tabelaCaixa.getColumnModel().getColumn(0).setMaxWidth(120);
            tabelaCaixa.getColumnModel().getColumn(1).setMinWidth(100);
            tabelaCaixa.getColumnModel().getColumn(1).setMaxWidth(100);
            tabelaCaixa.getColumnModel().getColumn(2).setMaxWidth(100);
            tabelaCaixa.getColumnModel().getColumn(6).setMinWidth(200);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jButton1.setText("Entrada Monetária");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menou.png"))); // NOI18N
        jButton2.setText("Saída Monetária");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtdata.setBackground(new java.awt.Color(255, 255, 204));
        txtdata.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtdataItemStateChanged(evt);
            }
        });
        txtdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdataMouseClicked(evt);
            }
        });
        txtdata.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtdataPropertyChange(evt);
            }
        });

        txttotalentradas.setBackground(new java.awt.Color(204, 255, 204));
        txttotalentradas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txttotalsaida.setBackground(new java.awt.Color(255, 204, 255));
        txttotalsaida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txttotalsaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalsaidaActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Entradas:");

        jLabel2.setText("Total Saidas:");

        jLabel3.setText("Valor Movimentado: ");

        jLabel4.setText("Data do Caixa:");

        jLabel5.setText(" CAIXA:");

        txtanterior.setBackground(new java.awt.Color(203, 235, 235));

        jLabel6.setText("Saldo do dia Anterior:");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtcodigoCaixa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtcodigoCaixa.setText("-");

        jLabel8.setText("STATUS:");

        txtstatuscaixa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtstatuscaixa.setForeground(new java.awt.Color(51, 204, 0));
        txtstatuscaixa.setText("-");

        txtsaldoacumulado.setBackground(new java.awt.Color(255, 255, 204));
        txtsaldoacumulado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lbacumulado.setText("Saldo Acumulado :");

        busca.setBackground(new java.awt.Color(204, 255, 204));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        descCaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("CXID:");

        menuFecharCaixa.setText("Operações");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAVE.png"))); // NOI18N
        jMenuItem1.setText("Fechamento Caixa Diário");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuFecharCaixa.add(jMenuItem1);
        menuFecharCaixa.add(jSeparator1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        jMenuItem2.setText("Resetar Caixa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuFecharCaixa.add(jMenuItem2);
        menuFecharCaixa.add(jSeparator2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-impressão-48.png"))); // NOI18N
        jMenuItem3.setText("Relatório Caixa Diário");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuFecharCaixa.add(jMenuItem3);
        menuFecharCaixa.add(jSeparator4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-conta-24.png"))); // NOI18N
        jMenuItem5.setText("Visualizar Caixa Diario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuFecharCaixa.add(jMenuItem5);

        jMenuBar1.add(menuFecharCaixa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcodigoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstatuscaixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtanterior))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txttotalentradas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txttotalsaida, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbacumulado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtxsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtsaldoacumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtcodigoCaixa)
                            .addComponent(jLabel8)
                            .addComponent(txtstatuscaixa)
                            .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(lbacumulado))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotalentradas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalsaida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtxsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsaldoacumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaLancamentoCaixaEntrada tl = new TelaLancamentoCaixaEntrada(null, closable);
        tl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttotalsaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalsaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalsaidaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaLancamentoCaixaSaida tl = new TelaLancamentoCaixaSaida(null, closable);
        tl.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtdataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtdataItemStateChanged
        //  mostrarDadosDoCaixa(LocalDate.parse(txtdata.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }//GEN-LAST:event_txtdataItemStateChanged

    private void txtdataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtdataPropertyChange
        // mostrarDadosDoCaixa(LocalDate.parse(txtdata.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }//GEN-LAST:event_txtdataPropertyChange

    private void txtdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdataMouseClicked

    }//GEN-LAST:event_txtdataMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        mostrarDadosDoCaixa(LocalDate.parse(txtdata.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        calcularTotais(LocalDate.parse(txtdata.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    }//GEN-LAST:event_jButton4ActionPerformed

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelaCaixa.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelaCaixa.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int opc = JOptionPane.showConfirmDialog(rootPane, "Você confirma o fechamento do Caixa?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            try {
//                DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//                df.setParseBigDecimal(true);

                Caixa cx = new Caixa(Long.parseLong(txtcodigoCaixa.getText().trim()));
                cx.setStatus("FECHADO");
                cx.setDescr(descCaixa.getSelectedItem().toString());

                CaixaDiario cxd = new CaixaDiario();
                cxd.setCaixa(cx);
                cxd.setDataCaixa(LocalDate.now());
                cxd.setHoraFechamento(new DataHora().ler_hora());
                cxd.setResponsavel(TelaMasterApp.txtinfoUser.getText());

                NumberFormat fmt = NumberFormat.getCurrencyInstance();
                Number nsaldo = fmt.parse(txtxsaldo.getText().trim());
                Number ntsac = fmt.parse(txtsaldoacumulado.getText().trim());

                BigDecimal saldo = new BigDecimal(nsaldo.doubleValue());
                BigDecimal total = new BigDecimal(ntsac.doubleValue());

                BigDecimal saidas = txttotalsaida.getValue();
                BigDecimal entradas = txttotalentradas.getValue();

                cxd.setSaldo(saldo);
                cxd.setValorEntradas(entradas);   ///.setScale(2, RoundingMode.HALF_UP); formatação decimal
                cxd.setValorSaida(saidas);
                cxd.setTotal(total);

                new CaixaDao().salvaCaixaDiario(cxd);
                new CaixaDao().fecharCaixa(cx);
                txtstatuscaixa.setForeground(Color.red);

                JOptionPane.showMessageDialog(rootPane, "Caixa Fechado com sucesso!\nData do Caixa: "
                        + new DataHora().ler_Data() + "\nHorário: "
                        + new DataHora().ler_hora() + "\nSaldo: " + fmt.format(saldo), "Confirmado", 1);

            } catch (ParseException ex) {
                Logger.getLogger(TelaMasterCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaCaixaDiario tl = new TelaCaixaDiario();
        tl.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new CaixaDao().resetCaixa();
        mostrarDadosDoCaixa(LocalDate.parse(txtdata.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        JOptionPane.showMessageDialog(rootPane, "Caixa Resetado com sucesso!", "Confirmado", 1);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaPeriodoRelatorioCaixa tp = new TelaPeriodoRelatorioCaixa();
        tp.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JComboBox<String> descCaixa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private static javax.swing.JLabel lbacumulado;
    private javax.swing.JMenu menuFecharCaixa;
    private static javax.swing.JTable tabelaCaixa;
    private static javax.swing.JTextField txtanterior;
    private javax.swing.JLabel txtcodigoCaixa;
    public static comp.JCalendar txtdata;
    private static javax.swing.JTextField txtsaldoacumulado;
    private javax.swing.JLabel txtstatuscaixa;
    private static Utilitarios.JNumberFormatField txttotalentradas;
    private static Utilitarios.JNumberFormatField txttotalsaida;
    private static javax.swing.JTextField txtxsaldo;
    // End of variables declaration//GEN-END:variables

}
