package controller;

import base.User;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private List<User> userList;

    public LoginController(){
        //TODO: popolare la lista
        //TODO: selectAllUser
        userList = new ArrayList<User>();
        userList.add(new User("Federico", "pass"));
        userList.add(new User("Fede", "pass"));
        userList.add(new User("Luca", "pass"));
        userList.add(new User("Melis", "pass"));
        userList.add(new User("D'Amato", "pass"));
    }

    public String TryLogin(String user, char[] pass){
        if (!user.isEmpty() && (pass.length > 0)){
            User tmp = new User(user, String.valueOf(pass));
            if (userList.contains(tmp)){
                return "Successo";
            }
            return "Username o password errati";
        }
        return "Compila tutti i campi";
    }

}
