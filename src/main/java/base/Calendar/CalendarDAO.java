package base.Calendar;

import java.sql.SQLException;

public interface CalendarDAO {

    void insertCalendar(int idCalendar, String nome, String pass, String desc) throws SQLException;

    void insertCalendar(int idCalendar, String nome, String pass) throws SQLException;

    Calendar selectCalendarByID(int idCalendar) throws SQLException;


}
