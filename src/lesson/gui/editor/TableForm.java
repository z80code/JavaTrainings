package lesson.gui.editor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ObjectView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TableForm extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private Object[][] data;

    public TableForm( String filePath ) {

        List<Record> records = FileHelper.readTxt(filePath);

        data = new Object[records.size()][3];
        Object[] headers = {"id", "name", "number"};
        for (int i = 0; i < records.size(); i++) {
            data[i][0] = records.get(i).getId();
            data[i][1] = records.get(i).getName();
            data[i][2] = records.get(i).getNumber();
        }

        model = new DefaultTableModel(data, headers);
        table = new JTable(model);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640,480);
        setTitle("Editor");

        add(new JScrollPane(table));


        addWindowListener(new WindowAdapter() {
            @Override

            public void windowClosing(WindowEvent e) {

                Vector rows = model.getDataVector();

                for(Object row : rows ) {
                    // !!! на самом деле row тоже вектор
                    // Можно привести Vector r = (Vector)row;
                    System.out.println(row);
                }
            }

        });

    }

}