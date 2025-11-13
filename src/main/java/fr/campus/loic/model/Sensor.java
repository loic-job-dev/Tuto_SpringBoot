package fr.campus.loic.model;

import java.util.Random;

public class Sensor {

    private final int ID;
    private String name;

    public Sensor(String name){
        Random RANDOM = new Random();
        this.ID = RANDOM.nextInt(10000);
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
