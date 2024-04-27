package code.swing.buttons;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentationButton extends JButton implements ActionListener {
    public DocumentationButton(JFrame frame,int x, int y, int width, int height, Color foreGround, Color backGround) {
        super("Supported Currencies");
        setBounds(x, y, width, height);
        setForeground(foreGround);
        setBackground(backGround);
        addActionListener(this);
        frame.add(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Supported Currencies: \n" +
                "USD - United States Dollar\n" +
                "EUR - Euro\n" +
                "JPY - Japanese Yen\n" +
                "CHF - Swiss Franc\n" +
                "TRY - Turkish Lira\n" +
                "AED - United Arab Emirates Dirham\n" +
                "RON - Romanian Leu\n" );
    }
}
