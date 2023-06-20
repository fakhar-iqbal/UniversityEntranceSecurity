
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;

public class ExitPersonFrame extends JFrame {

    private JLabel label;
    private JTextField text;
    JButton button;
    JButton button2;

    ExitPersonFrame() {
        super("Exit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel p = new JPanel(new GridLayout(1, 2));
        JPanel p2 = new JPanel(new GridLayout(1, 1));
        JPanel p3 = new JPanel(new GridLayout(1, 1));

        label = new JLabel("Special ID: ");
        text = new JTextField(10);

        p.add(label);
        p.add(text);
        button = new JButton("Exit");
        p2.add(button);
        button2 = new JButton("Back");
        p3.add(button2);
        ActionPerf act = new ActionPerf();

        button.addActionListener(act);
        button2.addActionListener(act);

        p.setBackground(Color.CYAN);
        p.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 20));
        p2.setBackground(Color.CYAN);
        p2.setBorder(BorderFactory.createEmptyBorder(30, 150, 0, 150));
        p3.setBackground(Color.CYAN);
        p3.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 150));
        add(p, BorderLayout.CENTER);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.CENTER);
        getContentPane().setBackground(Color.CYAN);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class ActionPerf implements ActionListener {
        public void actionPerformed(ActionEvent d) {
            String sid = text.getText();
            if (d.getSource() == button) {
                ExitPerson ep = new ExitPerson(sid);
                try {
                    int check = ep.exitingPerson();
                    if (check == 0) {
                        JOptionPane.showMessageDialog(null, "This person is not registered. Invalid ID");
                    } else if (check == 2) {
                        JOptionPane.showMessageDialog(null, "This person has not come to university today!");
                    } else if (check == 3) {
                        JOptionPane.showMessageDialog(null, "This person has exited from University!");
                    }
                    dispose();
                    SecureRunner f = new SecureRunner();

                } catch (Exception rt) {
                    System.out.println("3exception here");
                }
                try {
                    EnterTeacher.ReadTeachersFromToday();
                } catch (Exception rt) {
                    System.out.println("errordisplay");
                }
                try {
                    EnterStudent.ReadStudentFromToday();
                } catch (Exception rt) {
                    System.out.println("errordisplay");
                }
                try {
                    EnterStudent.ReadStudentFromToday();
                } catch (Exception V) {
                    System.out.println("4error displaying");
                }

            } else if (d.getSource() == button2) {
                dispose();
                SecureRunner sr = new SecureRunner();
            }
        }
    }
}
