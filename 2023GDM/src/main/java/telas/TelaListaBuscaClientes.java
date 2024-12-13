package telas;

import repositorio.ClienteDao;
import java.awt.Color;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import model.Cliente;

public class TelaListaBuscaClientes extends javax.swing.JDialog {

    private static final long serialVersionUID = -3273420919582458938L;
    private static int codigotela;

    public TelaListaBuscaClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer r, int rw,int col){
                Component comp = super.prepareRenderer(r, rw, col);

                if(rw%2 == 0 && !isCellSelected(rw, col)){
                    comp.setBackground(new Color(229,229,229));
                }else if(!isCellSelected(rw, col)){
                    comp.setBackground(new Color(242,242,242));
                }else{
                    comp.setBackground(new Color(163,184,204));
                }
                return comp;
            }

        };
        busca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setBackground(new java.awt.Color(184, 207, 229));
        setResizable(false);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setToolTipText("Para fechar ALT + F4");
        tabela.setGridColor(new java.awt.Color(240, 248, 239));
        tabela.setRowHeight(20);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMaxWidth(100);
            tabela.getColumnModel().getColumn(1).setMinWidth(250);
            tabela.getColumnModel().getColumn(2).setMinWidth(120);
            tabela.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        busca.setBackground(new java.awt.Color(204, 255, 204));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 153, 0));
        jLabel2.setText("SELECIONAR: CTRL+ENTER ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busca)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
                        .addGap(3, 3, 3))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() == 2) {
            int linha = tabela.getSelectedRow();

            switch (getCodigotela()) {
                case 1:
                    String codigo = tabela.getValueAt(linha, 0).toString();
                    String n = tabela.getValueAt(linha, 1).toString();
                    TelaPedidoVenda.txtcliente.setText(n);
                    TelaPedidoVenda.txtcodigoCliente.setText(codigo.trim());
                    this.setVisible(false);
                    break;
                case 2:
                    String id = tabela.getValueAt(linha, 0).toString();
                    String cpf = tabela.getValueAt(linha, 2).toString();
                    TelaMasterVenda.txtidcliente.setText(id);
                    TelaMasterVenda.txtcpf.setText(cpf);
                    this.setVisible(false);
                    break;
            }

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabela.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    public static void mostrarClientes() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        int Counter = 0;

        ClienteDao clienteDao = new ClienteDao();
        for (Cliente f : clienteDao.listaTodosClientes()) {

            String[] dados = new String[3];

            dados[0] = String.valueOf(f.getId());
            dados[1] = f.getPessoaJuridica().getNomeFantasia().toUpperCase();
            dados[2] = f.getCpf();

            Counter++;
            modelo.addRow(dados);
        }

        if (Counter == 0) {
            String[] dados = new String[2];
            dados[0] = "0";
            dados[1] = "Nenhum Cliente Cadastrado.";

            modelo.addRow(dados);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the codigotela
     */
    public static int getCodigotela() {
        return codigotela;
    }

    /**
     * @param aCodigotela the codigotela to set
     */
    public static void setCodigotela(int aCodigotela) {
        codigotela = aCodigotela;
    }
}
