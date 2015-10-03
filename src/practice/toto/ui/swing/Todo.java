package practice.toto.ui.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Todo extends JFrame {

    private JTable table;
    private DefaultTableModel model;


    public Todo() {
        Object[][] objects = {
            {"Task1", true},
            {"Task2", true},
            {"Task3", false}
        };


        model = new DefaultTableModel(objects, new String[]{"value", "is"}) {
            public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }
        };

        table = new JTable(model);

        this.add(table);
    }

    public static void main(String[] args) {
        Todo frame = new Todo();
        frame.setSize(200,400);
        frame.setVisible(true);
    }
}
