package telas;

import Utilitarios.WebServiceCep;
import repositorio.ClienteDao;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Endereco;
import model.PessoaJuridica;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaCadastroClientes extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 6601100968624021448L;

    /**
     * Creates new form TelaClientes
     */
    public TelaCadastroClientes() {
        initComponents();

        txtdata.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        tab.setEnabledAt(1, false);
    }

    public void setaEnderecoViaCep(String cep) {
        WebServiceCep cepi = WebServiceCep.searchCep(cep);
        if (!cepi.isCepNotFound()) {
            txtcidade.setText(cepi.getCidade());
            txtuf.setSelectedItem(cepi.getUf());
            txtbairro.setText(cepi.getBairro());
            txtcep.setText(cepi.getCep());
            txtendereco.setText(cepi.getLogradouroFull());

        } else {
            System.out.println("Não foi possivel encontrar endereço via cep");
        }

    }

    public void setaDadosClienteSelecionado(long id) {
        Cliente cliente = new ClienteDao().clientePorCodigoParaEdicao(id);

        txtnumero.setText(String.valueOf(cliente.getListaEndereco().get(0).getNumero()));
        txtid.setText(String.valueOf(id));
        txtcpf.setText(cliente.getCpf());
        txtapelido.setText(cliente.getApelido());
        txtrg.setText(cliente.getRg());
        txtmae.setText(cliente.getMae());
        txtpai.setText(cliente.getPai());
        txtdata.setText(cliente.getDatacadastro());
        txtconjugue.setText(cliente.getCompanheiro());
        txtemail.setText(cliente.getEmail());
        txtcelular.setText(cliente.getTelefone());
        txtcelular.setText(cliente.getCelular());
        txtobs.setText(cliente.getObs());
        txtescivil.setSelectedItem(cliente.getEstadocivil());
        cliente.setSexo(txtsexo.getSelectedItem().toString());
        txtlimite.setValue(cliente.getLimiteCredito());
        txtprofissao.setText(cliente.getProfissao());
        
        txtrazao.setText(cliente.getPessoaJuridica().getRazaosocial());
        txtcnpj.setText(cliente.getPessoaJuridica().getCnpj());
        txtie.setText(cliente.getPessoaJuridica().getIe());
        txtim.setText(cliente.getPessoaJuridica().getIm());
        txtfantasia.setText(cliente.getPessoaJuridica().getNomeFantasia());

        txtnome.setText(cliente.getPessoaJuridica().getNomeFantasia());

        Endereco endereco = cliente.getListaEndereco().get(0);
        txtendereco.setText(endereco.getEndereco());
        txtbairro.setText(endereco.getBairro());
        txtcep.setText(endereco.getCep());
        txtcidade.setText(endereco.getCidade());
        txtreferencia.setText(endereco.getReferencia());

        if (cliente.getListaEndereco().size() > 1) {
            txtConfirmacaoEnderecoEntrega.setSelectedItem("Não");

            Endereco enderecoEntrega = cliente.getListaEndereco().get(1);
            txtenderecoEntrega.setText(endereco.getEndereco());
            txtbairroEntrega.setText(endereco.getBairro());
            txtCepEntrega.setText(endereco.getCep());
            txtCidadeEntrega.setText(endereco.getCidade());
            txtreferenciaEntrega.setText(endereco.getReferencia());
        }

        if (cliente.getStatus().equals("Sim")) {
            block1.setSelected(true);
        } else if (cliente.getStatus().equals("Não")) {
            block2.setSelected(true);
        }

        txtnascimento.setText(cliente.getNascimento());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtrg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtescivil = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtsexo = new javax.swing.JComboBox<>();
        txtnascimento = new javax.swing.JFormattedTextField();
        txtapelido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pessoafisica = new javax.swing.JRadioButton();
        pessoajuridica = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtcnpj = new javax.swing.JFormattedTextField();
        txtrazao = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtim = new javax.swing.JFormattedTextField();
        txtie = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtfantasia = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        txtpai = new javax.swing.JTextField();
        txtmae = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtconjugue = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        txtprofissao = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtfone = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        block2 = new javax.swing.JRadioButton();
        block1 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        txtlimite = new Utilitarios.JNumberFormatField();
        jPanel11 = new javax.swing.JPanel();
        btnatualiza = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtdata = new javax.swing.JTextField();
        btnnovo = new javax.swing.JButton();
        btngrava = new javax.swing.JButton();
        txtid = new javax.swing.JLabel();
        tab2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtendereco = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcidade = new javax.swing.JTextField();
        txtuf = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtcep = new javax.swing.JFormattedTextField();
        txtConfirmacaoEnderecoEntrega = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtenderecoEntrega = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtCidadeEntrega = new javax.swing.JTextField();
        txtUfEntrega = new javax.swing.JComboBox<>();
        txtnumeroEntrega = new javax.swing.JTextField();
        txtbairroEntrega = new javax.swing.JTextField();
        txtCepEntrega = new javax.swing.JFormattedTextField();
        txtreferenciaEntrega = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        jTextField6.setText("jTextField6");

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Cadastro");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fornecedor-24.png"))); // NOI18N

        tab.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("Nome:");

        txtnome.setBackground(new java.awt.Color(204, 255, 204));

        txtrg.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("CPF:");

        txtcpf.setBackground(new java.awt.Color(255, 255, 204));
        try {
            txtcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("RG:");

        jLabel7.setText("Apelido:");

        jLabel8.setText("Estado Civil:");

        txtescivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solteiro(a)", "Divorciado(a)", "Viuvo(a)" }));

        jLabel9.setText("Sexo:");

        txtsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", " " }));

        try {
            txtnascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtnascimento.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel10.setText("Nascimento:");

        pessoafisica.setSelected(true);
        pessoafisica.setText("Pessoa Fisica");
        pessoafisica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pessoafisicaItemStateChanged(evt);
            }
        });
        pessoafisica.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pessoafisicaStateChanged(evt);
            }
        });
        pessoafisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pessoafisicaActionPerformed(evt);
            }
        });

        pessoajuridica.setText("Pessoa Juridica");
        pessoajuridica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pessoajuridicaItemStateChanged(evt);
            }
        });
        pessoajuridica.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pessoajuridicaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pessoafisica)
                        .addGap(135, 135, 135))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtapelido)
                                        .addGap(5, 5, 5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(244, 244, 244)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(txtcpf)
                                    .addComponent(txtsexo, 0, 145, Short.MAX_VALUE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtescivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2)
                                .addGap(278, 278, 278)
                                .addComponent(pessoajuridica)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pessoafisica)
                            .addComponent(pessoajuridica))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapelido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtescivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Pessoa Fisica", jPanel1);

        jPanel9.setOpaque(false);

        jLabel22.setText("CNPJ:");

        try {
            txtcnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcnpj.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel23.setText("Razão Social:");

        jLabel25.setText("Inscrição Municipal:");

        txtie.setBackground(new java.awt.Color(239, 253, 239));

        jLabel26.setText("Inscrição Estadual:");

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 153, 255));
        jLabel35.setText("< Pessoa Fisica");
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel35.setDoubleBuffered(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });

        txtfantasia.setBackground(new java.awt.Color(255, 255, 243));

        jLabel36.setText("Fantasia:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtim)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtie, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                                .addComponent(jLabel35))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtrazao, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel26))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtfantasia))))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel36))
                .addGap(2, 2, 2)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrazao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtie, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addContainerGap())
        );

        tab.addTab("Pessoa Juridica", jPanel9);

        jTabbedPane3.setOpaque(true);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel18.setText("Pai:");

        jLabel19.setText("Mãe:");

        jLabel20.setText("Conjugue:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtpai, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel19))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmae, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtconjugue))
                .addGap(4, 4, 4))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmae, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtconjugue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Outras Informações", jPanel6);

        txtobs.setColumns(20);
        txtobs.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtobs.setLineWrap(true);
        txtobs.setRows(3);
        txtobs.setText("Escreva...");
        jScrollPane1.setViewportView(txtobs);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Observações", jPanel5);

        jLabel24.setText("Profissão:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(6, 6, 6)
                .addComponent(txtprofissao, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprofissao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Profissão", jPanel2);

        jLabel15.setText("E-mail:");

        jLabel16.setText("Fone:");

        jLabel17.setText("Celular:");

        try {
            txtcelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bloqueado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        block2.setSelected(true);
        block2.setText("Não");
        block2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                block2ActionPerformed(evt);
            }
        });

        block1.setText("Sim");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(block1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(block2)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(block1)
                    .addComponent(block2))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Limite de Crédito", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        txtlimite.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtlimite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(txtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(2, 2, 2)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnatualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sincronizar-24.png"))); // NOI18N
        btnatualiza.setText("Atualizar");
        btnatualiza.setEnabled(false);
        btnatualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatualizaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("Data do Cadastro:");

        txtdata.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdata.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdata.setEnabled(false);

        btnnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clean.png"))); // NOI18N
        btnnovo.setText("Novo");
        btnnovo.setEnabled(false);
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btngrava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        btngrava.setText("Adicionar");
        btngrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngravaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnatualiza)
                .addGap(153, 153, 153)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btngrava)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnatualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnnovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btngrava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        tab2.setOpaque(true);

        jLabel3.setText("Endereço:");

        txtnumero.setText("0");

        jLabel4.setText("Bairro:");

        jLabel5.setText("N°:");

        jLabel11.setText("Cidade:");

        txtuf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MA", "PI", "SP", "RJ", "BA", "MG", "TO", "SC", "DF", "RO", "AC", "PE", "CE", "GO", "PR" }));

        jLabel12.setText("UF:");

        jLabel13.setText("Cep:");

        jLabel14.setText("Referencia Proxima:");

        txtcep.setBackground(new java.awt.Color(204, 255, 204));
        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcepFocusLost(evt);
            }
        });

        txtConfirmacaoEnderecoEntrega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não", " ", " " }));
        txtConfirmacaoEnderecoEntrega.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtConfirmacaoEnderecoEntregaItemStateChanged(evt);
            }
        });

        jLabel34.setText("End. Entrega:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(78, 78, 78))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtuf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtnumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbairro)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtreferencia)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(txtConfirmacaoEnderecoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 301, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel34))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmacaoEnderecoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tab2.addTab("Endereço Principal", jPanel3);

        jPanel4.setOpaque(false);

        jLabel27.setText("Endereço:");

        jLabel28.setText("Cidade:");

        txtUfEntrega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MA", "PI", "SP", "RJ", "BA", "MG", "TO", "SC", "DF", "RO", "AC", "PE", "CE", "GO", "PR" }));

        txtnumeroEntrega.setText("0");

        try {
            txtCepEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel29.setText("UF:");

        jLabel30.setText("Cep:");

        jLabel31.setText("Ponto de Referencia:");

        jLabel32.setText("N°:");

        jLabel33.setText("Bairro:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(txtenderecoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(txtCidadeEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUfEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtnumeroEntrega)
                        .addComponent(txtCepEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtreferenciaEntrega)
                    .addComponent(txtbairroEntrega)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel31))
                        .addGap(0, 284, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtenderecoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumeroEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbairroEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCidadeEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUfEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCepEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtreferenciaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        tab2.addTab("Endereço de Entrega", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tab2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void block2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_block2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_block2ActionPerformed

    private void btngravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngravaActionPerformed
        try {
            if (pessoafisica.isSelected()) {

                if (!txtnome.getText().equals("") && !txtcpf.getText().equals("") && !txtrg.getText().equals("")) {
                    Cliente cliente = new Cliente();

                    if (txtnumero.getText().equals("")) {
                        txtnumero.setText("0");
                    }

                    cliente.setCpf(txtcpf.getText());
                    cliente.setApelido(txtapelido.getText());
                    cliente.setRg(txtrg.getText());
                    cliente.setMae(txtmae.getText());
                    cliente.setPai(txtpai.getText());
                    cliente.setDatacadastro(txtdata.getText());
                    cliente.setCompanheiro(txtconjugue.getText());
                    cliente.setEmail(txtemail.getText());
                    cliente.setTelefone(txtcelular.getText());
                    cliente.setCelular(txtcelular.getText());
                    cliente.setObs(txtobs.getText());
                    cliente.setEstadocivil(txtescivil.getSelectedItem().toString());
                    cliente.setSexo(txtsexo.getSelectedItem().toString());
                    cliente.setLimiteCredito(txtlimite.getValue());
                    cliente.setProfissao(txtprofissao.getText());

                    PessoaJuridica pj = new PessoaJuridica();
                    pj.setNomeFantasia(txtnome.getText());
                    pj.setCnpj(txtcnpj.getText());
                    pj.setIe(txtie.getText());
                    pj.setIm(txtim.getText());
                    pj.setRazaosocial(txtrazao.getText());
                    cliente.setPessoaJuridica(pj);

                    if (pessoafisica.isSelected()) {
                        cliente.setTipo("PESSOA FISICA");
                    } else {
                        cliente.setTipo("PESSOA JURIDICA");
                    }

                    String bloqueio = null;
                    if (block1.isSelected()) {
                        bloqueio = "Sim";
                    } else if (block2.isSelected()) {
                        bloqueio = "Não";
                    }

                    cliente.setStatus(bloqueio);

                    cliente.setNascimento(txtnascimento.getText().trim());

                    Endereco enderecoPrincipal = new Endereco(
                            null, txtendereco.getText(), Integer.parseInt(txtnumero.getText()),
                            txtcidade.getText(), txtuf.getSelectedItem().toString(),
                            txtcep.getText(), txtbairro.getText(), txtreferencia.getText(), "PRINCIPAL"
                    );
                    enderecoPrincipal.setCliente(cliente);
                    cliente.getListaEndereco().add(enderecoPrincipal);

                    if (txtConfirmacaoEnderecoEntrega.getSelectedItem().toString().equals("Não")) {
                        Endereco enderecoEntrega = new Endereco(
                                null, txtenderecoEntrega.getText(), Integer.parseInt(txtnumeroEntrega.getText()),
                                txtCidadeEntrega.getText(), txtUfEntrega.getSelectedItem().toString(),
                                txtCepEntrega.getText(), txtbairroEntrega.getText(), txtreferenciaEntrega.getText(), "ENTREGA"
                        );
                        enderecoEntrega.setCliente(cliente);
                        cliente.getListaEndereco().add(enderecoEntrega);

                    }

                    ClienteDao cd = new ClienteDao();
                    cd.salvaCliente(cliente);

                    JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado com sucesso", "Confirmado", 1);
                    TelaClientesCadastrados.mostrarClientes();
                    btngrava.setEnabled(false);
                    btnnovo.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Preencha todos o campos", "Não foi possivél", 0);
                }

            } else if (pessoajuridica.isSelected()) {
                if (!txtcnpj.getText().equals("  .   .   /    -  ") && !txtrazao.getText().equals("") && !txtie.getText().equals("")) {
                    Cliente cliente = new Cliente();

                    if (txtnumero.getText().equals("")) {
                        txtnumero.setText("0");
                    }

                    cliente.setCpf(txtcpf.getText());
                    cliente.setApelido(txtapelido.getText());
                    cliente.setRg(txtrg.getText());
                    cliente.setMae(txtmae.getText());
                    cliente.setPai(txtpai.getText());
                    cliente.setDatacadastro(txtdata.getText());
                    cliente.setCompanheiro(txtconjugue.getText());
                    cliente.setEmail(txtemail.getText());
                    cliente.setTelefone(txtcelular.getText());
                    cliente.setCelular(txtcelular.getText());
                    cliente.setObs(txtobs.getText());
                    cliente.setEstadocivil(txtescivil.getSelectedItem().toString());
                    cliente.setSexo(txtsexo.getSelectedItem().toString());
                    cliente.setLimiteCredito(txtlimite.getValue());
                    cliente.setProfissao(txtprofissao.getText());

                    PessoaJuridica pj = new PessoaJuridica();
                    pj.setNomeFantasia(txtfantasia.getText());
                    pj.setCnpj(txtcnpj.getText());
                    pj.setIe(txtie.getText());
                    pj.setIm(txtim.getText());
                    pj.setRazaosocial(txtrazao.getText());
                    cliente.setPessoaJuridica(pj);

                    if (pessoafisica.isSelected()) {
                        cliente.setTipo("PESSOA FISICA");
                    } else {
                        cliente.setTipo("PESSOA JURIDICA");
                    }

                    String bloqueio = null;
                    if (block1.isSelected()) {
                        bloqueio = "Sim";
                    } else if (block2.isSelected()) {
                        bloqueio = "Não";
                    }

                    cliente.setStatus(bloqueio);

                    cliente.setNascimento(txtnascimento.getText().trim());

                    Endereco enderecoPrincipal = new Endereco(
                            null, txtendereco.getText(), Integer.parseInt(txtnumero.getText()),
                            txtcidade.getText(), txtuf.getSelectedItem().toString(),
                            txtcep.getText(), txtbairro.getText(), txtreferencia.getText(), "PRINCIPAL"
                    );
                    enderecoPrincipal.setCliente(cliente);
                    cliente.getListaEndereco().add(enderecoPrincipal);

                    if (txtConfirmacaoEnderecoEntrega.getSelectedItem().toString().equals("Não")) {
                        Endereco enderecoEntrega = new Endereco(
                                null, txtenderecoEntrega.getText(), Integer.parseInt(txtnumeroEntrega.getText()),
                                txtCidadeEntrega.getText(), txtUfEntrega.getSelectedItem().toString(),
                                txtCepEntrega.getText(), txtbairroEntrega.getText(), txtreferenciaEntrega.getText(), "ENTREGA"
                        );
                        enderecoEntrega.setCliente(cliente);
                        cliente.getListaEndereco().add(enderecoEntrega);

                    }

                    ClienteDao cd = new ClienteDao();
                    cd.salvaCliente(cliente);

                    JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado com sucesso", "Confirmado", 1);
                    TelaClientesCadastrados.mostrarClientes();
                    btngrava.setEnabled(false);
                    btnnovo.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Preencha todos o campos", "Não foi possivél", 0);
                }
            }

        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btngravaActionPerformed

    private void pessoafisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pessoafisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pessoafisicaActionPerformed

    private void pessoajuridicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pessoajuridicaItemStateChanged

    }//GEN-LAST:event_pessoajuridicaItemStateChanged

    private void pessoafisicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pessoafisicaItemStateChanged

    }//GEN-LAST:event_pessoafisicaItemStateChanged

    private void pessoafisicaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pessoafisicaStateChanged
        if (pessoafisica.isSelected()) {
            pessoajuridica.setSelected(false);

            tab.setEnabledAt(1, false);
            tab.setEnabledAt(0, true);
            tab.setSelectedIndex(0);
        } else {
            pessoajuridica.setSelected(true);
        }
    }//GEN-LAST:event_pessoafisicaStateChanged

    private void pessoajuridicaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pessoajuridicaStateChanged
        if (pessoajuridica.isSelected()) {
            pessoafisica.setSelected(false);
            tab.setEnabledAt(1, true);
            tab.setEnabledAt(0, false);
            tab.setSelectedIndex(1);
        } else {
            pessoafisica.setSelected(true);
        }
    }//GEN-LAST:event_pessoajuridicaStateChanged

    private void txtConfirmacaoEnderecoEntregaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtConfirmacaoEnderecoEntregaItemStateChanged
        if (txtConfirmacaoEnderecoEntrega.getSelectedItem().equals("Não")) {
            tab2.setSelectedIndex(1);
        }

    }//GEN-LAST:event_txtConfirmacaoEnderecoEntregaItemStateChanged

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked

        pessoafisica.setSelected(true);

        pessoajuridica.setSelected(false);

    }//GEN-LAST:event_jLabel35MouseClicked

    private void txtcepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcepFocusLost
        setaEnderecoViaCep(txtcep.getText().trim());
    }//GEN-LAST:event_txtcepFocusLost

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        txtcpf.setText("");
        txtrg.setText("");
        txtapelido.setText("");
        txtnome.setText("");
        txtendereco.setText("");
        txtemail.setText("");
        txtprofissao.setText("");
        txtnascimento.setText("");
        txtobs.setText("");
        txtCepEntrega.setText("");
        txtcep.setText("");
        txtlimite.setValue(BigDecimal.ZERO);
        txtpai.setText("");
        txtmae.setText("");
        txtconjugue.setText("");
        btngrava.setEnabled(true);
        btnnovo.setEnabled(false);
        
        txtfone.setText("");
        txtbairro.setText("");
        txtcidade.setText("");
        txtcelular.setText("");
        txtreferencia.setText("");
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnatualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizaActionPerformed
        if (!txtnome.getText().equals("") && !txtcpf.getText().equals("") && !txtrg.getText().equals("")) {

            Cliente cliente = new ClienteDao().clientePorCodigo(Long.parseLong(txtid.getText().trim()));

            if (txtnumero.getText().equals("")) {
                txtnumero.setText("0");
            }

            cliente.setCpf(txtcpf.getText());
            cliente.setApelido(txtapelido.getText());
            cliente.setRg(txtrg.getText());
            cliente.setMae(txtmae.getText());
            cliente.setPai(txtpai.getText());
            cliente.setDatacadastro(txtdata.getText());
            cliente.setCompanheiro(txtconjugue.getText());
            cliente.setEmail(txtemail.getText());
            cliente.setTelefone(txtcelular.getText());
            cliente.setCelular(txtcelular.getText());
            cliente.setObs(txtobs.getText());
            cliente.setEstadocivil(txtescivil.getSelectedItem().toString());
            cliente.setSexo(txtsexo.getSelectedItem().toString());
            cliente.setLimiteCredito(txtlimite.getValue());
            cliente.setProfissao(txtprofissao.getText());

            PessoaJuridica pj = cliente.getPessoaJuridica();
            pj.setNomeFantasia(txtnome.getText());
            pj.setCnpj(txtcnpj.getText());
            pj.setIe(txtie.getText());
            pj.setIm(txtim.getText());
            pj.setRazaosocial(txtrazao.getText());
            cliente.setPessoaJuridica(pj);

            if (pessoafisica.isSelected()) {
                cliente.setTipo("PESSOA FISICA");
            } else {
                cliente.setTipo("PESSOA JURIDICA");
            }

            String bloqueio = null;
            if (block1.isSelected()) {
                bloqueio = "Sim";
            } else if (block2.isSelected()) {
                bloqueio = "Não";
            }

            cliente.setStatus(bloqueio);

            cliente.setNascimento(txtnascimento.getText().trim());

            cliente.getListaEndereco().get(0).setEndereco(txtendereco.getText().toUpperCase());
            cliente.getListaEndereco().get(0).setNumero(Integer.parseInt(txtnumero.getText()));
            cliente.getListaEndereco().get(0).setCidade(txtcidade.getText().toUpperCase());
            cliente.getListaEndereco().get(0).setUf(txtuf.getSelectedItem().toString());
            cliente.getListaEndereco().get(0).setCep(txtcep.getText());
            cliente.getListaEndereco().get(0).setBairro(txtbairro.getText());
            cliente.getListaEndereco().get(0).setReferencia(txtreferencia.getText());
            cliente.getListaEndereco().get(0).setTipo("PRINCIPAL");

            //  enderecoPrincipal.setCliente(cliente);
            // cliente.getListaEndereco().add(enderecoPrincipal);
            if (txtConfirmacaoEnderecoEntrega.getSelectedItem().toString().equals("Não") && cliente.getListaEndereco().size() > 1) {
                cliente.getListaEndereco().get(1).setEndereco(txtenderecoEntrega.getText().toUpperCase());
                cliente.getListaEndereco().get(1).setNumero(Integer.parseInt(txtnumeroEntrega.getText()));
                cliente.getListaEndereco().get(1).setCidade(txtCidadeEntrega.getText().toUpperCase());
                cliente.getListaEndereco().get(1).setUf(txtUfEntrega.getSelectedItem().toString());
                cliente.getListaEndereco().get(1).setCep(txtCepEntrega.getText());
                cliente.getListaEndereco().get(1).setBairro(txtbairroEntrega.getText());
                cliente.getListaEndereco().get(1).setReferencia(txtreferenciaEntrega.getText());
                cliente.getListaEndereco().get(1).setTipo("ENTREGA");

            } else if (txtConfirmacaoEnderecoEntrega.getSelectedItem().toString().equals("Não") && cliente.getListaEndereco().size() == 1) {
                Endereco entrega = new Endereco();
                entrega.setEndereco(txtenderecoEntrega.getText().toUpperCase());
                entrega.setNumero(Integer.parseInt(txtnumeroEntrega.getText()));
                entrega.setCidade(txtCidadeEntrega.getText().toUpperCase());
                entrega.setUf(txtUfEntrega.getSelectedItem().toString());
                entrega.setCep(txtCepEntrega.getText());
                entrega.setBairro(txtbairroEntrega.getText());
                entrega.setReferencia(txtreferenciaEntrega.getText());
                entrega.setTipo("ENTREGA");

                entrega.setCliente(cliente);
                cliente.getListaEndereco().add(entrega);

                System.out.println("executou adicionamento de novo endereco");
            }

            ClienteDao cd = new ClienteDao();
            cd.salvaCliente(cliente);

            JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado com sucesso", "Confirmado", 1);
            TelaClientesCadastrados.mostrarClientes();
            btngrava.setEnabled(false);
            btnnovo.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos o campos", "Não foi possivél", 0);
        }
    }//GEN-LAST:event_btnatualizaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton block1;
    private javax.swing.JRadioButton block2;
    public static javax.swing.JButton btnatualiza;
    public static javax.swing.JButton btngrava;
    private javax.swing.JButton btnnovo;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JRadioButton pessoafisica;
    private javax.swing.JRadioButton pessoajuridica;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTabbedPane tab2;
    private javax.swing.JFormattedTextField txtCepEntrega;
    private javax.swing.JTextField txtCidadeEntrega;
    private javax.swing.JComboBox<String> txtConfirmacaoEnderecoEntrega;
    private javax.swing.JComboBox<String> txtUfEntrega;
    private javax.swing.JTextField txtapelido;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtbairroEntrega;
    private javax.swing.JFormattedTextField txtcelular;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JFormattedTextField txtcnpj;
    private javax.swing.JTextField txtconjugue;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtenderecoEntrega;
    private javax.swing.JComboBox<String> txtescivil;
    private javax.swing.JTextField txtfantasia;
    private javax.swing.JFormattedTextField txtfone;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtie;
    private javax.swing.JFormattedTextField txtim;
    private Utilitarios.JNumberFormatField txtlimite;
    private javax.swing.JTextField txtmae;
    private javax.swing.JFormattedTextField txtnascimento;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtnumeroEntrega;
    private javax.swing.JTextArea txtobs;
    private javax.swing.JTextField txtpai;
    private javax.swing.JTextField txtprofissao;
    private javax.swing.JTextField txtrazao;
    private javax.swing.JTextField txtreferencia;
    private javax.swing.JTextField txtreferenciaEntrega;
    private javax.swing.JTextField txtrg;
    private javax.swing.JComboBox<String> txtsexo;
    private javax.swing.JComboBox<String> txtuf;
    // End of variables declaration//GEN-END:variables
}
