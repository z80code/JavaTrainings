package gui.forms;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by igor on 03.08.2015.
 */
public class Models {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel jPanel = new JPanel();

        String[] columnNames = {"Name",
                "Number", "check"};


        //List<Record> recordList = new ArrayList<>();

//        final Object[][] data = {
//                {"Kathy1", "Smith1", true},
//                {"Kathy2", "Smith2", false},
//                {"Kathy3", "Smith3", true}
//        };

//        final Object[][] data = {
//                {"Kathy1", "Smith1", new Boolean( true)},
//                {"Kathy2", "Smith2", new Boolean( false)},
//                {"Kathy3", "Smith3", new Boolean( true)}
//        };

        final Object[][] data = {
                {"Kathy1", "Smith1", new Button( "sdf")},
                {"Kathy2", "Smith2", new Button( "ff")},
                {"Kathy3", "Smith3", new Button("f")}
        };


                TableModel model = new AbstractTableModel() {



            @Override
            public int getRowCount() {
                return data.length;
            }

            @Override
            public int getColumnCount() {
                return data[0].length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return data[rowIndex][columnIndex];
            }

            public boolean isCellEditable(int row, int col)
            { return false; }

            public void setValueAt(Object value, int row, int col) {
                data[row][col] = value;
                fireTableCellUpdated(row, col);
            }

            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }

        };

        final JLabel label = new JLabel();
        label.setText("not");

        final JTable table = new JTable(model);

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);




        JButton btn1 = new JButton();
        btn1.setText("Button");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //jPanel2.repaint();
                //JOptionPane.showMessageDialog(null, "btn 1");
                // display/center the jdialog when the button is pressed
                //JDialog d = new JDialog(frame, "Hello", true);

                //d.setLocationRelativeTo(frame);
                //d.setVisible(true);
            }
        });


        JButton btn2 = new JButton();
        btn2.setText("Add");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{"435","sdff"});*/
                // System.out.println(data[0][0]);
            }
        });



        BorderLayout layout = new BorderLayout(10,10);

        frame.setLayout(layout);

        jPanel.setBackground(new Color(255, 0, 0));
        jPanel.setLayout(new GridLayout(1,3));
        jPanel.add(btn1);
        jPanel.add(btn2);
        jPanel.add(label);

        frame.add(jPanel, BorderLayout.NORTH);
        frame.add( new JScrollPane(table) , BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
