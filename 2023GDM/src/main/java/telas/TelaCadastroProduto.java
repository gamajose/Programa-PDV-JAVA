package telas;

import Utilitarios.LeitorProdutoXmlFile;
import Utilitarios.TableMouseListener;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.parsers.ParserConfigurationException;
import model.Categoria;
import model.Estoque;
import model.Fornecedor;
import model.Produto;
import org.xml.sax.SAXException;
import repositorio.CategoriaDao;
import repositorio.EstoqueDao;
import repositorio.FornecedorDao;
import repositorio.ProdutoDao;
import repositorio.UsuarioDao;

public class TelaCadastroProduto extends javax.swing.JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1356945613805351273L;
    private Categoria ctg;
    private final TableMouseListener tableListener;
    private static String fotopath = "";

    public TelaCadastroProduto() {

        initComponents();
        mostrarProdutos();

        tableListener = new TableMouseListener(tabelaProdutos);
        tabelaProdutos.addMouseListener(tableListener);
        preparaOpenPopupTabela();

        btnadd.setEnabled(false);
        txtcomissao.setValue(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desc = new javax.swing.JTextField();
        codigobarras = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdimensao = new javax.swing.JFormattedTextField();
        peso = new javax.swing.JFormattedTextField();
        capacidade = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        categoria = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        txtbusca = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pcusto = new Utilitarios.JNumberFormatField();
        pvenda = new Utilitarios.JNumberFormatField();
        txtreferencia = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnAtualiza = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtajuste = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        validade = new javax.swing.JFormattedTextField();
        txtfabricacao = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        qtdeinicial = new javax.swing.JTextField();
        qtdeminima = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        localizacao = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        unidade = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ncm = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        fornecedor = new javax.swing.JComboBox<>();
        btnFornecedor = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtfoto = new javax.swing.JLabel();
        txtcomissao = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        cor = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Produtos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-canais-de-distribuição-24.png"))); // NOI18N

        desc.setBackground(new java.awt.Color(204, 255, 204));
        desc.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        codigobarras.setBackground(new java.awt.Color(204, 255, 255));
        codigobarras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        marca.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel1.setText("Nome do Produto:");

        jLabel2.setText("Preço de Custo:");

        jLabel3.setText("Marca / Fabricante:");

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        btnadd.setText("Cadastrar");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clean.png"))); // NOI18N
        jButton2.setText("Novo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dimensões/Peso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jLabel4.setText("AxLxP");

        jLabel7.setText("Peso: Kg");

        try {
            txtdimensao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##x##x##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        peso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0"))));

        jLabel19.setText("Capacidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtdimensao, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(capacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel19))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdimensao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel8.setText("Categoria:");

        obs.setBackground(new java.awt.Color(255, 255, 204));
        obs.setColumns(20);
        obs.setLineWrap(true);
        obs.setRows(2);
        obs.setTabSize(2);
        obs.setWrapStyleWord(true);
        jScrollPane1.setViewportView(obs);

        jLabel9.setText("Observações:");

        jLabel16.setText("Preço de Venda:");

        jLabel17.setText("Codigo de Barras:");

        categoria.setEditable(true);
        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...." }));
        categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoriaMouseClicked(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N

        tabelaProdutos.setAutoCreateRowSorter(true);
        tabelaProdutos.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Referência", "Preço", "Marca", "Categoria", "Estoque", "Fornecedor", "Status"
            }
        ));
        tabelaProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabelaProdutos.setGridColor(new java.awt.Color(241, 236, 245));
        tabelaProdutos.setRowHeight(19);
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaProdutos);
        if (tabelaProdutos.getColumnModel().getColumnCount() > 0) {
            tabelaProdutos.getColumnModel().getColumn(0).setMinWidth(40);
            tabelaProdutos.getColumnModel().getColumn(0).setMaxWidth(60);
            tabelaProdutos.getColumnModel().getColumn(1).setMinWidth(240);
            tabelaProdutos.getColumnModel().getColumn(3).setMinWidth(100);
            tabelaProdutos.getColumnModel().getColumn(3).setMaxWidth(12);
            tabelaProdutos.getColumnModel().getColumn(4).setMinWidth(110);
            tabelaProdutos.getColumnModel().getColumn(6).setMinWidth(70);
            tabelaProdutos.getColumnModel().getColumn(6).setMaxWidth(90);
            tabelaProdutos.getColumnModel().getColumn(7).setMinWidth(120);
            tabelaProdutos.getColumnModel().getColumn(8).setMinWidth(90);
            tabelaProdutos.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Produtos Cadastrados", new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-canais-de-distribuição-24.png")), jPanel4); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton4.setToolTipText("Adicionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtbusca.setBackground(new java.awt.Color(255, 255, 204));
        txtbusca.setText("Buscar...");
        txtbusca.setToolTipText("Encontrar um produto");
        txtbusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbuscaFocusGained(evt);
            }
        });
        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscaKeyTyped(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        pcusto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pcusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pcustoFocusLost(evt);
            }
        });
        pcusto.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pcustoPropertyChange(evt);
            }
        });

        pvenda.setBackground(new java.awt.Color(204, 255, 204));
        pvenda.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel22.setText("Referencia:");

        btnAtualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sincronizar-24.png"))); // NOI18N
        btnAtualiza.setText("Atualizar");
        btnAtualiza.setEnabled(false);
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        jButton6.setText("Deletar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel23.setText("Ajuste: %");

        txtajuste.setBackground(new java.awt.Color(204, 255, 255));
        txtajuste.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtajuste.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtajuste.setText("0.0");
        txtajuste.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtajusteFocusLost(evt);
            }
        });

        jLabel13.setText("Validade:");

        validade.setBackground(new java.awt.Color(255, 204, 204));
        try {
            validade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtfabricacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Fabricação:");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estoque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(51, 153, 255));

        jLabel10.setText("Inicial:");

        qtdeinicial.setBackground(new java.awt.Color(255, 255, 204));
        qtdeinicial.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N

        qtdeminima.setBackground(new java.awt.Color(255, 204, 204));
        qtdeminima.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N

        jLabel11.setText("Minimo:");

        jLabel14.setText("Localização:");

        jLabel20.setText("Unidade:");

        unidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CX", "UND", "CX25", "CX50", "CX100", "KG", "KIT", "LITRO", "LATA", "ML", "PC", "VIDRO", "TUBO", "SACOS", "PARES" }));
        unidade.setSelectedIndex(1);
        unidade.setToolTipText("");

        jLabel15.setText("Status:");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponivel", "Em Falta", "Pedido", "Indisponivel", "" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(qtdeinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(qtdeminima, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(localizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(localizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qtdeinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtdeminima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(1, 1, 1)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel6.setText("Cor:");

        ncm.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel18.setText("NCM:");

        fornecedor.setEditable(true);
        fornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));

        btnFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        btnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorActionPerformed(evt);
            }
        });

        jLabel12.setText("Fornecedor:");

        txtfoto.setBackground(new java.awt.Color(255, 255, 255));
        txtfoto.setForeground(new java.awt.Color(0, 102, 102));
        txtfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtfoto.setText("Selecione aqui..");
        txtfoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto do Produto"));
        txtfoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtfoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtfoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfotoMouseClicked(evt);
            }
        });

        txtcomissao.setBackground(new java.awt.Color(255, 255, 204));
        txtcomissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0"))));
        txtcomissao.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel24.setText("Comissão: %");

        cor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "PRETO", "BRANCO", "AZUL", "CINZA", "MARRON", "VERMELHO", "AMARELHO", "ROSA", "LARANJA", "BEGE", "VERDE", " " }));

        jMenu1.setText("Opções");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-baixar-atualizações-24.png"))); // NOI18N
        jMenuItem1.setText("Importar de Arquivo XML NFe");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(txtreferencia))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(validade, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtfabricacao))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(ncm, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(codigobarras, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(pcusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcomissao)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(pvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel21)
                .addGap(101, 101, 101)
                .addComponent(jButton6)
                .addGap(2, 2, 2)
                .addComponent(btnAtualiza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(2, 2, 2)
                .addComponent(btnadd)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(146, 146, 146))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel8))
                                        .addGap(0, 0, 0)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel12)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel17))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(validade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ncm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codigobarras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(31, 31, 31))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24))
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcomissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualiza)
                        .addComponent(jButton6))
                    .addComponent(txtbusca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnadd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Indisponivel":
                try {
                long id = Long.parseLong(tabelaProdutos.getValueAt(TableMouseListener
                        .getLinhaSelecionada(), 0)
                        .toString());

                ProdutoDao p = new ProdutoDao();
                p.alteraStatus(id, "Indisponivel");

                JOptionPane.showMessageDialog(rootPane, "Status modificado com sucesso.");
                mostrarProdutos();
                break;
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(tabelaProdutos, "Houve um erro, nenhum lançamento encontrado", "Nenhum Lançamento", 0);
            }

            case "Disponivel":
                try {
                long id = Long.parseLong(tabelaProdutos.getValueAt(TableMouseListener
                        .getLinhaSelecionada(), 0)
                        .toString());

                ProdutoDao p = new ProdutoDao();
                p.alteraStatus(id, "Disponivel");

                JOptionPane.showMessageDialog(rootPane, "Status modificado com sucesso.");
                mostrarProdutos();
                break;
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(tabelaProdutos, "Houve um erro, nenhum lançamento encontrado", "Nenhum Lançamento", 0);
            }

            case "Pedido":
                try {
                long id = Long.parseLong(tabelaProdutos.getValueAt(TableMouseListener
                        .getLinhaSelecionada(), 0)
                        .toString());

                ProdutoDao p = new ProdutoDao();
                p.alteraStatus(id, "Pedido");

                JOptionPane.showMessageDialog(rootPane, "Status modificado com sucesso.");
                mostrarProdutos();
                break;
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(tabelaProdutos, "Houve um erro, nenhum lançamento encontrado", "Nenhum Lançamento", 0);
            }

            case "Alterar Estoque":
                try {
                long id = Long.parseLong(tabelaProdutos.getValueAt(TableMouseListener
                        .getLinhaSelecionada(), 0)
                        .toString());

                Produto p = new EstoqueDao().estoqueByCodigoProduto(id);

                TelaConsultaEstoque tc = new TelaConsultaEstoque();
                tc.getProdutoComEstoque(p.getCodigo());
                tc.setVisible(true);

                System.out.println(p.getCodigo());

                break;
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(tabelaProdutos, "Houve um erro, nenhum produto encontrado", "Nenhum Cadastro", 0);
            }

            case "Vender Produto":
                long id = Long.parseLong(tabelaProdutos.getValueAt(TableMouseListener
                        .getLinhaSelecionada(), 0)
                        .toString());

                JInternalFrame[] frames = TelaMasterApp.getDisplay().getAllFrames();
                for (JInternalFrame frame : frames) {

                    if (frame.getTitle().equals("GDM-PDV")) {

                        TelaMasterVenda.txtcodigo.setText(String.valueOf(id).trim());

                        frame.setVisible(true);
                        frame.toFront();

                        TelaMasterVenda.txtcodigo.requestFocus();
                    } else {
                        TelaMasterApp.btnAbrePdv.doClick();
                        TelaMasterVenda.txtcodigo.setText(String.valueOf(id).trim());
                        TelaMasterVenda.txtdesc.setText("TECLE ENTER P/ CONFIRMAR");

                    }
                }

//                TelaMasterVenda masterVenda = TelaMasterApp.getTelaMadsterVendaPDV();
//
//                if (!masterVenda.isVisible()) {
//                    masterVenda.setVisible(true);
//                }else{
//                    TelaMasterApp.getDisplay().add(masterVenda);
//                    TelaMasterVenda.txtcodigo.setText(String.valueOf(id).trim());
//                    masterVenda.setVisible(true);
//                }
                // Dimension desktopSize = TelaMasterApp.getDisplay().getSize();
                //Dimension screenSize = masterVenda.getSize();
                // masterVenda.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
                break;

        }
    }

    public final void preparaOpenPopupTabela() {
        JPopupMenu popupMenu = new JPopupMenu("Operações Disponíveis:");

        JMenu menuItemStatus = new JMenu("Alterar Status");
        menuItemStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));

        JMenuItem menuItemRemove = new JMenuItem("Alterar Estoque", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));
        JMenuItem menuItemVenda = new JMenuItem("Vender Produto", new javax.swing.ImageIcon(getClass().getResource("/imagens/FLUXO.png")));

        JMenuItem menuItemStatusIdisponivel = new JMenuItem("Indisponivel", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));
        JMenuItem menuItemStatusDisponivel = new JMenuItem("Disponivel", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));
        JMenuItem menuItemStatusPedido = new JMenuItem("Pedido", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));

        menuItemStatus.add(menuItemStatusDisponivel);
        menuItemStatus.add(menuItemStatusIdisponivel);
        menuItemStatus.add(menuItemStatusPedido);

        menuItemVenda.addActionListener(this);
        menuItemRemove.addActionListener(this);
        menuItemStatusDisponivel.addActionListener(this);
        menuItemStatusPedido.addActionListener(this);
        menuItemStatusIdisponivel.addActionListener(this);

        popupMenu.add(menuItemRemove);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItemStatus);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItemVenda);

        tabelaProdutos.setComponentPopupMenu(popupMenu);
    }

    public static void mostrarProdutos() {

        DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
        modelo.setNumRows(0);

        NumberFormat format = DecimalFormat.getCurrencyInstance();

        int Counter = 0;

        ProdutoDao pDao = new ProdutoDao();
        for (Produto p : pDao.listaProdutos()) {

            Object[] dados = new Object[9];

            dados[0] = String.valueOf(p.getCodigo());
            dados[1] = p.getDescricao().toUpperCase();
            dados[2] = p.getReferencia().toUpperCase();
            dados[3] = String.valueOf(format.format(p.getPreco()));
            dados[4] = p.getMarca().toUpperCase();
            dados[5] = p.getCategoria().getNome().toUpperCase();
            dados[6] = p.getEstoque().getQtdeDisponivel();
            dados[7] = p.getFornecedor().getPessoaJuridica().getRazaosocial();
            dados[8] = p.getEstoque().getStatus();

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

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        if (qtdeinicial.getText().equals("") || qtdeinicial.getText().equals("0") || qtdeminima.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Insira informações sobre estoque deste produto", "Estoque não informado", 0);
            qtdeinicial.requestFocus();
        } else if (desc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Insira o nome do produto", "Nome não informado", 0);
            desc.requestFocus();
        } else if (pvenda.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o PREÇO do produto", "Preço de Venda não informado", 0);
            pvenda.requestFocus();
        } else if (categoria.getSelectedItem().toString().equals("Categoria não cadastrada")) {
            JOptionPane.showMessageDialog(rootPane, "Crie uma CATEGORIA para o produto\nEx: Medicamentos, Info etc..", "Sem Categoria criada", 0);
            categoria.requestFocus();
        } else if (fornecedor.getSelectedItem().toString().equals("Nenhum Fornecedor cadastrado")) {
            int opc = JOptionPane.showConfirmDialog(rootPane, "Cadastre um FORNECEDOR para o produto\n"
                    + "Não é possivel cadastrar um produto sem seu fornecedor selecionado.\n\nDeseja cadastrar agora?", "Nenhum Fornecedor cadastrado", JOptionPane.YES_NO_OPTION);

            if (opc == 0) {
                btnFornecedor.doClick();
            }

        } else {
            try {

                Produto produto = new Produto();
                Estoque estoque = new Estoque();

                //-------------------------------------categoria----------------------------//
                try {
                    ctg = CategoriaDao.categoriaByNome(categoria.getSelectedItem().toString());
                    produto.setCategoria(ctg);

                } catch (NoResultException e) {
                    ctg = new Categoria();
                    ctg.setNome(categoria.getSelectedItem().toString());
                    CategoriaDao.salvaCategoria(ctg);
                    produto.setCategoria(ctg);
                }

                //-------------------------------------fornecedor----------------------------//
                if (!fornecedor.getSelectedItem().toString().trim().equals("Nenhum Fornecedor cadastrado")) {
                    Fornecedor fdo = new FornecedorDao().
                            fornecedorByNome(fornecedor.getSelectedItem().toString().toUpperCase().trim());
                    produto.setFornecedor(fdo);
                } else {
                    produto.setFornecedor(null);
                }

                //-------------------------------------produto----------------------------//
                produto.setDescricao(desc.getText().toUpperCase().replaceAll("Ê", "E"));
                produto.setMarca(marca.getText());
                produto.setPreco(pvenda.getValue());
                produto.setPrecoCusto(pcusto.getValue());
                produto.setDimensao(txtdimensao.getText());
                produto.setFabricao(txtfabricacao.getText());

                // txtajuste.getText().replace("%", "").replace(",", ".").trim();
                // NumberFormat format = NumberFormat.getInstance();
                produto.setComissao(Double.parseDouble(String.valueOf(txtcomissao.getValue())));

                produto.setObs(obs.getText());
                produto.setCapacidade(capacidade.getText());
                if (peso.getValue() != null) {
                    produto.setPeso(((Number) peso.getValue()).doubleValue());
                } else {
                    produto.setPeso(0.0);
                }
                produto.setReferencia(txtreferencia.getText());
                produto.setEstoque(estoque);
                produto.setCodigoBarras(codigobarras.getText().trim());
                produto.setCor(cor.getSelectedItem().toString());

                //foto produto                
                if (!"".equals(fotopath)) {
                    javaxt.io.Image image = new javaxt.io.Image(fotopath);
                    image.resize(164, 120);

                    produto.setFoto(fotopath);
                }

                //-------------------------------------estoque----------------------------//
                List<Produto> lista = new ArrayList<>();
                lista.add(produto);
                estoque.setMinimo(Integer.parseInt(qtdeminima.getText()));
                estoque.setProdutos(lista);
                estoque.setQtdeDisponivel(Integer.parseInt(qtdeinicial.getText()));
                estoque.setStatus(status.getSelectedItem().toString());

                if (validade.getText().equals("  /  /    ")) {
                    estoque.setValidade(LocalDate.of(2099, 12, 30));
                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    estoque.setValidade(LocalDate.parse(validade.getText().trim(), formatter));
                }

                estoque.setUnidade(unidade.getSelectedItem().toString());
                estoque.setLocalizaco(localizacao.getText());

                //-------------------------------------persistencia----------------------------//
                EstoqueDao estoqueDao = new EstoqueDao();
                estoqueDao.saveEstoque(estoque);

                JOptionPane.showMessageDialog(rootPane, "Cadastro efetuado com Sucesso");
                btnadd.setEnabled(false);
                btnAtualiza.setEnabled(false);

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println(e.getMessage() + e.getCause());
            } finally {
                mostrarProdutos();

            }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    public static void setaCategorias() {
        List<Categoria> listaCategirias = CategoriaDao.getAllCategorias();

        String[] cgs = new String[listaCategirias.size()];

        try {

            if (!listaCategirias.isEmpty()) {

                for (int i = 0; i < listaCategirias.size(); i++) {
                    cgs[i] = listaCategirias.get(i).getNome().toUpperCase();
                }
            } else {
                cgs[0] = "";
            }
            categoria.setModel(new DefaultComboBoxModel<>(cgs));
        } catch (Exception e) {
            cgs[0] = "";
        }

    }

    public static void setaFornecedoresBox() {
        if (FornecedorDao.verificaSeExistiFornecedorCadastrado() == true) {

            FornecedorDao fornecedorDao = new FornecedorDao();
            List<Fornecedor> listaFnd = fornecedorDao.listaFornecedores();
            String[] cgs = new String[listaFnd.size()];

            if (!listaFnd.isEmpty()) {
                for (int i = 0; i < listaFnd.size(); i++) {
                    cgs[i] = listaFnd.get(i).getPessoaJuridica().getRazaosocial().toUpperCase();
                }
            } else {
                cgs[0] = "";
            }

            fornecedor.setModel(new DefaultComboBoxModel<>(cgs));

        } else {
            TelaCadastroProduto.fornecedor.setModel(
                    new DefaultComboBoxModel<>(new String[]{"Nenhum Fornecedor cadastrado"}));
        }
    }

    private void categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaCategoria tc = new TelaCategoria(null, rootPaneCheckingEnabled);
        tc.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorActionPerformed
        try {
            TelaCadastroFornecedor cf = new TelaCadastroFornecedor();
            TelaMasterApp.getDisplay().add(cf);
            cf.setVisible(true);
            cf.setRequestFocusEnabled(true);

            Dimension desktopSize = this.getSize();
            Dimension screenSize = cf.getSize();
            cf.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            TelaCadastroFornecedor.atualizarBoxTelaProduto = true;
            cf.setSelected(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnFornecedorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtajuste.setText("0");
        obs.setText("");
        desc.setText("");
        marca.setText("");
        txtreferencia.setText("");
        codigobarras.setText("");
        pvenda.setValue(BigDecimal.ZERO);
        pcusto.setValue(BigDecimal.ZERO);
        qtdeinicial.setText("");
        qtdeminima.setText("1");
        cor.setSelectedIndex(0);
        btnadd.setEnabled(true);
        capacidade.setText("");
        mostrarProdutos();
        mostrarFotoNoPainel(null);
        txtcomissao.setValue(0);
        
        desc.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtbuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelaProdutos.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelaProdutos.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtbusca.getText().toUpperCase()));
    }//GEN-LAST:event_txtbuscaKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
                int linha = tabelaProdutos.getSelectedRow();
                long codigoEstoque = Long.parseLong(tabelaProdutos.getValueAt(linha, 0).toString().trim());

                ProdutoDao pd = new ProdutoDao();

                pd.deleteProduto(codigoEstoque);

                mostrarProdutos();
                btnAtualiza.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Produto relacionado com outras funções no sistema (Vendas)", "Não é possivel apagar", 0);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtajusteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtajusteFocusLost
        String replace = null;

        if (!txtajuste.getText().trim().equals("") && !pcusto.getValue().equals(0)) {

            if (txtajuste.getText().contains("%") || txtajuste.getText().contains(",")) {
                replace = txtajuste.getText().replace("%", "").replace(",", ".").trim();

                pvenda.setValue(pcusto.getValue()
                        .multiply(new BigDecimal(replace))
                        .divide(new BigDecimal(100)).add(pcusto.getValue()));

            } else {
                pvenda.setValue(pcusto.getValue()
                        .multiply(new BigDecimal(txtajuste.getText().trim()))
                        .divide(new BigDecimal(100)).add(pcusto.getValue()));
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o valor de custo do produto", "Atenção", 0);
        }

        //System.out.println(replace);
    }//GEN-LAST:event_txtajusteFocusLost

    private void pcustoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pcustoPropertyChange
//        if(evt.getSource() == pcusto){
//            System.out.println("valor alterado");
//        }
    }//GEN-LAST:event_pcustoPropertyChange

    private void pcustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pcustoFocusLost
        String replace = null;

        if (!txtajuste.getText().trim().equals("") && !pcusto.getValue().equals(0)) {

            if (txtajuste.getText().contains("%") || txtajuste.getText().contains(",")) {
                replace = txtajuste.getText().replace("%", "").replace(",", ".").trim();

                pvenda.setValue(pcusto.getValue()
                        .multiply(new BigDecimal(replace))
                        .divide(new BigDecimal(100)).add(pcusto.getValue()));

            } else {
                pvenda.setValue(pcusto.getValue()
                        .multiply(new BigDecimal(txtajuste.getText().trim()))
                        .divide(new BigDecimal(100)).add(pcusto.getValue()));
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o valor de custo do produto", "Atenção", 0);
        }

        //    System.out.println(replace);
    }//GEN-LAST:event_pcustoFocusLost

    private void txtbuscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscaFocusGained
        txtbusca.setText("");
    }//GEN-LAST:event_txtbuscaFocusGained

    private void txtfotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfotoMouseClicked

        try {
            JFileChooser imgfile = new JFileChooser();
            imgfile.showDialog(jPanel1, "Selecione a Imagem");
            imgfile.setFileSelectionMode(JFileChooser.FILES_ONLY);

            if (JFileChooser.APPROVE_OPTION == 0) {
                fotopath = imgfile.getSelectedFile().getAbsolutePath();
                mostrarFotoNoPainel(fotopath);
                System.out.println(fotopath);
            }

        } catch (NullPointerException e) {

        }

    }//GEN-LAST:event_txtfotoMouseClicked

    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
        Produto produto = new ProdutoDao()
                .produtoByCodigo(Long.parseLong(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)
                        .toString()));

        produto.setDescricao(desc.getText());
        produto.setMarca(marca.getText());
        produto.setPreco(pvenda.getValue());
        produto.setPrecoCusto(pcusto.getValue());
        produto.setDimensao(txtdimensao.getText());
        produto.setFabricao(txtfabricacao.getText());
        produto.setObs(obs.getText());

        NumberFormat format = DecimalFormat.getNumberInstance();
        produto.setComissao(Double.parseDouble(format.format(txtcomissao.getValue())));

        if (peso.getValue() != null) {
            produto.setPeso(((Number) peso.getValue()).doubleValue());
        } else {
            produto.setPeso(0.0);
        }
        produto.setReferencia(txtreferencia.getText());

        produto.getEstoque().setUnidade(unidade.getSelectedItem().toString());
        produto.getEstoque().setLocalizaco(localizacao.getText());
        produto.getEstoque().setQtdeDisponivel(Integer.parseInt(qtdeinicial.getText()));
        produto.getEstoque().setMinimo(Integer.parseInt(qtdeminima.getText()));

        produto.setFornecedor(new FornecedorDao().fornecedorByNome(fornecedor.getSelectedItem().toString()));

        produto.setCodigoBarras(codigobarras.getText());
        produto.setCor(cor.getSelectedItem().toString());
        produto.setDimensao(txtdimensao.getText());

        if (!"".equals(fotopath)) {
            produto.setFoto(fotopath);
        }

        produto.getCategoria().setNome(categoria.getSelectedItem().toString());

        new ProdutoDao().atualizarProduto(produto);
        JOptionPane.showMessageDialog(rootPane, "Produto Atualizado", "Atenção", 1);
        btnAtualiza.setEnabled(false);
        mostrarProdutos();

    }//GEN-LAST:event_btnAtualizaActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        long id = Long.parseLong(tabelaProdutos.getValueAt(TableMouseListener
                .getLinhaSelecionada(), 0)
                .toString());

        Produto produto = new ProdutoDao().produtoByCodigo(id);

        qtdeminima.setText(String.valueOf(produto.getEstoque().getMinimo()));
        qtdeinicial.setText(String.valueOf(produto.getEstoque().getQtdeDisponivel()));
        localizacao.setText(produto.getEstoque().getLocalizaco());
        unidade.setSelectedItem(produto.getEstoque().getUnidade());

        desc.setText(produto.getDescricao().toUpperCase());
        cor.setSelectedItem(produto.getCor().toUpperCase());
        txtreferencia.setText(produto.getReferencia().toUpperCase());
        marca.setText(produto.getMarca().toUpperCase());
        obs.setText(produto.getObs());
        capacidade.setText(produto.getCapacidade());

        categoria.setSelectedItem(produto.getCategoria().getNome());
        fornecedor.setSelectedItem(produto.getFornecedor().getPessoaJuridica().getRazaosocial());
        codigobarras.setText(produto.getCodigoBarras());

        mostrarFotoNoPainel(produto.getFoto());

        pcusto.setValue(produto.getPrecoCusto());
        pvenda.setValue(produto.getPreco());
        txtdimensao.setText(produto.getDimensao());
        validade.setText(produto.getEstoque().getValidade().toString());

        if (produto.getComissao() != null) {
            txtcomissao.setValue(produto.getComissao());
        } else {
            txtcomissao.setValue(0);
        }

        btnAtualiza.setEnabled(true);

    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked

    }//GEN-LAST:event_jLabel21MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {

            JFileChooser XMFfile = new JFileChooser();
            XMFfile.showDialog(jPanel1, "Selecione o XML");
            XMFfile.setFileSelectionMode(JFileChooser.FILES_ONLY);

            if (JFileChooser.APPROVE_OPTION == 0) {

                LeitorProdutoXmlFile leitorProdutoXmlFile = new LeitorProdutoXmlFile(XMFfile.getSelectedFile());
                try {

                    EstoqueDao estoqueDao = new EstoqueDao();

                    int cont = 0;
                    for (Estoque produto : leitorProdutoXmlFile.readXML()) {
                        estoqueDao.saveEstoque(produto);
                        cont++;
                    }

                    JOptionPane.showMessageDialog(rootPane, "Operação efetuada com sucesso.\n" + cont + " Produto(s) adicionados", "Sucesso na Importação", 1);
                    mostrarProdutos();
                } catch (ParserConfigurationException | SAXException | IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel ler o xml.\n" + ex.getMessage(), "Erro na Importação", 0);
                }

            }

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void mostrarFotoNoPainel(String path) {
        if (path != null && new File(path).exists()) {
            javaxt.io.Image image = new javaxt.io.Image(path);
            image.setWidth(165); //set width, adjusts height to maintain aspect ratio
            image.setHeight(124); //set height, adjusts width to maintain aspect ratio
            image.resize(166, 124);
            byte[] b = image.getByteArray();
            txtfoto.setText("");
            txtfoto.setIcon(new javax.swing.ImageIcon(b));
        } else {
            txtfoto.setText("");
            txtfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/foto_blank.png")));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualiza;
    public static javax.swing.JButton btnFornecedor;
    private javax.swing.JButton btnadd;
    private javax.swing.JTextField capacidade;
    public static javax.swing.JComboBox<String> categoria;
    private javax.swing.JTextField codigobarras;
    private javax.swing.JComboBox<String> cor;
    private javax.swing.JTextField desc;
    public static javax.swing.JComboBox<String> fornecedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField localizacao;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField ncm;
    private javax.swing.JTextArea obs;
    private Utilitarios.JNumberFormatField pcusto;
    private javax.swing.JFormattedTextField peso;
    private Utilitarios.JNumberFormatField pvenda;
    private javax.swing.JTextField qtdeinicial;
    private javax.swing.JTextField qtdeminima;
    private javax.swing.JComboBox<String> status;
    private static javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtajuste;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JFormattedTextField txtcomissao;
    private javax.swing.JFormattedTextField txtdimensao;
    private javax.swing.JFormattedTextField txtfabricacao;
    private static javax.swing.JLabel txtfoto;
    private javax.swing.JTextField txtreferencia;
    private javax.swing.JComboBox<String> unidade;
    private javax.swing.JFormattedTextField validade;
    // End of variables declaration//GEN-END:variables
}
