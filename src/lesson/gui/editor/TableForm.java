package lesson.gui.editor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class TableForm extends JFrame {
    private JTable table;
    private DefaultTableModel model;


    public TableForm( String filePath ) {

        List<Record> records = FileHelper.readTxt(filePath);

        Object[][] data = new Object[records.size()][3];
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
            public void windowClosed(WindowEvent e) {

                // get list from model
                //FileHelper.saveTxt(null, )

            }
        });

    }

}