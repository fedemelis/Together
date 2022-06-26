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

    Event selectEventByUUDI(String UUID) throws SQLException;

    List<Event> selectAllEventOfSpecifiedMonth(Calendar calendar, int month) throws SQLException;

    void insertEvent(Calendar cal, String nome, String date, User u, String type, String desc) throws SQLException;

    void insertEventWithType(Calendar cal, String nome, String date, User u, String type) throws SQLException;

    void insertEventWithDesc(Calendar cal, String nome, String date, User u, String desc) throws SQLException;

    void insertEvent(Calendar cal, String nome, String date, User u) throws SQLException;

    void updateEvent(String nome, String date, User u, String type, String desc, String UUID) throws SQLException;

    void updateEventWithType(String nome, String date, User u, String type, String UUID) throws SQLException;

    void updateEventWithDesc(String nome, String date, User u, String desc, String UUID) throws SQLException;

    void updateEvent(String nome, String date, User u, String UUID) throws SQLException;

    void deleteEventById(String UUID) throws SQLException;

    List<String> selectUserameOfUsersFromEventAdded(Calendar cal) throws SQLException;

}
