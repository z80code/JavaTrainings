package com.itclass.jdbc.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.StringContent;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class GUI extends JFrame {

    JTable table;

    public GUI(List<RecordEntity> entities) {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640,480);

        Object[][] data = new Object[entities.size()][3];
        for (int i = 0; i < entities.size(); i++) {
            data[i][0] = entities.get(i).getId();
            data[i][1] = entities.get(i).getText();
            data[i][2] = entities.get(i).getNumber();
        }
        Object[] headers = {"id", "text", "number"};

        DefaultTableModel model = new DefaultTableModel(data,headers);
        table = new JTable(model);

        add( new JScrollPane(table) , BorderLayout.CENTER);

    }

    public static void main(String[] args) {

        try {

            TestTable testTable = new TestTable();
            List<RecordEntity> records = testTable.getAll();
            GUI gui = new GUI(records);
            gui.setVisible(true);

        } catch (SQLException ex) {
            JOptionPane
                    .showMessageDialog(null, "Подключение не установлено: "+ex.getMessage());
        }


    }
}
