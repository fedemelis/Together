package view;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginView extends JFrame{
    private JButton btnLogin;
    private JPanel loginViewPanel;
    private JPanel centrePanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton entra;
    private JLabel creaacc;

    public loginView() {
        super("Together");

        /*button1.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(menuView::new);
        });*/



        setContentPane(loginViewPanel);
        setSize(500, 500);
        setVisible(true);

        creaacc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                SwingUtilities.invokeLater(menuView::new);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(loginView::new);
    }

}
