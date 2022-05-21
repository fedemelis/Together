package base.User;

import java.sql.SQLException;

interface UserDAO<User> {

    //return user by username
    User selectUserByUsername(String username);

    //change username by username
    void updateUsernameByUsername(String oldUsername, String newUsername);

    //change password by username
    void updatePasswordByUsername(String username, String newPassword);

    //delete user by username
    void deleteUserByUsername(String username);

    //insert new user
    void insertUser(String query) throws SQLException;



}
