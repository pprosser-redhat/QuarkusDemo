package io.quarkus.workshop.super_heroes;


import javax.persistence.Entity;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
public class Hero extends PanacheEntity {

    public Long id;
    public String name;
    public String otherName;
    public int level;
    public String picture;
    public String powers;

    @Override
    public String toString() {
        return "Hero [id=" + id + ", level=" + level + ", name=" + name + ", otherName=" + otherName + ", picture="
                + picture + ", powers=" + powers + "]";
    }

    
}


