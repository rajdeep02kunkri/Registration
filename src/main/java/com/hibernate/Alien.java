package com.hibernate;

public class Alien {
    private String name;
    private int id;
    private String color;
    public Alien(int id, String name, String color)
    {
        this.id=id;
        this.name=name;
        this.color=color;
    }
    public String toString()
    {
        return "(id: "+id+" name: "+name+" color: "+color;
    }
}
