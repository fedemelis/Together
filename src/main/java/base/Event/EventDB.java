package base.Event;

import base.Calendar.Calendar;
import base.User.User;
import res.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HexFormat;
import java.util.List;

public class EventDB implements EventDAO{

    Statement statement;

    public void MySQLConnection() throws SQLException {
        statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    public EventDB() throws SQLException {
        MySQLConnection();
    }

    @Override
    public List<Event> selectAllEventOfCalendar(Calendar calendar) throws SQLException {
        String query = String.format("SELECT (idevent), idCalendar, nome, data, iduser, type, event.desc FROM event WHERE idCalendar = %d", calendar.getIdCalendar());
        ResultSet rs = statement.executeQuery(query);
        return rsToEventList(rs);
    }

    @Override
    public Event selectEventByUUDI(String UUID) throws SQLException{
        String query = String.format("SELECT idevent, idCalendar, nome, data, iduser, type, event.desc FROM event WHERE idevent = UUID_TO_BIN('%s')", UUID);
        ResultSet rs = statement.executeQuery(query);
        return rsToEvent(rs);
    }

    @Override
    public List<Event> selectAllEventOfSpecifiedMonth(Calendar calendar, int month) throws SQLException {
        String query = String.format("SELECT (idevent), idCalendar, nome, data, iduser, type, event.desc FROM event WHERE idCalendar = %d and month(data) = %d", calendar.getIdCalendar(), month);
        ResultSet rs = statement.executeQuery(query);
        return rsToEventList(rs);
    }

    @Override
    public void insertEvent(Calendar cal, String nome, String date, User u, String type, String desc)  throws SQLException{
        String query = String.format("INSERT INTO event VALUES (UUID_TO_BIN(UUID()), %d, '%s', '%s', '%s', '%s', '%s')",
                cal.getIdCalendar(), nome, date, u.getUsername(), type, desc);
        statement.executeUpdate(query);
    }

    @Override
    public void insertEventWithType(Calendar cal, String nome, String date, User u, String type) throws SQLException{
        String query = String.format("INSERT INTO event (idevent, idCalendar, nome, data, iduser, type, event.desc) VALUES(UUID_TO_BIN(UUID()), %d, '%s', '%s', '%s', '%s', NULL)",
                cal.getIdCalendar(), nome, date, u.getUsername(), type);
        statement.executeUpdate(query);
    }

    @Override
    public void insertEventWithDesc(Calendar cal, String nome, String date, User u, String desc) throws SQLException{
        String query = String.format("INSERT INTO event (idevent, idCalendar, nome, data, iduser, type, event.desc) VALUES(UUID_TO_BIN(UUID()), %d, '%s', '%s', '%s', NULL, '%s')",
                cal.getIdCalendar(), nome, date, u.getUsername(), desc);
        statement.executeUpdate(query);
    }

    @Override
    public void insertEvent(Calendar cal, String nome, String date, User u) throws SQLException {
        String query = String.format("INSERT INTO event (idevent, idCalendar, nome, data, iduser, type, event.desc) VALUES(UUID_TO_BIN(UUID()), %d, '%s', '%s', '%s', NULL, NULL)",
                cal.getIdCalendar(), nome, date, u.getUsername());
        statement.executeUpdate(query);
    }

    @Override
    public void updateEvent(String nome, String date, User u, String type, String desc, String UUID) throws SQLException {
        String query = String.format("UPDATE event SET nome = '%s', data = '%s', iduser = '%s', type = '%s', event.desc = '%s' WHERE idevent = UUID_TO_BIN('%s')",
                nome, date, u.getUsername(), type, desc, UUID);
        //System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void updateEventWithType(String nome, String date, User u, String type, String UUID) throws SQLException {
        String query = String.format("UPDATE event SET nome = '%s', data = '%s', iduser = '%s', type = '%s' WHERE idevent = UUID_TO_BIN('%s')",
                nome, date, u.getUsername(), type, UUID);
        statement.executeUpdate(query);
    }

    @Override
    public void updateEventWithDesc(String nome, String date, User u, String desc, String UUID) throws SQLException {
        String query = String.format("UPDATE event SET nome = '%s', data = '%s', iduser = '%s', event.desc = '%s' WHERE idevent = UUID_TO_BIN('%s')",
                nome, date, u.getUsername(), desc, UUID);
        statement.executeUpdate(query);
    }

    @Override
    public void updateEvent(String nome, String date, User u, String UUID) throws SQLException {
        String query = String.format("UPDATE event SET nome = '%s', data = '%s', iduser = '%s' WHERE idevent = UUID_TO_BIN('%s')",
                nome, date, u.getUsername(), UUID);
        statement.executeUpdate(query);
    }

    @Override
    public void deleteEventById(String UUID) throws SQLException {
        String query = String.format("DELETE FROM event WHERE idevent = UUID_TO_BIN('%s')",
                UUID);
        statement.executeUpdate(query);
    }

    @Override
    public List<String> selectUserameOfUsersFromEventAdded(Calendar cal) throws SQLException {
        String query = String.format("select distinct iduser from event where idcalendar = %d", cal.getIdCalendar());
        ResultSet rs = statement.executeQuery(query);
        return rsToStringList(rs);
    }

    @Override
    public List<Event> selectEventFiltered(String gruop, Calendar cal) throws SQLException {
        String query = String.format("select * from event where idcalendar = %d and iduser in (%s)", cal.getIdCalendar(), gruop);
        ResultSet rs = statement.executeQuery(query);
        return rsToEventList(rs);
    }

    public List<Event> rsToEventList(ResultSet rs) throws SQLException {
        List<Event> eventList = new ArrayList<Event>();
        HexFormat hex = HexFormat.of().withLowerCase();
        while (rs.next()) {
            Event e = new Event(
                    hex.formatHex(rs.getBytes(1)),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
            eventList.add(e);
        }
        return eventList;
    }

    public List<String> rsToStringList(ResultSet rs) throws SQLException {
        List<String> stringList = new ArrayList<String>();
        while (rs.next()) {
            String s = new String(
                    rs.getString(1));
            stringList.add(s);
        }
        return stringList;
    }

    public Event rsToEvent(ResultSet rs) throws SQLException {
        HexFormat hex = HexFormat.of().withLowerCase();
        if (rs.next()){
            Event e = new Event(
                    hex.formatHex(rs.getBytes(1)),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
            return e;
        }
        return null;
    }
}
