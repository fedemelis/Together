package view;

import controller.LoginController;
import model.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class LoginView extends JFrame{
    private JButton btnLogin;
    private JPanel loginViewPanel;
    private JPanel centrePanel;
    private JTextField tbUser;
    private JPasswordField tbPassword;
    private JButton button1;
    private JButton btnEntra;
    private JLabel creaacc;
    private LoginController loginController;

    public LoginView() {
        super("Together");
        setContentPane(loginViewPanel);
        setSize(500, 500);
        setVisible(true);

        makeHighlighted_HandCursor(creaacc);

        loginController = new LoginController();

        creaacc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                SwingUtilities.invokeLater(CreateAccountView::new);
            }
        });


        btnEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginController.TryLogin(tbUser.getText(), tbPassword.getPassword())){
                    setVisible(false);
                    SwingUtilities.invokeLater(CalendarLoginView::new);
                }
                else{
                    System.out.println("Errore");
                }
            }
        });
    }

    public void makeHighlighted_HandCursor(JLabel label){
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginView::new);
    }

}
