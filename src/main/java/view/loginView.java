package view;

import javax.swing.*;

public class loginView extends JFrame{
    private JButton button1;
    private JPanel loginViewPanel;

    public loginView() {

        super("Together");

        button1.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(menuView::new);
        });

        setContentPane(loginViewPanel);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(loginView::new);
    }

}
