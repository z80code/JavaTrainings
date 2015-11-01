package lesson.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StringContent;
import java.util.Vector;

public class TableVector extends JFrame {

    public TableVector(Vector<String[]> rows) {


        Vector headers = new Vector();
        headers.add("sdf");
        headers.add("sdf3");
        headers.add("sdff");


        DefaultTableModel model = new DefaultTableModel(rows, headers);
        JTable table = new JTable(model);
        add(table);

    }

    public static void main(String[] args) {
        Vector rows = new Vector();

        Vector row = new Vector();
        row.add("sdf");
        row.add("erty");
        row.add("ytu");

        Vector row1 = new Vector();
        row1.add("sdf");
        row1.add("sd");
        row1.add("sdf");

        rows.add(row);
        rows.add(row1);

        TableVector tableVector = new TableVector(rows);
        tableVector.setVisible(true);
    }
}
