package code.swing;
import code.apiStuff.Exchange;
import code.swing.buttons.ConvertButton;
import code.swing.buttons.DocumentationButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
public class SwingUI extends JFrame{
    private DocumentationButton documentationButton;
    private String apiKey = "";
    private ConvertButton convertButton;
    private ArrayList<String> namesList;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    public SwingUI() {
        super("CurrencyXchange");
        setLayout(null);
        setArrayList();
        initialize();
        makeTitle();
        makeLabel("Enter the type of currency to convert from:", 50, 100, 245, 50);
        makeLabel("Enter the amount of currency to convert:", 50, 175, 245, 50);
        makeLabel("Enter the type of currency to convert to:", 350, 100, 245, 50);
        textField1 = new JTextField("Type of currency");
        documentationButton = new DocumentationButton(this, 300,  400, 200, 50,Color.WHITE, Color.BLACK);
        convertButton = new ConvertButton(this, 50, 400, 150, 50, Color.WHITE, Color.BLACK);
        setTextField(50, 150, 150, 30, textField1);
        textField2 = new JTextField("Amount");
        setTextField(50, 225, 150, 30, textField2);
        textField3 = new JTextField("Type of currency");
        setTextField(350, 150, 150, 30, textField3);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAmount = textField2.getText();
                if(!verifyInputToBeInt(enteredAmount)){
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount");
                    clearFields();
                    return;
                }
                String enteredTypeFrom = textField1.getText();
                if(!verifyInputToBeString(enteredTypeFrom)){
                    JOptionPane.showMessageDialog(null, "Please enter a valid currency type");
                    clearFields();
                    return;
                }
                if(notInList(enteredTypeFrom)){
                    JOptionPane.showMessageDialog(null, "The type of currency to convert to is not supported yet.");
                    clearFields();
                    return;
                }
                String enteredTypeTo = textField3.getText();
                if(!verifyInputToBeString(enteredTypeTo)){
                    JOptionPane.showMessageDialog(null, "Please enter a valid currency type");
                    clearFields();
                    return;
                }
                if(notInList(enteredTypeTo)){
                    JOptionPane.showMessageDialog(null, "The type of currency to convert to is not supported yet.");
                    clearFields();
                    return;
                }
                Exchange.convertCurrency(apiKey,textField1.getText(), textField3.getText(), textField2.getText());
                clearFields();
            }
        });
        revalidate();
        repaint();
    }
    private void setArrayList(){
        namesList = new ArrayList<>();
        namesList.add("USD");
        namesList.add("EUR");
        namesList.add("JPY");
        namesList.add("CHF");
        namesList.add("TRY");
        namesList.add("AED");
        namesList.add("RON");
    }
    private void clearFields(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }
    private boolean notInList(String input){
        return !namesList.contains(input);
    }
    private void makeLabel(String text, int x, int y, int width, int height){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        setLayout(null);
        add(label);
    }
    private void makeTitle(){
        JLabel title = new JLabel("CurrencyXchange");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setBounds(200, 20, 300, 50);
        setLayout(null);
        add(title);
    }
    private boolean verifyInputToBeInt(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean verifyInputToBeString(String input){
        return input.matches("[a-zA-Z]+");
    }
    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(656, 500);
        setResizable(false);
        setVisible(true);
    }
    private void setTextField(int x, int y, int width, int height, JTextField textField){
        textField.setBackground(new Color(240, 240, 240));
        textField.setForeground(new Color(50, 50, 50));
        Font font = new Font("Arial", Font.PLAIN, 14);
        textField.setFont(font);
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        });
        add(textField, BorderLayout.SOUTH);
        textField.setBounds(x, y, width, height);
        textField.setPreferredSize(new Dimension(width, height));
        add(textField);
    }
}
