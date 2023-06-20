import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Status extends JFrame {
    // 5 radio buttons for checking status
    private JRadioButton all;
    private JRadioButton teachers;
    private JRadioButton students;
    private JRadioButton bba;
    private JRadioButton cs;
    private JRadioButton ee;
    private JRadioButton psy;
    private JScrollPane display;
    private JButton back;
    private JScrollBar bar;
    JTextArea textArea;

    Status() {
        super("Status");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel p1 = new JPanel(new GridLayout());
        all = new JRadioButton("ALL");
        bba = new JRadioButton("BBA");
        cs = new JRadioButton("CS");
        psy = new JRadioButton("PSY");
        ee = new JRadioButton("EE");
        teachers = new JRadioButton("Teachers");
        students = new JRadioButton("Students");
        all.setSelected(true);
        ButtonGroup gb = new ButtonGroup();
        teachers.setSelected(true);
        gb.add(teachers);
        gb.add(students);
        JPanel p = new JPanel(new GridLayout());
        p.add(teachers);
        p.add(students);
        ButtonGroup bg = new ButtonGroup();
        bg.add(all);
        bg.add(bba);
        bg.add(cs);
        bg.add(psy);
        bg.add(ee);
        p1.add(all);
        p1.add(cs);
        p1.add(ee);
        p1.add(bba);
        p1.add(psy);
        myActionListener mal = new myActionListener();
        all.addActionListener(mal);
        bba.addActionListener(mal);
        cs.addActionListener(mal);
        psy.addActionListener(mal);
        ee.addActionListener(mal);

        p1.setBackground(Color.CYAN);
        p1.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 50));

        // adding scroll panel
        JPanel p2 = new JPanel();
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(250, 2000));
        display = new JScrollPane(textArea);
        display.setPreferredSize(new Dimension(300, 200));

        p2.add(display);
        p2.setBackground(Color.CYAN);
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        JPanel p3 = new JPanel();
        back = new JButton("Back");
        back.addActionListener(mal);
        p3.add(back);
        p3.setBackground(Color.CYAN);
        p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        p.setBackground(Color.CYAN);
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        add(p1);
        add(p);
        add(p2);
        add(p3);

        getContentPane().setBackground(Color.CYAN);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class myActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == all) {
                textArea.setText("");
                if (students.isSelected()) {
                    ArrayList<EnterStudent> es = new ArrayList<EnterStudent>();
                    try {
                        es = EnterStudent.ReadStudentFromToday();
                        for (int i = 0; i < es.size(); i++) {
                            textArea.append(es.get(i).toString());
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                } else if (teachers.isSelected()) {
                    ArrayList<EnterTeacher> et = new ArrayList<EnterTeacher>();
                    try {
                        et = EnterTeacher.ReadTeachersFromToday();
                        for (int i = 0; i < et.size(); i++) {
                            textArea.append(et.get(i).toString());
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                }

            } else if (e.getSource() == ee) {
                textArea.setText("");

                if (students.isSelected()) {
                    ArrayList<EnterStudent> es = new ArrayList<EnterStudent>();
                    try {
                        es = EnterStudent.ReadStudentFromToday();
                        for (int i = 0; i < es.size(); i++) {
                            if (es.get(i).depart().equalsIgnoreCase("ee")) {
                                textArea.append(es.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                } else if (teachers.isSelected()) {
                    ArrayList<EnterTeacher> et = new ArrayList<EnterTeacher>();
                    try {
                        et = EnterTeacher.ReadTeachersFromToday();
                        for (int i = 0; i < et.size(); i++) {
                            if (et.get(i).depart().equalsIgnoreCase("ee")) {
                                textArea.append(et.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                }

            } else if (e.getSource() == cs) {
                textArea.setText("");

                if (students.isSelected()) {
                    ArrayList<EnterStudent> es = new ArrayList<EnterStudent>();
                    try {
                        es = EnterStudent.ReadStudentFromToday();
                        for (int i = 0; i < es.size(); i++) {
                            if (es.get(i).depart().equalsIgnoreCase("cs")) {
                                textArea.append(es.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                } else if (teachers.isSelected()) {
                    ArrayList<EnterTeacher> et = new ArrayList<EnterTeacher>();
                    try {
                        et = EnterTeacher.ReadTeachersFromToday();
                        for (int i = 0; i < et.size(); i++) {
                            if (et.get(i).depart().equalsIgnoreCase("cs")) {
                                textArea.append(et.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                }

            } else if (e.getSource() == bba) {
                textArea.setText("");

                if (students.isSelected()) {
                    ArrayList<EnterStudent> es = new ArrayList<EnterStudent>();
                    try {
                        es = EnterStudent.ReadStudentFromToday();
                        for (int i = 0; i < es.size(); i++) {
                            if (es.get(i).depart().equalsIgnoreCase("bba")) {
                                textArea.append(es.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                } else if (teachers.isSelected()) {
                    ArrayList<EnterTeacher> et = new ArrayList<EnterTeacher>();
                    try {
                        et = EnterTeacher.ReadTeachersFromToday();
                        for (int i = 0; i < et.size(); i++) {
                            if (et.get(i).depart().equalsIgnoreCase("bba")) {
                                textArea.append(et.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                }

            } else if (e.getSource() == psy) {
                textArea.setText("");

                if (students.isSelected()) {
                    ArrayList<EnterStudent> es = new ArrayList<EnterStudent>();
                    try {
                        es = EnterStudent.ReadStudentFromToday();
                        for (int i = 0; i < es.size(); i++) {
                            if (es.get(i).depart().equalsIgnoreCase("psy")) {
                                textArea.append(es.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                } else if (teachers.isSelected()) {
                    ArrayList<EnterTeacher> et = new ArrayList<EnterTeacher>();
                    try {
                        et = EnterTeacher.ReadTeachersFromToday();
                        for (int i = 0; i < et.size(); i++) {
                            if (et.get(i).depart().equalsIgnoreCase("psy")) {
                                textArea.append(et.get(i).toString());
                            }
                        }
                    } catch (Exception er) {
                        System.out.println("exception here5");
                    }
                }

            } else if (e.getSource() == back) {
                dispose();
                SecureRunner sr = new SecureRunner();
            }
        }
    }

}