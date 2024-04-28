package code.swing;

import javax.swing.*;
import java.awt.*;

public class TableFrame extends JFrame {
    private JTable table;
    public TableFrame(String[][] data) {
        super("History");
        initialize();
        String[] columnNames = {"Date","Currency", "Amount", "Converted Currency", "Converted Amount"};
        table = new JTable(data,columnNames);
        table.setBounds(50, 120, 700, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 700, 600);
        add(scrollPane);
        add(table);
    }
    private void initialize() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 800);
        setResizable(false);
        setVisible(true);
    }
}
