import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;

public class RegisterFrame extends JFrame {
    private JLabel nameLabel;
    private JLabel cnicLabel;
    private JLabel mobileLabel;
    private JTextField name;
    private JTextField cnic;
    private JTextField mobile;
    private JRadioButton cs;
    private JRadioButton bba;
    private JRadioButton ee;
    private JRadioButton psy;
    private JRadioButton student;
    private JRadioButton teacher;
    private JButton register;
    private JButton back;
    private JLabel sid;

    RegisterFrame() {
        super("Registration");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel p1 = new JPanel(new GridLayout(1, 2));
        nameLabel = new JLabel("Name: ");
        name = new JTextField(13);
        p1.add(nameLabel);
        p1.add(name);

        JPanel p2 = new JPanel(new GridLayout(1, 2));
        cnicLabel = new JLabel("CNIC: ");
        cnic = new JTextField(13);
        p2.add(cnicLabel);
        p2.add(cnic);

        JPanel p3 = new JPanel(new GridLayout(1, 2));
        mobileLabel = new JLabel("Mobile: ");
        mobile = new JTextField(13);
        p3.add(mobileLabel);
        p3.add(mobile);

        JPanel p4 = new JPanel(new GridLayout(1, 4));
        cs = new JRadioButton("CS");
        bba = new JRadioButton("BBA");
        psy = new JRadioButton("Psy");
        ee = new JRadioButton("EE");

        ButtonGroup bg = new ButtonGroup();
        bg.add(cs);
        bg.add(bba);
        bg.add(psy);
        bg.add(ee);
        p4.add(cs);
        p4.add(psy);
        p4.add(bba);
        p4.add(ee);
        cs.setSelected(true);

        sid = new JLabel();
        JPanel p5 = new JPanel(new GridLayout(1, 2));
        student = new JRadioButton("Student");
        teacher = new JRadioButton("Teacher");
        ButtonGroup b1 = new ButtonGroup();
        b1.add(student);
        b1.add(teacher);
        p5.add(student);
        p5.add(teacher);
        student.setSelected(true);

        JPanel p6 = new JPanel(new GridLayout(1, 2));
        register = new JButton("Register");
        back = new JButton("Back");
        p6.add(register);
        p6.add(back);
        actionListen act = new actionListen();
        register.addActionListener(act);
        back.addActionListener(act);

        p1.setBackground(Color.CYAN);
        p1.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 70));
        p2.setBackground(Color.CYAN);
        p2.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 70));
        p3.setBackground(Color.CYAN);
        p3.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 70));
        p4.setBackground(Color.CYAN);
        p4.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 70));
        p5.setBackground(Color.CYAN);
        p5.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 70));
        p6.setBackground(Color.CYAN);
        p6.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 70));

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.CENTER);
        add(p4, BorderLayout.CENTER);
        add(p5, BorderLayout.CENTER);

        add(p6, BorderLayout.CENTER);

        getContentPane().setBackground(Color.CYAN);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class actionListen implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == register) {

                String Sname = name.getText();
                String cn = cnic.getText();
                String mbl = mobile.getText();
                int mob = Integer.parseInt(mbl);
                String dept = "";
                if (cs.isSelected()) {
                    dept = "CS";
                } else if (ee.isSelected()) {
                    dept = "EE";
                } else if (psy.isSelected()) {
                    dept = "Psy";
                } else if (bba.isSelected()) {
                    dept = "BBA";
                }

                String post = "";
                if (student.isSelected()) {
                    post = "Student";
                } else {
                    post = "Teacher";
                }
                Person p = new Person(Sname, cn, mob, dept, post);
                String id = p.generateID();

                if (student.isSelected()) {

                    try {
                        Student.RegisterStudenttoFile(p);
                    } catch (Exception r) {
                        System.out.println("error/ exeception");
                    }
                    System.out.println("entered");
                } else {
                    try {
                        Teacher.RegisterTeachertoFile(p);
                    } catch (Exception d) {
                        System.out.println("exception here");
                    }
                    System.out.println("entered");
                }
                JOptionPane.showMessageDialog(null, "your special id is: " + id);
                dispose();
                SecureRunner s = new SecureRunner();

            } else if (e.getSource() == back) {
                dispose();
                SecureRunner s = new SecureRunner();
            }
        }
    }
}