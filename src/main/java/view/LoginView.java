package view;

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
    private LoginViewModel loginViewModel;

    public LoginView() {
        super("Together");
        setContentPane(loginViewPanel);
        setSize(500, 500);
        setVisible(true);
        /*
        * sottolinea il testo
        * */
        creaacc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = creaacc.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        creaacc.setFont(font.deriveFont(attributes));
        loginViewModel = new LoginViewModel();

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
                if(loginViewModel.LoginControl(tbUser.getText(), tbPassword.getPassword())){
                    setVisible(false);
                    SwingUtilities.invokeLater(CalendarLoginView::new);
                }
                else{
                    System.out.println("Errore");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginView::new);
    }

}
