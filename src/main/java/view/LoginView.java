package view;

import base.Calendar.CalendarDB;
import base.Event.Event;
import base.Event.EventDB;
import base.Partecipa.Partecipa;
import base.Partecipa.PartecipaDB;
import base.User.User;
import base.User.UserDB;
import lombok.SneakyThrows;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JButton avanti;
    private JButton indietro;
    private JLabel yearShow;
    private JList oldCalendar;
    private JLabel doUserHasSavedAccount;
    private ArrayList<User> userList;
    private User currUser;
    //private Calendar calendar;
    private int year;
    private int month;
    private base.Calendar.Calendar c;

    @SneakyThrows
    public LoginView()  {


        super("Together");
        setContentPane(mainPanel);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // width will store the width of the screen
        int width = (int)size.getWidth();
        // height will store the height of the screen
        int height = (int)size.getHeight();
        setSize(width, height);
        //setResizable(false);
        setVisible(true);
        makeHighlighted_HandCursor(creaacc);
        makeHighlighted_HandCursor(creaCalendario);
        initCreateEvent();



        //usato per le operazioni sul database
        UserDB userManager = new UserDB();
        CalendarDB calendarManager = new CalendarDB();
        EventDB eventManager = new EventDB();
        PartecipaDB partecipaManager = new PartecipaDB();

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
                            initLoginCalendar(currUser, partecipaManager);
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
                    c = calendarManager.selectCalendarByID(Integer.valueOf(tbCodice.getText()));
                    if(c != null){
                        if(c.getPass().equals(tbCalendarPassword.getText())){
                            System.out.println("Accesso al calendario");
                            //costruisco il calendario
                            calendarSetup();
                            //setto il calendario
                            initCalendarPanel(currUser, eventManager, c, year, month);
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
            mainPanel.removeAll();
            mainPanel.add(createEvent);
            mainPanel.repaint();
            mainPanel.revalidate();
        });

        btnCancellaNuovoEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventName.setText("");
                eventData.setText("");
                eventType.setText("");
                eventDesc.setText("");
                mainPanel.removeAll();
                mainPanel.add(calendarPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        btnConfermaNuovoEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    //TODO:

            }
        });

        //vai al mese precedente
        indietro.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if(month == 1){
                    month = 12;
                    year--;
                }
                else{
                    month--;
                }
                initCalendarPanel(currUser, eventManager, c, year, month);
            }
        });
        avanti.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if(month == 12){
                    month = 1;
                    year++;
                }
                else{
                    month++;
                }
                initCalendarPanel(currUser, eventManager, c, year, month);
            }
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
    public void initCalendarPanel(User currUser, EventDB eventManager, base.Calendar.Calendar currentCalendar, int year, int month) throws SQLException {
        /*lista per i valori da escludere nei for*/
        //List<String> dName = new ArrayList<>(Arrays.asList("Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"));
        //prendo la data attuale
        Calendar calendar = Calendar.getInstance();
        LocalDate date = LocalDate.now();
        int thisDay = date.getDayOfMonth();
        int thisMonth = date.getMonthValue();
        int thisYear = date.getYear();
        //prendo anno e mese corrente
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        yearShow.setText(df.format(calendar.getTime()).toUpperCase(Locale.ROOT));
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        if(startDay == 1){
            startDay = 6;
        }
        else{
            startDay -= 2;
        }
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, -startDay);
        //prendo gli eventi
        List<Event> eventList;
        //prendo tutti gli eventi del mese
        eventList = eventManager.selectAllEventOfSpecifiedMonth(currentCalendar, month);
        System.out.println(eventList);
        for (Component com : calendarPanel.getComponents()) {
            JPanel p = (JPanel) com;
            if(p.getComponentCount() == 2){
                Component c = p.getComponent(0);
                if(c instanceof JLabel){
                    JLabel l = (JLabel) c;
                    l.setFont(new Font("SansSerif", Font.PLAIN, 20));
                    p.setBorder(BorderFactory.createLineBorder(Color.black));
                    l.setText(calendar.get(Calendar.DATE) + "");
                    int t = Integer.parseInt(l.getText());
                    l.setForeground(Color.black);
                    if(thisDay == t && thisMonth == month && thisYear == year){
                        l.setForeground(Color.blue);
                    }
                }
                /**
                 * seleziono le jlist
                 */
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
                    list.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            System.out.println("Ciao");
                        }
                    });
                }
                calendar.add(Calendar.DATE, 1);
            }
        }
    }

    /**
     * inizializza la schermata di login al calendario
     * @param u
     */
    @SneakyThrows
    public void initLoginCalendar(User u, PartecipaDB partecipaManager){
        makeHighlighted_HandCursor(creaCalendario);
        currentUser.setText(u.getUsername());
        setPlaceHolder(tbCodice, "Inserire codice calendario");
        DefaultListModel model = new DefaultListModel();
        List<Partecipa> partecipaList;
        partecipaList = partecipaManager.selectAllCalendarOfSpecificUser(u.getUsername());
        for(Partecipa p : partecipaList){
            doUserHasSavedAccount.setText("Calendari salvati:");
            model.addElement(p.getIdcalendar());
        }
        oldCalendar.setModel(model);
    }

    public void initCreateEvent(){
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new JFormattedTextField.AbstractFormatter() {

            private String datePattern = "yyyy-MM-dd";
            private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

            @Override
            public Object stringToValue(String text) throws ParseException {
                return dateFormatter.parseObject(text);
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                if (value != null) {
                    Calendar cal = (Calendar) value;
                    return dateFormatter.format(cal.getTime());
                }
                return "";
            }
        });
        //createEvent.setLayout(new FlowLayout());
        createEvent.add(datePicker);
        mainPanel.revalidate();
        mainPanel.repaint();



    }

    public void calendarSetup(){
        //preparo il calendar
        //calendar = Calendar.getInstance();
        //prendo la data attuale
        LocalDate date = LocalDate.now();
        year = date.getYear();
        month = date.getMonthValue();
    }
}
