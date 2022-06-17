package view;

import base.User.User;
import base.User.UserDB;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.List;

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
    private JLabel passErrLabel;
    private JPanel calendarPanel;
    private JButton btnLoginCalendar;
    private JPanel lun;
    private JPanel mar;
    private JPanel mer;
    private JPanel gio;
    private JPanel ven;
    private JPanel sab;
    private JPanel dom;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JList list5;
    private JList list6;
    private JList list7;
    private JList list8;
    private JList list9;
    private JList list10;
    private JList list11;
    private JList list12;
    private JList list13;
    private JList list14;
    private JList list15;
    private JList list16;
    private JList list17;
    private JList list18;
    private JList list19;
    private JList list20;
    private JList list21;
    private JList list22;
    private JList list23;
    private JList list24;
    private JList list25;
    private JList list26;
    private JList list27;
    private JList list28;
    private JList list29;
    private JList list30;
    private JList list31;
    private JList list32;
    private JList list33;
    private JList list34;
    private JList list35;
    private JList list36;
    private JList list37;
    private JList list38;
    private JList list39;
    private JList list40;
    private JList list41;
    private JList list42;
    private JButton button1;
    private ArrayList<User> userList;

    @SneakyThrows
    public LoginView()  {

        super("Together");
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);
        makeHighlighted_HandCursor(creaacc);

        //usato per le operazioni sul database degli utenti
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
                            User currentUser = new User(tbUser.getText());
                            initCalendarPanel(currentUser);
                            errorLabel.setText("");
                            mainPanel.removeAll();
                            mainPanel.add(calendarPanel);
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
                if(tbNewAccountPassword.getText().equals(tbConfirmPasword.getText())) {
                    userManager.insertUser(tbUsername.getText(), tbConfirmPasword.getText(), tbNome.getText(), tbCognome.getText(), tbEmail.getText());
                }
            }
        });
        tbConfirmPasword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(!tbNewAccountPassword.getText().equals(tbConfirmPasword.getText())){
                    passErrLabel.setText("La password non coincide");
                    passErrLabel.setForeground(Color.red);
                    System.out.println("NO");

                }
                else{
                    passErrLabel.setText("");
                    System.out.println("SI");
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

    public void initCalendarPanel(User currentUser){
        /*lista per i valori da escludere nei for*/
        List<String> dName = new ArrayList<String>();
        dName.addAll(Arrays.asList("Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"));
        //preparo il calendar
        Calendar calendar = Calendar.getInstance();
        LocalDate date = LocalDate.now();
        //prendo anno e mese corrente
        int year = date.getYear();
        int month = date.getMonthValue();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        calendar.add(Calendar.DATE, -startDay);
        for (Component com : calendarPanel.getComponents()) {
            JPanel p = (JPanel) com;
            for(Component lab : p.getComponents()) {
                if(lab instanceof JLabel){
                    JLabel l = (JLabel) lab;
                    if(!dName.contains(l.getText())) {
                        l.setFont(new Font("SansSerif", Font.PLAIN, 20));
                        p.setBorder(BorderFactory.createLineBorder(Color.black));
                        l.setText(calendar.get(Calendar.DATE) + " ");
                        calendar.add(Calendar.DATE, 1);
                    }
                    if(l.getText().equals("Dom")){
                        l.setForeground(Color.red);
                    }
                }
            }
        }
    }

}
