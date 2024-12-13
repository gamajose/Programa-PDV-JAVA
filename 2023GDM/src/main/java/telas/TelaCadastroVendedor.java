/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Utilitarios.BuscadorFoto;
import Utilitarios.DataHora;
import Utilitarios.WebServiceCep;
import repositorio.DepartamentoDAO;
import repositorio.VendedorDao;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Cargo;
import model.DadosBancarios;
import model.Departamento;
import model.Endereco;
import model.Usuario;
import model.Vendedor;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaCadastroVendedor extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = -828569306745131108L;
    public static String fotoFuncionarioPath = "";

    /**
     * Creates new form TelaCadastroVendedor
     */
    public TelaCadastroVendedor() {
        initComponents();
        setaDepartametos();

        setaCargosDepartametos(txtdepartamento.getSelectedItem().toString().trim());
        txtadmissao.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        //seta o icone default (padrao) do cadastro do novo funcionario
        foto44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-decision-480.png")));

    }

    public void preparaFormParaEdicao(Vendedor vendedor) {

        txtID.setText(String.valueOf(vendedor.getId()).trim());
        txtnome.setText(vendedor.getNome());
        txtcpf.setText(vendedor.getCpf());
        txtrg.setText(vendedor.getRg());

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtnascimento.setText(fmt.format(vendedor.getNascimento()));
        txtsexo.setSelectedItem(vendedor.getSexo());
        txtestadocivil.setSelectedItem(vendedor.getEstadoCivil());
        txtStatus.setSelectedItem(vendedor.getStatus());

        txtmeta.setText(String.valueOf(vendedor.getMeta()));
        txtsalario.setText(String.valueOf(vendedor.getSalario()));
        txtcnh.setText(vendedor.getCnh());
        txtcargo.setSelectedItem(vendedor.getCargo());
        txtdepartamento.setSelectedItem(vendedor.getDepartamento().getNome());
        txtctps.setText(vendedor.getCtps());

        txtemail.setText(vendedor.getEmail());
        txttelefone1.setText(vendedor.getTelefone());
        txttelefone2.setText(vendedor.getCelular());

        txtobs.setText(vendedor.getObs());

        //informações de usuario
        txtsenha.setText(vendedor.getUsuario().getSenha());
        txtlogin.setText(vendedor.getUsuario().getUsuario());

        if (vendedor.getFoto() != null) {
            foto44.setIcon(new ImageIcon(vendedor.getFoto()));
        } else {
            foto44.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/imagens/icons8-decision-480.png")));
        }

        txtcidade.setText(vendedor.getEnderecos().get(0).getCidade());
        txtbairro.setText(vendedor.getEnderecos().get(0).getBairro());
        txtuf.setSelectedItem(vendedor.getEnderecos().get(0).getUf());
        txtcep.setText(vendedor.getEnderecos().get(0).getCep());
        txtnumero.setText(String.valueOf(vendedor.getEnderecos().get(0).getNumero()));
        txtreferencia.setText(vendedor.getEnderecos().get(0).getReferencia());
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
            System.out.println("não foi possivel encontrar endereço via cep");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcpf = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtrg = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtsexo = new javax.swing.JComboBox<>();
        txtestadocivil = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtnascimento = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtcnh = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtorgaoexp = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtcategoria = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        txtexpedicao = new javax.swing.JFormattedTextField();
        jLabel42 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        tabes = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtcomissao = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtadmissao = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtdepartamento = new javax.swing.JComboBox<>();
        txtctps = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtcargo = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txtpis = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtsalario = new Utilitarios.JNumberFormatField();
        txtmeta = new Utilitarios.JNumberFormatField();
        jButton4 = new javax.swing.JButton();
        txtserie = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtentrada = new javax.swing.JFormattedTextField();
        txtsaida = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtbanco = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        txtagencia = new javax.swing.JTextField();
        txtcontadigito = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtcontacorrente = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        poupancacheck = new javax.swing.JCheckBox();
        txtagdigito = new javax.swing.JTextField();
        txtvariacao = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtlogin = new javax.swing.JTextField();
        txtsenha = new javax.swing.JTextField();
        txtacesso = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtendereco = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtcidade = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtcep = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtuf = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        foto44 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        txttelefone1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txttelefone2 = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Cadastro Funcionário");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações Gerais:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jLabel1.setText("Nome:");

        txtnome.setBackground(new java.awt.Color(255, 255, 204));

        jLabel5.setText("CPF:");

        txtcpf.setBackground(new java.awt.Color(204, 255, 204));
        try {
            txtcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("RG:");

        txtrg.setBackground(new java.awt.Color(255, 225, 255));
        txtrg.setToolTipText("");

        jLabel13.setText("Sexo:");

        txtsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino ", "Feminino" }));

        txtestadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solterio(a)", "Divorciado(a)", "Conjugado(a)", "Viuvo" }));

        jLabel15.setText("Estado Civil:");

        try {
            txtnascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel21.setText("Nascimento:");

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jLabel24.setText("Status:");

        txtcnh.setBackground(new java.awt.Color(153, 255, 204));

        jLabel26.setText("CNH:");

        txtorgaoexp.setBackground(new java.awt.Color(255, 225, 255));

        jLabel35.setText("Orgão Expedição:");

        txtcategoria.setBackground(new java.awt.Color(153, 255, 204));
        txtcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO HABILITADO", "B", "AB", "A", "C", "D", "E", " " }));

        jLabel36.setText("Categoria:");

        txtexpedicao.setBackground(new java.awt.Color(255, 204, 255));
        try {
            txtexpedicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel42.setText("Data Exp.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtnome)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(35, 35, 35))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(txtestadocivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtexpedicao)
                        .addGap(114, 114, 114))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(txtorgaoexp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtcnh)
                        .addComponent(txtcategoria, 0, 164, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(1, 1, 1)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel26))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcnh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(2, 2, 2)
                                .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel35)
                            .addGap(0, 0, 0)
                            .addComponent(txtorgaoexp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15))
                            .addComponent(jLabel36))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtestadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(0, 0, 0)
                        .addComponent(txtexpedicao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabes.setOpaque(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações Trabalhistas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jLabel9.setText("Salário:");

        txtcomissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLabel10.setText("Comissão:");

        jLabel11.setText("Meta:");

        try {
            txtadmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("Admissão: ");

        jLabel14.setText("Departamento:");

        txtdepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtdepartamentoItemStateChanged(evt);
            }
        });

        txtctps.setBackground(new java.awt.Color(204, 255, 204));

        jLabel20.setText("CTPS:");

        jLabel25.setText("Cargo:");

        txtpis.setBackground(new java.awt.Color(204, 255, 204));
        txtpis.setText("0");

        jLabel27.setText("PIS:");

        txtsalario.setBackground(new java.awt.Color(153, 204, 255));
        txtsalario.setForeground(new java.awt.Color(51, 51, 51));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel29.setText("Serie:");

        txtentrada.setBackground(new java.awt.Color(204, 204, 255));
        try {
            txtentrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtentrada.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtsaida.setBackground(new java.awt.Color(204, 204, 255));
        try {
            txtsaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtsaida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel33.setText("Hora Entrada");

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel34.setText("Hora saida:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jButton4)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(txtpis, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel33)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtentrada, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(txtsaida, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcomissao, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtadmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(txtmeta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtctps, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtserie)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel20)
                    .addComponent(jLabel29))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcomissao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtadmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtctps, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmeta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtsaida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tabes.addTab("Informações Trabalhista", jPanel2);

        txtbanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banco do Brasil", "Banco Inter Digital", "Banco Bradesco", "Banco Itau", "Banco Santander", "Banco Safra", "Banco HSBC", "Banco Caixa Economica" }));

        jLabel37.setText("Entidade Bancária:");

        txtagencia.setText("0000");

        txtcontadigito.setText("0");

        jLabel38.setText("Agencia:");

        txtcontacorrente.setText("00000");

        jLabel39.setText("Conta Corrente:");

        poupancacheck.setText("Poupança");
        poupancacheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                poupancacheckItemStateChanged(evt);
            }
        });
        poupancacheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poupancacheckActionPerformed(evt);
            }
        });

        txtagdigito.setText("0");

        txtvariacao.setEditable(false);
        txtvariacao.setText("00");

        jLabel40.setText("Poupança/Variação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtagencia, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(txtcontacorrente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcontadigito, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(txtagdigito))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtvariacao, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(poupancacheck))))
                    .addComponent(txtbanco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtagencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(txtagdigito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poupancacheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontacorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtcontadigito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(txtvariacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tabes.addTab("Informações Bancárias", jPanel1);

        txtacesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limitado", "Administrador", " ", " " }));

        jLabel30.setText("Nivél de Acesso:");

        jLabel31.setText("Login:");

        jLabel32.setText("Senha:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(txtacesso, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtacesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        tabes.addTab("Informações de Usuário", jPanel6);

        txtobs.setColumns(20);
        txtobs.setRows(5);
        jScrollPane1.setViewportView(txtobs);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        tabes.addTab("Observações", jPanel7);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jLabel8.setText("Endereço :");

        txtnumero.setText("0");

        jLabel16.setText("Cidade:");

        jLabel17.setText("Cep:");

        jLabel18.setText("N°:");

        txtcep.setBackground(new java.awt.Color(215, 255, 255));
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

        jLabel19.setText("Bairro");

        txtuf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SP", "MA", "AL", "PI", "BA", "RJ", "MG", "DF", "ES", "GO", "RO", "TO" }));

        jLabel22.setText("UF:");

        jLabel28.setText("Referencia:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcep, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtcidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbairro)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtuf, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtreferencia))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel22)
                    .addComponent(jLabel28))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-soma-24.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clean.png"))); // NOI18N
        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sincronizar-24.png"))); // NOI18N
        btnRefresh.setText("Atualizar");
        btnRefresh.setEnabled(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        foto44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto44.setText("Foto");
        foto44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        foto44.setOpaque(true);

        jLabel41.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel41.setText("Click Duplo para adicionar foto.");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(foto44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(foto44, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel41))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contato:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        txttelefone1.setBackground(new java.awt.Color(204, 255, 204));
        try {
            txttelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Telefone:");

        jLabel4.setText("E-mail:");

        try {
            txttelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel23.setText("Telefone 2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtemail)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 243, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txttelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txttelefone2))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("E-mail / Contatos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabes, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(2, 2, 2)
                        .addComponent(btnCadastrar)))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabes)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void mostrarFoto4x4FuncionarioNoFormulario() {
        javaxt.io.Image image = new javaxt.io.Image(fotoFuncionarioPath);
        // image.setWidth(340); //set width, adjusts height to maintain aspect ratio
        // image.setHeight(160); //set height, adjusts width to maintain aspect ratio
        image.resize(140, 120);
        byte[] b = image.getByteArray();
        foto44.setText("");
        foto44.setIcon(new javax.swing.ImageIcon(b));
    }

    public static void setaDepartametos() {
        String[] departamentos;

        if (DepartamentoDAO.listaDepartamentos().size() > 0) {

            departamentos = new String[DepartamentoDAO.listaDepartamentos().size()];

            try {

                for (int i = 0; i < DepartamentoDAO.listaDepartamentos().size(); i++) {
                    departamentos[i] = DepartamentoDAO.listaDepartamentos().get(i).getNome().toUpperCase();
                }

                txtdepartamento.setModel(new DefaultComboBoxModel<>(departamentos));
            } catch (Exception e) {
                departamentos[0] = "";
            }

        } else {
            departamentos = new String[1];
            departamentos[0] = "nenhum";
            txtdepartamento.setModel(new DefaultComboBoxModel<>(departamentos));
        }

    }

    public static void setaCargosDepartametos(String departamento) {
        String[] cargos;

        List<Cargo> listaCargos = DepartamentoDAO.cargosPordepartamento(departamento);

        if (listaCargos.size() > 0) {

            cargos = new String[listaCargos.size()];

            try {

                for (int i = 0; i < listaCargos.size(); i++) {

                    cargos[i] = listaCargos.get(i).getCargo().toUpperCase();

                }

                txtcargo.setModel(new DefaultComboBoxModel<>(cargos));
            } catch (Exception e) {
                cargos[0] = "";
            }

        } else {
            cargos = new String[1];
            cargos[0] = "nenhum";
            txtcargo.setModel(new DefaultComboBoxModel<>(cargos));
        }
    }

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        if (txtdepartamento.getSelectedItem().toString().equals("NENHUM")) {
            JOptionPane.showMessageDialog(rootPane, "Departamento ou Cargo Inválido", "Atenção ", 0);

        } else {

            if (!txtlogin.getText().isEmpty() && !txtsenha.getText().isEmpty()) {
                int process = 0;
                if (txtcontacorrente.getText().equals("00000") || txtagencia.getText().equals("0000")) {
                    process = JOptionPane.showInternalConfirmDialog(rootPane, "Informações bancarias não foram informadas, ou estão incompletas\n\nDeseja Continuar?\n", "Atenção", JOptionPane.YES_NO_OPTION);
                } else if (txtcontacorrente.getText().equals("") || txtagencia.getText().equals("")) {
                    process = JOptionPane.showInternalConfirmDialog(rootPane, "Informações bancarias não foram informadas, ou estão incompletas\n\nDeseja Continuar?\n", "Atenção", JOptionPane.YES_NO_OPTION);
                }

                if (process == 1) {
                    tabes.setSelectedIndex(1);
                    txtcontacorrente.setBackground(new Color(255, 225, 255));
                } else if (txtnome.getText().isEmpty() || txtcpf.getText().equals("   .   .   -  ")) {
                    JOptionPane.showMessageDialog(rootPane, "Reveja o formulário e preencha todos os campos", "Cadastro incompleto", 0);
                } else {
                    VendedorDao vdao = new VendedorDao();

                    Vendedor vendedor = new Vendedor();
                    vendedor.setNome(txtnome.getText().toUpperCase());
                    vendedor.setCpf(txtcpf.getText());
                    vendedor.setRg(txtrg.getText());
                    vendedor.setCtps(txtctps.getText());
                    vendedor.setCtpsSerie(txtserie.getText());
                    vendedor.setStatus(txtStatus.getSelectedItem().toString());
                    vendedor.setNascimento(LocalDate.now());
                    vendedor.setSexo(txtsexo.getSelectedItem().toString());
                    vendedor.setCargo(txtcargo.getSelectedItem().toString());
                    vendedor.setEstadoCivil(txtestadocivil.getSelectedItem().toString());
                    vendedor.setEmail(txtemail.getText());
                    vendedor.setCnh(txtcnh.getText());
                    vendedor.setCategoria(txtcategoria.getSelectedItem().toString());
                    vendedor.setMeta(txtmeta.getValue());

                    if (!txtcomissao.getText().equals("")) {
                        vendedor.setComissao(((Number) txtcomissao.getValue()).doubleValue());
                    } else {
                        vendedor.setComissao(0.0);
                    }

                    vendedor.setSalario(txtsalario.getValue());
                    vendedor.setTelefone(txttelefone1.getText());
                    vendedor.setCelular(txttelefone2.getText());
                    vendedor.setPis(txtpis.getText());
                    vendedor.setAdmissao(LocalDate.now());

                    vendedor.setJornadaInicio(txtentrada.getText());
                    vendedor.setJornadaFim(txtsaida.getText());
                    vendedor.setOrgaoExpedidor(txtorgaoexp.getText());
                    vendedor.setDataexpedicao(txtexpedicao.getText());

                    DadosBancarios dados = new DadosBancarios();
                    dados.setAgencia(Integer.parseInt(txtagencia.getText()));
                    dados.setConta(Integer.parseInt(txtcontacorrente.getText()));
                    dados.setDigitoAgencia(Integer.parseInt(txtagdigito.getText()));
                    dados.setDigitoConta(Integer.parseInt(txtcontadigito.getText()));
                    dados.setPoupanca(poupancacheck.isSelected());
                    dados.setPoupancaVariacao(Integer.parseInt(txtvariacao.getText()));
                    dados.setBanco(txtbanco.getSelectedItem().toString());
                    vendedor.setDadosBancarios(dados);

                    Endereco endereco = new Endereco();
                    endereco.setBairro(txtbairro.getText());
                    endereco.setCep(txtcep.getText());
                    endereco.setCidade(txtcidade.getText());

                    if (!txtnumero.getText().equals("")) {
                        endereco.setNumero(Integer.parseInt(txtnumero.getText()));
                    } else {
                        endereco.setNumero(0);
                    }

                    endereco.setUf(txtuf.getSelectedItem().toString());
                    endereco.setReferencia(txtreferencia.getText());
                    endereco.setVendedor(vendedor);

                    List<Endereco> listaEnderecos = new ArrayList<>();
                    listaEnderecos.add(endereco);

                    vendedor.setEnderecos(listaEnderecos);

                    List<Vendedor> listaVendedores = new ArrayList<>();
                    listaVendedores.add(vendedor);

                    Departamento dep = new Departamento();
                    dep = DepartamentoDAO.departamentoPorNome(txtdepartamento.getSelectedItem().toString().trim());
                    dep.setVendedores(listaVendedores);

                    vendedor.setDepartamento(dep);

                    if (!"".equals(fotoFuncionarioPath)) {
                        javaxt.io.Image image = new javaxt.io.Image(fotoFuncionarioPath);
                        image.resize(110, 120);
                        byte[] b = image.getByteArray();
                        vendedor.setFoto(b);
                    }

                    Usuario user = new Usuario();
                    user.setSenha(txtsenha.getText());
                    user.setUsuario(txtlogin.getText());
                    user.setNivelAcesso(txtacesso.getSelectedItem().toString());
                    user.setFuncionario(vendedor);
                    vendedor.setUsuario(user);

                    vdao.salvaVendedor(vendedor);
                    JOptionPane.showMessageDialog(rootPane, "Vendedor cadastrado com sucesso.", "Confirmado", 1);
                    btnCadastrar.setEnabled(false);
                    TelaFuncionariosCadastrados.mostrarVendedores();

                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Entre na Aba Informações de Usuário e informe um login e senha.", "Atenção", 0);
                tabes.setSelectedIndex(2);
            }
        }
        //    foto44.setIcon(new ImageIcon(vendedor.getFoto()));
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaCadastroDepartamentos tc = new TelaCadastroDepartamentos(null, closable);
        tc.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtdepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtdepartamentoItemStateChanged
        //   System.out.println("item selecionado");
        txtcargo.invalidate();

        setaCargosDepartametos(txtdepartamento.getSelectedItem().toString().trim());// TODO add your handling code here:
        txtcargo.repaint();
    }//GEN-LAST:event_txtdepartamentoItemStateChanged

    private void poupancacheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poupancacheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poupancacheckActionPerformed

    private void poupancacheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_poupancacheckItemStateChanged
        if (poupancacheck.isSelected()) {
            txtvariacao.setEditable(true);
        } else {
            txtvariacao.setEditable(false);
        }
    }//GEN-LAST:event_poupancacheckItemStateChanged

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        if (evt.getClickCount() == 2) {
            BuscadorFoto bf = new BuscadorFoto(null, closable);
            bf.setVisible(true);
        }
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limparFormulario();

        TelaCadastroVendedor.btnRefresh.setEnabled(false);
        TelaCadastroVendedor.btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void limparFormulario() {
        txtcpf.setText("");
        txtrg.setText("");
        txtctps.setText("");
        txtnome.setText("");
        txtendereco.setText("");
        txtemail.setText("");
        txtcnh.setText("");
        txtnascimento.setText("");
        txtobs.setText("");
        txtlogin.setText("");
        txtcep.setText("");
        txtsalario.setValue(BigDecimal.ZERO);
        txtsenha.setText("");
        txtpis.setText("0");
        txttelefone1.setText("");
        txttelefone2.setText("");
        txtorgaoexp.setText("");
        txtexpedicao.setText("");
        txtmeta.setText("0");
        txtadmissao.setText(new DataHora().ler_Data());
        txtagencia.setText("0000");
        txtcontacorrente.setText("00000");
        txtcomissao.setText("");
        txtentrada.setText("");
        txtsaida.setText("");
        txtserie.setText("");

        foto44.removeAll();
        foto44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-decision-480.png")));
    }

    private void txtcepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcepFocusLost
        setaEnderecoViaCep(txtcep.getText().trim());
    }//GEN-LAST:event_txtcepFocusLost

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        if (txtdepartamento.getSelectedItem().toString().equals("NENHUM")) {
            JOptionPane.showMessageDialog(rootPane, "Departamento ou Cargo Inválido", "Atenção ", 0);

        } else {

            if (!txtlogin.getText().isEmpty() && !txtsenha.getText().isEmpty()) {
                int process = 0;
                if (txtcontacorrente.getText().equals("00000") || txtagencia.getText().equals("0000")) {
                    process = JOptionPane.showInternalConfirmDialog(rootPane, "Informações bancarias não foram informadas, ou estão incompletas\n\nDeseja Continuar?\n", "Atenção", JOptionPane.YES_NO_OPTION);
                } else if (txtcontacorrente.getText().equals("") || txtagencia.getText().equals("")) {
                    process = JOptionPane.showInternalConfirmDialog(rootPane, "Informações bancarias não foram informadas, ou estão incompletas\n\nDeseja Continuar?\n", "Atenção", JOptionPane.YES_NO_OPTION);
                }

                if (process == 1) {
                    tabes.setSelectedIndex(1);
                    txtcontacorrente.setBackground(new Color(255, 225, 255));
                } else if (txtnome.getText().isEmpty() || txtcpf.getText().equals("   .   .   -  ")) {
                    JOptionPane.showMessageDialog(rootPane, "Reveja o formulário e preencha todos os campos", "Cadastro incompleto", 0);
                } else {
                    VendedorDao vdao = new VendedorDao();

                    Vendedor vendedor = vdao.vendedorByCodigo(Long.parseLong(txtID.getText())).get();
                    vendedor.setId(Long.parseLong(txtID.getText()));
                    vendedor.setNome(txtnome.getText().toUpperCase());
                    vendedor.setCpf(txtcpf.getText());
                    vendedor.setRg(txtrg.getText());
                    vendedor.setCtps(txtctps.getText());
                    vendedor.setCtpsSerie(txtserie.getText());
                    vendedor.setStatus(txtStatus.getSelectedItem().toString());
                    vendedor.setNascimento(LocalDate.now());
                    vendedor.setSexo(txtsexo.getSelectedItem().toString());
                    vendedor.setCargo(txtcargo.getSelectedItem().toString());
                    vendedor.setEstadoCivil(txtestadocivil.getSelectedItem().toString());
                    vendedor.setEmail(txtemail.getText());
                    vendedor.setCnh(txtcnh.getText());
                    vendedor.setCategoria(txtcategoria.getSelectedItem().toString());
                    vendedor.setMeta(txtmeta.getValue());

                    if (!txtcomissao.getText().equals("")) {
                        vendedor.setComissao(((Number) txtcomissao.getValue()).doubleValue());
                    } else {
                        vendedor.setComissao(0.0);
                    }

                    vendedor.setSalario(txtsalario.getValue());
                    vendedor.setTelefone(txttelefone1.getText());
                    vendedor.setCelular(txttelefone2.getText());
                    vendedor.setPis(txtpis.getText());
                    vendedor.setAdmissao(LocalDate.now());

                    vendedor.setJornadaInicio(txtentrada.getText());
                    vendedor.setJornadaFim(txtsaida.getText());
                    vendedor.setOrgaoExpedidor(txtorgaoexp.getText());
                    vendedor.setDataexpedicao(txtexpedicao.getText());

                    // DadosBancarios dados = vendedor.getDadosBancarios();
                    vendedor.getDadosBancarios().setAgencia(Integer.parseInt(txtagencia.getText()));
                    vendedor.getDadosBancarios().setConta(Integer.parseInt(txtcontacorrente.getText()));
                    vendedor.getDadosBancarios().setDigitoAgencia(Integer.parseInt(txtagdigito.getText()));
                    vendedor.getDadosBancarios().setDigitoConta(Integer.parseInt(txtcontadigito.getText()));
                    vendedor.getDadosBancarios().setPoupanca(poupancacheck.isSelected());
                    vendedor.getDadosBancarios().setPoupancaVariacao(Integer.parseInt(txtvariacao.getText()));
                    vendedor.getDadosBancarios().setBanco(txtbanco.getSelectedItem().toString());
                    // vendedor.setDadosBancarios(dados);

                    vendedor.getEnderecos().get(0).setBairro(txtbairro.getText());
                    vendedor.getEnderecos().get(0).setCep(txtcep.getText());
                    vendedor.getEnderecos().get(0).setCidade(txtcidade.getText());

                    if (!txtnumero.getText().equals("")) {
                        vendedor.getEnderecos().get(0).setNumero(Integer.parseInt(txtnumero.getText()));
                    } else {
                        vendedor.getEnderecos().get(0).setNumero(0);
                    }

                    vendedor.getEnderecos().get(0).setUf(txtuf.getSelectedItem().toString());
                    vendedor.getEnderecos().get(0).setReferencia(txtreferencia.getText());
                    vendedor.getEnderecos().get(0).setVendedor(vendedor);

                    //List<Endereco> listaEnderecos = new ArrayList<>();
                    // listaEnderecos.add(endereco);
                    // vendedor.setEnderecos(listaEnderecos);
                    //  List<Vendedor> listaVendedores = new ArrayList<>();
                    //  listaVendedores.add(vendedor);
                    //  Departamento dep = vendedor.getDepartamento();
                    // dep = DepartamentoDAO.departamentoPorNome(txtdepartamento.getSelectedItem().toString().trim());
                    //  dep.setVendedores(listaVendedores);
                    // vendedor.setDepartamento(dep);
                    if (!"".equals(fotoFuncionarioPath)) {
                        javaxt.io.Image image = new javaxt.io.Image(fotoFuncionarioPath);
                        image.resize(110, 120);
                        byte[] b = image.getByteArray();
                        vendedor.setFoto(b);
                    }

                    // Usuario user = new Usuario();
                    vendedor.getUsuario().setSenha(txtsenha.getText());
                    vendedor.getUsuario().setUsuario(txtlogin.getText());
                    vendedor.getUsuario().setNivelAcesso(txtacesso.getSelectedItem().toString());
                    //  vendedor.getUsuario().setFuncionario(vendedor);
                    //  vendedor.setUsuario(user);

                    vdao.salvaVendedor(vendedor);
                    JOptionPane.showMessageDialog(rootPane, "Vendedor cadastrado com sucesso.", "Confirmado", 1);
                    btnCadastrar.setEnabled(false);
                    TelaFuncionariosCadastrados.mostrarVendedores();

                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Entre na Aba Informações de Usuário e informe um login e senha.", "Atenção", 0);
                tabes.setSelectedIndex(2);
            }
        }

    }//GEN-LAST:event_btnRefreshActionPerformed

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCadastrar;
    public static javax.swing.JButton btnRefresh;
    public static javax.swing.JLabel foto44;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox poupancacheck;
    private javax.swing.JTabbedPane tabes;
    private javax.swing.JLabel txtID;
    private javax.swing.JComboBox<String> txtStatus;
    private javax.swing.JComboBox<String> txtacesso;
    private javax.swing.JFormattedTextField txtadmissao;
    private javax.swing.JTextField txtagdigito;
    private javax.swing.JTextField txtagencia;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JComboBox<String> txtbanco;
    public static javax.swing.JComboBox<String> txtcargo;
    private javax.swing.JComboBox<String> txtcategoria;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JTextField txtcnh;
    private javax.swing.JFormattedTextField txtcomissao;
    private javax.swing.JTextField txtcontacorrente;
    private javax.swing.JTextField txtcontadigito;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JTextField txtctps;
    public static javax.swing.JComboBox<String> txtdepartamento;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JFormattedTextField txtentrada;
    private javax.swing.JComboBox<String> txtestadocivil;
    private javax.swing.JFormattedTextField txtexpedicao;
    private javax.swing.JTextField txtlogin;
    private Utilitarios.JNumberFormatField txtmeta;
    private javax.swing.JFormattedTextField txtnascimento;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextArea txtobs;
    private javax.swing.JTextField txtorgaoexp;
    private javax.swing.JTextField txtpis;
    private javax.swing.JTextField txtreferencia;
    private javax.swing.JTextField txtrg;
    private javax.swing.JFormattedTextField txtsaida;
    private Utilitarios.JNumberFormatField txtsalario;
    private javax.swing.JTextField txtsenha;
    private javax.swing.JTextField txtserie;
    private javax.swing.JComboBox<String> txtsexo;
    private javax.swing.JFormattedTextField txttelefone1;
    private javax.swing.JFormattedTextField txttelefone2;
    private javax.swing.JComboBox<String> txtuf;
    private javax.swing.JTextField txtvariacao;
    // End of variables declaration//GEN-END:variables
}
