package quarkus.workshop.super_heroes;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Hero extends PanacheEntity {

    public String name;
    public String otherName;
    public int level;
    public String picture;

    public Hero() {
    }

    @Column(columnDefinition = "TEXT")
    public String powers;

    @Override
    public String toString() {
        return "Hero [name=" + name + ", otherName=" + otherName + ", level=" + level + ", picture=" + picture
                + ", powers=" + powers + "]";
    }

    public Hero(String name, String otherName, int level, String picture, String powers) {
        this.name = name;
        this.otherName = otherName;
        this.level = level;
        this.picture = picture;
        this.powers = powers;
    }

}
