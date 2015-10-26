package lesson.gui.forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;

public class TableExamp extends JFrame{

    public TableExamp() {
        setSize(640,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Table example");

        Object[] headers = {"#", "co1", "col2"};
        Object[][] data = {
                {"1", "dfdg", "sdfs"},
                {"2", "fghg", "ytu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
                {"3", "345", "iu"},
        };

        DefaultTableModel model = new DefaultTableModel(data, headers);
        JTable  table = new JTable(model);

        model.addRow(new Object[]{"111","AAA","QQQ"});

        table.setAutoCreateRowSorter(true);
        table.setAutoCreateColumnsFromModel(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

    }

    public static void main(String[] args) {
        TableExamp tableExamp = new TableExamp();
        tableExamp.setVisible(true);
    }

}
