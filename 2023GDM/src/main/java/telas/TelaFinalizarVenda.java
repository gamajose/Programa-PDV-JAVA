
package telas;

import Utilitarios.DataHora;
import Utilitarios.FormaPagamento;
import Utilitarios.TelaQrCodePix;
import repositorio.CaixaDao;
import repositorio.CrediarioDao;
import repositorio.EstoqueDao;
import repositorio.LancamentoCartaoDAO;
import repositorio.LancamentoDao;
import repositorio.ProdutoDao;
import repositorio.VendaDao;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import model.CartaoLancamento;
import model.Cliente;
import model.Configuracao;
import model.Conta;
import model.Crediario;
import model.ItemVenda;
import model.Lancamento;
import model.Pagamento;
import model.Produto;
import model.Venda;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaFinalizarVenda extends javax.swing.JFrame {

    private static final long serialVersionUID = -6632233897170955639L;
    private static Venda venda;
    public static List<ItemVenda> itensVenda;
    private Crediario crediario = null;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static Venda getVenda() {
        return venda;
    }

    public static void setVenda(Venda aVenda) {
        venda = aVenda;
    }

    public TelaFinalizarVenda() {

        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);

        initComponents();
        txtvalorrecebido.requestFocus();

        crediarioComentario.setVisible(false);
        crediarioComentario.setSize(400, 1);
        this.setSize(440, 460);

        //   System.out.println(itensVenda.size());/////////INF
    }

    public void atualizaEstoque(long id, int qtde) {
        Produto pr = new ProdutoDao().produtoByCodigo(id);
        pr.getEstoque().setQtdeDisponivel(pr.getEstoque().getQtdeDisponivel() - qtde);

        EstoqueDao ed = new EstoqueDao();
        ed.atualizarEstoque(pr.getEstoque());
    }

    final AWTEventListener listener = (AWTEvent event) -> {
        KeyEvent evt = (KeyEvent) event;
        if (evt.getID() == KeyEvent.KEY_PRESSED
                && evt.getModifiers() == KeyEvent.CTRL_MASK
                && evt.getKeyCode() == KeyEvent.VK_F) {
            if (txtopcsopgto.getSelectedItem().equals("CREDIARIO")
                    && TelaMasterVenda.txtcpf.getText().equals("000.000.000-00")) {

                JOptionPane.showMessageDialog(rootPane, "NENHUM CLIENTE SELECIONADO.\nBusque um Cliente no PDV.\ntecle (Ctrl+C)", "Atenção", 0);

            } else {
                btnfinalize.doClick();
            }
        }
        if (evt.getID() == KeyEvent.KEY_PRESSED
                && evt.getModifiers() == KeyEvent.CTRL_MASK
                && evt.getKeyCode() == KeyEvent.VK_O) {
            txtopcsopgto.requestFocus();
            txtopcsopgto.setPopupVisible(true);
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtvalorrecebido = new Utilitarios.JNumberFormatField();
        txttotalVenda = new Utilitarios.JNumberFormatField();
        jLabel2 = new javax.swing.JLabel();
        txttroco = new Utilitarios.JNumberFormatField();
        jLabel3 = new javax.swing.JLabel();
        btnfinalize = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtopcsopgto = new javax.swing.JComboBox<>();
        txtdesconto = new Utilitarios.JNumberFormatField();
        jLabel6 = new javax.swing.JLabel();
        layerCartao = new javax.swing.JLayeredPane();
        txtbandeira = new javax.swing.JComboBox<>();
        spinner1 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbancoemisso = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtchequepazo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcaixan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        crediarioComentario = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        crediario_desc = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalização da Venda");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 153, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 0));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valor recebido:");

        txtvalorrecebido.setBackground(new java.awt.Color(204, 255, 204));
        txtvalorrecebido.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtvalorrecebido.setForeground(new java.awt.Color(102, 102, 102));
        txtvalorrecebido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtvalorrecebido.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtvalorrecebidoCaretUpdate(evt);
            }
        });
        txtvalorrecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtvalorrecebidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalorrecebidoKeyTyped(evt);
            }
        });

        txttotalVenda.setForeground(new java.awt.Color(102, 102, 102));
        txttotalVenda.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txttotalVenda.setText("12,00");
        txttotalVenda.setDisabledTextColor(new java.awt.Color(0, 102, 102));
        txttotalVenda.setEnabled(false);
        txttotalVenda.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total da Venda:");

        txttroco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txttroco.setForeground(new java.awt.Color(102, 102, 102));
        txttroco.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        txttroco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttrocoKeyPressed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Troco:");

        btnfinalize.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnfinalize.setForeground(new java.awt.Color(0, 153, 255));
        btnfinalize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-verificar-48.png"))); // NOI18N
        btnfinalize.setText("FINALIZAR VENDA   [Ctrl+F]");
        btnfinalize.setBorderPainted(false);
        btnfinalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalizeActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Forma  de Pagamento:  [Ctrl+O]");

        txtopcsopgto.setBackground(new java.awt.Color(204, 255, 204));
        txtopcsopgto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtopcsopgto.setForeground(new java.awt.Color(51, 153, 255));
        txtopcsopgto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DINHEIRO", "CARTAO_DEBITO", "CARTAO_CREDITO", "CHEQUE", "CREDIARIO", "PIX" }));
        txtopcsopgto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtopcsopgtoItemStateChanged(evt);
            }
        });

        txtdesconto.setBackground(new java.awt.Color(255, 255, 204));
        txtdesconto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtdesconto.setForeground(new java.awt.Color(102, 102, 102));
        txtdesconto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtdesconto.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        txtdesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdescontoFocusLost(evt);
            }
        });
        txtdesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescontoKeyPressed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Desconto:");

        layerCartao.setBackground(new java.awt.Color(76, 175, 243));
        layerCartao.setOpaque(true);

        txtbandeira.setBackground(new java.awt.Color(204, 204, 255));
        txtbandeira.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtbandeira.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "VISA", "MASTERCARD", "DINNERS", "CREDICARD", " " }));
        txtbandeira.setEnabled(false);

        spinner1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        spinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        spinner1.setEnabled(false);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Parcela(s)");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bandeira do Crédito:");

        txtbancoemisso.setBackground(new java.awt.Color(255, 255, 204));
        txtbancoemisso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtbancoemisso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "BANCO DO BRASIL", "BANCO BRADESCO", "BANCO HSBC", "BANCO SANTANDER", "BANCO ITAU", "CAIXA ECONOMICA", "BANCO NORDESTE", "BNDS" }));
        txtbancoemisso.setEnabled(false);
        txtbancoemisso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbancoemissoFocusLost(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(51, 153, 255));
        jLabel9.setText("Cheque - Banco Emissor:");

        txtchequepazo.setEditable(false);
        txtchequepazo.setEnabled(false);

        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Prazo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbancoemisso, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addComponent(txtchequepazo))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbancoemisso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtchequepazo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layerCartao.setLayer(txtbandeira, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerCartao.setLayer(spinner1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerCartao.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerCartao.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerCartao.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerCartaoLayout = new javax.swing.GroupLayout(layerCartao);
        layerCartao.setLayout(layerCartaoLayout);
        layerCartaoLayout.setHorizontalGroup(
            layerCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerCartaoLayout.createSequentialGroup()
                .addGroup(layerCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layerCartaoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(layerCartaoLayout.createSequentialGroup()
                        .addComponent(txtbandeira, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layerCartaoLayout.setVerticalGroup(
            layerCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerCartaoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layerCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layerCartaoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layerCartaoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(2, 2, 2)
                        .addComponent(txtbandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtcaixan.setForeground(new java.awt.Color(204, 204, 204));
        txtcaixan.setText("00");

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Caixa:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição da Venda no Crédiario"));
        jPanel3.setOpaque(false);

        crediario_desc.setColumns(20);
        crediario_desc.setLineWrap(true);
        crediario_desc.setRows(3);
        crediario_desc.setMargin(new java.awt.Insets(5, 5, 0, 0));
        jScrollPane1.setViewportView(crediario_desc);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );

        crediarioComentario.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout crediarioComentarioLayout = new javax.swing.GroupLayout(crediarioComentario);
        crediarioComentario.setLayout(crediarioComentarioLayout);
        crediarioComentarioLayout.setHorizontalGroup(
            crediarioComentarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        crediarioComentarioLayout.setVerticalGroup(
            crediarioComentarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcaixan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(layerCartao)
                    .addComponent(txtopcsopgto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnfinalize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttotalVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtvalorrecebido, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 196, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crediarioComentario)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcaixan)
                    .addComponent(jLabel12))
                .addGap(2, 2, 2)
                .addComponent(txtopcsopgto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layerCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttotalVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtvalorrecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttroco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crediarioComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnfinalize, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jMenu1.setText("Opções");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menou.png"))); // NOI18N
        jMenuItem1.setText("Cancelar Desconto");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtopcsopgtoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtopcsopgtoItemStateChanged
        switch (txtopcsopgto.getSelectedItem().toString()) {
            case "DINHEIRO":
                this.setSize(440, 460);
                crediarioComentario.setVisible(false);
                crediarioComentario.setSize(410, 120);
                break;
            case "CHEQUE":
                txtbancoemisso.setEnabled(true);
                txtchequepazo.setEditable(true);
                txtchequepazo.setEnabled(true);
                spinner1.setEnabled(false);
                txtbandeira.setEnabled(false);

                break;
            case "CARTAO_CREDITO":
                spinner1.setEnabled(true);
                txtbandeira.setEnabled(true);
                txtbandeira.requestFocus();
                txtbandeira.setPopupVisible(true);
                txtvalorrecebido.setValue(txttotalVenda.getValue());
                break;
            case "CARTAO_DEBITO":
                txtbandeira.setEnabled(true);
                txtbandeira.requestFocus();
                txtbandeira.setPopupVisible(true);
                txtvalorrecebido.setValue(txttotalVenda.getValue());
                break;
            case "CREDIARIO":
                crediarioComentario.setVisible(true);
                crediarioComentario.setSize(410, 120);
                this.setSize(440, 615);
                break;

            case "PIX":
                txtvalorrecebido.setValue(txttotalVenda.getValue());

                TelaQrCodePix telaQrCodePix = new TelaQrCodePix(this, true, txttotalVenda.getValue());
                telaQrCodePix.setAlwaysOnTop(false);
                telaQrCodePix.setVisible(true);

                break;
        }

    }//GEN-LAST:event_txtopcsopgtoItemStateChanged

    private void btnfinalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalizeActionPerformed
        VendaDao vd = new VendaDao();
        CartaoLancamento cartao = new CartaoLancamento();
        boolean pgto_cartao = false;

        boolean controleFluxo = true;

        switch (txtopcsopgto.getSelectedItem().toString()) {
            case "DINHEIRO":
                getVenda().setFormaPagamento(FormaPagamento.DINHEIRO);
                break;
            case "CARTAO_DEBITO":
                getVenda().setFormaPagamento(FormaPagamento.CARTAO_DEBITO);

                cartao.setBandeira(txtbandeira.getSelectedItem().toString());
                cartao.setTipoOP("DEBITO");
                cartao.setParcelas(1);
                cartao.setValor(txttotalVenda.getValue());
                cartao.setDate(LocalDate.now());
                cartao.setVenda(venda);

                pgto_cartao = true;

                break;
            case "CARTAO_CREDITO":
                getVenda().setFormaPagamento(FormaPagamento.CARTAO_CREDITO);

                cartao.setBandeira(txtbandeira.getSelectedItem().toString());
                cartao.setTipoOP("CREDITO");
                cartao.setParcelas((int) spinner1.getValue());
                cartao.setValor(txttotalVenda.getValue());
                cartao.setDate(LocalDate.now());
                cartao.setVenda(venda);
                pgto_cartao = true;

                break;
            case "CHEQUE":
                getVenda().setFormaPagamento(FormaPagamento.CHEQUE);
                break;

            case "CREDIARIO":
                if (!TelaMasterVenda.txtcpf.getText().equals("000.000.000-00")) {
                    getVenda().setFormaPagamento(FormaPagamento.CREDIARIO);

                    crediario = new Crediario();
                    crediario.setCliente(getVenda().getCliente());
                    //crediario.setCliente(new ClienteDao().clientePorCpf(TelaMasterVenda.txtcpf.getText()));

                    List<Pagamento> pagamentos = new ArrayList<>();
                    Pagamento pagamento = new Pagamento(txtvalorrecebido.getValue(), LocalDate.now(), getVenda().getCliente());
                    pagamentos.add(pagamento);
                    pagamento.setCrediario(crediario);
                    crediario.setPagamentos(pagamentos);

                    venda.setCrediario(crediario);
                    venda.setCliente(crediario.getCliente());

                    //seta o total da venda apenas o valor recebido
                    // venda.setTotal(txtvalorrecebido.getValue());
                    List<Venda> vendas = new ArrayList<>();
                    vendas.add(venda);
                    crediario.setVendas(vendas);

                    Conta contaReceber = new Conta();
                    contaReceber.setStatus(" A RECEBER ");
                    contaReceber.setValor(txttotalVenda.getValue().subtract(txtvalorrecebido.getValue()));
                    contaReceber.setTipo("RECEBER");
                    if (!crediario_desc.getText().equals("")) {
                        contaReceber.setTitulo(crediario_desc.getText());
                    } else {
                        contaReceber.setTitulo("VENDA A PRAZO");
                    }

                    contaReceber.setVencimento(LocalDate.now().plusDays(30));
                    contaReceber.setCendente(TelaMasterVenda.txtcpf.getText());
                    contaReceber.setDocNumero("0");
                    contaReceber.setBoletoNumero("0");
                    contaReceber.setBanco("CREDIARIO");
                    crediario.setConta(contaReceber);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "NENHUM CLIENTE SELECIONADO.\nBusque um Cliente no PDV.\ntecle (Ctrl+C)", "Atenção", 0);
                    this.setVisible(false);
                    controleFluxo = false;

                }
                break;
            case "PIX": {
                getVenda().setFormaPagamento(FormaPagamento.PIX);
                break;
            }

        }

        if (controleFluxo == true) {

            int valor = txtvalorrecebido.getValue().subtract(txttotalVenda.getValue()).intValue();

            if (valor < 0 && !txtopcsopgto.getSelectedItem().toString().equals("CREDIARIO")) {
                JOptionPane.showMessageDialog(rootPane, "Valor recebido menor que o total da venda.\nSolicite mais dinheiro ao Cliente", "Atenção", 0);
                txtvalorrecebido.requestFocus();
            } else {
                //aplica o desconto caso haja
                venda.setTotal(getVenda().getTotal().subtract(txtdesconto.getValue()));
                venda.setDesconto(txtdesconto.getValue());
                vd.salvaVenda(venda);

                if (crediario != null) {
                    crediario.getVendas().get(0).setId(venda.getId());
                    new CrediarioDao().saveCrediario(crediario);
                }

                // --------------------------------------lancamento caso compra seja no cartao---------//
                if (pgto_cartao == true) {
                    LancamentoCartaoDAO cl = new LancamentoCartaoDAO();
                    cl.regitrarTrasacaoComCartao(cartao);
                }

                //---------------------------------------Baixa no estoque------------------------------//
                for (Iterator iterator = itensVenda.iterator(); iterator.hasNext();) {
                    ItemVenda next = (ItemVenda) iterator.next();
                    atualizaEstoque(next.getProduto().getCodigo(), next.getQtde());

                }

                //---------------------------------------lancamento no caixa---------------------------//
                this.setVisible(false);

                //lançamento da venda no caixa diario
                CaixaDao caixaDao = new CaixaDao();

                Lancamento l = new Lancamento();
                l.setCaixa(caixaDao.getCaixaPoCodigo(Long.valueOf(txtcaixan.getText().trim())));
                l.setDescr("Venda n° " + venda.getId());
                l.setValor(venda.getTotal());//tira valor do desconto na finalização da venda

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                l.setData(LocalDate.parse(new DataHora().ler_Data().trim(), formatter));
                l.setHora(LocalDateTime.now());
                l.setTipo("ENTRADA");
                l.setResponsavel(TelaMasterApp.txtinfoUser.getText());

                LancamentoDao ldao = new LancamentoDao();
                l.setSaldoParcial(ldao.total().add(venda.getTotal()));//obs
                ldao.salva(l);

                venda = null;
                crediario = null;
                JOptionPane.showMessageDialog(rootPane, "Venda Efetuada com sucesso.", "Confirmada", 1);

                //GERA E IMPRIMI CUPOM
                if (new Configuracao().loadParamsPrint("imprimir").equals("SIM")) {
                    TelaMasterVenda.geraCupomNaoFiscal();
                }
                TelaMasterVenda.limparDadosPdv();

                pgto_cartao = false;

                TelaMasterVenda.txtcodigo.requestFocus();

            }
        }
    }//GEN-LAST:event_btnfinalizeActionPerformed

    private void txtvalorrecebidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorrecebidoKeyTyped
        //   txttroco.setValue(txttotalVenda.getValue().subtract(txtvalorrecebido.getValue()));
    }//GEN-LAST:event_txtvalorrecebidoKeyTyped

    private void txtvalorrecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorrecebidoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtvalorrecebido.getValue().equals(0)) {
                txttroco.setValue(txttotalVenda.getValue().subtract(txtvalorrecebido.getValue()));
            }
        }

        BigDecimal totalpago = txtvalorrecebido.getValue();
        BigDecimal totalVenda = txttotalVenda.getValue();

        if (totalpago.compareTo(totalVenda) < 0) {
            txttroco.setValue(BigDecimal.ZERO);
        }
    }//GEN-LAST:event_txtvalorrecebidoKeyPressed

    private void txtvalorrecebidoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtvalorrecebidoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorrecebidoCaretUpdate

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed

    }//GEN-LAST:event_jPanel1KeyPressed

    private void txttrocoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttrocoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtvalorrecebido.getValue().equals(0)) {
                txttroco.setValue(txttotalVenda.getValue().subtract(txtvalorrecebido.getValue()));
            }
        }

        BigDecimal totalpago = txtvalorrecebido.getValue();
        BigDecimal totalVenda = txttotalVenda.getValue();

        if (totalpago.compareTo(totalVenda) < 0) {
            txttroco.setValue(BigDecimal.ZERO);
        }
    }//GEN-LAST:event_txttrocoKeyPressed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained

    }//GEN-LAST:event_jPanel1FocusGained

    private void txtbancoemissoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbancoemissoFocusLost

        txtvalorrecebido.requestFocus();
    }//GEN-LAST:event_txtbancoemissoFocusLost

    private void txtdescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescontoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtdesconto.getValue().doubleValue() < txttotalVenda.getValue().doubleValue()) {
                txttotalVenda.setValue(txttotalVenda.getValue().subtract(txtdesconto.getValue()));
                txtdesconto.setEnabled(false);
                txtdesconto.setEditable(false);
                txtvalorrecebido.requestFocus();

                if (txtvalorrecebido.getValue().doubleValue() > txttotalVenda.getValue().doubleValue()) {
                    txttroco.setValue(txtvalorrecebido.getValue().subtract(txttotalVenda.getValue()));
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, ""
                        + "O DESCONTO NÃO PODE SER MAIOR OU IGUAL AO TOTAL DA VENDA\n * Favor Diminuir o desconto.", "Desconto muito alto", 0);
            }
        }
    }//GEN-LAST:event_txtdescontoKeyPressed

    private void txtdescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescontoFocusLost
        //txttotalVenda.setValue(txttotalVenda.getValue().subtract(txtdesconto.getValue()));
        //txtdesconto.setEnabled(false);
        //txtdesconto.setEditable(false);
    }//GEN-LAST:event_txtdescontoFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        BigDecimal desconto = txtdesconto.getValue();
        BigDecimal troco = txttroco.getValue();

        if (txtdesconto.getValue() != BigDecimal.ZERO) {
            txttotalVenda.setValue(txttotalVenda.getValue().add(txtdesconto.getValue()));
            txtdesconto.setEnabled(true);
            txtdesconto.setEditable(true);
            txtdesconto.setValue(BigDecimal.ZERO);

            if (txttroco.getValue().doubleValue() > 0) {
                txttroco.setValue(troco.subtract(desconto));
            }

        } else {
            JOptionPane.showMessageDialog(txtdesconto, "Nenhum desconto informado", "Desconto é R$ 0,00", 0);
            txtdesconto.requestFocus();
            txtdesconto.setEnabled(true);
            txtdesconto.setEditable(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnfinalize;
    private javax.swing.JLayeredPane crediarioComentario;
    private javax.swing.JTextArea crediario_desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane layerCartao;
    private javax.swing.JSpinner spinner1;
    private javax.swing.JComboBox<String> txtbancoemisso;
    private javax.swing.JComboBox<String> txtbandeira;
    public static javax.swing.JLabel txtcaixan;
    private javax.swing.JTextField txtchequepazo;
    private Utilitarios.JNumberFormatField txtdesconto;
    public static javax.swing.JComboBox<String> txtopcsopgto;
    public static Utilitarios.JNumberFormatField txttotalVenda;
    private Utilitarios.JNumberFormatField txttroco;
    private Utilitarios.JNumberFormatField txtvalorrecebido;
    // End of variables declaration//GEN-END:variables

}
