package com.medium.audhil.springbootrestrepositorydemo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animal {
    @Id
    @GeneratedValue
    private int id;
    private int legNos;
    private String name;
    private String type;    //  domestic or wild
    private boolean isHornAvailable;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", legNos=" + legNos +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isHornAvailable=" + isHornAvailable +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLegNos() {
        return legNos;
    }

    public void setLegNos(int legNos) {
        this.legNos = legNos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHornAvailable() {
        return isHornAvailable;
    }

    public void setHornAvailable(boolean hornAvailable) {
        isHornAvailable = hornAvailable;
    }
}
