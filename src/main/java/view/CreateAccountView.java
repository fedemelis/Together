package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CreateAccountView extends JFrame{
    private JButton btnShow;
    private JPanel mainPanel;
    private JTextField tbNome;
    private JTextField tbCognome;
    private JTextField tbUsername;
    private JTextField tbEmail;
    private JPasswordField tbPassword;
    private JPasswordField tbConfirmPasword;
    private JButton btnCrea;
    private JLabel labelNome;
    private JLabel labelCognome;

    public CreateAccountView() {
        super("testo di esempio");


        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);

        setPlaceHolder(tbUsername, "Username");
        setPlaceHolder(tbEmail, "E-mail");
        setPlaceHolder(tbNome, "Nome");
        setPlaceHolder(tbCognome, "Cognome");

    }

    public void setPlaceHolder(JTextField tb, String s){
        tb.setForeground(Color.GRAY);
        tb.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tb.getText().equals(s)) {
                    tb.setText("");
                    tb.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (tb.getText().isEmpty()) {
                    tb.setForeground(Color.GRAY);
                    tb.setText(s);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreateAccountView::new);
    }
}
