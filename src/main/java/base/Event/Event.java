package base.Event;

import base.User.User;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Event {

    @NonNull int idEvent;
    @NonNull int idcalendar;
    @NonNull String nome;
    @NonNull String date;
    @NonNull String u;
    String type;
    String desc;

}
