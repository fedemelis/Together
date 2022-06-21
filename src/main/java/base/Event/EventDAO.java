package base.Event;

import base.Calendar.Calendar;
import base.User.User;
import lombok.NonNull;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface EventDAO {

    //return all event by calendar
    List<Event> selectAllEventOfCalendar(Calendar calendar) throws SQLException;

    List<Event> selectAllEventOfSpecifiedMonth(Calendar calendar, int month) throws SQLException;

    void insertEvent(Calendar cal, String nome, String date, User u, String type, String desc) throws SQLException;

    void insertEventWithType(Calendar cal, String nome, String date, User u, String type) throws SQLException;

    void insertEventWithDesc(Calendar cal, String nome, String date, User u, String desc) throws SQLException;

    void insertEvent(Calendar cal, String nome, String date, User u) throws SQLException;

    void deleteEventById(byte[] idEvent) throws SQLException;

}
