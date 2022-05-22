package base.User;
import lombok.*;
import javax.annotation.processing.Generated;
import java.util.Objects;

@Data
@AllArgsConstructor
public class User {

    String username;
    String password;
    String nome;
    String cognome;
    String mail;
}
