
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;

public class SecureRunner extends JFrame {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JLabel bagd;

    SecureRunner() {
        super("Security");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400, 300);

        JPanel j = new JPanel(new GridLayout(1, 1));
        JPanel j1 = new JPanel(new FlowLayout());
        JPanel j2 = new JPanel(new GridLayout(1, 1));
        JPanel j3 = new JPanel(new GridLayout(1, 1));
        JPanel j4 = new JPanel(new GridLayout(1, 1));
        JPanel j5 = new JPanel(new GridLayout(1, 1));

        b1 = new JButton("Enter Uni");
        j.add(b1);
        b2 = new JButton("Registeration");
        j2.add(b2);
        b3 = new JButton("Exit Person");
        j3.add(b3);
        b4 = new JButton("Check Status");
        j4.add(b4);
        b5 = new JButton("Close");
        j5.add(b5);
        bagd = new JLabel(new ImageIcon("background.jpg"));
        bagd.setSize(390, 299);

        myActionListener mal = new myActionListener();
        b1.addActionListener(mal);
        b2.addActionListener(mal);
        b3.addActionListener(mal);
        b4.addActionListener(mal);
        b5.addActionListener(mal);

        j.setBackground(Color.CYAN);
        j.setBorder(BorderFactory.createEmptyBorder(50, 150, 0, 150));
        j2.setBackground(Color.CYAN);
        j2.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 150));
        j3.setBackground(Color.CYAN);
        j3.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 150));
        j4.setBackground(Color.CYAN);
        j4.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 150));
        j5.setBackground(Color.CYAN);
        j5.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 150));

        add(j, BorderLayout.CENTER);
        add(j2, BorderLayout.CENTER);
        add(j3, BorderLayout.CENTER);
        add(j4, BorderLayout.CENTER);
        add(j5, BorderLayout.CENTER);
        getContentPane().setBackground(Color.CYAN);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class myActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                dispose();
                EnterPersonFrame f = new EnterPersonFrame();
            } else if (e.getSource() == b2) {
                dispose();
                RegisterFrame r = new RegisterFrame();
            } else if (e.getSource() == b3) {
                dispose();
                ExitPersonFrame ex = new ExitPersonFrame();
            } else if (e.getSource() == b4) {
                dispose();
                Status s = new Status();
            } else if (e.getSource() == b5) {
                // dispose();
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SecureRunner s = new SecureRunner();
    }
}
