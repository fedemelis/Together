package base;

import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Eventi {
    @NonNull String nome;
    @NonNull String creator;
    @NonNull String category;
    String desc;
    @NonNull Date date;

}
