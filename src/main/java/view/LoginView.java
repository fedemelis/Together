package view;

import base.Calendar.CalendarDAO;
import base.Calendar.CalendarDB;
import base.Event.Event;
import base.Event.EventDAO;
import base.Event.EventDB;
import base.Partecipa.Partecipa;
import base.Partecipa.PartecipaDAO;
import base.Partecipa.PartecipaDB;
import base.User.User;
import base.User.UserDAO;
import base.User.UserDB;
import lombok.SneakyThrows;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
import java.util.Timer;
import java.util.regex.Pattern;

public class LoginView extends JFrame{
    public JPanel mainPanel;
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
    public JPanel calendarPanel;
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
    private JPanel createNewCalendar;
    private JTextField newCalendarCode;
    private JTextField newCalendarName;
    private JPasswordField newCalendarPass;
    private JPasswordField newCalendarPassConfirm;
    private JButton undoCreateCalendar;
    private JButton createCalendarConfirm;
    private JLabel createCalendarError;
    private JTextField newCalendarDesc;
    private JLabel labelUsername;
    private JLabel labelEmail;
    private JLabel labelPassword;
    private JLabel labelConfirmPassword;
    private JLabel labelLoginUsername;
    private JLabel labelLoginPassword;
    private JButton showPass;
    private JButton goBackToUserLoginFromUserCreation;
    private JLabel labelTitoloEvento;
    private JLabel labelTipoEvento;
    private JLabel labelDescrizioneEvento;
    private JPanel DatePickerPanel;
    private JLabel labelData;
    private JButton btnBackToCalendarLogin;
    private JLabel labelCode;
    private JLabel labelCalendarName;
    private JLabel labelPasswordCalendar;
    private JLabel labelConfirmPasswordCalendar;
    private JLabel labelCalendarDesc;
    private JLabel newEventError;
    private JButton backToUserLogin;
    private JPanel leftCalendarBlock;
    private JButton btnProfilo;
    private JLabel labelNomeUtente;
    private JPanel userPanel;
    private JTextField tbNomeUpdate;
    private JTextField tbCognomeUpdate;
    private JTextField tbEmailUpdate;
    private JPasswordField tbPasswordUpdate;
    private JPasswordField tbConfermaPasswordUpdate;
    private JLabel labelNomeUtenteUsername;
    private JButton btnAnnullaModifica;
    private JButton btnConfermaModifica;
    private JPanel topCalendarPanel;
    private JLabel wrongPass;
    private JPanel jpanelCell;
    private JLabel labelFilter;
    private JPanel topLeft;
    private JLabel doUserHaveCalendar;
    private ArrayList<User> userList;
    public User currUser;
    //private Calendar calendar;
    public int year;
    public int month;
    public int day;
    public base.Calendar.Calendar currCal;
    private boolean first = true;
    private boolean isShow = false;
    private HashMap<String, String> eventSelector = new HashMap();
    private boolean updating = false;
    private String currUUID;
    public List<Event> globalEventList;



