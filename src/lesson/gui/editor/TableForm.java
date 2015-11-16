package lesson.gui.editor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ObjectView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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

                List<Record> list = new ArrayList<Record>();

                for(Object row : rows) {
                    Vector r = (Vector)row;

                    try {
                        Record record = new Record(
                                Integer.parseInt(r.get(0).toString()),
                                (String) r.get(1),
                                Long.parseLong(r.get(2).toString()));
                        list.add(record);
                    } catch (NumberFormatException ignore) {
                        System.out.format("bad values: %s ", r.toString());
                    }
                }


                FileHelper.saveTxt(list,"D:","records.csv");

            }

        });

    }

}