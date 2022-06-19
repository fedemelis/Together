package base.User;

import base.User.User;
import base.User.UserDAO;
import res.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDB implements UserDAO {

    Statement statement;

    public void MySQLConnection() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_MySQL,
                DBManager.JDBC_URL_MySQL);
        statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    public UserDB()  throws SQLException {
        MySQLConnection();
    }

    @Override
    public User selectUserByUsername(String username) throws SQLException{
        String query = String.format("SELECT * FROM user WHERE username = '%s'", username);
        ResultSet rs = statement.executeQuery(query);
        return rsToUser(rs);
    }

    @Override
    public List<User> selectAllUser() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM user");
        return rsToUserList(rs);
    }

    @Override
    public void updateUsernameByUsername(String oldUsername, String newUsername) {

    }

    @Override
    public void updatePasswordByUsername(String username, String newPassword) {

    }

    @Override
    public void deleteUserByUsername(String username) {

    }

    @Override
    public void insertUser(String username, String password, String nome, String cognome, String mail) throws SQLException {
        String query = String.format("INSERT INTO user (username, password, nome, cognome, mail) VALUES('%s', '%s', '%s', '%s', '%s')",
               username, password, nome, cognome, mail);
        statement.executeUpdate(query);
    }

    public User rsToUser(ResultSet rs) throws SQLException {
        if (rs.next()){
            User u = new User(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            return u;
        }
        return null;
    }

    public List<User> rsToUserList(ResultSet rs) throws SQLException {
        List<User> userList = new ArrayList<User>();
        while (rs.next()) {
            User u = new User(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            userList.add(u);
        }
        return userList;
    }
}
