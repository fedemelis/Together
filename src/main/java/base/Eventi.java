package base;

import java.util.Date;

public class Eventi {
    String nome;
    String creator;
    String category;
    String desc;
    Date date;

    public Eventi(String nome, String creator, String category, String desc, Date date) {
        this.nome = nome;
        this.creator = creator;
        this.category = category;
        this.desc = desc;
        this.date = date;
    }

    public String getNome() {
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
    }
}
