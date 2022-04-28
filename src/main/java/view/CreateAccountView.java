package view;

import javax.swing.*;

public class CreateAccountView extends JFrame{
    private JButton btnShow;
    private JPanel panel;

    public CreateAccountView() {
        super("testo di esempio");
        btnShow.addActionListener(e -> {
            System.out.println("Prova");
        });

        setContentPane(panel);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreateAccountView::new);
    }
}
