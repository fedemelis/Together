package base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Getter
@Setter
public class Meeting extends Evento{

    @Getter @Setter @NonNull String link;

    public Meeting(@NonNull String nome, @NonNull String creator, @NonNull String category, String desc, @NonNull Date date, @NonNull String link) {
        super(nome, creator, category, desc, date);
        this.link = link;
    }

    public Meeting(@NonNull String nome, @NonNull String creator, @NonNull String category, @NonNull Date date, @NonNull String link) {
        super(nome, creator, category, date);
        this.link = link;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "nome='" + nome + '\'' +
                ", creator='" + creator + '\'' +
                ", category='" + category + '\'' +
                ", desc='" + desc + '\'' +
                ", date=" + date +
                ", link='" + link + '\'' +
                '}';
    }
}
