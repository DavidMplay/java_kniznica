package com.knjiznica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Glavna {
    private JButton btnOK;
    private JPanel panel1;
    private JTextField textField1;
    private JList list1;

    private String filename = "mojfajl.txt";

    public Glavna() throws IOException {
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = textField1.getText();
                try {
                    DBHandler.WriteToFile(tekst, filename);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        textField1.setText(DBHandler.ReadFromFile(filename));
    }

    private void createUIComponents() {
        panel1 = new JPanel();
        btnOK = new JButton("OK");
        textField1 = new JTextField();
        list1 = new JList();
        panel1.add(btnOK);
        panel1.add(textField1);
        panel1.add(list1);
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Knjiznicaaa");
        frame.setContentPane(new Glavna().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
