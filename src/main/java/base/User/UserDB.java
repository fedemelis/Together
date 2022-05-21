package base.User;

import base.User.User;
import base.User.UserDAO;
import res.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB implements UserDAO<User> {

    static Statement statement;

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
    public User selectUserByUsername(String username) {
        return null;
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
    public void insertUser(String query) throws SQLException{
        statement.executeUpdate(query);
    }


}
