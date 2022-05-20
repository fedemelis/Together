package base;
import lombok.*;
import javax.annotation.processing.Generated;
import java.util.Objects;

@Data
@AllArgsConstructor
public class User {

    String username;
    @ToString.Exclude String password;
}