    @SneakyThrows
    public LoginView() {
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
        LocalDate date = LocalDate.now();
        int thisDay = date.getDayOfMonth();
        int thisMonth = date.getMonthValue();
        int thisYear = date.getYear();
        initCreateEvent(thisYear, thisMonth, thisDay);
        JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
        dp.getModel().setDate(thisYear, thisMonth-1, thisDay);
        this.setExtendedState(MAXIMIZED_BOTH);
        loginPanel.requestFocusInWindow();



        Border standardBorder = tbUser.getBorder();

        creaCalendario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                creaCalendario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                creaCalendario.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

        });


        //usato per le operazioni sul database
        UserDAO userManager = new UserDB();
        CalendarDAO calendarManager = new CalendarDB();
        EventDAO eventManager = new EventDB();
        PartecipaDAO partecipaManager = new PartecipaDB();

        showPass.setSize(20, 20);
        indietro.setSize(40, 40);
        avanti.setSize(40, 40);
        btnProfilo.setSize(30, 30);

        ImageIcon eyeIcon = new ImageIcon("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\visibility.png");
        Image img = eyeIcon.getImage() ;
        Image newimg = img.getScaledInstance( showPass.getWidth(), showPass.getHeight(),  java.awt.Image.SCALE_SMOOTH );
        eyeIcon = new ImageIcon(newimg);
        showPass.setIcon(eyeIcon);

        ImageIcon addIcon = new ImageIcon("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\plus.png");
        Image imgAdd = addIcon.getImage();
        Image newimgAdd = imgAdd.getScaledInstance( addEvent.getWidth() / 2, addEvent.getWidth() / 2,  java.awt.Image.SCALE_SMOOTH );
        addIcon = new ImageIcon(newimgAdd);
        addEvent.setIcon(addIcon);

        ImageIcon rightIcon = new ImageIcon("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\next.png");
        Image imgRight = rightIcon.getImage();
        Image newimgRight = imgRight.getScaledInstance( avanti.getWidth(), avanti.getHeight(),  java.awt.Image.SCALE_SMOOTH );
        rightIcon = new ImageIcon(newimgRight);
        avanti.setIcon(rightIcon);

        ImageIcon leftIcon = new ImageIcon("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\left.png");
        Image imgLeft = leftIcon.getImage();
        Image newimgLeft = imgLeft.getScaledInstance( indietro.getWidth(), indietro.getHeight(),  java.awt.Image.SCALE_SMOOTH );
        leftIcon = new ImageIcon(newimgLeft);
        indietro.setIcon(leftIcon);

        ImageIcon userIcon = new ImageIcon("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\edit.png");
        Image imgUser = userIcon.getImage();
        Image newImgUser = imgUser.getScaledInstance( btnProfilo.getWidth(), btnProfilo.getHeight(),  java.awt.Image.SCALE_SMOOTH );
        userIcon = new ImageIcon(newImgUser);
        btnProfilo.setIcon(userIcon);

        ImageIcon logoIcon = new ImageIcon("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\support.png");
        Image imgIcon = logoIcon.getImage();
        this.setIconImage(imgIcon);

        Timer timer = new Timer();
        LiveUpdate liveUpdate = new LiveUpdate(this);
        TimerTask myTask = new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
                liveUpdate.update(eventManager, standardBorder);
            }
        };
        timer.schedule(myTask, 2000, 2000);

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
                tbUser.setText("");
                tbPassword.setText("");
                errorLabel.setText("");
                tbPassword.setBorder(standardBorder);
                tbUser.setBorder(standardBorder);
                isShow = false;
                tbPassword.setEchoChar('•');
            }
        });

        showPass.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                showPass.setBackground(new Color(187, 187, 187));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                showPass.setBackground(new Color(240, 240, 240));
            }
        });

        creaCalendario.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        indietro.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                indietro.setBackground(new Color(187, 187, 187));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                indietro.setBackground(new Color(240, 240, 240));
            }
        });

        avanti.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                avanti.setBackground(new Color(187, 187, 187));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                avanti.setBackground(new Color(240, 240, 240));
            }
        });

        btnProfilo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                btnProfilo.setBackground(new Color(187, 187, 187));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnProfilo.setBackground(new Color(240, 240, 240));
            }
        });

        addEvent.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                addEvent.setBackground(new Color(187, 187, 187));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addEvent.setBackground(new Color(240, 240, 240));
            }
        });
        //SwingUtilities.getRootPane(btnEntra).setDefaultButton(btnEntra);
                /**
                 * esegue il login per un utente
                 */
                btnEntra.addActionListener(new ActionListener() {
                    @SneakyThrows
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!tbUser.getText().isEmpty() && !tbPassword.getText().isEmpty()) {
                            User u = userManager.selectUserByUsername(tbUser.getText());
                            if (u != null) {
                                if (u.getPassword().equals(tbPassword.getText())) {
                                    System.out.println("ACCESSO ESEGUITO");
                                    currUser = new User(tbUser.getText());
                                    errorLabel.setText("");
                                    tbPassword.setBorder(standardBorder);
                                    tbUser.setBorder(standardBorder);
                                    //checkUserBox(currCal, eventManager);
                                    initLoginCalendar(currUser, partecipaManager, standardBorder);
                                    mainPanel.removeAll();
                                    mainPanel.add(loginCalendar);
                                    mainPanel.repaint();
                                    mainPanel.revalidate();
                                    tbUser.setText("");
                                    tbPassword.setText("");
                                    tbPassword.setEchoChar('•');
                                    //Highlighted_HandCursor(creaCalendario);

                                } else {
                                    if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
                                        errorLabel.setText("Username o password errati, prova a distattivare il caps lock");
                                    } else {
                                        errorLabel.setText("Username o password errati");
                                    }
                                    errorLabel.setForeground(Color.red);
                                    tbUser.setBorder(BorderFactory.createLineBorder(Color.red));
                                    tbPassword.setBorder(BorderFactory.createLineBorder(Color.red));

                                }
                            } else {
                                if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
                                    errorLabel.setText("Username o password errati, prova a distattivare il caps lock");
                                } else {
                                    errorLabel.setText("Username o password errati");
                                }
                                errorLabel.setForeground(Color.red);
                                tbPassword.setBorder(BorderFactory.createLineBorder(Color.red));
                                tbUser.setBorder(BorderFactory.createLineBorder(Color.red));
                            }
                        } else {
                            errorLabel.setText("Compila tutti i campi");
                            errorLabel.setForeground(Color.red);
                            tbPassword.setBorder(BorderFactory.createLineBorder(Color.red));
                            tbUser.setBorder(BorderFactory.createLineBorder(Color.red));
                        }
                    }
                });


        tbUser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                tbUser.setBorder(standardBorder);
                errorLabel.setText("");
            }
        });
        tbPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                tbPassword.setBorder(standardBorder);
                errorLabel.setText("");
            }
        });

        /**
         * crea un nuovo utente
         */
        btnCrea.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entrato");
                if(!tbNome.getText().isEmpty() && !tbCognome.getText().isEmpty() && !tbUsername.getText().isEmpty() && !tbEmail.getText().isEmpty() && !tbNewAccountPassword.getText().isEmpty() && !tbConfirmPasword.getText().isEmpty()) {
                    System.out.println("Entrato2");
                    if(!tbNome.getText().isEmpty()){
                        labelNome.setForeground(Color.black);
                        tbNome.setBorder(standardBorder);
                    }
                    if(!tbCognome.getText().isEmpty()){
                        labelCognome.setForeground(Color.black);
                        tbCognome.setBorder(standardBorder);
                    }
                    if(!tbUsername.getText().isEmpty()){
                        labelUsername.setForeground(Color.black);
                        tbUsername.setBorder(standardBorder);
                    }
                    if(!tbEmail.getText().isEmpty()){
                        labelEmail.setForeground(Color.black);
                        tbEmail.setBorder(standardBorder);
                    }
                    if(!tbNewAccountPassword.getText().isEmpty()){
                        labelPassword.setForeground(Color.black);
                        tbNewAccountPassword.setBorder(standardBorder);
                    }
                    if(!tbConfirmPasword.getText().isEmpty()){
                        labelConfirmPassword.setForeground(Color.black);
                        tbConfirmPasword.setBorder(standardBorder);
                    }
                    if (tbNewAccountPassword.getText().equals(tbConfirmPasword.getText())) {
                        if(!isValidMail(tbEmail.getText())){
                            passErrLabel.setText("Mail non valida");
                            passErrLabel.setForeground(Color.red);
                            tbEmail.setBorder(BorderFactory.createLineBorder(Color.red));
                        }
                        else{
                            User u = userManager.selectUserByUsername(tbUsername.getText());
                            if(u == null){
                                System.out.println("inserito");
                                userManager.insertUser(tbUsername.getText(), tbConfirmPasword.getText(), tbNome.getText(), tbCognome.getText(), tbEmail.getText());
                                tbUser.setText(tbUsername.getText());
                                tbPassword.setText(tbNewAccountPassword.getText());
                                tbUsername.setText("");
                                tbNome.setText("");
                                tbCognome.setText("");
                                tbNewAccountPassword.setText("");
                                tbConfirmPasword.setText("");
                                tbEmail.setText("");
                                mainPanel.removeAll();
                                mainPanel.add(loginPanel);
                                mainPanel.repaint();
                                mainPanel.revalidate();
                            }
                            else{
                                passErrLabel.setText("Nome utente non disponibile");
                                passErrLabel.setForeground(Color.red);
                                tbUsername.setBorder(BorderFactory.createLineBorder(Color.red));
                            }
                        }
                    }
                }
                else{
                    if(tbNome.getText().isEmpty()){
                        labelNome.setForeground(Color.red);
                        tbNome.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbCognome.getText().isEmpty()){
                        labelCognome.setForeground(Color.red);
                        tbCognome.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbUsername.getText().isEmpty()){
                        labelUsername.setForeground(Color.red);
                        tbUsername.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbEmail.getText().isEmpty()){
                        labelEmail.setForeground(Color.red);
                        tbEmail.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbNewAccountPassword.getText().isEmpty()){
                        labelPassword.setForeground(Color.red);
                        tbNewAccountPassword.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbConfirmPasword.getText().isEmpty()){
                        labelConfirmPassword.setForeground(Color.red);
                        tbConfirmPasword.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                }
            }
        });

        /**
         * cambio del colore mentre l'utente scrive nelle textbox
         * */
        tbNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                labelNome.setForeground(Color.black);
                tbNome.setBorder(standardBorder);
            }
        });
        tbCognome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                labelCognome.setForeground(Color.black);
                tbCognome.setBorder(standardBorder);
            }
        });
        tbUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                labelUsername.setForeground(Color.black);
                tbUsername.setBorder(standardBorder);
            }
        });
        tbEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                labelEmail.setForeground(Color.black);
                tbEmail.setBorder(standardBorder);
            }
        });
        tbNewAccountPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                labelPassword.setForeground(Color.black);
                tbNewAccountPassword.setBorder(standardBorder);
            }
        });
        tbConfirmPasword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                labelConfirmPassword.setForeground(Color.black);
                tbConfirmPasword.setBorder(standardBorder);
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

        tbNewAccountPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(!tbConfirmPasword.getText().equals(tbNewAccountPassword.getText())){
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
                    currCal = calendarManager.selectCalendarByID(Integer.valueOf(tbCodice.getText()));
                    if(currCal != null){
                        if(currCal.getPass().equals(tbCalendarPassword.getText())){
                            System.out.println("Accesso al calendario");
                            Partecipa p = partecipaManager.selectSpecificCalendarOfSpecificUser(Integer.parseInt(tbCodice.getText()), currUser.getUsername());
                            System.out.println(p);
                            if(p == null){
                                partecipaManager.insertNewCalendarForSpecificUser(Integer.parseInt(tbCodice.getText()), currUser.getUsername());
                                initLoginCalendar(currUser, partecipaManager, standardBorder);
                            }
                            //costruisco il calendario
                            calendarSetup();
                            checkUserBox(currCal, eventManager, standardBorder);
                            //setto il calendario
                            initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
                            mainPanel.removeAll();
                            mainPanel.add(calendarPanel);
                            mainPanel.repaint();
                            mainPanel.revalidate();
                            tbCodice.setText("");
                            tbCalendarPassword.setText("");
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
            addEvent.setBackground(new Color(240, 240, 240));
            System.out.println(eventSelector);
            mainPanel.add(createEvent);
            mainPanel.repaint();
            mainPanel.revalidate();
            JDatePickerImpl dateP = (JDatePickerImpl) DatePickerPanel.getComponent(0);
            dateP.getModel().setDate(year, month-1, day);
        });

        btnCancellaNuovoEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updating = false;
                eventName.setText("");
                eventType.setText("");
                eventDesc.setText("");
                newEventError.setForeground(Color.black);
                newEventError.setText("");
                labelTitoloEvento.setForeground(Color.black);
                eventName.setBorder(standardBorder);
                JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
                labelData.setForeground(Color.black);
                dp.setBorder(standardBorder);
                mainPanel.removeAll();
                mainPanel.add(calendarPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        btnConfermaNuovoEvento.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                    boolean done = false;
                    Date d = (Date) (((JDatePickerImpl) DatePickerPanel.getComponent(0)).getModel().getValue());
                    String newEventDate = "";
                    if(d != null) {
                        newEventDate = new SimpleDateFormat("yyyy-MM-dd").format(d);
                    }
                    //System.out.println(newEventDate);
                    if(!updating) {
                        if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && !eventType.getText().isEmpty() && !eventDesc.getText().isEmpty()) {
                            eventManager.insertEvent(currCal, eventName.getText(), newEventDate, currUser, eventType.getText(), eventDesc.getText());
                            done = true;
                        } else if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && eventType.getText().isEmpty() && eventDesc.getText().isEmpty()) {
                            eventManager.insertEvent(currCal, eventName.getText(), newEventDate, currUser);
                            done = true;
                        } else if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && !eventType.getText().isEmpty() && eventDesc.getText().isEmpty()) {
                            eventManager.insertEventWithType(currCal, eventName.getText(), newEventDate, currUser, eventType.getText());
                            done = true;
                        } else if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && !eventDesc.getText().isEmpty() && eventType.getText().isEmpty()) {
                            eventManager.insertEventWithDesc(currCal, eventName.getText(), newEventDate, currUser, eventDesc.getText());
                            done = true;
                        }
                        if (done == true) {
                            calendarSetup();
                            checkUserBox(currCal, eventManager, standardBorder);
                            initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
                            mainPanel.removeAll();
                            mainPanel.add(calendarPanel);
                            mainPanel.repaint();
                            mainPanel.revalidate();
                        } else {
                            newEventError.setForeground(Color.red);
                            newEventError.setText("Compila tutti i campi obbligatori");
                            labelTitoloEvento.setForeground(Color.red);
                            eventName.setBorder(BorderFactory.createLineBorder(Color.red));
                            JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
                            labelData.setForeground(Color.red);
                            dp.setBorder(BorderFactory.createLineBorder(Color.red));
                        }
                    }
                    else{
                        if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && !eventType.getText().isEmpty() && !eventDesc.getText().isEmpty()) {
                            eventManager.updateEvent(eventName.getText(), newEventDate, currUser, eventType.getText(), eventDesc.getText(), currUUID);
                            done = true;
                        } else if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && eventType.getText().isEmpty() && eventDesc.getText().isEmpty()) {
                            eventManager.updateEvent(eventName.getText(), newEventDate, currUser, currUUID);
                            done = true;
                        } else if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && !eventType.getText().isEmpty() && eventDesc.getText().isEmpty()) {
                            eventManager.updateEventWithType(eventName.getText(), newEventDate, currUser, eventType.getText(), currUUID);
                            done = true;
                        } else if (!eventName.getText().isEmpty() && !newEventDate.isEmpty() && !eventDesc.getText().isEmpty() && eventType.getText().isEmpty()) {
                            eventManager.updateEventWithDesc(eventName.getText(), newEventDate, currUser, eventDesc.getText(), currUUID);
                            done = true;
                        }
                        if (done == true) {
                            calendarSetup();
                            checkUserBox(currCal, eventManager, standardBorder);
                            initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
                            mainPanel.removeAll();
                            mainPanel.add(calendarPanel);
                            mainPanel.repaint();
                            mainPanel.revalidate();
                        } else {
                            newEventError.setForeground(Color.red);
                            newEventError.setText("Compila tutti i campi obbligatori");
                            labelTitoloEvento.setForeground(Color.red);
                            eventName.setBorder(BorderFactory.createLineBorder(Color.red));
                            JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
                            labelData.setForeground(Color.red);
                            dp.setBorder(BorderFactory.createLineBorder(Color.red));
                        }
                        updating = false;
                    }
                    eventName.setText("");
                    eventType.setText("");
                    eventDesc.setText("");
                    JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
                    dp.getModel().setDate(year, month-1, day);

                    dp.getModel().addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        labelData.setForeground(Color.black);
                        dp.setBorder(standardBorder);
                    }
                });
            }
        });

        eventName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                labelTitoloEvento.setForeground(Color.black);
                eventName.setBorder(standardBorder);
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
                //checkUserBox(currCal, eventManager, standardBorder);
                String s = filterEventByUser();
                if(s != ""){
                    List<Event> list = eventManager.selectEventFiltered(s, currCal);
                    initCalendarPanelFiltered(currUser, eventManager, currCal, year, month, standardBorder, list);
                }
                else{
                    List<Event> listNull = new ArrayList<>();
                    initCalendarPanelFiltered(currUser, eventManager, currCal, year, month, standardBorder,  listNull);
                }
                //initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
            }
        });

        //vai al mese successivo
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
                //checkUserBox(currCal, eventManager, standardBorder);
                String s = filterEventByUser();
                if(s != ""){
                    List<Event> list = eventManager.selectEventFiltered(s, currCal);
                    initCalendarPanelFiltered(currUser, eventManager, currCal, year, month, standardBorder, list);
                }
                else{
                    List<Event> listNull = new ArrayList<>();
                    initCalendarPanelFiltered(currUser, eventManager, currCal, year, month, standardBorder,  listNull);
                }
                //initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
            }
        });

        creaCalendario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("click");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                mainPanel.removeAll();
                mainPanel.add(createNewCalendar);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        undoCreateCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newCalendarCode.setText("");
                newCalendarName.setText("");
                newCalendarPass.setText("");
                newCalendarPassConfirm.setText("");
                newCalendarDesc.setText("");
                mainPanel.removeAll();
                mainPanel.add(loginCalendar);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        newCalendarPassConfirm.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(!newCalendarPass.getText().equals(newCalendarPassConfirm.getText())){
                    createCalendarError.setText("La password non coincide");
                    createCalendarError.setForeground(Color.red);

                }
                else{
                    createCalendarError.setText("");
                }
            }
        });

        createCalendarConfirm.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean numeric = true;
                if(!newCalendarCode.getText().isEmpty() && !newCalendarName.getText().isEmpty() && !newCalendarPass.getText().isEmpty() && !newCalendarPassConfirm.getText().isEmpty()){
                    try {
                        int n = Integer.parseInt(newCalendarCode.getText());
                    }
                    catch (NumberFormatException e1){
                        createCalendarError.setText("Inserisci un codice numerico");
                        createCalendarError.setForeground(Color.red);
                        numeric = false;
                    }
                    if(newCalendarPass.getText().equals(newCalendarPassConfirm.getText()) && numeric) {
                        base.Calendar.Calendar c = calendarManager.selectCalendarByID(Integer.parseInt(newCalendarCode.getText()));
                        if(c == null){
                            if(newCalendarDesc.getText().isEmpty()){
                                calendarManager.insertCalendar(Integer.parseInt(newCalendarCode.getText()), newCalendarName.getText(), newCalendarPass.getText());
                                partecipaManager.insertNewCalendarForSpecificUser(Integer.parseInt(newCalendarCode.getText()), currUser.getUsername());
                            }
                            else{
                                calendarManager.insertCalendar(Integer.parseInt(newCalendarCode.getText()), newCalendarName.getText(), newCalendarPass.getText(), newCalendarDesc.getText());
                                partecipaManager.insertNewCalendarForSpecificUser(Integer.parseInt(newCalendarCode.getText()), currUser.getUsername());
                            }
                            initLoginCalendar(currUser, partecipaManager, standardBorder);
                            //checkUserBox(currCal, eventManager);
                            newCalendarCode.setText("");
                            newCalendarName.setText("");
                            newCalendarPass.setText("");
                            newCalendarPassConfirm.setText("");
                            newCalendarDesc.setText("");
                            createCalendarError.setText("");
                            mainPanel.removeAll();
                            mainPanel.add(loginCalendar);
                            mainPanel.repaint();
                            mainPanel.revalidate();
                        }
                        else{
                            createCalendarError.setText("Esiste già un calendario con lo stesso codice");
                            createCalendarError.setForeground(Color.red);
                        }
                    }
                }
                else{
                    createCalendarError.setText("Compila tutti i campi richiesti");
                    createCalendarError.setForeground(Color.red);
                }
            }
        });

        showPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isShow) {
                    isShow = true;
                    tbPassword.setEchoChar((char) 0);
                }
                else{
                    isShow = false;
                    tbPassword.setEchoChar('•');
                }
            }
        });



        goBackToUserLoginFromUserCreation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(loginPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
                tbNome.setText("");
                tbCognome.setText("");
                tbUsername.setText("");
                tbEmail.setText("");
                tbNewAccountPassword.setText("");
                tbConfirmPasword.setText("");
                labelNome.setForeground(Color.black);
                tbNome.setBorder(standardBorder);
                labelCognome.setForeground(Color.black);
                tbCognome.setBorder(standardBorder);
                labelUsername.setForeground(Color.black);
                tbUsername.setBorder(standardBorder);
                labelEmail.setForeground(Color.black);
                tbEmail.setBorder(standardBorder);
                labelPassword.setForeground(Color.black);
                tbNewAccountPassword.setBorder(standardBorder);
                labelConfirmPassword.setForeground(Color.black);
                tbConfirmPasword.setBorder(standardBorder);
                //getRootPane().setDefaultButton(btnEntra);
            }
        });

        btnBackToCalendarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(loginCalendar);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        backToUserLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //oldCalendar.getSelectedValue()
                mainPanel.removeAll();
                mainPanel.add(loginPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
                //getRootPane().setDefaultButton(btnEntra);
            }
        });

        btnProfilo.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                btnProfilo.setBackground(new Color(240, 240, 240));
                JLabel label = (JLabel) topCalendarPanel.getComponent(1);
                String nomeUser = label.getText();
                User userToModify = userManager.selectUserByUsername(nomeUser);

                labelNomeUtenteUsername.setText(userToModify.getUsername());
                tbNomeUpdate.setText(userToModify.getNome());
                tbCognomeUpdate.setText(userToModify.getCognome());
                tbEmailUpdate.setText(userToModify.getMail());
                tbPasswordUpdate.setText(userToModify.getPassword());
                tbConfermaPasswordUpdate.setText(userToModify.getPassword());

                mainPanel.removeAll();
                mainPanel.add(userPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        btnAnnullaModifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(calendarPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
                wrongPass.setText("");
            }
        });

        tbConfermaPasswordUpdate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(!tbPasswordUpdate.getText().equals(tbConfermaPasswordUpdate.getText())){
                    wrongPass.setText("La password non coincide");
                    wrongPass.setForeground(Color.red);
                    System.out.println("NO");

                }
                else{
                    wrongPass.setText("");
                    System.out.println("SI");
                }
            }
        });

        tbPasswordUpdate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(!tbConfermaPasswordUpdate.getText().equals(tbPasswordUpdate.getText())){
                    wrongPass.setText("La password non coincide");
                    wrongPass.setForeground(Color.red);
                    System.out.println("NO");

                }
                else{
                    wrongPass.setText("");
                    System.out.println("SI");
                }
            }
        });

        btnConfermaModifica.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tbNomeUpdate.getText().isEmpty() && !tbCognomeUpdate.getText().isEmpty() && !tbEmailUpdate.getText().isEmpty() && !tbPasswordUpdate.getText().isEmpty() && !tbConfermaPasswordUpdate.getText().isEmpty()) {
                    if(!tbNomeUpdate.getText().isEmpty()){
                        tbNomeUpdate.setBorder(standardBorder);
                    }
                    if(!tbCognomeUpdate.getText().isEmpty()){
                        tbCognomeUpdate.setBorder(standardBorder);
                    }
                    if(!tbEmailUpdate.getText().isEmpty()){
                        tbEmailUpdate.setBorder(standardBorder);
                    }
                    if(!tbPasswordUpdate.getText().isEmpty()){
                        tbPasswordUpdate.setBorder(standardBorder);
                    }
                    if(!tbConfermaPasswordUpdate.getText().isEmpty()){
                        tbConfermaPasswordUpdate.setBorder(standardBorder);
                    }
                    if (tbPasswordUpdate.getText().equals(tbConfermaPasswordUpdate.getText())) {
                        if(!isValidMail(tbEmailUpdate.getText())){
                            wrongPass.setText("Mail non valida");
                            wrongPass.setForeground(Color.red);
                            tbEmailUpdate.setBorder(BorderFactory.createLineBorder(Color.red));
                        }
                        else{
                            /////
                            if(tbPasswordUpdate.getText().equals(tbConfermaPasswordUpdate.getText())){
                                User userModified = new User(
                                        labelNomeUtenteUsername.getText(),
                                        tbPasswordUpdate.getText(),
                                        tbNomeUpdate.getText(),
                                        tbCognomeUpdate.getText(),
                                        tbEmailUpdate.getText()
                                );
                                userManager.updateUserByUsername(userModified);
                                currUser = userModified;
                                mainPanel.removeAll();
                                mainPanel.add(calendarPanel);
                                mainPanel.repaint();
                                mainPanel.revalidate();
                            }
                            ///////
                        }
                    }
                }
                else{
                    if(tbNomeUpdate.getText().isEmpty()){
                        tbNomeUpdate.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbCognomeUpdate.getText().isEmpty()){
                        tbCognomeUpdate.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbEmailUpdate.getText().isEmpty()){
                        tbEmailUpdate.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbPasswordUpdate.getText().isEmpty()){
                        tbPasswordUpdate.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                    if(tbConfermaPasswordUpdate.getText().isEmpty()){
                        tbConfermaPasswordUpdate.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                }
                ////////////////////////////////////////////////////////////////////////
            }
        });

        tbNomeUpdate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                tbNomeUpdate.setBorder(standardBorder);
            }
        });
        tbCognomeUpdate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                tbCognomeUpdate.setBorder(standardBorder);
            }
        });
        tbEmailUpdate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                tbEmailUpdate.setBorder(standardBorder);
            }
        });
        tbPasswordUpdate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                tbPasswordUpdate.setBorder(standardBorder);
            }
        });
        tbConfermaPasswordUpdate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                tbConfermaPasswordUpdate.setBorder(standardBorder);
            }
        });
    }

    /**
    Methods
     */

    /**
     * rende una label più visibile e aggiunge la mano al puntatore quando ci passi sopra
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



    @SneakyThrows
    public static void main(String[] args) {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(LoginView::new);
    }

    @SneakyThrows
    public void checkUserBox(base.Calendar.Calendar currentCalendar, EventDAO eventManager, Border standardBorder){
        leftCalendarBlock.removeAll();
        leftCalendarBlock.setLayout(new GridLayout(20, 1));
        System.out.println("entrato");
        List<String> stringList;
        stringList = eventManager.selectUserameOfUsersFromEventAdded(currentCalendar);
        if(!stringList.isEmpty()){
            System.out.println("scrivo utenti");
            labelFilter.setText("Utenti:");
        }
        for(String s : stringList){
            leftCalendarBlock.add(new JCheckBox(s, true));
        }
        for(Component c : leftCalendarBlock.getComponents()){
            JCheckBox checkBox = (JCheckBox) c;
            checkBox.addActionListener(new ActionListener() {
                @SneakyThrows
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = filterEventByUser();
                    if(s != ""){
                        List<Event> list = eventManager.selectEventFiltered(s, currentCalendar);
                        initCalendarPanelFiltered(currUser, eventManager, currCal, year, month, standardBorder, list);
                    }
                    else{
                        List<Event> listNull = new ArrayList<>();
                        initCalendarPanelFiltered(currUser, eventManager, currCal, year, month, standardBorder,  listNull);
                    }
                }
            });
        }
    }

    /**
     * inizializza il calendario
     */
    public void initCalendarPanel(User currUser, EventDAO eventManager, base.Calendar.Calendar currentCalendar, int year, int month, Border standardBorder) throws SQLException {
        /*lista per i valori da escludere nei for*/
        //List<String> dName = new ArrayList<>(Arrays.asList("Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"));
        //prendo la data attuale
        labelNomeUtente.setText(currUser.getUsername());
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
        globalEventList = eventManager.selectAllEventOfCalendar(currentCalendar);
        for(Event e : eventList){
            System.out.println(e.getIdEvent());
        }
        int currentMonthDay = 1;
        for (Component com : calendarPanel.getComponents()) {
            if(com.getName() != "topLeft") {
                JPanel p = (JPanel) com;
                //Dimension d = new Dimension(150, 70);
                if (p.getComponentCount() == 2) {
                    if (!(p.getComponent(0) instanceof JCheckBox)) {
                        /*p.addMouseListener(new MouseAdapter() {
                            @SneakyThrows
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                                    mainPanel.removeAll();
                                    p.setBackground(new Color(240, 240, 240));
                                    JPanel panel = (JPanel) ( e.getSource());
                                    JLabel label = (JLabel) panel.getComponent(0);
                                    String cDay = label.getText();
                                    JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
                                    dp.getModel().setDate(year, month-1, Integer.parseInt(cDay));
                                    dp.getModel().setSelected(true);
                                    mainPanel.add(createEvent);
                                    mainPanel.repaint();
                                    mainPanel.revalidate();
                                }
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                p.setBackground(new Color(187, 187, 187));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                p.setBackground(new Color(240, 240, 240));
                            }
                        });*/
                        /***
                         * jlabel
                         */
                        Component c = p.getComponent(0);
                        if (c instanceof JLabel) {
                            JLabel l = (JLabel) c;
                            l.setFont(new Font("SansSerif", Font.PLAIN, 20));
                            p.setBorder(standardBorder);
                            l.setText(calendar.get(Calendar.DATE) + "");
                            int t = Integer.parseInt(l.getText());
                            l.setForeground(Color.black);
                            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                                l.setForeground(Color.red);
                            }
                            if (thisDay == t && thisMonth == month && thisYear == year) {
                                day = thisDay;
                                l.setForeground(Color.blue);
                            }
                            if(currentMonthDay == t){
                                currentMonthDay+=1;
                                p.addMouseListener(new MouseAdapter() {
                                    @SneakyThrows
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                                            mainPanel.removeAll();
                                            p.setBackground(new Color(240, 240, 240));
                                            JPanel panel = (JPanel) ( e.getSource());
                                            JLabel label = (JLabel) panel.getComponent(0);
                                            String cDay = label.getText();
                                            JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
                                            dp.getModel().setDate(year, month-1, Integer.parseInt(cDay));
                                            dp.getModel().setSelected(true);
                                            mainPanel.add(createEvent);
                                            mainPanel.repaint();
                                            mainPanel.revalidate();
                                        }
                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {
                                        p.setBackground(new Color(187, 187, 187));
                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {
                                        p.setBackground(new Color(240, 240, 240));
                                    }
                                });
                            }
                            else{
                                //teletrasporto
                                l.setForeground(Color.gray);
                            }
                        }

                        /**
                         * seleziono le jlist
                         */
                        c = p.getComponent(1);
                        if (c instanceof JList<?>) {
                            JList list = (JList) c;
                            DefaultListModel model = new DefaultListModel();
                            for (Event e : eventList) {
                                String calendarDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(calendar.getTime());
                                if (e.getDate().equals(calendarDate)) {
                                    calendarDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                                    model.addElement(e.getNome() + " " + calendarDate);
                                    eventSelector.put(e.getNome() + " " + calendarDate, e.getIdEvent());
                                }
                            }
                            //attacco la lista di stringhe alla jlist
                            list.setModel(model);
                            /**
                             * recepisce il click sul singolo oggetto della lista di eventi
                             */
                            list.addListSelectionListener(new ListSelectionListener() {
                                boolean b = false;

                                @Override
                                public void valueChanged(ListSelectionEvent e) {
                                    if (b) {
                                        String s = (String) ((JList) e.getSource()).getSelectedValue();
                                        if (s != null) {
                                            b = false;
                                        }
                                        b = false;
                                    } else {
                                        String s = (String) ((JList) e.getSource()).getSelectedValue();
                                        if (s != null) {
                                            //System.out.println(s);
                                            JPopupMenu menu = new JPopupMenu();
                                            JMenuItem update = new JMenuItem("Modifica");
                                            JMenuItem delete = new JMenuItem("Elimina");
                                            menu.add(update);
                                            menu.add(delete);
                                            int index = ((JList<?>) e.getSource()).getSelectedIndex();
                                            Rectangle bounds = ((JList<?>) e.getSource()).getCellBounds(index, index);
                                            Point p = bounds.getLocation();
                                            menu.show((Component) e.getSource(), p.x, p.y);
                                            //System.out.println(s);
                                            ((JList<?>) e.getSource()).clearSelection();
                                            b = true;
                                            /**
                                             * listener update
                                             * */
                                            update.addActionListener(new ActionListener() {
                                                @SneakyThrows
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    updating = true;
                                                    Event eventToModify = eventManager.selectEventByUUDI(eventSelector.get(s));
                                                    eventName.setText(eventToModify.getNome());
                                                    if (eventToModify.getType() != null) {
                                                        eventType.setText(eventToModify.getType());
                                                    }
                                                    if (eventToModify.getDesc() != null) {
                                                        eventDesc.setText(eventToModify.getDesc());
                                                    }
                                                    currUUID = eventSelector.get(s);
                                                    mainPanel.removeAll();
                                                    mainPanel.add(createEvent);
                                                    mainPanel.revalidate();
                                                    mainPanel.repaint();
                                                }
                                            });

                                            /***
                                             * listener delete
                                             */
                                            delete.addActionListener(new ActionListener() {
                                                @SneakyThrows
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    currUUID = eventSelector.get(s);
                                                    eventManager.deleteEventById(currUUID);
                                                    calendarSetup();
                                                    checkUserBox(currCal, eventManager, standardBorder);
                                                    initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
                                                    mainPanel.removeAll();
                                                    mainPanel.add(calendarPanel);
                                                    mainPanel.repaint();
                                                    mainPanel.revalidate();
                                                }
                                            });
                                        }
                                        b = true;
                                    }
                                }
                            });
                        }
                        //mando avanti il calendario per la scrittura
                        calendar.add(Calendar.DATE, 1);
                    }
                }
            }
        }
    }

    public void initCalendarPanelFiltered(User currUser, EventDAO eventManager, base.Calendar.Calendar currentCalendar, int year, int month, Border standardBorder, List<Event> listEventFiltered) throws SQLException {
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
        //prendo tutti gli eventi del mese
        int currentMonthDay = 1;
        for (Component com : calendarPanel.getComponents()) {
            JPanel p = (JPanel) com;
            if(p.getComponentCount() == 2){
                Component c = p.getComponent(0);
                if(c instanceof JLabel){
                    //p.removeMouseListener();
                    JLabel l = (JLabel) c;
                    l.setFont(new Font("SansSerif", Font.PLAIN, 20));
                    p.setBorder(standardBorder);
                    l.setText(calendar.get(Calendar.DATE) + "");
                    int t = Integer.parseInt(l.getText());
                    l.setForeground(Color.black);
                    if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
                        l.setForeground(Color.red);
                    }
                    if(thisDay == t && thisMonth == month && thisYear == year){
                        day = thisDay;
                        l.setForeground(Color.blue);
                    }
                    if(currentMonthDay == t){
                        currentMonthDay+=1;
                        p.addMouseListener(new MouseAdapter() {
                            @SneakyThrows
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                                    mainPanel.removeAll();
                                    p.setBackground(new Color(240, 240, 240));
                                    JPanel panel = (JPanel) ( e.getSource());
                                    JLabel label = (JLabel) panel.getComponent(0);
                                    String cDay = label.getText();
                                    JDatePickerImpl dp = (JDatePickerImpl) DatePickerPanel.getComponent(0);
                                    dp.getModel().setDate(year, month-1, Integer.parseInt(cDay));
                                    dp.getModel().setSelected(true);
                                    mainPanel.add(createEvent);
                                    mainPanel.repaint();
                                    mainPanel.revalidate();
                                }
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                p.setBackground(new Color(187, 187, 187));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                p.setBackground(new Color(240, 240, 240));
                            }
                        });
                    }
                    else{
                        //teletrasporto
                        l.setForeground(Color.gray);;
                    }
                }


                /**
                 * seleziono le jlist
                 */
                c = p.getComponent(1);
                if(c instanceof JList<?>){
                    JList list = (JList) c;
                    DefaultListModel model = new DefaultListModel();
                    for(Event e : listEventFiltered){
                        String calendarDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(calendar.getTime());
                        if(e.getDate().equals(calendarDate)){
                            calendarDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                            model.addElement(e.getNome()+ " " + calendarDate);
                            eventSelector.put(e.getNome()+ " " + calendarDate, e.getIdEvent());
                        }
                    }
                    //attacco la lista di stringhe alla jlist
                    list.setModel(model);
                    /**
                     * recepisce il click sul singolo oggetto della lista di eventi
                     */
                    list.addListSelectionListener(new ListSelectionListener() {
                        boolean b = false;

                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (b == true) {
                                String s = (String) ((JList) e.getSource()).getSelectedValue();
                                if (s != null) {
                                    b = false;
                                }
                                b = false;
                            } else {
                                String s = (String) ((JList) e.getSource()).getSelectedValue();
                                if (s != null) {
                                    //System.out.println(s);
                                    JPopupMenu menu = new JPopupMenu();
                                    JMenuItem update = new JMenuItem("Modifica");
                                    JMenuItem delete = new JMenuItem("Elimina");
                                    menu.add(update);
                                    menu.add(delete);
                                    int index = ((JList<?>) e.getSource()).getSelectedIndex();
                                    Rectangle bounds = ((JList<?>) e.getSource()).getCellBounds(index, index);
                                    Point p = bounds.getLocation();
                                    menu.show((Component) e.getSource(), p.x, p.y);
                                    //System.out.println(s);
                                    ((JList<?>) e.getSource()).clearSelection();
                                    b = true;
                                    /**
                                     * listener update
                                     * */
                                    update.addActionListener(new ActionListener() {
                                        @SneakyThrows
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            updating = true;
                                            System.out.println(s + "SONO LA STRINGA");
                                            System.out.println(eventSelector.get(s) + "SONO L'UUID");
                                            System.out.println(eventSelector);
                                            Event eventToModify = eventManager.selectEventByUUDI(eventSelector.get(s));
                                            eventName.setText(eventToModify.getNome());
                                            if (eventToModify.getType() != null) {
                                                eventType.setText(eventToModify.getType());
                                            }
                                            if (eventToModify.getDesc() != null) {
                                                eventDesc.setText(eventToModify.getDesc());
                                            }
                                            currUUID = eventSelector.get(s);
                                            mainPanel.removeAll();
                                            mainPanel.add(createEvent);
                                            mainPanel.revalidate();
                                            mainPanel.repaint();
                                        }
                                    });

                                    /***
                                     * listener delete
                                     */
                                    delete.addActionListener(new ActionListener() {
                                        @SneakyThrows
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            currUUID = eventSelector.get(s);
                                            eventManager.deleteEventById(currUUID);
                                            calendarSetup();
                                            checkUserBox(currCal, eventManager, standardBorder);
                                            initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
                                            mainPanel.removeAll();
                                            mainPanel.add(calendarPanel);
                                            mainPanel.repaint();
                                            mainPanel.revalidate();
                                        }
                                    });
                                }
                                b = true;
                            }
                        }
                    });
                }
                //mando avanti il calendario per la scrittura
                calendar.add(Calendar.DATE, 1);
            }
        }
    }

    /**
     * inizializza la schermata di login al calendario
     */
    @SneakyThrows
    public void initLoginCalendar(User u, PartecipaDAO partecipaManager, Border standardBorder){
        //makeHighlighted_HandCursor(creaCalendario);
        currentUser.setText(u.getUsername());
        //setPlaceHolder(tbCodice, "Inserire codice calendario");
        DefaultListModel model = new DefaultListModel();
        List<base.Calendar.Calendar> calendarList;
        calendarList = partecipaManager.selectAllCalendarNameForSpecificUser(u.getUsername());
        for(base.Calendar.Calendar c : calendarList){
            doUserHasSavedAccount.setText("I tuoi calendari");
            doUserHasSavedAccount.setFont(new Font("SansSerif", Font.PLAIN, 20));
            model.addElement(c.getNome() + " (" + c.getIdCalendar() + ")");

        }
        oldCalendar.addListSelectionListener(new ListSelectionListener() {
            @SneakyThrows
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!first) {
                    String s = (String) ((JList) e.getSource()).getSelectedValue();
                    if(s != null){
                        String res = s.substring(s.indexOf("(")+1,s.indexOf(")"));
                        int i = Integer.valueOf(res);
                        System.out.println(i);
                        first = true;
                        CalendarDB calendarManager = new CalendarDB();
                        currCal = calendarManager.selectCalendarByID(i);
                        System.out.println("Accesso al calendario");
                        //costruisco il calendario
                        calendarSetup();
                        //setto il calendario
                        EventDB eventManager = new EventDB();
                        initCalendarPanel(currUser, eventManager, currCal, year, month, standardBorder);
                        checkUserBox(currCal, eventManager, standardBorder);
                        mainPanel.removeAll();
                        mainPanel.add(calendarPanel);
                        mainPanel.repaint();
                        mainPanel.revalidate();
                        ((JList) e.getSource()).clearSelection();
                        tbCodice.setText("");
                        tbCalendarPassword.setText("");
                    }
                }
                else {
                    first = false;
                }
            }
        });
        oldCalendar.setModel(model);
    }

    /**
     * crea il jdatePicker
     */
    public void initCreateEvent(int year, int month, int day){
        UtilDateModel model = new UtilDateModel();
        model.setDate(year, month, day);
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
        datePicker.getModel().setDate(year, month, day);
        datePicker.getModel().setSelected(true);
        DatePickerPanel.add(datePicker);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    /**
     * setto le variabili temporali
     */
    public void calendarSetup(){
        //preparo il calendar
        //calendar = Calendar.getInstance();
        //prendo la data attuale
        LocalDate date = LocalDate.now();
        year = date.getYear();
        month = date.getMonthValue();
    }

    /**
     *
     * @param email email candidata
     * @return true - false
     */
    public static boolean isValidMail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public String filterEventByUser(){
        String query = "";
        for(Component c : leftCalendarBlock.getComponents()){
            JCheckBox checkBox = (JCheckBox) c;
            if(checkBox.isSelected()){
                String user = String.format("'%s',", checkBox.getText());
                query += user;
            }
        }
        if(query != ""){
            return query.substring(0, query.length() - 1);
        }
        return query;
    }
}
//todo login con il tasto INVIO, occhio barrato per le password