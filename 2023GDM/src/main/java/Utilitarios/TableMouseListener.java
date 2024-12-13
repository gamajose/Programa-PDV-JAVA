/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

//Evento no meu popup
public class TableMouseListener extends MouseAdapter {

    private final JTable table;
    private static int linhaSelecionada;

    public TableMouseListener(JTable table) {

        this.table = table;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        try {
            Point point = event.getPoint();
            setLinhaSelecionada(table.rowAtPoint(point));

            table.setRowSelectionInterval(getLinhaSelecionada(), getLinhaSelecionada());
        } catch (Exception e) {
            System.out.println("nenhum item nesta linha da tabela do pdv");
        }

        // selects the row at which point the mouse is clicked
    }

    /**
     * @return the linhaSelecionada
     */
    public static int getLinhaSelecionada() {
        return linhaSelecionada;
    }

    /**
     * @param linhaSelecionada the linhaSelecionada to set
     */
    public void setLinhaSelecionada(int linhaSelecionada) {
        TableMouseListener.linhaSelecionada = linhaSelecionada;
    }

}
