import javax.swing.*;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;

public class EnterPersonFrame extends JFrame {
    private JLabel label;
    private JTextField text;
    private JRadioButton r1;
    private JRadioButton r2;
    private JButton enter;
    private JButton back;

    EnterPersonFrame() {
        super("Entrance");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel p = new JPanel(new GridLayout(1, 2));
        JPanel p2 = new JPanel(new GridLayout(1, 2));
        JPanel p3 = new JPanel(new GridLayout(2, 1));

        label = new JLabel("Special ID: ");
        p.add(label);

        text = new JTextField(10);
        p.add(text);

        r1 = new JRadioButton("Teacher");
        r2 = new JRadioButton("Student");

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        p2.add(r1);
        p2.add(r2);
        r1.setSelected(true);

        enter = new JButton("Enter");
        p3.add(enter);

        back = new JButton("Back");
        p3.add(back);

        p.setBackground(Color.CYAN);
        p.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 20));
        p2.setBackground(Color.CYAN);
        p2.setBorder(BorderFactory.createEmptyBorder(30, 150, 0, 150));
        p3.setBackground(Color.CYAN);
        p3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 20));

        add(p, BorderLayout.CENTER);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.CENTER);

        myAction mal = new myAction();

        enter.addActionListener(mal);
        back.addActionListener(mal);

        getContentPane().setBackground(Color.CYAN);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class myAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // JRadioButton selectedButton = (JRadioButton) e.getSource();
            if (e.getSource() == enter) {
                if (r2.isSelected()) {
                    String spec = text.getText();
                    // System.out.println("c1");
                    EnterStudent es = new EnterStudent(spec);
                    // Person es = new Person(spec);
                    if (es.isRegistered()) {
                        try {
                            if (es.hasEntered()) {
                                JOptionPane.showMessageDialog(null,
                                        es.getName() + " has already entered the university!");
                            } else {
                                try {
                                    EnterStudent.EnterStudentToFile(es);
                                } catch (Exception ee) {
                                    System.out.println("error occured.");
                                }
                                JOptionPane.showMessageDialog(null, "You are allowed to enter. ");
                            }
                        } catch (Exception t) {
                            System.out.println("exception 13");
                        }
                        // try {
                        // EnterStudent.ReadStudentFromToday();
                        // } catch (Exception V) {
                        // System.out.println("error displaying");
                        // }
                        dispose();
                        SecureRunner s = new SecureRunner();

                    } else {
                        JOptionPane.showMessageDialog(null, "You are not registered. ");
                    }
                } else {
                    String spec = text.getText();
                    EnterTeacher et = new EnterTeacher(spec);
                    if (et.isRegistered()) {
                        try {
                            if (et.hasEntered()) {
                                JOptionPane.showMessageDialog(null,
                                        et.getName() + " has already entered the university!");
                            } else {
                                try {
                                    EnterTeacher.EnterTeacherToFile(et);
                                } catch (Exception ee) {
                                    System.out.println("error occured.");
                                }
                                JOptionPane.showMessageDialog(null, "You are allowed to enter. ");
                            }
                        } catch (Exception t) {
                            System.out.println("exception 13");
                        }
                        dispose();
                        SecureRunner s = new SecureRunner();
                    } else {
                        JOptionPane.showMessageDialog(null, "You are not registered. ");
                    }
                }

            } else if (e.getSource() == back) {
                dispose();
                SecureRunner s = new SecureRunner();
            }
        }
    }

}