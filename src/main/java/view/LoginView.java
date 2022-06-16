package view;

import base.User.User;
import base.User.UserDB;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    private JPanel a1;
    private JList list1;
    private JLabel l00;
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
    private JList list2;
    private JList list42;
    private ArrayList<User> userList;

    @SneakyThrows
    public LoginView()  {

        super("Together");
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);
        makeHighlighted_HandCursor(creaacc);

        initCalendarPanel();

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

    public void initCalendarPanel(){
        //setSize(1500, 1000);
        /*calendarPanel.setLayout(new GridLayout(7, 7));
        calendarPanel.add(new CalendarCell());
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));
        calendarPanel.add(new JButton("1"));*/

        Calendar calendar = Calendar.getInstance();
        int year = 2022;
        int month = 6;
        List<String> dName = new ArrayList<String>();
        dName.add("Lun");
        dName.add("Mar");
        dName.add("Mer");
        dName.add("Gio");
        dName.add("Ven");
        dName.add("Sab");
        dName.add("Dom");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  //  month jan as 0 so start from 0
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  //  get day of week -1 to index
        calendar.add(Calendar.DATE, -startDay);
        for (Component com : calendarPanel.getComponents()) {
            JPanel p = (JPanel) com;
            for(Component lab : p.getComponents()) {
                if(lab instanceof JLabel){
                    JLabel l = (JLabel) lab;
                    if(!dName.contains(l.getText())) {
                        l.setText(calendar.get(Calendar.DATE) + "");
                        calendar.add(Calendar.DATE, 1);
                    }
                }
            }
        }
    }

}
