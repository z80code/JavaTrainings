package lesson.gui.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsDialog extends JDialog {

    public DetailsDialog(String name, String number, String note) {

        this.setTitle("Details view");
        this.setModal(true);
        this.setSize(400,200);
        this.setLayout(new GridLayout(4,2));


        this.add(  new JLabel("Name: ")  );
        this.add(  new JLabel(name)  );

        this.add(  new JLabel("Number: ")  );
        this.add(  new JLabel(number)  );

        this.add(  new JLabel("Note: ")  );
        this.add(  new JLabel(note)  );

        JButton btn = new  JButton("Close");

        final JDialog dialog = this;

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });


        this.add( btn );
    }

    public void showDialog() {
        this.setVisible(true);
    }

}
