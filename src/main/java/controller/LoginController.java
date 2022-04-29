package controller;

import base.User;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    public LoginController(){

    }

    public boolean TryLogin(String user, char[] pass){
        if (!user.isEmpty() && (pass.length > 0)){
            //TODO: controllare se l'utente corrisponde ad una password nel db
            return true;
        }
        return false;
    }

}
