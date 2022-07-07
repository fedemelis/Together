package base.User;
import base.Event.Event;
import base.Partecipa.Partecipa;
import lombok.*;
import javax.annotation.processing.Generated;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    String username;
    String password;
    String nome;
    String cognome;
    String mail;

    //for saving currentUser
    public User(String username){
        this.username = username;
    }
}
