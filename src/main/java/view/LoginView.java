package view;

import base.Calendar.CalendarDB;
import base.Event.Event;
import base.Event.EventDB;
import base.User.User;
import base.User.UserDB;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    private JLabel passErrLabel;
    private JPanel calendarPanel;
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
    private JButton addEvent;
    private JPanel loginCalendar;
    private JTextField tbCodice;
    private JPasswordField tbCalendarPassword;
    private JButton btgGoToCalendar;
    private JLabel currentUser;
    private JLabel creaCalendario;
    private JLabel loginErrorCalendar;
    private JPanel createEvent;
    private JTextField eventName;
    private JTextField eventData;
    private JTextField eventType;
    private JTextField eventDesc;
    private JButton btnCancellaNuovoEvento;
    private JButton btnConfermaNuovoEvento;
    private ArrayList<User> userList;
    private User currUser;

    @SneakyThrows
    public LoginView()  {


        super("Together");
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);
        makeHighlighted_HandCursor(creaacc);

        //usato per le operazioni sul database degli utenti
        UserDB userManager = new UserDB();
        CalendarDB calendarManager = new CalendarDB();
        EventDB eventManager = new EventDB();

        /**
         * porta alla creazione di un nuovo utente
         */
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

        /**
         * esegue il login per un utente
         */
        btnEntra.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbUser.getText().isEmpty() && !tbPassword.getText().isEmpty()){
                    User u = userManager.selectUserByUsername(tbUser.getText());
                    if(u != null){
                        if (u.getPassword().equals(tbPassword.getText())) {
                            System.out.println("ACCESSO ESEGUITO");
                            currUser = new User(tbUser.getText());
                            errorLabel.setText("");
                            initLoginCalendar(currUser);
                            mainPanel.removeAll();
                            mainPanel.add(loginCalendar);
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

        /**
         * crea un nuovo utente
         */
        btnCrea.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tbNewAccountPassword.getText().equals(tbConfirmPasword.getText())) {
                    userManager.insertUser(tbUsername.getText(), tbConfirmPasword.getText(), tbNome.getText(), tbCognome.getText(), tbEmail.getText());
                }
            }
        });
        /**
         * controlla se le password coincidono
         */
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

        /**
         * fa il login al calendario
         */
        btgGoToCalendar.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tbCodice.getText().isEmpty() && !tbCalendarPassword.getText().isEmpty()){
                    base.Calendar.Calendar c = calendarManager.selectCalendarByID(Integer.valueOf(tbCodice.getText()));
                    if(c != null){
                        if(c.getPass().equals(tbCalendarPassword.getText())){
                            System.out.println("Accesso al calendario");
                            initCalendarPanel(currUser, eventManager, c);
                            mainPanel.removeAll();
                            mainPanel.add(calendarPanel);
                            mainPanel.repaint();
                            mainPanel.revalidate();
                        }
                        else{
                            loginErrorCalendar.setText("Password errata");
                            loginErrorCalendar.setForeground(Color.red);
                        }
                    }
                    else{
                        loginErrorCalendar.setText("Calendario non trovato");
                        loginErrorCalendar.setForeground(Color.red);
                    }
                }
                else{
                    loginErrorCalendar.setText("Compila tutti i campi");
                    loginErrorCalendar.setForeground(Color.red);
                }
            }
        });
        /*
        bottone per l'inserimento di un nuovo evento nel calendario
         */
        addEvent.addActionListener(e -> {

            mainPanel.repaint();
            mainPanel.revalidate();

        });
    }

    /**
    Methods
     */

    /**
     * rende una label più visibile e aggiunge la mano al puntatore quando ci passi sopra
     * @param label è la label che vogliamo higlightare
     */
    public void makeHighlighted_HandCursor(JLabel label){
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }

    /**
     * aggiunge un placeholder ad una textbox
     * @param tb
     * @param s
     */
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

    /**
     * inizializza il calendario
     * @param currUser
     */
    public void initCalendarPanel(User currUser, EventDB eventManager, base.Calendar.Calendar currentCalendar) throws SQLException {
        /*lista per i valori da escludere nei for*/
        List<String> dName = new ArrayList<>(Arrays.asList("Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"));
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
        //prendo gli eventi
        List<Event> eventList = new ArrayList<>();
        eventList = eventManager.selectAllEventOfCalendar(currentCalendar);
        System.out.println(eventList);
        for (Component com : calendarPanel.getComponents()) {
            JPanel p = (JPanel) com;
            if(p.getComponentCount() == 2){
                Component c = p.getComponent(0);
                if(c instanceof JLabel){
                    JLabel l = (JLabel) c;
                    l.setFont(new Font("SansSerif", Font.PLAIN, 20));
                    p.setBorder(BorderFactory.createLineBorder(Color.black));
                    l.setText(calendar.get(Calendar.DATE) + " ");
                }
                c = p.getComponent(1);
                if(c instanceof JList<?>){
                    JList list = (JList) c;
                    DefaultListModel model = new DefaultListModel();

                    for(Event e : eventList){
                        String calendarDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(calendar.getTime());
                        if(e.getDate().equals(calendarDate)){
                            model.addElement(e.getNome());
                        }
                    }
                    list.setModel(model);
                }
                calendar.add(Calendar.DATE, 1);
            }
        }
    }

    /**
     * inizializza la schermata di login al calendario
     * @param u
     */
    public void initLoginCalendar(User u){
        makeHighlighted_HandCursor(creaCalendario);
        currentUser.setText(u.getUsername());
        setPlaceHolder(tbCodice, "Inserire codice calendario");
    }

}
