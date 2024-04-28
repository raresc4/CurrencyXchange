package code.swing.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MongoButton extends JButton implements ActionListener {
    public MongoButton(JFrame frame, int x, int y, int width, int height, Color foreGround, Color backGround) {
        super("View history");
        setBounds(x, y, width, height);
        setForeground(foreGround);
        setBackground(backGround);
        addActionListener(this);
        frame.add(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
