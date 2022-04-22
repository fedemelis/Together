package view;

import javax.swing.*;

public class menuView extends JFrame{
    private JButton btnShow;
    private JPanel panel;

    public menuView() {
        super("testo di esempio");
        btnShow.addActionListener(e -> {
            System.out.println("Ciao");
        });

        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(menuView::new);
    }
}
