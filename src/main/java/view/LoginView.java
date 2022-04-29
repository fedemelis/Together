package view;

import base.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JPanel loginPanel;
    private JTextField tbUser;
    private JPasswordField tbPassword;
    private JButton btnEntra;
    private JLabel creaacc;
    private JLabel errorLabel;
    private ArrayList<User> userList;

    public LoginView() {
        super("Together");
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);

        ////////////////////////////
        userList = new ArrayList<User>();
        userList.add(new User("Federico", "pass"));
        userList.add(new User("Fede", "pass"));
        userList.add(new User("Luca", "pass"));
        userList.add(new User("Melis", "pass"));
        userList.add(new User("D'Amato", "pass"));
        ////////////////////////////

        makeHighlighted_HandCursor(creaacc);

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
                String risposta = TryLogin(tbUser.getText(), tbPassword.getPassword());
                if (risposta == "Successo"){
                    setVisible(false);
                    CreateAccountView.getFrames();
                    //SwingUtilities.invokeLater(CalendarLoginView::new);
                }
                else{
                    errorLabel.setText(risposta);
                    errorLabel.setForeground(Color.red);
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

    public String TryLogin(String user, char[] pass){
        if (!user.isEmpty() && (pass.length > 0)){
            User tmp = new User(user, String.valueOf(pass));
            if (userList.contains(tmp)){
                return "Successo";
            }
            return "Username o password errati";
        }
        return "Compila tutti i campi";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginView::new);
    }

}
