import javax.swing.*;
import java.awt.GridLayout;

public class Security extends JFrame {
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;

    public Security() {
        setLayout(new GridLayout(3, 1, 2, 20));
        jb1 = (new JButton("Enter", null));
        jb2 = (new JButton("Register"));
        jb3 = (new JButton("check Status"));
        jb1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jb2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jb3.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        add(jb1);
        add(jb2);
        add(jb3);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
}