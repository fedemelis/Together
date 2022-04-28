package model;

public class LoginViewModel {
    public LoginViewModel(){

    }

    public boolean LoginControl(String user, char[] pass){
        if (!user.isEmpty() && (pass.length > 0)){
            //TODO: controllare se l'utente corrisponde ad una password nel db
            return true;
        }
        return false;
    }
}
