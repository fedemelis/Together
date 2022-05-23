package view;

import base.User.User;
import base.User.UserDB;
import lombok.SneakyThrows;

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
    private JTextField tbUsername;
    private JTextField tbEmail;
    private JPasswordField tbConfirmPasword;
    private JButton btnCrea;
    private JTextField tbNome;
    private JTextField tbCognome;
    private JLabel labelNome;
    private JLabel labelCognome;
    private JPanel createNewAccountPanel;
    private JPasswordField tbNewAccountPassword;
    private JPanel loginCalendarPanel;
    private JTextField tbCalendarName;
    private JTextField tbCalendarCode;
    private JButton btnLoginCalendar;
    private ArrayList<User> userList;

    @SneakyThrows
    public LoginView()  {

        super("Together");
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);
        makeHighlighted_HandCursor(creaacc);

        int i = 0;
        UserDB userManager = new UserDB();


        creaacc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainPanel.removeAll();
                mainPanel.add(createNewAccountPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
                setPlaceHolder(tbUsername, "Username");
                setPlaceHolder(tbEmail, "E-mail");
                setPlaceHolder(tbNome, "Nome");
                setPlaceHolder(tbCognome, "Cognome");
            }
        });


        btnEntra.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbUser.getText().isEmpty() && !tbPassword.getText().isEmpty()){
                    User u = userManager.selectUserByUsername(tbUser.getText());
                    if(u != null){
                        if (u.getPassword().equals(tbPassword.getText())) {
                            System.out.println("ACCESSO ESEGUITO");
                            errorLabel.setText("");
                            mainPanel.removeAll();
                            mainPanel.add(loginCalendarPanel);
                            mainPanel.repaint();
                            mainPanel.revalidate();
                        }
                        else {
                            errorLabel.setText("Password errata");
                            errorLabel.setForeground(Color.red);
                        }
                    }
                    else {
                        errorLabel.setText("Username errato");
                        errorLabel.setForeground(Color.red);
                    }
                }
                else {
                    errorLabel.setText("Compila tutti i campi");
                    errorLabel.setForeground(Color.red);
                }
            }
        });

        btnCrea.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tbNewAccountPassword.getText().equals(tbConfirmPasword.getText())){
                    userManager.insertUser(tbUsername.getText(), tbConfirmPasword.getText(), tbNome.getText(), tbCognome.getText(), tbEmail.getText());
                }
                else{
                    //TODO: aggiungere una label che stampa che le password non coincidono
                    System.out.println("NO");
                    System.out.println(tbNewAccountPassword.getText());
                    System.out.println(tbConfirmPasword.getText());

                }
            }
        });
    }

    /*
    Methods
     */


    public void makeHighlighted_HandCursor(JLabel label){
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
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
        SwingUtilities.invokeLater(LoginView::new);
    }

}
