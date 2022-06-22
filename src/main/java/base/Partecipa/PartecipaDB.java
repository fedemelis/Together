package base.Partecipa;

import base.Calendar.Calendar;
import base.Event.Event;
import base.User.User;
import res.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PartecipaDB implements  PartecipaDAO{

    Statement statement;

    public void MySQLConnection() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_MySQL,
                DBManager.JDBC_URL_MySQL);
        statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    public PartecipaDB() throws SQLException {
        MySQLConnection();
    }

    @Override
    public List<Partecipa> selectAllCalendarOfSpecificUser(String user) throws SQLException {
        String query = String.format("SELECT * FROM partecipa WHERE idutente = '%s'", user);
        ResultSet rs = statement.executeQuery(query);
        return rsToPartecipaList(rs);
    }

    @Override
    public List<Calendar> selectAllCalendarNameForSpecificUser(String user) throws SQLException {
        String query = String.format("SELECT calendar.* FROM partecipa JOIN calendar on (partecipa.idcalendar = calendar.idcalendar) WHERE idutente = '%s'", user);
        ResultSet rs = statement.executeQuery(query);
        return rsToCalendarList(rs);
    }

    @Override
    public Partecipa selectSpecificCalendarOfSpecificUser(int idCalendar, String user) throws SQLException {
        String query = String.format("SELECT * FROM partecipa WHERE idutente = '%s' and idcalendar = %d", user, idCalendar);
        ResultSet rs = statement.executeQuery(query);
        return rsToPartecipa(rs);
    }

    @Override
    public void insertNewCalendarForSpecificUser(int idCalendar, String user) throws SQLException {
        String query = String.format("INSERT INTO user VALUES ('%s', %d)", user, idCalendar);
        statement.executeUpdate(query);
    }

    public List<Partecipa> rsToPartecipaList(ResultSet rs) throws SQLException {
        List<Partecipa> partecipaList = new ArrayList<Partecipa>();
        while (rs.next()) {
            Partecipa p = new Partecipa(
                    rs.getInt(2),
                    rs.getString(1));
            partecipaList.add(p);
        }
        return partecipaList;
    }

    public Partecipa rsToPartecipa(ResultSet rs) throws SQLException {
        if (rs.next()){
            Partecipa p = new Partecipa(
                    rs.getInt(2),
                    rs.getString(1));
            return p;
        }
        return null;
    }

    public List<Calendar> rsToCalendarList(ResultSet rs) throws SQLException {
        List<Calendar> calendarList = new ArrayList<Calendar>();
        while (rs.next()) {
            Calendar c = new Calendar(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            calendarList.add(c);
        }
        return calendarList;
    }
}
