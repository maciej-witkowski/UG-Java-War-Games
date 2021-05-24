package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attache extends Person implements Observer {
    private final String name;
    private final String surname;
    private final List<Person> people;
    private final List<String> log = new ArrayList<>();

    @Override
    public void update(Report report) {
        this.log.add(report.ready());
    }

    public Attache(String name, String surname, Person... people) {
        super();
        this.name = name;
        this.surname = surname;
        this.people = Arrays.asList(people);
    }

    public List<String> log() {
        return this.log;
    }

    public void reportLog() {
        for (String report: this.log) {
            System.out.println(report);
        }
    }

    public void info() {
        super.info();
        System.out.println("Imię i nazwisko: " + this.name + ' ' + this.surname);
    }
}
