package telas;

import Utilitarios.Sendmail;
import Utilitarios.SetaHoraRealTime;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import relatorio.GeraRelatorioUtil;
import repositorio.CategoriaDao;
import repositorio.UsuarioDao;

public class TelaMasterApp extends javax.swing.JFrame {

    private static final long serialVersionUID = -8329703888482222133L;
    private TelaCadastroProduto telaprodutos;
    private TelaCadastroVendedor telaCadastroVendedor;
    private TelaCadastroFornecedor cadastroFornecedor;
    private TelaPedidoVenda telaPedidoVenda;
    private TelaClientesCadastrados masterCliente;
    private TelaMasterCaixa masterCaixa;
    private TelaFuncionariosCadastrados telaFuncionariosCadastrados;

    private TelaGerenciarVendas gerenciarVendas;
    private static TelaMasterVenda masterVenda;
    private TelaContas telacontas;

    public TelaMasterApp() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        //  new Thread(syncronizar()).start();
        SetaHoraRealTime hora = new SetaHoraRealTime();
        hora.start();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        toolkit.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, Boolean.TRUE);

    }

//    public static Runnable syncronizar() {
//        Runnable backgroundSync = () -> {
//            try {
//                boolean sync = true;
//                int cont = 0;
//                while (sync) {
//                    System.out.println("syncronizando..." + cont);
//                    Thread.sleep(5000);
//
//                    if (cont == 10) {
//                        sync = false;
//                    }
//                    cont++;
//                }
//            } catch (InterruptedException ex) {
//                System.out.println(ex.getMessage());
//            }
//        };
//        return backgroundSync;
//    }
    public Image icone() {
        return new ImageIcon(getClass().getResource("/imagens/ico_main.png")).getImage();
    }

    public static TelaMasterVenda getTelaMadsterVendaPDV() {
        if (masterVenda == null) {
            masterVenda = new TelaMasterVenda();
        }
        return masterVenda;
    }

    public static JDesktopPane getDisplay() {
        if (desktopMaster == null) {
            desktopMaster = new JDesktopPane();
        }
        return desktopMaster;
    }

    public static void setaHoraRealTimeApp(String hora) {
        txtHora.setText(hora);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopMaster = new javax.swing.JDesktopPane();
        statusProgress = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        txtHora = new javax.swing.JLabel();
        txtinfoUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtinfoUserId = new javax.swing.JLabel();
        txt_ativacao = new javax.swing.JLabel();
        toobar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Toobar2 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnAbrePdv = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        jButton11 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        jMenuItem26 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem27 = new javax.swing.JMenuItem();
        jSeparator29 = new javax.swing.JPopupMenu.Separator();
        jMenuItem30 = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jMenuItem23 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jMenuItem21 = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GDM Softwares");
        setIconImage(icone());
        setSize(new java.awt.Dimension(1024, 640));

        desktopMaster.setBackground(new java.awt.Color(163, 184, 204));

        statusProgress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        statusProgress.setForeground(new java.awt.Color(102, 153, 255));
        statusProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusProgress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroud.png"))); // NOI18N

        desktopMaster.setLayer(statusProgress, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopMasterLayout = new javax.swing.GroupLayout(desktopMaster);
        desktopMaster.setLayout(desktopMasterLayout);
        desktopMasterLayout.setHorizontalGroup(
            desktopMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        desktopMasterLayout.setVerticalGroup(
            desktopMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 497, Short.MAX_VALUE)
        );

        ProgressBar.setBorder(null);

        txtHora.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtHora.setText("jLabel1");

        txtinfoUser.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtinfoUser.setText("------");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Usuário Logado: ");

        txtinfoUserId.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtinfoUserId.setText("00");

        txt_ativacao.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        txt_ativacao.setText("Licença 0 dias restantes");
        txt_ativacao.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHora)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtinfoUserId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtinfoUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_ativacao)
                .addGap(18, 18, 18)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora)
                    .addComponent(txtinfoUser)
                    .addComponent(jLabel1)
                    .addComponent(txtinfoUserId)
                    .addComponent(txt_ativacao))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        toobar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-folha-de-pagamento-48.png"))); // NOI18N
        jButton1.setText("   Clientes   ");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toobar1.add(jButton1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-administrador-masculino-48.png"))); // NOI18N
        jButton4.setText("   Funcionários   ");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        toobar1.add(jButton4);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-caminhão-selecionado-48.png"))); // NOI18N
        jButton2.setText("   Fornecedores   ");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        toobar1.add(jButton2);

        jSeparator8.setSeparatorSize(new java.awt.Dimension(2, 30));
        toobar1.add(jSeparator8);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mover-por-carrinho-48.png"))); // NOI18N
        jButton3.setText("    Produtos    ");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        toobar1.add(jButton3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-contabilidade-48.png"))); // NOI18N
        jButton5.setText("    Estoque    ");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        toobar1.add(jButton5);

        Toobar2.setRollover(true);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-renovar-assinatura-48.png"))); // NOI18N
        jButton6.setText("   Pedidos   ");
        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Toobar2.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-caixa-registradora-48.png"))); // NOI18N
        jButton7.setText("     Caixa     ");
        jButton7.setBorderPainted(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Toobar2.add(jButton7);

        btnAbrePdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-atualizar-o-código-de-barras-48.png"))); // NOI18N
        btnAbrePdv.setText("    Vendas  PDV   ");
        btnAbrePdv.setBorderPainted(false);
        btnAbrePdv.setFocusable(false);
        btnAbrePdv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrePdv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrePdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrePdvActionPerformed(evt);
            }
        });
        Toobar2.add(btnAbrePdv);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-dinheiro-48.png"))); // NOI18N
        jButton8.setText("    Contas   ");
        jButton8.setBorderPainted(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Toobar2.add(jButton8);
        Toobar2.add(jSeparator20);

        jButton11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-desligar-48.png"))); // NOI18N
        jButton11.setText("                    Encerrar Sistema");
        jButton11.setBorderPainted(false);
        jButton11.setFocusable(false);
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        Toobar2.add(jButton11);

        jMenu1.setText("Arquivos");
        jMenu1.add(jSeparator1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-grupos-de-usuários-24.png"))); // NOI18N
        jMenuItem3.setText("Colaboradores");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fornecedor-24.png"))); // NOI18N
        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mover-por-carrinho-24.png"))); // NOI18N
        jMenuItem5.setText("Estoque");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator4);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-contabilidade-24.png"))); // NOI18N
        jMenu10.setText("Pedidos");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-contabilidade-24.png"))); // NOI18N
        jMenuItem6.setText("Pedidos e Orçamentos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem6);
        jMenu10.add(jSeparator28);

        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAVE.png"))); // NOI18N
        jMenuItem28.setText("Historico de Pedidos e Orçamentos");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem28);

        jMenu1.add(jMenu10);
        jMenu1.add(jSeparator5);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-loja-24.png"))); // NOI18N
        jMenu8.setText("Vendas");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-loja-24.png"))); // NOI18N
        jMenuItem7.setText("Venda PDV");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem7);
        jMenu8.add(jSeparator24);

        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FINANCE.png"))); // NOI18N
        jMenuItem26.setText("Gerenciador de Vendas");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem26);

        jMenu1.add(jMenu8);
        jMenu1.add(jSeparator6);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-entrega-de-comida-24.png"))); // NOI18N
        jMenuItem8.setText("Fornecedores");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);
        jMenu1.add(jSeparator7);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-conta-24.png"))); // NOI18N
        jMenu4.setText("Relatórios");

        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-impressão-48.png"))); // NOI18N
        jMenuItem29.setText("Produtos Cadastrados e Serviços");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem29);

        jMenu1.add(jMenu4);
        jMenu1.add(jSeparator9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-canais-de-distribuição-24.png"))); // NOI18N
        jMenuItem10.setText("Produtos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);
        jMenu1.add(jSeparator10);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        jMenuItem9.setText("Fechar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Configurações");

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ico_main.png"))); // NOI18N
        jMenuItem18.setText("Dados da Empresa");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);
        jMenu2.add(jSeparator19);

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-barra-de-navegação-superior-48.png"))); // NOI18N
        jMenuItem19.setText("Ocultar / Exibir Menu");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);
        jMenu2.add(jSeparator26);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-menu-de-usuário-24.png"))); // NOI18N
        jMenu9.setText("Usuários");

        jMenuItem27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-configurações24.png"))); // NOI18N
        jMenuItem27.setText("Gerenciamento de usuários");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem27);

        jMenu2.add(jMenu9);
        jMenu2.add(jSeparator29);

        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-configurações24.png"))); // NOI18N
        jMenuItem30.setText("Configurações Adicionais");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem30);
        jMenu2.add(jSeparator25);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sincronizar-24.png"))); // NOI18N
        jMenuItem1.setText("Modo Claro / Escuro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Financeiro");
        jMenu6.add(jSeparator18);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-caixa-registradora-24.png"))); // NOI18N
        jMenu7.setText("Caixa");

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png"))); // NOI18N
        jMenuItem20.setText("Criar Caixa");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem20);
        jMenu7.add(jSeparator23);

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FLUXO.png"))); // NOI18N
        jMenuItem23.setText("Movimentação");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem23);

        jMenu6.add(jMenu7);
        jMenu6.add(jSeparator21);

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CARD.png"))); // NOI18N
        jMenuItem21.setText("Cartões Débito / Crédito");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem21);
        jMenu6.add(jSeparator22);

        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-dinheiro-24.png"))); // NOI18N
        jMenuItem22.setText("Contas Pagar / Receber");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem22);
        jMenu6.add(jSeparator27);

        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CHEQUE.png"))); // NOI18N
        jMenuItem24.setText("Cheques");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem24);

        jMenuBar1.add(jMenu6);

        jMenu3.setText("Ferramentas");
        jMenu3.add(jSeparator12);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-calculadora-24.png"))); // NOI18N
        jMenuItem12.setText("Calculadora");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);
        jMenu3.add(jSeparator13);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-enviar-e-mail-em-massa-24.png"))); // NOI18N
        jMenuItem13.setText("Envio de E-mail");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);
        jMenu3.add(jSeparator14);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/INTERNET-24.png"))); // NOI18N
        jMenuItem14.setText("Navegador Web");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);
        jMenu3.add(jSeparator15);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-folha-de-papel-24.png"))); // NOI18N
        jMenuItem15.setText("Bloco de Notas");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);
        jMenu3.add(jSeparator16);

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAVE.png"))); // NOI18N
        jMenuItem17.setText("Backup");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Ajuda");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sinal-de-informação-quadrado-24.png"))); // NOI18N
        jMenuItem2.setText("Sobre o Sistema");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);
        jMenu5.add(jSeparator11);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-ajuda-24.png"))); // NOI18N
        jMenuItem11.setText("Manual do Sistema");
        jMenu5.add(jMenuItem11);
        jMenu5.add(jSeparator17);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-baixar-atualizações-24.png"))); // NOI18N
        jMenuItem16.setText("Atualizações");
        jMenuItem16.setEnabled(false);
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopMaster)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toobar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Toobar2, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(toobar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Toobar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(desktopMaster)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaConsultaEstoque ce = new TelaConsultaEstoque();
        ce.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            TelaMasterVenda v = new TelaMasterVenda();
            desktopMaster.add(v);
            v.setVisible(true);
            toobar1.setVisible(false);
            Toobar2.setVisible(false);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = v.getSize();
            v.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2 + 40);
            v.setSelected(true);
            TelaMasterVenda.txtcodigo.requestFocus();

        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            if (telaCadastroVendedor == null) {
                telaCadastroVendedor = new TelaCadastroVendedor();
                desktopMaster.add(telaCadastroVendedor);
            }
            telaCadastroVendedor.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = telaCadastroVendedor.getSize();
            telaCadastroVendedor.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            telaCadastroVendedor.setSelected(true);

        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            if (cadastroFornecedor == null) {
                cadastroFornecedor = new TelaCadastroFornecedor();
                desktopMaster.add(cadastroFornecedor);

            }
            cadastroFornecedor.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = cadastroFornecedor.getSize();
            cadastroFornecedor.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            cadastroFornecedor.setSelected(true);

        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            if (telaPedidoVenda == null) {
                telaPedidoVenda = new TelaPedidoVenda();
                desktopMaster.add(telaPedidoVenda);

            }
            telaPedidoVenda.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = telaPedidoVenda.getSize();
            telaPedidoVenda.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            telaPedidoVenda.setSelected(true);

        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        ProgressBar.setStringPainted(true);
        ProgressBar.setFont(new Font("arial", Font.BOLD, 9));
        ProgressBar.setString("Aguarde...");
        ProgressBar.setIndeterminate(true);
        statusProgress.setText("Carregando...");

        SwingWorker work = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    if (telaprodutos == null) {
                        telaprodutos = new TelaCadastroProduto();
                        desktopMaster.add(telaprodutos);
                    }

                    Dimension desktopSize = desktopMaster.getSize();
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

                } catch (PropertyVetoException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro abrir a janela cadastro de produtos", "ops..", 0);
                } finally {
                    ProgressBar.setString("");
                    ProgressBar.setIndeterminate(false);
                    statusProgress.setText("");

                }
                return null;
            }
        };

        work.execute();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if (masterCliente == null) {
                masterCliente = new TelaClientesCadastrados();
                desktopMaster.add(masterCliente);
            }

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = masterCliente.getSize();
            masterCliente.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            masterCliente.setSelected(true);
            masterCliente.setVisible(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ProgressBar.setStringPainted(true);
        ProgressBar.setFont(new Font("arial", Font.BOLD, 9));
        ProgressBar.setString("Aguarde...");
        ProgressBar.setIndeterminate(true);
        // statusProgress.setText("");

        SwingWorker work = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    if (telaprodutos == null) {
                        telaprodutos = new TelaCadastroProduto();
                        desktopMaster.add(telaprodutos);
                    }

                    Dimension desktopSize = desktopMaster.getSize();
                    Dimension screenSize = telaprodutos.getSize();
                    telaprodutos.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
                    telaprodutos.setSelected(true);
                    telaprodutos.toFront();

                    if (CategoriaDao.verificaSeExistiCategoriaCadastrada() == true) {
                        TelaCadastroProduto.setaCategorias();
                    } else {
                        TelaCadastroProduto.categoria.setModel(
                                new DefaultComboBoxModel<>(new String[]{"Categoria não cadastrada"}));;
                    }

                    TelaCadastroProduto.setaFornecedoresBox();

                    telaprodutos.setVisible(true);

                } catch (PropertyVetoException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro abrir a janela cadastro de produtos", "ops..", 0);
                } finally {
                    ProgressBar.setString("");
                    ProgressBar.setIndeterminate(false);
                    statusProgress.setText("");

                }
                return null;
            }
        };

        work.execute();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if (telaPedidoVenda == null) {
                telaPedidoVenda = new TelaPedidoVenda();
                desktopMaster.add(telaPedidoVenda);

            }
            telaPedidoVenda.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = telaPedidoVenda.getSize();
            telaPedidoVenda.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            telaPedidoVenda.setSelected(true);

        } catch (PropertyVetoException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if (telaFuncionariosCadastrados == null) {
                telaFuncionariosCadastrados = new TelaFuncionariosCadastrados();
                desktopMaster.add(telaFuncionariosCadastrados);
            }
            telaFuncionariosCadastrados.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = telaFuncionariosCadastrados.getSize();
            telaFuncionariosCadastrados.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            telaFuncionariosCadastrados.setSelected(true);

        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (cadastroFornecedor == null) {
                cadastroFornecedor = new TelaCadastroFornecedor();
                desktopMaster.add(cadastroFornecedor);

            }
            cadastroFornecedor.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = cadastroFornecedor.getSize();
            cadastroFornecedor.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            cadastroFornecedor.setSelected(true);

        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        TelaConsultaEstoque ce = new TelaConsultaEstoque();
        ce.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        TelaBackupRestore tb = new TelaBackupRestore();
        tb.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        TelaDadosGeralSistema ts = new TelaDadosGeralSistema(this, rootPaneCheckingEnabled);
        ts.setVisible(true);

    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaAbout ab = new TelaAbout(this, rootPaneCheckingEnabled);
        ab.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            if (masterCaixa == null) {
                masterCaixa = new TelaMasterCaixa();
                desktopMaster.add(masterCaixa);

            }
            masterCaixa.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = masterCaixa.getSize();
            masterCaixa.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            masterCaixa.setSelected(true);
            masterCaixa.toFront();

        } catch (PropertyVetoException ex) {
        } finally {
            TelaMasterCaixa.atualizarTabelasLancamentos();
            // new CaixaDao().abrirCaixa(cx);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        TelaCadastroCaixa cx = new TelaCadastroCaixa(this, rootPaneCheckingEnabled);
        cx.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void btnAbrePdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrePdvActionPerformed

        try {
            if (masterVenda == null) {
                masterVenda = new TelaMasterVenda();
                desktopMaster.add(masterVenda);
            }
            masterVenda.setVisible(true);

            toobar1.setVisible(false);
            Toobar2.setVisible(false);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = masterVenda.getSize();
            masterVenda.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2 + 40);
            masterVenda.setSelected(true);
            TelaMasterVenda.txtcodigo.requestFocus();
            masterVenda.toFront();

        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAbrePdvActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        if (!toobar1.isVisible()) {
            toobar1.setVisible(true);
            Toobar2.setVisible(true);
        } else {
            toobar1.setVisible(false);
            Toobar2.setVisible(false);
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Runtime rt = Runtime.getRuntime();

        try {
            rt.exec("calc");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No Windows:Erro ao tentar executar calculadora!");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Runtime rs = Runtime.getRuntime();

        try {
            rs.exec("notepad");
        } catch (IOException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        try {
            if (masterCliente == null) {
                masterCliente = new TelaClientesCadastrados();
                desktopMaster.add(masterCliente);
            }

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = masterCliente.getSize();
            masterCliente.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            masterCliente.setSelected(true);
            masterCliente.setMaximum(true);
            masterCliente.setVisible(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        if (gerenciarVendas == null) {
            gerenciarVendas = new TelaGerenciarVendas();
        }
        gerenciarVendas.setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        try {
            if (masterCaixa == null) {
                masterCaixa = new TelaMasterCaixa();
                desktopMaster.add(masterCaixa);

            }
            masterCaixa.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = masterCaixa.getSize();
            masterCaixa.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            masterCaixa.setSelected(true);

        } catch (PropertyVetoException ex) {
        } finally {
            TelaMasterCaixa.atualizarTabelasLancamentos();
        }
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
            TelaCadastraUsuarios cu = new TelaCadastraUsuarios();
            cu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
        }
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        TelaCartoes cd = new TelaCartoes();
        cd.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        GeraRelatorioUtil gera = new GeraRelatorioUtil();
        gera.geraReletorioProdutosServicos();
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        TelaPedidosEfetuados pe = new TelaPedidosEfetuados();
        pe.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        try {
            if (telacontas == null) {
                telacontas = new TelaContas();
                desktopMaster.add(telacontas);

            }

            telacontas.setVisible(true);

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = telacontas.getSize();
            telacontas.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            telacontas.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        try {
            Runtime rt = Runtime.getRuntime();
            String url = "http://google.com";
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException ex) {
            Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        TelaCheque cheque = new TelaCheque();
        desktopMaster.add(cheque);
        cheque.setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        if (new UsuarioDao().verificaPermissao(TelaMasterApp.txtinfoUser.getText()) == true) {
            TelaConfiguracaoAdicional tf = new TelaConfiguracaoAdicional(this, rootPaneCheckingEnabled);
            tf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem Permissão para esta ação", "Permissão Negada", 0);
        }
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            if (telacontas == null) {
                telacontas = new TelaContas();
                desktopMaster.add(telacontas);

            }

            telacontas.setVisible(true);
            TelaContas.mostrarContasPagar();
            TelaContas.mostrarContasReceber();

            Dimension desktopSize = desktopMaster.getSize();
            Dimension screenSize = telacontas.getSize();
            telacontas.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
            telacontas.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Sendmail email = new Sendmail(this, rootPaneCheckingEnabled);
        email.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed


        if (UIManager.getLookAndFeel().getName().equals("Nimbus")) {
            FlatDarculaLaf.setup(new FlatDarculaLaf());
            FlatDarculaLaf.updateUI();
        } else {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                        FlatDarculaLaf.setup(UIManager.getLookAndFeel());
                        FlatDarculaLaf.updateUI();

                        break;
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(TelaMasterApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        Toobar2.repaint();
        Toobar2.updateUI();

        toobar1.repaint();
        toobar1.updateUI();

        jMenuBar1.repaint();
        jMenuBar1.updateUI();

        jPanel1.repaint();
        jPanel1.updateUI();

        ProgressBar.repaint();
        ProgressBar.updateUI();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }

            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMasterApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            setDefaultLookAndFeelDecorated(true);
            new TelaMasterApp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    public static javax.swing.JToolBar Toobar2;
    public static javax.swing.JButton btnAbrePdv;
    private static javax.swing.JDesktopPane desktopMaster;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JPopupMenu.Separator jSeparator29;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    public static javax.swing.JLabel statusProgress;
    public static javax.swing.JToolBar toobar1;
    private static javax.swing.JLabel txtHora;
    public static javax.swing.JLabel txt_ativacao;
    public static javax.swing.JLabel txtinfoUser;
    protected static javax.swing.JLabel txtinfoUserId;
    // End of variables declaration//GEN-END:variables

    public static int checaInternetConexao() throws Exception {
        Process process = java.lang.Runtime.getRuntime().exec("ping www.google.com");
        int x = process.waitFor();
        if (x == 0) {
            System.out.println("Connection Successful, "
                    + "Output was " + x);
        } else {
            System.out.println("Internet Not Connected, "
                    + "Output was " + x);
        }
        return x;
    }

}
