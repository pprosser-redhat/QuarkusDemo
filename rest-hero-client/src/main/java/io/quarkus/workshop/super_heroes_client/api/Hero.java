package io.quarkus.workshop.super_heroes_client.api;

public class Hero {

    public long id;
    public String name;
    public String otherName;
    public int level;
    public String picture;
    public String powers;
    
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getOtherName() {
        return otherName;
    }


    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }


    public int getLevel() {
        return level;
    }


    public void setLevel(int level) {
        this.level = level;
    }


    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getPowers() {
        return powers;
    }


    public void setPowers(String powers) {
        this.powers = powers;
    }

    @Override
    public String toString() {
        return "Hero{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", otherName='" + otherName + '\'' +
            ", level=" + level +
            ", picture='" + picture + '\'' +
            ", powers='" + powers + '\'' +
            '}';
    }
    
}

