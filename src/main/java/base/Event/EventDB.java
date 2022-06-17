package base.Event;

import base.Calendar.Calendar;
import base.User.User;
import res.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDB implements EventDAO{

    Statement statement;

    public void MySQLConnection() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_MySQL,
                DBManager.JDBC_URL_MySQL);
        statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    public EventDB() throws SQLException {
        MySQLConnection();
    }

    @Override
    public List<Event> selectAllEventOfCalendar(Calendar calendar) throws SQLException {
        String query = String.format("SELECT * FROM event WHERE idcalendar = %d", calendar.getIdCalendar());
        ResultSet rs = statement.executeQuery(query);
        return rsToEventList(rs);
    }

    @Override
    public void insertEvent(int idEvent, Calendar cal, String nome, Date date, User u, String type, String desc) {

    }

    @Override
    public void insertEventWithType(int idEvent, Calendar cal, String nome, Date date, User u, String type) {

    }

    @Override
    public void insertEventWithDesc(int idEvent, Calendar cal, String nome, Date date, User u, String desc) {

    }

    @Override
    public void insertEvent(int idEvent, Calendar cal, String nome, Date date, User u) {

    }

    @Override
    public void deleteEventById(int idEvent) {

    }

    public List<Event> rsToEventList(ResultSet rs) throws SQLException {
        List<Event> eventList = new ArrayList<Event>();
        while (rs.next()) {
            Event e = new Event(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
            eventList.add(e);
        }
        return eventList;
    }
}
