package main;

import java.io.Serializable;
import java.util.UUID;

abstract class Person implements Serializable {
    private final String id = UUID.randomUUID().toString();

    public String id() {
        return this.id;
    }

    public String personalInfo() {
        return this.id;
    }

    public void info() {
        System.out.println("\nNumer ID: " + this.id);
    }
}
