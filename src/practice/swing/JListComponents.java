package practice.swing;

import javax.swing.*;
import java.awt.*;

public class JListComponents extends JFrame{

    final private DefaultListModel<MyPanel> model = new DefaultListModel<>();
    final private JList<MyPanel> list = new JList<>(model);

    public JListComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200,400);


        list.setCellRenderer(new MyCellRenderer());
        add(list);

        model.addElement(new MyPanel("sdf",true));
        model.addElement(new MyPanel("sdfsdf",false));
        model.addElement(new MyPanel("234",true));


    }

    public static void main(String[] args) {
        JListComponents frame = new JListComponents();
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel {

    private String text;
    private boolean isChecked;

    public String getText() {
        return text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public MyPanel(String text, boolean isChecked) {

        add(new JLabel(text), BorderLayout.CENTER);
        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(isChecked);
        add(checkBox, BorderLayout.NORTH);
    }


}


class MyCellRenderer extends JPanel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public MyCellRenderer() {


        setOpaque(true);
        //setIconTextGap(12);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        MyPanel entry = (MyPanel) value;

        this.setLayout(new BorderLayout());
        this.add(new JLabel(entry.getText()), BorderLayout.CENTER);
        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected( entry.isChecked() );
        this.add(checkBox, BorderLayout.NORTH);

        //setText("sdf");
        //setIcon(entry.getImage());
        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}