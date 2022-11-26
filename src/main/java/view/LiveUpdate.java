package view;

import base.Calendar.Calendar;
import base.Event.Event;
import base.Event.EventDAO;

import javax.swing.*;
import javax.swing.border.Border;
import java.sql.SQLException;
import java.util.List;

public class LiveUpdate{

    LoginView loginView;

    public LiveUpdate(LoginView loginView) {
        this.loginView = loginView;
    }

    void update(EventDAO eventManager, Border standardBorder) throws SQLException {
        if((loginView.mainPanel.getComponents())[0] == loginView.calendarPanel){
            List<Event> refreshedList =  eventManager.selectAllEventOfCalendar(loginView.currCal);
            if(!refreshedList.equals(loginView.globalEventList)){
                loginView.initCalendarPanel(loginView.currUser, eventManager,
                        loginView.currCal, loginView.year, loginView.month, standardBorder);
            }
        }
    }






}
