package base.Partecipa;

import java.sql.SQLException;
import java.util.List;

public interface PartecipaDAO {

    List<Partecipa> selectAllCalendarOfSpecificUser(String user) throws SQLException;

    Partecipa selectSpecificCalendarOfSpecificUser(int idCalendar, String user) throws SQLException;

    void insertNewCalendarForSpecificUser(int idCalendar, String user) throws SQLException;

}
