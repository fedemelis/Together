package base.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Calendar {

    @NonNull int idCalendar;
    @NonNull String nome;
    @NonNull String pass;
    String desc;

}
