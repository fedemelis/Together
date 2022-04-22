package view;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView extends JFrame{
    private JButton button1;
    private JPanel panel1;

    public loginView() {
        button1.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(menuView::new);
        });

        setContentPane(panel1);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(loginView::new);
    }
}
