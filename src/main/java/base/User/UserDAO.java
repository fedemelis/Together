package base.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    //return user by username
    User selectUserByUsername(String username) throws SQLException;

    //return all user
    List<User> selectAllUser() throws SQLException;

    //change username by username
    void updateUsernameByUsername(String oldUsername, String newUsername);

    //change password by username
    void updatePasswordByUsername(String username, String newPassword);

    void updateUserByUsername(User user) throws SQLException;

    //delete user by username
    void deleteUserByUsername(String username) throws SQLException;

    //insert new user
    void insertUser(String username, String password, String nome, String cognome, String mail) throws SQLException;



}
