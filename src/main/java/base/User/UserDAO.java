package base.User;

import java.sql.ResultSet;
import java.sql.SQLException;

interface UserDAO {

    //return user by username
    User selectUserByUsername(String username) throws SQLException;

    //return all user
    ResultSet selectAllUser() throws SQLException;

    //change username by username
    void updateUsernameByUsername(String oldUsername, String newUsername);

    //change password by username
    void updatePasswordByUsername(String username, String newPassword);

    //delete user by username
    void deleteUserByUsername(String username);

    //insert new user
    void insertUser(String username, char[] password, String nome, String cognome, String mail) throws SQLException;



}
