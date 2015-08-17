package gui.forms;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by igor on 03.08.2015.
 */
public class Run {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel jPanel = new JPanel();

        String[] columnNames = {"Name",
                "Number"};


        //List<Record> recordList = new ArrayList<>();

        final Object[][] data = {
                {"Kathy1", "Smith1"},
                {"Kathy2", "Smith2"},
                {"Kathy3", "Smith3"}
        };


        TableModel model = new AbstractTableModel() {


            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public int getColumnCount() {
                return 0;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }
        };

        final JLabel label = new JLabel();
        label.setText("not");

        final JTable table = new JTable(new DefaultTableModel(data,columnNames));

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                //label.setText( e.getFirstIndex()+" "+e.getLastIndex() );
            }
        });

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();

                label.setText(row+" "+ column);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



        JButton btn1 = new JButton();
        btn1.setText("Button");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                final JDialog f = new JDialog(frame,"Adding", true);

                //f.getContentPane().add(panel);

                f.setPreferredSize(new Dimension(300,300));
                JPanel p = new JPanel();

                p.setLayout(new GridLayout(4, 2, 10, 10));

                p.add(new JLabel("etrt"));
                JTextField edit = new JTextField();
                p.add(edit);
                p.add(new JLabel("sf"));
                p.add(new JTextField());
                p.add(new JLabel("345"));
                p.add(new JTextField());

                JButton b = new JButton("OK");
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                    }
                });
                p.add(b);
                p.add(new JButton("Cancel"));

                f.getContentPane().add(p);
                f.pack();
                f.setVisible(true);
                //f.setBounds(20,20,200,200);
                System.out.println(edit.getText());
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
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{"435","sdff"});
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

class Record {
    String name;
    String phone;
    String otherInform;
}
