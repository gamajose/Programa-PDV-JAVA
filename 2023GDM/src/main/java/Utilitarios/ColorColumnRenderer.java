/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Deibidson Mesquita
 */
public class ColorColumnRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String versionVal = "";

        if (!table.getValueAt(0, 1).equals("Nenhuma conta a pagar cadastrada. ") & !table.getValueAt(0, 1).equals("Nenhuma conta a receber cadastrada. ")) {
            versionVal = table.getValueAt(row, 9).toString();
        }
        switch (versionVal) {
            case "QUITADA":
                c.setForeground(new Color(153, 153, 153));
                c.setFont(new Font("Tahoma", Font.BOLD, 11));
                break;
            case "RECEBIDA":
                c.setForeground(new Color(153, 153, 153));
                c.setFont(new Font("Tahoma", Font.BOLD, 11));
                break;

            default:
                if (value != null) {

                    switch (column) {
                        case 3:
                            c.setFont(new Font("Tahoma", 1, 11));
                            c.setForeground(new Color(0, 153, 0));
                            break;
                        case 4:
                            c.setFont(new Font("Tahoma", 1, 11));
                            c.setForeground(Color.red);
                            break;
                        case 5:
                            c.setFont(new Font("Tahoma", 1, 11));
                            c.setForeground(Color.BLUE);
                            break;
                        default:
                            c.setForeground(table.getForeground());
                    }
                }
                break;
        }
        return c;
    }

}
