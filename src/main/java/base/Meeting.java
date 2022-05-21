package base;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Meeting{
    @NonNull String nome;
    @NonNull String creator;
    @NonNull String category;
    @NonNull String desc;
    Date date;
    @NonNull String link;

}
