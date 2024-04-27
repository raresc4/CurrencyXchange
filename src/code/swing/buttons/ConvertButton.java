package code.swing.buttons;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertButton extends JButton implements ActionListener {
    public ConvertButton(JFrame frame, int x, int y, int width, int height, Color foreGround, Color backGround) {
        super("Convert");
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
