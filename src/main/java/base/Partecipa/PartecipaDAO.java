package base.Partecipa;

import base.Calendar.Calendar;
import base.Calendar.CalendarDAO;

import java.sql.SQLException;
import java.util.List;

public interface PartecipaDAO {

    List<Partecipa> selectAllCalendarOfSpecificUser(String user) throws SQLException;

    List<Calendar> selectAllCalendarNameForSpecificUser(String user) throws SQLException;

    Partecipa selectSpecificCalendarOfSpecificUser(int idCalendar, String user) throws SQLException;

    void insertNewCalendarForSpecificUser(int idCalendar, String user) throws SQLException;

}
