/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Utilitarios.TableMouseListener;
import repositorio.CaixaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deibidson Mesquita
 */
public class TelaCaixaDiario extends javax.swing.JFrame implements ActionListener {

    private static final long serialVersionUID = 803393249847248296L;

    /**
     * Creates new form TelaCaixaDiario
     */
    public TelaCaixaDiario() {
        initComponents();

        mostarListaCaixaDiario();

        preparaOpenPopupTabela();
        tabela.addMouseListener(new TableMouseListener(tabela));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nova Entrada Caixa Selecionado":
                TelaLancamentoCaixaEntrada te = new TelaLancamentoCaixaEntrada(this, rootPaneCheckingEnabled);
                te.txtdata.addItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                te.txtdata.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                te.setVisible(true);
                break;

            case "Nova Saida Caixa Selecionado":
                TelaLancamentoCaixaSaida ts = new TelaLancamentoCaixaSaida(this, rootPaneCheckingEnabled);
                ts.txtdata.addItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                ts.txtdata.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                ts.setVisible(true);
                break;
        }
    }

    public final void preparaOpenPopupTabela() {
        JPopupMenu popupMenu = new JPopupMenu("Operações Disponíveis:");

        JMenuItem menuItemDel = new JMenuItem("Nova Saida Caixa Selecionado", new javax.swing.ImageIcon(getClass().getResource("/imagens/menou.png")));
        JMenuItem menuItemAdd = new JMenuItem("Nova Entrada Caixa Selecionado", new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mais-48.png")));
        JMenuItem menuItemRemove = new JMenuItem("Remover Lançamento Caixa Selecionado", new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-excluir-24.png")));
        JMenuItem menuItemRemoveAll = new JMenuItem("Modificar Lançamento Caixa Selecionado", new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png")));

        popupMenu.add(menuItemAdd);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItemDel);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItemRemove);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItemRemoveAll);

        menuItemDel.addActionListener(this);
        menuItemAdd.addActionListener(this);

        tabela.setComponentPopupMenu(popupMenu);
    }

    public static void mostarListaCaixaDiario() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        CaixaDao u = new CaixaDao();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Object[] dados = new Object[9];
        u.listaCaixaDiario().forEach((p) -> {

            dados[0] = p.getId();
            dados[1] = format.format(p.getDataCaixa());
            dados[2] = p.getHoraFechamento();
            dados[3] = p.getResponsavel();
            dados[4] = p.getValorSaida();
            dados[5] = p.getValorEntradas();
            dados[6] = p.getSaldo();
            dados[7] = p.getCaixa().getId();
            dados[8] = p.getTotal();
            modelo.addRow(dados);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caixa diário");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Hora", "Responsavel", "Saidas", "Entradas", "Saldo", "Caixa", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(3).setMinWidth(180);
            tabela.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
