package telas;

import Utilitarios.DataHora;
import Utilitarios.FormaPagamento;
import Utilitarios.TableMouseListener;
import Utilitarios.TelaAlteraPreco;
import repositorio.CaixaDao;
import repositorio.ClienteDao;
import repositorio.EmpresaDao;
import repositorio.ProdutoDao;
import repositorio.VendaDao;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Caixa;
import model.Cliente;
import model.Empresa;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class TelaMasterVenda extends javax.swing.JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 3612499093313395902L;
    private static List<ItemVenda> itens = new ArrayList<>();
    private Produto produto = new Produto();
    private Venda venda = new Venda();
    private BigDecimal descontoTotalCupomPrint = BigDecimal.ZERO;
    private static Empresa emp;
    private static long numeroVenda;
    private TelaListaProdutos telaListaProdutos;
    private final TableMouseListener tableListener;

    private static DefaultTableModel modelo;

    public TelaMasterVenda() {

        this.listener = (AWTEvent event) -> {
            KeyEvent evt = (KeyEvent) event;
            if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getKeyCode() == KeyEvent.VK_F11) {
                if (modelo.getRowCount() > 0) {
                    TelaFinalizarVenda fv = new TelaFinalizarVenda();
                    TelaFinalizarVenda.setVenda(venda);
                    TelaFinalizarVenda.txttotalVenda.setValue(venda.getTotal());
                    fv.setVisible(true);
                    TelaFinalizarVenda.txtcaixan.setText(cxid.getText().trim());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum item Adicionado", "Erro", 0);
                }
            }
            if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getModifiers() == KeyEvent.CTRL_MASK && evt.getKeyCode() == KeyEvent.VK_C) {

                TelaListaBuscaClientes fv = new TelaListaBuscaClientes(null, closable);
                TelaListaBuscaClientes.setCodigotela(2);
                fv.setVisible(true);

            }
            if (evt.getID() == KeyEvent.KEY_PRESSED
                    && evt.getModifiers() == KeyEvent.CTRL_MASK
                    && evt.getKeyCode() == KeyEvent.VK_G) {
                TelaGerenciarVendas gv = new TelaGerenciarVendas();
                gv.setVisible(true);
            }

            if (evt.getID() == KeyEvent.KEY_PRESSED
                    && evt.getModifiers() == KeyEvent.CTRL_MASK
                    && evt.getKeyCode() == KeyEvent.VK_P) {
                TelaListaProdutos gv = new TelaListaProdutos(null, closable);
                TelaListaProdutos.origemDaChamada = 1;
                gv.setVisible(true);
            }

            if (evt.getID() == KeyEvent.KEY_PRESSED
                    && evt.getKeyCode() == KeyEvent.VK_F9) {

                TelaLogin gv = new TelaLogin();
                gv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                TelaLogin.logoff = true;
                gv.setVisible(true);

            }
        };

        initComponents();

        txtcodigo.requestFocus();
        txtdata.setText("Hoje é " + new DataHora().ler_Data());
        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);

        //seta 0 linha na tabela
        modelo = (DefaultTableModel) tabelapdv.getModel();
        modelo.setNumRows(0);

        //------------------------//-------------------
        CaixaDao cd = new CaixaDao();
        Caixa cx = cd.getCaixaByNome("MASTER-CX");
        cxid.setText(String.valueOf(cx.getId()));
        cxstatux.setText(cx.getStatus());

        //--------------------//-----------------------
        setDadosDoOperador();

        //---------------------carrega dados da empresa para cupom---------------
        emp = new EmpresaDao().dadosDaEmpresa();
        numeroVenda = new VendaDao().getNumeroProximaVendaCupom();

        //prepara opção de alterar preço na tabela pdv
        tableListener = new TableMouseListener(tabelapdv);
        preparaOpenPopupTabela();
        tabelapdv.addMouseListener(tableListener);

    }

    private void setaImagemDefault() {
        txtfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopping-icon.png")));
    }

    private static Venda getVendaAtual(Venda v) {
        return v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Alterar Preço":
               try {
                System.out.println(e.getActionCommand());

                long id = Long.parseLong(tabelapdv.getValueAt(TableMouseListener
                        .getLinhaSelecionada(), 1)
                        .toString());

                Produto prdo = new ProdutoDao().produtoByCodigo(id);

                TelaAlteraPreco tp = new TelaAlteraPreco(prdo);
                tp.setVisible(true);

                break;
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(tabelapdv, "Houve um erro, não é possivel alterar o preço", "Nenhum produto encontrado", 0);
            }
        }
    }

    public final void preparaOpenPopupTabela() {
        JPopupMenu popupMenu = new JPopupMenu("Operações Disponíveis:");

        JMenuItem menuItemAltera = new JMenuItem("Alterar Preço", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));

        menuItemAltera.addActionListener(this);

        popupMenu.add(menuItemAltera);
        //  popupMenu.add(new JSeparator());

        tabelapdv.setComponentPopupMenu(popupMenu);
    }

    //limpa o pdv apos finalizar vendo com sucesso
    public static void limparDadosPdv() {

        modelo = (DefaultTableModel) tabelapdv.getModel();
        modelo.setNumRows(0);
        txtvalorunt.setValue(BigDecimal.ZERO);
        txttotalcompra.setValue(BigDecimal.ZERO);
        txttotalporItens.setValue(BigDecimal.ZERO);
        txtdesconto.setValue(BigDecimal.ZERO);
        lbtotalitens.setText("0");
        txtestoque.setText("0");
        txtcpf.setText("000.000.000-00");
        txtidcliente.setText("0000");
        txtcupom.setText("-");
        txtdesc.setText("-");
        itens.clear();
        numeroVenda = new VendaDao().getNumeroProximaVendaCupom();

    }

    public static void alteraPrecoProdutoTabelaPdv(Produto produto) {
        int linha = tabelapdv.getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) tabelapdv.getModel();
        model.setNumRows(0);

        if (linha != -1) {

            ItemVenda itv = itens.stream().filter(item -> item.getProduto().getCodigo().equals(produto.getCodigo())).findFirst().get();

            ItemVenda item = new ItemVenda();
            item.setQtde(itv.getQtde());
            item.setValorTotal(produto.getPreco().multiply(new BigDecimal(itv.getQtde())).subtract(txtdesconto.getValue()));
            item.setProduto(produto);
            item.setVenda(itv.getVenda());
            item.setValorDesconto(txtdesconto.getValue());
            item.setValorUNT(produto.getPreco());

            itens.removeIf(i -> i.getProduto().getCodigo().equals(produto.getCodigo()));
            itens.add(item);

            int seq = 1;

            NumberFormat format = NumberFormat.getCurrencyInstance();
            Object[] oneRow = new Object[7];

            for (ItemVenda o : itens) {
                oneRow[0] = seq;
                oneRow[1] = o.getProduto().getCodigo();
                oneRow[2] = o.getProduto().getDescricao().toUpperCase();
                oneRow[3] = o.getQtde();
                oneRow[4] = o.getValorUNT();
                oneRow[5] = format.format(o.getValorDesconto());
                oneRow[6] = o.getValorTotal();
                model.addRow(oneRow);
                seq++;
            }

            List<BigDecimal> valores = itens.stream()
                    .map(p -> p.getValorTotal())
                    .collect(Collectors.toList());

            txttotalcompra.setValue(valores.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
            // venda.setTotal(txttotalcompra.getValue());

            //geraCupomNaoFiscalTextAreaParcial();
        } else {
            JOptionPane jOptionPane = new JOptionPane("Erro ao atualizar tabela", 0);
            jOptionPane.setVisible(true);
        }
    }

    public static void setDadosDoOperador() {
        txtCodigoOperador.setText(TelaMasterApp.txtinfoUserId.getText());
        txtNomeOperador.setText(TelaMasterApp.txtinfoUser.getText());
    }

    public void geraCupomNaoFiscalTextAreaParcial() {

        NumberFormat format = new DecimalFormat("#,##0.00");

        txtcupom.setText("");

        txtcupom.append("=============================================\n");
        txtcupom.append("" + emp.getPessoaJuridica().getNomeFantasia() + "\n"
                + emp.getEnderecos().get(0).getEndereco() + "\n"
                + emp.getContato().getTelefone1() + "             "
                + " Venda: " + numeroVenda + "\n");
        txtcupom.append("=============================================\n");
        txtcupom.append("********** NAO E DOCUMENTO FISCAL **********\n");
        txtcupom.append("=============================================\n");
        txtcupom.append("#  PRODUTO        QTDE   VALOR UN.    TOTAL  \n");
        txtcupom.append("---------------------------------------------\n");
        for (int x = 0; x < tabelapdv.getRowCount(); x++) {

            txtcupom.append(String.format("%-3s", tabelapdv.getModel().getValueAt(x, 0)));
            txtcupom.append(String.format("%-15.15s ", tabelapdv.getModel().getValueAt(x, 2)));
            txtcupom.append(String.format("%-7.10s", tabelapdv.getModel().getValueAt(x, 3)));
            txtcupom.append(String.format("%-8s ", tabelapdv.getModel().getValueAt(x, 4)));
            txtcupom.append(String.format("%7s ", tabelapdv.getModel().getValueAt(x, 6)));
            txtcupom.append("\n");
        }
        txtcupom.append("=============================================\n");
        txtcupom.append("   INFORMACOES PARA FECHAMENTO DE CONTA    \n");
        txtcupom.append("=============================================\n");
        txtcupom.append(String.format(" DATA: %1s %2s               \n",
                new DataHora().ler_Data(), new DataHora().ler_hora()));
        txtcupom.append("=============================================\n");
        txtcupom.append("SubTotal                       R$ "
                + format.format(txttotalcompra.getValue().add(descontoTotalCupomPrint)) + "\n");

        txtcupom.append("=============================================\n");
        txtcupom.append("Desconto Total                 R$ " + format.format(descontoTotalCupomPrint) + "\n");
        txtcupom.append("                   --------------------------\n");
        txtcupom.append("Total                          R$ " + format.format(txttotalcompra.getValue()) + "\n");
        txtcupom.append("=============================================\n");
        txtcupom.append("         OBRIGADO. E VOLTE SEMPRE!         \n");
        txtcupom.append("   INFORMACOES PARA FECHAMENTO DE CONTA    \n\n\n");
        txtcupom.append("---------------------------------------------\n\n\n\n\n\n-");
        //codigo para impressora cortar papel
        char[] cortePapel = new char[]{0x1d, 'V', 1};
        txtcupom.append(new String(cortePapel));
        txtcupom.setCaretPosition(0);
    }

    public static void geraCupomNaoFiscal() {
        try {
            File arquivo = new File("C:\\GDM Comercio\\cupom.txt");
            if (arquivo.exists()) {

                arquivo.delete();
                arquivo.createNewFile();
                //se existir
                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);

                String[] lines = txtcupom.getText().replaceAll("Ç", "C")
                        .replace("Ã", "A").split("\n");

                for (String line : lines) {
                    linhasTxt.println(line);
                }

                arquivoTxt.flush();
                linhasTxt.flush();
                arquivoTxt.close();
                linhasTxt.close();

            } else {
                //se naum existir
                new File("C:\\GDM Comercio").mkdirs();
                arquivo.createNewFile();

                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);

                String[] lines = txtcupom.getText().replaceAll("Ç", "C")
                        .replace("Ã", "A").split("\n");

                for (String line : lines) {
                    linhasTxt.println(line);
                }

                arquivoTxt.flush();
                arquivoTxt.close();
                linhasTxt.close();

            }
        } catch (IOException error) {
            System.out.println("nao encontrei arquivo");
        }
        //imprime arquivo 
        try {
            PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob job = ps.createPrintJob();

            job.addPrintJobListener(new PrintJobAdapter() {
                @Override
                public void printDataTransferCompleted(PrintJobEvent event) {
                    System.out.println("Impressão completa..");
                }

                @Override
                public void printJobNoMoreEvents(PrintJobEvent event) {
                    System.out.println("sem eventos de impressão");
                }
            });

            FileInputStream fis = new FileInputStream("C:\\GDM Comercio\\cupom.txt");

            Doc doc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            PrintRequestAttributeSet attrib = new HashPrintRequestAttributeSet();
            attrib.add(new Copies(1));
            job.print(doc, attrib);

            fis.close();

            try {
                Path path = Paths.get("C:\\GDM Comercio\\cupom.txt");
                boolean rsp = Files.deleteIfExists(path);
                System.out.println("Arquivo cupom apagado: " + rsp);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (PrintException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }
    }

    public void mostrarFotoNoPainel(String path) {
        if (path != null && new File(path).exists()) {
            javaxt.io.Image image = new javaxt.io.Image(path);
            image.setWidth(340); //set width, adjusts height to maintain aspect ratio
            image.setHeight(160); //set height, adjusts width to maintain aspect ratio

            byte[] b = image.getByteArray();
            txtfoto.setText("");
            txtfoto.setIcon(new javax.swing.ImageIcon(b));
            txtmsn.setText("Imagem do último produto adicionado");

        } else {
            txtfoto.setText("");
            txtfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopping-icon.png")));
        }
    }

    public void adicionarItem() {

        int qtde = Integer.parseInt(String.valueOf(txtqtde.getValue()));

        produto = new ProdutoDao().produtoByCodigoBarras(txtcodigo.getText().trim());

        if (produto == null) {
            JOptionPane.showMessageDialog(rootPane, "Produto não cadastrado no Sistema", "Atenção Erro", 0,
                    new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-excluir-48.png")));

        } else if (produto.getEstoque().getQtdeDisponivel() < 1) {
            JOptionPane.showMessageDialog(rootPane, "<html><h3>Produto com estoque zerado</h3></html>", "Produto em falta", 0,
                    new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-excluir-48.png")));

        } else if (produto.getEstoque().getQtdeDisponivel() < qtde) {
            JOptionPane.showMessageDialog(rootPane, "<html><h3>Quantidade desejada indisponivél</h3></html>\nQuantidade em Estoque: " + produto.getEstoque().getQtdeDisponivel() + "", "Estoque insuficiente", 0,
                    new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-excluir-48.png")));
        } else {
            //SETA A IMAGEM DO PRODUTO NO PDV
            mostrarFotoNoPainel(produto.getFoto());

            venda.setData(LocalDate.parse(LocalDate.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            ItemVenda item = new ItemVenda();
            item.setQtde(qtde);
            item.setValorTotal(produto.getPreco().multiply(new BigDecimal(qtde)).subtract(txtdesconto.getValue()));
            item.setProduto(produto);
            item.setVenda(venda);
            item.setValorDesconto(txtdesconto.getValue());
            item.setValorUNT(produto.getPreco());

            boolean itemRemovido = false;
            int qtdeApoio = 0;

            if (itens.isEmpty()) {
                itens.add(item);
            } else {
                for (Iterator<ItemVenda> iterator = itens.iterator(); iterator.hasNext();) {
                    ItemVenda next = iterator.next();
                    if (next.getProduto().getCodigo().equals(item.getProduto().getCodigo())) {
                        qtdeApoio = next.getQtde();
                        iterator.remove();
                        itemRemovido = true;
                        break;
                    }
                }
                if (itemRemovido) {

                    item.setQtde(qtdeApoio + (Integer) txtqtde.getValue());

                    if (item.getQtde() > produto.getEstoque().getQtdeDisponivel()) {
                        item.setQtde(produto.getEstoque().getQtdeDisponivel());
                        JOptionPane.showMessageDialog(rootPane, "<html><h3>Quantidade desejada indisponivél</h3></html>\nQuantidade em Estoque: " + produto.getEstoque().getQtdeDisponivel() + "", "Estoque insuficiente", 0,
                                new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-excluir-48.png")));
                    }

                    item.setValorTotal(produto.getPreco().multiply(new BigDecimal(item.getQtde())).subtract(txtdesconto.getValue()));
                    itens.add(item);
                } else {
                    itens.add(item);
                }
            }

            modelo = (DefaultTableModel) tabelapdv.getModel();
            modelo.setNumRows(0);

            int sequence = 1;

            NumberFormat format = NumberFormat.getCurrencyInstance();
            Object[] oneRow = new Object[7];
            for (ItemVenda o : itens) {
                oneRow[0] = sequence;
                oneRow[1] = o.getProduto().getCodigo();
                oneRow[2] = o.getProduto().getDescricao().toUpperCase();
                oneRow[3] = o.getQtde();
                oneRow[4] = o.getValorUNT();
                oneRow[5] = format.format(o.getValorDesconto());
                oneRow[6] = o.getValorTotal();
                modelo.addRow(oneRow);
                sequence++;
            }

            lbtotalitens.setText(String.valueOf(itens.stream().mapToInt(i -> i.getQtde()).sum()));
            txtdesc.setText(produto.getDescricao().toUpperCase());
            txtestoque.setText(String.valueOf(produto.getEstoque().getQtdeDisponivel()));

            List<BigDecimal> valores = itens.stream()
                    .map(p -> p.getValorTotal())
                    .collect(Collectors.toList());

            txttotalporItens.setValue(produto.getPreco().multiply(new BigDecimal((Integer) txtqtde.getValue())));
            txttotalcompra.setValue(valores.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
            txtvalorunt.setValue(produto.getPreco());
            txtdesconto.setValue(BigDecimal.ZERO);

            venda.setTotal(txttotalcompra.getValue());
            venda.setItensVenda(itens);
            venda.setFormaPagamento(FormaPagamento.DINHEIRO);
            venda.setHora(new DataHora().ler_hora());
            venda.setTotalItens(itens.stream().mapToInt(i -> i.getQtde()).sum());

            if (!txtidcliente.getText().equals("0000") && !txtcpf.getText().equals("000.000.000-00")) {
                Cliente c = new Cliente();
                c.setId(Long.parseLong(txtidcliente.getText().trim()));
                venda.setCliente(c);
            }

            venda.setCodigoResponsavel(Integer.parseInt(TelaMasterApp.txtinfoUserId.getText().trim()));
            venda.setReponsavel(TelaMasterApp.txtinfoUser.getText().trim());

            TelaFinalizarVenda.itensVenda = itens;

            List<BigDecimal> valoresDescontos = itens.stream()
                    .map(p -> p.getValorDesconto())
                    .collect(Collectors.toList());

            descontoTotalCupomPrint = valoresDescontos.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

            geraCupomNaoFiscalTextAreaParcial();

        }
    }

    final AWTEventListener listener;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lpane = new javax.swing.JLayeredPane();
        panelrosa = new javax.swing.JPanel();
        txttotalcompra = new Utilitarios.JNumberFormatField();
        jLabel12 = new javax.swing.JLabel();
        lbtotalitens = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelapdv = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcupom = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtvalorunt = new Utilitarios.JNumberFormatField();
        txttotalporItens = new Utilitarios.JNumberFormatField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtqtde = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        txtdesconto = new Utilitarios.JNumberFormatField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtfoto = new javax.swing.JLabel();
        txtdata = new javax.swing.JLabel();
        btnfinalizarvenda = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtmsn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcpf = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cxid = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cxstatux = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeOperador = new javax.swing.JLabel();
        txtCodigoOperador = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdesc = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtestoque = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 204, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("GDM-PDV");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-clicar-e-levantar-48.png"))); // NOI18N

        lpane.setBackground(new java.awt.Color(102, 153, 255));
        lpane.setOpaque(true);

        panelrosa.setBackground(new java.awt.Color(153, 204, 255));

        txttotalcompra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txttotalcompra.setForeground(new java.awt.Color(0, 102, 204));
        txttotalcompra.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total de Itens:");

        lbtotalitens.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbtotalitens.setForeground(new java.awt.Color(255, 255, 255));
        lbtotalitens.setText("0");

        tabelapdv.setBackground(new java.awt.Color(255, 253, 234));
        tabelapdv.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelapdv.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        tabelapdv.setForeground(new java.awt.Color(0, 102, 153));
        tabelapdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Seq.", "Codigo", "Produto", "Qtde", "Valor Unit", "Desconto", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelapdv.setFillsViewportHeight(true);
        tabelapdv.setGridColor(new java.awt.Color(244, 244, 243));
        jScrollPane1.setViewportView(tabelapdv);
        if (tabelapdv.getColumnModel().getColumnCount() > 0) {
            tabelapdv.getColumnModel().getColumn(0).setMinWidth(30);
            tabelapdv.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelapdv.getColumnModel().getColumn(1).setMinWidth(40);
            tabelapdv.getColumnModel().getColumn(1).setMaxWidth(50);
            tabelapdv.getColumnModel().getColumn(2).setMinWidth(165);
            tabelapdv.getColumnModel().getColumn(3).setMinWidth(40);
            tabelapdv.getColumnModel().getColumn(3).setMaxWidth(45);
            tabelapdv.getColumnModel().getColumn(4).setMinWidth(90);
            tabelapdv.getColumnModel().getColumn(4).setMaxWidth(100);
            tabelapdv.getColumnModel().getColumn(6).setMinWidth(90);
            tabelapdv.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jTabbedPane1.addTab("Tabela", jScrollPane1);

        txtcupom.setBackground(new java.awt.Color(255, 253, 225));
        txtcupom.setColumns(20);
        txtcupom.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtcupom.setRows(5);
        jScrollPane2.setViewportView(txtcupom);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cupom", jPanel5);

        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("TOTAL:");

        javax.swing.GroupLayout panelrosaLayout = new javax.swing.GroupLayout(panelrosa);
        panelrosa.setLayout(panelrosaLayout);
        panelrosaLayout.setHorizontalGroup(
            panelrosaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelrosaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelrosaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(panelrosaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbtotalitens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelrosaLayout.setVerticalGroup(
            panelrosaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelrosaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelrosaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(lbtotalitens)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Codigo:");

        txtcodigo.setBackground(new java.awt.Color(255, 255, 204));
        txtcodigo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txtcodigo.setForeground(new java.awt.Color(255, 102, 102));
        txtcodigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Qtde:");

        txtvalorunt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtvalorunt.setForeground(new java.awt.Color(102, 102, 102));
        txtvalorunt.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        txttotalporItens.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txttotalporItens.setForeground(new java.awt.Color(102, 102, 102));
        txttotalporItens.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Valor Unitário:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total:");

        txtqtde.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtqtde.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1100, 1));
        txtqtde.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtqtde.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtqtdeStateChanged(evt);
            }
        });
        txtqtde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqtdeFocusLost(evt);
            }
        });
        txtqtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtqtdeKeyPressed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Valor do Desconto:");

        txtdesconto.setBackground(new java.awt.Color(204, 255, 204));
        txtdesconto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtdesconto.setForeground(new java.awt.Color(102, 102, 102));
        txtdesconto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescontoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Fechar PDV");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtvalorunt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtqtde)
                    .addComponent(txttotalporItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(5, 5, 5)
                .addComponent(txtqtde, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(txtvalorunt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(txtdesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotalporItens, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        txtfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopping-icon.png"))); // NOI18N

        txtdata.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdata.setForeground(new java.awt.Color(255, 255, 255));
        txtdata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtdata.setText("-");

        btnfinalizarvenda.setForeground(new java.awt.Color(0, 102, 204));
        btnfinalizarvenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        btnfinalizarvenda.setText("Finalizar Venda   [F11]");
        btnfinalizarvenda.setBorderPainted(false);
        btnfinalizarvenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnfinalizarvenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalizarvendaActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(0, 153, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-loja-24.png"))); // NOI18N
        jButton2.setText("Gerenciar Vendas  [Ctrl+G]");
        jButton2.setBorderPainted(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(0, 153, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lixo-24.png"))); // NOI18N
        jButton3.setText("Remover  Item  ");
        jButton3.setBorderPainted(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setPreferredSize(new java.awt.Dimension(138, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setForeground(new java.awt.Color(0, 153, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mover-por-carrinho-24.png"))); // NOI18N
        jButton4.setText("Buscar Produtos  [Ctrl+P]");
        jButton4.setBorderPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtmsn.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtmsn.setForeground(new java.awt.Color(0, 153, 204));
        txtmsn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtmsn.setText("Imagem do último Produto adicionado.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnfinalizarvenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmsn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtfoto)
                .addGap(2, 2, 2)
                .addComponent(txtmsn)
                .addGap(28, 28, 28)
                .addComponent(txtdata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnfinalizarvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lpane.setLayer(panelrosa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpane.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpane.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpaneLayout = new javax.swing.GroupLayout(lpane);
        lpane.setLayout(lpaneLayout);
        lpaneLayout.setHorizontalGroup(
            lpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelrosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        lpaneLayout.setVerticalGroup(
            lpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelrosa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CÓDIGO DO CLIENTE:");

        txtidcliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtidcliente.setForeground(new java.awt.Color(255, 153, 0));
        txtidcliente.setText("0000");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CPF:");

        txtcpf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtcpf.setForeground(new java.awt.Color(255, 204, 51));
        txtcpf.setText("000.000.000-00");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CAIXA:");

        cxid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cxid.setForeground(new java.awt.Color(255, 153, 153));
        cxid.setText("0000");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("STATUS:");

        cxstatux.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cxstatux.setForeground(new java.awt.Color(255, 153, 153));
        cxstatux.setText("ABERTO");

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("OPERADOR:");

        txtNomeOperador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtNomeOperador.setForeground(new java.awt.Color(255, 255, 255));
        txtNomeOperador.setText("DEIBIDSON MESQUITA");

        txtCodigoOperador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtCodigoOperador.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoOperador.setText("0000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodigoOperador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeOperador)
                    .addComponent(txtCodigoOperador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(cxid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cxstatux)
                .addGap(57, 57, 57)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcpf)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtidcliente)
                    .addComponent(jLabel5)
                    .addComponent(txtcpf)
                    .addComponent(jLabel4)
                    .addComponent(cxid)
                    .addComponent(jLabel18)
                    .addComponent(cxstatux))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("DESCRIÇÃO DO PRODUTO:");

        txtdesc.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtdesc.setForeground(new java.awt.Color(0, 51, 153));
        txtdesc.setText("-");

        jLabel14.setBackground(new java.awt.Color(153, 153, 255));
        jLabel14.setForeground(new java.awt.Color(0, 102, 204));
        jLabel14.setText("  F9 - TROCAR OPERADOR   ");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel14.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Estoque:");

        txtestoque.setForeground(new java.awt.Color(0, 51, 204));
        txtestoque.setText("0");

        jLabel13.setBackground(new java.awt.Color(153, 153, 255));
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("  CTRL+C - CLIENTES   ");
        jLabel13.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(153, 153, 255));
        jLabel17.setForeground(new java.awt.Color(0, 102, 204));
        jLabel17.setText("  CTRL+A - ABRIR CAIXA   ");
        jLabel17.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 102, 204));
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("  Limpar PDV  ");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lpane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel13)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtestoque)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(txtestoque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lpane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyReleased
        String codigo = txtcodigo.getText().trim();

        if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println(codigo);
            System.out.println(evt.getKeyChar());
            System.out.println(evt.getKeyCode());

        }
    }//GEN-LAST:event_txtcodigoKeyReleased

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        if (!txtcodigo.getText().isEmpty()) {
            adicionarItem();
            txtcodigo.setText("");
            txtcodigo.requestFocus();
            txtqtde.setValue(1);
            txttotalporItens.setValue(BigDecimal.ZERO);
            txtvalorunt.setValue(BigDecimal.ZERO);
        }
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void btnfinalizarvendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalizarvendaActionPerformed
        String cpfCliente = txtcpf.getText();

        if (!cpfCliente.equals("000.000.000-00")) {
            venda.setCliente(new ClienteDao().clientePorCpf(txtcpf.getText()));
        } else {
            venda.setCliente(null);
        }

        //----------------------------//-----------------------------//
        if (venda != null && tabelapdv.getRowCount() > 0) {
            TelaFinalizarVenda fv = new TelaFinalizarVenda();

            venda.setTotal(txttotalcompra.getValue());

            TelaFinalizarVenda.setVenda(venda);
            TelaFinalizarVenda.txttotalVenda.setValue(venda.getTotal());
            TelaFinalizarVenda.txtcaixan.setText(cxid.getText().trim());

            fv.setVisible(true);

            txtfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopping-icon.png")));
            txtmsn.setText("");

        } else {
            JOptionPane.showMessageDialog(rootPane, "Efetue uma venda", "Sem Produtos", 0);
        }

        System.out.println(txtcpf.getText());

    }//GEN-LAST:event_btnfinalizarvendaActionPerformed

    private void txtqtdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqtdeFocusLost

    }//GEN-LAST:event_txtqtdeFocusLost

    private void txtqtdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtdeKeyPressed

    }//GEN-LAST:event_txtqtdeKeyPressed

    private void txtqtdeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtqtdeStateChanged
        txtcodigo.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtdeStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int linha = tabelapdv.getSelectedRow();
        if (linha != -1) {
            long codigo = Long.parseLong(tabelapdv.getValueAt(linha, 1).toString());

            boolean resposta = itens.removeIf(i -> i.getProduto().getCodigo().equals(codigo));

            if (resposta == true) {
                int sequence = 1;

                modelo = (DefaultTableModel) tabelapdv.getModel();
                modelo.setNumRows(0);

                Object[] oneRow = new Object[7];
                for (ItemVenda o : itens) {
                    oneRow[0] = sequence;
                    oneRow[1] = o.getProduto().getCodigo();
                    oneRow[2] = o.getProduto().getDescricao().toUpperCase();
                    oneRow[3] = o.getQtde();
                    oneRow[4] = o.getValorUNT();
                    oneRow[5] = o.getValorDesconto();
                    oneRow[6] = o.getValorTotal();
                    modelo.addRow(oneRow);
                    sequence++;
                }
                
                
               

                geraCupomNaoFiscalTextAreaParcial();

                List<BigDecimal> valores = itens.stream()
                        .map(p -> p.getValorTotal())
                        .collect(Collectors.toList());

                txttotalporItens.setValue(BigDecimal.ZERO);
                txttotalcompra.setValue(valores.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
                txtvalorunt.setValue(BigDecimal.ZERO);
                txtdesconto.setValue(BigDecimal.ZERO);
                txtcodigo.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum item selecionado", "Selecione na tabela", 0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaGerenciarVendas tg = new TelaGerenciarVendas();
        TelaGerenciarVendas.mostarVendasNaTabela();
        tg.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (telaListaProdutos == null) {
            telaListaProdutos = new TelaListaProdutos(null, closable);
            TelaListaProdutos.origemDaChamada = 1;
            telaListaProdutos.setVisible(true);
            telaListaProdutos.toFront();
        } else {
            TelaListaProdutos.origemDaChamada = 1;
            telaListaProdutos.setVisible(true);
            telaListaProdutos.toFront();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtdescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescontoActionPerformed
        txtcodigo.requestFocus();
    }//GEN-LAST:event_txtdescontoActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        limparDadosPdv();
        setaImagemDefault();
        txtcodigo.requestFocus();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hide();

        if (!TelaMasterApp.toobar1.isVisible()) {
            TelaMasterApp.toobar1.setVisible(true);
            TelaMasterApp.Toobar2.setVisible(true);
        } else {
            TelaMasterApp.toobar1.setVisible(false);
            TelaMasterApp.Toobar2.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfinalizarvenda;
    private javax.swing.JLabel cxid;
    private javax.swing.JLabel cxstatux;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JLabel lbtotalitens;
    private javax.swing.JLayeredPane lpane;
    private javax.swing.JPanel panelrosa;
    private static javax.swing.JTable tabelapdv;
    private static javax.swing.JLabel txtCodigoOperador;
    private static javax.swing.JLabel txtNomeOperador;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JLabel txtcpf;
    private static javax.swing.JTextArea txtcupom;
    private javax.swing.JLabel txtdata;
    public static javax.swing.JLabel txtdesc;
    private static Utilitarios.JNumberFormatField txtdesconto;
    private static javax.swing.JLabel txtestoque;
    public static javax.swing.JLabel txtfoto;
    public static javax.swing.JLabel txtidcliente;
    private javax.swing.JLabel txtmsn;
    public static javax.swing.JSpinner txtqtde;
    private static Utilitarios.JNumberFormatField txttotalcompra;
    public static Utilitarios.JNumberFormatField txttotalporItens;
    public static Utilitarios.JNumberFormatField txtvalorunt;
    // End of variables declaration//GEN-END:variables

}
