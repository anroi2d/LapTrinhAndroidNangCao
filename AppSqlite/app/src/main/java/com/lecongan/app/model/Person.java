package com.lecongan.app.model;

/**
 * Created by Admin on 17/03/2018.
 */

public class Person {
    int id;
    String name;
    String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person(String name, String message) {

        this.name = name;
        this.message = message;
    }

    public Person(int id, String name, String message) {

        this.id = id;
        this.name = name;
        this.message = message;
    }
}
