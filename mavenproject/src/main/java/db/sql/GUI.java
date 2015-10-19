package db.sql;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class GUI extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public GUI(List<User> users) {

        setSize(640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Object[][] data = new Object[users.size()][3];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i).getId();
            data[i][1] = users.get(i).getName();
            data[i][2] = users.get(i).getNumber();
        }

        Object[] headers = {"id", "name", "number"};

        model = new DefaultTableModel(data, headers);
        table = new JTable(model);

        table.setAutoCreateRowSorter(true);


        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {

        TestTable table = new TestTable();

        try {
            GUI gui = new GUI(table.getAll());
            gui.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
