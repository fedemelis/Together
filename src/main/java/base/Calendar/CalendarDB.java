package base.Calendar;

import base.User.User;
import res.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CalendarDB implements CalendarDAO{

    Statement statement;

    public void MySQLConnection() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_MySQL,
                DBManager.JDBC_URL_MySQL);
        statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    public CalendarDB() throws SQLException {
        MySQLConnection();
    }

    @Override
    public void insertCalendar(int idCalendar, String nome, String pass, String desc) throws SQLException {
        String query = String.format("INSERT INTO calendar (idCalendar, nome, pass, desc) VALUES(%d, %s, '%s', '%s')",
                idCalendar, nome, pass, desc);
        statement.executeUpdate(query);
    }

    @Override
    public void insertCalendar(int idCalendar, String nome, String pass) throws SQLException {
        String query = String.format("INSERT INTO calendar (idCalendar, nome, pass, desc) VALUES(%d, %s, '%s', NULL)",
                idCalendar, nome, pass);
        statement.executeUpdate(query);
    }

    @Override
    public Calendar selectCalendarByID(int idCalendar) throws SQLException {
        String query = String.format("SELECT * FROM calendar WHERE idCalendar = %d", idCalendar);
        ResultSet rs = statement.executeQuery(query);
        return rsToCalendar(rs);
    }

    public Calendar rsToCalendar(ResultSet rs) throws SQLException {
        if (rs.next()){
            Calendar c = new Calendar(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            return c;
        }
        return null;

    }
}
