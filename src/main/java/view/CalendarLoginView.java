package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarLoginView extends JFrame{
    private JPanel mainPanel;
    private JTextField tbCalendarName;
    private JPasswordField tbCalendarCode;
    private JButton btnAccedi;

    public CalendarLoginView(){
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);


        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}