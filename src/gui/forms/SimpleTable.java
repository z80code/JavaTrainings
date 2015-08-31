package gui.forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

/**
 * Created by igor on 03.08.2015.
 */
public class SimpleTable {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setTitle("Simple Table");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Object[] columns = {"Name", "Number", "Note"};
        Object[][] data = {
                {"name1", "345345", "sjkdflksf"},
                {"name2", "456456", "tyu dfg"},
                {"name3", "88888", "sjkdfl ksf"},
                {"name3", "456", "sjkdfl ksf"},
        };


        final TableModel tableModel = new MyModel(data, columns);
        final JTable table = new JTable(tableModel);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if( e.getClickCount()==2 ) {

                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();

                    String name = target.getModel().getValueAt(row, 0).toString();
                    String number = target.getModel().getValueAt(row, 1).toString();
                    String note = target.getModel().getValueAt(row, 2).toString();

                    DetailsDialog dialog = new DetailsDialog( name, number, note );
                    dialog.showDialog();
                }
            }
        });


        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setAutoCreateRowSorter(true);
        //table.setEditingRow();

        JButton button = new JButton("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String str = JOptionPane.showInputDialog(null, "Enter record");
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                String[] row = str.split(";");
                model.addRow(row);

                //table.getModel().
                //System.out.println(str);
                //JOptionPane.showMessageDialog(null, "Click", "My alert", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(button, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

class MyModel extends DefaultTableModel {

    MyModel(Object[][] data, Object[] column) {
        super(data, column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}