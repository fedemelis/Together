package base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Evento {
    //TODO: il primo attributo di ogni evento dovrebbe essere un numero generato autonomamente dal dbms
    @NonNull String nome;
    @NonNull String creator;
    @NonNull String category;
    String desc;
    @NonNull Date date;
}
