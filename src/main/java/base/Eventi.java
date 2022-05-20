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
    /*public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/
}
