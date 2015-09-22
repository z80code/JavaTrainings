package lesson.mvc.simple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by igor on 17.09.2015.
 */
public class Controller  implements /*PropertyChangeListener*/ActionListener {

    private View view;
    private Model model;

    public Controller(View view) {
        this.view = view;
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        String text = button.getText();
        model.setText(text);

        view.updateText(text);
    }

    /*@Override
    public void propertyChange(PropertyChangeEvent evt) {

    }*/
}
